package net.ilexiconn.jurassicraft.common.block.fossil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.api.ISubBlocksBlock;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.item.ItemBlockFossilClayOre;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockFossilClayOre extends Block implements ISubBlocksBlock {
    public static final String[] colors = { "", "brown", "orange", "red", "silver", "white", "yellow" };

    @SideOnly(Side.CLIENT)
    public IIcon[] type1;
    @SideOnly(Side.CLIENT)
    public IIcon[] type2;
    @SideOnly(Side.CLIENT)
    public IIcon[] type3;
    @SideOnly(Side.CLIENT)
    public IIcon[] type4;
    @SideOnly(Side.CLIENT)
    public IIcon[] type5;
    @SideOnly(Side.CLIENT)
    public IIcon[] type6;

    public BlockFossilClayOre() {
        super(Material.clay);

        setBlockName("fossil_clay_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(JCCreativeTabRegistry.blocks);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
    }

    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float f, int side) {
        if (!world.isRemote) {
            ArrayList<ItemStack> items = getDrops(world, x, y, z, side, metadata);
            /** Sets the correct color for the clay block */
            if (items.get(0).getItem() == Item.getItemFromBlock(Blocks.stained_hardened_clay)) {
                items.clear();
                switch (metadata) {
                    case 0:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 0));
                        break;
                    case 1:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 1));
                        break;
                    case 2:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 2));
                        break;
                    case 3:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 14));
                        break;
                    case 4:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 8));
                        break;
                    default:
                        items.add(new ItemStack(Blocks.stained_hardened_clay, 1, 0));
                        break;
                }
            }

            f = ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, side, metadata, f, false, harvesters.get());

            for (ItemStack item : items) {
                if (world.rand.nextFloat() <= f) {
                    this.dropBlockAsItem(world, x, y, z, item);
                }
            }
        }
    }

    public Item getItemDropped(int metadata, Random random, int thing) {
        float rand = random.nextFloat();

        if (rand < 0.5F) {
            return Item.getItemFromBlock(Blocks.stained_hardened_clay);
        } else if (rand < 0.75F) {
            return Items.bone;
        } else {
            return JCItemRegistry.fossil;
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0:
                return type1[meta];
            case 1:
                return type2[meta];
            case 2:
                return type3[meta];
            case 3:
                return type4[meta];
            case 4:
                return type5[meta];
            case 5:
                return type6[meta];
            default:
                return type1[meta];
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
        list.add(new ItemStack(item, 1, 4));
        list.add(new ItemStack(item, 1, 5));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        this.type1 = new IIcon[colors.length];
        this.type2 = new IIcon[colors.length];
        this.type3 = new IIcon[colors.length];
        this.type4 = new IIcon[colors.length];
        this.type5 = new IIcon[colors.length];
        this.type6 = new IIcon[colors.length];

        for (int i = 0; i < this.type1.length; ++i) {
            if (!(colors[i].equals(""))) {
                this.type1[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_0_hardened_clay_stained_" + colors[i]);
                this.type2[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_1_hardened_clay_stained_" + colors[i]);
                this.type3[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_2_hardened_clay_stained_" + colors[i]);
                this.type4[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_3_hardened_clay_stained_" + colors[i]);
                this.type5[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_4_hardened_clay_stained_" + colors[i]);
                this.type6[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_5_hardened_clay_stained_" + colors[i]);
            } else {
                this.type1[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_0_hardened_clay");
                this.type2[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_1_hardened_clay");
                this.type3[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_2_hardened_clay");
                this.type4[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_3_hardened_clay");
                this.type5[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_4_hardened_clay");
                this.type6[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_5_hardened_clay");
            }
        }
    }

    public Class<? extends ItemBlock> getItemBlockClass() {
        return ItemBlockFossilClayOre.class;
    }
}
