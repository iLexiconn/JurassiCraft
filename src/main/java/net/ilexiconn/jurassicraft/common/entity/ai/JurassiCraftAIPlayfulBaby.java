package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCoward;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.ArrayList;

public class JurassiCraftAIPlayfulBaby extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private EntityJurassiCraftSmart otherCreature;
    private double minimumDistance;
    private double maximumDistance;
    private int chance;
    private float maxAge;

    public JurassiCraftAIPlayfulBaby(EntityJurassiCraftSmart creature, int chance, double minimumDistance, double maximumDistance, float maxAge) {
        this.creature = creature;
        this.chance = chance;
        this.minimumDistance = minimumDistance * minimumDistance;
        this.maximumDistance = maximumDistance * maximumDistance;
        this.maxAge = maxAge;
        this.otherCreature = null;
    }

    public boolean shouldExecute() {
        if (this.creature.getRNG().nextInt(this.chance) > 0 || this.creature.isCreatureOlderThan(this.maxAge) || this.creature.isPlaying() || this.creature.isSocializing() || this.creature.getAnimationId() != 0 || this.creature.isSitting() || this.creature.isSleeping() || this.creature.isFleeing() || this.creature.isEating() || this.creature.isDrinking() || this.creature.isAttacking() || this.creature.isDefending())
            return false;
        else {
            double searchDistance = Math.sqrt(maximumDistance);
            ArrayList<EntityJurassiCraftCoward> closeCowardList = this.creature.getClosestEntityCowardList(this.creature, searchDistance, searchDistance / 2.0D, searchDistance);

            if (!closeCowardList.isEmpty()) {
                for (EntityJurassiCraftCoward entity : closeCowardList) {
                    if (entity != null && entity.getClass() == this.creature.getClass() && entity != this.creature) {
                        double distance = this.creature.getDistanceSqToEntity(entity);

                        if (distance >= this.minimumDistance && distance <= this.maximumDistance) {
                            this.otherCreature = entity;
                            return !this.otherCreature.isCreatureOlderThan(this.maxAge) && !this.otherCreature.isPlaying() && this.otherCreature.getAnimationId() == 0 && !this.otherCreature.isSocializing() && !this.otherCreature.isSitting() && !this.otherCreature.isSleeping() && !this.otherCreature.isFleeing() && !this.otherCreature.isEating() && !this.otherCreature.isDrinking() && !this.otherCreature.isAttacking() && !this.otherCreature.isDefending();
                        }
                    }
                }
            }
        }

        return false;
    }

    public void startExecuting() {
        if (this.creature.isTakingOff())
            this.creature.setTakingOff(false);
        if (this.creature.isFlying())
            this.creature.setFlying(false);
        if (this.creature.isDefending())
            this.creature.setDefending(false);
        if (this.creature.isAttacking())
            this.creature.setAttacking(false);
        if (this.creature.isFleeing())
            this.creature.setFleeing(false);
        if (this.creature.isEating())
            this.creature.setEating(false);
        if (this.creature.isDrinking())
            this.creature.setDrinking(false);
        if (this.creature.isSleeping())
            this.creature.setSleeping(false);
        if (this.creature.isBreeding())
            this.creature.setBreeding(false);
        if (this.creature.isSitting())
            this.creature.setSitting(false, null);

        if (this.otherCreature.isTakingOff())
            this.otherCreature.setTakingOff(false);
        if (this.otherCreature.isFlying())
            this.otherCreature.setFlying(false);
        if (this.otherCreature.isDefending())
            this.otherCreature.setDefending(false);
        if (this.otherCreature.isAttacking())
            this.otherCreature.setAttacking(false);
        if (this.otherCreature.isFleeing())
            this.otherCreature.setFleeing(false);
        if (this.otherCreature.isEating())
            this.otherCreature.setEating(false);
        if (this.otherCreature.isDrinking())
            this.otherCreature.setDrinking(false);
        if (this.otherCreature.isSleeping())
            this.otherCreature.setSleeping(false);
        if (this.otherCreature.isBreeding())
            this.otherCreature.setBreeding(false);
        if (this.otherCreature.isSitting())
            this.otherCreature.setSitting(false, null);

        this.otherCreature.setSocializing(true);
        this.creature.setPlaying(true);
    }

    public void updateTask() {
        if (!this.creature.hasPath())
            this.creature.getNavigator().tryMoveToEntityLiving(this.otherCreature, this.creature.getCreatureSpeed());
    }

    public boolean continueExecuting() {
        return this.creature.getRNG().nextBoolean() ? true : this.creature.getDistanceSqToEntity(this.otherCreature) > this.minimumDistance;
    }

    public void resetTask() {
        if (this.creature.getAnimationId() == 0)
            AnimationHandler.sendAnimationPacket(this.creature, JurassiCraftAnimationIDs.PLAYING.animID());

        this.creature.getNavigator().clearPathEntity();
        this.creature.setCreatureToAttack(this.otherCreature);
        this.creature.setPlaying(false);

        if (this.otherCreature.getAnimationId() == 0)
            AnimationHandler.sendAnimationPacket(this.otherCreature, JurassiCraftAnimationIDs.SOCIALIZING.animID());

        this.otherCreature.getNavigator().clearPathEntity();
        this.otherCreature.setCreatureToAttack(this.creature);
        this.otherCreature.setSocializing(false);
        this.otherCreature = null;
    }
}
