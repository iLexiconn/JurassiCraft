package net.ilexiconn.jurassicraft.client.render.entity;

import com.google.common.collect.Maps;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.data.CreatureContainer;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Map;

public class RenderJurassicraftCreature extends RenderLiving {
    private Map<String, ResourceLocation> textureCache = Maps.newHashMap();

    private CreatureContainer creature;
    private float resizableShadow;
    private String category;
    private String creatureName;

    public RenderJurassicraftCreature(CreatureContainer creature, String creatureName, String category, float shadow) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super((ModelBase) Class.forName("net.ilexiconn.jurassicraft.client.model.entity.Model" + creatureName).newInstance(), shadow);
        this.setCreature(creature);
        this.setShadow(shadow);
        this.category = category.toLowerCase();
        this.creatureName = creatureName.toLowerCase();
    }

    public float getShadow() {
        return this.resizableShadow;
    }

    private void setShadow(float shadow) {
        this.resizableShadow = shadow;
    }

    public CreatureContainer getCreature() {
        return this.creature;
    }

    private void setCreature(CreatureContainer creature) {
        this.creature = creature;
    }

    public void preRenderCallback(EntityLivingBase entity, float side) {
        float scale = ((EntityJurassiCraftCreature) entity).getCreatureScale();
        this.shadowSize = scale * this.getShadow();
        GL11.glScalef(scale, scale, scale);
    }

    public ResourceLocation getEntityTexture(Entity entity) {
        EntityJurassiCraftCreature dino = (EntityJurassiCraftCreature) entity;

        String texture;

        if (dino instanceof EntityVelociraptor) {
            String name = dino.getCustomNameTag();

            if (name != null) {
                if (name.equalsIgnoreCase("Blue")) {
                    return getTexture(JurassiCraft.getModId() + "textures/entity/" + category + "/" + creatureName + "/blue.png");
                } else if (name.equalsIgnoreCase("Charlie")) {
                    return getTexture(JurassiCraft.getModId() + "textures/entity/" + category + "/" + creatureName + "/charlie.png");
                } else if (name.equalsIgnoreCase("Delta")) {
                    return getTexture(JurassiCraft.getModId() + "textures/entity/" + category + "/" + creatureName + "/delta.png");
                } else if (name.equalsIgnoreCase("Echo")) {
                    return getTexture(JurassiCraft.getModId() + "textures/entity/" + category + "/" + creatureName + "/echo.png");
                } else if (name.equalsIgnoreCase("Velocibrine") || name.equalsIgnoreCase("Herobrine")) {
                    return getTexture(JurassiCraft.getModId() + "textures/entity/" + category + "/" + creatureName + "/" + "velocibrine" + dino.getCreatureGenderString() + "1.png");
                }
            }
        }

        return getTexture(JurassiCraft.getModId() + "textures/entity/" + category + "/" + creatureName + "/" + creatureName + dino.getCreatureGenderString() + "1.png");
    }

    public ResourceLocation getTexture(String texture) {
        if (textureCache.containsKey(texture)) {
            return textureCache.get(texture);
        } else {
            ResourceLocation value = new ResourceLocation(texture);
            textureCache.put(texture, value);

            return value;
        }
    }
}