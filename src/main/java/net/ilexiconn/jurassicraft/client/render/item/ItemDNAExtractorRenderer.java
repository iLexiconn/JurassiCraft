package net.ilexiconn.jurassicraft.client.render.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.client.render.tile.TileDNAExtractorRenderer;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemDNAExtractorRenderer implements IItemRenderer {
    private TileEntitySpecialRenderer render = new TileDNAExtractorRenderer();
    private TileEntity tileEntity = new TileDNAExtractor();

    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if (type == IItemRenderer.ItemRenderType.ENTITY) {
            GL11.glTranslatef(-0.5F, -0.35F, -0.5F);
            GL11.glScalef(1.2F, 1.2F, 1.2F);
        } else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.5F, 0.0F);
        } else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
            GL11.glScalef(1.5F, 1.5F, 1.5F);
        }

        this.render.renderTileEntityAt(this.tileEntity, 0.0D, 0.0D, 0.0D, 0.0F);
    }
}