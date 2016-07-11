package net.ilexiconn.jurassicraft.common.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.api.IDNASource;
import net.ilexiconn.jurassicraft.common.container.slot.SlotDNASource;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerDNAExtractor extends Container {
    private TileDNAExtractor dnaExtractor;
    private short lastAnalyzeTime;

    public ContainerDNAExtractor(InventoryPlayer playerInventory, TileDNAExtractor tileEntity) {
        this.dnaExtractor = tileEntity;
        this.addSlotToContainer(new SlotDNASource(dnaExtractor, 0, 29, 29));
        this.addSlotToContainer(new SlotDNASource(dnaExtractor, 1, 47, 29));
        this.addSlotToContainer(new SlotDNASource(dnaExtractor, 2, 29, 47));
        this.addSlotToContainer(new SlotDNASource(dnaExtractor, 3, 47, 47));
        this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 4, 113, 29));
        this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 5, 131, 29));
        this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 6, 113, 47));
        this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaExtractor, 7, 131, 47));

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 9; k++) {
                this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 164));
        }
    }

    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);

        if (!player.worldObj.isRemote) {
            dnaExtractor.closeInventory();
        }
    }

    public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.dnaExtractor.getExtractionTime());
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting crafting = (ICrafting) this.crafters.get(i);

            if (this.lastAnalyzeTime != this.dnaExtractor.getExtractionTime()) {
                crafting.sendProgressBarUpdate(this, 0, this.dnaExtractor.getExtractionTime());
            }
        }

        lastAnalyzeTime = dnaExtractor.getExtractionTime();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int time) {
        if (id == 0) {
            this.dnaExtractor.setExtractionTime((short) time);
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return dnaExtractor.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int itemSlot) {
        if (!player.worldObj.isRemote) {
            Slot slot = (Slot) inventorySlots.get(itemSlot);
            ItemStack stackFinal = null;

            if (slot != null && slot.getHasStack()) {
                ItemStack stackInSlot = slot.getStack();
                stackFinal = stackInSlot.copy();

                if (itemSlot < 8) {
                    if (!mergeItemStack(stackInSlot, 9, inventorySlots.size(), true)) {
                        return null;
                    }

                    slot.onSlotChange(stackInSlot, stackFinal);
                } else if (itemSlot >= 8) {
                    if (stackInSlot.getItem() instanceof IDNASource) {
                        if (!mergeItemStack(stackInSlot, 0, 4, false)) {
                            return null;
                        }
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }

                if (stackInSlot.stackSize == 0) {
                    slot.putStack(null);
                } else {
                    slot.onSlotChanged();
                }

                return stackFinal;
            }

            return null;
        }

        return null;
    }
}