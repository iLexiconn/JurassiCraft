package net.ilexiconn.jurassicraft.common.handler;

import java.util.Random;

public class JurassiCraftDNAHandler {
    private static Random random = new Random();

    /**
     * Returns a new DNA code (String) with size 15.
     */
    public static String createDefaultDNA() {
        return createDNA(15);
    }

    /**
     * Returns a new DNA code with a certain size.
     */
    public static String createDNA(int size) {
        String newDNA = "";

        for (int i = 0; i < size; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    newDNA = newDNA + "A";
                    break;
                case 1:
                    newDNA = newDNA + "C";
                    break;
                case 2:
                    newDNA = newDNA + "G";
                    break;
                case 3:
                    newDNA = newDNA + "T";
                    break;
                default:
                    newDNA = newDNA + "_FAIL_";
            }
        }

        if (newDNA.length() != size)
            newDNA = "FAIL";

        return newDNA;
    }

    /**
     * Returns a modified DNA code depending on the quality.
     */
    public static String reviseDNA(String dna, int quality) {
        if (dna != null && dna.length() > 0) {
            int changes = dna.length() * (100 - quality) / 100;

            for (int i = 0; i < changes; i++) {
                int charAt = random.nextInt(dna.length());

                String dna1 = dna.substring(0, charAt);
                String dna2 = dna.substring(charAt + 1, dna.length());
                String charChanged = String.valueOf(dna.charAt(charAt));

                if (charChanged.equals("A")) {
                    switch (random.nextInt(3)) {
                        case 0:
                            charChanged = "C";
                            break;
                        case 1:
                            charChanged = "G";
                            break;
                        case 2:
                            charChanged = "T";
                            break;
                        default:
                            charChanged = "A";
                    }
                } else if (charChanged.equals("C")) {
                    switch (random.nextInt(3)) {
                        case 0:
                            charChanged = "A";
                            break;
                        case 1:
                            charChanged = "G";
                            break;
                        case 2:
                            charChanged = "T";
                            break;
                        default:
                            charChanged = "C";
                    }
                } else if (charChanged.equals("G")) {
                    switch (random.nextInt(3)) {
                        case 0:
                            charChanged = "A";
                            break;
                        case 1:
                            charChanged = "C";
                            break;
                        case 2:
                            charChanged = "T";
                            break;
                        default:
                            charChanged = "G";
                    }
                } else if (charChanged.equals("T")) {
                    switch (random.nextInt(3)) {
                        case 0:
                            charChanged = "A";
                            break;
                        case 1:
                            charChanged = "C";
                            break;
                        case 2:
                            charChanged = "G";
                            break;
                        default:
                            charChanged = "T";
                    }
                }

                dna = dna1 + charChanged + dna2;
            }
        } else {
            dna = JurassiCraftDNAHandler.createDefaultDNA();
        }

        return dna;
    }

    /**
     * Returns a mixture of two DNA codes.
     */
    public static String mixTwoDNAs(String dna1, String dna2) {
        String newDNA = "";

        if (dna1.length() > 0 && dna2.length() > 0 && dna1.length() == dna2.length()) {
            for (int i = 0; i < dna1.length(); i++) {
                if ((i % 2) == 0)
                    newDNA = String.valueOf(newDNA + dna1.charAt(i));
                else
                    newDNA = String.valueOf(newDNA + dna2.charAt(i));
            }
        } else
            newDNA = JurassiCraftDNAHandler.createDefaultDNA();

        return newDNA;
    }

    /**
     * Returns a float value depending on the DNA string from char at i = 0 to char at i = 3.
     */
    public static float getDefaultGenderDNAQuality(String dna) {
        float quality = 0.5F;

        if (dna != null && dna.length() > 0) {
            for (int i = 0; i < 3; i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        quality = quality - 0.10F;
                        break;
                    case 'C':
                        quality = quality - 0.05F;
                        break;
                    case 'G':
                        quality = quality + 0.05F;
                        break;
                    case 'T':
                        quality = quality + 0.10F;
                        break;
                }
            }
        } else
            dna = JurassiCraftDNAHandler.createDefaultDNA();

        return quality;
    }

    /**
     * Returns a float value depending on the DNA string.
     */
    public static float getGenderDNAQuality(String dna, int fromChar, int toChar) {
        float quality = 0.5F;

        if (dna != null && dna.length() > 0) {
            for (int i = fromChar; i < toChar + 1; i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        quality = quality - 0.10F;
                        break;
                    case 'C':
                        quality = quality - 0.05F;
                        break;
                    case 'G':
                        quality = quality + 0.05F;
                        break;
                    case 'T':
                        quality = quality + 0.10F;
                        break;
                }
            }
        } else
            dna = JurassiCraftDNAHandler.createDefaultDNA();

        return (Float.valueOf((int) (100000 * quality))) / 100000.0F;
    }

    /**
     * Returns a float value depending on the DNA string from char at i = 3 to char at i = 6.
     */
    public static float getDefaultTextureDNAQuality(String dna) {
        float quality = 0.5F;

        if (dna != null && dna.length() > 0) {
            for (int i = 3; i < 7; i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        quality = quality - 0.10F;
                        break;
                    case 'C':
                        quality = quality - 0.05F;
                        break;
                    case 'G':
                        quality = quality + 0.05F;
                        break;
                    case 'T':
                        quality = quality + 0.10F;
                        break;
                }
            }
        } else
            dna = JurassiCraftDNAHandler.createDefaultDNA();

        return (Float.valueOf((int) (100000 * quality))) / 100000.0F;
    }

    /**
     * Returns a float value depending on the DNA string.
     */
    public static float getTextureDNAQuality(String dna, int fromChar, int toChar) {
        float quality = 0.5F;

        if (dna != null && dna.length() > 0) {
            for (int i = fromChar; i < toChar + 1; i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        quality = quality - 0.10F;
                        break;
                    case 'C':
                        quality = quality - 0.05F;
                        break;
                    case 'G':
                        quality = quality + 0.05F;
                        break;
                    case 'T':
                        quality = quality + 0.10F;
                        break;
                }
            }
        } else {
            dna = JurassiCraftDNAHandler.createDefaultDNA();
        }

        return (Float.valueOf((int) (100000 * quality))) / 100000.0F;
    }

    /**
     * Returns a float value depending on the DNA string from char at i = 7 to char at i = 14.
     */
    public static float getDefaultGeneticDNAQuality(String dna) {
        float quality = 1.0F;

        if (dna != null && dna.length() > 0) {
            for (int i = 7; i < 15; i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        quality = quality - 0.05F;
                        break;
                    case 'C':
                        quality = quality - 0.025F;
                        break;
                    case 'G':
                        quality = quality + 0.025F;
                        break;
                    case 'T':
                        quality = quality + 0.05F;
                        break;
                }
            }
        } else
            dna = JurassiCraftDNAHandler.createDefaultDNA();

        return (Float.valueOf((int) (100000 * quality))) / 100000.0F;
    }

    /**
     * Returns a float value depending on the DNA string.
     */
    public static float getGeneticDNAQuality(String dna, int fromChar, int toChar) {
        float quality = 1.0F;

        if (dna != null && dna.length() > 0) {
            for (int i = fromChar; i < toChar + 1; i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        quality = quality - 0.05F;
                        break;
                    case 'C':
                        quality = quality - 0.025F;
                        break;
                    case 'G':
                        quality = quality + 0.025F;
                        break;
                    case 'T':
                        quality = quality + 0.05F;
                        break;
                }
            }
        } else
            dna = JurassiCraftDNAHandler.createDefaultDNA();

        return (Float.valueOf((int) (100000 * quality))) / 100000.0F;
    }
}
