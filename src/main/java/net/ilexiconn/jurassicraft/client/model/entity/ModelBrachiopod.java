package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.common.entity.cephalopods.EntityBrachiopod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrachiopod extends ModelBase {
    ModelRenderer backBottom;
    ModelRenderer frontBottom;
    ModelRenderer shellBottom;
    ModelRenderer rightBottom;
    ModelRenderer leftBottom;
    ModelRenderer leftTop;
    ModelRenderer shellTop;
    ModelRenderer frontTop;
    ModelRenderer pearl;
    ModelRenderer backTop;
    ModelRenderer rightTop;

    public ModelBrachiopod() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.backBottom = new ModelRenderer(this, 0, 27)).addBox(0.0f, 0.0f, 0.0f, 14, 4, 1);
        this.backBottom.setRotationPoint(-7.0f, 20.0f, 6.0f);
        this.backBottom.setTextureSize(64, 32);
        this.backBottom.mirror = true;
        this.setRotation(this.backBottom, 0.0f, 0.0f, 0.0f);
        (this.frontBottom = new ModelRenderer(this, 0, 26)).addBox(0.0f, 0.0f, 0.0f, 14, 5, 1);
        this.frontBottom.setRotationPoint(-7.0f, 19.0f, -7.0f);
        this.frontBottom.setTextureSize(64, 32);
        this.frontBottom.mirror = true;
        this.setRotation(this.frontBottom, 0.0f, 0.0f, 0.0f);
        (this.shellBottom = new ModelRenderer(this, 0, 0)).addBox(-7.0f, 23.0f, -7.0f, 14, 1, 14);
        this.shellBottom.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.shellBottom.setTextureSize(64, 32);
        this.shellBottom.mirror = true;
        this.setRotation(this.shellBottom, 0.0f, 0.0f, 0.0f);
        (this.rightBottom = new ModelRenderer(this, 32, 10)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 14);
        this.rightBottom.setRotationPoint(-7.0f, 20.0f, -7.0f);
        this.rightBottom.setTextureSize(64, 32);
        this.rightBottom.mirror = true;
        this.setRotation(this.rightBottom, 0.0f, 0.0f, 0.0f);
        (this.leftBottom = new ModelRenderer(this, 32, 10)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 14);
        this.leftBottom.setRotationPoint(6.0f, 20.0f, -7.0f);
        this.leftBottom.setTextureSize(64, 32);
        this.leftBottom.mirror = true;
        this.setRotation(this.leftBottom, 0.0f, 0.0f, 0.0f);
        (this.leftTop = new ModelRenderer(this, 32, 10)).addBox(5.0f, -4.0f, -14.0f, 1, 4, 14);
        this.leftTop.setRotationPoint(1.0f, 20.0f, 7.0f);
        this.leftTop.setTextureSize(64, 32);
        this.leftTop.mirror = true;
        this.setRotation(this.leftTop, 0.0f, 0.0f, 0.0f);
        (this.shellTop = new ModelRenderer(this, 0, 0)).addBox(-8.0f, -4.0f, -14.0f, 14, 1, 14);
        this.shellTop.setRotationPoint(1.0f, 20.0f, 7.0f);
        this.shellTop.setTextureSize(64, 32);
        this.shellTop.mirror = true;
        this.setRotation(this.shellTop, 0.0f, 0.0f, 0.0f);
        (this.frontTop = new ModelRenderer(this, 0, 26)).addBox(-8.0f, -4.0f, -14.0f, 14, 5, 1);
        this.frontTop.setRotationPoint(1.0f, 20.0f, 7.0f);
        this.frontTop.setTextureSize(64, 32);
        this.frontTop.mirror = true;
        this.setRotation(this.frontTop, 0.0f, 0.0f, 0.0f);
        (this.pearl = new ModelRenderer(this, 0, 17)).addBox(0.0f, 0.0f, -0.1f, 6, 2, 6);
        this.pearl.setRotationPoint(-3.0f, 21.0f, 1.0f);
        this.pearl.setTextureSize(64, 32);
        this.pearl.mirror = true;
        this.setRotation(this.pearl, 0.0f, 0.0f, 0.0f);
        (this.backTop = new ModelRenderer(this, 0, 26)).addBox(-8.0f, -4.0f, -1.0f, 14, 5, 1);
        this.backTop.setRotationPoint(1.0f, 20.0f, 7.0f);
        this.backTop.setTextureSize(64, 32);
        this.backTop.mirror = true;
        this.setRotation(this.backTop, 0.0f, 0.0f, 0.0f);
        (this.rightTop = new ModelRenderer(this, 32, 10)).addBox(-8.0f, -4.0f, -14.0f, 1, 4, 14);
        this.rightTop.setRotationPoint(1.0f, 20.0f, 7.0f);
        this.rightTop.setTextureSize(64, 32);
        this.rightTop.mirror = true;
        this.setRotation(this.rightTop, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.backBottom.render(f5);
        this.frontBottom.render(f5);
        this.shellBottom.render(f5);
        this.rightBottom.render(f5);
        this.leftBottom.render(f5);
        this.leftTop.render(f5);
        this.shellTop.render(f5);
        this.frontTop.render(f5);
        final EntityBrachiopod brachipod = (EntityBrachiopod) entity;
        if (brachipod.hasPearl()) {
            this.pearl.render(f5);
        }
        this.backTop.render(f5);
        this.rightTop.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        final EntityBrachiopod brachipod = (EntityBrachiopod) entity;
        this.shellTop.rotateAngleX = brachipod.getOpenMouth(100.0f);
        this.frontTop.rotateAngleX = brachipod.getOpenMouth(100.0f);
        this.backTop.rotateAngleX = brachipod.getOpenMouth(100.0f);
        this.rightTop.rotateAngleX = brachipod.getOpenMouth(100.0f);
        this.leftTop.rotateAngleX = brachipod.getOpenMouth(100.0f);
    }
}
