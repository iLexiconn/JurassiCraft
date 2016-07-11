package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityGallimimus;

public class AnimationAIGallimimusBeingEaten extends AIAnimation {
    private EntityGallimimus gallimimus;

    public AnimationAIGallimimusBeingEaten(EntityGallimimus gallimimus) {
        super(gallimimus);
        this.gallimimus = gallimimus;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.BEING_EATEN.animID();
    }

    public int getDuration() {
        return 45;
    }

    public boolean isAutomatic() {
        return true;
    }

    public void resetTask() {
        super.resetTask();
        gallimimus.setHealth(0);
        gallimimus.setDead();
    }
}
