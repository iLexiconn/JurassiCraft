package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityDilophosaurus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDilophosaurus extends MowzieModelBase {
    public Animator animator;
    public MowzieModelRenderer body3;
    public MowzieModelRenderer thigh2;
    public MowzieModelRenderer thigh1;
    public MowzieModelRenderer body2;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer body1;
    public MowzieModelRenderer arm2;
    public MowzieModelRenderer arm1;
    public MowzieModelRenderer neck1;
    public MowzieModelRenderer neck2;
    public MowzieModelRenderer neck3;
    public MowzieModelRenderer neck4;
    public MowzieModelRenderer frill1;
    public MowzieModelRenderer frill2;
    public MowzieModelRenderer frill3;
    public MowzieModelRenderer frill4;
    public MowzieModelRenderer head;
    public MowzieModelRenderer crest1;
    public MowzieModelRenderer crest2;
    public MowzieModelRenderer upperjaw;
    public MowzieModelRenderer down_jaw;
    public MowzieModelRenderer Teeth;
    public MowzieModelRenderer forearm2;
    public MowzieModelRenderer hand2;
    public MowzieModelRenderer claw6;
    public MowzieModelRenderer claw5;
    public MowzieModelRenderer claw4;
    public MowzieModelRenderer forearm1;
    public MowzieModelRenderer hand1;
    public MowzieModelRenderer claw3;
    public MowzieModelRenderer claw2;
    public MowzieModelRenderer claw1;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer tail4;
    public MowzieModelRenderer tail5;
    public MowzieModelRenderer leg2;
    public MowzieModelRenderer upperfoot2;
    public MowzieModelRenderer foot2;
    public MowzieModelRenderer leg1;
    public MowzieModelRenderer upperfoot1;
    public MowzieModelRenderer foot1;
    public MowzieModelRenderer[] bodyParts;
    public MowzieModelRenderer[] tailParts;
    public MowzieModelRenderer[] rightArmParts;
    public MowzieModelRenderer[] leftArmParts;

    public ModelDilophosaurus() {
        this.animator = new Animator(this);

        this.textureWidth = 128;
        this.textureHeight = 64;
        this.crest2 = new MowzieModelRenderer(this, 41, -6);
        this.crest2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.crest2.addBox(1.5F, -3.5F, -7.0F, 0, 4, 7, 0.0F);
        this.setRotation(crest2, 0.045553093477052F, 0.091106186954104F, 0.136659280431156F);
        this.forearm2 = new MowzieModelRenderer(this, 57, 0);
        this.forearm2.setRotationPoint(0.0F, 6.0F, 1.0F);
        this.forearm2.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotation(forearm2, -1.268679833274678F, 0.0F, 0.0F);
        this.claw4 = new MowzieModelRenderer(this, 0, 0);
        this.claw4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw4.addBox(-0.5F, 1.0F, -1.2F, 1, 2, 1, 0.0F);
        this.setRotation(claw4, 0.26529004630313807F, 0.04258603374866164F, 0.40194932673429407F);
        this.neck4 = new MowzieModelRenderer(this, 24, 38);
        this.neck4.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.neck4.addBox(-2.0F, 0.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotation(neck4, 0.41678462537624583F, 0.0F, 0.0F);
        this.upperfoot2 = new MowzieModelRenderer(this, 15, 0);
        this.upperfoot2.setRotationPoint(0.0F, 7.0F, 2.5F);
        this.upperfoot2.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
        this.setRotation(upperfoot2, -0.9599310885968813F, 0.0F, 0.0F);
        this.hand1 = new MowzieModelRenderer(this, 0, 26);
        this.hand1.setRotationPoint(0.0F, 3.5F, -1.5F);
        this.hand1.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotation(hand1, 1.0522590060273813F, 0.08779006137531478F, 0.0F);
        this.frill4 = new MowzieModelRenderer(this, 88, 1);
        this.frill4.mirror = true;
        this.frill4.setRotationPoint(0.0F, 6.1F, -0.5F);
        this.frill4.addBox(0.0F, -6.1F, 0.0F, 10, 11, 0, 0.0F);
        this.setRotation(frill4, -3.141592653589793F, 0.0F, 0.0F);
        this.leg1 = new MowzieModelRenderer(this, 0, 13);
        this.leg1.mirror = true;
        this.leg1.setRotationPoint(-0.5F, 2.0F, -8.0F);
        this.leg1.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotation(leg1, -0.3665191429188092F, 0.0F, 0.0F);
        this.Teeth = new MowzieModelRenderer(this, 24, 10);
        this.Teeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Teeth.addBox(-2.0F, 3.0F, -8.0F, 4, 1, 4, 0.0F);
        this.frill1 = new MowzieModelRenderer(this, 67, 1);
        this.frill1.setRotationPoint(0.0F, -0.5F, -0.5F);
        this.frill1.addBox(-10.0F, -6.0F, 0.0F, 10, 8, 0, 0.0F);
        this.claw6 = new MowzieModelRenderer(this, 0, 0);
        this.claw6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw6.addBox(-0.5F, 1.0F, -1.3F, 1, 2, 1, 0.0F);
        this.setRotation(claw6, 0.2668608426299329F, -0.045553093477052F, -0.40980330836826856F);
        this.claw2 = new MowzieModelRenderer(this, 0, 0);
        this.claw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw2.addBox(-0.5F, 1.0F, -1.5F, 1, 2, 1, 0.0F);
        this.setRotation(claw2, 0.26616271092913524F, 0.0F, 0.0F);
        this.neck3 = new MowzieModelRenderer(this, 40, 38);
        this.neck3.setRotationPoint(0.0F, 0.0F, -5.5F);
        this.neck3.addBox(-2.0F, 0.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotation(neck3, 0.6311110575211495F, 0.0F, -0.012391837689159737F);
        this.arm1 = new MowzieModelRenderer(this, 15, 9);
        this.arm1.setRotationPoint(-4.4F, 4.0F, -5.5F);
        this.arm1.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotation(arm1, 0.36425021489121656F, 0.0F, 0.0F);
        this.leg2 = new MowzieModelRenderer(this, 0, 13);
        this.leg2.setRotationPoint(0.5F, 2.0F, -8.0F);
        this.leg2.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotation(leg2, -0.3665191429188092F, 0.0F, 0.0F);
        this.arm2 = new MowzieModelRenderer(this, 15, 9);
        this.arm2.setRotationPoint(4.4F, 4.0F, -5.5F);
        this.arm2.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotation(arm2, 0.36425021489121656F, 0.0F, 0.0F);
        this.down_jaw = new MowzieModelRenderer(this, 11, 21);
        this.down_jaw.setRotationPoint(0.0F, 3.0F, -3.6F);
        this.down_jaw.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 64, 17);
        this.tail1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.tail1.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 8, 0.0F);
        this.setRotation(tail1, 0.027925268031909273F, 0.0F, 0.0F);
        this.body2 = new MowzieModelRenderer(this, 19, 19);
        this.body2.setRotationPoint(0.0F, -1.0F, -6.9F);
        this.body2.addBox(-3.5F, 0.0F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotation(body2, -0.045553093477052F, 0.0F, 0.0F);
        this.body3 = new MowzieModelRenderer(this, 87, 46);
        this.body3.setRotationPoint(0.0F, 7.5F, 1.0F);
        this.body3.addBox(-4.0F, -1.5F, -7.9F, 8, 8, 10, 0.0F);
        this.setRotation(body3, -0.091106186954104F, 0.0F, 0.0F);
        this.claw1 = new MowzieModelRenderer(this, 0, 0);
        this.claw1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw1.addBox(-0.5F, 1.0F, -1.2F, 1, 2, 1, 0.0F);
        this.setRotation(claw1, 0.26616271092913524F, 0.045727626402251434F, 0.40980330836826856F);
        this.thigh2 = new MowzieModelRenderer(this, 48, 23);
        this.thigh2.setRotationPoint(4.0F, 7.0F, -0.5F);
        this.thigh2.addBox(-1.5F, 0.0F, -8.0F, 4, 5, 8, 0.0F);
        this.setRotation(thigh2, 0.8203047484373349F, 0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 92, 33);
        this.tail3.setRotationPoint(0.0F, 0.4F, 8.1F);
        this.tail3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotation(tail3, -0.031415926535897934F, 0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 95, 16);
        this.tail2.setRotationPoint(0.0F, 0.5F, 6.6F);
        this.tail2.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
        this.setRotation(tail2, 0.048869219055841226F, 0.0F, 0.0F);
        this.claw3 = new MowzieModelRenderer(this, 0, 0);
        this.claw3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw3.addBox(-0.5F, 1.0F, -1.2F, 1, 2, 1, 0.0F);
        this.setRotation(claw3, 0.2659881780039358F, 0.04258603374866164F, -0.40264745843509187F);
        this.forearm1 = new MowzieModelRenderer(this, 57, 0);
        this.forearm1.setRotationPoint(0.0F, 6.0F, 1.0F);
        this.forearm1.addBox(-1.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotation(forearm1, -1.268679833274678F, 0.0F, 0.0F);
        this.hand2 = new MowzieModelRenderer(this, 0, 26);
        this.hand2.setRotationPoint(0.0F, 3.5F, -1.5F);
        this.hand2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotation(hand2, 1.0471975511965976F, -0.0879645943005142F, 0.0F);
        this.thigh1 = new MowzieModelRenderer(this, 48, 23);
        this.thigh1.mirror = true;
        this.thigh1.setRotationPoint(-4.0F, 7.0F, -0.5F);
        this.thigh1.addBox(-2.5F, 0.0F, -8.0F, 4, 5, 8, 0.0F);
        this.setRotation(thigh1, 0.8203047484373349F, 0.0F, 0.0F);
        this.upperjaw = new MowzieModelRenderer(this, 24, 0);
        this.upperjaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperjaw.addBox(-2.0F, 0.0F, -8.0F, 4, 3, 4, 0.0F);
        this.setRotation(upperjaw, 0.0F, 0.0F, 0.009948376736367679F);
        this.tail4 = new MowzieModelRenderer(this, 70, 40);
        this.tail4.setRotationPoint(0.0F, 0.5F, 7.4F);
        this.tail4.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 8, 0.0F);
        this.setRotation(tail4, -0.03490658503988659F, 0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 42, 12);
        this.head.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.head.addBox(-2.5F, 0.0F, -4.0F, 5, 4, 4, 0.0F);
        this.setRotation(head, 0.1616174887346749F, 0.0F, 0.0F);
        this.claw5 = new MowzieModelRenderer(this, 0, 0);
        this.claw5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw5.addBox(-0.5F, 1.0F, -1.5F, 1, 2, 1, 0.0F);
        this.setRotation(claw5, 0.2668608426299329F, 0.0F, 0.0F);
        this.tail5 = new MowzieModelRenderer(this, 55, 37);
        this.tail5.setRotationPoint(0.0F, 0.4F, 7.4F);
        this.tail5.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotation(tail5, -0.022689280275926284F, 0.0F, 0.0F);
        this.neck1 = new MowzieModelRenderer(this, 1, 52);
        this.neck1.setRotationPoint(0.0F, 1.5F, 0.5F);
        this.neck1.addBox(-2.5F, 0.0F, -5.0F, 5, 5, 5, 0.0F);
        this.setRotation(neck1, -0.6457718232379019F, 0.0F, 0.0F);
        this.frill2 = new MowzieModelRenderer(this, 67, 1);
        this.frill2.mirror = true;
        this.frill2.setRotationPoint(0.0F, -0.5F, -0.5F);
        this.frill2.addBox(0.0F, -6.0F, 0.0F, 10, 8, 0, 0.0F);
        this.crest1 = new MowzieModelRenderer(this, 41, -6);
        this.crest1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.crest1.addBox(-1.5F, -3.5F, -7.0F, 0, 4, 7, 0.0F);
        this.setRotation(crest1, 0.045553093477052F, -0.091106186954104F, -0.136659280431156F);
        this.upperfoot1 = new MowzieModelRenderer(this, 15, 0);
        this.upperfoot1.setRotationPoint(0.0F, 7.0F, 2.5F);
        this.upperfoot1.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
        this.setRotation(upperfoot1, -0.9599310885968813F, 0.0F, 0.0F);
        this.frill3 = new MowzieModelRenderer(this, 88, 1);
        this.frill3.setRotationPoint(0.0F, 6.1F, -0.5F);
        this.frill3.addBox(-10.0F, -6.1F, 0.0F, 10, 11, 0, 0.0F);
        this.setRotation(frill3, -3.141592653589793F, 0.0F, 0.0F);
        this.foot1 = new MowzieModelRenderer(this, 0, 3);
        this.foot1.mirror = true;
        this.foot1.setRotationPoint(0.0F, 3.5F, -1.0F);
        this.foot1.addBox(-1.5F, 0.0F, -3.5F, 3, 2, 5, 0.0F);
        this.setRotation(foot1, 0.5235987755982988F, 0.0F, 0.0F);
        this.foot2 = new MowzieModelRenderer(this, 0, 3);
        this.foot2.setRotationPoint(0.0F, 3.5F, -1.0F);
        this.foot2.addBox(-1.5F, 0.0F, -3.5F, 3, 2, 5, 0.0F);
        this.setRotation(foot2, 0.5235987755982988F, 0.0F, 0.0F);
        this.neck2 = new MowzieModelRenderer(this, 29, 47);
        this.neck2.setRotationPoint(0.0F, 0.5F, -3.6F);
        this.neck2.addBox(-2.0F, 0.0F, -6.0F, 4, 4, 6, 0.0F);
        this.setRotation(neck2, -0.05235987755982988F, 0.0F, 0.0F);
        this.body1 = new MowzieModelRenderer(this, 1, 33);
        this.body1.setRotationPoint(0.0F, 0.0F, -4.9F);
        this.body1.addBox(-3.0F, 0.0F, -3.0F, 6, 6, 3, 0.0F);
        this.setRotation(body1, -0.30159289474462014F, 0.0F, 0.0F);
        this.tail3.addChild(this.tail4);
        this.neck1.addChild(this.neck2);
        this.neck2.addChild(this.neck3);
        this.upperjaw.addChild(this.Teeth);
        this.head.addChild(this.crest2);
        this.hand1.addChild(this.claw2);
        this.body2.addChild(this.arm1);
        this.tail4.addChild(this.tail5);
        this.upperfoot2.addChild(this.foot2);
        this.body1.addChild(this.neck1);
        this.arm2.addChild(this.forearm2);
        this.hand1.addChild(this.claw3);
        this.leg1.addChild(this.upperfoot1);
        this.tail1.addChild(this.tail2);
        this.thigh2.addChild(this.leg2);
        this.head.addChild(this.down_jaw);
        this.body2.addChild(this.body1);
        this.tail2.addChild(this.tail3);
        this.hand2.addChild(this.claw5);
        this.hand1.addChild(this.claw1);
        this.neck4.addChild(this.frill2);
        this.thigh1.addChild(this.leg1);
        this.head.addChild(this.crest1);
        this.forearm2.addChild(this.hand2);
        this.arm1.addChild(this.forearm1);
        this.upperfoot1.addChild(this.foot1);
        this.head.addChild(this.upperjaw);
        this.neck3.addChild(this.neck4);
        this.body2.addChild(this.arm2);
        this.neck4.addChild(this.head);
        this.body3.addChild(this.tail1);
        this.hand2.addChild(this.claw4);
        this.neck4.addChild(this.frill1);
        this.forearm1.addChild(this.hand1);
        this.leg2.addChild(this.upperfoot2);
        this.neck4.addChild(this.frill3);
        this.neck4.addChild(this.frill4);
        this.hand2.addChild(this.claw6);
        this.body3.addChild(this.body2);

        updateDefaultPose();

        bodyParts = new MowzieModelRenderer[] { head, neck4, neck3, neck2, neck1, body1, body2, body3 };
        rightArmParts = new MowzieModelRenderer[] { hand1, forearm1, arm1 };
        leftArmParts = new MowzieModelRenderer[] { hand2, forearm2, arm2 };
        tailParts = new MowzieModelRenderer[] { tail5, tail4, tail3, tail2, tail1 };
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.thigh2.render(f5);
        this.thigh1.render(f5);
        this.body3.render(f5);
    }

    private void setRotation(MowzieModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(EntityDilophosaurus dilo, float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, dilo);
        resetToDefaultPose();

        frill1.rotateAngleY += 1.55;
        frill2.rotateAngleY -= 1.55;
        frill3.rotateAngleY += 1.55;
        frill4.rotateAngleY -= 1.55;
        frill1.isHidden = true;
        frill2.isHidden = true;
        frill3.isHidden = true;
        frill4.isHidden = true;

        // f = dilo.frame;
        // f1 = 1F;

        float globalSpeed = 0.77F;
        float globalDegree = 0.77F;
        float height = 2F;

        faceTarget(f3, f4, 1.0F, head, neck1, neck2, neck3, neck4);

        neck4.rotateAngleZ += (f3 / (180f / (float) Math.PI)) / 5;
        neck3.rotateAngleZ += (f3 / (180f / (float) Math.PI)) / 5;
        head.rotateAngleZ += (f3 / (180f / (float) Math.PI)) / 5;

        bob(body3, 1F * globalSpeed, height * 0.7F, false, f, f1);
        bob(thigh2, 1F * globalSpeed, height * 0.7F, false, f, f1);
        bob(thigh1, 1F * globalSpeed, height * 0.7F, false, f, f1);
        walk(body3, 1F * globalSpeed, height * 0.05F, true, 0.1F, 0F, f, f1);
        chainWave(bodyParts, 1F * globalSpeed, -0.03F * height, 3.5F, f, f1);

        walk(thigh2, 0.5F * globalSpeed, 0.8F * globalDegree, false, 0F, 0.4F, f, f1);
        walk(leg2, 0.5F * globalSpeed, 0.8F * globalDegree, true, 1F, 0F, f, f1);
        walk(upperfoot2, 0.5F * globalSpeed, 0.5F * globalDegree, false, 0F, 0F, f, f1);
        walk(foot2, 0.5F * globalSpeed, 1.5F * globalDegree, true, 0.5F, 0.7F, f, f1);

        walk(thigh1, 0.5F * globalSpeed, 0.8F * globalDegree, true, 0F, 0.4F, f, f1);
        walk(leg1, 0.5F * globalSpeed, 0.8F * globalDegree, false, 1F, 0F, f, f1);
        walk(upperfoot1, 0.5F * globalSpeed, 0.5F * globalDegree, true, 0F, 0F, f, f1);
        walk(foot1, 0.5F * globalSpeed, 1.5F * globalDegree, false, 0.5F, 0.7F, f, f1);

        chainSwing(tailParts, 0.5F * globalSpeed, -0.1F, 2, f, f1);
        chainWave(tailParts, 1F * globalSpeed, -0.05F, 2, f, f1);
        chainWave(rightArmParts, 1F * globalSpeed, 0.2F, 3, f, f1);
        chainWave(leftArmParts, 1F * globalSpeed, 0.2F, 3, f, f1);

        float sittingProgress = dilo.sittingProgress.getAnimationProgressSin();

        if (sittingProgress > 0.001F) {
            // Sitting Pose
            float sittingProgressTemporary = dilo.sittingProgress.getAnimationProgressTemporaryFS();

            this.body3.rotationPointY += 10F * sittingProgress;
            this.thigh1.rotationPointY += 10F * sittingProgress;
            this.thigh2.rotationPointY += 10F * sittingProgress;
            this.neck1.rotationPointY -= 0.25F * sittingProgress;
            this.neck2.rotationPointY -= 0.25F * sittingProgress;
            this.neck3.rotationPointY -= 0.25F * sittingProgress;
            this.neck4.rotationPointY -= 0.25F * sittingProgress;
            this.body3.rotationPointZ += 3F * sittingProgress;
            this.thigh1.rotationPointZ += 3F * sittingProgress;
            this.thigh2.rotationPointZ += 3F * sittingProgress;

            if (sittingProgressTemporary > 0.001F) {
                this.body3.rotateAngleX += 0.1F * sittingProgressTemporary;
                this.neck1.rotateAngleX += 0.2F * sittingProgressTemporary;
                this.head.rotateAngleX += 0.1F * sittingProgressTemporary;
                this.arm1.rotateAngleX += 0.5F * sittingProgressTemporary;
                this.arm2.rotateAngleX += 0.5F * sittingProgressTemporary;

                if (dilo.isSitting()) {
                    this.tail1.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.tail2.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.tail3.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.tail4.rotateAngleX += 0.1F * sittingProgressTemporary;
                    this.tail5.rotateAngleX += 0.1F * sittingProgressTemporary;
                } else {
                    this.tail1.rotateAngleX -= 0.1F * sittingProgressTemporary;
                    this.tail2.rotateAngleX -= 0.1F * sittingProgressTemporary;
                    this.tail3.rotateAngleX -= 0.1F * sittingProgressTemporary;
                    this.tail4.rotateAngleX -= 0.1F * sittingProgressTemporary;
                    this.tail5.rotateAngleX -= 0.1F * sittingProgressTemporary;
                }
            }

            this.body3.rotateAngleX -= 0.075F * sittingProgress;

            this.neck1.rotateAngleX -= 0.3F * sittingProgress;
            this.head.rotateAngleX += 0.3F * sittingProgress;

            this.tail1.rotateAngleX += 0.1F * sittingProgress;

            this.arm1.rotationPointY -= 0.8F * sittingProgress;
            this.arm2.rotationPointY -= 0.8F * sittingProgress;
            this.arm1.rotateAngleX -= 0.5F * sittingProgress;
            this.arm2.rotateAngleX -= 0.5F * sittingProgress;

            this.thigh1.rotateAngleX -= 1.0F * sittingProgress;
            this.thigh2.rotateAngleX -= 1.0F * sittingProgress;

            // this.leg1.rotationPointZ += 0.5F * sittingProgress;
            // this.leg2.rotationPointZ += 0.5F * sittingProgress;
            // this.leg1.rotationPointY += 1.5F * sittingProgress;
            // this.leg2.rotationPointY += 1.5F * sittingProgress;
            this.leg1.rotateAngleX += 1.1F * sittingProgress;
            this.leg2.rotateAngleX += 1.1F * sittingProgress;

            this.upperfoot1.rotationPointY += 1.75F * sittingProgress;
            this.upperfoot2.rotationPointY += 1.75F * sittingProgress;
            this.upperfoot1.rotationPointZ -= 1.25F * sittingProgress;
            this.upperfoot2.rotationPointZ -= 1.25F * sittingProgress;
            this.upperfoot1.rotateAngleX -= 1.1F * sittingProgress;
            this.upperfoot2.rotateAngleX -= 1.1F * sittingProgress;

            this.foot1.rotationPointY += 0.5F * sittingProgress;
            this.foot2.rotationPointY += 0.5F * sittingProgress;
            this.foot1.rotationPointZ -= 1.0F * sittingProgress;
            this.foot2.rotationPointZ -= 1.0F * sittingProgress;
            this.foot1.rotateAngleX += 1.0F * sittingProgress;
            this.foot2.rotateAngleX += 1.0F * sittingProgress;

            // Idling
            chainWave(tailParts, 0.1F, -0.05F, 2, dilo.frame, 1.0F - 0.6F * sittingProgress);
            chainWave(bodyParts, 0.15F, 0.03F, 3.5F, dilo.frame, 1.0F - 0.6F * sittingProgress);
            walk(head, 0.1F, 0.07F, true, 0F, 0F, dilo.frame, 1.0F - 0.5F * sittingProgress);
            walk(body3, 0.1F, 0.05F, false, 0F, 0F, dilo.frame, 1.0F - 0.5F * sittingProgress);
            chainWave(rightArmParts, 0.1F, -0.1F, 4, dilo.frame, 1.0F - 0.7F * sittingProgress);
            chainWave(leftArmParts, 0.1F, -0.1F, 4, dilo.frame, 1.0F - 0.7F * sittingProgress);
            chainSwing(tailParts, 0.1F, -0.1F, 3, dilo.frame, 1.0F - 0.6F * sittingProgress);
        } else {
            // Idling
            chainWave(tailParts, 0.15F, -0.03F, 2, dilo.frame, 1.0F);
            chainWave(bodyParts, 0.15F, 0.03F, 3.5F, dilo.frame, 1.0F);
            chainWave(rightArmParts, 0.15F, -0.1F, 4, dilo.frame, 1.0F);
            chainWave(leftArmParts, 0.15F, -0.1F, 4, dilo.frame, 1.0F);
            chainSwing(tailParts, 0.15F, -0.1F, 3, dilo.frame, 1.0F);
        }
        dilo.tailBuffer.applyChainSwingBuffer(this.tailParts);
    }

    private void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setRotationAngles((EntityDilophosaurus) entity, f, f1, f2, f3, f4, f5);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.BITE.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.BITE.animID());
            this.animator.startPhase(3);
            this.animator.rotate(neck1, -0.3F, 0, 0);
            this.animator.rotate(neck2, -0.3F, 0, 0);
            this.animator.rotate(neck3, 0.2F, 0, 0);
            this.animator.rotate(neck4, 0.2F, 0, 0);
            this.animator.rotate(head, 0.2F, 0, 0);
            this.animator.rotate(down_jaw, 0.6F, 0, 0);
            this.animator.endPhase();
            this.animator.startPhase(2);
            this.animator.rotate(neck1, 0.7F, 0, 0);
            this.animator.rotate(neck2, 0.3F, 0, 0);
            this.animator.rotate(neck3, -0.1F, 0, 0);
            this.animator.rotate(neck4, -0.1F, 0, 0);
            this.animator.rotate(head, -1F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.resetPhase(4);
        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.SPITTING.animID()) {
            if (entity.getAnimationTick() <= 18) {
                frill1.isHidden = false;
                frill2.isHidden = false;
                frill3.isHidden = false;
                frill4.isHidden = false;
            }
            this.animator.setAnimation(JurassiCraftAnimationIDs.SPITTING.animID());
            this.animator.startPhase(5);
            this.animator.rotate(neck1, -0.3F, 0, 0);
            this.animator.rotate(neck2, -0.3F, 0, 0);
            this.animator.rotate(neck3, 0.2F, 0, 0);
            this.animator.rotate(neck4, 0.2F, 0, 0);
            this.animator.rotate(head, 0.2F, 0, 0);
            this.animator.rotate(down_jaw, 0.6F, 0, 0);
            animator.rotate(frill1, 0, -1.55F, 0);
            animator.rotate(frill2, 0, 1.55F, 0);
            animator.rotate(frill3, 0, -1.55F, 0);
            animator.rotate(frill4, 0, 1.55F, 0);
            this.animator.endPhase();
            animator.setStationaryPhase(5);
            this.animator.startPhase(2);
            this.animator.rotate(neck1, 0.7F, 0, 0);
            this.animator.rotate(neck2, 0.3F, 0, 0);
            this.animator.rotate(neck3, -0.1F, 0, 0);
            this.animator.rotate(neck4, -0.1F, 0, 0);
            this.animator.rotate(head, -1F, 0, 0);
            this.animator.rotate(down_jaw, 0.6F, 0, 0);
            animator.rotate(frill1, 0, -1.55F, 0);
            animator.rotate(frill2, 0, 1.55F, 0);
            animator.rotate(frill3, 0, -1.55F, 0);
            animator.rotate(frill4, 0, 1.55F, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(3);
            this.animator.resetPhase(5);
        }
    }
}
