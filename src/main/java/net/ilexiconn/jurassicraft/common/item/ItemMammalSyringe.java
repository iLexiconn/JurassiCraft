package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantCow;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantHorse;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantPig;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantSheep;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ItemMammalSyringe extends Item {
    public static final HashSet<String> creaturesFromCow = new HashSet<String>(Arrays.asList("mammoth", "arsinoitherium", "basilosaurus", "uintatherium", "paraceratherium", "deinotherium", "leptictidium"));
    public static final HashSet<String> creaturesFromPig = new HashSet<String>(Arrays.asList("mammoth", "arsinoitherium", "basilosaurus", "uintatherium", "paraceratherium", "deinotherium", "leptictidium"));
    public static final HashSet<String> creaturesFromHorse = new HashSet<String>(Arrays.asList("mammoth", "arsinoitherium", "basilosaurus", "uintatherium", "paraceratherium", "deinotherium", "leptictidium"));
    public static final HashSet<String> creaturesFromSheep = new HashSet<String>(Arrays.asList("mammoth", "arsinoitherium", "basilosaurus", "uintatherium", "paraceratherium", "deinotherium", "leptictidium"));
    public String mammalName;

    public ItemMammalSyringe(String mammal) {
        super();
        this.setUnlocalizedName(mammal + "_Syringe");
        String cat = CreatureHandler.getCategoryFromCreatureName(mammal);
        this.setTextureName(JurassiCraft.getModId() + "creatures/" + cat + "/" + mammal.toLowerCase() + "/" + mammal.toLowerCase() + "_Syringe");
        this.setCreativeTab(JCCreativeTabRegistry.syringesEggs);
        this.mammalName = mammal;
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal("entity." + mammalName + ".name") + " " + StatCollector.translateToLocal("item.dino_syringe.name");
    }

    public String getSyringeDNASequence(ItemStack syringe) {
        if (syringe.hasTagCompound()) {
            if (syringe.getTagCompound().hasKey("DNA")) {
                return syringe.getTagCompound().getString("DNA");
            }
        }

        return JurassiCraftDNAHandler.createDefaultDNA();
    }

    public int getSyringeQuality(ItemStack syringe) {
        if (syringe.hasTagCompound()) {
            if (syringe.getTagCompound().hasKey("Quality")) {
                return syringe.getTagCompound().getInteger("Quality");
            }
        }

        return 75;
    }

    public void addInformation(ItemStack syringe, EntityPlayer player, List list, boolean flag) {
        if (!syringe.hasTagCompound()) {
            syringe.stackTagCompound = new NBTTagCompound();
        }

        if (!syringe.getTagCompound().hasKey("DNA")) {
            syringe.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        if (!syringe.getTagCompound().hasKey("Quality")) {
            syringe.getTagCompound().setInteger("Quality", player.capabilities.isCreativeMode ? 100 : 0);
        }

        list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.dna") + ": " + syringe.getTagCompound().getString("DNA"));
        list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("item.dna.info.quality") + ": " + syringe.getTagCompound().getInteger("Quality") + "%");
    }

    public ItemStack onItemRightClick(ItemStack syringe, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && player.isSneaking()) {
            NBTTagCompound compound = syringe.getTagCompound();

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

            syringe.setTagCompound(compound);

            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.qualityChanged") + " " + compound.getInteger("Quality") + "%"));
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.geneticCodeIs") + ": " + compound.getString("DNA")));
            }
        }

        return syringe;
    }

    public boolean itemInteractionForEntity(ItemStack syringe, EntityPlayer player, EntityLivingBase creature) {
        if (!syringe.hasTagCompound() && player.capabilities.isCreativeMode) {
            syringe.stackTagCompound = new NBTTagCompound();
        }

        if (!syringe.getTagCompound().hasKey("DNA") && player.capabilities.isCreativeMode) {
            syringe.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
        }

        if (!syringe.getTagCompound().hasKey("Quality") && player.capabilities.isCreativeMode) {
            syringe.getTagCompound().setInteger("Quality", 0);
        }

        if (!player.capabilities.isCreativeMode) {
            if (creature instanceof EntityAnimal && ((EntityAnimal) creature).getGrowingAge() >= 0) {
                if (!this.setBaby(player.worldObj, player, creature, syringe)) {
                    return false;
                } else {
                    syringe.stackSize--;

                    if (syringe.stackSize <= 0) {
                        syringe = null;
                    }

                    return true;
                }
            }
        } else if (player.capabilities.isCreativeMode && !player.isSneaking()) {
            if (creature instanceof EntityAnimal && ((EntityAnimal) creature).getGrowingAge() >= 0) {
                if (!this.setBaby(player.worldObj, player, creature, syringe)) {
                    return false;
                } else {
                    syringe.stackSize--;

                    if (syringe.stackSize <= 0) {
                        syringe = null;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    private boolean setBaby(World world, EntityPlayer player, EntityLivingBase creature, ItemStack syringe) {
        if (syringe.hasTagCompound() && syringe.getTagCompound().hasKey("SyringeQuality") && syringe.getTagCompound().getInteger("SyringeQuality") >= 50) {
            if (creature instanceof EntityCow) {
                if (!creaturesFromCow.contains(this.mammalName.toLowerCase())) {
                    return false;
                } else {
                    EntityPregnantCow cow = EntityPregnantCow.get(((EntityCow) creature));

                    if (cow != null && cow.getMammalName().equals("noEmbryo")) {
                        cow.setMammalName(this.mammalName);
                        cow.setDNAQuality(this.getSyringeQuality(syringe));
                        cow.setDNASequence(this.getSyringeDNASequence(syringe));
                        cow.setPregnancySpeed(2048);

                        if (!world.isRemote) {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }

                        return true;
                    }
                }
            } else if (creature instanceof EntityPig) {
                if (!creaturesFromPig.contains(this.mammalName.toLowerCase())) {
                    return false;
                } else {
                    EntityPregnantPig pig = EntityPregnantPig.get(((EntityPig) creature));

                    if (pig != null && pig.getMammalName().equals("noEmbryo")) {
                        pig.setMammalName(this.mammalName);
                        pig.setDNAQuality(this.getSyringeQuality(syringe));
                        pig.setDNASequence(this.getSyringeDNASequence(syringe));
                        pig.setPregnancySpeed(2048);

                        if (!world.isRemote) {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }

                        return true;
                    }
                }
            } else if (creature instanceof EntityHorse) {
                if (!creaturesFromHorse.contains(this.mammalName.toLowerCase())) {
                    return false;
                } else {
                    EntityPregnantHorse horse = EntityPregnantHorse.get(((EntityHorse) creature));

                    if (horse != null && horse.getMammalName().equals("noEmbryo")) {
                        horse.setMammalName(this.mammalName);
                        horse.setDNAQuality(this.getSyringeQuality(syringe));
                        horse.setDNASequence(this.getSyringeDNASequence(syringe));
                        horse.setPregnancySpeed(2048);

                        if (!world.isRemote) {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }

                        return true;
                    }
                }
            } else if (creature instanceof EntitySheep) {
                if (!creaturesFromSheep.contains(this.mammalName.toLowerCase())) {
                    return false;
                } else {
                    EntityPregnantSheep sheep = EntityPregnantSheep.get(((EntitySheep) creature));

                    if (sheep != null && sheep.getMammalName().equals("noEmbryo")) {
                        sheep.setMammalName(this.mammalName);
                        sheep.setDNAQuality(this.getSyringeQuality(syringe));
                        sheep.setDNASequence(this.getSyringeDNASequence(syringe));
                        sheep.setPregnancySpeed(2048);

                        if (!world.isRemote) {
                            player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.syringe.info.embryoInseminated")));
                        }

                        return true;
                    }
                }
            }
        } else {
            if (!world.isRemote) {
                player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("item.dna.info.errorQuality")));
            }
        }

        return false;
    }
}
