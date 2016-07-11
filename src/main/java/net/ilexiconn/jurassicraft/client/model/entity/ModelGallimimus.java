package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelGallimimus extends MowzieModelBase {
    public Animator animator;
    public MowzieModelRenderer Left_Upper_Foot;
    public MowzieModelRenderer Right_Upper_Foot;
    public MowzieModelRenderer Left_Calf_1;
    public MowzieModelRenderer Right_Calf_1;
    public MowzieModelRenderer Left_Thigh;
    public MowzieModelRenderer Right_Thigh;
    public MowzieModelRenderer Body_1;
    public MowzieModelRenderer Body_2;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer Upper_Jaw;
    public MowzieModelRenderer Lower_Jaw;
    public MowzieModelRenderer Tail_1;
    public MowzieModelRenderer Tail_2;
    public MowzieModelRenderer Tail_3;
    public MowzieModelRenderer Tail_4;
    public MowzieModelRenderer Tail_5;
    public MowzieModelRenderer Upper_Arm_Right;
    public MowzieModelRenderer Upper_Arm_Left;
    public MowzieModelRenderer Lower_Arm_Left;
    public MowzieModelRenderer Lower_Arm_Right;
    public MowzieModelRenderer Hand_Left;
    public MowzieModelRenderer Hand_Right;
    public MowzieModelRenderer Hand_Left_Claw_Left;
    public MowzieModelRenderer Hand_Left_Claw_Right;
    public MowzieModelRenderer Hand_Left_Claw_Middle;
    public MowzieModelRenderer Hand_Right_Claw_Right;
    public MowzieModelRenderer Hand_Right_Claw_Left;
    public MowzieModelRenderer Hand_Right_Claw_Middle;
    public MowzieModelRenderer Foot_Left;
    public MowzieModelRenderer Foot_Right;
    public MowzieModelRenderer Neck_1;
    public MowzieModelRenderer Neck_2;
    public MowzieModelRenderer Neck_3;
    public MowzieModelRenderer Neck_4;
    public MowzieModelRenderer Neck_5;
    public MowzieModelRenderer HeadJoint;
    public MowzieModelRenderer[] NeckParts;
    public MowzieModelRenderer[] TailParts;
    public MowzieModelRenderer[] RightArmParts;
    public MowzieModelRenderer[] LeftArmParts;
    public MowzieModelRenderer[] RightLegParts;
    public MowzieModelRenderer[] LeftLegParts;

    public ModelGallimimus() {
        this.animator = new Animator(this);
        textureWidth = 256;
        textureHeight = 256;

        Left_Calf_1 = new MowzieModelRenderer(this, 65, 0);
        Left_Calf_1.addBox(-1.5F, 0F, 0F, 3, 10, 3);
        Left_Calf_1.setRotationPoint(5F, 12.5F, 2F);
        Left_Calf_1.setTextureSize(256, 256);
        Left_Calf_1.mirror = false;
        setRotation(Left_Calf_1, 0.7238469F, 0F, 0F);
        Right_Calf_1 = new MowzieModelRenderer(this, 65, 0);
        Right_Calf_1.addBox(-1.5F, 0F, 0F, 3, 10, 3);
        Right_Calf_1.setRotationPoint(-5F, 12.5F, 2F);
        Right_Calf_1.setTextureSize(256, 256);
        Right_Calf_1.mirror = false;
        setRotation(Right_Calf_1, 0.7238469F, 0F, 0.0174533F);
        Left_Thigh = new MowzieModelRenderer(this, 27, 57);
        Left_Thigh.addBox(0F, 0F, -10F, 4, 4, 11);
        Left_Thigh.setRotationPoint(3F, 4F, 6F);
        Left_Thigh.setTextureSize(256, 256);
        Left_Thigh.mirror = false;
        setRotation(Left_Thigh, 1.029744F, 0F, 0F);
        Right_Thigh = new MowzieModelRenderer(this, 27, 57);
        Right_Thigh.addBox(-4F, 0F, -10F, 4, 4, 11);
        Right_Thigh.setRotationPoint(-3F, 4F, 6F);
        Right_Thigh.setTextureSize(256, 256);
        Right_Thigh.mirror = false;
        setRotation(Right_Thigh, 1.029744F, 0F, 0F);
        Body_1 = new MowzieModelRenderer(this, 118, 0);
        Body_1.addBox(-3.5F, -2F, -9F, 7, 8, 12);
        Body_1.setRotationPoint(0F, 3.6F, 7F);
        Body_1.setTextureSize(256, 256);
        Body_1.mirror = false;
        setRotation(Body_1, -0.0219973F, 0F, 0F);
        Body_2 = new MowzieModelRenderer(this, 182, 21);
        Body_2.addBox(-3F, 0F, -7F, 6, 7, 7);
        Body_2.setRotationPoint(0F, 2.2F, 2F);
        Body_2.setTextureSize(256, 256);
        Body_2.mirror = false;
        setRotation(Body_2, -0.2595274F, 0F, 0F);
        Head = new MowzieModelRenderer(this, 0, 92);
        Head.addBox(-2F, 0F, -5F, 4, 5, 5);
        Head.setRotationPoint(0F, -10.5F, -12.5F);
        Head.setTextureSize(256, 256);
        Head.mirror = false;
        setRotation(Head, 0F, 0F, 0F);
        Upper_Jaw = new MowzieModelRenderer(this, 12, 26);
        Upper_Jaw.addBox(-1F, -2F, -4F, 2, 2, 4);
        Upper_Jaw.setRotationPoint(0F, -7F, -17.5F);
        Upper_Jaw.setTextureSize(256, 256);
        Upper_Jaw.mirror = false;
        setRotation(Upper_Jaw, 0F, 0F, 0F);
        Lower_Jaw = new MowzieModelRenderer(this, 70, 27);
        Lower_Jaw.addBox(-1F, -1F, -5F, 2, 1, 4);
        Lower_Jaw.setRotationPoint(0F, -6F, -16.5F);
        Lower_Jaw.setTextureSize(256, 256);
        Lower_Jaw.mirror = false;
        setRotation(Lower_Jaw, 0F, 0F, 0F);
        Tail_1 = new MowzieModelRenderer(this, 118, 39);
        Tail_1.addBox(-3F, 0F, 0F, 6, 6, 8);
        Tail_1.setRotationPoint(0F, 2.1F, 7F);
        Tail_1.setTextureSize(256, 256);
        Tail_1.mirror = false;
        setRotation(Tail_1, 0.0181172F, 0F, 0F);
        Tail_2 = new MowzieModelRenderer(this, 118, 61);
        Tail_2.addBox(-2.5F, 0F, -0.2F, 5, 5, 6);
        Tail_2.setRotationPoint(0F, 2.3F, 15F);
        Tail_2.setTextureSize(256, 256);
        Tail_2.mirror = false;
        setRotation(Tail_2, 0.0351279F, 0F, 0F);
        Tail_3 = new MowzieModelRenderer(this, 118, 119);
        Tail_3.addBox(-2F, 0F, 0F, 4, 4, 6);
        Tail_3.setRotationPoint(0F, 2.7F, 20F);
        Tail_3.setTextureSize(256, 256);
        Tail_3.mirror = false;
        setRotation(Tail_3, -0.0546319F, 0F, 0F);
        Tail_4 = new MowzieModelRenderer(this, 118, 80);
        Tail_4.addBox(-1.5F, 0F, 0F, 3, 3, 7);
        Tail_4.setRotationPoint(0F, 3.5F, 25F);
        Tail_4.setTextureSize(256, 256);
        Tail_4.mirror = false;
        setRotation(Tail_4, -0.0698132F, 0F, 0F);
        Tail_5 = new MowzieModelRenderer(this, 118, 100);
        Tail_5.addBox(-1F, 0F, 0F, 2, 2, 9);
        Tail_5.setRotationPoint(0F, 4.5F, 31F);
        Tail_5.setTextureSize(256, 256);
        Tail_5.mirror = false;
        setRotation(Tail_5, 0.0500879F, 0F, 0F);
        Upper_Arm_Right = new MowzieModelRenderer(this, 0, 56);
        Upper_Arm_Right.addBox(-2F, 0F, 0F, 2, 2, 5);
        Upper_Arm_Right.setRotationPoint(-3F, 5F, -4F);
        Upper_Arm_Right.setTextureSize(256, 256);
        Upper_Arm_Right.mirror = false;
        setRotation(Upper_Arm_Right, -1.22173F, 0F, 0F);
        Upper_Arm_Left = new MowzieModelRenderer(this, 0, 56);
        Upper_Arm_Left.addBox(0F, 0F, 0F, 2, 2, 5);
        Upper_Arm_Left.setRotationPoint(3F, 5F, -4F);
        Upper_Arm_Left.setTextureSize(256, 256);
        Upper_Arm_Left.mirror = false;
        setRotation(Upper_Arm_Left, -1.22173F, 0F, 0F);
        Lower_Arm_Left = new MowzieModelRenderer(this, 0, 68);
        Lower_Arm_Left.addBox(-1F, 0F, 0F, 1, 5, 1);
        Lower_Arm_Left.setRotationPoint(4.5F, 9F, -3.5F);
        Lower_Arm_Left.setTextureSize(256, 256);
        Lower_Arm_Left.mirror = false;
        setRotation(Lower_Arm_Left, -0.6320364F, 0F, 0F);
        Lower_Arm_Right = new MowzieModelRenderer(this, 0, 68);
        Lower_Arm_Right.addBox(-1F, 0F, 0F, 1, 5, 1);
        Lower_Arm_Right.setRotationPoint(-3.5F, 9F, -3.5F);
        Lower_Arm_Right.setTextureSize(256, 256);
        Lower_Arm_Right.mirror = false;
        setRotation(Lower_Arm_Right, -0.6320364F, 0F, 0F);
        Hand_Left = new MowzieModelRenderer(this, 81, 54);
        Hand_Left.addBox(0F, -1F, 0F, 2, 1, 2);
        Hand_Left.setRotationPoint(3.5F, 13F, -7F);
        Hand_Left.setTextureSize(256, 256);
        Hand_Left.mirror = false;
        setRotation(Hand_Left, -1.58825F, -0.4537856F, 0F);
        Hand_Right = new MowzieModelRenderer(this, 81, 54);
        Hand_Right.addBox(-2F, 0F, 0F, 2, 1, 2);
        Hand_Right.setRotationPoint(-3F, 13F, -6.2F);
        Hand_Right.setTextureSize(256, 256);
        Hand_Right.mirror = false;
        setRotation(Hand_Right, -1.58825F, 0.4537856F, 0F);
        Foot_Left = new MowzieModelRenderer(this, 0, 0);
        Foot_Left.addBox(-1.5F, 0F, -3F, 3, 2, 5);
        Foot_Left.setRotationPoint(5F, 22F, 5.5F);
        Foot_Left.setTextureSize(256, 256);
        Foot_Left.mirror = false;
        setRotation(Foot_Left, 0F, 0F, 0F);
        Foot_Right = new MowzieModelRenderer(this, 0, 0);
        Foot_Right.addBox(-1.5F, 0F, -3F, 3, 2, 5);
        Foot_Right.setRotationPoint(-5.1F, 22F, 5.5F);
        Foot_Right.setTextureSize(256, 256);
        Foot_Right.mirror = false;
        setRotation(Foot_Right, 0F, 0F, 0F);
        Neck_1 = new MowzieModelRenderer(this, 182, 38);
        Neck_1.addBox(-2F, 0F, -7F, 4, 4, 8);
        Neck_1.setRotationPoint(0F, 2.6F, -3F);
        Neck_1.setTextureSize(256, 256);
        Neck_1.mirror = false;
        setRotation(Neck_1, -0.8573801F, 0F, 0F);
        Neck_2 = new MowzieModelRenderer(this, 182, 52);
        Neck_2.addBox(-1.5F, 0F, -4F, 3, 3, 4);
        Neck_2.setRotationPoint(0F, -1.2F, -7.3F);
        Neck_2.setTextureSize(256, 256);
        Neck_2.mirror = false;
        setRotation(Neck_2, -1.202625F, 0F, 0F);
        Neck_3 = new MowzieModelRenderer(this, 200, 52);
        Neck_3.addBox(-1.5F, 0F, -3F, 3, 3, 3);
        Neck_3.setRotationPoint(0F, -3.8F, -8.5F);
        Neck_3.setTextureSize(256, 256);
        Neck_3.mirror = false;
        setRotation(Neck_3, -1.552414F, 0F, 0F);
        Neck_4 = new MowzieModelRenderer(this, 182, 65);
        Neck_4.addBox(-1.5F, 0F, -2F, 3, 2, 2);
        Neck_4.setRotationPoint(0F, -6.8F, -8.6F);
        Neck_4.setTextureSize(256, 256);
        Neck_4.mirror = false;
        setRotation(Neck_4, -0.9795531F, 0F, 0F);
        Neck_5 = new MowzieModelRenderer(this, 182, 72);
        Neck_5.addBox(-1.5F, 0F, -3F, 3, 3, 3);
        Neck_5.setRotationPoint(0F, -8.5F, -9.7F);
        Neck_5.setTextureSize(256, 256);
        Neck_5.mirror = false;
        setRotation(Neck_5, -0.3846954F, 0F, 0F);
        Left_Upper_Foot = new MowzieModelRenderer(this, 67, 1);
        Left_Upper_Foot.addBox(-1F, 0F, -1F, 2, 7, 2);
        Left_Upper_Foot.setRotationPoint(5F, 18F, 8.6F);
        Left_Upper_Foot.setTextureSize(256, 256);
        Left_Upper_Foot.mirror = false;
        setRotation(Left_Upper_Foot, -0.6123111F, 0F, 0F);
        Right_Upper_Foot = new MowzieModelRenderer(this, 67, 1);
        Right_Upper_Foot.addBox(-1F, 0F, -1F, 2, 7, 2);
        Right_Upper_Foot.setRotationPoint(-5F, 18F, 8.6F);
        Right_Upper_Foot.setTextureSize(256, 256);
        Right_Upper_Foot.mirror = false;
        setRotation(Right_Upper_Foot, -0.6123111F, 0F, 0F);
        Hand_Left_Claw_Left = new MowzieModelRenderer(this, 81, 57);
        Hand_Left_Claw_Left.addBox(0F, 0F, -0.5F, 1, 2, 1);
        Hand_Left_Claw_Left.setRotationPoint(4.5F, 14F, -6.7F);
        Hand_Left_Claw_Left.setTextureSize(256, 256);
        Hand_Left_Claw_Left.mirror = false;
        setRotation(Hand_Left_Claw_Left, 0F, -2.089644F, 0F);
        Hand_Left_Claw_Right = new MowzieModelRenderer(this, 81, 57);
        Hand_Left_Claw_Right.addBox(0F, 0F, 0F, 1, 2, 1);
        Hand_Left_Claw_Right.setRotationPoint(4.5F, 14F, -6.4F);
        Hand_Left_Claw_Right.setTextureSize(256, 256);
        Hand_Left_Claw_Right.mirror = false;
        setRotation(Hand_Left_Claw_Right, 0.5235988F, -2.089644F, 0F);
        Hand_Left_Claw_Middle = new MowzieModelRenderer(this, 81, 57);
        Hand_Left_Claw_Middle.addBox(0F, 0F, -0.7F, 1, 2, 1);
        Hand_Left_Claw_Middle.setRotationPoint(4.5F, 14F, -6.44F);
        Hand_Left_Claw_Middle.setTextureSize(256, 256);
        Hand_Left_Claw_Middle.mirror = false;
        setRotation(Hand_Left_Claw_Middle, -0.5917596F, -2.089644F, 0F);
        Hand_Right_Claw_Right = new MowzieModelRenderer(this, 81, 57);
        Hand_Right_Claw_Right.addBox(-0.9F, 0F, -0.5F, 1, 2, 1);
        Hand_Right_Claw_Right.setRotationPoint(-4.4F, 14F, -6.7F);
        Hand_Right_Claw_Right.setTextureSize(256, 256);
        Hand_Right_Claw_Right.mirror = false;
        setRotation(Hand_Right_Claw_Right, 0F, 2.089648F, 0F);
        Hand_Right_Claw_Left = new MowzieModelRenderer(this, 81, 57);
        Hand_Right_Claw_Left.addBox(-1F, 0F, 0F, 1, 2, 1);
        Hand_Right_Claw_Left.setRotationPoint(-4.3F, 14F, -6.4F);
        Hand_Right_Claw_Left.setTextureSize(256, 256);
        Hand_Right_Claw_Left.mirror = false;
        setRotation(Hand_Right_Claw_Left, 0.5235988F, 2.089648F, 0F);
        Hand_Right_Claw_Middle = new MowzieModelRenderer(this, 81, 57);
        Hand_Right_Claw_Middle.addBox(-1F, -0.1F, -0.6F, 1, 2, 1);
        Hand_Right_Claw_Middle.setRotationPoint(-4.5F, 14F, -6.4F);
        Hand_Right_Claw_Middle.setTextureSize(256, 256);
        Hand_Right_Claw_Middle.mirror = false;
        setRotation(Hand_Right_Claw_Middle, -0.5917596F, 2.089648F, 0F);
        HeadJoint = new MowzieModelRenderer(this, 81, 57);
        Hand_Right_Claw_Middle.addBox(0F, 0F, 0F, 0, 0, 0);
        HeadJoint.setRotationPoint(-4.5F, 14F, -6.4F);
        HeadJoint.setTextureSize(256, 256);
        HeadJoint.mirror = false;
        setRotation(HeadJoint, 0F, 0F, 0F);

        addChildTo(Lower_Jaw, Head);
        addChildTo(Upper_Jaw, Head);
        addChildTo(Head, HeadJoint);
        addChildTo(HeadJoint, Neck_5);
        addChildTo(Neck_5, Neck_4);
        addChildTo(Neck_4, Neck_3);
        addChildTo(Neck_3, Neck_2);
        addChildTo(Neck_2, Neck_1);
        addChildTo(Neck_1, Body_2);
        addChildTo(Body_2, Body_1);

        addChildTo(Foot_Left, Left_Upper_Foot);
        addChildTo(Left_Upper_Foot, Left_Calf_1);
        addChildTo(Left_Calf_1, Left_Thigh);

        addChildTo(Foot_Right, Right_Upper_Foot);
        addChildTo(Right_Upper_Foot, Right_Calf_1);
        addChildTo(Right_Calf_1, Right_Thigh);

        addChildTo(Hand_Left, Lower_Arm_Left);
        addChildTo(Lower_Arm_Left, Upper_Arm_Left);
        addChildTo(Upper_Arm_Left, Body_1);

        addChildTo(Hand_Right, Lower_Arm_Right);
        addChildTo(Lower_Arm_Right, Upper_Arm_Right);
        addChildTo(Upper_Arm_Right, Body_1);

        addChildTo(Tail_5, Tail_4);
        addChildTo(Tail_4, Tail_3);
        addChildTo(Tail_3, Tail_2);
        addChildTo(Tail_2, Tail_1);
        addChildTo(Tail_1, Body_1);

        // Corrections
        Head.setRotationPoint(0, 0, 0);
        HeadJoint.setRotationPoint(0, -1, -3);
        Neck_5.setRotationPoint(0, 0, -2);
        Neck_4.setRotationPoint(0, 0, -3);
        Neck_3.setRotationPoint(0, 0, -3);
        Neck_2.setRotationPoint(0, 0.5F, -6);
        Body_2.setRotationPoint(0, -1, -6F);
        Tail_1.rotationPointY -= 3;
        Foot_Left.offsetY += 0.15;
        Foot_Right.offsetY += 0.15;

        NeckParts = new MowzieModelRenderer[] { this.Head, this.Neck_5, this.Neck_4, this.Neck_3, this.Neck_2, this.Neck_1 };
        TailParts = new MowzieModelRenderer[] { this.Tail_5, this.Tail_4, this.Tail_3, this.Tail_2 };
        RightArmParts = new MowzieModelRenderer[] { this.Hand_Right, this.Lower_Arm_Right, this.Upper_Arm_Right };
        LeftArmParts = new MowzieModelRenderer[] { this.Hand_Left, this.Lower_Arm_Left, this.Upper_Arm_Left };
        RightLegParts = new MowzieModelRenderer[] { Foot_Right, Right_Upper_Foot, Right_Calf_1, Right_Thigh };
        LeftLegParts = new MowzieModelRenderer[] { Foot_Left, Left_Upper_Foot, Left_Calf_1, Left_Thigh };

        Left_Upper_Foot.updateDefaultPose();
        Right_Upper_Foot.updateDefaultPose();
        Left_Calf_1.updateDefaultPose();
        Right_Calf_1.updateDefaultPose();
        Left_Thigh.updateDefaultPose();
        Right_Thigh.updateDefaultPose();
        Body_1.updateDefaultPose();
        Body_2.updateDefaultPose();
        Head.updateDefaultPose();
        Upper_Jaw.updateDefaultPose();
        Lower_Jaw.updateDefaultPose();
        Tail_1.updateDefaultPose();
        Tail_2.updateDefaultPose();
        Tail_3.updateDefaultPose();
        Tail_4.updateDefaultPose();
        Tail_5.updateDefaultPose();
        Upper_Arm_Right.updateDefaultPose();
        Upper_Arm_Left.updateDefaultPose();
        Lower_Arm_Left.updateDefaultPose();
        Lower_Arm_Right.updateDefaultPose();
        Hand_Left.updateDefaultPose();
        Hand_Right.updateDefaultPose();
        Hand_Left_Claw_Left.updateDefaultPose();
        Hand_Left_Claw_Right.updateDefaultPose();
        Hand_Left_Claw_Middle.updateDefaultPose();
        Hand_Right_Claw_Right.updateDefaultPose();
        Hand_Right_Claw_Left.updateDefaultPose();
        Hand_Right_Claw_Middle.updateDefaultPose();
        Foot_Left.updateDefaultPose();
        Foot_Right.updateDefaultPose();
        Neck_1.updateDefaultPose();
        Neck_2.updateDefaultPose();
        Neck_3.updateDefaultPose();
        Neck_4.updateDefaultPose();
        Neck_5.updateDefaultPose();
        HeadJoint.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        float scale = ((EntityGallimimus) entity).swallowScale;
        GL11.glScalef(scale, scale, scale);
        Left_Thigh.render(f5);
        Right_Thigh.render(f5);
        Body_1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void resetPose() {
        Left_Upper_Foot.resetToDefaultPose();
        Right_Upper_Foot.resetToDefaultPose();
        Left_Calf_1.resetToDefaultPose();
        Right_Calf_1.resetToDefaultPose();
        Left_Thigh.resetToDefaultPose();
        Right_Thigh.resetToDefaultPose();
        Body_1.resetToDefaultPose();
        Body_2.resetToDefaultPose();
        Head.resetToDefaultPose();
        Upper_Jaw.resetToDefaultPose();
        Lower_Jaw.resetToDefaultPose();
        Tail_1.resetToDefaultPose();
        Tail_2.resetToDefaultPose();
        Tail_3.resetToDefaultPose();
        Tail_4.resetToDefaultPose();
        Tail_5.resetToDefaultPose();
        Upper_Arm_Right.resetToDefaultPose();
        Upper_Arm_Left.resetToDefaultPose();
        Lower_Arm_Left.resetToDefaultPose();
        Lower_Arm_Right.resetToDefaultPose();
        Hand_Left.resetToDefaultPose();
        Hand_Right.resetToDefaultPose();
        Hand_Left_Claw_Left.resetToDefaultPose();
        Hand_Left_Claw_Right.resetToDefaultPose();
        Hand_Left_Claw_Middle.resetToDefaultPose();
        Hand_Right_Claw_Right.resetToDefaultPose();
        Hand_Right_Claw_Left.resetToDefaultPose();
        Hand_Right_Claw_Middle.resetToDefaultPose();
        Foot_Left.resetToDefaultPose();
        Foot_Right.resetToDefaultPose();
        Neck_1.resetToDefaultPose();
        Neck_2.resetToDefaultPose();
        Neck_3.resetToDefaultPose();
        Neck_4.resetToDefaultPose();
        Neck_5.resetToDefaultPose();
        HeadJoint.resetToDefaultPose();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityGallimimus gallimimus) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
        this.resetPose();

        /*
         * f = gallimimus.frame; f1 = 1F;
         */

        float scaleFactor = 0.9F;
        float height = 2.5F * f1;
        float legDelay = -0.1F;

        Body_1.rotationPointY -= 2;
        Left_Thigh.rotationPointY -= 2;
        Right_Thigh.rotationPointY -= 2;

        if (gallimimus.ridingEntity == null) {
            bob(Body_1, 1F * scaleFactor, height, false, f, f1);
            bob(Left_Thigh, 1F * scaleFactor, height, false, f, f1);
            bob(Right_Thigh, 1F * scaleFactor, height, false, f, f1);
            Body_1.rotationPointX += -f1 * height * Math.cos(f * 0.5 * scaleFactor);
            Left_Thigh.rotationPointX += -f1 * height * Math.cos(f * 0.5 * scaleFactor);
            Right_Thigh.rotationPointX += -f1 * height * Math.cos(f * 0.5 * scaleFactor);

            Neck_1.rotateAngleZ += f1 * 0.2 * height * Math.cos(f * 0.5 * scaleFactor);
            Neck_2.rotateAngleY += f1 * 0.2 * height * Math.cos(f * 0.5 * scaleFactor);

            walk(Left_Thigh, 0.5F * scaleFactor, 0.8F, false, 0F - legDelay, 0.2F, f, f1);
            walk(Left_Calf_1, 0.5F * scaleFactor, 0.7F, true, 2F - legDelay, 0F, f, f1);
            walk(Left_Upper_Foot, 0.5F * scaleFactor, 0.5F, false, 3F - legDelay, 0F, f, f1);
            walk(Foot_Left, 0.5F * scaleFactor, 0.5F, true, 1.5F - legDelay, 1F, f, f1);

            walk(Right_Thigh, 0.5F * scaleFactor, 0.8F, true, 0F - legDelay, 0.2F, f, f1);
            walk(Right_Calf_1, 0.5F * scaleFactor, 0.7F, false, 2F - legDelay, 0F, f, f1);
            walk(Right_Upper_Foot, 0.5F * scaleFactor, 0.5F, true, 3F - legDelay, 0F, f, f1);
            walk(Foot_Right, 0.5F * scaleFactor, 0.5F, false, 1.5F - legDelay, 1F, f, f1);

            walk(Upper_Arm_Right, 1 * scaleFactor, 0.3F, true, 0.3F, -0.3F, f, f1);
            walk(Upper_Arm_Left, 1 * scaleFactor, 0.3F, true, 0.3F, -0.3F, f, f1);
            walk(Lower_Arm_Right, 1 * scaleFactor, 0.3F, true, 0.6F, -0.7F, f, f1);
            walk(Lower_Arm_Left, 1 * scaleFactor, 0.3F, true, 0.6F, -0.7F, f, f1);
            walk(Hand_Right, 1 * scaleFactor, 0.3F, true, 0.9F, 1F, f, f1);
            walk(Hand_Left, 1 * scaleFactor, 0.3F, true, 0.9F, 1F, f, f1);

            walk(Neck_1, scaleFactor, 0.3F, true, 1.5F, -1.5F, f, f1);
            walk(Neck_2, scaleFactor, 0.1F, false, 1.5F, 0.7F, f, f1);
            walk(Neck_3, scaleFactor, 0.1F, false, 1.5F, 0.5F, f, f1);
            walk(Neck_4, scaleFactor, 0.1F, false, 1.5F, 0.3F, f, f1);

            chainWave(TailParts, 1 * scaleFactor, 0.1F, 1, f, f1);
            chainSwing(TailParts, 0.5F * scaleFactor, 0.1F, 2, f, f1);
        }

        float sittingProgress = gallimimus.sittingProgress.getAnimationProgressSin();

        if (sittingProgress > 0.0F) {
            // Sitting Pose
            float sittingProgressTemporary = gallimimus.sittingProgress.getAnimationProgressTemporaryFS();

            this.faceTarget(f3, f4, 4.0F, Neck_1, Neck_2);
            this.faceTarget(f3, f4, 3.5F, Neck_3, Neck_4);
            this.faceTarget(f3, f4, 6.0F, Neck_5);
            this.faceTarget(f3, f4, 3.0F, Head);

            this.Body_1.rotationPointY += 15.0F * sittingProgress;
            this.Right_Thigh.rotationPointY += 15.0F * sittingProgress;
            this.Left_Thigh.rotationPointY += 15.0F * sittingProgress;
            this.Right_Thigh.rotationPointZ += 0.6F * sittingProgress;
            this.Left_Thigh.rotationPointZ += 0.6F * sittingProgress;

            if (sittingProgressTemporary > 0.001F) {
                this.Body_2.rotateAngleX += 0.25F * sittingProgressTemporary;
                this.Neck_1.rotateAngleX += 0.4F * sittingProgressTemporary;
                this.Neck_2.rotateAngleX += 0.2F * sittingProgressTemporary;
                this.Neck_3.rotateAngleX += 0.2F * sittingProgressTemporary;
                this.Neck_4.rotateAngleX -= 0.2F * sittingProgressTemporary;
                this.Neck_5.rotateAngleX -= 0.2F * sittingProgressTemporary;
                this.Head.rotateAngleX -= 0.2F * sittingProgressTemporary;
                this.Upper_Arm_Right.rotateAngleX += 0.5F * sittingProgressTemporary;
                this.Upper_Arm_Left.rotateAngleX += 0.5F * sittingProgressTemporary;

                if (gallimimus.isSitting()) {
                    this.Tail_1.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.Tail_2.rotateAngleX += 0.15F * sittingProgressTemporary;
                    this.Tail_3.rotateAngleX += 0.2F * sittingProgressTemporary;
                    this.Tail_4.rotateAngleX += 0.15F * sittingProgressTemporary;
                    this.Tail_5.rotateAngleX += 0.1F * sittingProgressTemporary;
                } else {
                    this.Tail_1.rotateAngleX -= 0.1F * sittingProgressTemporary;
                    this.Tail_2.rotateAngleX -= 0.15F * sittingProgressTemporary;
                    this.Tail_3.rotateAngleX -= 0.2F * sittingProgressTemporary;
                    this.Tail_4.rotateAngleX -= 0.15F * sittingProgressTemporary;
                    this.Tail_5.rotateAngleX -= 0.1F * sittingProgressTemporary;
                }
            }

            this.Upper_Arm_Right.rotateAngleX -= 0.8F * sittingProgress;
            this.Upper_Arm_Left.rotateAngleX -= 0.8F * sittingProgress;

            this.Right_Thigh.rotateAngleX -= 1.2F * sittingProgress;
            this.Left_Thigh.rotateAngleX -= 1.2F * sittingProgress;

            this.Right_Calf_1.rotationPointZ -= 0.65F * sittingProgress;
            this.Left_Calf_1.rotationPointZ -= 0.65F * sittingProgress;
            this.Right_Calf_1.rotationPointY += 1.5F * sittingProgress;
            this.Left_Calf_1.rotationPointY += 1.5F * sittingProgress;
            this.Right_Calf_1.rotateAngleX += 1.2F * sittingProgress;
            this.Left_Calf_1.rotateAngleX += 1.2F * sittingProgress;

            this.Right_Upper_Foot.rotationPointZ -= 0.5F * sittingProgress;
            this.Left_Upper_Foot.rotationPointZ -= 0.5F * sittingProgress;
            this.Right_Upper_Foot.rotateAngleX -= 1.0F * sittingProgress;
            this.Left_Upper_Foot.rotateAngleX -= 1.0F * sittingProgress;

            this.Foot_Right.rotationPointZ -= 0.5F * sittingProgress;
            this.Foot_Left.rotationPointZ -= 0.5F * sittingProgress;
            this.Foot_Right.rotateAngleX += 1.0F * sittingProgress;
            this.Foot_Left.rotateAngleX += 1.0F * sittingProgress;

            chainWave(TailParts, 0.1F, -0.05F, 1, gallimimus.frame, 1F - 0.6F * sittingProgress);
            chainWave(NeckParts, 0.1F, -0.1F, 4, gallimimus.frame, 1F - 0.6F * sittingProgress);
            walk(Body_1, 0.1F, 0.05F, false, 0F, 0F, gallimimus.frame, 1F - 0.7F * sittingProgress);
            chainWave(RightArmParts, 0.1F, -0.15F, 4, gallimimus.frame, 1F - 0.8F * sittingProgress);
            chainWave(LeftArmParts, 0.1F, -0.15F, 4, gallimimus.frame, 1F - 0.8F * sittingProgress);
        } else {
            faceTarget(f3, f5, 1, Head);

            // Idling
            chainWave(TailParts, 0.1F, -0.05F, 1, gallimimus.frame, 1.0F);
            chainWave(NeckParts, 0.1F, -0.1F, 4, gallimimus.frame, 1.0F);
            walk(Body_1, 0.1F, 0.05F, false, 0F, 0F, gallimimus.frame, 1.0F);
            chainWave(RightArmParts, 0.1F, -0.15F, 4, gallimimus.frame, 1.0F);
            chainWave(LeftArmParts, 0.1F, -0.15F, 4, gallimimus.frame, 1.0F);
        }

        gallimimus.tailBuffer.applyChainSwingBuffer(TailParts);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (EntityGallimimus) entity);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.BEING_EATEN.animID()) {
            EntityTyrannosaurus trex = (EntityTyrannosaurus) ((EntityGallimimus) entity).ridingEntity;
            Neck_1.rotateAngleY = 0;
            Neck_2.rotateAngleY = 0;
            Neck_3.rotateAngleY = 0;
            Neck_4.rotateAngleY = 0;
            Neck_5.rotateAngleY = 0;
            Head.rotateAngleY = 0;
            chainWave(NeckParts, 0.6F, -0.25F * (trex.shakePrey.getAnimationProgressSinSqrt() + 0.02F), 2, trex.frame, 1F);
            chainWave(TailParts, 0.6F, -0.3F * trex.shakePrey.getAnimationProgressSinSqrt(), 2, trex.frame, 1F);
            chainWave(LeftArmParts, 0.6F, -0.3F * trex.shakePrey.getAnimationProgressSinSqrt(), 2, trex.frame, 1F);
            chainWave(RightArmParts, 0.6F, -0.3F * trex.shakePrey.getAnimationProgressSinSqrt(), 2, trex.frame, 1F);
            chainWave(LeftLegParts, 0.6F, -0.4F * trex.shakePrey.getAnimationProgressSinSqrt(), 1, trex.frame, 1F);
            chainWave(RightLegParts, 0.6F, -0.4F * trex.shakePrey.getAnimationProgressSinSqrt(), 1, trex.frame, 1F);
            animator.setAnimation(JurassiCraftAnimationIDs.BEING_EATEN.animID());
            animator.startPhase(0);
            animator.rotate(Tail_1, -0.3F, 0.0F, 0.0F);
            animator.rotate(Tail_2, -0.3F, 0.0F, 0.0F);
            animator.rotate(Tail_3, -0.2F, 0.0F, 0.0F);
            animator.rotate(Tail_4, -0.2F, 0.0F, 0.0F);
            animator.rotate(Tail_5, -0.2F, 0.0F, 0.0F);
            animator.rotate(Body_1, 0.0F, 0.0F, 0.0F);
            animator.rotate(Body_2, 0.5F, 0.0F, 0.0F);
            animator.rotate(Neck_1, 0.8F, 0.0F, 0.0F);
            animator.rotate(Neck_2, 0.5F, 0.0F, 0.0F);
            animator.rotate(Neck_3, 0.5F, 0.0F, 0.0F);
            animator.rotate(Neck_4, 0.4F, 0.0F, 0.0F);
            animator.rotate(Neck_5, -0.3F, 0.0F, 0.0F);
            animator.rotate(HeadJoint, -0.3F, 0.0F, 0.0F);
            animator.rotate(Foot_Left, 0.6F, 0, 0);
            animator.rotate(Foot_Right, 0.6F, 0, 0);
            animator.endPhase();
            animator.setStationaryPhase(45);
        }
    }
}
