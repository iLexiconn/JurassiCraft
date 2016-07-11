package net.ilexiconn.jurassicraft.common.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.item.ItemDinoPad;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class JurassiCraftInteractEvent {
    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event) {
        if (event.entity instanceof EntityPlayer) {
            if (event.target != null) {
                EntityPlayer player = (EntityPlayer) event.entity;
                ItemStack heldItem = player.getHeldItem();

                if (heldItem != null && heldItem.getItem() instanceof ItemDinoPad)
                    JurassiCraft.proxy.openDinoPad(event.target);
            }
        }
    }
}