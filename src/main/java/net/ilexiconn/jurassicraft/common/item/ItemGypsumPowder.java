package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.item.Item;

public class ItemGypsumPowder extends Item {
    public ItemGypsumPowder() {
        super();
        setUnlocalizedName("gypsumPowder");
        setTextureName(JurassiCraft.getModId() + "gypsum_Powder");
        setCreativeTab(JCCreativeTabRegistry.items);
    }
}
