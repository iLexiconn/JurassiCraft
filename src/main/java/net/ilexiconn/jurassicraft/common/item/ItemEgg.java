package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
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

public class ItemEgg extends Item {
    public String name;

    public ItemEgg(String name) {
        super();
        this.setUnlocalizedName(name + "_Egg");
        this.name = name;
        String cat = CreatureHandler.getCategoryFromCreatureName(name);
        this.setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + name.toLowerCase() + "/" + name.toLowerCase() + "_Egg");
        this.setCreativeTab(JCCreativeTabRegistry.syringesEggs);
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal("entity." + name + ".name") + " " + StatCollector.translateToLocal("item.dino_egg.name");
    }

    public String getEggDNASequence(ItemStack egg) {
        if (egg.hasTagCompound()) {
            if (egg.getTagCompound().hasKey("EggDNA")) {
                return egg.getTagCompound().getString("EggDNA");
            }
        }

        return JurassiCraftDNAHandler.createDefaultDNA();
    }

    public int getEggQuality(ItemStack egg) {
        if (egg.hasTagCompound()) {
            if (egg.getTagCompound().hasKey("EggQuality")) {
                return egg.getTagCompound().getInteger("EggQuality");
            }
        }

        return 75;
    }

    public void addInformation(ItemStack egg, EntityPlayer player, List list, boolean flag) {
        if (!egg.hasTagCompound()) {
            egg.stackTagCompound = new NBTTagCompound();
        }

        if (!egg.getTagCompound().hasKey("EggDNA")) {
            egg.getTagCompound().setString("EggDNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        if (!egg.getTagCompound().hasKey("EggQuality")) {
            egg.getTagCompound().setInteger("EggQuality", player.capabilities.isCreativeMode ? 100 : 0);
        }

        list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + egg.getTagCompound().getString("EggDNA"));
        list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + egg.getTagCompound().getInteger("EggQuality") + "%");
    }

    public ItemStack onItemRightClick(ItemStack egg, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && player.isSneaking()) {
            NBTTagCompound compound = egg.getTagCompound();

            if (compound == null) {
                compound = new NBTTagCompound();
            }

            int quality = 0;

            if (compound.hasKey("EggQuality")) {
                quality = compound.getInteger("EggQuality");
            }

            quality += 25;

            if (quality > 100) {
                quality = 0;
            }

            compound.setInteger("EggQuality", quality);

            compound.setString("EggDNA", JurassiCraftDNAHandler.createDefaultDNA());

            egg.setTagCompound(compound);

            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + compound.getInteger("EggQuality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + compound.getString("EggDNA")));
            }
        }

        return egg;
    }

    public boolean onItemUse(ItemStack egg, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ) {
        if (egg.hasTagCompound() && egg.getTagCompound().hasKey("EggQuality") && egg.getTagCompound().getInteger("EggQuality") >= 50) {
            if (!world.isRemote && !player.capabilities.isCreativeMode) {
                world.spawnEntityInWorld(new EntityDinoEgg(world, CreatureHandler.getCreatureFromName(name), this.getEggQuality(egg), this.getEggDNASequence(egg), 2048, x, y + 1, z));
            } else if (!world.isRemote && !player.isSneaking()) {
                world.spawnEntityInWorld(new EntityDinoEgg(world, CreatureHandler.getCreatureFromName(name), this.getEggQuality(egg), this.getEggDNASequence(egg), 2048, x, y + 1, z));
            } else {
                this.onItemRightClick(egg, world, player);
            }

            egg.stackSize--;

            if (egg.stackSize <= 0)
                egg = null;

            return true;
        } else {
            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.errorQuality")));
            }
        }

        return false;
    }
}
