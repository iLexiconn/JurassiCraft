package net.ilexiconn.jurassicraft.common.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.ilexiconn.jurassicraft.common.tileentity.TileDinoPad;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDinoPad extends Block implements ITileEntityProvider {
    public BlockDinoPad() {
        super(Material.iron);
        this.setTickRandomly(true);
        this.setBlockName("dinoPad");
        this.setHardness(0.0F);
        this.setResistance(0.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.2F, 0.9F);
        this.setBlockTextureName(JurassiCraft.getModId() + "dinopad");
    }

    public boolean hasTileEntity(int metadata) {
        return true;
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int quantityDropped(int metadata, int fortune, Random random) {
        return 0;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);

            if (tileEntity instanceof TileDinoPad) {
                Random rand = new Random();

                float x1 = rand.nextFloat() * 0.8F + 0.1F;
                float y1 = rand.nextFloat() * 0.8F + 0.1F;
                float z1 = rand.nextFloat() * 0.8F + 0.1F;

                ItemStack stack = new ItemStack(JCItemRegistry.dinoPad);

                EntityItem planks = new EntityItem(world, (double) ((float) x + x1), (double) ((float) y + y1), (double) ((float) z + z1), stack);
                world.spawnEntityInWorld(planks);
            }
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.getHeldItem() != null) {
            return false;
        } else {
            world.removeTileEntity(x, y, z);
            world.setBlockToAir(x, y, z);
            player.inventory.addItemStackToInventory(new ItemStack(JCItemRegistry.dinoPad, 1));

            return true;
        }
    }

    public void updateTick(World world, int x, int y, int z, Random rand) {
        this.canBlockStay(world, x, y, z);
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!this.canBlockStay(world, x, y, z)) {
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(JCItemRegistry.dinoPad, 1)));
            world.removeTileEntity(x, y, z);
            world.setBlockToAir(x, y, z);
        }
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        return world.getBlock(x, y - 1, z).getMaterial().isSolid();
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        try {
            return new TileDinoPad();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
