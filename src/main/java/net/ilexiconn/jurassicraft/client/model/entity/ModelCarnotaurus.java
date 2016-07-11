package net.ilexiconn.jurassicraft.client.model.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityCarnotaurus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelCarnotaurus extends MowzieModelBase {
    public Animator animator;
    public MowzieModelRenderer bodyMain;
    public MowzieModelRenderer upperArmRight;
    public MowzieModelRenderer upperArmLeft;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer body2;
    public MowzieModelRenderer leftThigh;
    public MowzieModelRenderer rightThigh;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer tail4;
    public MowzieModelRenderer tail5;
    public MowzieModelRenderer tail6;
    public MowzieModelRenderer body1;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer head;
    public MowzieModelRenderer hornLeft;
    public MowzieModelRenderer hornRight;
    public MowzieModelRenderer upperJaw;
    public MowzieModelRenderer teeth;
    public MowzieModelRenderer lowerJaw;
    public MowzieModelRenderer leftCalf1;
    public MowzieModelRenderer leftUpperFoot;
    public MowzieModelRenderer footLeft;
    public MowzieModelRenderer rightCalf1;
    public MowzieModelRenderer rightUpperFoot;
    public MowzieModelRenderer footRight;
    public MowzieModelRenderer rightHand;
    public MowzieModelRenderer leftHand;
    public MowzieModelRenderer[] tailParts;
    public MowzieModelRenderer[] bodyParts;

    public ModelCarnotaurus() {
        this.animator = new Animator(this);
        this.textureWidth = 256;
        this.textureHeight = 256;

        this.hornLeft = new MowzieModelRenderer(this, 1, 110);
        this.hornLeft.setRotationPoint(1.0F, -1.0F, -1.0F);
        this.hornLeft.addBox(-1.25F, -3.25F, -0.5F, 2, 3, 1);
        this.setRotateAngle(hornLeft, 2.530727415391778F, -1.48352986419518F, -1.5707963267948966F);
        this.footRight = new MowzieModelRenderer(this, 20, 0);
        this.footRight.setRotationPoint(0.0F, 4.4F, -0.5F);
        this.footRight.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 6);
        this.setRotateAngle(footRight, 0.6457718232379019F, 0.0F, 0.0F);
        this.upperArmLeft = new MowzieModelRenderer(this, 0, 56);
        this.upperArmLeft.setRotationPoint(4.5F, 4.0F, -6.0F);
        this.upperArmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5);
        this.setRotateAngle(upperArmLeft, -0.9599310885968813F, 0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 119, 61);
        this.tail2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.tail2.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 8);
        this.setRotateAngle(tail2, 0.05235987755982988F, 0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 152, 82);
        this.tail3.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.tail3.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 8);
        this.setRotateAngle(tail3, 0.05235987755982988F, 0.0F, 0.0F);
        this.tail5 = new MowzieModelRenderer(this, 118, 100);
        this.tail5.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.tail5.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 11);
        this.setRotateAngle(tail5, 0.017453292519943295F, 0.0F, 0.0F);
        this.body2 = new MowzieModelRenderer(this, 118, 139);
        this.body2.setRotationPoint(0.0F, 0.0F, -11.0F);
        this.body2.addBox(-4.5F, -4.0F, -9.0F, 9, 10, 11);
        this.setRotateAngle(body2, -0.017453292519943295F, 0.0F, 0.0F);
        this.bodyMain = new MowzieModelRenderer(this, 118, 0);
        this.bodyMain.setRotationPoint(0.0F, 4.5F, 7.0F);
        this.bodyMain.addBox(-5.0F, -4.2F, -11.0F, 10, 11, 11);
        this.setRotateAngle(bodyMain, -0.06981317007977318F, 0.0F, 0.0F);
        this.teeth = new MowzieModelRenderer(this, 30, 36);
        this.teeth.setRotationPoint(0.0F, 0.2F, -1.2F);
        this.teeth.addBox(-2.5F, -3.5F, 0.0F, 5, 1, 6);
        this.setRotateAngle(teeth, -3.1066860685499065F, 0.0F, 0.0F);
        this.rightThigh = new MowzieModelRenderer(this, 57, 57);
        this.rightThigh.setRotationPoint(-5.0F, 2.0F, -3.25F);
        this.rightThigh.addBox(-2.5F, -3.0F, -8.0F, 5, 6, 10);
        this.setRotateAngle(rightThigh, 1.1519173063162573F, 0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 71, 27);
        this.lowerJaw.setRotationPoint(0.0F, 2.75F, -1.2F);
        this.lowerJaw.addBox(-2.0F, -1.5F, 0.0F, 4, 2, 5);
        this.setRotateAngle(lowerJaw, 3.1066860685499065F, 0.0F, 0.0F);
        this.leftCalf1 = new MowzieModelRenderer(this, 65, 0);
        this.leftCalf1.setRotationPoint(0.0F, -1.4F, -6.1F);
        this.leftCalf1.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3);
        this.setRotateAngle(leftCalf1, -0.5585053606381855F, 0.0F, 0.0F);
        this.body1 = new MowzieModelRenderer(this, 182, 0);
        this.body1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.body1.addBox(-4.0F, -3.5F, -3.5F, 8, 8, 8);
        this.setRotateAngle(body1, -0.12217304763960307F, 0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 217, 0);
        this.neck.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.neck.addBox(-2.5F, -2.75F, -9.0F, 5, 6, 11);
        this.setRotateAngle(neck, -0.3490658503988659F, 0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 93);
        this.head.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.head.addBox(-3.0F, -2.5F, -3.0F, 6, 7, 5);
        this.setRotateAngle(head, 0.6457718232379019F, 0.0F, 0.0F);
        this.rightUpperFoot = new MowzieModelRenderer(this, 89, 3);
        this.rightUpperFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.rightUpperFoot.addBox(-1.5F, -1.0F, -1.25F, 3, 6, 3);
        this.setRotateAngle(rightUpperFoot, -1.1693705988362009F, 0.0F, 0.0F);
        this.rightCalf1 = new MowzieModelRenderer(this, 53, 0);
        this.rightCalf1.setRotationPoint(0.0F, -1.4F, -6.1F);
        this.rightCalf1.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3);
        this.setRotateAngle(rightCalf1, -0.5585053606381855F, 0.0F, 0.0F);
        this.rightHand = new MowzieModelRenderer(this, 0, 68);
        this.rightHand.setRotationPoint(-0.5F, 1.0F, 5.0F);
        this.rightHand.addBox(-1.0F, -0.75F, -1.25F, 1, 2, 2);
        this.setRotateAngle(rightHand, 2.0943951023931953F, 0.0F, 0.0F);
        this.leftHand = new MowzieModelRenderer(this, 0, 68);
        this.leftHand.setRotationPoint(0.5F, 1.0F, 5.0F);
        this.leftHand.addBox(0.0F, -0.75F, -1.25F, 1, 2, 2);
        this.setRotateAngle(leftHand, 2.0943951023931953F, 0.0F, 0.0F);
        this.leftThigh = new MowzieModelRenderer(this, 27, 57);
        this.leftThigh.setRotationPoint(5.0F, 2.0F, -3.25F);
        this.leftThigh.addBox(-2.5F, -3.0F, -8.0F, 5, 6, 10);
        this.setRotateAngle(leftThigh, 1.1519173063162573F, 0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 121, 41);
        this.tail1.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.tail1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 8);
        this.setRotateAngle(tail1, -0.05235987755982988F, 0.0F, 0.0F);
        this.footLeft = new MowzieModelRenderer(this, 0, 0);
        this.footLeft.setRotationPoint(0.0F, 4.4F, -0.5F);
        this.footLeft.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 6);
        this.setRotateAngle(footLeft, 0.6457718232379019F, 0.0F, 0.0F);
        this.tail4 = new MowzieModelRenderer(this, 119, 79);
        this.tail4.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.tail4.addBox(-2.0F, -2.5F, 0.0F, 4, 5, 9);
        this.setRotateAngle(tail4, -0.05235987755982988F, 0.0F, 0.0F);
        this.hornRight = new MowzieModelRenderer(this, 1, 110);
        this.hornRight.setRotationPoint(-1.0F, -1.0F, -1.0F);
        this.hornRight.addBox(-1.25F, -3.25F, -0.5F, 2, 3, 1);
        this.setRotateAngle(hornRight, 0.6108652381980153F, -1.48352986419518F, -1.5707963267948966F);
        this.upperJaw = new MowzieModelRenderer(this, 30, 21);
        this.upperJaw.setRotationPoint(0.0F, 0.2F, -1.2F);
        this.upperJaw.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 6);
        this.setRotateAngle(upperJaw, -3.1066860685499065F, 0.0F, 0.0F);
        this.leftUpperFoot = new MowzieModelRenderer(this, 77, 3);
        this.leftUpperFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.leftUpperFoot.addBox(-1.5F, -1.0F, -1.25F, 3, 6, 3);
        this.setRotateAngle(leftUpperFoot, -1.1693705988362009F, 0.0F, 0.0F);
        this.upperArmRight = new MowzieModelRenderer(this, 0, 56);
        this.upperArmRight.setRotationPoint(-4.5F, 4.0F, -6.0F);
        this.upperArmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5);
        this.setRotateAngle(upperArmRight, -0.9599310885968813F, 0.0F, 0.0F);
        this.tail6 = new MowzieModelRenderer(this, 119, 118);
        this.tail6.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.tail6.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 11);
        this.setRotateAngle(tail6, 0.05235987755982988F, 0.0F, 0.0F);

        this.bodyMain.addChild(this.body2);
        this.body2.addChild(this.body1);
        this.body1.addChild(this.neck);
        this.neck.addChild(this.head);
        this.head.addChild(this.hornRight);
        this.head.addChild(this.hornLeft);
        this.head.addChild(this.upperJaw);
        this.head.addChild(this.lowerJaw);
        this.head.addChild(this.teeth);

        this.body2.addChild(this.upperArmLeft);
        this.upperArmLeft.addChild(this.leftHand);

        this.body2.addChild(this.upperArmRight);
        this.upperArmRight.addChild(this.rightHand);

        this.leftThigh.addChild(this.leftCalf1);
        this.leftCalf1.addChild(this.leftUpperFoot);
        this.leftUpperFoot.addChild(this.footLeft);

        this.rightThigh.addChild(this.rightCalf1);
        this.rightCalf1.addChild(this.rightUpperFoot);
        this.rightUpperFoot.addChild(this.footRight);

        this.bodyMain.addChild(this.tail1);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.tail3);
        this.tail3.addChild(this.tail4);
        this.tail4.addChild(this.tail5);
        this.tail5.addChild(this.tail6);

        // Corrections
        leftThigh.rotationPointY += 4;
        leftThigh.rotationPointZ += 6;
        rightThigh.rotationPointY += 4;
        rightThigh.rotationPointZ += 6;
        footLeft.rotationPointZ -= 1;
        footRight.rotationPointZ -= 1;
        footLeft.rotationPointY += 0.88;
        footRight.rotationPointY += 0.88;
        footLeft.rotateAngleZ -= 0.05;
        footRight.rotateAngleZ -= 0.05;

        this.tailParts = new MowzieModelRenderer[] { this.tail5, this.tail4, this.tail3, this.tail2, this.tail1 };
        this.bodyParts = new MowzieModelRenderer[] { this.head, this.neck, this.body2, this.body1, this.bodyMain };

        this.bodyMain.updateDefaultPose();
        this.upperArmRight.updateDefaultPose();
        this.upperArmLeft.updateDefaultPose();
        this.tail1.updateDefaultPose();
        this.body2.updateDefaultPose();
        this.leftThigh.updateDefaultPose();
        this.rightThigh.updateDefaultPose();
        this.tail2.updateDefaultPose();
        this.tail3.updateDefaultPose();
        this.tail4.updateDefaultPose();
        this.tail5.updateDefaultPose();
        this.tail6.updateDefaultPose();
        this.body1.updateDefaultPose();
        this.neck.updateDefaultPose();
        this.head.updateDefaultPose();
        this.hornLeft.updateDefaultPose();
        this.hornRight.updateDefaultPose();
        this.upperJaw.updateDefaultPose();
        this.teeth.updateDefaultPose();
        this.lowerJaw.updateDefaultPose();
        this.leftCalf1.updateDefaultPose();
        this.leftUpperFoot.updateDefaultPose();
        this.footLeft.updateDefaultPose();
        this.rightCalf1.updateDefaultPose();
        this.rightUpperFoot.updateDefaultPose();
        this.footRight.updateDefaultPose();
        this.rightHand.updateDefaultPose();
        this.leftHand.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((EntityCarnotaurus) entity, f, f1, f2, f3, f4, f5);
        this.bodyMain.render(f5);
        this.leftThigh.render(f5);
        this.rightThigh.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityCarnotaurus carnotaurus) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, carnotaurus);
        this.resetPose();

        /*
         * f = carnotaurus.frame; f1 = 0.8F;
         */

        if (!carnotaurus.isSitting()) {
            // Walking-dependent animation
            float globalSpeed = 0.55F;
            float globalDegree = 0.5F;
            float height = 1F;
            float walkSpeed = 0.275F;
            float armRotation = this.rotateBox(globalSpeed, 0.25F, true, 2F, 0F, f, f1);
            float bodyWeight = this.moveBox(globalSpeed, height, false, f, f1);
            float legRotation = f1 * MathHelper.cos(f * 0.5F * globalSpeed);

            // Idle
            this.faceTarget(f3, f4, 3.0F, this.body1, this.body2);
            this.faceTarget(f3, f4, 1.25F, this.neck, this.head);

            this.chainWave(bodyParts, globalSpeed, 0.08F, 3, f, f1);
            this.bodyMain.rotationPointY += bodyWeight;
            this.leftThigh.rotationPointY += bodyWeight;
            this.rightThigh.rotationPointY += bodyWeight;
            this.leftThigh.rotationPointY += legRotation;
            this.rightThigh.rotationPointY -= legRotation;
            this.bodyMain.rotateAngleZ += 0.05 * f1;
            this.walk(neck, globalSpeed, 0.25F, true, 3.1F, 0.4F, f, f1);
            this.walk(head, globalSpeed, 0.25F, false, 3.1F, -0.4F, f, f1);

            this.walk(this.leftThigh, walkSpeed, 1.25F * globalDegree, false, 0.0F, 0.5F, f, f1);
            this.walk(this.leftCalf1, walkSpeed, globalDegree, true, 1F, 0.4F, f, f1);
            this.walk(this.leftUpperFoot, walkSpeed, globalDegree, false, 0.0F, 0.0F, f, f1);
            this.walk(this.footLeft, walkSpeed, 1.5F * globalDegree, true, 0.5F, -0.15F, f, f1);

            this.walk(this.rightThigh, walkSpeed, 1.25F * globalDegree, true, 0.0F, 0.5F, f, f1);
            this.walk(this.rightCalf1, walkSpeed, globalDegree, false, 1.0F, 0.4F, f, f1);
            this.walk(this.rightUpperFoot, walkSpeed, globalDegree, true, 0.0F, 0.0F, f, f1);
            this.walk(this.footRight, walkSpeed, 1.5F * globalDegree, false, 0.5F, -0.15F, f, f1);

            this.upperArmRight.rotateAngleX += armRotation;
            this.upperArmLeft.rotateAngleX += armRotation;

            this.chainSwing(tailParts, 0.5F * globalSpeed, -0.07F, 2, f, f1);
            this.chainWave(tailParts, globalSpeed, 0.05F, 2, f, f1);
        }

        float sittingProgress = carnotaurus.sittingProgress.getAnimationProgressSin();

        if (sittingProgress > 0) {
            // Sitting Pose
            float restHeadProgress = carnotaurus.restingHeadProgress.getAnimationProgressSinSqrt();
            float sittingProgressTemporary = carnotaurus.sittingProgress.getAnimationProgressTemporaryFS();

            if (restHeadProgress > 0) {
                this.body1.rotateAngleY += (f3 / (180f / (float) Math.PI)) / 6.0F;
                this.neck.rotateAngleY += (f3 / (180f / (float) Math.PI)) / 5.0F;
                this.head.rotateAngleY += (f3 / (180f / (float) Math.PI)) / 4.0F;
            } else {
                this.faceTarget(f3, f5, 4.0F, this.body1, this.body2);
                this.faceTarget(f3, f5, 3.0F, this.neck, this.head);
            }

            if (sittingProgressTemporary > 0.001F) {
                this.body1.rotateAngleX += 0.1F * sittingProgressTemporary;
                this.body2.rotateAngleX += 0.25F * sittingProgressTemporary;
                this.neck.rotateAngleX += 0.25F * sittingProgressTemporary;

                if (carnotaurus.isSitting()) {
                    this.tail1.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.tail2.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.tail3.rotateAngleX += 0.075F * sittingProgressTemporary;
                    this.tail4.rotateAngleX += 0.075F * sittingProgressTemporary;
                    this.tail5.rotateAngleX += 0.05F * sittingProgressTemporary;
                    this.tail6.rotateAngleX += 0.05F * sittingProgressTemporary;
                }
            }

            this.head.rotateAngleY += ((f3 / (180f / (float) Math.PI)) / 2) * sittingProgress - (((f3 / (180f / (float) Math.PI)) / 2) * restHeadProgress);
            this.neck.rotateAngleY += ((f3 / (180f / (float) Math.PI)) / 2) * sittingProgress - (((f3 / (180f / (float) Math.PI)) / 2) * restHeadProgress);

            this.bodyMain.rotationPointY += 10.0F * sittingProgress;
            this.rightThigh.rotationPointY += 10.0F * sittingProgress;
            this.leftThigh.rotationPointY += 10.0F * sittingProgress;

            this.upperArmRight.rotateAngleX += 0.25F * sittingProgress;
            this.upperArmLeft.rotateAngleX += 0.25F * sittingProgress;
            this.leftHand.rotateAngleX -= 1.2F * sittingProgress;
            this.rightHand.rotateAngleX -= 1.2F * sittingProgress;

            this.rightThigh.rotateAngleX -= 1.2F * sittingProgress;
            this.leftThigh.rotateAngleX -= 1.2F * sittingProgress;

            this.rightCalf1.rotationPointZ -= 0.5F * sittingProgress;
            this.leftCalf1.rotationPointZ -= 0.5F * sittingProgress;
            this.rightCalf1.rotationPointY += 1.0F * sittingProgress;
            this.leftCalf1.rotationPointY += 1.0F * sittingProgress;
            this.rightCalf1.rotateAngleX += 1.2F * sittingProgress;
            this.leftCalf1.rotateAngleX += 1.2F * sittingProgress;

            this.rightUpperFoot.rotationPointY -= 0.25F * sittingProgress;
            this.leftUpperFoot.rotationPointY -= 0.25F * sittingProgress;
            this.rightUpperFoot.rotateAngleX -= 1.0F * sittingProgress;
            this.leftUpperFoot.rotateAngleX -= 1.0F * sittingProgress;

            this.footRight.rotationPointY += 1.25F * sittingProgress;
            this.footLeft.rotationPointY += 1.25F * sittingProgress;
            this.footRight.rotationPointZ += 1.0F * sittingProgress;
            this.footLeft.rotationPointZ += 1.0F * sittingProgress;
            this.footRight.rotateAngleX += 1.0F * sittingProgress;
            this.footLeft.rotateAngleX += 1.0F * sittingProgress;

            this.tail1.rotationPointZ -= 0.75F * sittingProgress;
            this.tail1.rotateAngleX -= 0.3F * sittingProgress;
            this.tail2.rotateAngleX += 0.1F * sittingProgress;
            this.tail3.rotateAngleX += 0.15F * sittingProgress;
            this.tail4.rotateAngleX += 0.15F * sittingProgress;
            this.tail4.rotationPointY += 0.5F * sittingProgress;
            this.walk(this.tail1, 0.1F, 0.03F * sittingProgress - (0.03F * restHeadProgress), true, 1, 0, carnotaurus.frame, 0.4F);

            this.upperArmRight.rotationPointZ -= 2.0F * restHeadProgress;
            this.upperArmLeft.rotationPointZ -= 2.0F * restHeadProgress;
            this.bodyMain.rotationPointY += 2.75F * restHeadProgress;
            this.body2.rotationPointY += 0.25F * restHeadProgress;
            this.body1.rotationPointY += 1.25F * restHeadProgress;
            this.neck.rotationPointY += 0.6F * restHeadProgress;
            this.head.rotationPointY -= 0.6F * restHeadProgress;

            this.body2.rotateAngleX += 0.175F * restHeadProgress;
            this.neck.rotateAngleX += 0.55F * restHeadProgress;
            this.head.rotateAngleX -= 0.825F * restHeadProgress;
            this.upperArmRight.rotateAngleX += 0.5F * restHeadProgress;
            this.upperArmLeft.rotateAngleX += 0.5F * restHeadProgress;
            this.rightHand.rotateAngleX -= 0.3F * restHeadProgress;
            this.leftHand.rotateAngleX -= 0.3F * restHeadProgress;
            this.tail1.rotationPointY += (0.2F * restHeadProgress) * MathHelper.cos((carnotaurus.frame + 1.0F) * 0.08F);
            this.walk(this.bodyMain, 0.08F, 0.02F * restHeadProgress, false, 0.0F, 0.0F, carnotaurus.frame, 1.0F);
            this.walk(this.body2, 0.08F, 0.02F * restHeadProgress, true, 0.0F, 0.0F, carnotaurus.frame, 1.0F);
            this.chainWave(this.bodyParts, 0.07F, -0.03F, 3, carnotaurus.frame, 1.0F - restHeadProgress);
            this.chainSwing(this.tailParts, 0.07F, 0.05F, 1, carnotaurus.frame, 1.0F - 0.3F * sittingProgress - 0.5F * restHeadProgress);
            this.chainWave(this.tailParts, 0.07F, -0.03F, 2, carnotaurus.frame, 1.0F - 0.3F * sittingProgress - 0.5F * restHeadProgress);
        } else {
            this.chainWave(this.bodyParts, 0.07F, -0.03F, 3, carnotaurus.frame, 1.0F);
            this.chainSwing(this.tailParts, 0.07F, 0.05F, 1, carnotaurus.frame, 1.0F);
            this.chainWave(this.tailParts, 0.07F, -0.03F, 2, carnotaurus.frame, 1.0F);
        }

        this.walk(this.upperArmRight, 0.07F, 0.05F, false, 1F, 0.0F, carnotaurus.frame, 1.0F);
        this.walk(this.upperArmLeft, 0.07F, 0.05F, false, 1F, 0.0F, carnotaurus.frame, 1.0F);

        this.walk(this.lowerJaw, 0.03F, 0.1F, false, 0F, 0.0F, carnotaurus.frame, 1.0F);

        carnotaurus.tailBuffer.applyChainSwingBuffer(this.tailParts);
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void resetPose() {
        this.bodyMain.resetToDefaultPose();
        this.upperArmRight.resetToDefaultPose();
        this.upperArmLeft.resetToDefaultPose();
        this.tail1.resetToDefaultPose();
        this.body2.resetToDefaultPose();
        this.leftThigh.resetToDefaultPose();
        this.rightThigh.resetToDefaultPose();
        this.tail2.resetToDefaultPose();
        this.tail3.resetToDefaultPose();
        this.tail4.resetToDefaultPose();
        this.tail5.resetToDefaultPose();
        this.tail6.resetToDefaultPose();
        this.body1.resetToDefaultPose();
        this.neck.resetToDefaultPose();
        this.head.resetToDefaultPose();
        this.hornLeft.resetToDefaultPose();
        this.hornRight.resetToDefaultPose();
        this.upperJaw.resetToDefaultPose();
        this.teeth.resetToDefaultPose();
        this.lowerJaw.resetToDefaultPose();
        this.leftCalf1.resetToDefaultPose();
        this.leftUpperFoot.resetToDefaultPose();
        this.footLeft.resetToDefaultPose();
        this.rightCalf1.resetToDefaultPose();
        this.rightUpperFoot.resetToDefaultPose();
        this.footRight.resetToDefaultPose();
        this.rightHand.resetToDefaultPose();
        this.leftHand.resetToDefaultPose();
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityCarnotaurus) entity);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.BITE.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.BITE.animID());
            this.animator.startPhase(6);
            this.animator.rotate(neck, -0.3F, 0, 0);
            this.animator.rotate(head, 0.5F, 0, 0);
            this.animator.rotate(lowerJaw, 1F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.startPhase(3);
            this.animator.rotate(neck, 0.8F, 0, 0);
            this.animator.rotate(head, -0.5F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(2);
            this.animator.resetPhase(8);
        }
    }
}
