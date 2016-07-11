package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAISwimming extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private float bBoxPercentage;
    private float creatureStepHeight;

    public JurassiCraftAISwimming(EntityJurassiCraftSmart entity, float bBoxPercentage) {
        this.creature = entity;
        this.bBoxPercentage = bBoxPercentage;
        this.creatureStepHeight = this.creature.stepHeight;
        entity.getNavigator().setCanSwim(true);
        this.setMutexBits(4);
    }

    public boolean shouldExecute() {
        return this.creature.isInWater() || this.creature.handleLavaMovement();
    }

    public void startExecuting() {
        this.creature.setSitting(false, null);
        this.creature.stepHeight = this.bBoxPercentage * this.creature.getYBouningBox();
    }

    public void updateTask() {
        if (!this.creature.worldObj.isAirBlock((int) (this.creature.posX + 0.5D), (int) (this.creature.posY + this.bBoxPercentage * this.creature.getYBouningBox()), (int) (this.creature.posZ + 0.5D)))
            this.creature.motionY = 0.06D;
    }

    public void resetTask() {
        this.creature.stepHeight = this.creatureStepHeight;
    }
}
