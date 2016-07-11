package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantCow;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantHorse;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantPig;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantSheep;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiDinoPadPregnancy extends GuiScreen {
    private EntityAnimal creature;
    private float renderRotation;
    private int guiLeft;
    private int guiTop;
    private int xSize;
    private int ySize;

    public GuiDinoPadPregnancy(Entity entity) {
        super();

        if (entity instanceof EntityAnimal && ((EntityAnimal) entity).getGrowingAge() == 0) {
            if (entity instanceof EntityCow) {
                EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) entity));

                if (cow != null) {
                    this.creature = (EntityCow) entity;
                }
            } else if (entity instanceof EntityPig) {
                EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) entity));

                if (pig != null) {
                    this.creature = (EntityPig) entity;
                }
            } else if (entity instanceof EntityHorse) {
                EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) entity));

                if (horse != null) {
                    this.creature = (EntityHorse) entity;
                }
            } else if (entity instanceof EntitySheep) {
                EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) entity));

                if (sheep != null) {
                    this.creature = (EntitySheep) entity;
                }
            } else {
                this.creature = null;
                this.mc.thePlayer.closeScreen();
            }

            if (this.creature == null) {
                this.mc.thePlayer.closeScreen();
            }
        }
    }

    public void initGui() {
        super.initGui();
        this.xSize = 256;
        this.ySize = 176;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.renderRotation = 0.0F;
    }

    public void onGuiClosed() {
        this.creature = null;
        super.onGuiClosed();
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void keyTyped(char var1, int key) {
        if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.creature = null;
            this.mc.thePlayer.closeScreen();
        }
    }

    public void updateScreen() {
        if (this.creature != null) {
            this.renderRotation++;
            if (!this.creature.isEntityAlive()) {
                this.creature = null;
                this.mc.thePlayer.closeScreen();
            }
        } else {
            this.creature = null;
            this.mc.thePlayer.closeScreen();
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiDinoPadPregnancy.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (this.creature != null && this.creature.isEntityAlive()) {
            this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), 30.0F);

            if (this.creature instanceof EntityCow) {
                EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) this.creature));

                if (cow.getPregnancyProgress() >= cow.getPregnancySpeed()) {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.cow"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.cow")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo")) / 2, this.guiTop + 70, 14737632);
                } else {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 81, 1, 182, cow.getPregnancyProgressScaled(95), 5);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantCow"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantCow")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(cow.getMammalName() + ": " + cow.getPregnancyProgressScaled(100) + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(cow.getMammalName() + ": " + cow.getPregnancyProgressScaled(100) + "%") / 2, this.guiTop + 70, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + cow.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + cow.getDNASequence()) / 2, this.guiTop + 92, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + cow.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + cow.getDNAQuality() + "%") / 2, this.guiTop + 104, 14737632);
                }
            } else if (this.creature instanceof EntityPig) {
                EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) this.creature));

                if (pig.getPregnancyProgress() >= pig.getPregnancySpeed()) {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pig"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pig")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo")) / 2, this.guiTop + 70, 14737632);
                } else {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 81, 1, 182, pig.getPregnancyProgressScaled(95), 5);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantPig"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantPig")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(pig.getMammalName() + ": " + pig.getPregnancyProgressScaled(100) + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(pig.getMammalName() + ": " + pig.getPregnancyProgressScaled(100) + "%") / 2, this.guiTop + 70, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + pig.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + pig.getDNASequence()) / 2, this.guiTop + 92, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + pig.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + pig.getDNAQuality() + "%") / 2, this.guiTop + 104, 14737632);
                }
            } else if (this.creature instanceof EntityHorse) {
                EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) this.creature));

                if (horse.getPregnancyProgress() >= horse.getPregnancySpeed()) {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.horse"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.horse")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo")) / 2, this.guiTop + 70, 14737632);
                } else {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 81, 1, 182, horse.getPregnancyProgressScaled(95), 5);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantHorse"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantHorse")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(horse.getMammalName() + ": " + horse.getPregnancyProgressScaled(100) + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(horse.getMammalName() + ": " + horse.getPregnancyProgressScaled(100) + "%") / 2, this.guiTop + 70, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + horse.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + horse.getDNASequence()) / 2, this.guiTop + 92, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + horse.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + horse.getDNAQuality() + "%") / 2, this.guiTop + 104, 14737632);
                }
            } else if (this.creature instanceof EntitySheep) {
                EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) this.creature));

                if (sheep.getPregnancyProgress() >= sheep.getPregnancySpeed()) {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.sheep"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.sheep")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo"), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.noEmbryo")) / 2, this.guiTop + 70, 14737632);
                } else {
                    this.drawTexturedModalRect(this.guiLeft + 130, this.guiTop + 80, 0, 202, 98, 8);
                    this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 81, 1, 182, sheep.getPregnancyProgressScaled(95), 5);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.pregnantSheep"), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.pregnantSheep")) / 2, this.guiTop + 14, 14737632);
                    this.fontRendererObj.drawString(sheep.getMammalName() + ": " + sheep.getPregnancyProgressScaled(100) + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(sheep.getMammalName() + ": " + sheep.getPregnancyProgressScaled(100) + "%") / 2, this.guiTop + 70, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + sheep.getDNASequence(), this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaCode") + ": " + sheep.getDNASequence()) / 2, this.guiTop + 92, 14737632);
                    this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + sheep.getDNAQuality() + "%", this.guiLeft + 180 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.pregnancy.dnaQuality") + ": " + sheep.getDNAQuality() + "%") / 2, this.guiTop + 104, 14737632);
                }
            }
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void renderCreature(float x, float y, float scale) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 50.0F);
        GL11.glScalef(-scale, scale, scale);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(1.5F * this.renderRotation, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, this.creature.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(this.creature, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
