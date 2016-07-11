package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IDNASource;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.item.Item;

public class ItemFossil extends Item implements IDNASource {
    public ItemFossil() {
        super();
        setUnlocalizedName("fossil");
        setTextureName(JurassiCraft.getModId() + "fossil");
        setCreativeTab(JCCreativeTabRegistry.items);
    }
}
