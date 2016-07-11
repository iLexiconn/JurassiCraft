package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IDNASource;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.item.Item;

public class ItemAmber extends Item implements IDNASource {
    public ItemAmber() {
        super();
        setUnlocalizedName("amber");
        setTextureName(JurassiCraft.getModId() + "amber");
        setCreativeTab(JCCreativeTabRegistry.items);
    }
}
