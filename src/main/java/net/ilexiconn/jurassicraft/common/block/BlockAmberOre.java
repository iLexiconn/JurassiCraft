package net.ilexiconn.jurassicraft.common.block;

import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockAmberOre extends Block {
    public BlockAmberOre() {
        super(Material.rock);
        setBlockName("amber_ore");
        setBlockTextureName(JurassiCraft.getModId() + "amber_ore");
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(JCCreativeTabRegistry.blocks);
    }

    public Item getItemDropped(int value, Random random, int thing) {
        return JCItemRegistry.amber;
    }
}
