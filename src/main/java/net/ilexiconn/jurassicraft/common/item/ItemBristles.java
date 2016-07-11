package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;

public class ItemBristles extends ItemGenericDNASource {
    public ItemBristles(String name) {
        super(name, "Bristles");
        this.setCreativeTab(JCCreativeTabRegistry.items);
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Bristles");
    }
}
