package net.ilexiconn.jurassicraft.common.block.cultivate;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.ISubBlocksBlock;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.item.ItemBlockCultivate;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
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

public class BlockCultivateTop extends Block implements ISubBlocksBlock {
    public static final String[] iconVariationsNames = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };
    public boolean isLit;

    @SideOnly(Side.CLIENT)
    private IIcon[] iconVariations;

    public BlockCultivateTop(boolean lit) {
        super(Material.cactus);
        this.setBlockName("cultivate_top_" + (lit ? "lit" : "idle"));
        this.setBlockTextureName(JurassiCraft.getModId() + "cultivate");
        this.setCreativeTab(null);
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
    public void registerBlockIcons(IIconRegister iconRegister) {
        iconVariations = new IIcon[iconVariationsNames.length];

        for (int i = 0; i < this.iconVariations.length; i++)
            this.iconVariations[i] = iconRegister.registerIcon(this.getTextureName() + "_" + iconVariationsNames[i]);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Item.getItemFromBlock(JCBlockRegistry.cultivateBottomOff);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity instanceof TileCultivate) {
            TileCultivate tileCultivate = (TileCultivate) tileEntity;

            if (tileCultivate.hasItems()) {
                for (int i = 0; i < tileCultivate.getSizeInventory(); i++) {
                    ItemStack stack = tileCultivate.getStackInSlot(i);

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

        super.breakBlock(world, x, y, z, block, metadata);
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
        world.setBlockToAir(x, y - 1, z);
        world.removeTileEntity(x, y - 1, z);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(JCBlockRegistry.cultivateBottomOff);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int damageDropped(int i) {
        return i;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float t, float h, float k) {
        TileEntity tileEntity = world.getTileEntity(x, y - 1, z);

        if (tileEntity instanceof TileCultivate) {
            Block block = world.getBlock(x, y - 1, z);
            int blockMetadata = world.getBlockMetadata(x, y - 1, z);

            return block.onBlockActivated(world, x, y - 1, z, player, blockMetadata, t, h, k);
        }

        return false;
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity) {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[0];

        for (AxisAlignedBB aabb : aabbs) {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp))
                list.add(aabbTmp);
        }
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction) {
        AxisAlignedBB[] aabbs = BlockCultivate.boxes[0];
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
