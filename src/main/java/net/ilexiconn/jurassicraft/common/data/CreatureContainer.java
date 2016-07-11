package net.ilexiconn.jurassicraft.common.data;

import java.util.ArrayList;

public class CreatureContainer {
    private static byte currentCreatureID = 0;
    public byte creatureID = currentCreatureID++;
    public String creatureName;
    public ArrayList<String> livingSounds; // todo: can we remove these vars? public String hurtSound; public String deathSound;
    public double minHealth;
    public double minStrength;
    public double minSpeed;
    public double minKnockback;
    public double minProximate;
    public double minMinerals;
    public double minVitamins;
    public double minLipids;
    public double maxHealth;
    public double maxStrength;
    public double maxSpeed;
    public double maxKnockback;
    public double ridingSpeed;
    public float adultAge;
    public float minLength;
    public float minHeight;
    public float maxLength;
    public float maxHeight;
    public float xzBoxMin;
    public float yBoxMin;
    public float xzBoxDelta;
    public float yBoxDelta;
    public float scaleAdjustment;
    public float shadowSize;
    public int ticksToAdulthood;
    public int cultivateSpeed;
    public int numberOfTextures;
    public int ridingStyle;
    public int numberOfInfoPages;
    public ArrayList<String> favoriteFoodList;
    public ArrayList<String> ridingItemList;
    public boolean isRidable;
    public boolean canBeTamedUponSpawning;
    public boolean waterCreature;
    public boolean flyingCreature;
    public byte addItemTypes;
    public int eggPrimaryColor;
    public int eggSecondaryColor;
}
