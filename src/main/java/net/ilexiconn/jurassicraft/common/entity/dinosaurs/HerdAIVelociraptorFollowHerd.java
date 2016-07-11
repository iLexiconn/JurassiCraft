package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.CreatureHerd;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.VelociraptorHerd;

public class HerdAIVelociraptorFollowHerd extends HerdAIFollowHerd {
    public HerdAIVelociraptorFollowHerd(EntityJurassiCraftCreature creature, double speed) {
        super(creature, true, speed);
    }

    protected CreatureHerd createHerd() {
        return new VelociraptorHerd();
    }
}
