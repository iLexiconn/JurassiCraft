package net.ilexiconn.jurassicraft.common.handler;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.common.data.CreatureContainer;

import java.io.InputStreamReader;
import java.util.Collection;

public class JsonEntityHandler {
    public Collection<CreatureContainer> dinos;
    public Collection<CreatureContainer> mammals;
    public Collection<CreatureContainer> cephalopods;
    public Collection<CreatureContainer> arthropods;
    public Collection<CreatureContainer> fish;
    public Collection<CreatureContainer> reptiles;
    public Collection<CreatureContainer> birds;

    public void parseServerEntities() {
        loadJsons();

        for (CreatureContainer dino : dinos)
            CreatureHandler.addCreature(dino, "dinosaurs");

        for (CreatureContainer creature : reptiles)
            CreatureHandler.addCreature(creature, "reptiles");

        for (CreatureContainer creature : mammals)
            CreatureHandler.addCreature(creature, "mammals");

        for (CreatureContainer creature : birds)
            CreatureHandler.addCreature(creature, "birds");

        for (CreatureContainer creature : fish)
            CreatureHandler.addCreature(creature, "fish");

        for (CreatureContainer creature : cephalopods)
            CreatureHandler.addCreature(creature, "cephalopods");

        for (CreatureContainer creature : arthropods)
            CreatureHandler.addCreature(creature, "arthropods");
    }

    @SideOnly(Side.CLIENT)
    public void parseClientEntities() throws Exception {
        loadJsons();

        for (CreatureContainer creature : dinos)
            CreatureHandler.addCreatureRenderer(creature, "dinosaurs");

        for (CreatureContainer creature : reptiles)
            CreatureHandler.addCreatureRenderer(creature, "reptiles");

        for (CreatureContainer creature : mammals)
            CreatureHandler.addCreatureRenderer(creature, "mammals");

        for (CreatureContainer creature : birds)
            CreatureHandler.addCreatureRenderer(creature, "birds");

        for (CreatureContainer creature : fish)
            CreatureHandler.addCreatureRenderer(creature, "fish");

        for (CreatureContainer creature : cephalopods)
            CreatureHandler.addCreatureRenderer(creature, "cephalopods");

        for (CreatureContainer creature : arthropods)
            CreatureHandler.addCreatureRenderer(creature, "arthropods");
    }

    public void loadJsons() {
        dinos = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/dinos.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
        reptiles = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/reptiles.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
        mammals = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/mammals.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
        birds = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/birds.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
        fish = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/fish.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
        cephalopods = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/cephalopods.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
        arthropods = new Gson().fromJson(new InputStreamReader(JsonEntityHandler.class.getResourceAsStream("/assets/jurassicraft/json/arthropods.json")), new TypeToken<Collection<CreatureContainer>>() {
        }.getType());
    }
}
