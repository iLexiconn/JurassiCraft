package net.ilexiconn.jurassicraft.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmmonite extends ModelBase {
    ModelRenderer shellbase;
    ModelRenderer shellside1;
    ModelRenderer shellside2;
    ModelRenderer headpiece;
    ModelRenderer tentacle1;
    ModelRenderer tentacle2;
    ModelRenderer tentacle3;
    ModelRenderer tentacle4;

    public ModelAmmonite() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.shellbase = new ModelRenderer(this, 0, 4).addBox(0.0f, 0.0f, 0.0f, 3, 5, 5);
        this.shellbase.setRotationPoint(-1.5f, 18.0f, -2.0f);
        this.shellbase.setTextureSize(64, 32);
        this.shellbase.mirror = true;

        this.shellside1 = new ModelRenderer(this, 25, 0).addBox(0.0f, 0.0f, 0.0f, 1, 3, 3);
        this.shellside1.setRotationPoint(-2.0f, 19.0f, -1.0f);
        this.shellside1.setTextureSize(64, 32);
        this.shellside1.mirror = true;

        this.shellside2 = new ModelRenderer(this, 25, 0).addBox(0.0f, 0.0f, 0.0f, 1, 3, 3);
        this.shellside2.setRotationPoint(1.0f, 19.0f, -1.0f);
        this.shellside2.setTextureSize(64, 32);
        this.shellside2.mirror = true;

        this.headpiece = new ModelRenderer(this, 9, 0).addBox(0.0f, 0.0f, 0.0f, 2, 2, 1);
        this.headpiece.setRotationPoint(-1.0f, 20.5f, -2.5f);
        this.headpiece.setTextureSize(64, 32);
        this.headpiece.mirror = true;

        this.tentacle1 = new ModelRenderer(this, 0, 0).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.tentacle1.setRotationPoint(0.0f, 20.5f, -4.0f);
        this.tentacle1.setTextureSize(64, 32);
        this.tentacle1.mirror = true;

        this.tentacle2 = new ModelRenderer(this, 0, 0).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.tentacle2.setRotationPoint(0.0f, 21.5f, -4.0f);
        this.tentacle2.setTextureSize(64, 32);
        this.tentacle2.mirror = true;

        this.tentacle3 = new ModelRenderer(this, 0, 0).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.tentacle3.setRotationPoint(-1.0f, 21.5f, -4.0f);
        this.tentacle3.setTextureSize(64, 32);
        this.tentacle3.mirror = true;

        this.tentacle4 = new ModelRenderer(this, 0, 0).addBox(0.0f, 0.0f, 0.0f, 1, 1, 2);
        this.tentacle4.setRotationPoint(-1.0f, 20.5f, -4.0f);
        this.tentacle4.setTextureSize(64, 32);
        this.tentacle4.mirror = true;
    }

    public void render(Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        this.shellbase.render(f5);
        this.shellside1.render(f5);
        this.shellside2.render(f5);
        this.headpiece.render(f5);
        this.tentacle1.render(f5);
        this.tentacle2.render(f5);
        this.tentacle3.render(f5);
        this.tentacle4.render(f5);
    }
}
