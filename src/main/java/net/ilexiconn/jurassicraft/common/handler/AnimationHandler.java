package net.ilexiconn.jurassicraft.common.handler;

import cpw.mods.fml.common.FMLCommonHandler;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.message.MessageAnimation;
import net.minecraft.entity.Entity;

public class AnimationHandler {
    public static boolean isClient() {
        return FMLCommonHandler.instance().getSide().isClient();
    }

    public static boolean isEffectiveClient() {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    public static void sendAnimationPacket(IAnimatedEntity entity, int animationId) {
        if (isEffectiveClient())
            return;
        entity.setAnimationId(animationId);
        JurassiCraft.network.sendToAll(new MessageAnimation((byte) animationId, ((Entity) entity).getEntityId()));
    }
}
