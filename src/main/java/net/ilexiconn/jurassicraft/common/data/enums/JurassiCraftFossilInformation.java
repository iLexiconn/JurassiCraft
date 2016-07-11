package net.ilexiconn.jurassicraft.common.data.enums;

import net.minecraft.util.EnumChatFormatting;

public enum JurassiCraftFossilInformation {

    /*
     * Already done. CORONICERASROTIFORME("Coroniceras rotiforme", (byte) 0, "Arietitidae", (short) 199, (short) 191, "Carnivorous", 1.00000D, 0.50D, 0.50D, "IconCoronicerasRotiforme", (byte) 1, (byte) 1, "Dinosaur"), COMPSOGNATHUS("Compsognathus longipes", (byte) 1, "Compsognathidae", (short) 151, (short) 147, "Carnivorous", 4.00000D, 1.00D, 0.55D, "IconCompsognathus", (byte) 1, (byte) 2, "Dinosaur"), VELOCIRAPTOR("Velociraptor mongoliensis", (byte) 2, "Dromaeosauridae", (short) 75, (short) 71, "Carnivorous", 15.0000D, 2.00D, 0.80D, "IconVelociraptor", (byte) 1, (byte) 2, "Dinosaur"), TYRANNOSAURUSREX("Tyrannosaurus rex", (byte) 3, "Tyrannosauridae", (short) 67, (short) 65, "Carnivorous", 6800.00D, 12.3D, 4.00D, "IconTyrannosaurusRex", (byte) 3, (byte) 5, "Dinosaur"), STEGOSAURUS("Stegosaurus armatus", (byte) 4, "Stegosauridae", (short) 156, (short) 149, "Herbivorous", 4500.00D, 8.50D, 4.20D, "IconStegosaurus", (byte) 2, (byte) 4, "Dinosaur"), ANKYLOSAURUS("Ankylosaurus magniventris", (byte) 5, "Ankylosauridae", (short) 67, (short) 65, "Herbivorous", 6000.00D, 6.25D, 1.70D, "IconAnkylosaurus", (byte) 2, (byte) 4, "Dinosaur"), PLESIOSAURUS("Plesiosaurus dolichodeirus", (byte) 6, "Plesiosauridae", (short) 200, (short) 194, "Piscivorous", 480.000D, 3.60D, 1.20D, "IconPlesiosaurus", (byte) 2, (byte) 4, "Dinosaur");
     * 
     * /* Others. TRICERATOPS("Triceratops horridus", 5, "Herbivore", 67, 65, 9000.0, 9.0, 3.2, "SmallCarnivore"); BRACHIOSAURUS("Brachiosaurus altithorax", 6, "Herbivore", 156, 145, 35000.0, 26.0, 6.5, "SmallCarnivore"); PARASAUROLOPHUS("Parasaurolophus walkeri", 7, "Herbivore", 77, 72, 2500.0, 9.5, 3.8, "SmallCarnivore"); ALLOSAURUS("Allosaurus fragilis", 8, "Carnivore", 156, 150, 2200.0, 11.0, 3.5, "SmallCarnivore"); SPINOSAURUS("Spinosaurus aegyptiacus", 9, "Carnivore", 111, 93, 8500.0, 17, 5.5, "SmallCarnivore"); DILOPHOSAURUS("Dilophosaurus wetherilli", 10, "Carnivore", 196, 191, 500.0, 6.5, 1.9, "SmallCarnivore"); ARCHAEOPTERYX("Archaeopteryx lithographica", 11, "Carnivore", 152, 145, 1.0, 0.5, 0.3, "SmallCarnivore");
     */

    EXAMPLE("Species", (byte) 0, "family", (short) 199, (short) 191, "Diet", 1.00000D, 0.50D, 0.50D, (byte) 1, (byte) 1, "Dinosaur");

    private final String typeOfCreature;
    private final String fossilName;
    private final String family;
    private final String diet;
    private final byte fossilID;
    private final byte boundX;
    private final byte boundZ;
    private final short beginOfExistence;
    private final short endOfExistence;
    private final double weight;
    private final double length;
    private final double height;

    JurassiCraftFossilInformation(String name, byte id, String dinoFamily, short maxYear, short minYear, String dinoDiet, double dinoWeight, double dinoLength, double dinoHeight, byte xB, byte zB, String creature) {
        this.fossilName = name;
        this.fossilID = id;
        this.family = dinoFamily;
        this.diet = dinoDiet;
        this.beginOfExistence = maxYear;
        this.endOfExistence = minYear;
        this.weight = dinoWeight;
        this.height = dinoHeight;
        this.length = dinoLength;
        this.boundX = xB;
        this.boundZ = zB;
        this.typeOfCreature = creature;
    }

