package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIEating extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private boolean shouldAnimate;
    private int animationID;
    private int duration;
    private int timer;

    public JurassiCraftAIEating(EntityJurassiCraftSmart creature, int duration) {
        this(creature, duration, false, 0);
    }

    public JurassiCraftAIEating(EntityJurassiCraftSmart creature, int duration, boolean shouldAnimate, int animationID) {
        this.creature = creature;

        if (duration > 0)
            this.duration = duration;
        else
            this.duration = 10;

        this.shouldAnimate = shouldAnimate;
        this.animationID = animationID;
        this.timer = 0;
    }

    public boolean shouldExecute() {
        return this.creature.isEating();
    }

    public void startExecuting() {
        this.timer = this.duration;

        if (this.creature.isDrinking())
            this.creature.setDrinking(false);

        if (this.shouldAnimate && this.creature.getAnimationId() == 0)
            AnimationHandler.sendAnimationPacket(this.creature, this.animationID);
    }

    public void updateTask() {
        this.timer--;
    }

    public boolean continueExecuting() {
        return this.timer >= 0 && !this.creature.isSitting() && !this.creature.isSleeping() && !this.creature.hasBeenHurt() && this.creature.riddenByEntity == null;
    }

    public void resetTask() {
        this.creature.setEating(false);
        this.timer = 0;
    }
}
