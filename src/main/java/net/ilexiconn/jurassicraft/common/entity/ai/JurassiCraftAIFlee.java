package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class JurassiCraftAIFlee extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private int fleeingTime;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    private double speed;

    public JurassiCraftAIFlee(EntityJurassiCraftSmart entity, int duration, double velocity) {
        this.creature = entity;
        this.speed = velocity;
        this.fleeingTime = duration;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.creature.isSleeping()) {
            return false;
        } else if (this.creature.isFleeing()) {
            Vec3 randomTarget = RandomPositionGenerator.findRandomTarget(this.creature, 5, 4);

            if (randomTarget == null) {
                return false;
            } else {
                this.randPosX = randomTarget.xCoord;
                this.randPosY = randomTarget.yCoord;
                this.randPosZ = randomTarget.zCoord;

                return true;
            }
        } else {
            return false;
        }
    }

    public void startExecuting() {
        this.creature.setPlaying(false);
        this.creature.setSocializing(false);
        this.creature.setEating(false);
        this.creature.setDrinking(false);
        this.creature.setDefending(false);
        this.creature.setAttacking(false);
        this.creature.setBreeding(false);
        this.creature.setInLove(false);
        this.creature.setSitting(false, null);
        this.creature.setFleeingTick(this.fleeingTime + (int) (this.fleeingTime * 0.6F * this.creature.getRNG().nextFloat()));
    }

    public void updateTask() {
        this.creature.setFleeingTick(this.creature.getFleeingTick() - 1);

        if (this.creature.getNavigator().noPath()) {
            Vec3 randomTarget = RandomPositionGenerator.findRandomTarget(this.creature, 5, 4);

            if (randomTarget != null) {
                this.randPosX = randomTarget.xCoord;
                this.randPosY = randomTarget.yCoord;
                this.randPosZ = randomTarget.zCoord;
                this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
            }
        }
    }

    public boolean continueExecuting() {
        return this.creature.getFleeingTick() > 0 && !this.creature.isSitting() && !this.creature.isSleeping() && this.creature.riddenByEntity == null;
    }

    public void resetTask() {
        this.creature.setFleeingTick(0);
        this.creature.setFleeing(false);

        if (this.creature.getAttackTarget() != null) {
            this.creature.setAttackTarget(null);
        }
    }
}
