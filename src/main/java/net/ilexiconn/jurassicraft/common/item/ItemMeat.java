package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.IDNASource;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemMeat extends ItemFood implements IDNASource {
    private String name;

    public ItemMeat(String name) {
        super(4, 0.1f, true);
        setPotionEffect(Potion.hunger.id, 30, 0, 0.8F);
        setUnlocalizedName(name + "_Meat");
        this.name = name;

        String category = CreatureHandler.getCategoryFromCreatureName(name);
        setTextureName(JurassiCraft.getModId() + "creatures/" + category + "/" + name.toLowerCase() + "/" + name.toLowerCase() + "_Meat");
        setCreativeTab(JCCreativeTabRegistry.itemsFood);
    }

    public ItemDNA getCorrespondingDNA() {
        Creature creature = CreatureHandler.getCreatureFromName(this.getUnlocalizedName().substring(5, this.getUnlocalizedName().length() - 5));

        if (creature != null)
            return creature.getDNA();
        else
            return null;
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal("entity." + name + ".name") + " " + StatCollector.translateToLocal("item.dino_meat.name");
    }

    public String getDNASequence(ItemStack meat) {
        if (meat.hasTagCompound()) {
            if (meat.getTagCompound().hasKey("DNA")) {
                return meat.getTagCompound().getString("DNA");
            }
        }

        return StatCollector.translateToLocal("item.meat.info.errorCode");
    }

    public int getQuality(ItemStack meat) {
        if (meat.hasTagCompound()) {
            if (meat.getTagCompound().hasKey("Quality")) {
                return meat.getTagCompound().getInteger("Quality");
            }
        }

        return 0;
    }

    public void addInformation(ItemStack meat, EntityPlayer player, List list, boolean flag) {
        NBTTagCompound compound = meat.getTagCompound();

        if (compound == null) {
            compound = new NBTTagCompound();
        }

        if (!compound.hasKey("Quality")) {
            compound.setInteger("Quality", player.capabilities.isCreativeMode ? 100 : 0);
        }

        if (!compound.hasKey("DNA")) {
            compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        if (compound.hasKey("DNA") && compound.hasKey("Quality")) {
            list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + compound.getString("DNA"));
            list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + compound.getInteger("Quality") + "%");
        }

        meat.setTagCompound(compound);
    }

    public ItemStack onItemRightClick(ItemStack meat, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && player.isSneaking()) {
            NBTTagCompound compound = meat.getTagCompound();

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

            meat.setTagCompound(compound);

            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + compound.getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + compound.getString("DNA")));
            }
        }

        return meat;
    }
}
