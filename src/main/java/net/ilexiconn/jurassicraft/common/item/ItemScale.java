package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;

public class ItemScale extends ItemGenericDNASource {
    public ItemScale(String name) {
        super(name, "Scale");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Scale");
    }
}
