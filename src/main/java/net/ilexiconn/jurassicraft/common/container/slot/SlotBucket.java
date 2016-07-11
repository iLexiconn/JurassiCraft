package net.ilexiconn.jurassicraft.common.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class SlotBucket extends Slot {
    public SlotBucket(IInventory inventory, int number, int x, int y) {
        super(inventory, number, x, y);
    }

    public int getSlotStackLimit() {
        return 16;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemBucket;
    }
}