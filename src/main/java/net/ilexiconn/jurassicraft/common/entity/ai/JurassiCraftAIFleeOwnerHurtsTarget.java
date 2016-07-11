package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class JurassiCraftAIFleeOwnerHurtsTarget extends EntityAITarget {
    private EntityJurassiCraftSmart creature;
    private EntityLivingBase target;

    public JurassiCraftAIFleeOwnerHurtsTarget(EntityJurassiCraftSmart entity) {
        super(entity, false);
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
                this.target = owner.getLastAttacker();

                return target != null && owner.getDistanceSqToEntity(this.creature) < 256.0D;
            }
        }
    }

    public void startExecuting() {
        this.creature.setFleeing(true);
        super.startExecuting();
    }

    public boolean continueExecuting() {
        this.target = null;
        return this.creature.isFleeing();
    }
}
