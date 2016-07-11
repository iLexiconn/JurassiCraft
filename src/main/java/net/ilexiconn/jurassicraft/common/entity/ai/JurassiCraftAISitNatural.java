package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class JurassiCraftAISitNatural extends EntityAIBase {
    private EntityJurassiCraftSmart creature;
    private int nonTamedStartingTime;
    private int nonTamedTimer;
    private int nonTamedChance;
    private int nonTamedMinDuration;
    private int nonTamedDurationVariation;

    /**
     * This AI handles the sitting state of the creature. It can be set to sit by its owner, or can naturally sit if it does not have a owner.
     *
     * @param creature is the entity that will sit;
     * @param nonTamedStartingTime is a minimum amount of time required to sit. Must be greater than or equal to 500;
     * @param nonTamedChance is the chance that the creature will sit is not tamed. Must be greater then 0;
     * @param nonTamedMinDuration is the minimum time that a non tamed creature will be sitting. It should be greater than or equal to 300, and can vary between the minimum value and 1.5 of this value.
     * @author RafaMv
     */
    public JurassiCraftAISitNatural(EntityJurassiCraftSmart creature, int nonTamedStartingTime, int nonTamedChance, int nonTamedMinDuration) {
        this.creature = creature;

        this.setMutexBits(5);
        this.nonTamedTimer = 0;

        if (nonTamedStartingTime > 499)
            this.nonTamedStartingTime = nonTamedStartingTime + (int) (nonTamedStartingTime * this.creature.getRNG().nextFloat());
        else
            this.nonTamedStartingTime = 500;

        if (nonTamedChance > 0)
            this.nonTamedChance = nonTamedChance;
        else
            this.nonTamedChance = 1;

        if (nonTamedMinDuration > 299) {
            this.nonTamedDurationVariation = (int) (nonTamedMinDuration * 0.5F * this.creature.getRNG().nextFloat());
            this.nonTamedMinDuration = nonTamedMinDuration + this.nonTamedDurationVariation;
        } else {
            this.nonTamedDurationVariation = (int) (300 + 150 * this.creature.getRNG().nextFloat());
            this.nonTamedMinDuration = 300 + this.nonTamedDurationVariation;
        }
    }

    public boolean shouldExecute() {
        if (this.creature.isInWater() || !this.creature.onGround || this.creature.isTakingOff() || this.creature.isFlying() || this.creature.riddenByEntity != null || this.creature.isEating() || this.creature.isDrinking() || this.creature.isPlaying() || this.creature.isAttacking() || this.creature.isDefending() || this.creature.isBreeding())
            return false;

        if (!this.creature.isTamed()) {
            this.nonTamedTimer++;

            if (this.nonTamedTimer > this.nonTamedStartingTime)
                return this.creature.getRNG().nextInt(this.nonTamedChance) == 0;
            else
                return false;
        } else {
            EntityLivingBase owner = this.creature.getOwner();

            return this.creature.isSitting() ? (owner == null ? false : (this.creature.getDistanceSqToEntity(owner) < 144.0D && owner.getAITarget() == null)) : false;
        }
    }

    public void startExecuting() {
        this.creature.getNavigator().clearPathEntity();
        this.creature.setTakingOff(false);
        this.creature.setFlying(false);
        this.creature.setEating(false);
        this.creature.setDrinking(false);
        this.creature.setDefending(false);
        this.creature.setPlaying(false);
        this.creature.setBreeding(false);
        this.creature.setSitting(true, null);
        this.nonTamedTimer = 0;
    }

    public void updateTask() {
        if (!this.creature.isTamed())
            this.nonTamedTimer++;
    }

    public boolean continueExecuting() {
        return this.creature.isSitting() && this.nonTamedTimer < this.nonTamedMinDuration && !this.creature.hasBeenHurt() && this.creature.getAttackTarget() == null;
    }

    public void resetTask() {
        this.nonTamedDurationVariation = (int) (this.nonTamedMinDuration * 0.5F * this.creature.getRNG().nextFloat());

        if (this.creature.isTamed())
            this.creature.setSitting(false, (EntityPlayer) this.creature.getOwner());
        else
            this.creature.setSitting(false, null);
    }
}
