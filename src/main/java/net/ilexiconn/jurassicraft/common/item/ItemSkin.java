package net.ilexiconn.jurassicraft.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemSkin extends ItemGenericDNASource {
    @SideOnly(Side.CLIENT)
    public IIcon maleIcon;

    @SideOnly(Side.CLIENT)
    public IIcon femaleIcon;

    public ItemSkin(String name) {
        super(name, "Skin");
        this.setCreativeTab(JCCreativeTabRegistry.items);
        this.setHasSubtypes(true);
    }

    public ItemDNA getCorrespondingDNA() {
        return this.getCorrespondingDNA("Skin");
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal("entity." + name + ".name") + " " + StatCollector.translateToLocal("item.skin_" + (itemStack.getItemDamage() == 0 ? "male" : "female") + ".name");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int i) {
        return i == 0 ? this.maleIcon : this.femaleIcon;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
        // list.add(new ItemStack(item, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister) {
        this.maleIcon = iIconRegister.registerIcon(JurassiCraft.getModId() + "creatures/" + CreatureHandler.getCategoryFromCreatureName(this.getUnlocalizedName().substring(5, this.getUnlocalizedName().indexOf("_"))).toLowerCase() + "/" + this.getUnlocalizedName().substring(5, this.getUnlocalizedName().indexOf("_")).toLowerCase() + "/" + this.getUnlocalizedName().substring(5, this.getUnlocalizedName().indexOf("_")).toLowerCase() + "_Skin_Male");
        // this.femaleIcon = iIconRegister.registerIcon(JurassiCraft.getModId() + "creature/" + this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length()) + "_Female");
    }
}
