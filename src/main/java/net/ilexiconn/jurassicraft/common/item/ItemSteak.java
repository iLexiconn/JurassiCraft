package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSteak extends ItemFood {
    private String name;

    public ItemSteak(String name) {
        super(8, 0.2f, true);
        setUnlocalizedName(name + "_Steak");
        this.name = name;
        String cat = CreatureHandler.getCategoryFromCreatureName(name);
        setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + name.toLowerCase() + "/" + name.toLowerCase() + "_Steak");
        setCreativeTab(JCCreativeTabRegistry.itemsFood);
    }

    public void addInformation(ItemStack meat, EntityPlayer player, List list, boolean flag) {
        list.add(StatCollector.translateToLocal("item.dna.info.none"));
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal("entity." + name + ".name") + " " + StatCollector.translateToLocal("item.dino_steak.name");
    }
}
