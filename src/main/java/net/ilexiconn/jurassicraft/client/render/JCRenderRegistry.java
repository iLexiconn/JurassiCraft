package net.ilexiconn.jurassicraft.client.render;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.client.render.entity.RenderDinoEgg;
import net.ilexiconn.jurassicraft.client.render.entity.RenderSpit;
import net.ilexiconn.jurassicraft.client.render.item.*;
import net.ilexiconn.jurassicraft.client.render.tile.TileCultivateRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.TileDNACombinatorRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.TileDNAExtractorRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.TileDinoPadRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.fence.TileSecurityFenceLowBaseRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.fence.TileSecurityFenceLowGridRenderer;
import net.ilexiconn.jurassicraft.client.render.tile.fence.TileSecurityFenceLowPoleRenderer;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.entity.EntitySpit;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNACombinator;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.ilexiconn.jurassicraft.common.tileentity.TileDinoPad;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowPole;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class JCRenderRegistry {
    public void init() {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(JCBlockRegistry.cultivateBottomOff), new ItemCultivateRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(JCBlockRegistry.dnaExtractor), new ItemDNAExtractorRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(JCBlockRegistry.dnaCombinator), new ItemDNACombinatorRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(JCBlockRegistry.securityFenceLowPole), new ItemLowSecurityFencePoleRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(JCBlockRegistry.securityFenceLowBase), new ItemLowSecurityFenceBaseRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileDNACombinator.class, new TileDNACombinatorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCultivate.class, new TileCultivateRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDNAExtractor.class, new TileDNAExtractorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDinoPad.class, new TileDinoPadRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceLowBase.class, new TileSecurityFenceLowBaseRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceLowGrid.class, new TileSecurityFenceLowGridRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSecurityFenceLowPole.class, new TileSecurityFenceLowPoleRenderer());

        RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg());
        RenderingRegistry.registerEntityRenderingHandler(EntitySpit.class, new RenderSpit());
    }
}
