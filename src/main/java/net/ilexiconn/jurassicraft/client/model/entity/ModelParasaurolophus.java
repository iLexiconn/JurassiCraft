package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityParasaurolophus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelParasaurolophus extends MowzieModelBase {
    public boolean isAlarmed;
    private Animator animator;

    MowzieModelRenderer Left_Lower_Foot;
    MowzieModelRenderer Left_Upper_Foot;
    MowzieModelRenderer Right_Lower_Foot;
    MowzieModelRenderer Right_Upper_Foot;
    MowzieModelRenderer Left_Calf_1;
    MowzieModelRenderer Right_Calf_1;
    MowzieModelRenderer Left_Thigh;
    MowzieModelRenderer Right_Thigh;
    MowzieModelRenderer Body_1;
    MowzieModelRenderer Body_2;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Tail_1;
    MowzieModelRenderer Tail_2;
    MowzieModelRenderer Tail_3;
    MowzieModelRenderer Tail_4;
    MowzieModelRenderer Tail_5;
    MowzieModelRenderer Upper_Arm_Right;
    MowzieModelRenderer Upper_Arm_Left;
    MowzieModelRenderer Lower_Arm_Left;
    MowzieModelRenderer Lower_Arm_Right;
    MowzieModelRenderer Left_Hand;
    MowzieModelRenderer Right_Hand;
    MowzieModelRenderer Tail_6;
    MowzieModelRenderer Head;
    MowzieModelRenderer Snout_1;
    MowzieModelRenderer Snout_2;
    MowzieModelRenderer Jaw;
    MowzieModelRenderer Crest_1;
    MowzieModelRenderer Crest_2;
    MowzieModelRenderer Crest_3;
    MowzieModelRenderer Body_3;
    MowzieModelRenderer Foot_Left;
    MowzieModelRenderer Foot_Right;
    MowzieModelRenderer[] tailParts;
    MowzieModelRenderer[] bodyParts;

    public ModelParasaurolophus() {
        textureWidth = 256;
        textureHeight = 256;

        animator = new Animator(this);

        Left_Lower_Foot = new MowzieModelRenderer(this, 98, 0);
        Left_Lower_Foot.addBox(-2F, 0F, 0F, 4, 2, 2);
        Left_Lower_Foot.setRotationPoint(7F, 20.8F, 7.7F);
        Left_Lower_Foot.setTextureSize(256, 256);
        Left_Lower_Foot.mirror = true;
        setRotation(Left_Lower_Foot, -0.9075712F, 0F, 0F);
        Left_Upper_Foot = new MowzieModelRenderer(this, 81, 0);
        Left_Upper_Foot.addBox(-2F, 0F, 0F, 3, 4, 2);
        Left_Upper_Foot.setRotationPoint(7.5F, 18F, 8.3F);
        Left_Upper_Foot.setTextureSize(256, 256);
        Left_Upper_Foot.mirror = true;
        setRotation(Left_Upper_Foot, -0.3490659F, 0F, 0F);
        Right_Lower_Foot = new MowzieModelRenderer(this, 98, 0);
        Right_Lower_Foot.addBox(-2F, 0F, 0F, 4, 2, 2);
        Right_Lower_Foot.setRotationPoint(-7.1F, 20.8F, 7.7F);
        Right_Lower_Foot.setTextureSize(256, 256);
        Right_Lower_Foot.mirror = true;
        setRotation(Right_Lower_Foot, -0.9075712F, 0F, 0F);
        Right_Upper_Foot = new MowzieModelRenderer(this, 81, 0);
        Right_Upper_Foot.addBox(-1.5F, 0F, 0F, 3, 4, 2);
        Right_Upper_Foot.setRotationPoint(-7.1F, 18F, 8.3F);
        Right_Upper_Foot.setTextureSize(256, 256);
        Right_Upper_Foot.mirror = true;
        setRotation(Right_Upper_Foot, -0.3490659F, 0F, 0F);
        Left_Calf_1 = new MowzieModelRenderer(this, 65, 0);
        Left_Calf_1.addBox(-1.5F, 0F, 0F, 3, 12, 4);
        Left_Calf_1.setRotationPoint(7F, 11.5F, 1F);
        Left_Calf_1.setTextureSize(256, 256);
        Left_Calf_1.mirror = true;
        setRotation(Left_Calf_1, 0.6283185F, 0F, 0F);
        Right_Calf_1 = new MowzieModelRenderer(this, 65, 0);
        Right_Calf_1.addBox(-1.5F, 0F, 0F, 3, 12, 4);
        Right_Calf_1.setRotationPoint(-7F, 11.5F, 1F);
        Right_Calf_1.setTextureSize(256, 256);
        Right_Calf_1.mirror = true;
        setRotation(Right_Calf_1, 0.6283185F, 0F, 0.0174533F);
        Left_Thigh = new MowzieModelRenderer(this, 27, 57);
        Left_Thigh.addBox(0F, 0F, -12F, 5, 6, 12);
        Left_Thigh.setRotationPoint(4.5F, 1F, 7F);
        Left_Thigh.setTextureSize(256, 256);
        Left_Thigh.mirror = true;
        setRotation(Left_Thigh, 0.8028515F, 0F, 0F);
        Right_Thigh = new MowzieModelRenderer(this, 27, 57);
        Right_Thigh.addBox(-5F, 0F, -12F, 5, 6, 12);
        Right_Thigh.setRotationPoint(-4.5F, 1F, 7F);
        Right_Thigh.setTextureSize(256, 256);
        Right_Thigh.mirror = true;
        setRotation(Right_Thigh, 0.8028515F, 0F, 0F);
        Body_1 = new MowzieModelRenderer(this, 130, 12);
        Body_1.addBox(-4.5F, 0F, -10F, 9, 12, 10);
        Body_1.setRotationPoint(0F, 0.3F, 0.1F);
        Body_1.setTextureSize(256, 256);
        Body_1.mirror = true;
        setRotation(Body_1, 0.2799756F, 0F, 0F);
        Body_2 = new MowzieModelRenderer(this, 182, 0);
        Body_2.addBox(-4F, 0F, -8F, 8, 9, 8);
        Body_2.setRotationPoint(0F, 3.3F, -9F);
        Body_2.setTextureSize(256, 256);
        Body_2.mirror = true;
        setRotation(Body_2, 0.669215F, 0F, 0F);
        Neck = new MowzieModelRenderer(this, 217, 0);
        Neck.addBox(-2.5F, 0F, -11F, 5, 5, 11);
        Neck.setRotationPoint(0F, 9.6F, -9F);
        Neck.setTextureSize(256, 256);
        Neck.mirror = true;
        setRotation(Neck, -0.3346075F, 0F, 0F);
        Tail_1 = new MowzieModelRenderer(this, 119, 39);
        Tail_1.addBox(-4.5F, 0F, -1F, 9, 10, 10);
        Tail_1.setRotationPoint(0F, -1.2F, 10F);
        Tail_1.setTextureSize(256, 256);
        Tail_1.mirror = true;
        setRotation(Tail_1, -0.0371786F, 0F, 0F);
        Tail_2 = new MowzieModelRenderer(this, 118, 61);
        Tail_2.addBox(-4F, 0F, 0F, 8, 7, 9);
        Tail_2.setRotationPoint(0F, 0F, 16F);
        Tail_2.setTextureSize(256, 256);
        Tail_2.mirror = true;
        setRotation(Tail_2, -0.0743572F, 0F, 0F);
        Tail_3 = new MowzieModelRenderer(this, 150, 80);
        Tail_3.addBox(-3F, 0F, 0F, 6, 6, 9);
        Tail_3.setRotationPoint(0F, 1F, 22F);
        Tail_3.setTextureSize(256, 256);
        Tail_3.mirror = true;
        setRotation(Tail_3, -0.0743572F, 0F, 0F);
        Tail_4 = new MowzieModelRenderer(this, 118, 80);
        Tail_4.addBox(-2F, 0F, 0F, 4, 5, 10);
        Tail_4.setRotationPoint(0F, 2F, 29F);
        Tail_4.setTextureSize(256, 256);
        Tail_4.mirror = true;
        setRotation(Tail_4, -0.1487144F, 0F, 0F);
        Tail_5 = new MowzieModelRenderer(this, 118, 149);
        Tail_5.addBox(-1.5F, 0F, 0F, 3, 4, 10);
        Tail_5.setRotationPoint(0F, 3.3F, 35F);
        Tail_5.setTextureSize(256, 256);
        Tail_5.mirror = true;
        setRotation(Tail_5, -0.185895F, 0F, 0F);
        Upper_Arm_Right = new MowzieModelRenderer(this, 0, 56);
        Upper_Arm_Right.addBox(-3F, 0F, 0F, 3, 3, 7);
        Upper_Arm_Right.setRotationPoint(-3.5F, 12F, -7F);
        Upper_Arm_Right.setTextureSize(256, 256);
        Upper_Arm_Right.mirror = true;
        setRotation(Upper_Arm_Right, -1.07818F, 0F, 0F);
        Upper_Arm_Left = new MowzieModelRenderer(this, 0, 56);
        Upper_Arm_Left.addBox(0F, 0F, 0F, 3, 3, 7);
        Upper_Arm_Left.setRotationPoint(3.5F, 12F, -7F);
        Upper_Arm_Left.setTextureSize(256, 256);
        Upper_Arm_Left.mirror = true;
        setRotation(Upper_Arm_Left, -1.07818F, 0F, 0F);
        Lower_Arm_Left = new MowzieModelRenderer(this, 0, 71);
        Lower_Arm_Left.addBox(-1F, 0F, 0F, 2, 7, 2);
        Lower_Arm_Left.setRotationPoint(5F, 17F, -6F);
        Lower_Arm_Left.setTextureSize(256, 256);
        Lower_Arm_Left.mirror = true;
        setRotation(Lower_Arm_Left, -0.5129616F, 0F, 0F);
        Lower_Arm_Right = new MowzieModelRenderer(this, 0, 71);
        Lower_Arm_Right.addBox(-1F, 0F, 0F, 2, 7, 2);
        Lower_Arm_Right.setRotationPoint(-5F, 17F, -6F);
        Lower_Arm_Right.setTextureSize(256, 256);
        Lower_Arm_Right.mirror = true;
        setRotation(Lower_Arm_Right, -0.5129697F, 0F, 0F);
        Left_Hand = new MowzieModelRenderer(this, 0, 83);
        Left_Hand.addBox(-1F, -1F, -0.5F, 2, 4, 1);
        Left_Hand.setRotationPoint(5F, 23.5F, -8F);
        Left_Hand.setTextureSize(256, 256);
        Left_Hand.mirror = true;
        setRotation(Left_Hand, -1.570796F, 0F, 0F);
        Right_Hand = new MowzieModelRenderer(this, 0, 83);
        Right_Hand.addBox(0F, -1F, -0.5F, 2, 4, 1);
        Right_Hand.setRotationPoint(-6F, 23.5F, -8F);
        Right_Hand.setTextureSize(256, 256);
        Right_Hand.mirror = true;
        setRotation(Right_Hand, -1.570796F, 0F, 0F);
        Tail_6 = new MowzieModelRenderer(this, 118, 100);
        Tail_6.addBox(-1F, 0F, 0F, 2, 3, 8);
        Tail_6.setRotationPoint(0F, 5.2F, 43F);
        Tail_6.setTextureSize(256, 256);
        Tail_6.mirror = true;
        setRotation(Tail_6, -0.2974289F, 0F, 0F);
        Head = new MowzieModelRenderer(this, 217, 40);
        Head.addBox(-3F, 0F, -6F, 6, 6, 6);
        Head.setRotationPoint(0F, 5F, -18F);
        Head.setTextureSize(256, 256);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Snout_1 = new MowzieModelRenderer(this, 217, 23);
        Snout_1.addBox(-2.5F, 0F, -6F, 5, 2, 6);
        Snout_1.setRotationPoint(0F, 7F, -23.1F);
        Snout_1.setTextureSize(256, 256);
        Snout_1.mirror = true;
        setRotation(Snout_1, 0F, 0F, 0F);
        Snout_2 = new MowzieModelRenderer(this, 217, 58);
        Snout_2.addBox(-2F, 0F, -6F, 4, 2, 6);
        Snout_2.setRotationPoint(0F, 5.3F, -23F);
        Snout_2.setTextureSize(256, 256);
        Snout_2.mirror = true;
        setRotation(Snout_2, 0.2974289F, 0F, 0F);
        Jaw = new MowzieModelRenderer(this, 217, 71);
        Jaw.addBox(-1.5F, 0F, 0F, 3, 1, 6);
        Jaw.setRotationPoint(0F, 10F, -22F);
        Jaw.setTextureSize(256, 256);
        Jaw.mirror = true;
        setRotation(Jaw, 3.141593F, 0F, 0F);
        Crest_1 = new MowzieModelRenderer(this, 0, 32);
        Crest_1.addBox(-1F, 0F, 0F, 2, 6, 2);
        Crest_1.setRotationPoint(0F, 8.5F, -27F);
        Crest_1.setTextureSize(256, 256);
        Crest_1.mirror = true;
        setRotation(Crest_1, 2.156352F, 0F, 0F);
        Crest_2 = new MowzieModelRenderer(this, 0, 32);
        Crest_2.addBox(-1F, 0F, 0F, 2, 6, 2);
        Crest_2.setRotationPoint(0F, 5.6F, -22.5F);
        Crest_2.setTextureSize(256, 256);
        Crest_2.mirror = true;
        setRotation(Crest_2, 1.970459F, 0F, 0F);
        Crest_3 = new MowzieModelRenderer(this, 0, 32);
        Crest_3.addBox(-1F, 0F, 0F, 2, 5, 2);
        Crest_3.setRotationPoint(0F, 3.6F, -17.6F);
        Crest_3.setTextureSize(256, 256);
        Crest_3.mirror = true;
        setRotation(Crest_3, 1.710209F, 0F, 0F);
        Body_3 = new MowzieModelRenderer(this, 118, 118);
        Body_3.addBox(-5.5F, -3F, -8F, 11, 13, 13);
        Body_3.setRotationPoint(0F, 2F, 7F);
        Body_3.setTextureSize(256, 256);
        Body_3.mirror = true;
        setRotation(Body_3, 0.1509865F, 0F, 0F);
        Foot_Left = new MowzieModelRenderer(this, 0, 20);
        Foot_Left.addBox(-2F, -2F, 0F, 4, 2, 6);
        Foot_Left.setRotationPoint(7F, 22F, 8F);
        Foot_Left.setTextureSize(256, 256);
        Foot_Left.mirror = true;
        setRotation(Foot_Left, 3.141593F, 0F, 0F);
        Foot_Right = new MowzieModelRenderer(this, 0, 20);
        Foot_Right.addBox(-2F, -2F, 0F, 4, 2, 6);
        Foot_Right.setRotationPoint(-7.1F, 22F, 8F);
        Foot_Right.setTextureSize(256, 256);
        Foot_Right.mirror = true;
        setRotation(Foot_Right, 3.141593F, 0F, 0F);

        addChildTo(Snout_1, Head);
        addChildTo(Snout_2, Head);
        addChildTo(Jaw, Head);
        addChildTo(Crest_1, Head);
        addChildTo(Crest_2, Head);
        addChildTo(Crest_3, Head);

        addChildTo(Head, Neck);
        addChildTo(Neck, Body_2);
        addChildTo(Body_2, Body_1);

        addChildTo(Left_Hand, Lower_Arm_Left);
        addChildTo(Lower_Arm_Left, Upper_Arm_Left);
        addChildTo(Upper_Arm_Left, Body_1);
        addChildTo(Right_Hand, Lower_Arm_Right);
        addChildTo(Lower_Arm_Right, Upper_Arm_Right);
        addChildTo(Upper_Arm_Right, Body_1);

        addChildTo(Body_1, Body_3);

        addChildTo(Tail_6, Tail_5);
        addChildTo(Tail_5, Tail_4);
        addChildTo(Tail_4, Tail_3);
        addChildTo(Tail_3, Tail_2);
        addChildTo(Tail_2, Tail_1);
        addChildTo(Tail_1, Body_3);

        addChildTo(Foot_Right, Right_Lower_Foot);
        addChildTo(Right_Lower_Foot, Right_Upper_Foot);
        addChildTo(Right_Upper_Foot, Right_Calf_1);
        addChildTo(Right_Calf_1, Right_Thigh);

        addChildTo(Foot_Left, Left_Lower_Foot);
        addChildTo(Left_Lower_Foot, Left_Upper_Foot);
        addChildTo(Left_Upper_Foot, Left_Calf_1);
        addChildTo(Left_Calf_1, Left_Thigh);

        // Corrections
        Crest_3.setRotationPoint(0, Crest_3.rotationPointY, 6);
        Crest_3.offsetY -= 0.19F;
        Crest_3.offsetZ -= 0.35F;
        Head.rotationPointY -= 2;
        Head.rotationPointZ -= 20;
        Body_1.rotationPointY -= 5;
        Body_1.rotationPointZ -= 15;
        Tail_1.rotationPointY -= 5;
        Tail_1.rotationPointZ += 7;

        // Adjustments
        Body_3.rotateAngleX -= 0.25F;
        Neck.rotateAngleX += 0.25F;
        Left_Hand.rotateAngleX += 2F;
        Right_Hand.rotateAngleX += 2F;
        Lower_Arm_Left.rotateAngleX -= 0.5F;
        Lower_Arm_Right.rotateAngleX -= 0.5F;
        Upper_Arm_Left.rotateAngleX += 0.5F;
        Upper_Arm_Right.rotateAngleX += 0.5F;

        tailParts = new MowzieModelRenderer[] { this.Tail_6, this.Tail_5, this.Tail_4, this.Tail_3, this.Tail_2, this.Tail_1 };
        bodyParts = new MowzieModelRenderer[] { this.Body_3, this.Body_1, this.Body_2, this.Neck, this.Head };

        Left_Lower_Foot.updateDefaultPose();
        Left_Upper_Foot.updateDefaultPose();
        Right_Lower_Foot.updateDefaultPose();
        Right_Upper_Foot.updateDefaultPose();
        Left_Calf_1.updateDefaultPose();
        Right_Calf_1.updateDefaultPose();
        Left_Thigh.updateDefaultPose();
        Right_Thigh.updateDefaultPose();
        Body_1.updateDefaultPose();
        Body_2.updateDefaultPose();
        Neck.updateDefaultPose();
        Tail_1.updateDefaultPose();
        Tail_2.updateDefaultPose();
        Tail_3.updateDefaultPose();
        Tail_4.updateDefaultPose();
        Tail_5.updateDefaultPose();
        Upper_Arm_Right.updateDefaultPose();
        Upper_Arm_Left.updateDefaultPose();
        Lower_Arm_Left.updateDefaultPose();
        Lower_Arm_Right.updateDefaultPose();
        Left_Hand.updateDefaultPose();
        Right_Hand.updateDefaultPose();
        Tail_6.updateDefaultPose();
        Head.updateDefaultPose();
        Snout_1.updateDefaultPose();
        Snout_2.updateDefaultPose();
        Jaw.updateDefaultPose();
        Crest_1.updateDefaultPose();
        Crest_2.updateDefaultPose();
        Crest_3.updateDefaultPose();
        Body_3.updateDefaultPose();
        Foot_Left.updateDefaultPose();
        Foot_Right.updateDefaultPose();
    }

    public boolean setAlarmed(boolean setAlarm) {
        return this.isAlarmed = setAlarm;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        /*
         * Left_Lower_Foot.render(f5); Left_Upper_Foot.render(f5); Right_Lower_Foot.render(f5); Right_Upper_Foot.render(f5); Left_Calf_1.render(f5); Right_Calf_1.render(f5);
         */
        Left_Thigh.render(f5);
        Right_Thigh.render(f5);
        // Body_1.render(f5);
        // Body_2.render(f5);
        // Neck.render(f5);
        /*
         * Tail_1.render(f5); Tail_2.render(f5); Tail_3.render(f5); Tail_4.render(f5); Tail_5.render(f5);
         */
        /*
         * Upper_Arm_Right.render(f5); Upper_Arm_Left.render(f5); Lower_Arm_Left.render(f5); Lower_Arm_Right.render(f5); Left_Hand.render(f5); Right_Hand.render(f5);
         */
        // Tail_6.render(f5);
        /*
         * Head.render(f5); Snout_1.render(f5); Snout_2.render(f5); Jaw.render(f5); Crest_1.render(f5); Crest_2.render(f5); Crest_3.render(f5);
         */
        Body_3.render(f5);
        // Foot_Left.render(f5);
        // Foot_Right.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void resetPose() {
        Left_Lower_Foot.resetToDefaultPose();
        Left_Upper_Foot.resetToDefaultPose();
        Right_Lower_Foot.resetToDefaultPose();
        Right_Upper_Foot.resetToDefaultPose();
        Left_Calf_1.resetToDefaultPose();
        Right_Calf_1.resetToDefaultPose();
        Left_Thigh.resetToDefaultPose();
        Right_Thigh.resetToDefaultPose();
        Body_1.resetToDefaultPose();
        Body_2.resetToDefaultPose();
        Neck.resetToDefaultPose();
        Tail_1.resetToDefaultPose();
        Tail_2.resetToDefaultPose();
        Tail_3.resetToDefaultPose();
        Tail_4.resetToDefaultPose();
        Tail_5.resetToDefaultPose();
        Upper_Arm_Right.resetToDefaultPose();
        Upper_Arm_Left.resetToDefaultPose();
        Lower_Arm_Left.resetToDefaultPose();
        Lower_Arm_Right.resetToDefaultPose();
        Left_Hand.resetToDefaultPose();
        Right_Hand.resetToDefaultPose();
        Tail_6.resetToDefaultPose();
        Head.resetToDefaultPose();
        Snout_1.resetToDefaultPose();
        Snout_2.resetToDefaultPose();
        Jaw.resetToDefaultPose();
        Crest_1.resetToDefaultPose();
        Crest_2.resetToDefaultPose();
        Crest_3.resetToDefaultPose();
        Body_3.resetToDefaultPose();
        Foot_Left.resetToDefaultPose();
        Foot_Right.resetToDefaultPose();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityParasaurolophus para) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, para);
        this.resetPose();
        /*
         * f = para.frame; f1 = (float) Math.cos(f/20)*0.25F + 0.5F;
         */
        float scaleFactor = 0.6F;
        float height = 2F;
        float allFoursLean = (float) (Math.pow(f1, 1 / (f1 * 10)) / 4);
        faceTarget(f3, f4, 1.0F, Head, Neck);

        if (allFoursLean > 0.15F)
            allFoursLean = 0.15F;

        // All fours behavior
        Body_3.rotateAngleX += allFoursLean * 1.5;
        Body_2.rotateAngleX -= allFoursLean / 5;
        Neck.rotateAngleX -= 2 * allFoursLean / 5 * 1.5;
        Head.rotateAngleX -= 2 * allFoursLean / 5 * 1.5;
        Tail_1.rotateAngleX -= 2 * allFoursLean / 7;
        Tail_2.rotateAngleX -= 1 * allFoursLean / 7;
        Tail_3.rotateAngleX -= 1 * allFoursLean / 7;
        Tail_4.rotateAngleX -= 1 * allFoursLean / 7;
        Tail_5.rotateAngleX -= 1 * allFoursLean / 7;
        Tail_6.rotateAngleX -= 1 * allFoursLean / 7;
        Upper_Arm_Left.rotateAngleX -= allFoursLean * 4;
        Upper_Arm_Right.rotateAngleX -= allFoursLean * 4;
        Lower_Arm_Left.rotateAngleX += allFoursLean * 4;
        Lower_Arm_Right.rotateAngleX += allFoursLean * 4;
        Left_Hand.rotateAngleX -= allFoursLean * 12;
        Right_Hand.rotateAngleX -= allFoursLean * 12;

        bob(Body_3, 1F * scaleFactor, 1F * height, false, f, f1);
        bob(Left_Thigh, 1F * scaleFactor, 1F * height, false, f, f1);
        bob(Right_Thigh, 1F * scaleFactor, 1F * height, false, f, f1);

        walk(Neck, 1F * scaleFactor, 0.15F * height, false, 1F, 0F, f, f1);
        walk(Head, 1F * scaleFactor, 0.15F * height, true, 1F, 0F, f, f1);

        walk(Left_Thigh, 0.5F * scaleFactor, 0.5F, false, 0F, 0.3F, f, f1);
        walk(Left_Calf_1, 0.5F * scaleFactor, 0.5F, true, 2F, 0F, f, f1);
        walk(Left_Upper_Foot, 0.5F * scaleFactor, 0.7F, false, 0F, -0.4F, f, f1);
        walk(Foot_Left, 0.5F * scaleFactor, 1F, true, 0.5F, 1F, f, f1);

        walk(Right_Thigh, 0.5F * scaleFactor, 0.5F, true, 0F, 0.3F, f, f1);
        walk(Right_Calf_1, 0.5F * scaleFactor, 0.5F, false, 2F, 0F, f, f1);
        walk(Right_Upper_Foot, 0.5F * scaleFactor, 0.7F, true, 0F, -0.4F, f, f1);
        walk(Foot_Right, 0.5F * scaleFactor, 1F, false, 0.5F, 1F, f, f1);

        float frontOffset = 1.3F;
        walk(Upper_Arm_Left, 0.5F * scaleFactor, 1F, false, -0.5F - frontOffset, 0F, f, f1);
        walk(Lower_Arm_Left, 0.5F * scaleFactor, 1F, true, -1F - frontOffset, 0F, f, f1);
        walk(Left_Hand, 0.5F * scaleFactor, 0.5F, false, -1F - frontOffset, 0F, f, f1);

        walk(Upper_Arm_Right, 0.5F * scaleFactor, 1F, true, -0.5F - frontOffset, 0F, f, f1);
        walk(Lower_Arm_Right, 0.5F * scaleFactor, 1F, false, -1F - frontOffset, 0F, f, f1);
        walk(Right_Hand, 0.5F * scaleFactor, 0.5F, true, -1F - frontOffset, 0F, f, f1);

        chainWave(tailParts, 1F * scaleFactor, -0.1F, 2, f, f1);
        chainSwing(tailParts, 0.5F * scaleFactor, 0.1F, 2, f, f1);

        // Idle
        walk(Neck, 0.1F, 0.07F, false, -1F, 0F, para.frame, 1F);
        walk(Head, 0.1F, 0.07F, true, 0F, 0F, para.frame, 1F);
        walk(Body_3, 0.1F, 0.04F, false, 0F, 0F, para.frame, 1F);
        walk(Upper_Arm_Right, 0.1F, 0.1F, false, -1F, 0F, para.frame, 1F);
        walk(Upper_Arm_Left, 0.1F, 0.1F, false, -1F, 0F, para.frame, 1F);
        walk(Lower_Arm_Right, 0.1F, 0.1F, true, -1.5F, 0F, para.frame, 1F);
        walk(Lower_Arm_Left, 0.1F, 0.1F, true, -1.5F, 0F, para.frame, 1F);
        walk(Right_Hand, 0.1F, 0.1F, false, -2F, 0F, para.frame, 1F);
        walk(Left_Hand, 0.1F, 0.1F, false, -2F, 0F, para.frame, 1F);

        chainWave(this.tailParts, 0.1F, -0.02F, 2, para.frame, 1F);

        para.tailBuffer.applyChainSwingBuffer(this.tailParts);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (EntityParasaurolophus) entity);

        animator.setAnimation(JurassiCraftAnimationIDs.TRUMPET.animID());
        animator.startPhase(15);
        animator.rotate(Body_3, 0.3F, 0, 0);
        animator.rotate(Body_1, 0.1F, 0, 0);
        animator.rotate(Body_2, 0.1F, 0, 0);
        animator.rotate(Neck, -0.6F, 0, 0);
        animator.move(Neck, 0, -2, 0);
        animator.rotate(Head, 0.7F, 0, 0);
        animator.rotate(Upper_Arm_Right, 0.4F, 0, 0);
        animator.rotate(Upper_Arm_Left, 0.4F, 0, 0);
        animator.rotate(Lower_Arm_Right, -0.6F, 0, 0);
        animator.rotate(Lower_Arm_Left, -0.6F, 0, 0);
        animator.rotate(Right_Hand, 0.4F, 0, 0);
        animator.rotate(Left_Hand, 0.4F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(5);
        animator.startPhase(10);
        animator.rotate(Body_3, -0.5F, 0, 0);
        animator.rotate(Neck, 0.5F, 0, 0);
        animator.rotate(Head, -0.5F, 0, 0);
        animator.rotate(Jaw, 0.2F, 0, 0);
        animator.move(Neck, 0, -2.3F, 0);
        animator.rotate(Tail_1, 0.2F, 0, 0);
        animator.rotate(Tail_2, 0.2F, 0, 0);
        animator.rotate(Tail_3, 0.2F, 0, 0);
        animator.rotate(Tail_4, 0.2F, 0, 0);
        animator.rotate(Tail_5, 0.2F, 0, 0);
        animator.rotate(Tail_6, 0.2F, 0, 0);
        animator.endPhase();
        animator.setStationaryPhase(20);
        animator.resetPhase(10);
    }
}
