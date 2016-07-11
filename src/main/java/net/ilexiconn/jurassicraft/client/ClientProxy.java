package net.ilexiconn.jurassicraft.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.gui.GuiCultivateProcess;
import net.ilexiconn.jurassicraft.client.gui.GuiDinoPad;
import net.ilexiconn.jurassicraft.client.gui.GuiDinoPadEgg;
import net.ilexiconn.jurassicraft.client.gui.GuiDinoPadPregnancy;
import net.ilexiconn.jurassicraft.client.render.JCRenderRegistry;
import net.ilexiconn.jurassicraft.client.render.RenderPlayerEventHandler;
import net.ilexiconn.jurassicraft.common.CommonProxy;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    private Timer timer;

    public float getPartialTick() {
        return timer.renderPartialTicks;
    }

    public World getWorldClient() {
        return FMLClientHandler.instance().getWorldClient();
    }

    public void renderEntity(Class<? extends EntityLiving> entity, RenderLiving renderLiving) {
        RenderingRegistry.registerEntityRenderingHandler(entity, renderLiving);
    }

    public void renderTileEntity(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer) {
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntity, renderer);
    }

    public void renderItem(Item item, IItemRenderer render) {
        MinecraftForgeClient.registerItemRenderer(item, render);
    }

    public void init() throws Exception {
        new JCRenderRegistry().init();

        MinecraftForge.EVENT_BUS.register(new RenderPlayerEventHandler());
        JurassiCraft.entityParser.parseClientEntities();

        timer = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), new String[] { "field_71428_T", "S", "timer" });
    }

    public void openCultivatorProgress(TileCultivate tile) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiCultivateProcess(tile));
    }

    public void openDinoPad(Entity entity) {
        GuiScreen screen = null;

        if (entity instanceof EntityCow || entity instanceof EntityPig || entity instanceof EntityHorse || entity instanceof EntitySheep)
            screen = new GuiDinoPadPregnancy(entity);
        else if (entity instanceof EntityDinoEgg)
            screen = new GuiDinoPadEgg(entity);
        else if (entity instanceof EntityJurassiCraftSmart)
            screen = new GuiDinoPad(entity);

        if (screen != null) {
            Minecraft.getMinecraft().displayGuiScreen(screen);
        }
    }
}
