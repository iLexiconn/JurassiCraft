package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCultivate extends ModelBase {
    public ModelRenderer[] shapes = new ModelRenderer[7];

    public ModelCultivate() {
        textureWidth = 64;
        textureHeight = 64;

        shapes[0] = new ModelRenderer(this, 0, 0);
        shapes[0].addBox(0f, 0f, 0f, 16, 6, 16);
        shapes[0].setRotationPoint(-8f, 18f, -8f);

        shapes[1] = new ModelRenderer(this, 56, 22);
        shapes[1].addBox(0f, 0f, 0f, 1, 25, 1);
        shapes[1].setRotationPoint(7f, -7f, -8f);

        shapes[2] = new ModelRenderer(this, 56, 22);
        shapes[2].addBox(0f, 0f, 0f, 1, 25, 1);
        shapes[2].setRotationPoint(-8f, -7f, -8f);

        shapes[3] = new ModelRenderer(this, 56, 22);
        shapes[3].addBox(0f, 0f, 0f, 1, 25, 1);
        shapes[3].setRotationPoint(7f, -7f, 7f);

        shapes[4] = new ModelRenderer(this, 56, 22);
        shapes[4].addBox(0f, 0f, 0f, 1, 25, 1);
        shapes[4].setRotationPoint(-8f, -7f, 7f);

        shapes[5] = new ModelRenderer(this, 0, 0);
        shapes[5].addBox(0f, 0f, 0f, 16, 1, 16);
        shapes[5].setRotationPoint(-8f, -8f, -8f);

        shapes[6] = new ModelRenderer(this, 0, 22);
        shapes[6].addBox(0f, 0f, 0f, 14, 25, 14);
        shapes[6].setRotationPoint(-7f, -7f, -7f);

        for (ModelRenderer shape : shapes)
            shape.setTextureSize(64, 64);
    }

    public void render(boolean glass) {
        for (int i = 0; i < shapes.length - 1; i++)
            shapes[i].render(0.0625f);

        if (glass)
            shapes[6].render(0.0625f);
    }

    public void renderGlass() {
        shapes[6].render(0.0625f);
    }
}