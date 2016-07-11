package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.container.ContainerDNAExtractor;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiDNAExtractor extends GuiContainer {
    private TileDNAExtractor dnaExtractor;

    public GuiDNAExtractor(InventoryPlayer inventoryPlayer, TileDNAExtractor tileEntity) {
        super(new ContainerDNAExtractor(inventoryPlayer, tileEntity));
        this.dnaExtractor = tileEntity;
        this.xSize = 176;
        this.ySize = 188;
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.dnaExtractor"), this.xSize - this.fontRendererObj.getStringWidth("container.dnaExtractor"), 7, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiDNAExtractor.png"));
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        int i = this.dnaExtractor.getExtractionProgressScaled(22);
        this.drawTexturedModalRect(guiLeft + 77, guiTop + 38, 176, 0, i, 17);
    }
}
