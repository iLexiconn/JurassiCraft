package net.ilexiconn.jurassicraft.common.block.fossil;

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

public class BlockFossilSandstoneOre extends Block {
    protected IIcon[] topIcons = new IIcon[6];
    protected IIcon[] normalIcons = new IIcon[6];
    protected IIcon[] bottomIcons = new IIcon[6];

    public BlockFossilSandstoneOre() {
        super(Material.rock);
        setBlockName("fossil_sandstone_ore");
        setBlockTextureName(JurassiCraft.getModId() + "fossil_sandstone_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(JCCreativeTabRegistry.blocks);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
    }

    public Item getItemDropped(int value, Random random, int thing) {
        float rand = random.nextFloat();

        if (rand < 0.25F)
            return Item.getItemFromBlock(Blocks.sandstone);
        else if (rand < 0.5F)
            return Item.getItemFromBlock(Blocks.sand);
        else if (rand < 0.75F)
            return Items.bone;
        else
            return JCItemRegistry.fossil;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        world.setBlockMetadataWithNotify(x, y, z, new Random().nextInt(6), 2);
    }

    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; ++i)
            topIcons[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_" + i + "_sandstone_top");

        for (int i = 0; i < 6; ++i)
            normalIcons[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_" + i + "_sandstone_normal");

        for (int i = 0; i < 6; ++i)
            bottomIcons[i] = register.registerIcon(JurassiCraft.getModId() + "fossil/fossil_side_" + i + "_sandstone_bottom");
    }

    public IIcon getIcon(int side, int metadata) {
        if (metadata > 5)
            return topIcons[0];

        switch (side) {
            case 0:
                return bottomIcons[metadata];
            case 1:
                return topIcons[metadata];
            default:
                return normalIcons[metadata];
        }
    }
}
