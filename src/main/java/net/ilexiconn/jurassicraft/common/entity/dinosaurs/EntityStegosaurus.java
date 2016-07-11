package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.api.IHerbivore;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftProtective;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityStegosaurus extends EntityJurassiCraftProtective implements IHerbivore {
    public ControlledAnimation tailWhipPosition = new ControlledAnimation(30);
    public ChainBuffer tailBuffer = new ChainBuffer(5);

    public EntityStegosaurus(World world) {
        super(world);

        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 200));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(1, new JurassiCraftAIWander(this, 45, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(3, new JurassiCraftAIDefensiveReaction(this, 8.0D, 30.0D, true, JurassiCraftAnimationIDs.TAIL_WHIP.animID(), false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(5, new JurassiCraftAISit(this));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(7, new JurassiCraftAIFollowFood(this, 50, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(7, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(8, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.tasks.addTask(11, new JurassiCraftAIHerdBehavior(this, 128, 2500, 24, this.getCreatureSpeed()));
        this.tasks.addTask(11, new HerdAIFollowHerd(this, false, getCreatureSpeed()));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.setCreatureExperiencePoints(4000);
    }

    public int getNumberOfAllies() {
        return 1;
    }

    public int getTalkInterval() {
        return 350;
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.isDefending() && this.creatureToAttack != null) {
            this.tailWhipPosition.increaseTimer();

            if (this.creatureToAttack != null && this.getAnimationId() != JurassiCraftAnimationIDs.TAIL_WHIP.animID()) {
                this.rotationYaw += (this.creatureToAttack.rotationYaw - this.rotationYaw) / 10.0F;
                this.renderYawOffset = this.rotationYaw + 3.14159265359F;
            }

            if (this.rand.nextInt(60) == 0) {
                this.creatureToAttack = this.getClosestEntityAggressive(this, 20, 8, 20);
                if (this.creatureToAttack != null)
                    this.setDefending(((EntityJurassiCraftAggressive) this.creatureToAttack).isCreatureOlderThan(0.5F));
            }
        } else {
            this.tailWhipPosition.decreaseTimer();

            if (this.rand.nextInt(35) == 0 && this.isCreatureOlderThan(0.5F)) {
                this.creatureToAttack = this.getClosestEntityAggressive(this, 20, 8, 20);

                if (this.creatureToAttack != null)
                    this.setDefending(((EntityJurassiCraftAggressive) this.creatureToAttack).isCreatureOlderThan(0.5F));
            }
        }

        this.tailBuffer.calculateChainSwingBuffer(45.0F, 5, 3.0F, this);
    }

    public boolean attackEntityAsMob(Entity entity) {
        if (this.rand.nextInt(3) == 0) {
            if (this.animID == 0)
                AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.TAIL_WHIP.animID());

            return true;
        } else {
            return super.attackEntityAsMob(entity);
        }
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
