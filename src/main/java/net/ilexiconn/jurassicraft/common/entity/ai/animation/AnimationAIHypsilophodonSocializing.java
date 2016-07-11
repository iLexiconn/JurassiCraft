package net.ilexiconn.jurassicraft.common.entity.ai.animation;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.AIAnimation;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityHypsilophodon;

public class AnimationAIHypsilophodonSocializing extends AIAnimation {
    private EntityHypsilophodon hypsilophodon;

    public AnimationAIHypsilophodonSocializing(EntityHypsilophodon hypsilophodon) {
        super(hypsilophodon);
        this.hypsilophodon = hypsilophodon;
    }

    public int getAnimationId() {
        return JurassiCraftAnimationIDs.SOCIALIZING.animID();
    }

    public boolean isAutomatic() {
        return true;
    }

    public int getDuration() {
        return 70;
    }

    public void startExecuting() {
        super.startExecuting();
        this.hypsilophodon.setSitting(false, null);
    }

    public void updateTask() {
        if (this.hypsilophodon.getCreatureToAttack() != null && this.hypsilophodon.getCreatureToAttack() instanceof EntityHypsilophodon) {
            EntityHypsilophodon friend = (EntityHypsilophodon) this.hypsilophodon.getCreatureToAttack();

            if (this.hypsilophodon.getAnimationTick() < 5) {
                this.hypsilophodon.getLookHelper().setLookPositionWithEntity(friend, 30F, 30F);
            }
            // TODO Do stuff
        }
    }

    public void resetTask() {
        super.resetTask();

        this.hypsilophodon.setCreatureToAttack(null);
    }
}
