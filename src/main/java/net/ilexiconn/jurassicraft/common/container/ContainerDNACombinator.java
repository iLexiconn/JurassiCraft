package net.ilexiconn.jurassicraft.common.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.api.IDNASample;
import net.ilexiconn.jurassicraft.common.container.slot.SlotDNASample;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNACombinator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerDNACombinator extends Container {
    private TileDNACombinator dnaCombinator;
    private short lastAnalyzeTime;

    public ContainerDNACombinator(InventoryPlayer playerInventory, TileDNACombinator tileEntity) {
        this.dnaCombinator = tileEntity;
        this.addSlotToContainer(new SlotDNASample(dnaCombinator, 0, 55, 20));
        this.addSlotToContainer(new SlotDNASample(dnaCombinator, 1, 105, 20));
        this.addSlotToContainer(new SlotFurnace(playerInventory.player, dnaCombinator, 2, 81, 67));

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
            dnaCombinator.closeInventory();
        }
    }

    public void addCraftingToCrafters(ICrafting crafter) {
        super.addCraftingToCrafters(crafter);
        crafter.sendProgressBarUpdate(this, 0, this.dnaCombinator.getCombinationTime());
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting crafting = (ICrafting) this.crafters.get(i);
            if (this.lastAnalyzeTime != this.dnaCombinator.getCombinationTime()) {
                crafting.sendProgressBarUpdate(this, 0, this.dnaCombinator.getCombinationTime());
            }
        }

        lastAnalyzeTime = dnaCombinator.getCombinationTime();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int amount) {
        if (id == 0) {
            this.dnaCombinator.setCombinationTime((short) amount);
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return dnaCombinator.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotId) {
        if (!entityPlayer.worldObj.isRemote) {
            Slot slot = (Slot) inventorySlots.get(slotId);
            ItemStack stackFinal = null;

            if (slot != null && slot.getHasStack()) {
                ItemStack stackInSlot = slot.getStack();
                stackFinal = stackInSlot.copy();

                if (slotId < 3) {
                    if (!mergeItemStack(stackInSlot, 9, inventorySlots.size(), true)) {
                        return null;
                    }

                    slot.onSlotChange(stackInSlot, stackFinal);
                } else if (slotId >= 3) {
                    if (stackInSlot.getItem() instanceof IDNASample) {
                        if (!mergeItemStack(stackInSlot, 0, 2, false)) {
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