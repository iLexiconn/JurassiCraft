package net.ilexiconn.jurassicraft.common.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.container.slot.SlotBucket;
import net.ilexiconn.jurassicraft.common.container.slot.SlotDNASampleAndEgg;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftFoodNutrients;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class ContainerCultivate extends Container {
    private TileCultivate cultivator;
    private int lastWaterStored;
    private int lastProximateValue;
    private int lastMineralsValue;
    private int lastVitaminsValue;
    private int lastLipidsValue;

    public ContainerCultivate(InventoryPlayer inventory, TileCultivate tileEntity) {
        this.cultivator = tileEntity;

        this.addSlotToContainer(new SlotBucket(cultivator, 0, 12, 20));
        this.addSlotToContainer(new SlotBucket(cultivator, 1, 12, 68));
        this.addSlotToContainer(new SlotDNASampleAndEgg(cultivator, 2, 122, 44));
        this.addSlotToContainer(new Slot(cultivator, 3, 208, 20));

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 9; k++) {
                this.addSlotToContainer(new Slot(inventory, k + i * 9 + 9, k * 18 + 8, i * 18 + 106));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, i * 18 + 8, 164));
        }
    }

    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);

        if (!player.worldObj.isRemote) {
            cultivator.closeInventory();
        }
    }

    public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);

        crafting.sendProgressBarUpdate(this, 0, this.cultivator.getWaterStored());
        crafting.sendProgressBarUpdate(this, 1, this.cultivator.getProximateValue());
        crafting.sendProgressBarUpdate(this, 2, this.cultivator.getMineralValue());
        crafting.sendProgressBarUpdate(this, 3, this.cultivator.getVitaminValue());
        crafting.sendProgressBarUpdate(this, 4, this.cultivator.getLipidValue());
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (Object obj : crafters) {
            ICrafting crafter = (ICrafting) obj;

            if (this.lastWaterStored != this.cultivator.getWaterStored()) {
                crafter.sendProgressBarUpdate(this, 0, this.cultivator.getWaterStored());
            }

            if (this.lastProximateValue != this.cultivator.getProximateValue()) {
                crafter.sendProgressBarUpdate(this, 1, this.cultivator.getProximateValue());
            }

            if (this.lastMineralsValue != this.cultivator.getMineralValue()) {
                crafter.sendProgressBarUpdate(this, 2, this.cultivator.getMineralValue());
            }

            if (this.lastVitaminsValue != this.cultivator.getVitaminValue()) {
                crafter.sendProgressBarUpdate(this, 3, this.cultivator.getVitaminValue());
            }

            if (this.lastLipidsValue != this.cultivator.getLipidValue()) {
                crafter.sendProgressBarUpdate(this, 4, this.cultivator.getLipidValue());
            }
        }

        lastWaterStored = cultivator.getWaterStored();
        lastProximateValue = cultivator.getProximateValue();
        lastMineralsValue = cultivator.getMineralValue();
        lastVitaminsValue = cultivator.getVitaminValue();
        lastLipidsValue = cultivator.getLipidValue();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int amount) {
        if (id == 0) {
            this.cultivator.setWaterStored((byte) amount);
        }

        if (id == 1) {
            this.cultivator.setProximateValue((short) amount);
        }

        if (id == 2) {
            this.cultivator.setMineralValue((short) amount);
        }

        if (id == 3) {
            this.cultivator.setVitaminValue((short) amount);
        }

        if (id == 4) {
            this.cultivator.setLipidValue((short) amount);
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return cultivator.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        if (!player.worldObj.isRemote) {
            Slot slot = (Slot) inventorySlots.get(i);
            ItemStack stackFinal = null;

            if (slot != null && slot.getHasStack()) {
                ItemStack stackInSlot = slot.getStack();

                stackFinal = stackInSlot.copy();

                if (i < 4) {
                    if (!mergeItemStack(stackInSlot, 4, inventorySlots.size(), true)) {
                        return null;
                    }

                    slot.onSlotChange(stackInSlot, stackFinal);
                } else if (i >= 4) {
                    if (stackInSlot.getItem() instanceof ItemBucket) {
                        if (!mergeItemStack(stackInSlot, 0, 2, false)) {
                            return null;
                        }
                    } else if (JurassiCraftFoodNutrients.FOODLIST.containsKey(stackInSlot.getItem())) {
                        if (!mergeItemStack(stackInSlot, 3, 4, false)) {
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