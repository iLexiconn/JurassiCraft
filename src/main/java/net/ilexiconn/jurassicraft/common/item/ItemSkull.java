package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemSkull extends ItemGenericDNASource {
    public ItemSkull(String name) {
        super(name, "Skull");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Skull");
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal("entity." + name + ".name") + " " + StatCollector.translateToLocal("item.dino_skull.name");
    }

}
