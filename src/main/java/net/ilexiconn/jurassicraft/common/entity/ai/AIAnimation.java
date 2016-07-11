package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class AIAnimation extends EntityAIBase {
    private IAnimatedEntity animatedEntity;

    public AIAnimation(IAnimatedEntity entity) {
        this.animatedEntity = entity;
        setMutexBits(7);
    }

    public abstract int getAnimationId();

    public <T extends EntityLiving> T getEntity() {
        return (T) this.animatedEntity;
    }

    public abstract boolean isAutomatic();

    public abstract int getDuration();

    public boolean shouldAnimate() {
        return false;
    }

    public boolean shouldExecute() {
        if (isAutomatic())
            return this.animatedEntity.getAnimationId() == getAnimationId();

        return shouldAnimate();
    }

    public void startExecuting() {
        if (!isAutomatic())
            AnimationHandler.sendAnimationPacket(this.animatedEntity, getAnimationId());

        this.animatedEntity.setAnimationTick(0);
    }

    public boolean continueExecuting() {
        return this.animatedEntity.getAnimationTick() < getDuration();
    }

    public void resetTask() {
        AnimationHandler.sendAnimationPacket(this.animatedEntity, 0);
    }
}
