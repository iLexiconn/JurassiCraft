package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class JurassiCraftAISit extends EntityAIBase {
    private EntityJurassiCraftSmart creature;

    public JurassiCraftAISit(EntityJurassiCraftSmart creature) {
        this.creature = creature;
        this.setMutexBits(5);
    }

    public boolean shouldExecute() {
        if (this.creature.isInWater() || !this.creature.onGround || !this.creature.isTamed() || this.creature.isTakingOff() || this.creature.isFlying() || this.creature.riddenByEntity != null || this.creature.isEating() || this.creature.isDrinking() || this.creature.isPlaying() || this.creature.isAttacking() || this.creature.isDefending() || this.creature.isBreeding())
            return false;

        EntityLivingBase owner = this.creature.getOwner();

        return !this.creature.isSitting() ? false : (owner == null ? false : (this.creature.getDistanceSqToEntity(owner) < 144.0D && owner.getAITarget() == null));
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
        this.creature.setSitting(true, (EntityPlayer) this.creature.getOwner());
    }

    public boolean continueExecuting() {
        return this.creature.isSitting() && !this.creature.hasBeenHurt();
    }

    public void resetTask() {
        this.creature.setSitting(false, (EntityPlayer) this.creature.getOwner());
    }
}
