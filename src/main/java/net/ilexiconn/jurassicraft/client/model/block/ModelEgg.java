package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEgg extends ModelBase {
    public ModelRenderer[] shapes = new ModelRenderer[4];

    public ModelEgg() {
        textureWidth = 64;
        textureHeight = 32;

        shapes[0] = new ModelRenderer(this, 0, 21);
        shapes[0].addBox(-3F, 0F, -3F, 6, 5, 6);
        shapes[0].setRotationPoint(0F, 18F, 0F);

        shapes[1] = new ModelRenderer(this, 0, 14);
        shapes[1].addBox(-2.5F, 0F, -2.5F, 5, 2, 5);
        shapes[1].setRotationPoint(0F, 22F, 0F);

        shapes[2] = new ModelRenderer(this, 24, 24);
        shapes[2].addBox(-2.5F, 0F, -2.5F, 5, 3, 5);
        shapes[2].setRotationPoint(0F, 16F, 0F);

        shapes[3] = new ModelRenderer(this, 24, 18);
        shapes[3].addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
        shapes[3].setRotationPoint(0F, 15F, 0F);

        for (ModelRenderer shape : shapes)
            shape.setTextureSize(64, 32);
    }

    public void render(Entity entity, float x, float y, float z, float x1, float y1, float z1) {
        super.render(entity, x, y, z, x1, y1, z1);
        render();
    }

    public void render() {
        for (ModelRenderer shape : shapes)
            shape.render(0.0625f);
    }
}