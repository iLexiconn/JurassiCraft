package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class JurassiCraftAIFleeOwnerIsHurtByTarget extends EntityAITarget {
    private EntityJurassiCraftSmart creature;
    private EntityLivingBase attacker;

    public JurassiCraftAIFleeOwnerIsHurtByTarget(EntityJurassiCraftSmart entity) {
        super(entity, true);
        this.creature = entity;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (!this.creature.isTamed() || this.creature.isSleeping() || !this.creature.isFleeing()) {
            return false;
        } else {
            EntityLivingBase owner = this.creature.getOwner();

            if (owner == null) {
                return false;
            } else {
                this.attacker = owner.getAITarget();
                return attacker != null;
            }
        }
    }

    public void startExecuting() {
        this.creature.setFleeing(true);

        super.startExecuting();
    }

    public boolean continueExecuting() {
        this.attacker = null;

        return this.creature.isFleeing();
    }
}
