package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.api.IHerbivore;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftProtective;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIGallimimusBeingEaten;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGallimimus extends EntityJurassiCraftProtective implements IHerbivore {
    public ControlledAnimation sittingProgress = new ControlledAnimation(40);
    public ChainBuffer tailBuffer = new ChainBuffer(4);
    public float swallowScale = 1;

    public EntityGallimimus(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 150));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 80, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAISitNatural(this, 900, 175, 375));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 30, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(4, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(4, new AnimationAIGallimimusBeingEaten(this));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 30, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftAIHerdBehavior(this, 128, 2500, 24, this.getCreatureSpeed()));
        this.tasks.addTask(7, new HerdAIFollowHerd(this, false, getCreatureSpeed()));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.setCreatureExperiencePoints(1000);
    }

    public void updateRiderPosition() {
        float creatureSizeParam = 0.25F * this.getCreatureLength();
        float extraX = creatureSizeParam * MathHelper.sin(3.14159265359F + 0.01745329251F * this.rotationYaw);
        float extraZ = creatureSizeParam * MathHelper.cos(0.01745329251F * this.rotationYaw);
        float extraY = 1.2F * this.getYBouningBox() + 0.16F * (this.limbSwingAmount - this.limbSwingAmount * MathHelper.sin(this.limbSwing));

        this.riddenByEntity.setPosition(this.posX - (double) extraX, this.posY + (double) extraY, this.posZ - (double) extraZ);
    }

    public int getNumberOfAllies() {
        return 2;
    }

    public int getTalkInterval() {
        return 350;
    }

    public void onUpdate() {
        super.onUpdate();

        /** Sitting Animation */
        if (this.worldObj.isRemote) {
            if (this.isSitting())
                this.sittingProgress.increaseTimer();
            else
                this.sittingProgress.decreaseTimer();
        }

        this.tailBuffer.calculateChainSwingBuffer(45.0F, 3, 3.8F, this);

        if (getAnimationId() == JurassiCraftAnimationIDs.BEING_EATEN.animID() && getAnimationTick() >= 35 && swallowScale > 0)
            swallowScale -= 0.1;
    }

    public boolean attackEntityAsMob(Entity entity) {
        if (this.ridingEntity instanceof EntityTyrannosaurus) {
            if (this.getAttackTarget() == this.ridingEntity)
                this.setAttackTarget(null);

            return false;
        } else {
            return super.attackEntityAsMob(entity);
        }
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (2.5F * developmentFraction) + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);
    }
}