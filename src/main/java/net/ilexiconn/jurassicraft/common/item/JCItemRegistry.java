package net.ilexiconn.jurassicraft.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.minecraft.item.Item;

import java.lang.reflect.Field;

public class JCItemRegistry {
    public static Item amber;
    public static Item fossil;
    public static Item dinoPad;
    public static Item dinoBone;
    public static Item growthSerum;
    public static Item gypsumPowder;
    public static Item appleOnAStick;
    public static Item beefOnAStick;
    public static Item carrotOnAStick;
    public static Item fishOnAStick;
    public static Item porkOnAStick;
    public static Item wheatOnAStick;
    public static Item net;
    public static Item spawnEgg;

    public void init() {
        amber = new ItemAmber();
        fossil = new ItemFossil();
        dinoBone = new ItemDinoBone();
        growthSerum = new ItemGrowthSerum();
        gypsumPowder = new ItemGypsumPowder();
        dinoPad = new ItemDinoPad();
        appleOnAStick = new ItemOnAStick("Apple");
        beefOnAStick = new ItemOnAStick("Beef");
        carrotOnAStick = new ItemOnAStick("Carrot");
        fishOnAStick = new ItemOnAStick("Fish");
        porkOnAStick = new ItemOnAStick("Pork");
        wheatOnAStick = new ItemOnAStick("Wheat");
        spawnEgg = new ItemSpawnEggJurassiCraft();
        net = new ItemNet();

        for (Creature creature : CreatureHandler.getCreatures()) {
            switch (creature.getAddedItemTypes()) {
                case 0:
                    /** Creature not implemented yet */
                    break;
                case 1:
                    /** DNA + Egg */
                    creature.addDNA();
                    creature.addEgg();
                    break;
                case 2:
                    /** DNA + Syringe */
                    creature.addDNA();
                    creature.addSyringe();
                    break;
                case 3:
                    /** DNA + Egg + Meat */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    break;
                case 4:
                    /** DNA + Syringe + Meat */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    break;
                case 5:
                    /** DNA + Egg + Meat + Skull */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    creature.addSkull();
                    break;
                case 6:
                    /** DNA + Syringe + Meat + Skull */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    creature.addSkull();
                    break;
                case 7:
                    /** DNA + Egg + Meat + Skin */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    creature.addSkin();
                    break;
                case 8:
                    /** DNA + Syringe + Meat + Fur */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    creature.addFur();
                    break;
                case 9:
                    /** DNA + Egg + Meat + Skull + Skin */
                    creature.addDNA();
                    creature.addEgg();
                    creature.addMeat();
                    creature.addSkull();
                    creature.addSkin();
                    break;
                case 10:
                    /** DNA + Syringe + Meat + Skin */
                    creature.addDNA();
                    creature.addSyringe();
                    creature.addMeat();
                    creature.addSkin();
                    break;
            }
        }

        for (Field field : getClass().getFields()) {
            try {
                Object obj = null;
                try {
                    obj = field.get(this);
                } catch (Throwable ex) {
                }
                if (obj != null && obj instanceof Item) {
                    Item item = (Item) field.get(this);
                    if (field.getAnnotations().length == 0)
                        GameRegistry.registerItem(item, item.getUnlocalizedName());
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
