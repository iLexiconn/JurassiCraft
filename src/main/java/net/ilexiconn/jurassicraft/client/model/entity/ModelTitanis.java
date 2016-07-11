package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.birds.EntityTitanis;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTitanis extends MowzieModelBase {
    public Animator animator;
    MowzieModelRenderer Beak_1;
    MowzieModelRenderer Front_Beak_Ridge;
    MowzieModelRenderer Jaw;
    MowzieModelRenderer Beak_2;
    MowzieModelRenderer Head;
    MowzieModelRenderer Feather1;
    MowzieModelRenderer Feather2;
    MowzieModelRenderer Feather3;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Neck_2;
    MowzieModelRenderer Chest;
    MowzieModelRenderer Beak_Ridge_Main;
    MowzieModelRenderer Feather_4;
    MowzieModelRenderer Left_Wing_1;
    MowzieModelRenderer Left_Wing_2;
    MowzieModelRenderer Rear;
    MowzieModelRenderer Tail1;
    MowzieModelRenderer Tail2;
    MowzieModelRenderer Tail3;
    MowzieModelRenderer Right_Wing1;
    MowzieModelRenderer Right_Wing2;
    MowzieModelRenderer Tailfeather1;
    MowzieModelRenderer Tailfeather2;
    MowzieModelRenderer Tailfeather3;
    MowzieModelRenderer Left_Thigh;
    MowzieModelRenderer Upper_Left_Leg;
    MowzieModelRenderer Lower_Left_Leg;
    MowzieModelRenderer Left_Foot;
    MowzieModelRenderer Right_Thigh;
    MowzieModelRenderer Upper_right_leg;
    MowzieModelRenderer Lower_Right_leg;
    MowzieModelRenderer Right_foot;
    MowzieModelRenderer HeadJoint;

    public ModelTitanis() {
        this.animator = new Animator(this);
        textureWidth = 128;
        textureHeight = 64;

        Beak_1 = new MowzieModelRenderer(this, 115, 0);
        Beak_1.addBox(-0.7F, -3F, -4F, 2, 3, 4);
        Beak_1.setRotationPoint(0F, -2F, -16F);
        Beak_1.setTextureSize(128, 64);
        Beak_1.mirror = true;
        setRotation(Beak_1, 0F, 0F, 0F);
        Front_Beak_Ridge = new MowzieModelRenderer(this, 110, 0);
        Front_Beak_Ridge.addBox(-0.5F, -3.5F, -4.5F, 1, 4, 1);
        Front_Beak_Ridge.setRotationPoint(0F, -2F, -16F);
        Front_Beak_Ridge.setTextureSize(128, 64);
        Front_Beak_Ridge.mirror = true;
        setRotation(Front_Beak_Ridge, 0F, 0F, 0F);
        Jaw = new MowzieModelRenderer(this, 115, 8);
        Jaw.addBox(-1F, 0F, -4F, 2, 1, 4);
        Jaw.setRotationPoint(0F, -1.8F, -15.5F);
        Jaw.setTextureSize(128, 64);
        Jaw.mirror = true;
        setRotation(Jaw, 0.122173F, 0F, 0F);
        Beak_2 = new MowzieModelRenderer(this, 115, 14);
        Beak_2.addBox(-1.3F, -3F, -4F, 2, 3, 4);
        Beak_2.setRotationPoint(0F, -2F, -16F);
        Beak_2.setTextureSize(128, 64);
        Beak_2.mirror = true;
        setRotation(Beak_2, 0F, 0F, 0F);
        Head = new MowzieModelRenderer(this, 89, 0);
        Head.setRotationPoint(0.0F, -2.7F, -12.0F);
        Head.addBox(-2.0F, -3.0F, -4.0F, 4, 5, 5);
        Head.setTextureSize(128, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Feather1 = new MowzieModelRenderer(this, 108, 6);
        Feather1.addBox(-0.5F, 0F, 0F, 1, 0, 2);
        Feather1.setRotationPoint(1F, -5.7F, -13F);
        Feather1.setTextureSize(128, 64);
        Feather1.mirror = true;
        setRotation(Feather1, 0.5235988F, 0.418879F, 0F);
        Feather2 = new MowzieModelRenderer(this, 108, 6);
        Feather2.addBox(-0.5F, 0F, 0F, 1, 0, 2);
        Feather2.setRotationPoint(-1F, -5.7F, -13F);
        Feather2.setTextureSize(128, 64);
        Feather2.mirror = true;
        setRotation(Feather2, 0.5235988F, -0.418879F, 0F);
        Feather3 = new MowzieModelRenderer(this, 108, 9);
        Feather3.addBox(-0.5F, 0F, 0F, 1, 0, 2);
        Feather3.setRotationPoint(0F, -5.7F, -12F);
        Feather3.setTextureSize(128, 64);
        Feather3.mirror = true;
        setRotation(Feather3, 0.4363323F, 0F, 0F);
        Neck = new MowzieModelRenderer(this, 94, 11);
        Neck.addBox(-1.5F, -8F, -4F, 3, 8, 4);
        Neck.setRotationPoint(0F, 2F, -7.5F);
        Neck.setTextureSize(128, 64);
        Neck.mirror = true;
        setRotation(Neck, 0.4712389F, 0F, 0F);
        Neck_2 = new MowzieModelRenderer(this, 90, 24);
        Neck_2.addBox(-2F, -6F, -4.5F, 4, 7, 5);
        Neck_2.setRotationPoint(0F, 4.6F, -3.9F);
        Neck_2.setTextureSize(128, 64);
        Neck_2.mirror = true;
        setRotation(Neck_2, 0.8726646F, 0F, 0F);
        Chest = new MowzieModelRenderer(this, 61, 0);
        Chest.addBox(-3.5F, 0F, 0F, 7, 8, 7);
        Chest.setRotationPoint(0F, 1.3F, -6.6F);
        Chest.setTextureSize(128, 64);
        Chest.mirror = true;
        setRotation(Chest, 0.0872665F, 0F, 0F);
        Beak_Ridge_Main = new MowzieModelRenderer(this, 117, 22);
        Beak_Ridge_Main.addBox(-0.5F, -3.5F, -4F, 1, 1, 4);
        Beak_Ridge_Main.setRotationPoint(0F, -2F, -16F);
        Beak_Ridge_Main.setTextureSize(128, 64);
        Beak_Ridge_Main.mirror = true;
        setRotation(Beak_Ridge_Main, 0F, 0F, 0F);
        Feather_4 = new MowzieModelRenderer(this, 108, 9);
        Feather_4.addBox(-0.5F, 0F, -0.5F, 1, 0, 2);
        Feather_4.setRotationPoint(0F, -5.7F, -13.5F);
        Feather_4.setTextureSize(128, 64);
        Feather_4.mirror = true;
        setRotation(Feather_4, 0.6981317F, 0F, 0F);
        Left_Wing_1 = new MowzieModelRenderer(this, 116, 28);
        Left_Wing_1.addBox(0F, 0F, 0F, 1, 4, 5);
        Left_Wing_1.setRotationPoint(3.3F, 3.5F, -4F);
        Left_Wing_1.setTextureSize(128, 64);
        Left_Wing_1.mirror = true;
        setRotation(Left_Wing_1, -0.0523599F, 0.1396263F, 0F);
        Left_Wing_2 = new MowzieModelRenderer(this, 109, 12);
        Left_Wing_2.addBox(0F, 0F, 5F, 1, 3, 2);
        Left_Wing_2.setRotationPoint(3.3F, 3.5F, -4F);
        Left_Wing_2.setTextureSize(128, 64);
        Left_Wing_2.mirror = true;
        setRotation(Left_Wing_2, -0.0523599F, 0.1396263F, 0F);
        Rear = new MowzieModelRenderer(this, 61, 16);
        Rear.addBox(-4F, -7.5F, -1F, 8, 9, 6);
        Rear.setRotationPoint(0F, 8F, 0.3F);
        Rear.setTextureSize(128, 64);
        Rear.mirror = true;
        setRotation(Rear, -0.1396263F, 0F, 0F);
        Tail1 = new MowzieModelRenderer(this, 90, 37);
        Tail1.addBox(-3F, 0F, 0F, 6, 7, 3);
        Tail1.setRotationPoint(0F, 2F, 5F);
        Tail1.setTextureSize(128, 64);
        Tail1.mirror = true;
        setRotation(Tail1, -0.1047198F, 0F, 0F);
        Tail2 = new MowzieModelRenderer(this, 114, 38);
        Tail2.addBox(-2F, 0F, 0F, 4, 5, 3);
        Tail2.setRotationPoint(0F, 3.1F, 6.5F);
        Tail2.setTextureSize(128, 64);
        Tail2.mirror = true;
        setRotation(Tail2, -0.0698132F, 0F, 0F);
        Tail3 = new MowzieModelRenderer(this, 116, 47);
        Tail3.addBox(-1.5F, 0F, 0F, 3, 3, 3);
        Tail3.setRotationPoint(0F, 4.2F, 8.5F);
        Tail3.setTextureSize(128, 64);
        Tail3.mirror = true;
        setRotation(Tail3, -0.0349066F, 0F, 0F);
        Right_Wing1 = new MowzieModelRenderer(this, 116, 54);
        Right_Wing1.addBox(-1F, 0F, 0F, 1, 4, 5);
        Right_Wing1.setRotationPoint(-3.3F, 3.5F, -4F);
        Right_Wing1.setTextureSize(128, 64);
        Right_Wing1.mirror = true;
        setRotation(Right_Wing1, -0.0523599F, -0.1396263F, 0F);
        Right_Wing2 = new MowzieModelRenderer(this, 109, 18);
        Right_Wing2.addBox(-1F, 0F, 5F, 1, 3, 2);
        Right_Wing2.setRotationPoint(-3.3F, 3.5F, -4F);
        Right_Wing2.setTextureSize(128, 64);
        Right_Wing2.mirror = true;
        setRotation(Right_Wing2, -0.0523599F, -0.1396263F, 0F);
        Tailfeather1 = new MowzieModelRenderer(this, 90, 48);
        Tailfeather1.addBox(-1.5F, 0F, 0F, 3, 0, 6);
        Tailfeather1.setRotationPoint(0F, 4.2F, 8.5F);
        Tailfeather1.setTextureSize(128, 64);
        Tailfeather1.mirror = true;
        setRotation(Tailfeather1, -0.0349066F, 0F, 0F);
        Tailfeather2 = new MowzieModelRenderer(this, 105, 55);
        Tailfeather2.addBox(0F, 0F, 0F, 0, 2, 5);
        Tailfeather2.setRotationPoint(1.5F, 4.2F, 8.5F);
        Tailfeather2.setTextureSize(128, 64);
        Tailfeather2.mirror = true;
        setRotation(Tailfeather2, -0.0349066F, 0F, 0F);
        Tailfeather3 = new MowzieModelRenderer(this, 94, 55);
        Tailfeather3.addBox(0F, 0F, 0F, 0, 2, 5);
        Tailfeather3.setRotationPoint(-1.5F, 4.2F, 8.5F);
        Tailfeather3.setTextureSize(128, 64);
        Tailfeather3.mirror = true;
        setRotation(Tailfeather3, -0.0349066F, 0F, 0F);
        Left_Thigh = new MowzieModelRenderer(this, 75, 32);
        Left_Thigh.addBox(-2F, 0F, 0F, 3, 5, 4);
        Left_Thigh.setRotationPoint(4F, 8F, 0F);
        Left_Thigh.setTextureSize(128, 64);
        Left_Thigh.mirror = true;
        setRotation(Left_Thigh, 0.0523599F, 0F, 0F);
        Upper_Left_Leg = new MowzieModelRenderer(this, 64, 32);
        Upper_Left_Leg.addBox(-1F, 0F, 0F, 2, 5, 3);
        Upper_Left_Leg.setRotationPoint(3.5F, 13F, 0.7F);
        Upper_Left_Leg.setTextureSize(128, 64);
        Upper_Left_Leg.mirror = true;
        setRotation(Upper_Left_Leg, 0.122173F, 0F, 0F);
        Lower_Left_Leg = new MowzieModelRenderer(this, 81, 42);
        Lower_Left_Leg.addBox(-1F, 0F, -2F, 2, 7, 2);
        Lower_Left_Leg.setRotationPoint(3.5F, 17F, 4F);
        Lower_Left_Leg.setTextureSize(128, 64);
        Lower_Left_Leg.mirror = true;
        setRotation(Lower_Left_Leg, -0.2792527F, 0F, 0F);
        Left_Foot = new MowzieModelRenderer(this, 64, 42);
        Left_Foot.addBox(-1.5F, 0F, -4F, 3, 2, 5);
        Left_Foot.setRotationPoint(3.5F, 22.5F, 1.5F);
        Left_Foot.setTextureSize(128, 64);
        Left_Foot.mirror = true;
        setRotation(Left_Foot, 0F, 0F, 0F);
        Right_Thigh = new MowzieModelRenderer(this, 75, 52);
        Right_Thigh.addBox(-1F, 0F, 0F, 3, 5, 4);
        Right_Thigh.setRotationPoint(-4F, 8F, 0F);
        Right_Thigh.setTextureSize(128, 64);
        Right_Thigh.mirror = true;
        setRotation(Right_Thigh, 0.0523599F, 0F, 0F);
        Upper_right_leg = new MowzieModelRenderer(this, 53, 39);
        Upper_right_leg.addBox(-1F, 0F, 0F, 2, 5, 3);
        Upper_right_leg.setRotationPoint(-3.5F, 13F, 0.7F);
        Upper_right_leg.setTextureSize(128, 64);
        Upper_right_leg.mirror = true;
        setRotation(Upper_right_leg, 0.122173F, 0F, 0F);
        Lower_Right_leg = new MowzieModelRenderer(this, 55, 48);
        Lower_Right_leg.addBox(-1F, 0F, -2F, 2, 7, 2);
        Lower_Right_leg.setRotationPoint(-3.5F, 17F, 4F);
        Lower_Right_leg.setTextureSize(128, 64);
        Lower_Right_leg.mirror = true;
        setRotation(Lower_Right_leg, -0.2792527F, 0F, 0F);
        Right_foot = new MowzieModelRenderer(this, 58, 57);
        Right_foot.addBox(-1.5F, 0F, -4F, 3, 2, 5);
        Right_foot.setRotationPoint(-3.523F, 22.5F, 1.5F);
        Right_foot.setTextureSize(128, 64);
        Right_foot.mirror = true;
        setRotation(Right_foot, 0F, 0F, 0F);
        HeadJoint = new MowzieModelRenderer(this, 0, 0);
        HeadJoint.addBox(-2F, 0F, -5F, 4, 5, 5);
        HeadJoint.setRotationPoint(0.0F, -2.7F, -12.0F);
        HeadJoint.setTextureSize(128, 64);
        HeadJoint.mirror = true;
        setRotation(HeadJoint, 0F, 0F, 0F);

        addChildTo(Beak_1, Head);
        addChildTo(Beak_2, Head);
        addChildTo(Front_Beak_Ridge, Head);
        addChildTo(Beak_Ridge_Main, Head);
        addChildTo(Jaw, Head);
        addChildTo(Feather1, Head);
        addChildTo(Feather2, Head);
        addChildTo(Feather3, Head);
        addChildTo(Feather_4, Head);

        addChildTo(Head, HeadJoint);
        addChildTo(HeadJoint, Neck);
        addChildTo(Neck, Neck_2);
        addChildTo(Neck_2, Chest);

        addChildTo(Right_Wing2, Right_Wing1);
        addChildTo(Left_Wing_2, Left_Wing_1);
        addChildTo(Right_Wing1, Chest);
        addChildTo(Left_Wing_1, Chest);

        addChildTo(Chest, Rear);

        addChildTo(Tailfeather2, Tail3);
        addChildTo(Tailfeather3, Tail3);
        addChildTo(Tailfeather1, Tail3);
        addChildTo(Tail3, Tail2);
        addChildTo(Tail2, Tail1);
        addChildTo(Tail1, Rear);

        addChildTo(Left_Foot, Lower_Left_Leg);
        addChildTo(Lower_Left_Leg, Upper_Left_Leg);
        addChildTo(Upper_Left_Leg, Left_Thigh);
        addChildTo(Right_foot, Lower_Right_leg);
        addChildTo(Lower_Right_leg, Upper_right_leg);
        addChildTo(Upper_right_leg, Right_Thigh);

        // Corrections
        Chest.setRotationPoint(0, -6, -7);
        Neck.setRotationPoint(0, -4, -0.5F);
        HeadJoint.rotationPointY -= 13;
        HeadJoint.rotationPointZ -= 4;
        Head.setRotationPoint(0, 0, 0);
        Right_Wing2.setRotationPoint(0, 0, 0);
        Left_Wing_2.setRotationPoint(0, 0, 0);
        Tail1.setRotationPoint(0, -7, 3);
        Tailfeather1.setRotationPoint(0, 0, 0);
        Tailfeather2.setRotationPoint(1.5F, 0, 0);
        Tailfeather3.setRotationPoint(-1.5F, 0, 0);
        Jaw.rotateAngleX -= 0.15;
        Feather1.rotationPointY -= 6;
        Feather2.rotationPointY -= 6;
        Feather3.rotationPointY -= 6;
        Feather_4.rotationPointY -= 6;

        Beak_1.updateDefaultPose();
        Front_Beak_Ridge.updateDefaultPose();
        Jaw.updateDefaultPose();
        Beak_2.updateDefaultPose();
        Head.updateDefaultPose();
        Feather1.updateDefaultPose();
        Feather2.updateDefaultPose();
        Feather3.updateDefaultPose();
        Neck.updateDefaultPose();
        Neck_2.updateDefaultPose();
        Chest.updateDefaultPose();
        Beak_Ridge_Main.updateDefaultPose();
        Feather_4.updateDefaultPose();
        Left_Wing_1.updateDefaultPose();
        Left_Wing_2.updateDefaultPose();
        Rear.updateDefaultPose();
        Tail1.updateDefaultPose();
        Tail2.updateDefaultPose();
        Tail3.updateDefaultPose();
        Right_Wing1.updateDefaultPose();
        Right_Wing2.updateDefaultPose();
        Tailfeather1.updateDefaultPose();
        Tailfeather2.updateDefaultPose();
        Tailfeather3.updateDefaultPose();
        Left_Thigh.updateDefaultPose();
        Upper_Left_Leg.updateDefaultPose();
        Lower_Left_Leg.updateDefaultPose();
        Left_Foot.updateDefaultPose();
        Right_Thigh.updateDefaultPose();
        Upper_right_leg.updateDefaultPose();
        Lower_Right_leg.updateDefaultPose();
        Right_foot.updateDefaultPose();
        HeadJoint.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        /*
         * Beak_1.render(f5); Front_Beak_Ridge.render(f5); Jaw.render(f5); Beak_2.render(f5); Head.render(f5); Feather1.render(f5); Feather2.render(f5); Feather3.render(f5); Neck.render(f5); Neck_2.render(f5); Chest.render(f5); Beak_Ridge_Main.render(f5); Feather_4.render(f5); Left_Wing_1.render(f5); Left_Wing_2.render(f5);
         */
        Rear.render(f5);
        /*
         * Tail1.render(f5); Tail2.render(f5); Tail3.render(f5); Right_Wing1.render(f5); Right_Wing2.render(f5); Tailfeather1.render(f5); Tailfeather2.render(f5); Tailfeather3.render(f5);
         */
        Left_Thigh.render(f5);
        /*
         * Upper_Left_Leg.render(f5); Lower_Left_Leg.render(f5); Left_Foot.render(f5);
         */
        Right_Thigh.render(f5);
        /*
         * Upper_right_leg.render(f5); Lower_Right_leg.render(f5); Right_foot.render(f5);
         */
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void resetPose() {
        Beak_1.resetToDefaultPose();
        Front_Beak_Ridge.resetToDefaultPose();
        Jaw.resetToDefaultPose();
        Beak_2.resetToDefaultPose();
        Head.resetToDefaultPose();
        Feather1.resetToDefaultPose();
        Feather2.resetToDefaultPose();
        Feather3.resetToDefaultPose();
        Neck.resetToDefaultPose();
        Neck_2.resetToDefaultPose();
        Chest.resetToDefaultPose();
        Beak_Ridge_Main.resetToDefaultPose();
        Feather_4.resetToDefaultPose();
        Left_Wing_1.resetToDefaultPose();
        Left_Wing_2.resetToDefaultPose();
        Rear.resetToDefaultPose();
        Tail1.resetToDefaultPose();
        Tail2.resetToDefaultPose();
        Tail3.resetToDefaultPose();
        Right_Wing1.resetToDefaultPose();
        Right_Wing2.resetToDefaultPose();
        Tailfeather1.resetToDefaultPose();
        Tailfeather2.resetToDefaultPose();
        Tailfeather3.resetToDefaultPose();
        Left_Thigh.resetToDefaultPose();
        Upper_Left_Leg.resetToDefaultPose();
        Lower_Left_Leg.resetToDefaultPose();
        Left_Foot.resetToDefaultPose();
        Right_Thigh.resetToDefaultPose();
        Upper_right_leg.resetToDefaultPose();
        Lower_Right_leg.resetToDefaultPose();
        Right_foot.resetToDefaultPose();
        HeadJoint.resetToDefaultPose();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        resetPose();
        EntityTitanis titanis = (EntityTitanis) entity;
        /*
         * f = titanis.frame; f1 = 1F;
         */
        float scaleFactor = 0.9F;
        float height = 2F * f1;

        bob(Rear, 1F * scaleFactor, height, false, f, f1);
        bob(Left_Thigh, 1F * scaleFactor, height, false, f, f1);
        bob(Right_Thigh, 1F * scaleFactor, height, false, f, f1);
        Rear.rotationPointY += f1;
        Left_Thigh.rotationPointY += 2 * f1;
        Right_Thigh.rotationPointY += 2 * f1;

        walk(Rear, 1F * scaleFactor, 0.1F, true, 0F, 0.07F, f, f1);
        walk(Neck_2, 1F * scaleFactor, 0.15F, false, 1F, 0.4F, f, f1);
        walk(Neck, 1F * scaleFactor, 0.15F, false, 1F, 0.3F, f, f1);
        walk(Head, 1F * scaleFactor, 0.3F, true, 1F, -0.7F, f, f1);

        walk(Left_Thigh, 0.5F * scaleFactor, 0.8F, false, 0F, 0.5F, f, f1);
        walk(Lower_Left_Leg, 0.5F * scaleFactor, 0.5F, false, 0F, -0.5F, f, f1);
        walk(Left_Foot, 0.5F * scaleFactor, 1.5F, true, 0.5F, 1F, f, f1);

        walk(Right_Thigh, 0.5F * scaleFactor, 0.8F, true, 0F, 0.5F, f, f1);
        walk(Lower_Right_leg, 0.5F * scaleFactor, 0.5F, true, 0F, -0.5F, f, f1);
        walk(Right_foot, 0.5F * scaleFactor, 1.5F, false, 0.5F, 1F, f, f1);

        Right_Wing1.rotateAngleY -= 0.7 * f1;
        Left_Wing_1.rotateAngleY += 0.7 * f1;

        // Idling
        walk(Neck, 0.1F, 0.03F, false, -0.5F, 0F, titanis.frame, 1F);
        walk(Neck_2, 0.1F, 0.03F, false, -0.5F, 0F, titanis.frame, 1F);
        walk(Head, 0.1F, 0.06F, true, 0F, 0F, titanis.frame, 1F);
        walk(Rear, 0.1F, 0.05F, false, 0F, 0F, titanis.frame, 1F);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityTitanis) entity);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.BITE.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.BITE.animID());
            this.animator.startPhase(3);
            this.animator.rotate(Neck, -0.2F, 0, 0);
            this.animator.rotate(Neck_2, -0.2F, 0, 0);
            this.animator.rotate(Head, 0.4F, 0, 0);
            this.animator.rotate(Jaw, 1F, 0, 0);
            this.animator.endPhase();
            this.animator.startPhase(2);
            this.animator.rotate(Neck, 0.3F, 0, 0);
            this.animator.rotate(Neck_2, 0.3F, 0, 0);
            this.animator.rotate(Head, -0.6F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.resetPhase(4);
        }
    }
}