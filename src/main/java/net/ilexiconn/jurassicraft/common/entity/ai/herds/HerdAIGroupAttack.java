package net.ilexiconn.jurassicraft.common.entity.ai.herds;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;

public class HerdAIGroupAttack extends EntityAIHerd {
    public HerdAIGroupAttack(EntityJurassiCraftCreature creature) {
        super(creature, true);
    }

    public void startExecuting() {
        super.startExecuting();

        if (getHerd() != null)
            getHerd().attack(getCreature().getAttackTarget());
    }

    public boolean shouldExecute() {
        return getCreature().getAttackTarget() != null;
    }

    public boolean continueExecuting() {
        return getCreature().getAttackTarget() != null && getCreature().getAttackTarget().isEntityAlive();
    }
}
