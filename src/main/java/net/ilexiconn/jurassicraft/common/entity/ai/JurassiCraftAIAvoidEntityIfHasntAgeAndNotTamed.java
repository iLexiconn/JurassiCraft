package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class JurassiCraftAIAvoidEntityIfHasntAgeAndNotTamed extends EntityAIAvoidEntity {
    private EntityJurassiCraftSmart creature;
    private float age;

    public JurassiCraftAIAvoidEntityIfHasntAgeAndNotTamed(EntityJurassiCraftSmart entity, Class avoidClass, float minAgeToAvoid, float distanceFromEntity, double farSpeed, double nearSpeed) {
        super(entity, avoidClass, distanceFromEntity, farSpeed, nearSpeed);
        this.creature = entity;
        this.age = minAgeToAvoid;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        return !this.creature.isTamed() && !this.creature.isCreatureOlderThan(this.age) && super.shouldExecute();
    }
}
