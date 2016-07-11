package net.ilexiconn.jurassicraft.common.entity.ai.herds;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class EntityAIHerd extends EntityAIBase {
    private CreatureHerd herd;
    private EntityJurassiCraftCreature creature;
    private boolean groupAttack;

    public EntityAIHerd(EntityJurassiCraftCreature creature, boolean groupAttack) {
        this.creature = creature;
        this.groupAttack = groupAttack;
    }

    public EntityJurassiCraftCreature getCreature() {
        return creature;
    }

    public CreatureHerd getHerd() {
        return herd;
    }

    public void startExecuting() {
        for (CreatureHerd herd : CreatureHerd.getHerds()) {
            if (herd.contains(creature)) {
                this.herd = herd;
                break;
            }

            double distance = herd.getDistanceFrom(creature);

            if (distance < 35) {
                if (herd.isAcceptable(creature)) {
                    this.herd = herd;
                    this.herd.add(creature);
                    break;
                }
            }
        }

        if (herd == null) {
            herd = createHerd();
            herd.add(creature);

            CreatureHerd.registerHerd(herd);
        }
    }

    protected CreatureHerd createHerd() {
        return new CreatureHerd(groupAttack);
    }
}
