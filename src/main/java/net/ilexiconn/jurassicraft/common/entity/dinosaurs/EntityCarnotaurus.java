package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftGroupAggressive;
import net.ilexiconn.jurassicraft.common.entity.IntermittentAnimation;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIGroupAttack;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCarnotaurus extends EntityJurassiCraftGroupAggressive {
    public IntermittentAnimation restingHeadProgress = new IntermittentAnimation(30, 200, 100, 100);
    public ControlledAnimation sittingProgress = new ControlledAnimation(40);
    public ChainBuffer tailBuffer = new ChainBuffer(5);

    public EntityCarnotaurus(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIWander(this, 40, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAISitNatural(this, 800, 125, 400));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20, true, JurassiCraftAnimationIDs.BITE.animID()));
        this.tasks.addTask(7, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(7, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(9, new HerdAIFollowHerd(this, true, getCreatureSpeed()));
        this.tasks.addTask(9, new HerdAIGroupAttack(this));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaurus.class, 120, 0.7F, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaurus.class, 80, 0.6F, 0.7F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 70, 0.6F, 0.7F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 0, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHypsilophodon.class, 40, 0.55F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeaellynasaura.class, 40, 0.55F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 0, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 0, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 0, 0.9F));

        this.setCreatureExperiencePoints(4000);
    }

    public double getMountedYOffset() {
        return 0.95D * (double) (this.getYBouningBox() + 0.175F * (this.limbSwingAmount - this.limbSwingAmount * MathHelper.sin(0.55F * this.limbSwing)));
    }

    public void onUpdate() {
        super.onUpdate();

        /** Sitting Animation */
        if (this.worldObj.isRemote) {
            if (this.isSitting()) {
                this.sittingProgress.increaseTimer();
                this.restingHeadProgress.runAnimation();
            } else {
                this.sittingProgress.decreaseTimer();
                this.restingHeadProgress.stopAnimation();
            }
        }

        this.tailBuffer.calculateChainSwingBuffer(65.0F, 5, 4.0F, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int countMeat = Math.round(1 + (3.5F * developmentFraction) + this.rand.nextInt(1 + (int) (3.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), countMeat));
        else
            this.dropItem(this.getCreature().getSteak(), countMeat);

        if (this.rand.nextFloat() < 0.1F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
    }
}
