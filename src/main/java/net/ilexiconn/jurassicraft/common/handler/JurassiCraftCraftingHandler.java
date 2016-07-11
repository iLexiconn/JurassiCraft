//package net.ilexiconn.jurassicraft.common.handler;
//
//import cpw.mods.fml.common.eventhandler.SubscribeEvent;
//import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
//import net.minecraft.init.Items;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.item.ItemStack;
//
///**
// * Not working
// */
//public class JurassiCraftCraftingHandler
//{
//    @SubscribeEvent
//    public void onCrafting(ItemCraftedEvent event)
//    {
//        IInventory craftMatrix = event.craftMatrix;
//
//        for (int i = 0; i < craftMatrix.getSizeInventory(); i++)
//        {
//            if (craftMatrix.getStackInSlot(i) != null)
//            {
//                ItemStack item = craftMatrix.getStackInSlot(i);
//
//                if (item != null && item.getItem() == Items.iron_pickaxe)
//                {
//                    ItemStack pickaxe = new ItemStack(Items.iron_pickaxe, 1, (item.getItemDamage() + 1));
//
//                    if (pickaxe.getItemDamage() >= pickaxe.getMaxDamage())
//                    {
//                        pickaxe.stackSize--;
//
//                        if (pickaxe.stackSize <= 0)
//                            pickaxe = null;
//                    }
//
//                    craftMatrix.setInventorySlotContents(i, pickaxe);
//                }
//            }
//        }
//    }
// }
