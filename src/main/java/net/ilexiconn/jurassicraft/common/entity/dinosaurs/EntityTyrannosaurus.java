package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.client.model.base.ControlledParam;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.common.entity.IntermittentAnimation;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIRoar;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAITyrannosaurusEatingGallimimus;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIWalkRoar;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIGroupAttack;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityLeptictidium;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityMoeritherium;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityJurassiCraftAggressive {
    public ControlledParam roarCount = new ControlledParam(0F, 0F, 0.5F, 0F);
    public ControlledParam roarTiltDegree = new ControlledParam(0F, 0F, 1F, 0F);
    public IntermittentAnimation restingHeadProgress = new IntermittentAnimation(30, 200, 100, 100);
    public ControlledAnimation sittingProgress = new ControlledAnimation(50);
    public ControlledAnimation shakePrey = new ControlledAnimation(10);
    public ChainBuffer tailBuffer = new ChainBuffer(6);
    private int stepCount = 0;

    public EntityTyrannosaurus(World world) {
        super(world);

        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(0, new AnimationAITyrannosaurusEatingGallimimus(this));
        this.tasks.addTask(2, new AnimationAIRoar(this, 75));
        this.tasks.addTask(8, new AnimationAIWalkRoar(this, 75));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.4F * this.getCreatureSpeed(), false));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, 40, this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAISitNatural(this, 800, 125, 400));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20, true, JurassiCraftAnimationIDs.BITE.animID()));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(7, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(7, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(7, new HerdAIFollowHerd(this, true, getCreatureSpeed()));
        this.tasks.addTask(7, new HerdAIGroupAttack(this));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaurus.class, 120, 0.7F, 0.7F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaurus.class, 80, 0.6F, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 70, 0.6F, 0.9F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityParasaurolophus.class, 40, 0.55F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 40, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHypsilophodon.class, 40, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeaellynasaura.class, 40, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityMoeritherium.class, 40, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 40, 0.3F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeptictidium.class, 40, 0.3F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHorse.class, 50, 0.25F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 30, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 30, 0.15F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 30, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 10, 0.1F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 40, 0.3F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySpinosaurus.class, 40, 0.7F));

        this.setCreatureExperiencePoints(5500);
    }

    public void updateRiderPosition() {
        super.updateRiderPosition();

        if (this.riddenByEntity != null) {
            if (this.riddenByEntity instanceof EntityGallimimus) {
                rotationYaw = renderYawOffset;
                EntityGallimimus gallimimus = (EntityGallimimus) this.riddenByEntity;

                gallimimus.rotationYawHead = this.riddenByEntity.rotationYaw;

                float shakeProgress = shakePrey.getAnimationProgressSinSqrt();
                float radius = 0.4F * this.getCreatureLength();
                float angle = (float) (0.01745329251F * this.renderYawOffset + (0.05 * this.getCreatureLength() * shakeProgress * Math.cos(frame * 0.6 + 1)));
                this.riddenByEntity.rotationYaw = (float) (angle * (180 / Math.PI) - 150.0F);

                gallimimus.renderYawOffset = (float) (angle * (180 / Math.PI) - 150.0F);
                double extraY = this.getCreatureHeight() * (0.425 - shakeProgress * 0.21);

                if (getAnimationTick() > 30) {
                    extraY += 0.38 * Math.sin((getAnimationTick() - 30) * 0.2) * getCreatureHeight();
                    radius -= 0.001 * (getAnimationTick() - 30) * (getAnimationTick() - 30) * this.getCreatureLength();
                }

                double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
                double extraZ = (double) (radius * MathHelper.cos(angle));
                this.riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
            } else {
                this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
            }
        }
    }

    public String getLivingSound() {
        int sound = rand.nextInt(4) + 1;

        if (sound == 1 && this.getCreatureAgeInDays() >= 25) {
            this.playSound("jurassicraft:tyrannosaurus01", 5.0F, this.getSoundPitch());

            if (animID == 0) {
                if (this.moveForward == 0) {
                    if (!this.isSitting())
                        AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.ROAR.animID());
                } else
                    AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.WALK_ROAR.animID());
            }

            return null;
        } else {
            return null;
        }
    }

    public void onUpdate() {
        super.onUpdate();

        this.roarCount.update();
        this.roarTiltDegree.update();

        /** Step Sound */
        if (this.moveForward > 0 && this.stepCount <= 0 && this.getCreatureAgeInDays() >= 25) {
            this.playSound("jurassicraft:footstep", 2.0F, this.getSoundPitch());
            stepCount = 65;
        }

        if (animID == JurassiCraftAnimationIDs.ROAR.animID() && animTick == 22)
            this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);

        if (animID == JurassiCraftAnimationIDs.WALK_ROAR.animID() && animTick == 22)
            this.roarTiltDegree.thereAndBack(0F, 0.1F, 1F, 20);

        this.stepCount -= this.moveForward * 9.5;

        if (this.frame % 62 == 28)
            this.playSound("jurassicraft:tyrannosaurusbreath", 1.0F, this.getSoundPitch());

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

        this.tailBuffer.calculateChainSwingBuffer(55.0F, 5, 3.0F, this);

        if (this.getAttackTarget() == this.riddenByEntity)
            setAttackTarget(null);

        if (getAnimationId() == JurassiCraftAnimationIDs.EATING.animID() && getAnimationTick() <= 20)
            shakePrey.increaseTimer();

        if (getAnimationId() == JurassiCraftAnimationIDs.EATING.animID() && getAnimationTick() > 20)
            shakePrey.decreaseTimer();
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int countMeat = Math.round(1 + (5.0F * developmentFraction) + this.rand.nextInt(1 + (int) (3.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));
        int countTeeth = Math.round(1.5F * developmentFraction + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)));

        if (!this.isBurning()) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), countMeat));
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getTooth(), countTeeth));
        } else {
            this.dropItem(this.getCreature().getSteak(), countMeat);
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getTooth(), countTeeth));
        }

        if (this.rand.nextFloat() < 0.1F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));

        if (this.isMale() && this.rand.nextFloat() < 0.25F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    }
}
