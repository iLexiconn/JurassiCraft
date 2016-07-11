package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityMammoth;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMammoth extends MowzieModelBase {
    public MowzieModelRenderer LeftBackThigh;
    public MowzieModelRenderer RightBackThigh;
    public MowzieModelRenderer Waist;
    public MowzieModelRenderer LeftBackCalf;
    public MowzieModelRenderer LeftBackFoot;
    public MowzieModelRenderer RightBackCalf;
    public MowzieModelRenderer RightBackFoot;
    public MowzieModelRenderer Tail;
    public MowzieModelRenderer Chest;
    public MowzieModelRenderer FurBackRightWaist;
    public MowzieModelRenderer FurBackLeftWaist;
    public MowzieModelRenderer Neck;
    public MowzieModelRenderer RightFrontThigh1;
    public MowzieModelRenderer LeftFrontThigh1;
    public MowzieModelRenderer FurFrontLeftChest;
    public MowzieModelRenderer FurFrontRightChest;
    public MowzieModelRenderer FurJointChest;
    public MowzieModelRenderer LowerHead;
    public MowzieModelRenderer FurFrontRightNeck;
    public MowzieModelRenderer FurFrontLeftNeck;
    public MowzieModelRenderer FurJointNeck;
    public MowzieModelRenderer Mouth;
    public MowzieModelRenderer LeftEar;
    public MowzieModelRenderer RightEar;
    public MowzieModelRenderer Trunk1;
    public MowzieModelRenderer UpperHead;
    public MowzieModelRenderer LeftTusk1;
    public MowzieModelRenderer RightTusk1;
    public MowzieModelRenderer Trunk2;
    public MowzieModelRenderer Trunk3;
    public MowzieModelRenderer Trunk4;
    public MowzieModelRenderer Trunk5;
    public MowzieModelRenderer Trunk6;
    public MowzieModelRenderer Trunk7;
    public MowzieModelRenderer LeftTusk2;
    public MowzieModelRenderer LeftTusk3;
    public MowzieModelRenderer LeftTusk4;
    public MowzieModelRenderer LeftTusk5;
    public MowzieModelRenderer RightTusk2;
    public MowzieModelRenderer RightTusk3;
    public MowzieModelRenderer RightTusk4;
    public MowzieModelRenderer RightTusk5;
    public MowzieModelRenderer FurFrontMiddleNeck;
    public MowzieModelRenderer RightFrontThigh2;
    public MowzieModelRenderer RightFrontCalf;
    public MowzieModelRenderer RightFrontFoot;
    public MowzieModelRenderer LeftFrontThigh2;
    public MowzieModelRenderer LeftFrontCalf;
    public MowzieModelRenderer LeftFrontFoot;
    public MowzieModelRenderer FurFrontMiddleChest;
    public MowzieModelRenderer[] lefttuskparts;
    public MowzieModelRenderer[] righttuskparts;
    public MowzieModelRenderer[] trunkParts;
    private Animator animator;

    public ModelMammoth() {
        this.animator = new Animator(this);
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.RightBackFoot = new MowzieModelRenderer(this, 0, 59);
        this.RightBackFoot.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.RightBackFoot.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 6, 0.0F);
        this.setRotateAngle(RightBackFoot, -0.19198621771937624F, -0.0F, 0.0F);
        this.RightFrontCalf = new MowzieModelRenderer(this, 0, 34);
        this.RightFrontCalf.setRotationPoint(0.0F, 5.7F, 3.7F);
        this.RightFrontCalf.addBox(-2.0F, 0.0F, -2.8F, 4, 7, 5, 0.0F);
        this.setRotateAngle(RightFrontCalf, -0.33161255787892263F, -0.0F, 0.0F);
        this.Chest = new MowzieModelRenderer(this, 28, 1);
        this.Chest.setRotationPoint(0.0F, -1.0F, -7.0F);
        this.Chest.addBox(-9.0F, -9.5F, -17.0F, 18, 19, 17, 0.0F);
        this.setRotateAngle(Chest, 0.22689280275926282F, 0.0F, 0.0F);
        this.Mouth = new MowzieModelRenderer(this, 44, 115);
        this.Mouth.setRotationPoint(0.0F, 4.0F, -2.25F);
        this.Mouth.addBox(-3.5F, 0.0F, -7.0F, 7, 2, 7, 0.0F);
        this.setRotateAngle(Mouth, 0.33457961760731303F, -0.0F, 0.0F);
        this.Trunk6 = new MowzieModelRenderer(this, 102, 2);
        this.Trunk6.setRotationPoint(0.0F, 0.0F, -4.75F);
        this.Trunk6.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(Trunk6, 0.2617993877991494F, 0.0F, 0.0F);
        this.FurFrontRightChest = new MowzieModelRenderer(this, 86, 73);
        this.FurFrontRightChest.setRotationPoint(6.6F, 8.7F, -9.0F);
        this.FurFrontRightChest.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
        this.setRotateAngle(FurFrontRightChest, 0.0F, 0.08726646259971647F, 0.0F);
        this.LeftTusk2 = new MowzieModelRenderer(this, 79, 39);
        this.LeftTusk2.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.LeftTusk2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(LeftTusk2, -0.2617993877991494F, 0.0F, 0.017453292519943295F);
        this.LeftTusk5 = new MowzieModelRenderer(this, 79, 39);
        this.LeftTusk5.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.LeftTusk5.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(LeftTusk5, -0.5235987755982988F, 0.08726646259971647F, 0.017453292519943295F);
        this.RightTusk1 = new MowzieModelRenderer(this, 79, 39);
        this.RightTusk1.setRotationPoint(-3.5F, 2.0F, -5.0F);
        this.RightTusk1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(RightTusk1, -0.17453292519943295F, 0.0F, 0.17453292519943295F);
        this.LeftFrontFoot = new MowzieModelRenderer(this, 0, 48);
        this.LeftFrontFoot.setRotationPoint(0.0F, 7.0F, -2.8F);
        this.LeftFrontFoot.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(LeftFrontFoot, 0.12217304763960307F, -0.0F, 0.0F);
        this.LeftFrontCalf = new MowzieModelRenderer(this, 0, 34);
        this.LeftFrontCalf.setRotationPoint(0.0F, 5.7F, 3.7F);
        this.LeftFrontCalf.addBox(-2.0F, 0.0F, -2.8F, 4, 7, 5, 0.0F);
        this.setRotateAngle(LeftFrontCalf, -0.33161255787892263F, -0.0F, 0.0F);
        this.RightEar = new MowzieModelRenderer(this, 114, 39);
        this.RightEar.setRotationPoint(-4.5F, -4.0F, -2.0F);
        this.RightEar.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(RightEar, 0.1350884841043611F, -0.6108652381980153F, 0.0F);
        this.Trunk4 = new MowzieModelRenderer(this, 100, 53);
        this.Trunk4.setRotationPoint(0.0F, 0.0F, -5.25F);
        this.Trunk4.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Trunk4, 0.17453292519943295F, 0.0F, 0.0F);
        this.LeftBackThigh = new MowzieModelRenderer(this, 0, 87);
        this.LeftBackThigh.setRotationPoint(6.0F, 5.3F, 12.0F);
        this.LeftBackThigh.addBox(-3.0F, -2.5F, -2.7F, 6, 10, 8, 0.0F);
        this.setRotateAngle(LeftBackThigh, -0.1361356816555577F, -0.0F, 0.0F);
        this.Neck = new MowzieModelRenderer(this, 92, 106);
        this.Neck.setRotationPoint(0.0F, -2.5F, -15.2F);
        this.Neck.addBox(-6.0F, -7.0F, -4.0F, 12, 14, 4, 0.0F);
        this.setRotateAngle(Neck, 0.045553093477052F, -0.0F, 0.0F);
        this.LeftTusk3 = new MowzieModelRenderer(this, 79, 39);
        this.LeftTusk3.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.LeftTusk3.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(LeftTusk3, -0.4363323129985824F, 0.08726646259971647F, 0.017453292519943295F);
        this.UpperHead = new MowzieModelRenderer(this, 0, 106);
        this.UpperHead.setRotationPoint(0.0F, -4.0F, -1.0F);
        this.UpperHead.addBox(-4.5F, -4.5F, -6.5F, 9, 5, 12, 0.0F);
        this.setRotateAngle(UpperHead, -0.08726646259971647F, 0.0F, 0.0F);
        this.RightBackCalf = new MowzieModelRenderer(this, 0, 71);
        this.RightBackCalf.setRotationPoint(0.0F, 6.6F, -2.0F);
        this.RightBackCalf.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 6, 0.0F);
        this.setRotateAngle(RightBackCalf, 0.32812189937493397F, -0.0F, 0.0F);
        this.RightTusk4 = new MowzieModelRenderer(this, 79, 39);
        this.RightTusk4.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.RightTusk4.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(RightTusk4, -0.3490658503988659F, -0.08726646259971647F, -0.017453292519943295F);
        this.FurFrontLeftNeck = new MowzieModelRenderer(this, 86, 73);
        this.FurFrontLeftNeck.setRotationPoint(-6.0F, 6.3F, 4.0F);
        this.FurFrontLeftNeck.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
        this.FurFrontMiddleChest = new MowzieModelRenderer(this, 91, 78);
        this.FurFrontMiddleChest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FurFrontMiddleChest.addBox(0.0F, 0.0F, -6.0F, 0, 9, 12, 0.0F);
        this.setRotateAngle(FurFrontMiddleChest, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.FurJointChest = new MowzieModelRenderer(this, 0, 0);
        this.FurJointChest.setRotationPoint(0.0F, 8.7F, -17.0F);
        this.FurJointChest.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftFrontThigh2 = new MowzieModelRenderer(this, 0, 19);
        this.LeftFrontThigh2.setRotationPoint(1.0F, 9.0F, 0.5F);
        this.LeftFrontThigh2.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 6, 0.0F);
        this.setRotateAngle(LeftFrontThigh2, 0.15707963267948966F, -0.0F, 0.0F);
        this.Tail = new MowzieModelRenderer(this, 23, 18);
        this.Tail.setRotationPoint(-0.5F, -7.0F, 5.0F);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
        this.setRotateAngle(Tail, 0.40980330836826856F, 0.0F, 0.0F);
        this.RightFrontFoot = new MowzieModelRenderer(this, 0, 48);
        this.RightFrontFoot.setRotationPoint(0.0F, 7.0F, -2.8F);
        this.RightFrontFoot.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(RightFrontFoot, 0.12217304763960307F, -0.0F, 0.0F);
        this.FurBackLeftWaist = new MowzieModelRenderer(this, 86, 73);
        this.FurBackLeftWaist.setRotationPoint(-7.9F, 8.0F, -5.5F);
        this.FurBackLeftWaist.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
        this.setRotateAngle(FurBackLeftWaist, 0.296705972839036F, 0.0F, 0.0F);
        this.LeftFrontThigh1 = new MowzieModelRenderer(this, 0, 0);
        this.LeftFrontThigh1.setRotationPoint(7.0F, -1.1F, -16.0F);
        this.LeftFrontThigh1.addBox(-2.0F, 0.0F, 0.0F, 6, 10, 7, 0.0F);
        this.setRotateAngle(LeftFrontThigh1, 0.13962634015954636F, -0.0F, 0.0F);
        this.RightTusk5 = new MowzieModelRenderer(this, 79, 39);
        this.RightTusk5.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.RightTusk5.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(RightTusk5, -0.5235987755982988F, -0.08726646259971647F, -0.017453292519943295F);
        this.Trunk3 = new MowzieModelRenderer(this, 100, 14);
        this.Trunk3.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Trunk3.addBox(-3.5F, -3.5F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Trunk3, 0.2617993877991494F, 0.0F, 0.0F);
        this.RightFrontThigh2 = new MowzieModelRenderer(this, 0, 19);
        this.RightFrontThigh2.setRotationPoint(-1.0F, 9.0F, 0.5F);
        this.RightFrontThigh2.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 6, 0.0F);
        this.setRotateAngle(RightFrontThigh2, 0.15707963267948966F, -0.0F, 0.0F);
        this.FurJointNeck = new MowzieModelRenderer(this, 0, 0);
        this.FurJointNeck.setRotationPoint(0.0F, 6.3F, -3.9F);
        this.FurJointNeck.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftBackCalf = new MowzieModelRenderer(this, 0, 71);
        this.LeftBackCalf.setRotationPoint(0.0F, 6.6F, -2.0F);
        this.LeftBackCalf.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 6, 0.0F);
        this.setRotateAngle(LeftBackCalf, 0.32812189937493397F, -0.0F, 0.0F);
        this.Trunk5 = new MowzieModelRenderer(this, 91, 40);
        this.Trunk5.setRotationPoint(0.0F, 0.0F, -4.75F);
        this.Trunk5.addBox(-2.5F, -2.5F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(Trunk5, 0.17453292519943295F, 0.0F, 0.0F);
        this.FurBackRightWaist = new MowzieModelRenderer(this, 86, 73);
        this.FurBackRightWaist.setRotationPoint(7.9F, 8.0F, -5.5F);
        this.FurBackRightWaist.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
        this.setRotateAngle(FurBackRightWaist, 0.27314402793711257F, 0.0F, 0.0F);
        this.LeftBackFoot = new MowzieModelRenderer(this, 0, 59);
        this.LeftBackFoot.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.LeftBackFoot.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 6, 0.0F);
        this.setRotateAngle(LeftBackFoot, -0.19198621771937624F, -0.0F, 0.0F);
        this.Trunk2 = new MowzieModelRenderer(this, 43, 94);
        this.Trunk2.setRotationPoint(0.0F, -1.25F, -3.5F);
        this.Trunk2.addBox(-4.0F, -4.5F, -5.0F, 8, 9, 6, 0.0F);
        this.setRotateAngle(Trunk2, 0.5235987755982988F, 0.0F, 0.0F);
        this.LeftEar = new MowzieModelRenderer(this, 114, 39);
        this.LeftEar.setRotationPoint(4.5F, -4.0F, -2.0F);
        this.LeftEar.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(LeftEar, 0.1350884841043611F, 0.6108652381980153F, 0.0F);
        this.RightBackThigh = new MowzieModelRenderer(this, 0, 87);
        this.RightBackThigh.setRotationPoint(-6.0F, 5.3F, 12.0F);
        this.RightBackThigh.addBox(-3.0F, -2.5F, -2.7F, 6, 10, 8, 0.0F);
        this.setRotateAngle(RightBackThigh, -0.1361356816555577F, -0.0F, 0.0F);
        this.LowerHead = new MowzieModelRenderer(this, 29, 73);
        this.LowerHead.setRotationPoint(0.0F, -2.5F, -4.0F);
        this.LowerHead.addBox(-5.5F, -6.0F, -8.0F, 11, 12, 8, 0.0F);
        this.RightFrontThigh1 = new MowzieModelRenderer(this, 0, 0);
        this.RightFrontThigh1.setRotationPoint(-7.0F, -1.1F, -16.0F);
        this.RightFrontThigh1.addBox(-4.0F, 0.0F, 0.0F, 6, 10, 7, 0.0F);
        this.setRotateAngle(RightFrontThigh1, 0.13962634015954636F, -0.0F, 0.0F);
        this.Trunk1 = new MowzieModelRenderer(this, 88, 73);
        this.Trunk1.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Trunk1.addBox(-4.5F, -6.0F, -5.75F, 9, 11, 6, 0.0F);
        this.setRotateAngle(Trunk1, 0.5235987755982988F, 0.0F, 0.0F);
        this.LeftTusk4 = new MowzieModelRenderer(this, 79, 39);
        this.LeftTusk4.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.LeftTusk4.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(LeftTusk4, -0.3490658503988659F, 0.08726646259971647F, 0.017453292519943295F);
        this.Waist = new MowzieModelRenderer(this, 22, 38);
        this.Waist.setRotationPoint(0.0F, 5.3F, 12.0F);
        this.Waist.addBox(-8.0F, -9.0F, -10.5F, 16, 18, 16, 0.0F);
        this.setRotateAngle(Waist, -0.3141592653589793F, 0.0F, 0.0F);
        this.RightTusk3 = new MowzieModelRenderer(this, 79, 39);
        this.RightTusk3.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.RightTusk3.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(RightTusk3, -0.4363323129985824F, -0.08726646259971647F, -0.017453292519943295F);
        this.FurFrontLeftChest = new MowzieModelRenderer(this, 86, 73);
        this.FurFrontLeftChest.setRotationPoint(-6.6F, 8.7F, -9.0F);
        this.FurFrontLeftChest.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
        this.setRotateAngle(FurFrontLeftChest, 0.0F, -0.08726646259971647F, 0.0F);
        this.Trunk7 = new MowzieModelRenderer(this, 107, 30);
        this.Trunk7.setRotationPoint(0.0F, 0.0F, -4.75F);
        this.Trunk7.addBox(-1.5F, -1.5F, -5.0F, 3, 3, 5, 0.0F);
        this.setRotateAngle(Trunk7, 0.17453292519943295F, 0.0F, 0.0F);
        this.RightTusk2 = new MowzieModelRenderer(this, 79, 39);
        this.RightTusk2.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.RightTusk2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(RightTusk2, -0.2617993877991494F, 0.0F, -0.017453292519943295F);
        this.LeftTusk1 = new MowzieModelRenderer(this, 79, 39);
        this.LeftTusk1.setRotationPoint(3.5F, 2.0F, -5.0F);
        this.LeftTusk1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(LeftTusk1, -0.17453292519943295F, 0.0F, -0.17453292519943295F);
        this.FurFrontMiddleNeck = new MowzieModelRenderer(this, 91, 78);
        this.FurFrontMiddleNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FurFrontMiddleNeck.addBox(0.0F, 0.0F, -6.0F, 0, 9, 12, 0.0F);
        this.setRotateAngle(FurFrontMiddleNeck, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.FurFrontRightNeck = new MowzieModelRenderer(this, 86, 73);
        this.FurFrontRightNeck.setRotationPoint(6.0F, 6.3F, 4.0F);
        this.FurFrontRightNeck.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);

        this.RightBackCalf.addChild(this.RightBackFoot);
        this.RightFrontThigh2.addChild(this.RightFrontCalf);
        this.Waist.addChild(this.Chest);
        this.LowerHead.addChild(this.Mouth);
        this.Trunk5.addChild(this.Trunk6);
        this.Chest.addChild(this.FurFrontRightChest);
        this.LeftTusk1.addChild(this.LeftTusk2);
        this.LeftTusk4.addChild(this.LeftTusk5);
        this.LowerHead.addChild(this.RightTusk1);
        this.LeftFrontCalf.addChild(this.LeftFrontFoot);
        this.LeftFrontThigh2.addChild(this.LeftFrontCalf);
        this.LowerHead.addChild(this.RightEar);
        this.Trunk3.addChild(this.Trunk4);
        this.Chest.addChild(this.Neck);
        this.LeftTusk2.addChild(this.LeftTusk3);
        this.LowerHead.addChild(this.UpperHead);
        this.RightBackThigh.addChild(this.RightBackCalf);
        this.RightTusk3.addChild(this.RightTusk4);
        this.Neck.addChild(this.FurFrontLeftNeck);
        this.FurJointChest.addChild(this.FurFrontMiddleChest);
        this.Chest.addChild(this.FurJointChest);
        this.LeftFrontThigh1.addChild(this.LeftFrontThigh2);
        this.Waist.addChild(this.Tail);
        this.RightFrontCalf.addChild(this.RightFrontFoot);
        this.Waist.addChild(this.FurBackLeftWaist);
        this.Chest.addChild(this.LeftFrontThigh1);
        this.RightTusk4.addChild(this.RightTusk5);
        this.Trunk2.addChild(this.Trunk3);
        this.RightFrontThigh1.addChild(this.RightFrontThigh2);
        this.Neck.addChild(this.FurJointNeck);
        this.LeftBackThigh.addChild(this.LeftBackCalf);
        this.Trunk4.addChild(this.Trunk5);
        this.Waist.addChild(this.FurBackRightWaist);
        this.LeftBackCalf.addChild(this.LeftBackFoot);
        this.Trunk1.addChild(this.Trunk2);
        this.LowerHead.addChild(this.LeftEar);
        this.Neck.addChild(this.LowerHead);
        this.Chest.addChild(this.RightFrontThigh1);
        this.LowerHead.addChild(this.Trunk1);
        this.LeftTusk3.addChild(this.LeftTusk4);
        this.RightTusk2.addChild(this.RightTusk3);
        this.Chest.addChild(this.FurFrontLeftChest);
        this.Trunk6.addChild(this.Trunk7);
        this.RightTusk1.addChild(this.RightTusk2);
        this.LowerHead.addChild(this.LeftTusk1);
        this.FurJointNeck.addChild(this.FurFrontMiddleNeck);
        this.Neck.addChild(this.FurFrontRightNeck);

        trunkParts = new MowzieModelRenderer[] { Trunk7, Trunk6, Trunk5, Trunk4, Trunk3, Trunk2, Trunk1 };
        lefttuskparts = new MowzieModelRenderer[] { LeftTusk5, LeftTusk4, LeftTusk3, LeftTusk2, LeftTusk1 };
        righttuskparts = new MowzieModelRenderer[] { RightTusk5, RightTusk4, RightTusk3, RightTusk2, RightTusk1 };
        this.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate(f, f1, f2, f3, f4, f5, (EntityMammoth) entity);
        this.LeftBackThigh.render(f5);
        this.RightBackThigh.render(f5);
        this.Waist.render(f5);
    }

    private void setRotateAngle(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityMammoth mammoth) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, mammoth);
        resetToDefaultPose();

        // f = mammoth.frame;
        // f1 = 0.5F;

        if (mammoth.getCreatureGender() == false) {
            LeftTusk3.isHidden = true;
            RightTusk3.isHidden = true;
        } else {
            LeftTusk3.isHidden = false;
            RightTusk3.isHidden = false;
        }

        float globalSpeed = 0.5F;
        float globalDegree = 1F;
        float height = 1.3F;
        float frontOffset = -2.3F;

        LowerHead.rotateAngleY += (f3 / (180f / (float) Math.PI)) / 2;
        Neck.rotateAngleY += (f3 / (180f / (float) Math.PI)) / 2;

        this.bob(this.Waist, 2 * globalSpeed, height, false, f, f1);
        this.bob(this.LeftBackThigh, 2 * globalSpeed, height, false, f, f1);
        this.bob(this.RightBackThigh, 2 * globalSpeed, height, false, f, f1);
        this.walk(this.Waist, 2 * globalSpeed, 0.1F * height, true, -1.5F, 0.05F, f, f1);
        this.walk(this.Tail, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.Neck, 2 * globalSpeed, 0.06F * height, false, 0F, -0.1F, f, f1);
        this.walk(this.LowerHead, 2 * globalSpeed, 0.04F * height, false, 0F, -0.1F, f, f1);
        this.flap(LowerHead, 1 * globalSpeed, 0.2F * height, false, 3F, 0, f, f1);
        this.walk(this.RightEar, 2 * globalSpeed, 0.2F * height, false, 2F, 0F, f, f1);
        this.walk(this.LeftEar, 2 * globalSpeed, 0.2F * height, false, 2F, 0F, f, f1);

        this.walk(this.FurBackRightWaist, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurBackLeftWaist, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurFrontLeftChest, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurFrontRightChest, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurJointChest, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurJointNeck, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurFrontLeftNeck, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurFrontRightNeck, 2 * globalSpeed, 0.2F * height, false, -0.3F, 0F, f, f1);
        this.walk(this.FurJointNeck, 2 * globalSpeed, 0.1F * height, false, -0.3F, 0F, f, f1);

        this.walk(this.LeftBackThigh, 1F * globalSpeed, 0.6F * globalDegree, false, 0F, 0F, f, f1);
        this.walk(this.LeftBackCalf, 1F * globalSpeed, 0.6F * globalDegree, true, 1F, 0F, f, f1);
        this.walk(this.LeftBackFoot, 1F * globalSpeed, 0.6F * globalDegree, false, -1.5F, 1F, f, f1);

        this.walk(this.RightBackThigh, 1F * globalSpeed, 0.6F * globalDegree, true, 0F, 0F, f, f1);
        this.walk(this.RightBackCalf, 1F * globalSpeed, 0.6F * globalDegree, false, 1F, 0F, f, f1);
        this.walk(this.RightBackFoot, 1F * globalSpeed, 0.6F * globalDegree, true, -1.5F, 1F, f, f1);

        this.walk(this.RightFrontThigh1, 1F * globalSpeed, 0.4F * globalDegree, true, frontOffset + 0F, -0.15F, f, f1);
        this.walk(this.RightFrontCalf, 1F * globalSpeed, 0.6F * globalDegree, true, frontOffset + 1F, -0.2F, f, f1);
        this.walk(this.RightFrontFoot, 1F * globalSpeed, 0.6F * globalDegree, false, frontOffset + 2F, 0.8F, f, f1);

        this.walk(this.LeftFrontThigh1, 1F * globalSpeed, 0.4F * globalDegree, false, frontOffset + 0F, -0.15F, f, f1);
        this.walk(this.LeftFrontCalf, 1F * globalSpeed, 0.6F * globalDegree, false, frontOffset + 1F, -0.2F, f, f1);
        this.walk(this.LeftFrontFoot, 1F * globalSpeed, 0.6F * globalDegree, true, frontOffset + 2F, 0.8F, f, f1);

        chainWave(trunkParts, 2F * globalSpeed, -0.07F, 2, f, f1);
        chainSwing(trunkParts, 1F * globalSpeed, 0.08F, 2, f, f1);
        // chainWave(lefttuskparts, 2F * globalSpeed, -0.3F, 2, f, f1);
        // chainWave(righttuskparts, 2F * globalSpeed, -0.3F, 2, f, f1);

        // Idling
        this.walk(this.Neck, 0.1F, 0.04F, false, -1F, 0F, mammoth.frame, 1F);
        this.walk(this.LowerHead, 0.1F, 0.07F, true, 0F, 0F, mammoth.frame, 1F);
        this.walk(this.Waist, 0.1F, 0.025F, false, 0F, 0F, mammoth.frame, 1F);

        float inverseKinematicsConstant = 0.32F;
        this.walk(this.RightFrontThigh1, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, mammoth.frame, 1F);
        this.walk(this.RightFrontCalf, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, mammoth.frame, 1F);
        this.walk(this.RightFrontFoot, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, mammoth.frame, 1F);
        this.walk(this.LeftFrontThigh1, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, mammoth.frame, 1F);
        this.walk(this.LeftFrontCalf, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, mammoth.frame, 1F);
        this.walk(this.LeftFrontFoot, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, mammoth.frame, 1F);
        this.LeftFrontThigh1.rotationPointZ -= 1.3 * inverseKinematicsConstant * Math.cos(mammoth.frame * 0.1F);
        this.RightFrontThigh1.rotationPointZ -= 1.3 * inverseKinematicsConstant * Math.cos(mammoth.frame * 0.1F);
        chainWave(trunkParts, 0.1F, -0.02F, 1, mammoth.frame, 1F);
        this.walk(this.RightEar, 0.1F, 0.1F, false, 2F, 0F, mammoth.frame, 1F);
        this.walk(this.LeftEar, 0.1F, 0.1F, false, 2F, 0F, mammoth.frame, 1F);
        this.walk(this.Tail, 0.1F, 0.05F, false, -1.2F, 0F, mammoth.frame, 1F);
        this.walk(this.FurBackRightWaist, 0.1F, 0.1F, false, -1.2F, -0.2F, mammoth.frame, 1F);
        this.walk(this.FurBackLeftWaist, 0.1F, 0.1F, false, -1.2F, -0.2F, mammoth.frame, 1F);
        this.walk(this.FurFrontLeftChest, 0.1F, 0.1F, false, -1.2F, 0F, mammoth.frame, 1F);
        this.walk(this.FurFrontRightChest, 0.1F, 0.1F, false, -1.2F, 0F, mammoth.frame, 1F);
        this.walk(this.FurJointChest, 0.1F, 0.1F, false, -1.2F, 0F, mammoth.frame, 1F);
        this.walk(this.FurJointNeck, 0.1F, 0.1F, false, -1.2F, 0F, mammoth.frame, 1F);
        this.walk(this.FurFrontLeftNeck, 0.1F, 0.1F, false, -1.2F, 0F, mammoth.frame, 1F);
        this.walk(this.FurFrontRightNeck, 0.1F, 0.1F, false, -1.2F, 0F, mammoth.frame, 1F);

        // Trunk lifting animation
        float liftTrunkProgress = mammoth.trunkLift.getAnimationProgressSinSqrt();
        Trunk4.rotateAngleX -= 0.3 * liftTrunkProgress;
        Trunk5.rotateAngleX -= 0.7 * liftTrunkProgress;
        Trunk6.rotateAngleX -= 1.5 * liftTrunkProgress;
        Trunk7.rotateAngleX += 0.3 * liftTrunkProgress;

        // Trunk swinging animation
        float swingTrunkProgress = mammoth.trunkSwing.getAnimationProgressSinSqrt();
        chainWave(trunkParts, 0.2F, 0.1F * swingTrunkProgress, 0, mammoth.frame, 1F);

        // Ear flapping
        float earFlapProgress = mammoth.earFlap.getAnimationProgressSinSqrt();
        RightEar.rotateAngleY += 0.5F * earFlapProgress * Math.cos(mammoth.frame * 0.4F) - earFlapProgress * 0.5;
        LeftEar.rotateAngleY -= 0.5F * earFlapProgress * Math.cos(mammoth.frame * 0.4F) - earFlapProgress * 0.5;

        // Tail Swinging
        float tailSwingProgress = mammoth.tailSwing.getAnimationProgressSinSqrt();
        flap(Tail, 0.3F, 0.4F * tailSwingProgress, false, 0, 0, mammoth.frame, 1F);
    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, EntityMammoth mammoth) {
        this.animator.update(mammoth);
        setRotationAngles(f, f1, f2, f3, f4, f5, mammoth);

        if (mammoth.getAnimationId() == JurassiCraftAnimationIDs.BITE.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.BITE.animID());
            this.animator.startPhase(6);
            animator.rotate(Waist, 0.3F, 0.3F, 0);
            animator.rotate(RightFrontThigh1, 0.3F, 0, 0);
            animator.rotate(LeftFrontThigh1, 0.3F, 0, 0);
            animator.rotate(RightFrontCalf, -0.8F, 0, 0);
            animator.rotate(LeftFrontCalf, -0.8F, 0, 0);
            animator.rotate(RightFrontFoot, 0.3F, 0, 0);
            animator.rotate(LeftFrontFoot, 0.3F, 0, 0);
            animator.rotate(LowerHead, 0.3F, 0.3F, 0);
            animator.rotate(Trunk1, 0.1F, 0, 0);
            animator.rotate(Trunk2, 0.1F, 0, 0);
            animator.rotate(Trunk3, 0.1F, 0, 0);
            animator.rotate(Trunk4, 0.2F, 0, 0);
            animator.rotate(Trunk5, 0.2F, 0, 0);
            animator.rotate(Trunk6, 0.2F, 0, 0);
            animator.rotate(Trunk7, 0.2F, 0, 0);
            animator.endPhase();
            animator.setStationaryPhase(2);
            this.animator.startPhase(4);
            animator.rotate(Waist, 0, -0.5F, 0);
            // animator.rotate(RightFrontThigh1, 0.3F, 0, 0);
            // animator.rotate(LeftFrontThigh1, 0.3F, 0, 0);
            // animator.rotate(RightFrontCalf, -0.8F, 0, 0);
            // animator.rotate(LeftFrontCalf, -0.8F, 0, 0);
            // animator.rotate(RightFrontFoot, 0.3F, 0, 0);
            // animator.rotate(LeftFrontFoot, 0.3F, 0, 0);
            animator.rotate(Neck, -0.3F, -0.3F, 0);
            animator.rotate(LowerHead, -0.3F, -0.3F, 0);
            animator.rotate(Trunk1, -0.1F, 0, 0);
            animator.rotate(Trunk2, -0.1F, 0, 0);
            animator.rotate(Trunk3, -0.1F, 0, 0);
            animator.rotate(Trunk4, -0.1F, 0, 0);
            animator.rotate(Trunk5, -0.1F, 0, 0);
            animator.rotate(Trunk6, -0.1F, 0, 0);
            animator.rotate(Trunk7, -0.1F, 0, 0);
            animator.endPhase();
            animator.setStationaryPhase(4);
            this.animator.resetPhase(8);
        }
    }
}
