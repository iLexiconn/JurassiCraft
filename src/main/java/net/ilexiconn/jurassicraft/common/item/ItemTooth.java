package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;

public class ItemTooth extends ItemGenericDNASource {
    public ItemTooth(String name) {
        super(name, "Tooth");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Tooth");
    }
}
