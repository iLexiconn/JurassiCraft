package net.ilexiconn.jurassicraft.client.render.entity;

import net.ilexiconn.jurassicraft.client.model.block.ModelEgg;
import net.ilexiconn.jurassicraft.client.model.entity.ModelCoelacanthEgg;
import net.ilexiconn.jurassicraft.client.model.entity.ModelMeganeuraEgg;
import net.ilexiconn.jurassicraft.common.entity.egg.EntityDinoEgg;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDinoEgg extends Render {
    private final ModelMeganeuraEgg meganeuraEgg = new ModelMeganeuraEgg();
    private final ModelCoelacanthEgg fishEgg = new ModelCoelacanthEgg();

    public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float p_76986_9_) {
        this.renderEgg((EntityDinoEgg) entity, x, y, z, rotationYaw, p_76986_9_);
    }

    private void renderEgg(EntityDinoEgg entity, double x, double y, double z, float rotationYaw, float p_76986_9_) {
        ModelBase eggModel = new ModelEgg();

        String name = entity.creature.getCreatureName().toLowerCase();

        if (name.contains("meganeura"))
            eggModel = meganeuraEgg;
        else if (name.contains("coelacanth") || name.contains("orthacanthus"))
            eggModel = fishEgg;

        if (!entity.isDead) {
            GL11.glPushMatrix();

            GL11.glTranslatef((float) x, ((float) y + 1.5F), (float) z);

            GL11.glRotatef(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(entity.rotationPitch, 1, 0, 0);
            float f4 = 0.75F;

            GL11.glScalef(f4, f4, f4);
            GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
            this.bindEntityTexture(entity);
            GL11.glScalef(-1.0F, -1.0F, 1.0F);

            if (entity.froze) {
                GL11.glColor3f(1F, 1F, 2F);
            }

            if (entity.dried) {
                GL11.glColor3f(1.5F, 1.1F, 1F);
            }

            eggModel.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return ((EntityDinoEgg) entity).getTexture();
    }
}
