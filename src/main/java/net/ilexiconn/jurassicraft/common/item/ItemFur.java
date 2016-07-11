package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemFur extends ItemGenericDNASource {
    public ItemFur(String name) {
        super(name, "Fur");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal(CreatureHandler.getCreatureFromId(itemStack.getItemDamage()).getCreatureName()) + " " + StatCollector.translateToLocal("item.dino_fur.name");
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Fur");
    }
}
