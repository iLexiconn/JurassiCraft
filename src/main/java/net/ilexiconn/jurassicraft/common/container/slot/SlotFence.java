package net.ilexiconn.jurassicraft.common.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;

public class SlotFence extends Slot {
    public SlotFence(IInventory inventory, int number, int x, int y) {
        super(inventory, number, x, y);
    }

    public int getSlotStackLimit() {
        return 64;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemRedstone || itemstack.getItem().getUnlocalizedName().equals("item.ingotIron");
    }
}