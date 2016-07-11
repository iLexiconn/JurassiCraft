package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.entity.EntityLivingBase;

public class AnimationAIVelociraptorLeap extends AIAnimation {
    private EntityVelociraptor entityRaptor;
    private EntityLivingBase attackTarget;

    private double destX;
    private double destZ;
    private double targetSpeedX;
    private double targetSpeedZ;
    private double targetPrevPosX;
    private double targetPrevPosZ;

    public AnimationAIVelociraptorLeap(EntityVelociraptor raptor) {
        super(raptor);

        this.entityRaptor = raptor;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.LEAP.animID();
    }

    public boolean isAutomatic() {
        return true;
    }

    public int getDuration() {
        return 20;
    }

    public void startExecuting() {
        super.startExecuting();
        this.attackTarget = entityRaptor.getAttackTarget();
    }

    public void resetTask() {
        super.resetTask();
    }

    public void updateTask() {
        if (this.entityRaptor.getAnimationTick() < 10) {
            if (this.attackTarget != null)
                this.entityRaptor.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30F, 30F);
        }

        if (this.entityRaptor.getAnimationTick() == 9) {
            if (this.attackTarget != null) {
                this.targetPrevPosX = attackTarget.posX;
                this.targetPrevPosZ = attackTarget.posZ;
            }
        }

        if (entityRaptor.getAnimationTick() == 10) {
            if (this.attackTarget != null) {
                this.targetSpeedX = attackTarget.posX - targetPrevPosX;
                this.targetSpeedZ = attackTarget.posZ - targetPrevPosZ;

                double leapDuration = 6;

                this.destX = attackTarget.posX + targetSpeedX * leapDuration * 2;
                this.destZ = attackTarget.posZ + targetSpeedZ * leapDuration * 2;

                double d = Math.sqrt((destX - entityRaptor.posX) * (destX - entityRaptor.posX) + (destZ - entityRaptor.posZ) * (destZ - entityRaptor.posZ));
                double a = Math.atan2((destZ - entityRaptor.posZ), (destX - entityRaptor.posX));

                this.entityRaptor.motionX = (d / leapDuration) * Math.cos(a);
                this.entityRaptor.motionZ = (d / leapDuration) * Math.sin(a);
                this.entityRaptor.motionY = 0.6D;
                this.entityRaptor.timeSinceLeap = 150;

                entityRaptor.playSound("jurassicraft:velociraptorCall", 1.0F, 1.0F);
            }
        }
    }
}