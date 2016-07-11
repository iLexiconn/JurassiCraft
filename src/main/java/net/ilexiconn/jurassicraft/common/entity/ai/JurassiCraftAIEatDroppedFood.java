package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;

import java.util.List;

public class JurassiCraftAIEatDroppedFood extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private EntityItem droppedFood;
    private double timeTryingToEat;
    private double searchDistance;

    public JurassiCraftAIEatDroppedFood(EntityJurassiCraftSmart entity, double distance) {
        this.creature = entity;
        this.searchDistance = distance;
        this.timeTryingToEat = 0;
    }

    public boolean shouldExecute() {
        if (this.creature.getAttackTarget() != null || this.creature.isSitting() || this.creature.isTakingOff() || this.creature.isFlying() || this.creature.isFleeing() || this.creature.isAttacking() || this.creature.isDefending() || this.creature.isEating() || this.creature.isDrinking()) {
            return false;
        } else if (this.creature.getRNG().nextInt(25) == 0) {
            List nearEntityList = this.creature.worldObj.getEntitiesWithinAABBExcludingEntity(this.creature, this.creature.boundingBox.expand(this.searchDistance, this.searchDistance / 2.0D, this.searchDistance));

            if (!nearEntityList.isEmpty()) {
                for (int i = nearEntityList.size() - 1; i > -1; i--) {
                    Entity item = (Entity) nearEntityList.get(i);

                    if (item instanceof EntityItem) {
                        this.droppedFood = (EntityItem) item;
                        if (this.creature.getCreature().isFavoriteFood(this.droppedFood.getEntityItem().getItem())) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public void startExecuting() {
        this.creature.setDefending(false);
        this.creature.setAttacking(false);
        this.creature.setBreeding(false);
        this.creature.setPlaying(false);
        this.creature.setSocializing(false);
        this.creature.setEating(false);
        this.creature.setDrinking(false);
        this.creature.setSitting(false, null);
        this.creature.getNavigator().tryMoveToXYZ(droppedFood.posX, droppedFood.posY, droppedFood.posZ, this.creature.getCreatureSpeed());
        this.timeTryingToEat = 0;

        super.startExecuting();
    }

    public void updateTask() {
        double distance = Math.sqrt(Math.pow(this.creature.posX - this.droppedFood.posX, 2.0D) + Math.pow(this.creature.posY - this.droppedFood.posY, 2.0D) + Math.pow(this.creature.posZ - this.droppedFood.posZ, 2.0D));

        if (distance < 1.2D) {
            this.droppedFood.setDead();
            this.creature.setEating(true);
        } else {
            this.timeTryingToEat++;

            if (this.creature.getNavigator().noPath())
                this.creature.getNavigator().tryMoveToXYZ(this.droppedFood.posX, this.droppedFood.posY, this.droppedFood.posZ, this.creature.getCreatureSpeed());
        }
    }

    public boolean continueExecuting() {
        return this.timeTryingToEat < 125 && this.droppedFood.isEntityAlive() && this.creature.isEntityAlive() && !this.creature.isSitting() && this.creature.riddenByEntity == null && !this.creature.isAttacking() && !this.creature.isDefending();
    }

    public void resetTask() {
        this.creature.getNavigator().clearPathEntity();
        this.droppedFood = null;
        this.timeTryingToEat = 0;
    }
}
