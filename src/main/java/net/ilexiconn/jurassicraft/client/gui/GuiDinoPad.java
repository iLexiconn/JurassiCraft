package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.HashMap;

@SideOnly(Side.CLIENT)
public class GuiDinoPad extends GuiScreen {
    private EntityJurassiCraftSmart creature;
    private int xSize;
    private int ySize;
    private int guiLeft;
    private int guiTop;
    private float renderRotation;
    private int pageNumber;
    private HashMap<Integer, String[]> dinoInfo = new HashMap<Integer, String[]>();

    public GuiDinoPad(Entity entity) {
        super();

        if (entity instanceof EntityJurassiCraftSmart) {
            this.creature = (EntityJurassiCraftSmart) entity;
            this.xSize = 256;
            this.ySize = 176;
        } else {
            this.mc.thePlayer.closeScreen();
        }

        if (this.creature == null) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void initGui() {
        this.buttonList.clear();
        this.dinoInfo.clear();

        if (this.creature != null) {
            for (int numberOfPages = 1; numberOfPages <= this.creature.getCreature().getInfoPageCount(); numberOfPages++) {
                this.dinoInfo.put(numberOfPages, this.getCreatureInformation(numberOfPages));
            }

            this.renderRotation = 0.0F;
            this.pageNumber = 0;
            this.guiLeft = (this.width - this.xSize) / 2;
            this.guiTop = (this.height - this.ySize) / 2;

            this.buttonList.add(new GuiButtonDinopad(0, this.guiLeft + (this.xSize - 18) / 2, this.guiTop + 146, 0, 210, 18, 18));
            this.buttonList.add(new GuiButtonDinopad(1, this.guiLeft + (this.xSize - 18) / 2 - 14, this.guiTop + 146, 36, 210, 12, 18));
            this.buttonList.add(new GuiButtonDinopad(2, this.guiLeft + (this.xSize - 18) / 2 + 20, this.guiTop + 146, 60, 210, 12, 18));
        }
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void onGuiClosed() {
        this.creature = null;

        super.onGuiClosed();
    }

    protected void keyTyped(char keyChar, int key) {
        if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void updateScreen() {
        if (this.creature == null) {
            this.mc.thePlayer.closeScreen();
        } else if (!this.creature.isEntityAlive()) {
            this.mc.thePlayer.closeScreen();
        }

        this.renderRotation++;
    }

    public void actionPerformed(GuiButton button) {
        if (this.creature != null) {
            if (button.id == 0) {
                this.pageNumber = 0;
            } else if (button.id == 1) {
                if (this.pageNumber > 0) {
                    this.pageNumber--;
                } else {
                    this.pageNumber = this.creature.getCreature().getInfoPageCount();
                }
            } else if (button.id == 2) {
                if (this.pageNumber < this.creature.getCreature().getInfoPageCount()) {
                    this.pageNumber++;
                } else {
                    this.pageNumber = 0;
                }
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (this.creature != null) {
            this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiDinoPad.png"));
            this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

            switch (this.pageNumber) {
                case 0:
                    this.renderEmptyBars();
                    this.renderStatusBars();

                    if (this.creature.getCreature().getCreatureID() >= 0 && this.creature.getCreatureLength() > this.creature.getCreatureHeight()) {
                        this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), (55.0F / creature.getCreatureLength()) * (0.4F + 0.6F * this.creature.getCreatureLength() / (this.creature.getCreature().getMaxLength())) * 4);
                    } else {
                        this.renderCreature((float) (this.guiLeft + 67), (float) (this.guiTop + 108), (55.0F / creature.getCreatureHeight()) * (0.4F + 0.6F * this.creature.getCreatureHeight() / this.creature.getCreature().getMaxHeight()) * 4);
                    }

                    this.renderNameGenderStrings();
                    this.renderStatusStrings();
                    this.renderTamedStrings();

                    break;
                default:
                    this.renderNameGenderStrings();
                    this.renderCreatureInformation(this.pageNumber);

                    break;
            }
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void renderEmptyBars() {
        this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 55, 0, 202, 98, 8);
        this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 80, 0, 202, 98, 8);
        this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 105, 0, 202, 98, 8);
    }

    private void renderStatusBars() {
        this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 56, 1, 177, this.creature.getCreatureHealthScaled(95), 5);
        this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 81, 1, 182, this.creature.getCreatureAttackScaled(95), 5);
        this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 106, 1, 187, this.creature.getCreatureSpeedScaled(95), 5);
    }

    private void renderNameGenderStrings() {
        if (this.creature.hasCustomNameTag()) {
            this.fontRendererObj.drawString(this.creature.getCustomNameTag() + " (" + this.creature.getCreatureName() + ")", this.guiLeft + 127 - this.fontRendererObj.getStringWidth(this.creature.getCustomNameTag() + "(" + this.creature.getCreatureName() + ")") / 2, this.guiTop + 11, 14737632);
        } else {
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.creature") + ": " + this.creature.getCreatureName(), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.creature") + ": " + this.creature.getCreatureName()) / 2, this.guiTop + 11, 14737632);
        }

        this.fontRendererObj.drawString(this.creature.getCreatureAgeString() + ", " + this.creature.getCreatureGenderString(), this.guiLeft + 127 - this.fontRendererObj.getStringWidth(this.creature.getCreatureAgeString() + ", " + this.creature.getCreatureGenderString()) / 2, this.guiTop + 19, 14737632);
    }

    private void renderStatusStrings() {
        String healthLang = StatCollector.translateToLocal("container.pad.health");
        String attackLang = StatCollector.translateToLocal("container.pad.attack");
        String speedLang = StatCollector.translateToLocal("container.pad.speed");
        String heightLang = StatCollector.translateToLocal("container.pad.height");
        String lengthLang = StatCollector.translateToLocal("container.pad.length");

        String health = healthLang + ": " + String.valueOf(this.creature.getCreatureCurrentHealth() + "/" + this.creature.getCreatureHealth());
        String attack = attackLang + ": " + String.valueOf(this.creature.getCreatureAttack());
        String speed = speedLang + ": " + String.valueOf(this.creature.getCreatureSpeed());
        String height = heightLang + ": " + String.valueOf(this.creature.getCreatureHeight());
        String length = lengthLang + ": " + String.valueOf(this.creature.getCreatureLength());

        this.fontRendererObj.drawString(health, this.guiLeft + 192 - this.fontRendererObj.getStringWidth(health) / 2, this.guiTop + 45, 14737632);
        this.fontRendererObj.drawString(attack, this.guiLeft + 192 - this.fontRendererObj.getStringWidth(attack) / 2, this.guiTop + 70, 14737632);
        this.fontRendererObj.drawString(speed, this.guiLeft + 192 - this.fontRendererObj.getStringWidth(speed) / 2, this.guiTop + 95, 14737632);
        this.fontRendererObj.drawString(height, this.guiLeft + 192 - this.fontRendererObj.getStringWidth(height) / 2, this.guiTop + 116, 14737632);
        this.fontRendererObj.drawString(length, this.guiLeft + 192 - this.fontRendererObj.getStringWidth(length) / 2, this.guiTop + 126, 14737632);
    }

    private void renderTamedStrings() {
        if (this.creature.isTamed()) {
            if (this.creature.getCreature().isRidable() && this.creature.isCreatureAdult()) {
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.owner") + ": " + this.creature.getOwnerName(), this.guiLeft + 67 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.owner") + this.creature.getOwnerName()) / 2, this.guiTop + 112, 14737632);
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.ridable"), this.guiLeft + 67 - this.fontRendererObj.getStringWidth("Ridable") / 2, this.guiTop + 122, 14737632);
            } else {
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.owner") + ": " + this.creature.getOwnerName(), this.guiLeft + 67 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.owner") + ": " + this.creature.getOwnerName()) / 2, this.guiTop + 122, 14737632);
            }
        } else {
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.pad.owner") + ": " + StatCollector.translateToLocal("container.pad.none"), this.guiLeft + 67 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.pad.owner") + ": " + StatCollector.translateToLocal("container.pad.none")) / 2, this.guiTop + 122, 14737632);
        }
    }

    private String[] getCreatureInformation(int page) {
        String info = StatCollector.translateToLocal("container.pad.info." + this.creature.getCreature().getCreatureName() + ".page" + page);
        String[] pageInfo = new String[8];

        if (info != null && info != "") {
            int line = 0;
            int index = 0;

            for (int infoSize = info.length(); infoSize >= 43; line++) {
                index = 43;

                while (!String.valueOf(info.substring(0, index).charAt(index - 1)).equals(" ")) {
                    index--;
                }

                pageInfo[line] = info.substring(0, index - 1);
                info = info.substring(index, infoSize);
                infoSize = info.length();
            }

            pageInfo[line] = info;
        }

        return pageInfo;
    }

    private void renderCreatureInformation(int page) {
        if (this.dinoInfo.containsKey(page)) {
            for (int line = 0; line < this.dinoInfo.get(page).length; line++) {
                this.fontRendererObj.drawString(this.dinoInfo.get(page)[line], this.guiLeft + 128 - this.fontRendererObj.getStringWidth(this.dinoInfo.get(page)[line]) / 2, this.guiTop + 45 + 12 * line, 14737632);
            }
        } else {
            this.fontRendererObj.drawString("Page missing! This is a bug!", this.guiLeft + 128 - this.fontRendererObj.getStringWidth("Page missing! This is a bug!") / 2, this.guiTop + 45, 14737632);
        }
    }

    private void renderCreature(float posX, float posY, float scale) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);

        GL11.glPushMatrix();

        GL11.glTranslatef(posX, posY, 50.0F);
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
