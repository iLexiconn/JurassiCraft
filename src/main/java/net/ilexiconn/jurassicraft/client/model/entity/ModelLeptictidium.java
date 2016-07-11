package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityLeptictidium;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelLeptictidium - RafaMv Created using Tabula 4.0.2
 */
public class ModelLeptictidium extends MowzieModelBase {
    public MowzieModelRenderer body1, body2, neck, head1, earLeft, earRight, head2, snout1, snout2, mouth1, mouth2, mouth3;
    public MowzieModelRenderer leftLeg1, leftLeg2, leftLeg3, leftFoot, rightLeg1, rightLeg2, rightLeg3, rightFoot;
    public MowzieModelRenderer rightHand, rightHand2, leftHand, leftHand2;
    public MowzieModelRenderer tail1, tail2, tail3, tail4, tail5;
    private MowzieModelRenderer[] tailParts;
    private MowzieModelRenderer[] noseParts;

    public ModelLeptictidium() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.body1 = new MowzieModelRenderer(this, 0, 0);
        this.body1.setRotationPoint(0.0F, 16.0F, 4.0F);
        this.body1.addBox(-2.5F, -2.5F, -3.6F, 5, 5, 5);
        this.body2 = new MowzieModelRenderer(this, 20, 0);
        this.body2.setRotationPoint(0.0F, -0.5F, -3.5F);
        this.body2.addBox(-2.0F, -2.0F, -5.0F, 4, 4, 6);
        this.setRotateAngle(body2, -0.17453292519943295F, 0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 20, 25);
        this.neck.setRotationPoint(0.0F, -0.75F, -4.5F);
        this.neck.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
        this.setRotateAngle(neck, 0.04363323129985824F, 0.0F, 0.0F);
        this.head1 = new MowzieModelRenderer(this, 30, 24);
        this.head1.setRotationPoint(0.0F, 0.0F, -1.5F);
        this.head1.addBox(-1.5F, -2.5F, -4.0F, 3, 3, 4);
        this.setRotateAngle(head1, 0.17453292519943295F, 0.0F, 0.0F);
        this.head2 = new MowzieModelRenderer(this, 44, 25);
        this.head2.setRotationPoint(0.0F, 0.1F, 0.0F);
        this.head2.addBox(-1.0F, -2.0F, -6.75F, 2, 2, 3);
        this.setRotateAngle(head2, 0.08726646259971647F, 0.0F, 0.0F);
        this.snout1 = new MowzieModelRenderer(this, 55, 28);
        this.snout1.setRotationPoint(0.0F, -1.25F, -6.5F);
        this.snout1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2);
        this.setRotateAngle(snout1, 0.5235987755982988F, -0.0F, 0.0F);
        this.snout2 = new MowzieModelRenderer(this, 55, 25);
        this.snout2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.snout2.addBox(-0.5F, -0.5F, -0.75F, 1, 1, 1);
        this.setRotateAngle(snout2, 0.5235987755982988F, -0.0F, 0.0F);
        this.mouth1 = new MowzieModelRenderer(this, 38, 10);
        this.mouth1.setRotationPoint(0.0F, 0.4F, -0.5F);
        this.mouth1.addBox(-1.5F, 0.0F, -2.98F, 3, 1, 3);
        this.mouth2 = new MowzieModelRenderer(this, 40, 16);
        this.mouth2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth2.addBox(-1.0F, 0.05F, -4.5F, 2, 1, 2);
        this.mouth3 = new MowzieModelRenderer(this, 45, 21);
        this.mouth3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth3.addBox(-0.5F, 0.1F, -6.0F, 1, 1, 2);
        this.earLeft = new MowzieModelRenderer(this, 25, 20);
        this.earLeft.setRotationPoint(1.0F, -2.0F, -0.5F);
        this.earLeft.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1);
        this.setRotateAngle(earLeft, -0.2617993877991494F, -0.0F, 0.15707963267948966F);
        this.earRight = new MowzieModelRenderer(this, 31, 20);
        this.earRight.setRotationPoint(-1.0F, -2.0F, -0.5F);
        this.earRight.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1);
        this.setRotateAngle(earRight, -0.2617993877991494F, -0.0F, -0.15707963267948966F);
        this.leftLeg1 = new MowzieModelRenderer(this, 0, 10);
        this.leftLeg1.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.leftLeg1.addBox(-0.5F, -1.0F, -2.0F, 2, 4, 4);
        this.setRotateAngle(leftLeg1, 0.17453292519943295F, 0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 0, 24);
        this.leftFoot.setRotationPoint(0.0F, 3.5F, -0.5F);
        this.leftFoot.addBox(-0.5F, -0.6F, -1.5F, 1, 1, 2);
        this.setRotateAngle(leftFoot, 0.5235987755982988F, 0.0F, 0.0F);
        this.leftLeg3 = new MowzieModelRenderer(this, 0, 18);
        this.leftLeg3.setRotationPoint(0.5F, 3.0F, -0.5F);
        this.leftLeg3.addBox(-0.5F, -0.5F, -1.0F, 1, 4, 1);
        this.setRotateAngle(leftLeg3, -1.0471975511965976F, 0.0F, 0.0F);
        this.leftLeg2 = new MowzieModelRenderer(this, 4, 18);
        this.leftLeg2.setRotationPoint(2.0F, 2.0F, 0.0F);
        this.leftLeg2.addBox(0.0F, 0.0F, -1.0F, 1, 3, 2);
        this.setRotateAngle(leftLeg2, 0.5235987755982988F, 0.0F, 0.0F);
        this.rightHand = new MowzieModelRenderer(this, 25, 10);
        this.rightHand.setRotationPoint(1.75F, 1.5F, -3.0F);
        this.rightHand.addBox(-0.5F, 0.2F, -0.5F, 1, 2, 1);
        this.setRotateAngle(rightHand, 0.2617993877991494F, 0.0F, 0.0F);
        this.rightHand2 = new MowzieModelRenderer(this, 25, 14);
        this.rightHand2.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.rightHand2.addBox(-0.5F, 0.1F, -0.3F, 1, 2, 1);
        this.setRotateAngle(rightHand2, -0.5235987755982988F, 0.0F, 0.0F);
        this.rightLeg1 = new MowzieModelRenderer(this, 12, 10);
        this.rightLeg1.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.rightLeg1.addBox(-1.0F, -1.0F, -2.0F, 2, 4, 4);
        this.setRotateAngle(rightLeg1, 0.17453292519943295F, -0.0F, 0.0F);
        this.rightLeg2 = new MowzieModelRenderer(this, 16, 18);
        this.rightLeg2.setRotationPoint(-2.0F, 2.0F, 0.0F);
        this.rightLeg2.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 2);
        this.setRotateAngle(rightLeg2, 0.5235987755982988F, -0.0F, 0.0F);
        this.rightLeg3 = new MowzieModelRenderer(this, 12, 18);
        this.rightLeg3.setRotationPoint(0.0F, 3.0F, -0.5F);
        this.rightLeg3.addBox(-0.5F, -0.5F, -1.0F, 1, 4, 1);
        this.setRotateAngle(rightLeg3, -1.0471975511965976F, -0.0F, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 12, 24);
        this.rightFoot.setRotationPoint(0.0F, 3.5F, -0.5F);
        this.rightFoot.addBox(-0.5F, -0.6F, -1.5F, 1, 1, 2);
        this.setRotateAngle(rightFoot, 0.5235987755982988F, -0.0F, 0.0F);
        this.leftHand = new MowzieModelRenderer(this, 30, 10);
        this.leftHand.setRotationPoint(-1.75F, 1.5F, -3.0F);
        this.leftHand.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1);
        this.setRotateAngle(leftHand, 0.2617993877991494F, 0.0F, 0.0F);
        this.leftHand2 = new MowzieModelRenderer(this, 30, 14);
        this.leftHand2.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.leftHand2.addBox(-0.5F, 0.1F, -0.3F, 1, 2, 1);
        this.setRotateAngle(leftHand2, -0.5235987755982988F, 0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 40, 0);
        this.tail1.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.tail1.addBox(-1.5F, -2.0F, 0.0F, 3, 3, 4);
        this.tail2 = new MowzieModelRenderer(this, 54, 0);
        this.tail2.setRotationPoint(0.0F, -0.5F, 4.0F);
        this.tail2.addBox(-1.0F, -1.0F, -0.25F, 2, 2, 3);
        this.tail3 = new MowzieModelRenderer(this, 54, 5);
        this.tail3.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.tail3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
        this.tail4 = new MowzieModelRenderer(this, 54, 9);
        this.tail4.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.tail4.addBox(-0.5F, -0.5F, -0.25F, 1, 1, 4);
        this.tail5 = new MowzieModelRenderer(this, 52, 14);
        this.tail5.setRotationPoint(0.0F, 0.0F, 3.5F);
        this.tail5.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 5);

        // Head
        this.body1.addChild(this.body2);
        this.body2.addChild(this.neck);
        this.neck.addChild(this.head1);
        this.head1.addChild(this.earLeft);
        this.head1.addChild(this.earRight);
        this.head1.addChild(this.mouth1);
        this.mouth1.addChild(this.mouth2);
        this.mouth1.addChild(this.mouth3);
        this.head1.addChild(this.head2);
        this.head2.addChild(this.snout1);
        this.snout1.addChild(this.snout2);

        // Arms
        this.body2.addChild(this.rightHand);
        this.rightHand.addChild(this.rightHand2);
        this.body2.addChild(this.leftHand);
        this.leftHand.addChild(this.leftHand2);

        // Left leg
        this.body1.addChild(this.rightLeg1);
        this.rightLeg1.addChild(this.rightLeg2);
        this.rightLeg2.addChild(this.rightLeg3);
        this.rightLeg3.addChild(this.rightFoot);

        // Right leg
        this.body1.addChild(this.leftLeg1);
        this.leftLeg1.addChild(this.leftLeg2);
        this.leftLeg2.addChild(this.leftLeg3);
        this.leftLeg3.addChild(this.leftFoot);

        // Tail
        this.body1.addChild(this.tail1);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.tail3);
        this.tail3.addChild(this.tail4);
        this.tail4.addChild(this.tail5);

        this.tailParts = new MowzieModelRenderer[] { this.tail5, this.tail4, this.tail3, this.tail2, this.tail1 };
        this.noseParts = new MowzieModelRenderer[] { this.snout2, this.snout1 };

        // Corrections
        rightLeg2.rotationPointX = 0;
        leftLeg2.rotationPointX = 0;

        this.body1.updateDefaultPose();
        this.body2.updateDefaultPose();
        this.neck.updateDefaultPose();
        this.head1.updateDefaultPose();
        this.earLeft.updateDefaultPose();
        this.earRight.updateDefaultPose();
        this.head2.updateDefaultPose();
        this.snout1.updateDefaultPose();
        this.snout2.updateDefaultPose();
        this.mouth1.updateDefaultPose();
        this.mouth2.updateDefaultPose();
        this.mouth3.updateDefaultPose();
        this.leftLeg1.updateDefaultPose();
        this.leftLeg2.updateDefaultPose();
        this.leftLeg3.updateDefaultPose();
        this.leftFoot.updateDefaultPose();
        this.rightLeg1.updateDefaultPose();
        this.rightLeg2.updateDefaultPose();
        this.rightLeg3.updateDefaultPose();
        this.rightFoot.updateDefaultPose();
        this.rightHand.updateDefaultPose();
        this.rightHand2.updateDefaultPose();
        this.leftHand.updateDefaultPose();
        this.leftHand2.updateDefaultPose();
        this.tail1.updateDefaultPose();
        this.tail2.updateDefaultPose();
        this.tail3.updateDefaultPose();
        this.tail4.updateDefaultPose();
        this.tail5.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityLeptictidium) entity);
        this.body1.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityLeptictidium entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.resetPose();

        float globalSpeed = 0.6F;
        float height = 12F * f1;

        this.faceTarget(f3, f4, 1.0F, this.head1, this.neck);

        this.bob(this.body1, 0.5F * globalSpeed, height, true, f, f1);

        this.walk(this.leftLeg1, 1F * globalSpeed, 0.75F, true, 1F, 0.2F, f, f1);
        this.walk(this.rightLeg1, 1F * globalSpeed, 0.75F, true, 0.5F, 0.2F, f, f1);
        this.walk(this.leftLeg2, 1F * globalSpeed, 0.5F, true, 1.5F, 0.1F, f, f1);
        this.walk(this.rightLeg2, 1F * globalSpeed, 0.5F, true, 1F, 0.1F, f, f1);
        this.walk(this.leftLeg3, 1F * globalSpeed, 0.5F, true, 0.5F, 0F, f, f1);
        this.walk(this.rightLeg3, 1F * globalSpeed, 0.5F, true, 1F, 0F, f, f1);
        this.walk(this.leftFoot, 1F * globalSpeed, 0.5F, true, 1F, 0.75F, f, f1);
        this.walk(this.rightFoot, 1F * globalSpeed, 0.5F, true, 0.5F, 0.75F, f, f1);

        this.walk(this.body1, 1F * globalSpeed, 0.3F, false, 0.5F, 0F, f, f1);
        this.walk(this.body2, 1F * globalSpeed, 0.5F, true, 1.0F, 0.5F, f, f1);
        this.walk(this.neck, 1F * globalSpeed, 0.3F, true, 0.25F, 0.3F, f, f1);
        this.walk(this.head1, 1F * globalSpeed, 0.3F, false, 0.25F, -0.8F, f, f1);

        this.walk(this.rightHand, 1 * globalSpeed, 0.3F, true, 1, 0.2F, f, f1);
        this.walk(this.leftHand, 1 * globalSpeed, 0.3F, true, 1, 0.2F, f, f1);
        this.walk(this.rightHand2, 1 * globalSpeed, 0.3F, false, 1, -0.2F, f, f1);
        this.walk(this.leftHand2, 1 * globalSpeed, 0.3F, false, 1, -0.2F, f, f1);

        this.chainWave(this.tailParts, 1F * globalSpeed, 0.2F, 2.7F, f, f1);
        this.chainWave(this.noseParts, 1F * globalSpeed, -0.5F, 0F, f, f1);
        this.flap(this.earLeft, 1F * globalSpeed, 0.5F, true, 1.0F, 0.8F, f, f1);
        this.flap(this.earRight, 1F * globalSpeed, 0.5F, false, 1.0F, -0.8F, f, f1);

        // Idle
        this.chainWave(this.tailParts, 0.2F, -0.05F, 2, entity.frame, 1F);
        this.chainSwing(this.tailParts, 0.3F, 0.05F, 3, entity.frame, 1F);
        this.walk(this.neck, 0.2F, 0.1F, false, -1F, 0F, entity.frame, 1F);
        this.walk(this.head1, 0.2F, 0.1F, true, 0F, 0F, entity.frame, 1F);
        this.flap(this.earLeft, 0.2F, 0.1F, true, -1.0F, 0F, entity.frame, 1F);
        this.flap(this.earRight, 0.2F, 0.1F, false, -1.0F, 0F, entity.frame, 1F);
        this.chainWave(this.noseParts, 0.2F, -0.1F, 0F, entity.frame, 1F);
        this.walk(this.body2, 0.2F, 0.1F, true, 0F, 0F, entity.frame, 1F);
        this.walk(this.body1, 0.2F, 0.1F, false, 0F, 0F, entity.frame, 1F);
        this.walk(this.leftLeg1, 0.2F, 0.1F, true, 0F, 0F, entity.frame, 1F);
        this.walk(this.rightLeg1, 0.2F, 0.1F, true, 0F, 0F, entity.frame, 1F);
        this.walk(this.rightHand, 0.2F, 0.1F, true, 0F, 0F, entity.frame, 1F);
        this.walk(this.leftHand, 0.2F, 0.1F, true, 0F, 0F, entity.frame, 1F);
        this.walk(this.rightHand2, 0.2F, 0.1F, false, 0F, 0F, entity.frame, 1F);
        this.walk(this.leftHand2, 0.2F, 0.1F, false, 0F, 0F, entity.frame, 1F);

        entity.tailBuffer.applyChainSwingBuffer(this.tailParts);
    }

    public void resetPose() {
        this.body1.resetToDefaultPose();
        this.body2.resetToDefaultPose();
        this.neck.resetToDefaultPose();
        this.head1.resetToDefaultPose();
        this.earLeft.resetToDefaultPose();
        this.earRight.resetToDefaultPose();
        this.head2.resetToDefaultPose();
        this.snout1.resetToDefaultPose();
        this.snout2.resetToDefaultPose();
        this.mouth1.resetToDefaultPose();
        this.mouth2.resetToDefaultPose();
        this.mouth3.resetToDefaultPose();
        this.leftLeg1.resetToDefaultPose();
        this.leftLeg2.resetToDefaultPose();
        this.leftLeg3.resetToDefaultPose();
        this.leftFoot.resetToDefaultPose();
        this.rightLeg1.resetToDefaultPose();
        this.rightLeg2.resetToDefaultPose();
        this.rightLeg3.resetToDefaultPose();
        this.rightFoot.resetToDefaultPose();
        this.rightHand.resetToDefaultPose();
        this.rightHand2.resetToDefaultPose();
        this.leftHand.resetToDefaultPose();
        this.leftHand2.resetToDefaultPose();
        this.tail1.resetToDefaultPose();
        this.tail2.resetToDefaultPose();
        this.tail3.resetToDefaultPose();
        this.tail4.resetToDefaultPose();
        this.tail5.resetToDefaultPose();
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
