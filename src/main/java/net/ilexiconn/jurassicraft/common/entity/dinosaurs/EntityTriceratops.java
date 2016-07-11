package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.client.model.base.ControlledParam;
import net.ilexiconn.jurassicraft.common.api.IHerbivore;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCharges;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTriceratops extends EntityJurassiCraftCharges implements IHerbivore {
    public ControlledParam flailDegree = new ControlledParam(0.0F, 0.0F, 1.0F, 0.0F);
    public ControlledAnimation defendingPosition = new ControlledAnimation(40);
    public ChainBuffer tailBuffer = new ChainBuffer(5);

    public EntityTriceratops(World world) {
        super(world);

        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 200));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(1, new JurassiCraftAIWander(this, 45, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(2, new JurassiCraftAISit(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAIDefensiveReaction(this, 16.0D, 36.0D, true, JurassiCraftAnimationIDs.CHARGE.animID(), true));
        this.tasks.addTask(5, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 50, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(7, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.tasks.addTask(10, new JurassiCraftAIHerdBehavior(this, 96, 2000, 20, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(10, new HerdAIFollowHerd(this, false, getCreatureSpeed()));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.setCreatureExperiencePoints(3500);
    }

    public double getMountedYOffset() {
        if (this.getAnimationId() == JurassiCraftAnimationIDs.CHARGE.animID()) {
            if (this.getAnimationTick() < 5) {
                float animationProgress = (float) this.getAnimationTick() / 5.0F;
                return 0.91D * (double) this.getYBouningBox() - (0.3F * MathHelper.sin(animationProgress));
            } else if (this.getAnimationTick() < 18) {
                float animationProgress = (float) (this.getAnimationTick() - 5) / 13.0F;
                return 0.91D * (double) this.getYBouningBox() + (0.6F * MathHelper.sin(animationProgress));
            } else if (this.getAnimationTick() < 39) {
                float animationProgress = (float) (this.getAnimationTick() - 18) / 21.0F;
                return 0.91D * (double) this.getYBouningBox() - (0.5F * MathHelper.sin(animationProgress));
            }
        }

        return 0.91D * (double) this.getYBouningBox();
    }

    public int getNumberOfAllies() {
        return 1;
    }

    public int getTalkInterval() {
        return 350;
    }

    public void onUpdate() {
        super.onUpdate();
        this.flailDegree.update();

        if (this.animID == JurassiCraftAnimationIDs.CHARGE.animID() && this.animTick == 1)
            this.flailDegree.thereAndBack(0F, 0.1F, 1F, 5);

        if (this.isDefending()) {
            this.defendingPosition.increaseTimer();

            if (this.creatureToAttack != null)
                this.renderYawOffset = this.rotationYaw = this.creatureToAttack.rotationYaw + 3.14159265359F;
        } else {
            this.defendingPosition.decreaseTimer(2);

            if (this.rand.nextInt(40) == 0 && this.isCreatureOlderThan(0.6F)) {
                this.creatureToAttack = this.getClosestEntityAggressive(this, 20, 8, 20);

                if (this.creatureToAttack != null)
                    this.setDefending(((EntityJurassiCraftAggressive) this.creatureToAttack).isCreatureOlderThan(0.5F));
            }
        }

        this.tailBuffer.calculateChainSwingBuffer(40.0F, 5, 3.0F, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (4.0F * developmentFraction) + this.rand.nextInt(1 + (int) (4.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);

        if (this.rand.nextFloat() < 0.1F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));

        if (this.isMale() && this.rand.nextFloat() < 0.25F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    }
}