    /**
     * Returns the era and period of the fossil based on its year of existence
     */
    public static String getEra(double numberOfMYA) {
        if (numberOfMYA <= 252.7 && numberOfMYA > 251.2) {
            return "Induan period of the Early Triassic";
        } else if (numberOfMYA <= 251.2 && numberOfMYA > 247.2) {
            return "Olenekian period of the Early Triassic";
        } else if (numberOfMYA <= 247.2 && numberOfMYA > 242.0) {
            return "Anisian period of the Middle Triassic";
        } else if (numberOfMYA <= 242.0 && numberOfMYA > 235.0) {
            return "Ladinian period of the Middle Triassic";
        } else if (numberOfMYA <= 235.0 && numberOfMYA > 228.0) {
            return "Carnian period of the Middle Triassic";
        } else if (numberOfMYA <= 228.0 && numberOfMYA > 208.5) {
            return "Norian period of the Late Triassic";
        } else if (numberOfMYA <= 208.5 && numberOfMYA > 201.3) {
            return "Rhaetian period of the Late Triassic";
        } else if (numberOfMYA <= 201.3 && numberOfMYA > 199.3) {
            return "Hettangian period of the Early Jurassic";
        } else if (numberOfMYA <= 199.3 && numberOfMYA > 190.8) {
            return "Sinemurian period of the Early Jurassic";
        } else if (numberOfMYA <= 190.8 && numberOfMYA > 182.7) {
            return "Pliensbachian period of the Early Jurassic";
        } else if (numberOfMYA <= 182.7 && numberOfMYA > 174.1) {
            return "Toarcian period of the Early Jurassic";
        } else if (numberOfMYA <= 174.1 && numberOfMYA > 170.3) {
            return "Aalenian period of the Middle Jurassic";
        } else if (numberOfMYA <= 170.3 && numberOfMYA > 168.3) {
            return "Bajocian period of the Middle Jurassic";
        } else if (numberOfMYA <= 168.3 && numberOfMYA > 166.1) {
            return "Bathonian period of the Middle Jurassic";
        } else if (numberOfMYA <= 166.1 && numberOfMYA > 163.5) {
            return "Callovian period of the Middle Jurassic";
        } else if (numberOfMYA <= 163.5 && numberOfMYA > 157.3) {
            return "Oxfordian period of the Late Jurassic";
        } else if (numberOfMYA <= 157.3 && numberOfMYA > 152.1) {
            return "Kimmeridgian period of the Late Jurassic";
        } else if (numberOfMYA <= 152.1 && numberOfMYA > 145.0) {
            return "Tithonian period of the Late Jurassic";
        } else if (numberOfMYA <= 145.0 && numberOfMYA > 139.8) {
            return "Berriasian period of the Early Cretaceous";
        } else if (numberOfMYA <= 139.8 && numberOfMYA > 132.9) {
            return "Valanginian period of the Early Cretaceous";
        } else if (numberOfMYA <= 132.9 && numberOfMYA > 129.4) {
            return "Hauterivian period of the Early Cretaceous";
        } else if (numberOfMYA <= 129.4 && numberOfMYA > 125.0) {
            return "Barremian period of the Early Cretaceous";
        } else if (numberOfMYA <= 125.0 && numberOfMYA > 113.0) {
            return "Aptian period of the Early Cretaceous";
        } else if (numberOfMYA <= 113.0 && numberOfMYA > 100.5) {
            return "Albian period of the Early Cretaceous";
        } else if (numberOfMYA <= 100.5 && numberOfMYA > 93.9) {
            return "Cenomanian period of the Late Cretaceous";
        } else if (numberOfMYA <= 93.9 && numberOfMYA > 89.8) {
            return "Turonian period of the Late Cretaceous";
        } else if (numberOfMYA <= 89.8 && numberOfMYA > 86.3) {
            return "Coniacian period of the Late Cretaceous";
        } else if (numberOfMYA <= 86.3 && numberOfMYA > 83.3) {
            return "Santonian period of the Late Cretaceous";
        } else if (numberOfMYA <= 83.3 && numberOfMYA > 72.1) {
            return "Campanian period of the Late Cretaceous";
        } else if (numberOfMYA <= 72.1 && numberOfMYA >= 65.0) {
            return "Maastrichtian period of the Late Cretaceous";
        } else {
            return "Not Defined";
        }
    }

    /**
     * Returns the right EnumChatFormatting color depending on the diet
     */
    public static EnumChatFormatting getDietColor(String diet) {
        if (diet == "Carnivorous") {
            return EnumChatFormatting.RED;
        } else if (diet == "Herbivorous") {
            return EnumChatFormatting.GREEN;
        } else if (diet == "Piscivorous") {
            return EnumChatFormatting.BLUE;
        } else {
            return EnumChatFormatting.GRAY;
        }
    }

    /**
     * Returns the name of the fossil.
     */
    public String getName() {
        return fossilName;
    }

    /**
     * Returns the id of the fossil.
     */
    public int getID() {
        return fossilID;
    }

    /**
     * Returns the diet of the fossil.
     */
    public String getDiet() {
        return diet;
    }

    /**
     * Returns the family of the fossil
     */
    public String getFamily() {
        return family;
    }

    /**
     * Returns the initial year of existence.
     */
    public int getBeginOfExistence() {
        return beginOfExistence;
    }

    /**
     * Returns the final year of existence.
     */
    public int getEndOfExistence() {
        return endOfExistence;
    }

    /**
     * Returns the length of the fossil.
     */
    public double getLength() {
        return length;
    }

    /**
     * Returns the length of the fossil.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the length of the fossil.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the x bound of the fossil.
     */
    public int getXBound() {
        return boundX;
    }

    /**
     * Returns the z bound of the fossil.
     */
    public int getZBound() {
        return boundZ;
    }

    /**
     * Returns the type of creature. Dinosaur, mammal, reptile.
     */
    public String getTypeOfCreature() {
        return typeOfCreature;
    }
}