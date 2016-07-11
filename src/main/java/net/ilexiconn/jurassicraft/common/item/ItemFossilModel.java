package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemFossilModel extends Item {
    public ItemFossilModel(String fossilName) {
        super();
        this.setMaxStackSize(8);
        this.setUnlocalizedName(fossilName + "_Fossil");
        this.setTextureName(JurassiCraft.getModId() + fossilName + "_Fossil");
        this.setCreativeTab(JCCreativeTabRegistry.blocks);
    }

    public int getFossil(ItemStack fossil) {
        if (fossil.hasTagCompound()) {
            if (fossil.getTagCompound().hasKey("FossilID")) {
                return fossil.getTagCompound().getInteger("FossilID");
            }
        }
        return 0;
    }

    public void addInformation(ItemStack fossil, EntityPlayer player, List list, boolean flag) {
        if (fossil.hasTagCompound()) {
            if (fossil.getTagCompound().hasKey("FossilID")) {
                list.add(EnumChatFormatting.GREEN + String.valueOf(fossil.getTagCompound().getInteger("FossilID")));
            }
        }
    }

    public ItemStack onItemRightClick(ItemStack fossil, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && player.isSneaking()) {
            if (fossil.hasTagCompound()) {
                if (fossil.getTagCompound().hasKey("FossilID")) {
                    // PLACE
                }
            }
        }
        return fossil;
    }
}
