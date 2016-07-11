package net.ilexiconn.jurassicraft.common.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockFossilClayOre extends ItemBlock {
    public static final String[] colors = { "", "brown", "orange", "red", "silver", "white", "yellow" };

    public ItemBlockFossilClayOre(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        String name = "";
        if (!(colors[itemStack.getItemDamage()]).equals("")) {
            for (String item : colors[itemStack.getItemDamage()].replaceAll("_", " ").split(" "))
                name = name + String.valueOf(item.charAt(0)).toUpperCase() + item.substring(1) + " ";
            return name + "Stained Clay Fossil Ore";
        } else {
            return "Clay Fossil Ore";
        }
    }

    public int getMetadata(int meta) {
        return meta;
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z), 2);
        return true;
    }
}
