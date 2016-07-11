package net.ilexiconn.jurassicraft.client.render.tile;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.block.ModelDNAExtractorBase;
import net.ilexiconn.jurassicraft.client.model.block.ModelDNAExtractorGlass;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileDNAExtractorRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation(JurassiCraft.getModId() + "textures/blocks/dna_extractor.png");
    private ModelDNAExtractorBase modelBase = new ModelDNAExtractorBase();
    private ModelDNAExtractorGlass modelGlass = new ModelDNAExtractorGlass();
    private float animationAngle = 0.001F;

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        if (tileEntity instanceof TileDNAExtractor) {
            TileDNAExtractor tileEntityModel = (TileDNAExtractor) tileEntity;
            int angle = 0;

            if (tileEntityModel.getWorldObj() == null) {
                angle = 0;
            } else {
                int direction = tileEntityModel.getBlockMetadata();
                switch (direction) {
                    case 0:
                        angle = -180;
                        break;
                    case 1:
                        angle = -90;
                        break;
                    case 2:
                        angle = 0;
                        break;
                    case 3:
                        angle = -270;
                        break;
                }
            }

            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(angle + 180, 0.0F, 1.0F, 0F);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            this.modelBase.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

            if (tileEntityModel.hasItems()) {
                this.animationAngle += 0.1F;
                for (int i = 7; i > 3; i--) {
                    ItemStack stack = tileEntityModel.getStackInSlot(i);
                    if (stack != null) {
                        GL11.glPushMatrix();
                        GL11.glTranslatef(0.05F * (i - 3), 1.0F + 0.1F * MathHelper.sin(this.animationAngle / 20.0F + i), -0.05F * (i - 3));
                        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                        GL11.glRotatef(this.animationAngle + i, 0.0F, 1.0F, 0F);
                        GL11.glScalef(0.4F, 0.4F, 0.4F);
                        EntityItem entityItem = new EntityItem(tileEntityModel.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);
                        entityItem.hoverStart = 0.0F;
                        RenderItem.renderInFrame = true;
                        RenderManager.instance.renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                        RenderItem.renderInFrame = false;
                        GL11.glPopMatrix();
                    }
                }
            }

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.55F);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            this.modelGlass.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glPopMatrix();
        }
    }
}