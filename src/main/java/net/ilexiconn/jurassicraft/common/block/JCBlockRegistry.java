package net.ilexiconn.jurassicraft.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.common.api.ISubBlocksBlock;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivateBottom;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivateFluid;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivateTop;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowCorner;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowPole;
import net.ilexiconn.jurassicraft.common.block.fossil.BlockFossilClayOre;
import net.ilexiconn.jurassicraft.common.block.fossil.BlockFossilOre;
import net.ilexiconn.jurassicraft.common.block.fossil.BlockFossilSandstoneOre;
import net.ilexiconn.jurassicraft.common.block.gypsum.BlockGypsumBlock;
import net.ilexiconn.jurassicraft.common.block.gypsum.BlockGypsumBrick;
import net.ilexiconn.jurassicraft.common.block.gypsum.BlockGypsumCobblestone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.lang.reflect.Field;

public class JCBlockRegistry {
    public static Block clayFossilOre;
    public static Fluid cultivateFluid;
    public static Block cultivateLiquid;
    public static Block cultivateBottomOff;
    public static Block cultivateBottomOn;
    public static Block cultivateTopOff;
    public static Block cultivateTopOn;
    public static Block dnaExtractor;
    public static Block dnaCombinator;
    public static Block gypsumBlock;
    public static Block gypsumBrick;
    public static Block gypsumCobblestone;
    public static Block amberOre;
    public static Block fossilOre;
    public static Block sandstoneFossilOre;
    public static Block dinoPad;
    public static Block securityFenceLowCorner;
    public static Block securityFenceLowPole;
    public static Block securityFenceLowBase;
    public static Block securityFenceLowGrid;
    public static Block clearGlass;

    public void init() {
        cultivateBottomOff = new BlockCultivateBottom(false);
        cultivateTopOff = new BlockCultivateTop(false);
        cultivateBottomOn = new BlockCultivateBottom(true);
        cultivateTopOn = new BlockCultivateTop(true);
        dnaExtractor = new BlockDNAExtractor();
        dnaCombinator = new BlockDNACombinator();
        gypsumBlock = new BlockGypsumBlock();
        gypsumBrick = new BlockGypsumBrick();
        gypsumCobblestone = new BlockGypsumCobblestone();
        amberOre = new BlockAmberOre();
        fossilOre = new BlockFossilOre();
        sandstoneFossilOre = new BlockFossilSandstoneOre();
        clayFossilOre = new BlockFossilClayOre();
        dinoPad = new BlockDinoPad();
        securityFenceLowCorner = new BlockSecurityFenceLowCorner();
        securityFenceLowPole = new BlockSecurityFenceLowPole();
        securityFenceLowBase = new BlockSecurityFenceLowBase();
        securityFenceLowGrid = new BlockSecurityFenceLowGrid();
        cultivateFluid = new Fluid("cultivate").setLuminosity(5).setViscosity(1);
        FluidRegistry.registerFluid(cultivateFluid);
        cultivateLiquid = new BlockCultivateFluid(cultivateFluid, Material.water).setBlockName("culivateFluid").setCreativeTab(null);
        clearGlass = new BlockClearGlass();

        try {
            for (Field field : JCBlockRegistry.class.getDeclaredFields()) {
                Object obj = field.get(null);

                if (obj instanceof Block)
                    registerBlock((Block) obj);
                else if (obj instanceof Block[])
                    for (Block block : (Block[]) obj)
                        registerBlock(block);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerBlock(Block block) {
        if (block instanceof ISubBlocksBlock)
            GameRegistry.registerBlock(block, ((ISubBlocksBlock) block).getItemBlockClass(), block.getUnlocalizedName());
        else
            GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }
}
