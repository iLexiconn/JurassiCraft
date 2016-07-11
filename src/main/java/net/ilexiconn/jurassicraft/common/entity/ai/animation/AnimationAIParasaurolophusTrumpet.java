package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityParasaurolophus;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;

import java.util.List;

public class AnimationAIParasaurolophusTrumpet extends AIAnimation {
    private EntityParasaurolophus parasaurolophus;

    public AnimationAIParasaurolophusTrumpet(IAnimatedEntity entity) {
        super(entity);
        this.parasaurolophus = (EntityParasaurolophus) entity;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.TRUMPET.animID();
    }

    public boolean isAutomatic() {
        return true;
    }

    public int getDuration() {
        return 60;
    }

    public void resetTask() {
        super.resetTask();
        this.parasaurolophus.timeUntilCanCall = 300;
    }

    public void updateTask() {
        if (this.parasaurolophus.getAnimationTick() == 3) {
            this.parasaurolophus.playSound("jurassicraft:parasaurolophusCall", 5.0F, 1.0F);
        }

        if (this.parasaurolophus.getAnimationTick() == 50) {
            List<EntityParasaurolophus> recipients = this.parasaurolophus.getParasaurolophusNearby(20.0D, 10.0D, 20.0D);

            for (EntityParasaurolophus nearbyParasaurolophus : recipients) {
                if (nearbyParasaurolophus.timeUntilCanCall == 0 && nearbyParasaurolophus.getAnimationId() == 0)
                    AnimationHandler.sendAnimationPacket(nearbyParasaurolophus, JurassiCraftAnimationIDs.TRUMPET.animID());
            }
        }
    }
}
