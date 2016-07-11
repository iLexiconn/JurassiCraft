package net.ilexiconn.jurassicraft.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;

import java.util.Random;

public class BlockClearGlass extends BlockBreakable {
    public BlockClearGlass() {
        super(JurassiCraft.getModId() + "clear_glass", Material.glass, false);
        setBlockName("clearGlass");
        setBlockTextureName(JurassiCraft.getModId() + "clear_glass");
        setCreativeTab(JCCreativeTabRegistry.blocks);
        setHardness(0.3f);
        setStepSound(soundTypeGlass);
    }

    public int quantityDropped(Random random) {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    protected boolean canSilkHarvest() {
        return true;
    }
}
