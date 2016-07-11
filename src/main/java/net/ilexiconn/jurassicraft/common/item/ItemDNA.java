package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IDNASample;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemDNA extends Item implements IDNASample {
    private String name;

    public ItemDNA(String name) {
        super();
        this.name = name;
        String category = CreatureHandler.getCategoryFromCreatureName(name);
        setUnlocalizedName(name.toLowerCase() + "_DNA");
        setTextureName(JurassiCraft.getModId() + "creatures/" + category.toLowerCase() + "/" + name.toLowerCase() + "/" + name.toLowerCase() + "_DNA");
        setCreativeTab(JCCreativeTabRegistry.dnas);
    }

    public String getItemStackDisplayName(ItemStack stack) {
        return StatCollector.translateToLocal("entity." + name + ".name") + " " + StatCollector.translateToLocal("item.dino_dna.name");
    }

    public Item getCorrespondingEggOrSyringe() {
        Creature creature = CreatureHandler.getCreatureFromDNA(this);

        if (creature.getEgg() != null) {
            return creature.getEgg();
        } else if (creature.getMammalSyringe() != null) {
            return creature.getMammalSyringe();
        } else {
            return null;
        }
    }

    public String getDNASequence(ItemStack dnaSample) {
        if (!dnaSample.hasTagCompound()) {
            dnaSample.stackTagCompound = new NBTTagCompound();
        }

        if (!dnaSample.getTagCompound().hasKey("DNA")) {
            dnaSample.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        if (!dnaSample.getTagCompound().hasKey("Quality")) {
            dnaSample.getTagCompound().setInteger("Quality", 50);
        }

        if (dnaSample.hasTagCompound()) {
            if (dnaSample.getTagCompound().hasKey("DNA")) {
                return dnaSample.getTagCompound().getString("DNA");
            }
        }

        return StatCollector.translateToLocal("item.dna.info.errorCode");
    }

    public int getQuality(ItemStack dnaSample) {
        if (!dnaSample.hasTagCompound()) {
            dnaSample.stackTagCompound = new NBTTagCompound();
        }

        if (!dnaSample.getTagCompound().hasKey("DNA")) {
            dnaSample.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        if (!dnaSample.getTagCompound().hasKey("Quality")) {
            dnaSample.getTagCompound().setInteger("Quality", 50);
        }

        if (dnaSample.hasTagCompound()) {
            if (dnaSample.getTagCompound().hasKey("Quality")) {
                return dnaSample.getTagCompound().getInteger("Quality");
            }
        }

        return 0;
    }

    public void addInformation(ItemStack dnaSample, EntityPlayer player, List list, boolean flag) {
        if (!dnaSample.hasTagCompound()) {
            dnaSample.stackTagCompound = new NBTTagCompound();
        }

        if (!dnaSample.getTagCompound().hasKey("Quality")) {
            dnaSample.getTagCompound().setInteger("Quality", player.capabilities.isCreativeMode ? 100 : 0);
        }

        if (!dnaSample.getTagCompound().hasKey("DNA")) {
            dnaSample.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + dnaSample.getTagCompound().getString("DNA"));

        if (!dnaSample.getTagCompound().hasKey("Quality") && player.capabilities.isCreativeMode) {
            dnaSample.getTagCompound().setInteger("Quality", 100);
        }

        list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + dnaSample.getTagCompound().getInteger("Quality") + "%");
    }

    public ItemStack onItemRightClick(ItemStack dnaSample, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && player.isSneaking()) {
            NBTTagCompound compound = dnaSample.getTagCompound();

            if (compound == null) {
                compound = new NBTTagCompound();
            }

            int quality = 0;

            if (compound.hasKey("Quality")) {
                quality = compound.getInteger("Quality");
            }

            quality += 25;

            if (quality > 100) {
                quality = 0;
            }

            compound.setInteger("Quality", quality);

            compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

            dnaSample.setTagCompound(compound);

            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + compound.getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + compound.getString("DNA")));
            }
        }

        return dnaSample;
    }
}
