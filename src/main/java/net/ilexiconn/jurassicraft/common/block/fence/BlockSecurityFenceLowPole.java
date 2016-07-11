package net.ilexiconn.jurassicraft.common.block.fence;

import net.ilexiconn.jurassicraft.common.api.IFenceGrid;
import net.ilexiconn.jurassicraft.common.api.IFencePole;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowPole;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSecurityFenceLowPole extends BlockSecurityFence implements IFencePole {
    public BlockSecurityFenceLowPole() {
        super(7.5F, 112.5F, 2, "low_Security_Fence_Pole");
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
        this.setCreativeTab(JCCreativeTabRegistry.blocks);
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

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        if (world.getBlock(x, y + 1, z) instanceof IFencePole) {
            if (world.getTileEntity(x, y + 1, z) != null)
                world.removeTileEntity(x, y + 1, z);

            world.setBlockToAir(x, y + 1, z);

            if (!world.isRemote)
                this.dropPole(world, new Random(), x, y, z);
        }

        if (world.getBlock(x, y, z + 1) instanceof IFenceGrid) {
            if (world.getTileEntity(x, y, z + 1) != null)
                world.removeTileEntity(x, y, z + 1);

            world.setBlockToAir(x, y, z + 1);
        }

        if (world.getBlock(x - 1, y, z) instanceof IFenceGrid) {
            if (world.getTileEntity(x - 1, y, z) != null)
                world.removeTileEntity(x - 1, y, z);

            world.setBlockToAir(x - 1, y, z);
        }

        if (world.getBlock(x, y, z - 1) instanceof IFenceGrid) {
            if (world.getTileEntity(x, y, z - 1) != null)
                world.removeTileEntity(x, y, z - 1);

            world.setBlockToAir(x, y, z - 1);
        }

        if (world.getBlock(x + 1, y, z) instanceof IFenceGrid) {
            if (world.getTileEntity(x + 1, y, z) != null)
                world.removeTileEntity(x + 1, y, z);

            world.setBlockToAir(x + 1, y, z);
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }

    public void dropPole(World world, Random rand, int x, int y, int z) {
        float xRand = rand.nextFloat() * 0.8F + 0.1F;
        float yRand = rand.nextFloat() * 0.8F + 0.1F;
        float zRand = rand.nextFloat() * 0.8F + 0.1F;

        world.spawnEntityInWorld(new EntityItem(world, (double) ((float) x + xRand), (double) ((float) y + yRand), (double) ((float) z + zRand), new ItemStack(JCBlockRegistry.securityFenceLowPole, 1, 0)));
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileSecurityFenceLowPole();
    }
}
