package net.ilexiconn.jurassicraft.common.entity;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAICharge;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJurassiCraftCharges extends EntityJurassiCraftProtective {
    public boolean charging = false;
    public float distanceFromTarget;
    public int timeSinceCharge = 0;
    public int stepCount = 0;

    public EntityJurassiCraftCharges(World world) {
        super(world);

        this.tasks.addTask(2, new AnimationAICharge(this));
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (getAttackTarget() != null) {
            // Charge AI
            if (getAttackTarget() != null)
                distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
            else
                distanceFromTarget = -1;
            if (this.getAttackTarget() != null && onGround && timeSinceCharge == 0 && !this.isFleeing() && this.getCreatureAgeInDays() >= 17)
                AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.CHARGE.animID());
        } else {
            this.distanceFromTarget = -1.0F;
        }

        if (timeSinceCharge != 0)
            timeSinceCharge--;
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.stepCount <= 0 && this.charging) {
            this.playSound("jurassicraft:gallop", 3.0F, this.getSoundPitch() - 0.5F);
            this.stepCount = 10;
        }

        this.stepCount -= 1;
    }

    public void collideWithEntity(Entity victim) {
        super.collideWithEntity(victim);

        if (this.charging && (isTamed() || !getClass().equals(victim.getClass()))) {
            victim.attackEntityFrom(DamageSource.causeMobDamage(this), 20);
            double deltaX = victim.posX - posX;
            double deltaZ = victim.posZ - posZ;
            double angleYaw = (float) Math.atan2(deltaZ, deltaX);
            victim.motionX += Math.cos(angleYaw);
            victim.motionZ += Math.sin(angleYaw);
            victim.motionY += 0.3;
        }
    }

    public void ridingPlayerRightClick() {
        if (this.onGround && this.timeSinceCharge < 75 && this.getCreatureAgeInDays() >= 17 && ((EntityPlayer) this.riddenByEntity).getHeldItem() != null && this.getCreature().isRidingItem(((EntityPlayer) this.riddenByEntity).getHeldItem().getItem())) {
            this.decreaseHeldItemDurability(40);
            AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.CHARGE.animID());
        }
    }
}
