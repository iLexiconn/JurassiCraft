package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.entity.fish.EntityOrthacanthus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOrthacanthus extends MowzieModelBase {
    public MowzieModelRenderer head;
    public MowzieModelRenderer mouth;
    public MowzieModelRenderer body1;
    public MowzieModelRenderer hornTop;
    public MowzieModelRenderer fliperLeft1;
    public MowzieModelRenderer fliperRight1;
    public MowzieModelRenderer finFront1;
    public MowzieModelRenderer body2;
    public MowzieModelRenderer fliperLeft2;
    public MowzieModelRenderer fliperRight2;
    public MowzieModelRenderer finFront2;
    public MowzieModelRenderer body3;
    public MowzieModelRenderer fliperLeft3;
    public MowzieModelRenderer fliperRight3;
    public MowzieModelRenderer finFront3;
    public MowzieModelRenderer body4;
    public MowzieModelRenderer fliperLeft4;
    public MowzieModelRenderer fliperRight4;
    public MowzieModelRenderer body5;
    public MowzieModelRenderer finBack;
    private MowzieModelRenderer[] tailParts;
    private MowzieModelRenderer[] shortTailParts;

    public ModelOrthacanthus() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.body3 = new MowzieModelRenderer(this, 28, 22);
        this.body3.setRotationPoint(0.0F, 0.0F, 7.75F);
        this.body3.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 8);
        this.finBack = new MowzieModelRenderer(this, 47, 36);
        this.finBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.finBack.addBox(0.0F, -4.5F, 0.0F, 0, 7, 9);
        this.fliperLeft1 = new MowzieModelRenderer(this, 0, 49);
        this.fliperLeft1.mirror = true;
        this.fliperLeft1.setRotationPoint(2.5F, 0.0F, 6.0F);
        this.fliperLeft1.addBox(0.0F, 0.0F, -3.0F, 7, 0, 6);
        this.setRotateAngle(fliperLeft1, 0.08726646259971647F, -0.17453292519943295F, 0.6108652381980153F);
        this.body5 = new MowzieModelRenderer(this, 28, 54);
        this.body5.setRotationPoint(0.0F, 0.0F, 6.75F);
        this.body5.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 9);
        this.finFront1 = new MowzieModelRenderer(this, 70, -5);
        this.finFront1.setRotationPoint(0.0F, -3.0F, 4.0F);
        this.finFront1.addBox(0.0F, -4.5F, 0.0F, 0, 5, 10);
        this.hornTop = new MowzieModelRenderer(this, 28, 4);
        this.hornTop.setRotationPoint(0.0F, -3.0F, 3.5F);
        this.hornTop.addBox(-0.5F, -5.5F, -0.5F, 1, 6, 1);
        this.setRotateAngle(hornTop, -0.37175513067479216F, -0.0F, 0.0F);
        this.body2 = new MowzieModelRenderer(this, 0, 22);
        this.body2.setRotationPoint(0.0F, 0.0F, 13.75F);
        this.body2.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 8);
        this.body1 = new MowzieModelRenderer(this, 0, 0);
        this.body1.setRotationPoint(0.0F, 1.0F, -0.25F);
        this.body1.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 14);
        this.setRotateAngle(body1, -0.08726646259971647F, 0.0F, 0.0F);
        this.mouth = new MowzieModelRenderer(this, 24, 36);
        this.mouth.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.mouth.addBox(-2.0F, 0.0F, -5.85F, 4, 2, 6);
        this.fliperRight4 = new MowzieModelRenderer(this, 0, 63);
        this.fliperRight4.setRotationPoint(-1.5F, 0.25F, 2.0F);
        this.fliperRight4.addBox(-2.0F, 0.0F, -1.0F, 2, 0, 2);
        this.setRotateAngle(fliperRight4, 0.08726646259971647F, 0.17453292519943295F, -0.6108652381980153F);
        this.fliperLeft2 = new MowzieModelRenderer(this, 0, 57);
        this.fliperLeft2.mirror = true;
        this.fliperLeft2.setRotationPoint(2.0F, 0.0F, 3.5F);
        this.fliperLeft2.addBox(0.0F, 0.0F, -2.0F, 5, 0, 4);
        this.setRotateAngle(fliperLeft2, 0.08726646259971647F, -0.17453292519943295F, 0.6108652381980153F);
        this.body4 = new MowzieModelRenderer(this, 41, 0);
        this.body4.setRotationPoint(0.0F, 0.0F, 7.75F);
        this.body4.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 7);
        this.finFront3 = new MowzieModelRenderer(this, 70, 11);
        this.finFront3.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.finFront3.addBox(0.0F, -4.5F, 0.0F, 0, 5, 10);
        this.fliperRight3 = new MowzieModelRenderer(this, 0, 63);
        this.fliperRight3.setRotationPoint(-2.0F, 0.0F, 2.5F);
        this.fliperRight3.addBox(-3.0F, 0.0F, -1.0F, 3, 0, 2);
        this.setRotateAngle(fliperRight3, 0.08726646259971647F, 0.17453292519943295F, -0.6108652381980153F);
        this.head = new MowzieModelRenderer(this, 0, 37);
        this.head.setRotationPoint(0.0F, 16.5F, -9.0F);
        this.head.addBox(-2.5F, -2.0F, -6.0F, 5, 4, 6);
        this.setRotateAngle(head, 0.08726646259971647F, 0.0F, 0.0F);
        this.fliperRight1 = new MowzieModelRenderer(this, 0, 49);
        this.fliperRight1.setRotationPoint(-2.5F, 0.0F, 6.0F);
        this.fliperRight1.addBox(-7.0F, 0.0F, -3.0F, 7, 0, 6);
        this.setRotateAngle(fliperRight1, 0.08726646259971647F, 0.17453292519943295F, -0.6108652381980153F);
        this.fliperRight2 = new MowzieModelRenderer(this, 0, 57);
        this.fliperRight2.setRotationPoint(-2.0F, 0.0F, 3.5F);
        this.fliperRight2.addBox(-5.0F, 0.0F, -2.0F, 5, 0, 4);
        this.setRotateAngle(fliperRight2, 0.08726646259971647F, 0.17453292519943295F, -0.6108652381980153F);
        this.fliperLeft4 = new MowzieModelRenderer(this, 0, 63);
        this.fliperLeft4.setRotationPoint(1.5F, 0.25F, 2.0F);
        this.fliperLeft4.addBox(0.0F, 0.0F, -1.0F, 2, 0, 2);
        this.setRotateAngle(fliperLeft4, 0.08726646259971647F, -0.17453292519943295F, 0.6108652381980153F);
        this.fliperLeft3 = new MowzieModelRenderer(this, 0, 63);
        this.fliperLeft3.mirror = true;
        this.fliperLeft3.setRotationPoint(2.0F, 0.0F, 3.5F);
        this.fliperLeft3.addBox(0.0F, 0.0F, -1.0F, 3, 0, 2);
        this.setRotateAngle(fliperLeft3, 0.08726646259971647F, -0.17453292519943295F, 0.6108652381980153F);
        this.finFront2 = new MowzieModelRenderer(this, 72, 5);
        this.finFront2.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.finFront2.addBox(0.0F, -4.5F, 0.0F, 0, 5, 8);

        this.head.addChild(this.mouth);
        this.head.addChild(this.body1);

        this.body1.addChild(this.fliperLeft1);
        this.body1.addChild(this.fliperRight1);
        this.body1.addChild(this.hornTop);
        this.body1.addChild(this.finFront1);
        this.body1.addChild(this.body2);

        this.body2.addChild(this.fliperLeft2);
        this.body2.addChild(this.fliperRight2);
        this.body2.addChild(this.finFront2);
        this.body2.addChild(this.body3);

        this.body3.addChild(this.fliperRight3);
        this.body3.addChild(this.fliperLeft3);
        this.body3.addChild(this.finFront3);
        this.body3.addChild(this.body4);

        this.body4.addChild(this.fliperLeft4);
        this.body4.addChild(this.fliperRight4);
        this.body5.addChild(this.finBack);
        this.body4.addChild(this.body5);

        this.tailParts = new MowzieModelRenderer[] { this.body5, this.body4, this.body3, this.body2, this.body1, this.head };
        this.shortTailParts = new MowzieModelRenderer[] { this.body5, this.body4, this.body3, this.body2, this.body1 };

        this.head.updateDefaultPose();
        this.mouth.updateDefaultPose();
        this.body1.updateDefaultPose();
        this.hornTop.updateDefaultPose();
        this.fliperLeft1.updateDefaultPose();
        this.fliperRight1.updateDefaultPose();
        this.finFront1.updateDefaultPose();
        this.body2.updateDefaultPose();
        this.fliperLeft2.updateDefaultPose();
        this.fliperRight2.updateDefaultPose();
        this.finFront2.updateDefaultPose();
        this.body3.updateDefaultPose();
        this.fliperLeft3.updateDefaultPose();
        this.fliperRight3.updateDefaultPose();
        this.finFront3.updateDefaultPose();
        this.body4.updateDefaultPose();
        this.fliperLeft4.updateDefaultPose();
        this.fliperRight4.updateDefaultPose();
        this.body5.updateDefaultPose();
        this.finBack.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityOrthacanthus) entity);
        this.head.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityOrthacanthus orthacanthus) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, orthacanthus);
        this.resetPose();
        /*
         * f = orthacanthus.frame; f1 = 0.4F;
         */
        float globalSpeed = 0.6F;
        if (orthacanthus.isAirBorne || orthacanthus.isInWater()) {
            this.flap(this.fliperLeft1, 1.0F * globalSpeed, 0.7F, false, 0.0F, -0.8F, f, f1);
            this.flap(this.fliperLeft2, 1.0F * globalSpeed, 0.7F, false, -1F, -0.8F, f, f1);
            this.flap(this.fliperLeft3, 1.0F * globalSpeed, 0.7F, false, -2F, -0.8F, f, f1);
            this.flap(this.fliperLeft4, 1.0F * globalSpeed, 0.7F, false, -3F, -0.8F, f, f1);

            this.flap(this.fliperRight1, 1.0F * globalSpeed, 0.7F, true, 0.0F, 0.8F, f, f1);
            this.flap(this.fliperRight2, 1.0F * globalSpeed, 0.7F, true, -1F, 0.8F, f, f1);
            this.flap(this.fliperRight3, 1.0F * globalSpeed, 0.7F, true, -2F, 0.8F, f, f1);
            this.flap(this.fliperRight4, 1.0F * globalSpeed, 0.7F, true, -3F, 0.8F, f, f1);

            this.chainSwing(this.tailParts, 1.0F * globalSpeed, 0.5F, 3.0D, f, f1);
            head.rotationPointX -= -5 * f1 * Math.sin((f + 1) * globalSpeed);

            // Idle
            this.walk(this.mouth, 0.1F, 0.1F, false, 0.0F, 0.1F, orthacanthus.frame, 1.0F);

            this.flap(this.fliperLeft1, 0.2F, 0.25F, false, 0.0F, 0.0F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperLeft2, 0.2F, 0.2F, false, -1F, 0.0F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperLeft3, 0.2F, 0.15F, false, -2F, 0.0F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperLeft4, 0.2F, 0.15F, false, -3F, 0.0F, orthacanthus.frame, 1.0F);

            this.flap(this.fliperRight1, 0.2F, 0.25F, true, 0.0F, 0.0F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperRight2, 0.2F, 0.2F, true, -1F, 0.0F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperRight3, 0.2F, 0.15F, true, -2F, 0.0F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperRight4, 0.2F, 0.15F, true, -3F, 0.0F, orthacanthus.frame, 1.0F);

            this.chainWave(this.tailParts, 0.025F, -0.05F, 3.0D, orthacanthus.frame, 1.0F);
            this.chainSwing(this.tailParts, 0.05F, 0.05F, 1.5D, orthacanthus.frame, 1.0F);

            orthacanthus.tailBuffer.applyChainSwingBuffer(this.tailParts);
        } else {
            this.head.rotationPointY += 4.0F;
            this.bob(this.head, 0.3F, 4.0F, true, orthacanthus.frame, 1.0F);
            this.flap(this.head, 0.3F, 0.5F, false, 0.0F, 0.0F, orthacanthus.frame, 1.0F);

            this.flap(this.fliperLeft1, 1.0F, 0.7F, false, 0.0F, -0.8F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperLeft2, 1.0F, 0.7F, false, 0.0F, -0.8F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperLeft3, 1.0F, 0.7F, false, 0.0F, -0.8F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperLeft4, 1.0F, 0.7F, false, 0.0F, -0.8F, orthacanthus.frame, 1.0F);

            this.flap(this.fliperRight1, 1.0F, 0.7F, true, 0.0F, 0.8F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperRight2, 1.0F, 0.7F, true, 0.0F, 0.8F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperRight3, 1.0F, 0.7F, true, 0.0F, 0.8F, orthacanthus.frame, 1.0F);
            this.flap(this.fliperRight4, 1.0F, 0.7F, true, 0.0F, 0.8F, orthacanthus.frame, 1.0F);

            this.chainWave(this.shortTailParts, 0.6F, -0.1F, 3.0D, orthacanthus.frame, 1.0F);
        }
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void resetPose() {
        this.head.resetToDefaultPose();
        this.mouth.resetToDefaultPose();
        this.body1.resetToDefaultPose();
        this.hornTop.resetToDefaultPose();
        this.fliperLeft1.resetToDefaultPose();
        this.fliperRight1.resetToDefaultPose();
        this.finFront1.resetToDefaultPose();
        this.body2.resetToDefaultPose();
        this.fliperLeft2.resetToDefaultPose();
        this.fliperRight2.resetToDefaultPose();
        this.finFront2.resetToDefaultPose();
        this.body3.resetToDefaultPose();
        this.fliperLeft3.resetToDefaultPose();
        this.fliperRight3.resetToDefaultPose();
        this.finFront3.resetToDefaultPose();
        this.body4.resetToDefaultPose();
        this.fliperLeft4.resetToDefaultPose();
        this.fliperRight4.resetToDefaultPose();
        this.body5.resetToDefaultPose();
        this.finBack.resetToDefaultPose();
    }
}
