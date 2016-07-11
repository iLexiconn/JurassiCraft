package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.container.ContainerSecurityFenceLow;
import net.ilexiconn.jurassicraft.common.message.MessageFence;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowCorner;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.util.HashMap;

@SideOnly(Side.CLIENT)
public class GuiSecurityFenceLow extends GuiContainer {
    private HashMap<Integer, int[]> fenceMap = new HashMap<Integer, int[]>();
    private TileSecurityFenceLowCorner fence;
    private int missingMaterials;
    private String errorMessage;

    public GuiSecurityFenceLow(InventoryPlayer inventoryPlayer, TileSecurityFenceLowCorner entity) {
        super(new ContainerSecurityFenceLow(inventoryPlayer, entity));
        if (entity != null) {
            this.xSize = 256;
            this.ySize = 256;
            this.fence = entity;
        } else {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void initGui() {
        super.initGui();
        this.buttonList.clear();

        // Direction Buttons.
        this.buttonList.add(new GuiButtonFenceGeneric(0, this.guiLeft + 54, this.guiTop + 126, 15, 45, 15, 10));
        this.buttonList.add(new GuiButtonFenceGeneric(1, this.guiLeft + 10, this.guiTop + 78, 15, 0, 10, 15));
        this.buttonList.add(new GuiButtonFenceGeneric(2, this.guiLeft + 54, this.guiTop + 34, 0, 45, 15, 10));
        this.buttonList.add(new GuiButtonFenceGeneric(3, this.guiLeft + 102, this.guiTop + 78, 25, 0, 10, 15));

        // Update Map Button.
        this.buttonList.add(new GuiButtonFenceGeneric(4, this.guiLeft + 23, this.guiTop + 142, 35, 0, 15, 15));

        // Build Fence Button.
        this.buttonList.add(new GuiButton(5, this.guiLeft + 141, this.guiTop + 63, 80, 20, StatCollector.translateToLocal("container.fence.buildFence")));

        // Turn On Off Button.
        this.buttonList.add(new GuiButtonFenceSwitch(6, this.guiLeft + 141, this.guiTop + 86, 89, 0, 80, 54, this.fence.isFenceOn(this.fence.getPlannedSide())));

        // Fixing Button.
        this.buttonList.add(new GuiButton(7, this.guiLeft + 141, this.guiTop + 63, 80, 20, StatCollector.translateToLocal("container.fence.fixFence")));

        this.fenceMap = this.fence.getAllFenceBlocks();
        this.refreshGUI();
    }

    public void onGuiClosed() {
        if (this.fence != null) {
            this.fence = null;
            this.fenceMap.clear();
        }
        super.onGuiClosed();
    }

    public void updateScreen() {
        this.refreshGUI();
    }

    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                ((GuiButton) this.buttonList.get(0)).enabled = false;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                this.fence.setPlannedSide((byte) 0);
                break;
            case 1:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = false;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                this.fence.setPlannedSide((byte) 1);
                break;
            case 2:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = false;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                this.fence.setPlannedSide((byte) 2);
                break;
            case 3:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = false;
                this.fence.setPlannedSide((byte) 3);
                break;
            case 4:
                this.fenceMap = this.fence.getAllFenceBlocks();
                this.refreshGUI();
                break;
            case 5:
                JurassiCraft.network.sendToServer(new MessageFence(0, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getPlannedSide()));
                break;
            case 6:
                JurassiCraft.network.sendToServer(new MessageFence(1, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getPlannedSide()));
                break;
            case 7:
                JurassiCraft.network.sendToServer(new MessageFence(2, this.fence.xCoord, this.fence.yCoord, this.fence.zCoord, this.fence.getPlannedSide()));
                break;
        }

        this.fenceMap = this.fence.getAllFenceBlocks();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        int direction = this.fence.getPlannedSide();

        switch (direction) {
            case 0:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.south"), 71 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.south")) / 2, 146, 4210752);
                break;
            case 1:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.west"), 71 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.west")) / 2, 146, 4210752);
                break;
            case 2:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.north"), 71 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.north")) / 2, 146, 4210752);
                break;
            case 3:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.east"), 71 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.east")) / 2, 146, 4210752);
                break;
            default:
                this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.noDirection"), 71 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.noDirection")) / 2, 146, 4210752);
        }

        if (this.fence.hasFenceAt(direction)) {
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.security.low"), 128 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.security.low")) / 2, 15, 4210752);
        } else {
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.fence.security.low"), 128 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("container.fence.security.none")) / 2, 15, 4210752);
        }

        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 48, 163, 4210752);

        if (this.errorMessage != null) {
            if (this.errorMessage == "container.fence.noIronIngots" || this.errorMessage == "container.fence.noRedstone") {
                this.fontRendererObj.drawString(StatCollector.translateToLocal(this.errorMessage) + " (" + this.missingMaterials + ")", 181 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal(this.errorMessage) + " (" + this.missingMaterials + ")") / 2, 146, 4210752);
            } else {
                this.fontRendererObj.drawString(StatCollector.translateToLocal(this.errorMessage), 181 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal(this.errorMessage)) / 2, 146, 4210752);
            }
        }
    }

    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiSecurityFence.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiSecurityFenceWidgets.png"));

        switch (this.fence.getPlannedSide()) {
            case 0:
                this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 83, 52, 0, 4, 37);
                break;
            case 1:
                this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 83, 52, 0, 37, 4);
                break;
            case 2:
                this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 50, 52, 0, 4, 37);
                break;
            case 3:
                this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 83, 52, 0, 37, 4);
                break;
        }

        if (!this.fenceMap.isEmpty()) {
            for (int i = 0; i < this.fenceMap.size(); i++) {
                this.drawTexturedModalRect(this.guiLeft + 60 + 3 * this.fenceMap.get(i)[0], this.guiTop + 84 + 3 * this.fenceMap.get(i)[1], 50, 0, 2, 2);
            }
        }
    }

    private void refreshSwitchButton() {
        ((GuiButtonFenceSwitch) this.buttonList.get(6)).setState(this.fence.isFenceOn(this.fence.getPlannedSide()));
    }

    private void refreshGUI() {
        switch (this.fence.getPlannedSide()) {
            case 0:
                ((GuiButton) this.buttonList.get(0)).enabled = false;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                break;
            case 1:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = false;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                break;
            case 2:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = false;
                ((GuiButton) this.buttonList.get(3)).enabled = true;
                break;
            case 3:
                ((GuiButton) this.buttonList.get(0)).enabled = true;
                ((GuiButton) this.buttonList.get(1)).enabled = true;
                ((GuiButton) this.buttonList.get(2)).enabled = true;
                ((GuiButton) this.buttonList.get(3)).enabled = false;
                break;
        }
        if (this.fence.hasFenceAt(this.fence.getPlannedSide())) {
            ((GuiButton) this.buttonList.get(5)).visible = false;
            ((GuiButton) this.buttonList.get(6)).enabled = true;
            ((GuiButton) this.buttonList.get(7)).visible = true;

            if (!this.fence.isFenceOn(this.fence.getPlannedSide())) {
                int length = this.fence.getFenceBaseLength(this.fence, this.fence.getPlannedSide());

                if (this.fence.isBaseAtSideValid(this.fence, this.fence.getPlannedSide(), length)) {
                    TileSecurityFenceLowCorner otherFence = this.fence.getNextLowSecurityMainFenceBlockDirectly(this.fence, this.fence.getPlannedSide(), length + 1);

                    int height = this.fence.getSmallerFencePoleHeight(this.fence, otherFence);

                    int numberOfGridsToFix = this.fence.getNumberOfGridsToFix(this.fence, this.fence.getPlannedSide(), length, height);

                    if (numberOfGridsToFix > 0) {
                        int ironRequiredToFix = this.fence.getIronRequiredForGrid(numberOfGridsToFix);

                        if (this.fence.hasNumberOfIronStored(ironRequiredToFix)) {
                            int redstoneRequiredToFix = this.fence.getRedstoneRequiredForGrid(numberOfGridsToFix);

                            if (this.fence.hasNumberOfRedstoneStored(redstoneRequiredToFix)) {
                                ((GuiButton) this.buttonList.get(5)).enabled = false;
                                ((GuiButton) this.buttonList.get(7)).enabled = true;
                                this.refreshSwitchButton();
                                this.missingMaterials = 0;
                                this.errorMessage = null;
                                return;
                            } else {
                                this.errorMessage = "container.fence.noRedstone";
                                this.missingMaterials = redstoneRequiredToFix;
                            }
                        } else {
                            this.errorMessage = "container.fence.noIronIngots";
                            this.missingMaterials = ironRequiredToFix;
                        }
                    } else {
                        this.errorMessage = "container.fence.notBroken";
                        this.missingMaterials = 0;
                    }
                } else {
                    this.errorMessage = "container.fence.baseIsWrong";
                    this.missingMaterials = 0;
                }
            } else {
                this.errorMessage = "container.fence.fenceOn";
                this.missingMaterials = 0;
            }

            ((GuiButton) this.buttonList.get(5)).enabled = false;
            ((GuiButton) this.buttonList.get(7)).enabled = false;
            this.refreshSwitchButton();
        } else {
            ((GuiButton) this.buttonList.get(5)).visible = true;
            ((GuiButton) this.buttonList.get(6)).enabled = false;
            ((GuiButton) this.buttonList.get(7)).visible = false;

            int length = this.fence.getFenceBaseLength(this.fence, this.fence.getPlannedSide());

            if (this.fence.isBaseAtSideValid(this.fence, this.fence.getPlannedSide(), length)) {
                TileSecurityFenceLowCorner otherFence = this.fence.getNextLowSecurityMainFenceBlockDirectly(this.fence, this.fence.getPlannedSide(), length + 1);

                int height = this.fence.getSmallerFencePoleHeight(this.fence, otherFence);

                int numberOfGridsToBuild = this.fence.getNumberOfGridsToBuild(length, height);

                int ironRequiredToBuild = this.fence.getIronRequiredForGrid(numberOfGridsToBuild);

                if (this.fence.hasNumberOfIronStored(ironRequiredToBuild)) {
                    int redstoneRequiredToBuild = this.fence.getRedstoneRequiredForGrid(numberOfGridsToBuild);

                    if (this.fence.hasNumberOfRedstoneStored(redstoneRequiredToBuild)) {
                        if (this.fence.hasEmptySpaceAt(this.fence, this.fence.getPlannedSide(), length, height)) {
                            ((GuiButton) this.buttonList.get(5)).enabled = true;
                            ((GuiButton) this.buttonList.get(6)).enabled = false;
                            this.missingMaterials = 0;
                            this.errorMessage = null;
                            return;
                        } else {
                            this.errorMessage = "container.fence.pathBlocked";
                            this.missingMaterials = 0;
                        }
                    } else {
                        this.errorMessage = "container.fence.noRedstone";
                        this.missingMaterials = redstoneRequiredToBuild;
                    }
                } else {
                    this.errorMessage = "container.fence.noIronIngots";
                    this.missingMaterials = ironRequiredToBuild;
                }
            } else {
                this.errorMessage = "container.fence.baseIsWrong";
                this.missingMaterials = 0;
            }

            ((GuiButton) this.buttonList.get(5)).enabled = false;
            ((GuiButton) this.buttonList.get(7)).enabled = false;
        }
    }
}
