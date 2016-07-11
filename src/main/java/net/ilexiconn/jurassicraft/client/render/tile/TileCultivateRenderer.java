package net.ilexiconn.jurassicraft.client.render.tile;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.block.ModelCultivate;
import net.ilexiconn.jurassicraft.client.model.block.ModelEmbryo;
import net.ilexiconn.jurassicraft.client.render.RenderHelper;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivate;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivateBottom;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemDye;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileCultivateRenderer extends TileEntitySpecialRenderer {
    public ModelCultivate cultivate = new ModelCultivate();
    public ModelEmbryo embryo = new ModelEmbryo();
    public ResourceLocation[] cultivateTextures;
    public ResourceLocation embryoTextures;

    public TileCultivateRenderer() {
        this.embryoTextures = new ResourceLocation(JurassiCraft.getModId() + "textures/blocks/embryo.png");
        this.cultivateTextures = new ResourceLocation[BlockCultivateBottom.iconVariationsNames.length];

        for (int i = 0; i < BlockCultivateBottom.iconVariationsNames.length; i++)
            this.cultivateTextures[i] = new ResourceLocation(JurassiCraft.getModId() + "textures/blocks/cultivate_" + ItemDye.field_150921_b[i] + ".png");
    }

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float meta) {
        GL11.glEnable(GL11.GL_BLEND);
        TileCultivate tile = (TileCultivate) tileEntity;
        int metadata = 0;

        if (tile.getWorldObj() != null) {
            metadata = tile.getWorldObj().getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
        }

        TextureManager renderEngine = Minecraft.getMinecraft().renderEngine;

        if (tile.isHatching()) {
            GL11.glPushMatrix();
            GL11.glColor4f(1f, 1f, 1f, 1f);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
            int rotation = BlockCultivate.getRotation(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord);
            GL11.glRotatef(rotation == 0 ? 0f : rotation == 1 ? -90f : rotation == 2 ? -180f : 90f, 0f, 1f, 0f);
            GL11.glRotatef(180f, 0f, 0f, 1f);
            renderEngine.bindTexture(this.embryoTextures);
            this.embryo.render(tile);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        renderEngine.bindTexture(this.cultivateTextures[metadata]);
        this.cultivate.render(false);
        GL11.glPopMatrix();

        int[] displayList = RenderHelper.getFluidDisplayLists(tile.getWorldObj(), JCBlockRegistry.cultivateFluid, JCBlockRegistry.cultivateLiquid);
        GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.bindTexture(TextureMap.locationBlocksTexture);
        GL11.glTranslatef((float) x + 0.125f, (float) y + 1.29f, (float) z + 0.125f);
        GL11.glScalef(0.75f, 0.75f * 2.5f, 0.75f);
        GL11.glTranslatef(0, -0.5f, 0);
        GL11.glCallList(displayList[7]);
        GL11.glPopAttrib();
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glColor4f(1f, 1f, 1f, 0.7f);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        renderEngine.bindTexture(this.cultivateTextures[metadata]);
        this.cultivate.renderGlass();
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_BLEND);
    }
}
