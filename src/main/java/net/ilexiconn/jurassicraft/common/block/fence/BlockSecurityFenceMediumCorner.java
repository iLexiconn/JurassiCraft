package net.ilexiconn.jurassicraft.common.block.fence;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowPole;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceMediumCorner;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSecurityFenceMediumCorner extends BlockSecurityFence {
    public BlockSecurityFenceMediumCorner() {
        super(10.0F, 150.0F, 2, "low_Security_Fence_Main");
        this.setCreativeTab(JCCreativeTabRegistry.blocks);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else if (!player.isSneaking()) {
            player.openGui(JurassiCraft.instance, 0, world, x, y, z);
            return true;
        }

        return false;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity instanceof TileSecurityFenceMediumCorner) {
            TileSecurityFenceMediumCorner fence = (TileSecurityFenceMediumCorner) tileEntity;

            if (fence.hasItems() && !world.isRemote) {
                for (int i = 0; i < fence.getSizeInventory(); i++) {
                    ItemStack stack = fence.getStackInSlot(i);

                    if (stack != null) {
                        Random rand = new Random();

                        float f = rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = rand.nextFloat() * 0.8F + 0.1F;

                        while (stack.stackSize > 0) {
                            int j = rand.nextInt(21) + 10;

                            if (j > stack.stackSize) {
                                j = stack.stackSize;
                            }

                            stack.stackSize -= j;

                            EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(stack.getItem(), j, stack.getItemDamage()));

                            if (stack.hasTagCompound()) {
                                item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
                            }

                            world.spawnEntityInWorld(item);
                        }
                    }
                }

                for (int side = 0; side < 4; side++) {
                    if (fence.hasFenceAt(side)) {
                        TileSecurityFenceMediumCorner neighborFence = fence.getNextMediumSecurityCornerFenceBlock(fence, side, 128);
                        if (neighborFence != null) {
                            switch (side) {
                                /** South */
                                case 0:
                                    neighborFence.setFenceAt(2, false);
                                    neighborFence.setFenceOff(2);
                                    break;
                                /** West */
                                case 1:
                                    neighborFence.setFenceAt(3, false);
                                    neighborFence.setFenceOff(3);
                                    break;
                                /** North */
                                case 2:
                                    neighborFence.setFenceAt(0, false);
                                    neighborFence.setFenceOff(0);
                                    break;
                                /** East */
                                case 3:
                                    neighborFence.setFenceAt(1, false);
                                    neighborFence.setFenceOff(1);
                                    break;
                            }
                            neighborFence.getWorldObj().markBlockForUpdate(neighborFence.xCoord, neighborFence.yCoord, neighborFence.zCoord);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }

        tileEntity = world.getTileEntity(x, y + 1, z);

        if (tileEntity instanceof TileSecurityFenceLowPole) {
            world.removeTileEntity(x, y + 1, z);
            world.setBlockToAir(x, y + 1, z);

            if (!world.isRemote)
                this.dropPole(world, new Random(), x, y, z);
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
        return new TileSecurityFenceMediumCorner();
    }
}
