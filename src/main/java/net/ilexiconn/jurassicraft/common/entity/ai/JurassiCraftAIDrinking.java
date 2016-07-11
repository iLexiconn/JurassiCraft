package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIDrinking extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private int duration;
    private int timer;

    public JurassiCraftAIDrinking(EntityJurassiCraftSmart creature, int duration) {
        this.creature = creature;

        if (duration > 0)
            this.duration = duration;
        else
            this.duration = 10;

        this.timer = 0;
    }

    public boolean shouldExecute() {
        return this.creature.isDrinking();
    }

    public void startExecuting() {
        if (this.creature.isEating())
            this.creature.setEating(false);

        this.timer = this.duration;
    }

    public void updateTask() {
        this.timer--;
    }

    public boolean continueExecuting() {
        return this.timer >= 0 && !this.creature.isSitting() && !this.creature.isSleeping() && !this.creature.hasBeenHurt() && this.creature.riddenByEntity == null;
    }

    public void resetTask() {
        this.creature.setDrinking(false);
        this.timer = 0;
    }
}
