package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;

public class AnimationAIRoar extends AIAnimation {
    private int duration;

    public AnimationAIRoar(EntityJurassiCraftSmart creature, int duration) {
        super(creature);
        this.duration = duration;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.ROAR.animID();
    }

    public boolean isAutomatic() {
        return true;
    }

    public int getDuration() {
        return this.duration;
    }
}
