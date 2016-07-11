package net.ilexiconn.jurassicraft.common.block.fossil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFossilOre extends Block {
    @SideOnly(Side.CLIENT)
    public IIcon type1;
    @SideOnly(Side.CLIENT)
    public IIcon type2;
    @SideOnly(Side.CLIENT)
    public IIcon type3;
    @SideOnly(Side.CLIENT)
    public IIcon type4;
    @SideOnly(Side.CLIENT)
    public IIcon type5;
    @SideOnly(Side.CLIENT)
    public IIcon type6;

    public BlockFossilOre() {
        super(Material.rock);
        setBlockName("fossil_ore");
        setBlockTextureName(JurassiCraft.getModId() + "fossil_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(JCCreativeTabRegistry.blocks);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
    }

    public Item getItemDropped(int value, Random random, int thing) {
        float rand = random.nextFloat();
        if (rand < 0.20F) {
            return Item.getItemFromBlock(Blocks.stone);
        } else if (rand < 0.5F) {
            return Item.getItemFromBlock(Blocks.cobblestone);
        } else if (rand < 0.70F) {
            return Items.bone;
        } else {
            return JCItemRegistry.fossil;
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        world.setBlockMetadataWithNotify(x, y, z, new Random().nextInt(6), 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        type1 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_0");
        type2 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_1");
        type3 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_2");
        type4 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_3");
        type5 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_4");
        type6 = iconRegister.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_5");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        switch (metadata) {
            case 0:
                return type1;
            case 1:
                return type2;
            case 2:
                return type3;
            case 3:
                return type4;
            case 4:
                return type5;
            case 5:
                return type6;
            default:
                return type1;
        }
    }
}
