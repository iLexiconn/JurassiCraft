package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class JurassiCraftAIDefensiveReaction extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private EntityLivingBase attacker;
    private double distanceSqFromAttacker;
    private double minimumSquaredDistance;
    private double maximumSquaredDistance;
    private boolean resetStateWhenTriggered;
    private boolean shouldAnimate;
    private int animationID;

    /**
     * This class is a generic defensive behavior for herbivores. This AI will only start if the this.creature.getCreatureToAttack() is != null. It can be easily set in the entity class by using getClosestEntityAggressive() from EntityJurassiCraftSmart class.
     *
     * @param creature is the entity creature;
     * @param minimumSquaredDistance is the minimum distance from the attacker. Smaller distances will trigger an attack;
     * @param maximumSquaredDistance is the maximum distance from the attacker. Larger distances will reset this AI;
     * @param resetStateWhenTriggered checks if there is a attack target, if so this AI is reset;
     * @author RafaMv
     * @see EntityJurassiCraftSmart
     */
    public JurassiCraftAIDefensiveReaction(EntityJurassiCraftSmart creature, double minimumSquaredDistance, double maximumSquaredDistance, boolean resetStateWhenTriggered) {
        this(creature, minimumSquaredDistance, maximumSquaredDistance, false, 0, resetStateWhenTriggered);
    }

    /**
     * This class is a generic defensive behavior for herbivores. This AI will only start if the this.creature.getCreatureToAttack() is != null. It can be easily set in the entity class by using getClosestEntityAggressive() from EntityJurassiCraftSmart class.
     *
     * @param creature is the entity creature;
     * @param minimumDistance is the minimum distance from the attacker. Smaller distances will trigger an attack;
     * @param maximumDistance is the maximum distance from the attacker. Larger distances will reset this AI;
     * @param shouldAnimate checks if the entity should receive the animation ID;
     * @param animationID is the ID from the animation that will be trigger if the attack is too close.
     * @param resetStateWhenTriggered checks if there is a attack target, if so this AI is reset;
     * @author RafaMv
     * @see EntityJurassiCraftSmart
     */
    public JurassiCraftAIDefensiveReaction(EntityJurassiCraftSmart creature, double minimumDistance, double maximumDistance, boolean shouldAnimate, int animationID, boolean resetStateWhenTriggered) {
        this.creature = creature;
        this.distanceSqFromAttacker = 0;
        this.attacker = null;
        this.minimumSquaredDistance = minimumDistance * minimumDistance;
        this.maximumSquaredDistance = maximumDistance * maximumDistance;
        this.shouldAnimate = shouldAnimate;
        this.animationID = animationID;
        this.resetStateWhenTriggered = resetStateWhenTriggered;
    }

    public boolean shouldExecute() {
        if (this.creature.isDefending() && !this.creature.isSleeping() && !this.creature.isTakingOff() && !this.creature.isFlying() && !this.creature.isFleeing()) {
            return this.creature.getCreatureToAttack() != null;
        }

        return false;
    }

    public void startExecuting() {
        this.creature.getNavigator().clearPathEntity();

        if (this.creature.isTakingOff())
            this.creature.setTakingOff(false);

        if (this.creature.isFlying())
            this.creature.setFlying(false);

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

        if (this.creature.isSitting())
            this.creature.setSitting(false, null);

        if (this.creature.isBreeding())
            this.creature.setBreeding(false);

        if (this.creature.isInLove())
            this.creature.setInLove(false);

        if (this.creature.isStalking())
            this.creature.setStalking(false);

        this.attacker = this.creature.getCreatureToAttack();
        this.distanceSqFromAttacker = this.creature.getDistanceSqToEntity(this.attacker);
    }

    public void updateTask() {
        if (this.creature.getRNG().nextInt(5) == 0)
            this.distanceSqFromAttacker = this.creature.getDistanceSqToEntity(this.attacker);

        if (this.distanceSqFromAttacker < this.minimumSquaredDistance) {
            this.creature.setAttackTarget(this.attacker);

            if (this.shouldAnimate && this.creature.getAnimationId() == 0)
                AnimationHandler.sendAnimationPacket(this.creature, this.animationID);
        }
    }

    public boolean continueExecuting() {
        return this.attacker.isEntityAlive() && this.creature.isDefending() && this.distanceSqFromAttacker < this.maximumSquaredDistance && (this.resetStateWhenTriggered ? this.creature.getAttackTarget() == null : true) && !this.creature.isSitting() && this.creature.riddenByEntity == null;
    }

    public void resetTask() {
        this.creature.setCreatureToAttack(null);
        this.creature.setDefending(false);
        this.distanceSqFromAttacker = 0;
        this.attacker = null;
    }
}
