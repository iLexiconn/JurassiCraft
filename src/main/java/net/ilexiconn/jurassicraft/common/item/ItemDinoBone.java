package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.item.Item;

public class ItemDinoBone extends Item {
    public ItemDinoBone() {
        super();
        setUnlocalizedName("dinoBone");
        setTextureName(JurassiCraft.getModId() + "dinoBone");
        setCreativeTab(JCCreativeTabRegistry.items);
    }
}
