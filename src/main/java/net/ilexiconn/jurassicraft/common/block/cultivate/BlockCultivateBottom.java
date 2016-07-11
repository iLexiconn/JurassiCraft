package net.ilexiconn.jurassicraft.common.block.cultivate;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.ISubBlocksBlock;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.item.ItemBlockCultivate;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCultivateBottom extends BlockContainer implements ISubBlocksBlock {
    public static final String[] iconVariationsNames = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };
    public boolean isLit;

    @SideOnly(Side.CLIENT)
    private IIcon[] iconVariations;

    public BlockCultivateBottom(boolean lit) {
        super(Material.cactus);
        this.setBlockName("cultivate_bottom_" + (lit ? "lit" : "idle"));
        this.setBlockTextureName(JurassiCraft.getModId() + "cultivate");
        this.setCreativeTab(lit ? null : JCCreativeTabRegistry.blocks);
        this.setHardness(2.0F);
        this.setBlockBounds(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if (lit)
            setLightLevel(1.0F);
        this.isLit = lit;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return this.iconVariations[metadata];
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < this.iconVariations.length; i++)
            list.add(new ItemStack(item, 1, i));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        iconVariations = new IIcon[iconVariationsNames.length];

        for (int i = 0; i < this.iconVariations.length; i++)
            this.iconVariations[i] = iconRegister.registerIcon(this.getTextureName() + "_" + iconVariationsNames[i]);
    }

    public int damageDropped(int metadata) {
        return metadata;
    }

    public int getRenderType() {
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float t, float h, float k) {
        if (!player.isSneaking()) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);

            if (tileEntity instanceof TileCultivate) {
                TileCultivate tileCultivate = (TileCultivate) tileEntity;

                if (tileCultivate.isUseableByPlayer(player)) {
                    if (!tileCultivate.isHatching()) {
                        if (!world.isRemote) {
                            player.openGui(JurassiCraft.instance, 0, world, x, y, z);
                        }

                        return true;
                    } else {
                        if (world.isRemote) {
                            JurassiCraft.proxy.openCultivatorProgress(tileCultivate);
                        }

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Item.getItemFromBlock(JCBlockRegistry.cultivateBottomOff);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity instanceof TileCultivate) {
            TileCultivate cultivator = (TileCultivate) tileEntity;

            if (cultivator.hasItems()) {
                for (int i = 0; i < cultivator.getSizeInventory(); i++) {
                    ItemStack itemstack = cultivator.getStackInSlot(i);

                    if (itemstack != null) {
                        float f = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = world.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j = world.rand.nextInt(21) + 10;

                            if (j > itemstack.stackSize) {
                                j = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j;

                            EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                            }

                            world.spawnEntityInWorld(item);
                        }
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
        world.setBlockToAir(x, y + 1, z);
        world.removeTileEntity(x, y + 1, z);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(JCBlockRegistry.cultivateBottomOff);
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileCultivate();
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity) {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[1];

        for (AxisAlignedBB aabb : aabbs) {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp))
                list.add(aabbTmp);
        }
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction) {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[1];

        MovingObjectPosition closest = null;

        for (AxisAlignedBB aabb : aabbs) {
            MovingObjectPosition mop = aabb.getOffsetBoundingBox(x, y, z).calculateIntercept(origin, direction);

            if (mop != null) {
                if (closest != null && mop.hitVec.distanceTo(origin) < closest.hitVec.distanceTo(origin))
                    closest = mop;
                else
                    closest = mop;
            }
        }

        if (closest != null) {
            closest.blockX = x;
            closest.blockY = y;
            closest.blockZ = z;
        }

        return closest;
    }

    public Class<? extends ItemBlock> getItemBlockClass() {
        return ItemBlockCultivate.class;
    }
}
