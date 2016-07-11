package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.container.ContainerCultivate;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiCultivate extends GuiContainer {
    private TileCultivate cultivator;

    public GuiCultivate(InventoryPlayer inventoryPlayer, TileCultivate entity) {
        super(new ContainerCultivate(inventoryPlayer, entity));
        this.cultivator = entity;
        this.xSize = 352;
        this.ySize = 188;
    }

    public void updateScreen() {
        if (this.cultivator.isHatching()) {
            this.mc.thePlayer.closeScreen();
            this.mc.displayGuiScreen(new GuiCultivateProcess(cultivator));
        }
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Cultivate"), this.xSize * 3 / 8 - this.fontRendererObj.getStringWidth("Cultivate") / 2 - 1, 20, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Proximates"), 200, 48, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Minerals"), 200, 74, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Vitamins"), 200, 100, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("Lipids"), 200, 126, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiCultivateLeft.png"));
        drawTexturedModalRect(this.width / 2 - xSize / 2, this.height / 2 - ySize / 2, 0, 0, 176, 188);

        int water = this.cultivator.getWaterStoredProgressScaled(67);
        this.drawTexturedModalRect(guiLeft + 48, guiTop + 18, 0, 188, 42, 67 - water);

        mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiCultivateRight.png"));
        drawTexturedModalRect(this.width / 2 + 1, this.height / 2 - ySize / 2, 0, 0, 176, 166);

        int proximates = this.cultivator.getProximateBarScaled(150);
        this.drawTexturedModalRect(guiLeft + 190, guiTop + 56, 0, 166, proximates, 9);

        int minerals = this.cultivator.getMineralBarScaled(150);
        this.drawTexturedModalRect(guiLeft + 190, guiTop + 82, 0, 175, minerals, 9);

        int vitamins = this.cultivator.getVitaminBarScaled(150);
        this.drawTexturedModalRect(guiLeft + 190, guiTop + 108, 0, 184, vitamins, 9);

        int lipids = this.cultivator.getLipidBarScaled(150);
        this.drawTexturedModalRect(guiLeft + 190, guiTop + 134, 0, 193, lipids, 9);
    }
}