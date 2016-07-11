package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.ArrayList;
import java.util.List;

public class JurassiCraftAIHerdBehavior extends EntityAIBase {
    private EntityJurassiCraftSmart lostCreature;
    private EntityJurassiCraftSmart herdCreature;
    private double lostCreatureOldFollowRange;
    private double searchDistance;
    private double distanceToHerd;
    private double maxDistanceToHerd;
    private double movementSpeed;
    private int timeTryingToMove;
    private int maxTimeTryingToMove;

    /**
     * @author RafaMv
     */
    public JurassiCraftAIHerdBehavior(EntityJurassiCraftSmart creature, double distance, int maxNumberOfTicksTrying, double distanceToConsiderHerd, double speed) {
        this.lostCreature = creature;
        this.searchDistance = distance;
        this.maxTimeTryingToMove = maxNumberOfTicksTrying;
        this.maxDistanceToHerd = distanceToConsiderHerd;
        this.movementSpeed = speed;
        this.timeTryingToMove = 0;
        this.setMutexBits(3);
    }

    public boolean isInterruptible() {
        return this.timeTryingToMove > this.maxTimeTryingToMove / 2.0D;
    }

    public boolean shouldExecute() {
        if (this.lostCreature.getAttackTarget() != null || this.lostCreature.getRNG().nextInt(100) < 99 || !this.lostCreature.isEntityAlive())
            return false;

        ArrayList<EntityJurassiCraftSmart> nearCreaturesList = new ArrayList<EntityJurassiCraftSmart>();
        List<Entity> nearEntityList = this.lostCreature.worldObj.getEntitiesWithinAABBExcludingEntity(this.lostCreature, this.lostCreature.boundingBox.expand(this.searchDistance, 8.0D, this.searchDistance));

        if (!nearEntityList.isEmpty()) {
            for (int i = nearEntityList.size() - 1; i > -1; i--) {
                if (nearEntityList.get(i) instanceof EntityJurassiCraftSmart && nearEntityList.get(i).getClass() == lostCreature.getClass() && nearEntityList.get(i).getUniqueID() != lostCreature.getUniqueID())
                    nearCreaturesList.add((EntityJurassiCraftSmart) nearEntityList.get(i));
            }

            if (nearCreaturesList.size() < 4) {
                double minDistance = this.searchDistance + 1;

                for (int j = 0; j < nearCreaturesList.size(); j++) {
                    double distance = nearCreaturesList.get(j).getDistanceToEntity(this.lostCreature);

                    if (distance < minDistance) {
                        minDistance = distance;
                        this.herdCreature = nearCreaturesList.get(j);
                    }
                }
            } else {
                ArrayList<Integer> nearCreatureAndNumberOfOtherNearCreatures = new ArrayList<Integer>();

                int neighbourCount = 0;

                for (int j = 0; j < nearCreaturesList.size(); j++) {
                    neighbourCount = 0;

                    for (int k = 0; k < nearCreaturesList.size(); k++) {
                        if (nearCreaturesList.get(j).getDistanceToEntity(nearCreaturesList.get(k)) < this.maxDistanceToHerd)
                            neighbourCount++;
                    }

                    nearCreatureAndNumberOfOtherNearCreatures.add(neighbourCount);
                }

                neighbourCount = 0;

                for (int i = 0; i < nearCreatureAndNumberOfOtherNearCreatures.size(); i++) {
                    if (nearCreatureAndNumberOfOtherNearCreatures.get(i) > neighbourCount) {
                        neighbourCount = nearCreatureAndNumberOfOtherNearCreatures.get(i);
                        this.herdCreature = nearCreaturesList.get(i);
                    }
                }
            }

            if (this.herdCreature != null && this.herdCreature.isEntityAlive() && this.lostCreature.isEntityAlive()) {
                this.distanceToHerd = this.lostCreature.getDistanceToEntity(herdCreature);
                return !this.lostCreature.isSitting() && this.distanceToHerd > this.maxDistanceToHerd;
            }
        }

        return false;
    }

    public void startExecuting() {
        this.lostCreatureOldFollowRange = this.lostCreature.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
        this.lostCreature.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.searchDistance);
        this.lostCreature.getNavigator().tryMoveToEntityLiving(this.herdCreature, this.movementSpeed);

        super.startExecuting();
    }

    public void updateTask() {
        if (this.timeTryingToMove == this.maxTimeTryingToMove / 2.0D || this.timeTryingToMove == this.maxTimeTryingToMove / 4.0D || this.timeTryingToMove == 3.0D * this.maxTimeTryingToMove / 4.0D) {
            this.lostCreature.getNavigator().tryMoveToEntityLiving(this.herdCreature, this.movementSpeed);
        }

        this.lostCreature.getDistanceSqToEntity(herdCreature);
        this.timeTryingToMove++;
    }

    public boolean continueExecuting() {
        return (!this.lostCreature.getNavigator().noPath() && this.timeTryingToMove < this.maxTimeTryingToMove && this.distanceToHerd > this.maxDistanceToHerd / 2.0D && this.lostCreature.isEntityAlive() && this.herdCreature.isEntityAlive());
    }

    public void resetTask() {
        this.lostCreature.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.lostCreatureOldFollowRange);
        this.lostCreature.getNavigator().clearPathEntity();
        this.herdCreature = null;
        this.timeTryingToMove = 0;
    }
}