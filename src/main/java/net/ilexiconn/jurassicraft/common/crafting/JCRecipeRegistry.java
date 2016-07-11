package net.ilexiconn.jurassicraft.common.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.block.cultivate.BlockCultivateBottom;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.item.ItemMeat;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class JCRecipeRegistry {
    public void init() {
        GameRegistry.addSmelting(JCBlockRegistry.gypsumCobblestone, new ItemStack(JCBlockRegistry.gypsumBlock, 1), 5);

        for (int i = 0; i < BlockCultivateBottom.iconVariationsNames.length; i++) {
            int correction = BlockCultivateBottom.iconVariationsNames.length - i - 1;
            GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.cultivateBottomOff, 1, i), "GIG", "G G", "III", 'I', Items.iron_ingot, 'G', new ItemStack(Blocks.stained_glass_pane, 1, correction));
        }

        for (Creature creature : CreatureHandler.getCreatures()) {
            ItemMeat meat = creature.getMeat();

            if (meat != null) {
                addGrowthSerumRecipe(new ItemStack(meat, 1));
            }
        }

        GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.securityFenceLowCorner, 1), "SSS", "SIS", "SSS", 'I', Blocks.iron_block, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.securityFenceLowBase, 1), "SSS", "III", 'I', Items.iron_ingot, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.securityFenceLowPole, 1), "SIS", "SIS", "SIS", 'I', Items.iron_ingot, 'S', Blocks.stone);
        GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.dnaCombinator, 1), "III", "IRI", "III", 'I', Items.iron_ingot, 'R', Items.redstone);
        GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.dnaExtractor, 1), "IIG", "IRG", "III", 'G', Blocks.glass, 'I', Items.iron_ingot, 'R', Items.redstone);
        GameRegistry.addShapedRecipe(new ItemStack(JCItemRegistry.dinoPad, 1), "III", "RGR", "III", 'I', Items.iron_ingot, 'G', Items.glowstone_dust, 'R', Items.redstone);

        GameRegistry.addShapedRecipe(new ItemStack(JCItemRegistry.gypsumPowder, 2), "TG", 'T', Items.flint, 'G', JCBlockRegistry.gypsumCobblestone);
        GameRegistry.addShapedRecipe(new ItemStack(JCBlockRegistry.gypsumBrick, 1), "BB", "BB", 'B', JCBlockRegistry.gypsumBlock);

        addGrowthSerumRecipe(new ItemStack(Items.beef, 1));
        addGrowthSerumRecipe(new ItemStack(Items.fish, 1));
        addGrowthSerumRecipe(new ItemStack(Items.porkchop, 1));
        addGrowthSerumRecipe(new ItemStack(Items.chicken, 1));
        addGrowthSerumRecipe(new ItemStack(Items.cooked_beef, 1));
        addGrowthSerumRecipe(new ItemStack(Items.cooked_fished, 1));
        addGrowthSerumRecipe(new ItemStack(Items.cooked_chicken, 1));
        addGrowthSerumRecipe(new ItemStack(Items.cooked_porkchop, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(JCBlockRegistry.clearGlass, 2), new ItemStack(Blocks.glass), new ItemStack(Items.iron_ingot));
    }

    private void addGrowthSerumRecipe(ItemStack meat) {
        GameRegistry.addShapelessRecipe(new ItemStack(JCItemRegistry.growthSerum, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.water_bucket, 1), meat);
    }
}
