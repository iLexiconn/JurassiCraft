package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityTyrannosaurus;

public class AnimationAITyrannosaurusEatingGallimimus extends AIAnimation {
    private EntityTyrannosaurus tyrannosaurus;

    public AnimationAITyrannosaurusEatingGallimimus(EntityTyrannosaurus tyrannosaurus) {
        super(tyrannosaurus);
        this.tyrannosaurus = tyrannosaurus;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.EATING.animID();
    }

    public int getDuration() {
        return 50;
    }

    public boolean isAutomatic() {
        return true;
    }

    public void startExecuting() {
        super.startExecuting();

        this.tyrannosaurus.setDrinking(false);
    }

    public void updateTask() {
    }
}
