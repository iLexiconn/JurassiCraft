package net.ilexiconn.jurassicraft.common.block.fence;

import net.ilexiconn.jurassicraft.common.api.IFenceGrid;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceMediumGrid;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSecurityFenceMediumGrid extends BlockSecurityFence implements IFenceGrid {
    public BlockSecurityFenceMediumGrid() {
        super(5.0F, 75.0F, 2, "low_Security_Fence_Grid");
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
        switch (metadata) {
            /** South and North (On/Off) */
            case 0:
            case 2:
            case 4:
            case 6:
                if (world.getBlock(x - 1, y, z) instanceof BlockSecurityFenceMediumGrid) {
                    if (world.getTileEntity(x - 1, y, z) != null)
                        world.removeTileEntity(x - 1, y, z);

                    world.setBlockToAir(x - 1, y, z);
                }

                if (world.getBlock(x + 1, y, z) instanceof BlockSecurityFenceMediumGrid) {
                    if (world.getTileEntity(x + 1, y, z) != null)
                        world.removeTileEntity(x + 1, y, z);

                    world.setBlockToAir(x + 1, y, z);
                }

                break;
            /** West and East (On/Off) */
            case 1:
            case 3:
            case 5:
            case 7:
                if (world.getBlock(x, y, z + 1) instanceof BlockSecurityFenceMediumGrid) {
                    if (world.getTileEntity(x, y, z + 1) != null)
                        world.removeTileEntity(x, y, z + 1);

                    world.setBlockToAir(x, y, z + 1);
                }

                if (world.getBlock(x, y, z - 1) instanceof BlockSecurityFenceMediumGrid) {
                    if (world.getTileEntity(x, y, z - 1) != null)
                        world.removeTileEntity(x, y, z - 1);

                    world.setBlockToAir(x, y, z - 1);
                }

                break;
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        double widthInPixels = 6 * 0.03125D;
        int metadata = world.getBlockMetadata(x, y, z);

        switch (metadata) {
            /** South and North (On/Off) */
            case 0:
            case 2:
            case 4:
            case 6:
                return AxisAlignedBB.getBoundingBox((double) x, (double) y, z + 0.5D - widthInPixels, x + 1.0D, y + 1.0D, z + 0.5D + widthInPixels);
            /** West and East (On/Off) */
            case 1:
            case 3:
            case 5:
            case 7:
                return AxisAlignedBB.getBoundingBox(x + 0.5D - widthInPixels, (double) y, (double) z, x + 0.5D + widthInPixels, y + 1.0D, z + 1.0D);
            default:
                return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, x + 1.0D, y + 1.0D, z + 1.0D);
        }
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        double widthInPixels = 6 * 0.03125D;
        int metadata = world.getBlockMetadata(x, y, z);
        switch (metadata) {
            /** South and North (On/Off) */
            case 0:
            case 2:
            case 4:
            case 6:
                return AxisAlignedBB.getBoundingBox((double) x, (double) y, z + 0.5D - widthInPixels, x + 1.0D, y + 1.0D, z + 0.5D + widthInPixels);
            /** West and East (On/Off) */
            case 1:
            case 3:
            case 5:
            case 7:
                return AxisAlignedBB.getBoundingBox(x + 0.5D - widthInPixels, (double) y, (double) z, x + 0.5D + widthInPixels, y + 1.0D, z + 1.0D);
            default:
                return AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, x + 1.0D, y + 1.0D, z + 1.0D);
        }
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        int metadata = world.getBlockMetadata(x, y, z);

        if (metadata == 4 || metadata == 5 || metadata == 6 || metadata == 7)
            entity.attackEntityFrom(DamageSource.generic, 4.0F);
    }

    public int quantityDropped(Random rand) {
        return 0;
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileSecurityFenceMediumGrid();
    }
}
