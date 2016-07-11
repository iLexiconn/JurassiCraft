package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.entity.fish.EntityCoelacanth;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCoelacanth extends MowzieModelBase {
    public MowzieModelRenderer headTop;
    public MowzieModelRenderer headBottom;
    public MowzieModelRenderer body;
    public MowzieModelRenderer bottomFinLeft;
    public MowzieModelRenderer bottomFinRight;
    public MowzieModelRenderer sideFinLeft;
    public MowzieModelRenderer sideFinRight;
    public MowzieModelRenderer topFin1;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer topFin2;
    public MowzieModelRenderer bottomFin3;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tailFin;
    private MowzieModelRenderer[] bodyParts;

    public ModelCoelacanth() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.headBottom = new MowzieModelRenderer(this, 45, 23);
        this.headBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headBottom.addBox(-1.5F, 3.0F, -6.75F, 3, 2, 7);
        this.setRotateAngle(headBottom, -0.2617993877991494F, 0.0F, 0.0F);
        this.sideFinLeft = new MowzieModelRenderer(this, 0, 4);
        this.sideFinLeft.setRotationPoint(1.5F, 2.5F, 2.5F);
        this.sideFinLeft.addBox(0.0F, 0.0F, -1.5F, 6, 0, 3);
        this.setRotateAngle(sideFinLeft, 0.0F, -0.0F, 0.20943951023931953F);
        this.bottomFinLeft = new MowzieModelRenderer(this, 7, 9);
        this.bottomFinLeft.setRotationPoint(0.0F, 5.0F, 4.0F);
        this.bottomFinLeft.addBox(0.0F, 0.0F, -1.5F, 0, 4, 3);
        this.setRotateAngle(bottomFinLeft, 0.0F, 0.0F, -0.4363323129985824F);
        this.topFin1 = new MowzieModelRenderer(this, 0, 10);
        this.topFin1.setRotationPoint(0.0F, -2.75F, 1.3F);
        this.topFin1.addBox(0.0F, -3.0F, -1.0F, 0, 3, 3);
        this.tailFin = new MowzieModelRenderer(this, 45, -9);
        this.tailFin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFin.addBox(0.0F, -3.5F, 0.0F, 0, 7, 10);
        this.tail1 = new MowzieModelRenderer(this, 44, 9);
        this.tail1.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.tail1.addBox(-1.5F, -2.0F, 0.0F, 3, 6, 8);
        this.topFin2 = new MowzieModelRenderer(this, 0, 17);
        this.topFin2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.topFin2.addBox(0.0F, -3.0F, -1.5F, 0, 3, 3);
        this.setRotateAngle(topFin2, -0.47123889803846897F, 0.0F, 0.0F);
        this.sideFinRight = new MowzieModelRenderer(this, 0, 0);
        this.sideFinRight.setRotationPoint(-1.5F, 2.5F, 2.5F);
        this.sideFinRight.addBox(-6.0F, 0.0F, -1.5F, 6, 0, 3);
        this.setRotateAngle(sideFinRight, 0.0F, -0.0F, -0.20943951023931953F);
        this.headTop = new MowzieModelRenderer(this, 20, 0);
        this.headTop.setRotationPoint(0.0F, 18.9F, -1.2F);
        this.headTop.addBox(-2.0F, -3.0F, -8.0F, 4, 6, 8);
        this.setRotateAngle(headTop, 0.2617993877991494F, 0.0F, 0.0F);
        this.body = new MowzieModelRenderer(this, 19, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-2.0F, -2.9F, -0.8F, 4, 8, 8);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.bottomFinRight = new MowzieModelRenderer(this, 14, 9);
        this.bottomFinRight.setRotationPoint(0.0F, 5.0F, 4.0F);
        this.bottomFinRight.addBox(0.0F, 0.0F, -1.5F, 0, 4, 3);
        this.setRotateAngle(bottomFinRight, 0.0F, 0.0F, 0.4363323129985824F);
        this.tail2 = new MowzieModelRenderer(this, 4, 23);
        this.tail2.setRotationPoint(0.0F, 1.0F, 8.0F);
        this.tail2.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 5);
        this.bottomFin3 = new MowzieModelRenderer(this, 7, 17);
        this.bottomFin3.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.bottomFin3.addBox(0.0F, 0.0F, -1.5F, 0, 3, 3);
        this.setRotateAngle(bottomFin3, 0.47123889803846897F, 0.0F, 0.0F);

        this.headTop.addChild(this.headBottom);
        this.headTop.addChild(this.body);
        this.body.addChild(this.sideFinLeft);
        this.body.addChild(this.sideFinRight);
        this.body.addChild(this.bottomFinLeft);
        this.body.addChild(this.bottomFinRight);
        this.body.addChild(this.topFin1);
        this.body.addChild(this.tail1);
        this.tail1.addChild(this.bottomFin3);
        this.tail1.addChild(this.topFin2);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.tailFin);

        this.bodyParts = new MowzieModelRenderer[] { this.tail2, this.tail1, this.body, this.headTop };

        this.headTop.updateDefaultPose();
        this.headBottom.updateDefaultPose();
        this.body.updateDefaultPose();
        this.bottomFinLeft.updateDefaultPose();
        this.bottomFinRight.updateDefaultPose();
        this.sideFinLeft.updateDefaultPose();
        this.sideFinRight.updateDefaultPose();
        this.topFin1.updateDefaultPose();
        this.tail1.updateDefaultPose();
        this.topFin2.updateDefaultPose();
        this.bottomFin3.updateDefaultPose();
        this.tail2.updateDefaultPose();
        this.tailFin.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityCoelacanth) entity);
        this.headTop.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityCoelacanth coelacanth) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, coelacanth);
        this.resetPose();
        if (coelacanth.isAirBorne || coelacanth.isInWater()) {
            this.headTop.rotateAngleZ = 1.57079633F * coelacanth.droppingTimer.getAnimationProgressSinSqrt();

            this.walk(this.sideFinLeft, 0.6F, 0.6F, true, 0.0F, 0.8F, f, f1);
            this.walk(this.sideFinRight, 0.6F, 0.6F, false, 0.0F, 0.8F, f, f1);

            this.flap(this.sideFinLeft, 0.6F, 0.6F, false, 0.0F, 0.8F, f, f1);
            this.flap(this.sideFinRight, 0.6F, 0.6F, true, 0.0F, -0.8F, f, f1);

            this.chainSwing(this.bodyParts, 0.6F, 0.75F, 3.0D, f, f1);
            headTop.rotationPointX -= -4 * f1 * Math.sin((f + 1) * 0.6);

            // Idle
            this.bob(this.headTop, 0.04F, 2.0F, false, coelacanth.frame, 1.0F);

            this.flap(this.sideFinLeft, 0.2F, 0.25F, false, 1.0F, 0.0F, coelacanth.frame, 1.0F);
            this.flap(this.bottomFinLeft, 0.1F, 0.075F, false, 1.0F, 0.0F, coelacanth.frame, 1.0F);

            this.flap(this.sideFinRight, 0.2F, 0.25F, true, 1.0F, 0.0F, coelacanth.frame, 1.0F);
            this.flap(this.bottomFinRight, 0.1F, 0.075F, true, 1.0F, 0.0F, coelacanth.frame, 1.0F);

            this.chainSwing(this.bodyParts, 0.05F, -0.075F, 1.5D, coelacanth.frame, 1.0F);
            coelacanth.tailBuffer.applyChainSwingBuffer(this.bodyParts);
        } else {
            float droppingProgress = coelacanth.droppingTimer.getAnimationProgressSinSqrt();

            this.headTop.rotateAngleZ = 1.57079633F * droppingProgress;
            this.headTop.rotationPointY += 4.0F * droppingProgress;

            this.bob(this.headTop, 0.3F, 4.0F, true, coelacanth.frame, 1.0F);
            headTop.rotateAngleY += 0.3 * Math.cos((coelacanth.frame + 1) * 0.6F);
            body.rotateAngleY -= 0.3 * Math.cos((coelacanth.frame + 1) * 0.6F);

            this.flap(this.sideFinLeft, 1.2F, 0.25F, false, 1.0F, 1.0F, coelacanth.frame, 1.0F);
            this.flap(this.sideFinRight, 1.2F, 0.25F, true, 1.0F, -1.0F, coelacanth.frame, 1.0F);

            this.chainSwing(this.bodyParts, 0.6F, 0.16F, 3.0D, coelacanth.frame, 1.0F);
        }
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void resetPose() {
        this.headTop.resetToDefaultPose();
        this.headBottom.resetToDefaultPose();
        this.body.resetToDefaultPose();
        this.bottomFinLeft.resetToDefaultPose();
        this.bottomFinRight.resetToDefaultPose();
        this.sideFinLeft.resetToDefaultPose();
        this.sideFinRight.resetToDefaultPose();
        this.topFin1.resetToDefaultPose();
        this.tail1.resetToDefaultPose();
        this.topFin2.resetToDefaultPose();
        this.bottomFin3.resetToDefaultPose();
        this.tail2.resetToDefaultPose();
        this.tailFin.resetToDefaultPose();
    }
}
