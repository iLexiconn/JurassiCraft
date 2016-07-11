package net.ilexiconn.jurassicraft.common.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.item.JCItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JCCreativeTabRegistry {
    public static CreativeTabs items;
    public static CreativeTabs blocks;
    public static CreativeTabs dnas;
    public static CreativeTabs syringesEggs;
    public static CreativeTabs spawnEggs;
    public static CreativeTabs itemsFood;

    public void init() {
        items = new CreativeTabs("jurassicraft.items") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return JCItemRegistry.amber;
            }
        };

        blocks = new CreativeTabs("jurassicraft.blocks") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(JCBlockRegistry.cultivateBottomOff);
            }
        };

        dnas = new CreativeTabs("jurassicraft.dnas") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return CreatureHandler.getCreatureFromName("Tyrannosaurus").getDNA();
            }
        };

        syringesEggs = new CreativeTabs("jurassicraft.syringesEggs") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return CreatureHandler.getCreatureFromName("Tyrannosaurus").getEgg();
            }
        };

        spawnEggs = new CreativeTabs("jurassicraft.spawnEggs") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return JCItemRegistry.spawnEgg;
            }
        };

        itemsFood = new CreativeTabs("jurassicraft.itemsFood") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return CreatureHandler.getCreatureFromName("Tyrannosaurus").getMeat();
            }
        };
    }

    public void gameRegistry() throws Exception {
    }
}
