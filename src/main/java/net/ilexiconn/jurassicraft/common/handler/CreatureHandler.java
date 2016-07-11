package net.ilexiconn.jurassicraft.common.handler;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.render.entity.RenderJurassicraftCreature;
import net.ilexiconn.jurassicraft.common.data.CreatureContainer;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;

import java.util.ArrayList;
import java.util.List;

public class CreatureHandler {
    private static List<Creature> creatures = new ArrayList<Creature>();

    public static List<Creature> getCreatures() {
        return creatures;
    }

    public static String[] getCreatureNames() {
        List<String> list = new ArrayList<String>();

        for (Creature creature : getCreatures())
            list.add(creature.getCreatureName());

        return list.toArray(new String[list.size()]);
    }

    public static Creature getCreatureFromId(int creatureID) {
        for (Creature creature : creatures) {
            if (creature.getCreatureID() == creatureID) {
                return creature;
            }
        }

        return null;
    }

    public static String getCategoryFromCreatureName(String name) {
        for (Creature creature : creatures) {
            if (creature.getCreatureName().toLowerCase().equals(name.toLowerCase()))
                return creature.getCreatureCategory();
        }

        return null;
    }

    public static Creature classToCreature(Class clazz) {
        for (Creature creature : creatures) {
            if (creature.getCreatureClass().equals(clazz)) {
                return creature;
            }
        }

        return null;
    }

    public static Creature getCreatureFromDNA(ItemDNA itemDNA) {
        if (itemDNA != null) {
            for (Creature creature : creatures) {
                ItemDNA currentDNA = creature.getDNA();

                if (itemDNA.equals(currentDNA)) {
                    return creature;
                }
            }
        }

        return null;
    }

    public static Creature getCreatureFromName(String name) {
        for (Creature creature : creatures) {
            if (creature.getCreatureName().equalsIgnoreCase(name)) {
                return creature;
            }
        }

        return null;
    }

    public static void addCreature(CreatureContainer creature, String category) {
        try {
            String creatureName = creature.creatureName;

            Class entity = Class.forName("net.ilexiconn.jurassicraft.common.entity." + category + ".Entity" + creatureName);
            creatures.add(new Creature(category, creature, entity));

            EntityRegistry.registerModEntity(entity, creatureName, JurassiCraft.entityIndex++, JurassiCraft.instance, 64, 1, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SideOnly(Side.CLIENT)
    public static void addCreatureRenderer(CreatureContainer dino, String category) {
        try {
            Class entity = Class.forName("net.ilexiconn.jurassicraft.common.entity." + category + ".Entity" + dino.creatureName);
            JurassiCraft.proxy.renderEntity(entity, new RenderJurassicraftCreature(dino, dino.creatureName, category, dino.shadowSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
