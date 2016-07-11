package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCharges;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class AnimationAICharge extends AIAnimation {
    private EntityJurassiCraftCharges entityCharging;
    private EntityLivingBase attackTarget;
    private float chargeAcceleration;
    private float chargeSpeed;
    private float angleYaw;
    private float startX;
    private float startZ;
    private float distanceTravelled;
    private float distanceOfTargetFromStart;

    public AnimationAICharge(EntityJurassiCraftCharges charging) {
        super(charging);
        this.entityCharging = charging;
        this.attackTarget = null;
        this.chargeAcceleration = 0.2F;
        this.chargeSpeed = 1;
        this.angleYaw = 0.0F;
        this.startX = 0.0F;
        this.startZ = 0.0F;
        this.distanceTravelled = 0.0F;
        this.distanceOfTargetFromStart = 0.0F;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.CHARGE.animID();
    }

    public boolean isAutomatic() {
        return true;
    }

    public int getDuration() {
        return 100;
    }

    public void startExecuting() {
        super.startExecuting();

        this.attackTarget = this.entityCharging.getAttackTarget();
        this.startX = (float) this.entityCharging.posX;
        this.startZ = (float) this.entityCharging.posZ;

        if (this.attackTarget != null)
            this.distanceOfTargetFromStart = (float) Math.sqrt((this.startX - this.attackTarget.posX) * (this.startX - this.attackTarget.posX) + (this.startZ - this.attackTarget.posZ) * (this.startZ - this.attackTarget.posZ));
    }

    public void resetTask() {
        super.resetTask();

        this.entityCharging.timeSinceCharge = 150;
        this.entityCharging.charging = false;
        this.entityCharging.setAttackTarget(null);
    }

    public void updateTask() {
        if (this.attackTarget != null)
            this.entityCharging.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30F, 30F);

        this.distanceTravelled = (float) Math.sqrt((this.startX - this.entityCharging.posX) * (this.startX - this.entityCharging.posX) + (this.startZ - this.entityCharging.posZ) * (this.startZ - this.entityCharging.posZ));

        if (this.entityCharging.getAnimationTick() == 1)
            this.entityCharging.playSound("jurassicraft:TriceratopsCharge", 1.0F, 1.0F);

        if (this.entityCharging.getAnimationTick() >= 35 && this.entityCharging.getAnimationTick() <= 40 && this.attackTarget != null) {
            double deltaX = this.attackTarget.posX - this.entityCharging.posX;
            double deltaZ = this.attackTarget.posZ - this.entityCharging.posZ;
            this.angleYaw = (float) Math.atan2(deltaZ, deltaX);
        }

        if (this.entityCharging.getAnimationTick() > 40) {
            if (this.attackTarget != null || this.entityCharging.riddenByEntity != null) {
                if (this.entityCharging.riddenByEntity != null && this.entityCharging.riddenByEntity instanceof EntityPlayer) {
                    this.angleYaw = this.entityCharging.riddenByEntity.rotationYaw * 0.01745329251F + 1.57079632679F;
                    this.entityCharging.rotationYaw = this.entityCharging.riddenByEntity.rotationYaw;
                    this.chargeAcceleration = 0.3F;
                }

                this.entityCharging.charging = true;

                if (attackTarget != null && this.distanceOfTargetFromStart > distanceTravelled) {
                    double deltaX = this.attackTarget.posX - this.entityCharging.posX;
                    double deltaZ = this.attackTarget.posZ - this.entityCharging.posZ;
                    float destAngleYaw = (float) Math.atan2(deltaZ, deltaX);

                    if (angleYaw - destAngleYaw >= 0.1)
                        angleYaw -= 0.1;
                    else if (angleYaw - destAngleYaw <= -0.1)
                        angleYaw += 0.1;
                }

                if (Math.sqrt(this.entityCharging.motionX * this.entityCharging.motionX + this.entityCharging.motionZ * this.entityCharging.motionZ) < this.chargeSpeed - 0.2) {
                    this.entityCharging.motionX += this.chargeAcceleration * Math.cos(this.angleYaw);
                    this.entityCharging.motionZ += this.chargeAcceleration * Math.sin(this.angleYaw);
                } else {
                    this.entityCharging.motionX = this.chargeSpeed * Math.cos(this.angleYaw);
                    this.entityCharging.motionZ = this.chargeSpeed * Math.sin(this.angleYaw);
                }

                entityCharging.rotationYaw = (float) (angleYaw * (180 / Math.PI) - 90);
                entityCharging.renderYawOffset = (float) (angleYaw * (180 / Math.PI) - 90);
            }
        }
    }
}
