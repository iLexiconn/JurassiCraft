package net.ilexiconn.jurassicraft.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderHelper {
    private static ResourceLocation glintTexture = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private static Map<Fluid, int[]> renderCache = new HashMap<Fluid, int[]>();
    private static RenderInfo liquidBlock = new RenderInfo();
    private static RenderBlocks renderBlocks = new RenderBlocks();

    private static void renderBlock(RenderInfo info, IBlockAccess blockAccess, int x, int y, int z, boolean doLight) {
        float lightBottom = 0.5F;
        float lightTop = 1.0F;
        float lightEastWest = 0.8F;
        float lightNorthSouth = 0.6F;

        Tessellator tessellator = Tessellator.instance;

        boolean realDoLight = doLight;

        if (blockAccess == null)
            realDoLight = false;

        tessellator.startDrawingQuads();

        float light = 0;

        if (realDoLight) {
            if (info.light < 0) {
                light = info.baseBlock.getMixedBrightnessForBlock(blockAccess, x, y, z);
                light = light + ((1.0f - light) * 0.4f);
            } else
                light = info.light;

            int brightness;

            if (info.brightness < 0)
                brightness = info.baseBlock.getMixedBrightnessForBlock(blockAccess, x, y, z);
            else
                brightness = info.brightness;

            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(lightBottom * light, lightBottom * light, lightBottom * light);
        } else if (info.brightness >= 0)
            tessellator.setBrightness(info.brightness);

        renderBlocks.setRenderBounds(info.minX, info.minY, info.minZ, info.maxX, info.maxY, info.maxZ);

        if (info.renderSide[0])
            renderBlocks.renderFaceYNeg(info.baseBlock, x, y, z, info.getBlockTextureFromSide(0));

        if (realDoLight)
            tessellator.setColorOpaque_F(lightTop * light, lightTop * light, lightTop * light);

        if (info.renderSide[1])
            renderBlocks.renderFaceYPos(info.baseBlock, x, y, z, info.getBlockTextureFromSide(1));

        if (realDoLight)
            tessellator.setColorOpaque_F(lightEastWest * light, lightEastWest * light, lightEastWest * light);

        if (info.renderSide[2])
            renderBlocks.renderFaceZNeg(info.baseBlock, x, y, z, info.getBlockTextureFromSide(2));

        if (realDoLight)
            tessellator.setColorOpaque_F(lightEastWest * light, lightEastWest * light, lightEastWest * light);

        if (info.renderSide[3])
            renderBlocks.renderFaceZPos(info.baseBlock, x, y, z, info.getBlockTextureFromSide(3));

        if (realDoLight)
            tessellator.setColorOpaque_F(lightNorthSouth * light, lightNorthSouth * light, lightNorthSouth * light);

        if (info.renderSide[4])
            renderBlocks.renderFaceXNeg(info.baseBlock, x, y, z, info.getBlockTextureFromSide(4));

        if (realDoLight)
            tessellator.setColorOpaque_F(lightNorthSouth * light, lightNorthSouth * light, lightNorthSouth * light);

        if (info.renderSide[5])
            renderBlocks.renderFaceXPos(info.baseBlock, x, y, z, info.getBlockTextureFromSide(5));

        tessellator.draw();
    }

    public static int[] getFluidDisplayLists(World world) {
        return getFluidDisplayLists(world, FluidRegistry.WATER, Blocks.water);
    }

    public static int[] getFluidDisplayLists(World world, Fluid fluid, Block blockFluid) {
        if (fluid == null)
            return null;

        int[] displayLists = renderCache.get(fluid);
        if (displayLists != null)
            return displayLists;

        displayLists = new int[8];

        liquidBlock.baseBlock = blockFluid;
        liquidBlock.texture = fluid.getStillIcon();

        renderCache.put(fluid, displayLists);

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);

        for (int s = 0; s < displayLists.length; ++s) {
            displayLists[s] = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(displayLists[s], 4864);

            liquidBlock.minX = 0.01f;
            liquidBlock.minY = 0;
            liquidBlock.minZ = 0.01f;

            liquidBlock.maxX = 0.99f;
            liquidBlock.maxY = (float) s / (float) displayLists.length;
            liquidBlock.maxZ = 0.99f;

            renderBlock(liquidBlock, world, 0, 0, 0, false);

            GL11.glEndList();
        }

        GL11.glColor4f(1, 1, 1, 1);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);

        return displayLists;
    }

    public static void renderItemIn3d(ItemStack stack) {
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        if (textureManager == null)
            return;
        Item item = stack.getItem();

        GL11.glPushMatrix();

        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.5f, -0.5f, 1 / 32.0f);

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

        int passes = item.getRenderPasses(stack.getItemDamage());

        for (int pass = 0; pass < passes; pass++) {
            textureManager.bindTexture(((stack.getItemSpriteNumber() == 0) ? TextureMap.locationBlocksTexture : TextureMap.locationItemsTexture));
            IIcon icon = item.getIcon(stack, pass);

            float minU = icon.getMinU();
            float maxU = icon.getMaxU();
            float minV = icon.getMinV();
            float maxV = icon.getMaxV();

            setColorFromInt(item.getColorFromItemStack(stack, pass));
            ItemRenderer.renderItemIn2D(tessellator, maxU, minV, minU, maxV, icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
        }

        if (stack.hasEffect(0)) {
            GL11.glDepthFunc(GL11.GL_EQUAL);
            GL11.glDisable(GL11.GL_LIGHTING);
            textureManager.bindTexture(glintTexture);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            float f7 = 0.76f;
            GL11.glColor4f(0.5f * f7, 0.25f * f7, 0.8f * f7, 1.0f);
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            float f8 = 0.125f;
            GL11.glScalef(f8, f8, f8);
            float f9 = Minecraft.getSystemTime() % 3000l / 3000.0f * 8.0f;
            GL11.glTranslatef(f9, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            f9 = Minecraft.getSystemTime() % 4873l / 4873.0f * 8.0f;
            GL11.glTranslatef(-f9, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);

        GL11.glPopMatrix();
    }

    private static void setColorFromInt(int color) {
        float r = (color >> 16 & 255) / 255f;
        float g = (color >> 8 & 255) / 255f;
        float b = (color & 255) / 255f;
        GL11.glColor4f(r, g, b, 1.0f);
    }
}