package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiDinoPadEgg extends GuiScreen {
    private EntityDinoEgg egg;
    private float renderRotation;
    private int xSize;
    private int ySize;
    private int guiLeft;
    private int guiTop;

    public GuiDinoPadEgg(Entity entity) {
        super();

        if (entity != null) {
            this.egg = (EntityDinoEgg) entity;
        } else {
            this.mc.thePlayer.closeScreen();
        }

        if (this.egg == null) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void initGui() {
        this.buttonList.clear();
        this.xSize = 256;
        this.ySize = 176;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.renderRotation = 0.0F;
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void onGuiClosed() {
        this.egg = null;
        super.onGuiClosed();
    }

    protected void keyTyped(char keyChar, int key) {
        if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void updateScreen() {
        if (this.egg != null) {
            this.renderRotation++;

            if (!this.egg.isEntityAlive()) {
                this.mc.thePlayer.closeScreen();
            }
        } else {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiDinoPadEgg.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (this.egg != null && this.egg.isEntityAlive()) {
            this.renderEgg((float) (this.guiLeft + 67), (float) (this.guiTop + 108), 60.0F);
            this.fontRendererObj.drawString(StatCollector.translateToLocal("entity." + this.egg.creature.getCreatureName() + ".name"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("entity." + this.egg.creature.getCreatureName() + ".name")) / 2, this.guiTop + 14, 14737632);

            if (this.egg.currentSpawnTime >= 0) {
                mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiDinoPadEgg.png"));
                this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 81, 1, 182, this.egg.getHatchingProgressScaled(95), 5);
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.hatching") + ": " + String.valueOf(this.egg.getHatchingProgressScaled(100)) + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.hatching") + String.valueOf(this.egg.getHatchingProgressScaled(100)) + "%") / 2, this.guiTop + 68, 14737632);
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence()) / 2, this.guiTop + 92, 14737632);
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%") / 2, this.guiTop + 104, 14737632);
            } else {
                if (this.egg.dried) {
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.notHatching"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.notHatching")) / 2, this.guiTop + 68, 32000000);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dried"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dried")) / 2, this.guiTop + 80, 32000000);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence()) / 2, this.guiTop + 92, 32000000);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%") / 2, this.guiTop + 104, 32000000);
                } else if (this.egg.froze) {
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.notHatching"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.notHatching")) / 2, this.guiTop + 68, 950000);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.frozen"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.frozen")) / 2, this.guiTop + 80, 950000);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence()) / 2, this.guiTop + 92, 950000);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%") / 2, this.guiTop + 104, 950000);
                } else {
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.notHatching"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.notHatching")) / 2, this.guiTop + 68, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaCode") + ": " + this.egg.getDNASequence()) / 2, this.guiTop + 80, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.egg.dnaQuality") + ": " + this.egg.getDNAQuality() + "%") / 2, this.guiTop + 92, 14737632);
                }
            }
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void renderEgg(float x, float y, float scale) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 50.0F);
        GL11.glScalef(-scale, scale, scale);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(1.5F * this.renderRotation, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, this.egg.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(this.egg, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
