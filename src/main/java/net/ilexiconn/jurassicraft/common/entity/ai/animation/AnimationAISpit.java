package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;

public class AnimationAISpit extends AIAnimation {
    private EntityJurassiCraftCreature entitySpitting;
    private EntityLivingBase entityTarget;
    private int duration;
    private int spitFrame;

    public AnimationAISpit(EntityJurassiCraftCreature dino, int duration, int spitFrame) {
        super(dino);
        setMutexBits(8);
        this.entitySpitting = dino;
        this.entityTarget = null;
        this.duration = duration;
        this.spitFrame = spitFrame;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.SPITTING.animID();
    }

    public boolean isAutomatic() {
        return true;
    }

    public int getDuration() {
        return this.duration;
    }

    public void startExecuting() {
        super.startExecuting();

        this.entityTarget = this.entitySpitting.getAttackTarget();
    }

    public void updateTask() {
        super.updateTask();

        if (this.entityTarget != null) {
            if (entitySpitting.getAnimationTick() <= spitFrame)
                entitySpitting.getLookHelper().setLookPositionWithEntity(entityTarget, 30F, 30F);

            if (entitySpitting.getAnimationTick() == spitFrame)
                ((IRangedAttackMob) entitySpitting).attackEntityWithRangedAttack(entityTarget, 0);
        }
    }

    public void resetTask() {
        super.resetTask();
    }
}
