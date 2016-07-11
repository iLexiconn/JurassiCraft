package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;

public class ItemFeather extends ItemGenericDNASource {
    public ItemFeather(String name) {
        super(name, "Feather");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Feather");
    }
}
