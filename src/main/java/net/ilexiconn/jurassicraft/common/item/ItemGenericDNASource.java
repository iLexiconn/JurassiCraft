package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IDNASource;
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

public class ItemGenericDNASource extends Item implements IDNASource {
    protected String name;

    public ItemGenericDNASource(String name, String type) {
        super();
        this.setUnlocalizedName(name + "_" + type);
        this.name = name;
        String cat = CreatureHandler.getCategoryFromCreatureName(name);
        this.setTextureName(JurassiCraft.getModId() + "creatures/" + cat.toLowerCase() + "/" + name.toLowerCase() + "/" + name.toLowerCase() + "_" + type);
    }

    public ItemDNA getCorrespondingDNA(String type) {
        Creature creature = CreatureHandler.getCreatureFromName(this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length() - (1 + type.length())));

        if (creature != null)
            return creature.getDNA();
        else
            return null;
    }

    public String getDNASequence(ItemStack drop) {
        if (drop.hasTagCompound()) {
            if (drop.getTagCompound().hasKey("DNA")) {
                return drop.getTagCompound().getString("DNA");
            }
        }

        return StatCollector.translateToLocal("item.dna.info.errorCode");
    }

    public int getQuality(ItemStack drop) {
        if (drop.hasTagCompound()) {
            if (drop.getTagCompound().hasKey("Quality")) {
                return drop.getTagCompound().getInteger("Quality");
            }
        }

        return 0;
    }

    public void addInformation(ItemStack drop, EntityPlayer player, List list, boolean flag) {
        if (drop.hasTagCompound()) {
            if (drop.getTagCompound().hasKey("DNA"))
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + drop.getTagCompound().getString("DNA"));
            else
                list.add(StatCollector.translateToLocal("item.dna.info.none"));

            if (drop.getTagCompound().hasKey("Quality"))
                list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + drop.getTagCompound().getInteger("Quality") + "%");
        } else
            list.add(StatCollector.translateToLocal("item.dna.info.none"));
    }

    public ItemStack onItemRightClick(ItemStack drop, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && player.isSneaking()) {
            NBTTagCompound compound = drop.getTagCompound();

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

            drop.setTagCompound(compound);

            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + compound.getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + compound.getString("DNA")));
            }
        }

        return drop;
    }
}
