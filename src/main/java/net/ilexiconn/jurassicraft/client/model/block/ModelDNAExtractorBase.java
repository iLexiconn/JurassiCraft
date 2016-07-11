package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDNAExtractorBase extends ModelBase {
    ModelRenderer base1;
    ModelRenderer middle1;
    ModelRenderer middle2;
    ModelRenderer bottom1;
    ModelRenderer bottom2;
    ModelRenderer bottom3;
    ModelRenderer bottom4;

    public ModelDNAExtractorBase() {
        textureWidth = 64;
        textureHeight = 64;

        base1 = new ModelRenderer(this, 0, 0);
        base1.addBox(-7F, -3F, -7F, 14, 2, 14);
        base1.setRotationPoint(0F, 24F, 0F);
        base1.setTextureSize(64, 64);
        base1.mirror = true;

        middle1 = new ModelRenderer(this, 0, 16);
        middle1.addBox(-7F, -15F, -7F, 6, 12, 14);
        middle1.setRotationPoint(0F, 24F, 0F);
        middle1.setTextureSize(64, 64);
        middle1.mirror = true;

        middle2 = new ModelRenderer(this, 0, 42);
        middle2.addBox(-1F, -15F, 1F, 8, 12, 6);
        middle2.setRotationPoint(0F, 24F, 0F);
        middle2.setTextureSize(64, 64);
        middle2.mirror = true;

        bottom1 = new ModelRenderer(this, 46, 35);
        bottom1.addBox(-7F, -1F, -7F, 3, 1, 3);
        bottom1.setRotationPoint(0F, 24F, 0F);
        bottom1.setTextureSize(64, 64);
        bottom1.mirror = true;

        bottom2 = new ModelRenderer(this, 46, 35);
        bottom2.addBox(4F, -1F, -7F, 3, 1, 3);
        bottom2.setRotationPoint(0F, 24F, 0F);
        bottom2.setTextureSize(64, 64);
        bottom2.mirror = true;

        bottom3 = new ModelRenderer(this, 46, 35);
        bottom3.addBox(4F, -1F, 4F, 3, 1, 3);
        bottom3.setRotationPoint(0F, 24F, 0F);
        bottom3.setTextureSize(64, 64);
        bottom3.mirror = true;

        bottom4 = new ModelRenderer(this, 46, 35);
        bottom4.addBox(-7F, -1F, 4F, 3, 1, 3);
        bottom4.setRotationPoint(0F, 24F, 0F);
        bottom4.setTextureSize(64, 64);
        bottom4.mirror = true;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);

        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        base1.render(f5);
        middle1.render(f5);
        middle2.render(f5);
        bottom1.render(f5);
        bottom2.render(f5);
        bottom3.render(f5);
        bottom4.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
