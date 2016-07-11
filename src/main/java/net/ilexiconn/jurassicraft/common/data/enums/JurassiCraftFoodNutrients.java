package net.ilexiconn.jurassicraft.common.data.enums;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public enum JurassiCraftFoodNutrients {
    APPLE(Items.apple, 0.060D, 0.065D, 0.100D, 0.010D), POTATO(Items.potato, 0.100D, 0.200D, 0.160D, 0.020D), BREAD(Items.bread, 0.300D, 0.400D, 0.430D, 0.180D), CHICKEN(Items.chicken, 0.390D, 0.350D, 0.280D, 0.450D), CHICKENCOOKED(Items.cooked_chicken, 0.490D, 0.425D, 0.335D, 0.555D), PORKCHOP(Items.porkchop, 0.460D, 0.310D, 0.390D, 0.380D), PORKCHOPCOOKED(Items.cooked_porkchop, 0.580D, 0.390D, 0.490D, 0.470D), BEEF(Items.beef, 0.460D, 0.310D, 0.390D, 0.380D), BEEFCOOKED(Items.cooked_beef, 0.520D, 0.330D, 0.410D, 0.400D), FISH(Items.fish, 0.480D, 0.430D, 0.140D, 0.240D), FISHCOOKED(Items.cooked_fished, 0.500D, 0.450D, 0.200D, 0.280D), MILK(Items.milk_bucket, 0.180D, 0.260D, 0.220D, 0.600D), EGG(Items.egg, 0.050D, 0.030D, 0.050D, 0.250D), CARROT(Items.carrot, 0.070D, 0.170D, 0.350D, 0.010D), SUGAR(Items.sugar, 0.200D, 0.010D, 0.010D, 0.010D), WATERMELON(Items.melon, 0.060D, 0.060D, 0.060D, 0.010D), WHEAT(Items.wheat, 0.100D, 0.220D, 0.100D, 0.030D);

    /**
     * Sets a list of all food. Used to check if some food is valid [.FOODLIST.containsKey(item)].
     */
    public static final Map<Item, Integer> FOODLIST = new HashMap<Item, Integer>();

    static {
        for (int i = 0; i < values().length; i++) {
            FOODLIST.put(JurassiCraftFoodNutrients.values()[i].getFoodItem(), i);
        }
    }

    private final double proximate;
    private final double minerals;
    private final double vitamins;
    private final double lipids;
    private final Item food;

    JurassiCraftFoodNutrients(Item foodID, double foodProximates, double foodMinerals, double foodVitamins, double foodLipids) {
        this.food = foodID;
        this.proximate = foodProximates;
        this.minerals = foodMinerals;
        this.vitamins = foodVitamins;
        this.lipids = foodLipids;
    }

    /**
     * Returns the food (Item).
     */
    public Item getFoodItem() {
        return food;
    }

    /**
     * Returns the value of proximate from certain food.
     */
    public double getProximate() {
        return proximate;
    }

    /**
     * Returns the mineral value from certain food.
     */
    public double getMinerals() {
        return minerals;
    }

    /**
     * Returns the value of vitamins from certain food.
     */
    public double getVitamins() {
        return vitamins;
    }

    /**
     * Returns the value of lipids from certain food.
     */
    public double getLipids() {
        return lipids;
    }
}