package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiCultivateProcess extends GuiScreen {
    private TileCultivate cultivator;
    private int xSize;
    private int ySize;
    private int guiLeft;
    private int guiTop;

    public GuiCultivateProcess(TileCultivate entity) {
        super();
        this.cultivator = entity;
        this.xSize = 176;
        this.ySize = 107;
    }

    public void updateScreen() {
        if (!this.cultivator.isHatching()) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void keyTyped(char var1, int key) {
        if (key == 1 || key == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void initGui() {
        super.initGui();

        this.buttonList.clear();

        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.buttonList.add(new GuiButton(0, this.guiLeft + (this.xSize - 100) / 2, this.guiTop + 70, 100, 20, StatCollector.translateToLocal("container.cultivator.stopCultivating")));
    }

    public void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            float progress = (float) this.cultivator.getCultivateTimeProgressScaled(100) / 100.0F;
            this.cultivator.cancelHatching(progress);
            this.mc.thePlayer.closeScreen();
        }
    }

    public void drawScreen(int x, int y, float f) {
        this.drawDefaultBackground();
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiCultivateProgress.png"));

        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(this.guiLeft + 13, this.guiTop + 49, 0, 107, this.cultivator.getCultivateTimeProgressScaled(150), 9);

        Creature creature = this.cultivator.getCreature();

        String name;

        if (creature != null) {
            name = creature.getCreatureName();
        } else {
            name = "Unknown";
        }

        String cultivatingLang = StatCollector.translateToLocal("container.cultivator.cultivating");
        String progressLang = StatCollector.translateToLocal("container.cultivator.progress");

        String progress = progressLang + ": " + this.cultivator.getCultivateTimeProgressScaled(100) + "%";
        String cultivating = cultivatingLang + ": " + name;

        this.fontRendererObj.drawString(cultivating, this.guiLeft + (this.xSize - this.fontRendererObj.getStringWidth(cultivating)) / 2, this.guiTop + 10, 4210752);
        this.fontRendererObj.drawString(progress, this.guiLeft + (this.xSize - this.fontRendererObj.getStringWidth(progress)) / 2, this.guiTop + 30, 4210752);

        super.drawScreen(x, y, f);
    }
}
