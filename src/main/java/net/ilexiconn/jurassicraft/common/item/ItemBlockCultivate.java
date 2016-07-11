package net.ilexiconn.jurassicraft.common.item;

import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivate;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemBlockCultivate extends ItemBlock {
    public String[] colors = { "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };

    public ItemBlockCultivate(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxStackSize(16);
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        String displayName = "";
        for (String color : colors[itemStack.getItemDamage()].split(" "))
            displayName = "tile." + color + "_cultivate" + ".name";
        return StatCollector.translateToLocal(displayName);
    }

    public int getMetadata(int meta) {
        return meta;
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        if (world.getBlock(x, y + 1, z).isReplaceable(world, x, y, z)) {
            super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
            world.setBlock(x, y + 1, z, JCBlockRegistry.cultivateTopOff);
            world.setBlockMetadataWithNotify(x, y + 1, z, world.getBlockMetadata(x, y, z), 2);
            BlockCultivate.setRotation(world, x, y, z, MathHelper.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3);
            return true;
        } else
            return false;
    }
}