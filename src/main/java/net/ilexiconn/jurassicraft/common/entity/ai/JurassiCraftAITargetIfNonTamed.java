package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

/**
 * This AI makes an EntityJurassiCraftSmart attack a desirable mob when the creature is not tamed.
 *
 * @author RafaMv
 */
public class JurassiCraftAITargetIfNonTamed extends EntityAINearestAttackableTarget {
    private EntityJurassiCraftSmart creature;

    public JurassiCraftAITargetIfNonTamed(EntityJurassiCraftSmart entity, Class targetClass, int chanceToAttack) {
        super(entity, targetClass, chanceToAttack, false);
        this.creature = entity;
    }

    public boolean shouldExecute() {
        return !this.creature.isTamed() && !this.creature.isSleeping() && !this.creature.isAttacking() && super.shouldExecute();
    }

    public void startExecuting() {
        super.startExecuting();
        this.creature.setAttacking(true);
    }

    public void resetTask() {
        super.resetTask();
        this.creature.setAttacking(false);
    }
}
