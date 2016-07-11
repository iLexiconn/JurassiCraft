package net.ilexiconn.jurassicraft.common.container.slot;

import net.ilexiconn.jurassicraft.common.api.IDNASource;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDNASource extends Slot {
    public SlotDNASource(IInventory inventory, int number, int x, int y) {
        super(inventory, number, x, y);
    }

    public int getSlotStackLimit() {
        return 64;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return (itemstack.getItem() instanceof IDNASource);
    }
}