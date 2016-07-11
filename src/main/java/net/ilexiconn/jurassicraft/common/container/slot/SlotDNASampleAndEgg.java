package net.ilexiconn.jurassicraft.common.container.slot;

import net.ilexiconn.jurassicraft.common.api.IDNASample;
import net.ilexiconn.jurassicraft.common.item.ItemEgg;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDNASampleAndEgg extends Slot {
    public SlotDNASampleAndEgg(IInventory inventory, int number, int x, int y) {
        super(inventory, number, x, y);
    }

    public int getSlotStackLimit() {
        return 1;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return (itemstack.getItem() instanceof IDNASample || itemstack.getItem() instanceof ItemEgg);
    }
}