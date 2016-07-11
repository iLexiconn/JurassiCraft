package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class JurassiCraftAIAvoidEntityIfNotTamed extends EntityAIAvoidEntity {
    private EntityJurassiCraftSmart creature;

    public JurassiCraftAIAvoidEntityIfNotTamed(EntityJurassiCraftSmart entity, Class avoidClass, float distanceFromEntity, double farSpeed, double nearSpeed) {
        super(entity, avoidClass, distanceFromEntity, farSpeed, nearSpeed);
        this.creature = entity;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        return !this.creature.isTamed() && super.shouldExecute();
    }
}
