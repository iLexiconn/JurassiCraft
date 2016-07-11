package net.ilexiconn.jurassicraft.client.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSpit extends Render {
    public RenderSpit() {
        super();
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}
