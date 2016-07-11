package net.ilexiconn.jurassicraft.client.render;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import java.util.UUID;

@SideOnly(Side.CLIENT)
public class RenderPlayerEventHandler {
    public ResourceLocation capeDeveloper = new ResourceLocation("jurassicraft", "textures/cape/developer_cape.png");
    public ResourceLocation capePatron = new ResourceLocation("jurassicraft", "textures/cape/patron_cape.png");

    @SubscribeEvent
    public void playerRender(RenderPlayerEvent.Pre event) {
        AbstractClientPlayer player = (AbstractClientPlayer) event.entityPlayer;

        UUID uniqueID = player.getUniqueID();

        try {
            if (isDeveloper(uniqueID))
                player.func_152121_a(MinecraftProfileTexture.Type.CAPE, capeDeveloper);
            else if (isPatron(uniqueID))
                player.func_152121_a(MinecraftProfileTexture.Type.CAPE, capePatron);
        } catch (Exception e) {
            System.err.println("Failed to load capes!");
            e.printStackTrace();
        }
    }

    public boolean isDeveloper(UUID uuid) throws Exception {
        return JurassiCraft.capeContainer.getDevelopers().contains(uuid.toString());
    }

    public boolean isPatron(UUID uuid) throws Exception {
        return JurassiCraft.capeContainer.getPatrons().contains(uuid.toString());
    }
}
