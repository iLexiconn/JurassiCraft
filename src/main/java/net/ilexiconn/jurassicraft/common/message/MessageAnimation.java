package net.ilexiconn.jurassicraft.common.message;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.llibrary.server.network.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class MessageAnimation extends AbstractMessage<MessageAnimation> {
    private byte animationId;
    private int entityId;

    public MessageAnimation() {
        this((byte) 0, 0);
    }

    public MessageAnimation(byte animation, int entity) {
        animationId = animation;
        entityId = entity;
    }

    @Override
    public void onClientReceived(Minecraft client, MessageAnimation message, EntityPlayer player, MessageContext messageContext) {
        World world = JurassiCraft.proxy.getWorldClient();
        IAnimatedEntity entity = (IAnimatedEntity) world.getEntityByID(message.entityId);
        if (entity != null && message.animationId != -1) {
            entity.setAnimationId(message.animationId);
            if (message.animationId == 0)
                entity.setAnimationTick(0);
        }
    }

    @Override
    public void onServerReceived(MinecraftServer server, MessageAnimation message, EntityPlayer player, MessageContext messageContext) {

    }

    public void toBytes(ByteBuf buffer) {
        buffer.writeByte(animationId);
        buffer.writeInt(entityId);
    }

    public void fromBytes(ByteBuf buffer) {
        animationId = buffer.readByte();
        entityId = buffer.readInt();
    }
}
