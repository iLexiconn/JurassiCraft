package net.ilexiconn.jurassicraft.common.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNACombinator;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDNACombinator extends BlockContainer {
    public BlockDNACombinator() {
        super(Material.iron);
        this.setBlockName("dnaCombinator");
        this.setHardness(3.0f);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.setCreativeTab(JCCreativeTabRegistry.blocks);
        this.setBlockTextureName("iron_block");
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

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else if (!player.isSneaking()) {
            player.openGui(JurassiCraft.instance, 0, world, x, y, z);
            return true;
        }

        return false;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        } else if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        } else if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        } else if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity instanceof TileDNAExtractor) {
            TileDNAExtractor tileEntityDNAExtractor = (TileDNAExtractor) tileEntity;

            if (tileEntityDNAExtractor.hasItems()) {
                for (int i = 0; i < tileEntityDNAExtractor.getSizeInventory(); i++) {
                    ItemStack stack = tileEntityDNAExtractor.getStackInSlot(i);

                    if (stack != null) {
                        float f = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = world.rand.nextFloat() * 0.8F + 0.1F;

                        while (stack.stackSize > 0) {
                            int j = world.rand.nextInt(21) + 10;

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

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        try {
            return new TileDNACombinator();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
