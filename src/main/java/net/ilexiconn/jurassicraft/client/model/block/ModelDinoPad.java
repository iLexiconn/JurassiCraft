package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDinoPad extends ModelBase {
    ModelRenderer dinoPad;

    public ModelDinoPad() {
        textureWidth = 64;
        textureHeight = 32;

        dinoPad = new ModelRenderer(this, 0, 0);
        dinoPad.addBox(-6.5F, -1F, -4.5F, 13, 2, 9);
        dinoPad.setRotationPoint(0F, 23F, 0F);
        dinoPad.setTextureSize(64, 32);
        dinoPad.mirror = true;

        setRotation(dinoPad, 0F, -0.2617994F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        dinoPad.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
