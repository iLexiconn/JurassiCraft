package net.ilexiconn.jurassicraft.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemSpawnEggJurassiCraft extends Item {
    @SideOnly(Side.CLIENT)
    private IIcon overlay;

    public ItemSpawnEggJurassiCraft() {
        this.setUnlocalizedName("jc_spawn_egg"); // ItemMonsterPlacer
        this.setTextureName("spawn_egg");
        this.setCreativeTab(JCCreativeTabRegistry.spawnEggs);
        this.setHasSubtypes(true);
    }

    public static EntityJurassiCraftCreature spawnCreature(World world, EntityPlayer player, ItemStack egg, double x, double y, double z) {
        Class creatureClass = CreatureHandler.getCreatureFromId(egg.getItemDamage()).getCreatureClass();

        try {
            Entity creatureToSpawn = (Entity) creatureClass.getConstructor(World.class).newInstance(player.worldObj);

            if (creatureToSpawn instanceof EntityJurassiCraftCreature) {
                EntityJurassiCraftCreature creature = (EntityJurassiCraftCreature) creatureToSpawn;
                creature.setGenetics(100, JurassiCraftDNAHandler.createDefaultDNA());
                creature.setPosition(x, y, z);
                creature.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                creature.rotationYawHead = creature.rotationYaw;
                creature.renderYawOffset = creature.rotationYaw;

                if (!player.isSneaking()) {
                    creature.setFullGrowth();
                }

                return creature;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addInformation(ItemStack egg, EntityPlayer player, List info, boolean flag) {
        info.add(StatCollector.translateToLocal("lore.baby_dino.name"));
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal(CreatureHandler.getCreatureFromId(itemStack.getItemDamage()).getCreatureName()) + " " + StatCollector.translateToLocal("item.dino_spawn_egg.name");
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) {
        return p_77618_2_ > 0 ? this.overlay : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_);
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int renderPass) {
        Creature creature = CreatureHandler.getCreatureFromId(stack.getItemDamage());

        return creature != null ? (renderPass == 0 ? creature.getEggPrimaryColor() : creature.getEggSecondaryColor()) : 16777215;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List subtypes) {
        for (Creature creature : CreatureHandler.getCreatures()) {
            if (creature.getAddedItemTypes() != 0) {
                subtypes.add(new ItemStack(item, 1, creature.getCreatureID()));
            }
        }
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int hitX, float hitY, float hitZ, float metadata) {
        if (world.isRemote) {
            return true;
        } else {
            Block block = world.getBlock(x, y, z);
            x += Facing.offsetsXForSide[hitX];
            y += Facing.offsetsYForSide[hitX];
            z += Facing.offsetsZForSide[hitX];

            double yTranslation = 0.0D;

            if (hitX == 1 && block.getRenderType() == 11) {
                yTranslation = 0.5D;
            }

            EntityJurassiCraftCreature creature = spawnCreature(world, player, itemStack, (double) x + 0.5D, (double) y + yTranslation, (double) z + 0.5D);

            if (creature != null) {
                if (creature instanceof EntityLivingBase && itemStack.hasDisplayName()) {
                    creature.setCustomNameTag(itemStack.getDisplayName());
                }

                if (!player.capabilities.isCreativeMode) {
                    itemStack.stackSize--;
                    if (itemStack.stackSize <= 0) {
                        itemStack = null;
                    }
                }

                world.spawnEntityInWorld(creature);
                creature.playLivingSound();
            }

            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this.overlay = iconRegister.registerIcon("spawn_egg_overlay");
    }
}
