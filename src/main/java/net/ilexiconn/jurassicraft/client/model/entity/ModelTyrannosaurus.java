package net.ilexiconn.jurassicraft.client.model.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelTyrannosaurus extends MowzieModelBase {
    public MowzieModelRenderer RightThigh;
    public MowzieModelRenderer waist;
    public MowzieModelRenderer LeftThigh;
    public MowzieModelRenderer RightCalf1;
    public MowzieModelRenderer RightCalf2;
    public MowzieModelRenderer FootRight;
    public MowzieModelRenderer Tail1;
    public MowzieModelRenderer stomach;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer Tail3;
    public MowzieModelRenderer Tail4;
    public MowzieModelRenderer Tail5;
    public MowzieModelRenderer Tail6;
    public MowzieModelRenderer chest;
    public MowzieModelRenderer UpperArmLeft;
    public MowzieModelRenderer UpperArmRight;
    public MowzieModelRenderer Neck1;
    public MowzieModelRenderer LowerArmLeft;
    public MowzieModelRenderer HandLeft;
    public MowzieModelRenderer HandLeftClawLeft;
    public MowzieModelRenderer HandLeftClawRight;
    public MowzieModelRenderer LowerArmRight;
    public MowzieModelRenderer HandRight;
    public MowzieModelRenderer HandRightClawLeft;
    public MowzieModelRenderer HandRightClawRight;
    public MowzieModelRenderer Neck2;
    public MowzieModelRenderer Throat1;
    public MowzieModelRenderer Neck3;
    public MowzieModelRenderer Neck4;
    public MowzieModelRenderer Throat2;
    public MowzieModelRenderer Neck5;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer Throat3;
    public MowzieModelRenderer UpperJaw;
    public MowzieModelRenderer LowerJaw;
    public MowzieModelRenderer Righteyeridge;
    public MowzieModelRenderer Lefteyeridge;
    public MowzieModelRenderer Teeth;
    public MowzieModelRenderer crest1;
    public MowzieModelRenderer crest2;
    public MowzieModelRenderer crest3;
    public MowzieModelRenderer Righteyeridge2;
    public MowzieModelRenderer Righteyeridgerear;
    public MowzieModelRenderer Righteyeridge3;
    public MowzieModelRenderer Lefteyeridge2;
    public MowzieModelRenderer Lefteyeridgerear;
    public MowzieModelRenderer Lefteyeridge3;
    public MowzieModelRenderer LeftCalf1;
    public MowzieModelRenderer LeftCalf2;
    public MowzieModelRenderer FootLeft;
    public MowzieModelRenderer[] tailParts;
    public MowzieModelRenderer[] bodyParts;
    public MowzieModelRenderer[] leftArmParts;
    public MowzieModelRenderer[] rightArmParts;
    private Animator animator;

    public ModelTyrannosaurus() {
        this.animator = new Animator(this);
        this.textureWidth = 256;
        this.textureHeight = 256;

        this.RightThigh = new MowzieModelRenderer(this, 0, 138);
        this.RightThigh.setRotationPoint(-4.5F, 1.8F, 5.0F);
        this.RightThigh.addBox(-5.0F, -4.0F, -11.0F, 5, 8, 14, 0.0F);
        this.setRotateAngle(RightThigh, 1.284736862393026F, 0.0F, 0.0F);
        this.Throat1 = new MowzieModelRenderer(this, 180, 31);
        this.Throat1.setRotationPoint(0.0F, 3.8F, 0.4F);
        this.Throat1.addBox(-3.0F, 0.0F, -7.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Throat1, 0.15707963267948966F, -0.0F, 0.0F);
        this.Tail4 = new MowzieModelRenderer(this, 118, 107);
        this.Tail4.setRotationPoint(0.0F, 0.3F, 8.0F);
        this.Tail4.addBox(-2.5F, 0.0F, -1.0F, 5, 7, 10, 0.0F);
        this.setRotateAngle(Tail4, -0.0778416846389471F, -0.0F, 0.0F);
        this.crest1 = new MowzieModelRenderer(this, 23, 79);
        this.crest1.setRotationPoint(-2.5F, 4.7F, -0.5F);
        this.crest1.addBox(0.0F, 0.0F, 0.0F, 5, 2, 9, 0.0F);
        this.setRotateAngle(crest1, 0.17872171540421936F, 0.0F, 0.0F);
        this.LowerArmLeft = new MowzieModelRenderer(this, 12, 59);
        this.LowerArmLeft.setRotationPoint(0.0F, 2.5F, 0.7F);
        this.LowerArmLeft.addBox(0.0F, 0.2F, -0.1F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LowerArmLeft, -0.8100073058505682F, -0.0F, 0.0F);
        this.Neck1 = new MowzieModelRenderer(this, 218, 1);
        this.Neck1.setRotationPoint(0.0F, 2.6F, -2.2F);
        this.Neck1.addBox(-3.5F, 0.0F, -6.0F, 7, 8, 6, 0.0F);
        this.setRotateAngle(Neck1, -0.5612978874413763F, -0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 0, 92);
        this.Head.setRotationPoint(0.0F, 0.5F, -1.8F);
        this.Head.addBox(-4.0F, 0.0F, -8.0F, 8, 9, 8, 0.0F);
        this.setRotateAngle(Head, -0.25603980126756815F, 0.0F, 0.0F);
        this.crest2 = new MowzieModelRenderer(this, 22, 64);
        this.crest2.setRotationPoint(0.5F, 1.2F, 1.1F);
        this.crest2.addBox(0.0F, 0.2F, 0.0F, 4, 1, 8, 0.0F);
        this.setRotateAngle(crest2, -0.10297442586766545F, 0.0F, 0.0F);
        this.LeftCalf1 = new MowzieModelRenderer(this, 54, 166);
        this.LeftCalf1.setRotationPoint(2.5F, -2.8F, -10.5F);
        this.LeftCalf1.addBox(-2.0F, 0.0F, 0.0F, 4, 10, 5, 0.0F);
        this.setRotateAngle(LeftCalf1, -0.6564183316750672F, -0.0F, 0.0F);
        this.Tail2 = new MowzieModelRenderer(this, 118, 63);
        this.Tail2.setRotationPoint(0.0F, 0.8F, 8.0F);
        this.Tail2.addBox(-4.0F, 0.0F, 0.0F, 8, 10, 9, 0.0F);
        this.setRotateAngle(Tail2, 0.031939525311496235F, -0.0F, 0.0F);
        this.Neck5 = new MowzieModelRenderer(this, 218, 76);
        this.Neck5.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Neck5.addBox(-3.5F, 0.0F, -4.0F, 7, 8, 4, 0.0F);
        this.setRotateAngle(Neck5, 0.39671333897831107F, -0.0F, 0.0F);
        this.RightCalf2 = new MowzieModelRenderer(this, 0, 190);
        this.RightCalf2.setRotationPoint(0.0F, 7.8F, 3.5F);
        this.RightCalf2.addBox(-1.5F, 0.0F, -1.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(RightCalf2, -1.1667526049582093F, -0.0F, 0.0F);
        this.Tail3 = new MowzieModelRenderer(this, 118, 86);
        this.Tail3.setRotationPoint(0.0F, 0.7F, 9.0F);
        this.Tail3.addBox(-3.5F, 0.0F, -1.0F, 7, 8, 9, 0.0F);
        this.setRotateAngle(Tail3, 0.0158824961931484F, -0.0F, 0.0F);
        this.Neck2 = new MowzieModelRenderer(this, 218, 18);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Neck2.addBox(-3.5F, 0.0F, -4.0F, 7, 8, 4, 0.0F);
        this.Throat2 = new MowzieModelRenderer(this, 180, 48);
        this.Throat2.setRotationPoint(0.0F, 6.0F, -0.4F);
        this.Throat2.addBox(-3.0F, -0.3F, -4.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Throat2, 0.0466002910282486F, 0.0F, 0.0F);
        this.waist = new MowzieModelRenderer(this, 84, 1);
        this.waist.setRotationPoint(0.0F, 1.8F, 5.0F);
        this.waist.addBox(-6.0F, -9.0F, -6.0F, 12, 15, 10, 0.0F);
        this.setRotateAngle(waist, -0.040666171571467874F, -0.0F, 0.0F);
        this.Lefteyeridge3 = new MowzieModelRenderer(this, 37, 40);
        this.Lefteyeridge3.setRotationPoint(0.5F, 0.0F, -8.7F);
        this.Lefteyeridge3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(Lefteyeridge3, 0.0F, -0.13700834628155487F, 0.0F);
        this.Tail6 = new MowzieModelRenderer(this, 118, 150);
        this.Tail6.setRotationPoint(0.0F, -0.2F, 12.7F);
        this.Tail6.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 14, 0.0F);
        this.setRotateAngle(Tail6, -0.09005898940290741F, 0.0F, 0.0F);
        this.Righteyeridge = new MowzieModelRenderer(this, 12, 28);
        this.Righteyeridge.setRotationPoint(-5.6F, 0.2F, -3.4F);
        this.Righteyeridge.addBox(0.0F, 0.0F, -5.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(Righteyeridge, 0.32288591161895097F, 0.16929693744344995F, -1.1035716860360145F);
        this.HandRight = new MowzieModelRenderer(this, 91, 54);
        this.HandRight.setRotationPoint(-1.0F, 3.1F, 0.9F);
        this.HandRight.addBox(-1.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(HandRight, 0.14730578886832138F, -1.1238175053591488F, -0.19704767255015979F);
        this.HandLeftClawRight = new MowzieModelRenderer(this, 81, 45);
        this.HandLeftClawRight.setRotationPoint(-0.3F, 0.4F, -0.5F);
        this.HandLeftClawRight.addBox(-0.8F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(HandLeftClawRight, 0.008203047484373348F, 0.0F, -0.8628907821859966F);
        this.Tail1 = new MowzieModelRenderer(this, 118, 39);
        this.Tail1.setRotationPoint(0.0F, -8.6F, 4.0F);
        this.Tail1.addBox(-4.5F, 0.0F, -1.0F, 9, 12, 10, 0.0F);
        this.setRotateAngle(Tail1, 0.04258603374866164F, -0.0F, 0.0F);
        this.Righteyeridge2 = new MowzieModelRenderer(this, 21, 28);
        this.Righteyeridge2.setRotationPoint(-0.2F, 0.2F, -3.9F);
        this.Righteyeridge2.addBox(0.0F, 0.0F, -5.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(Righteyeridge2, -0.1689478715930511F, -0.14394272313290019F, 0.0F);
        this.LeftThigh = new MowzieModelRenderer(this, 52, 138);
        this.LeftThigh.setRotationPoint(4.5F, 1.8F, 5.0F);
        this.LeftThigh.addBox(0.0F, -4.0F, -11.0F, 5, 8, 14, 0.0F);
        this.setRotateAngle(LeftThigh, 1.284736862393026F, 0.0F, 0.0F);
        this.Righteyeridgerear = new MowzieModelRenderer(this, 0, 25);
        this.Righteyeridgerear.setRotationPoint(0.1F, 0.0F, -1.5F);
        this.Righteyeridgerear.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(Righteyeridgerear, -0.9512044423369095F, -0.5492551156026155F, 0.23841197582242543F);
        this.Neck3 = new MowzieModelRenderer(this, 218, 37);
        this.Neck3.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Neck3.addBox(-3.5F, 0.0F, -4.0F, 7, 8, 4, 0.0F);
        this.setRotateAngle(Neck3, 0.278554548618295F, -0.0F, 0.0F);
        this.stomach = new MowzieModelRenderer(this, 132, 1);
        this.stomach.setRotationPoint(0.0F, -8.6F, -5.5F);
        this.stomach.addBox(-5.5F, 0.0F, -9.0F, 11, 14, 9, 0.0F);
        this.setRotateAngle(stomach, 0.05183627878423159F, -0.0F, 0.0F);
        this.Lefteyeridgerear = new MowzieModelRenderer(this, 0, 40);
        this.Lefteyeridgerear.setRotationPoint(-0.9F, 0.2F, -1.0F);
        this.Lefteyeridgerear.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(Lefteyeridgerear, -0.9512044423369095F, 0.5492551156026155F, -0.23841197582242543F);
        this.HandLeftClawLeft = new MowzieModelRenderer(this, 81, 45);
        this.HandLeftClawLeft.setRotationPoint(-0.5F, 0.2F, 1.0F);
        this.HandLeftClawLeft.addBox(-0.8F, 0.5F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(HandLeftClawLeft, 0.0024434609527920616F, -0.020420352248333655F, -0.5098106745075436F);
        this.chest = new MowzieModelRenderer(this, 177, 1);
        this.chest.setRotationPoint(0.0F, 0.4F, -8.5F);
        this.chest.addBox(-4.5F, 0.0F, -8.0F, 9, 13, 8, 0.0F);
        this.setRotateAngle(chest, 0.07819075048934597F, -0.0F, 0.0F);
        this.Tail5 = new MowzieModelRenderer(this, 118, 126);
        this.Tail5.setRotationPoint(0.0F, 0.8F, 6.5F);
        this.Tail5.addBox(-2.0F, -0.5F, 1.0F, 4, 6, 13, 0.0F);
        this.setRotateAngle(Tail5, -0.06702064327658225F, -0.0F, 0.0F);
        this.Throat3 = new MowzieModelRenderer(this, 180, 48);
        this.Throat3.setRotationPoint(0.0F, 6.0F, -0.4F);
        this.Throat3.addBox(-3.0F, -0.15F, -5.3F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Throat3, -0.6166248247295966F, 0.0F, 0.0F);
        this.FootRight = new MowzieModelRenderer(this, 0, 209);
        this.FootRight.setRotationPoint(0.0F, 7.3F, 1.0F);
        this.FootRight.addBox(-2.5F, 0.0F, -6.0F, 5, 2, 7, 0.0F);
        this.setRotateAngle(FootRight, 0.5412266010434416F, -0.0F, 0.0F);
        this.Neck4 = new MowzieModelRenderer(this, 218, 56);
        this.Neck4.setRotationPoint(0.0F, 0.0F, -4.1F);
        this.Neck4.addBox(-3.5F, 0.0F, -4.0F, 7, 8, 4, 0.0F);
        this.setRotateAngle(Neck4, 0.30857421175259747F, -0.0F, 0.0F);
        this.FootLeft = new MowzieModelRenderer(this, 50, 209);
        this.FootLeft.setRotationPoint(0.0F, 7.3F, 1.0F);
        this.FootLeft.addBox(-2.5F, 0.0F, -6.0F, 5, 2, 7, 0.0F);
        this.setRotateAngle(FootLeft, 0.5412266010434416F, -0.0F, 0.0F);
        this.HandRightClawLeft = new MowzieModelRenderer(this, 81, 45);
        this.HandRightClawLeft.setRotationPoint(-0.5F, 0.2F, 0.0F);
        this.HandRightClawLeft.addBox(-0.8F, 0.5F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(HandRightClawLeft, 0.0024434609527920616F, -0.020420352248333655F, -0.5098106745075436F);
        this.UpperJaw = new MowzieModelRenderer(this, 37, 93);
        this.UpperJaw.setRotationPoint(0.0F, 6.8F, -7.8F);
        this.UpperJaw.addBox(-3.5F, -0.2F, 0.0F, 7, 6, 9, 0.0F);
        this.setRotateAngle(UpperJaw, 3.141592653589793F, -0.0F, 0.0F);
        this.Lefteyeridge = new MowzieModelRenderer(this, 12, 40);
        this.Lefteyeridge.setRotationPoint(5.6F, 0.2F, -3.4F);
        this.Lefteyeridge.addBox(-1.0F, 0.0F, -5.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(Lefteyeridge, 0.32288591161895097F, -0.16929693744344995F, 1.1035716860360145F);
        this.LowerArmRight = new MowzieModelRenderer(this, 12, 69);
        this.LowerArmRight.setRotationPoint(0.0F, 2.5F, 0.7F);
        this.LowerArmRight.addBox(-2.0F, 0.2F, -0.1F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LowerArmRight, -0.8100073058505682F, -0.0F, 0.0F);
        this.UpperArmLeft = new MowzieModelRenderer(this, 0, 68);
        this.UpperArmLeft.setRotationPoint(3.5F, 11.0F, -7.0F);
        this.UpperArmLeft.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(UpperArmLeft, 0.6724753607934152F, 0.21729349187329403F, 0.0F);
        this.HandRightClawRight = new MowzieModelRenderer(this, 81, 45);
        this.HandRightClawRight.setRotationPoint(-0.3F, 0.4F, 0.5F);
        this.HandRightClawRight.addBox(-0.8F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(HandRightClawRight, 0.008203047484373348F, 0.0F, -0.8628907821859966F);
        this.crest3 = new MowzieModelRenderer(this, 26, 51);
        this.crest3.setRotationPoint(1.0F, 0.4F, 1.0F);
        this.crest3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 6, 0.0F);
        this.setRotateAngle(crest3, -0.03316125578789226F, 0.0F, 0.0F);
        this.LowerJaw = new MowzieModelRenderer(this, 37, 112);
        this.LowerJaw.setRotationPoint(-0.5F, 6.5F, -7.3F);
        this.LowerJaw.addBox(-2.5F, -2.4F, 0.0F, 6, 2, 9, 0.0F);
        this.setRotateAngle(LowerJaw, 3.0731757469116157F, -0.0F, 0.0F);
        this.Teeth = new MowzieModelRenderer(this, 71, 111);
        this.Teeth.setRotationPoint(0.0F, 0.0F, -7.8F);
        this.Teeth.addBox(-3.5F, -9.0F, 0.0F, 7, 2, 9, 0.0F);
        this.setRotateAngle(Teeth, -3.141592653589793F, -0.0F, 0.0F);
        this.HandLeft = new MowzieModelRenderer(this, 81, 54);
        this.HandLeft.setRotationPoint(1.2F, 3.2F, 0.9F);
        this.HandLeft.addBox(-1.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(HandLeft, 0.14730578886832138F, -1.8743090837167105F, -0.19704767255015979F);
        this.RightCalf1 = new MowzieModelRenderer(this, 0, 166);
        this.RightCalf1.setRotationPoint(-2.5F, -2.8F, -10.5F);
        this.RightCalf1.addBox(-2.0F, 0.0F, 0.0F, 4, 10, 5, 0.0F);
        this.setRotateAngle(RightCalf1, -0.6564183316750672F, -0.0F, 0.0F);
        this.LeftCalf2 = new MowzieModelRenderer(this, 54, 190);
        this.LeftCalf2.setRotationPoint(0.0F, 7.8F, 3.5F);
        this.LeftCalf2.addBox(-1.5F, 0.0F, -1.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(LeftCalf2, -1.1667526049582093F, -0.0F, 0.0F);
        this.Lefteyeridge2 = new MowzieModelRenderer(this, 21, 40);
        this.Lefteyeridge2.setRotationPoint(-0.8F, 0.2F, -3.7F);
        this.Lefteyeridge2.addBox(0.0F, 0.0F, -5.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(Lefteyeridge2, -0.1689478715930511F, 0.187448361664191F, 0.0F);
        this.Righteyeridge3 = new MowzieModelRenderer(this, 37, 28);
        this.Righteyeridge3.setRotationPoint(-0.3F, 0.0F, -8.7F);
        this.Righteyeridge3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(Righteyeridge3, 0.0F, 0.07906341511534312F, 0.0F);
        this.UpperArmRight = new MowzieModelRenderer(this, 0, 57);
        this.UpperArmRight.setRotationPoint(-3.5F, 11.0F, -7.0F);
        this.UpperArmRight.addBox(-2.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(UpperArmRight, 0.6724753607934152F, -0.21729349187329403F, 0.0F);
        this.Neck1.addChild(this.Throat1);
        this.Tail3.addChild(this.Tail4);
        this.UpperJaw.addChild(this.crest1);
        this.UpperArmLeft.addChild(this.LowerArmLeft);
        this.chest.addChild(this.Neck1);
        this.Neck5.addChild(this.Head);
        this.crest1.addChild(this.crest2);
        this.LeftThigh.addChild(this.LeftCalf1);
        this.Tail1.addChild(this.Tail2);
        this.Neck4.addChild(this.Neck5);
        this.RightCalf1.addChild(this.RightCalf2);
        this.Tail2.addChild(this.Tail3);
        this.Neck1.addChild(this.Neck2);
        this.Neck3.addChild(this.Throat2);
        this.Lefteyeridge2.addChild(this.Lefteyeridge3);
        this.Tail5.addChild(this.Tail6);
        this.Head.addChild(this.Righteyeridge);
        this.LowerArmRight.addChild(this.HandRight);
        this.HandLeft.addChild(this.HandLeftClawRight);
        this.waist.addChild(this.Tail1);
        this.Righteyeridge.addChild(this.Righteyeridge2);
        this.Righteyeridge.addChild(this.Righteyeridgerear);
        this.Neck2.addChild(this.Neck3);
        this.waist.addChild(this.stomach);
        this.Lefteyeridge.addChild(this.Lefteyeridgerear);
        this.HandLeft.addChild(this.HandLeftClawLeft);
        this.stomach.addChild(this.chest);
        this.Tail4.addChild(this.Tail5);
        this.Neck5.addChild(this.Throat3);
        this.RightCalf2.addChild(this.FootRight);
        this.Neck3.addChild(this.Neck4);
        this.LeftCalf2.addChild(this.FootLeft);
        this.HandRight.addChild(this.HandRightClawLeft);
        this.Head.addChild(this.UpperJaw);
        this.Head.addChild(this.Lefteyeridge);
        this.UpperArmRight.addChild(this.LowerArmRight);
        this.chest.addChild(this.UpperArmLeft);
        this.HandRight.addChild(this.HandRightClawRight);
        this.crest2.addChild(this.crest3);
        this.Head.addChild(this.LowerJaw);
        this.Head.addChild(this.Teeth);
        this.LowerArmLeft.addChild(this.HandLeft);
        this.RightThigh.addChild(this.RightCalf1);
        this.LeftCalf1.addChild(this.LeftCalf2);
        this.Lefteyeridge.addChild(this.Lefteyeridge2);
        this.Righteyeridge2.addChild(this.Righteyeridge3);
        this.chest.addChild(this.UpperArmRight);

        this.tailParts = new MowzieModelRenderer[] { Tail6, Tail5, Tail4, Tail3, Tail2, Tail1 };
        this.bodyParts = new MowzieModelRenderer[] { Head, Neck5, Neck4, Neck3, Neck2, Neck1, chest, stomach, waist };
        this.leftArmParts = new MowzieModelRenderer[] { HandLeft, LowerArmLeft, UpperArmLeft };
        this.rightArmParts = new MowzieModelRenderer[] { HandRight, LowerArmRight, UpperArmRight };

        this.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.waist.render(f5);
        this.RightThigh.render(f5);
        this.LeftThigh.render(f5);
    }

    private void setRotateAngle(MowzieModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float ticks, float f3, float f4, float f5, EntityTyrannosaurus trex) {
        super.setRotationAngles(f, f1, ticks, f3, f4, f5, trex);
        this.resetToDefaultPose();

        // f = ticks;
        // f1 = (float) Math.cos(f/20)*0.25F + 0.5F;
        // f1 = 0.5F;

        if (!trex.isSitting()) {
            // Walking-dependent animation
            float globalSpeed = 0.45F;
            float globalDegree = 0.5F;
            float height = 1.0F;

            this.faceTarget(f3, f5, 3.0F, this.stomach, this.chest);
            this.faceTarget(f3, f4, 1.5F, this.Head, this.Neck1);

            this.bob(waist, 1F * globalSpeed, height, false, f, f1);
            this.bob(LeftThigh, 1F * globalSpeed, height, false, f, f1);
            this.bob(RightThigh, 1F * globalSpeed, height, false, f, f1);
            this.LeftThigh.rotationPointY -= -2 * f1 * Math.cos(f * 0.5 * globalSpeed);
            this.RightThigh.rotationPointY -= 2 * f1 * Math.cos(f * 0.5 * globalSpeed);
            this.walk(Neck1, 1F * globalSpeed, 0.15F, false, 0F, 0.2F, f, f1);
            this.walk(Head, 1F * globalSpeed, 0.15F, true, 0F, -0.2F, f, f1);

            this.walk(LeftThigh, 0.5F * globalSpeed, 0.8F * globalDegree, false, 0F, 0.4F, f, f1);
            this.walk(LeftCalf1, 0.5F * globalSpeed, 1F * globalDegree, true, 1F, 0.4F, f, f1);
            this.walk(LeftCalf2, 0.5F * globalSpeed, 1F * globalDegree, false, 0F, 0F, f, f1);
            this.walk(FootLeft, 0.5F * globalSpeed, 1.5F * globalDegree, true, 0.5F, 0.3F, f, f1);

            this.walk(RightThigh, 0.5F * globalSpeed, 0.8F * globalDegree, true, 0F, 0.4F, f, f1);
            this.walk(RightCalf1, 0.5F * globalSpeed, 1F * globalDegree, false, 1F, 0.4F, f, f1);
            this.walk(RightCalf2, 0.5F * globalSpeed, 1F * globalDegree, true, 0F, 0F, f, f1);
            this.walk(FootRight, 0.5F * globalSpeed, 1.5F * globalDegree, false, 0.5F, 0.3F, f, f1);

            this.chainWave(tailParts, 1F * globalSpeed, 0.05F, 2, f, f1);
            this.chainWave(bodyParts, 1F * globalSpeed, 0.05F, 3, f, f1);
            this.chainWave(leftArmParts, 1F * globalSpeed, 0.2F, 1, f, f1);
            this.chainWave(rightArmParts, 1F * globalSpeed, 0.2F, 1, f, f1);
        }

        // Sitting Pose
        float sittingProgress = trex.sittingProgress.getAnimationProgressSinSqrt();

        if (sittingProgress > 0.001F) {
            // Sitting Pose
            float sittingProgressFast = trex.sittingProgress.getAnimationProgressSinToTen();
            float restHeadProgress = trex.restingHeadProgress.getAnimationProgressSinSqrt();

            Head.rotateAngleY += ((f3 / (180f / (float) Math.PI)) / 2) * sittingProgress - (((f3 / (180f / (float) Math.PI)) / 2) * restHeadProgress);
            Neck1.rotateAngleY += ((f3 / (180f / (float) Math.PI)) / 2) * sittingProgress - (((f3 / (180f / (float) Math.PI)) / 2) * restHeadProgress);

            this.waist.rotationPointY += 17F * sittingProgress;
            this.RightThigh.rotationPointY += 15F * sittingProgress;
            this.LeftThigh.rotationPointY += 15F * sittingProgress;
            this.RightThigh.rotationPointZ += 5F * sittingProgress;
            this.LeftThigh.rotationPointZ += 5F * sittingProgress;

            this.UpperArmRight.rotationPointY -= 1F * sittingProgress;
            this.UpperArmLeft.rotationPointY -= 1F * sittingProgress;
            this.UpperArmRight.rotateAngleX += 0.25F * sittingProgress;
            this.UpperArmLeft.rotateAngleX += 0.25F * sittingProgress;
            this.LowerArmRight.rotateAngleX -= 1.4F * sittingProgress;
            this.LowerArmLeft.rotateAngleX -= 1.4F * sittingProgress;
            // this.LowerArmRight.rotationPointY -= 1F * sittingProgress;
            // this.LowerArmLeft.rotationPointY -= 1F * sittingProgress;
            // this.LowerArmRight.rotationPointZ -= 1F * sittingProgress;
            // this.LowerArmLeft.rotationPointZ -= 1F * sittingProgress;

            this.RightThigh.rotateAngleX -= 1.2F * sittingProgress;
            this.LeftThigh.rotateAngleX -= 1.2F * sittingProgress;

            this.RightCalf1.rotationPointY += 6.0F * sittingProgress;
            this.LeftCalf1.rotationPointY += 6.0F * sittingProgress;
            this.RightCalf1.rotateAngleX += 1.9F * sittingProgress;
            this.LeftCalf1.rotateAngleX += 1.9F * sittingProgress;

            this.RightCalf2.rotationPointY += 2.0F * sittingProgress;
            this.LeftCalf2.rotationPointY += 2.0F * sittingProgress;
            this.RightCalf2.rotateAngleX -= 1.4F * sittingProgress;
            this.LeftCalf2.rotateAngleX -= 1.4F * sittingProgress;

            this.FootRight.rotationPointY -= 2F * sittingProgress;
            this.FootLeft.rotationPointY -= 2F * sittingProgress;
            this.FootRight.rotateAngleX += 0.7F * sittingProgress;
            this.FootLeft.rotateAngleX += 0.7F * sittingProgress;

            this.Tail1.rotateAngleX -= 0.3F * sittingProgress;
            this.Tail2.rotateAngleX += 0.1F * sittingProgress;
            this.Tail3.rotateAngleX += 0.15F * sittingProgress;
            this.Tail4.rotateAngleX += 0.15F * sittingProgress;
            this.Tail4.rotationPointY += 0.5F * sittingProgress;
            walk(Tail1, 0.1F, 0.03F * sittingProgress - (0.03F * restHeadProgress), true, 1, 0, ticks, 0.4F);
            Tail1.rotationPointY += (0.1F * sittingProgress - (0.1F * restHeadProgress)) * Math.cos((ticks + 1) * 0.1);

            this.Neck1.rotationPointZ += 0.35F * restHeadProgress * Math.cos(ticks * 0.08);
            this.Neck1.rotateAngleX += 0.08F * restHeadProgress;
            this.Neck2.rotateAngleX += 0.1F * restHeadProgress;
            this.Neck3.rotateAngleX += 0.1F * restHeadProgress;
            this.Neck4.rotateAngleX -= 0.2F * restHeadProgress;
            this.Neck5.rotateAngleX -= 0.2F * restHeadProgress;
            this.Throat3.rotationPointZ += 2F * restHeadProgress;
            this.Throat2.rotationPointZ -= 1F * restHeadProgress;
            this.Head.rotateAngleX -= 0.2F * restHeadProgress;
            this.Head.rotationPointZ += 1F * restHeadProgress;
            this.chest.rotateAngleX += 0.15F * restHeadProgress;
            this.UpperArmRight.rotateAngleX += 0.3F * restHeadProgress;
            this.UpperArmLeft.rotateAngleX += 0.3F * restHeadProgress;
            this.LowerArmRight.rotateAngleX -= 0.3F * restHeadProgress;
            this.LowerArmLeft.rotateAngleX -= 0.3F * restHeadProgress;
            walk(waist, 0.08F, 0.04F * restHeadProgress, false, 0, 0, ticks, 1F);
            walk(Tail1, 0.08F, 0.04F * restHeadProgress, true, 0, 0, ticks, 1F);
            Tail1.rotationPointY += (0.2F * restHeadProgress) * Math.cos((ticks + 1) * 0.08);
            walk(chest, 0.08F, 0.08F * restHeadProgress, true, 0, 0, ticks, 1F);
            walk(Neck1, 0.08F, 0.005F * restHeadProgress, false, 0, 0, ticks, 1F);
            walk(Neck2, 0.08F, 0.005F * restHeadProgress, false, 0, 0, ticks, 1F);
            walk(Neck3, 0.08F, 0.005F * restHeadProgress, false, 0, 0, ticks, 1F);
            walk(Neck4, 0.08F, 0.005F * restHeadProgress, false, 0, 0, ticks, 1F);
            walk(Neck5, 0.08F, 0.005F * restHeadProgress, false, 0, 0, ticks, 1F);
            walk(Head, 0.08F, 0.02F * restHeadProgress, false, 0, 0, ticks, 1F);

            this.waist.rotateAngleX += 0.38F * (sittingProgress - sittingProgressFast);
            for (int i = 0; i < this.tailParts.length; i++) {
                this.tailParts[i].rotateAngleX += 0.15F * (sittingProgress - sittingProgressFast);
            }

            this.chainWave(bodyParts, 0.1F, -0.03F + (0.03F * restHeadProgress), 3, ticks, 1.0F - 0.6F * sittingProgress);
            this.chainWave(rightArmParts, -0.1F, 0.2F - (0.2F * restHeadProgress), 4, ticks, 1.0F - 0.6F * sittingProgress);
            this.chainWave(leftArmParts, -0.1F, 0.2F - (0.2F * restHeadProgress), 4, ticks, 1.0F - 0.6F * sittingProgress);
            this.chainWave(tailParts, 0.1F, -0.05F - (-0.05F * sittingProgress), 2, ticks, 1.0F - 0.6F * sittingProgress);
            this.chainSwing(tailParts, 0.1F, 0.05F - (0.05F * sittingProgress), 1, ticks, 1.0F - 0.6F * sittingProgress);
        } else {
            // Idling
            this.chainWave(bodyParts, 0.1F, -0.03F, 3, ticks, 1.0F);
            this.chainWave(rightArmParts, -0.1F, 0.2F, 4, ticks, 1.0F);
            this.chainWave(leftArmParts, -0.1F, 0.2F, 4, ticks, 1.0F);

            this.chainSwing(tailParts, 0.1F, 0.05F - (0.05F * sittingProgress), 1, ticks, 1.0F - 0.6F * sittingProgress);
            this.chainWave(tailParts, 0.1F, -0.05F - (-0.05F * sittingProgress), 2, ticks, 1.0F - 0.6F * sittingProgress);
        }

        // Specialized animations
        this.Head.rotateAngleZ += Math.cos(ticks / 3) * trex.roarTiltDegree.value / 3;
        this.LowerJaw.rotateAngleX += Math.cos(ticks) * trex.roarTiltDegree.value / 7;

        trex.tailBuffer.applyChainSwingBuffer(tailParts);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityTyrannosaurus) entity);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.ROAR.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.ROAR.animID());
            this.animator.startPhase(15);
            this.animator.move(waist, 0, -3, -5);
            this.animator.move(RightThigh, 0, -3, -5);
            this.animator.move(LeftThigh, 0, -3, -5);
            this.animator.rotate(waist, -0.3F, 0, 0);
            this.animator.rotate(Head, 0.3F, 0, 0);
            this.animator.rotate(RightThigh, 0.3F, 0, 0);
            this.animator.rotate(RightCalf1, -0.4F, 0, 0);
            this.animator.rotate(RightCalf2, 0.4F, 0, 0);
            this.animator.rotate(FootRight, -0.3F, 0, 0);
            this.animator.rotate(LeftThigh, -0.7F, 0, 0);
            this.animator.rotate(LeftCalf1, 0.7F, 0, 0);
            this.animator.rotate(LeftCalf2, -0.5F, 0, 0);
            this.animator.rotate(FootLeft, 0.7F, 0, 0);
            this.animator.endPhase();
            this.animator.startPhase(10);
            this.animator.move(waist, 0, 3, -10);
            this.animator.move(RightThigh, 0, 3, -10);
            this.animator.move(LeftThigh, 0, 3, -10);
            this.animator.move(Head, 0, 1, 2);
            this.animator.move(LowerJaw, 0, 0, 1);
            this.animator.rotate(waist, 0.2F, 0, 0);
            this.animator.rotate(Neck1, 0.2F, 0, 0);
            this.animator.rotate(Neck2, 0.2F, 0, 0);
            this.animator.rotate(Neck3, -0.2F, 0, 0);
            this.animator.rotate(Neck4, -0.1F, 0, 0);
            this.animator.rotate(Neck5, -0.1F, 0, 0);
            this.animator.move(Neck5, 0, 0, 1);
            this.animator.move(Throat1, 0, -0.5F, 0);
            this.animator.move(Throat2, 0, -1, 0);
            this.animator.move(Throat3, 0, -1, 0);
            this.animator.rotate(Head, -0.5F, 0, 0);
            this.animator.move(Head, 0, 1, 0);
            this.animator.rotate(LowerJaw, 0.9F, 0, 0);
            this.animator.rotate(RightThigh, 0.6F, 0, 0);
            this.animator.rotate(RightCalf1, 0.05F, 0, 0);
            this.animator.rotate(RightCalf2, -0.3F, 0, 0);
            this.animator.rotate(FootRight, -0.3F, 0, 0);
            this.animator.rotate(LeftThigh, -0.3F, 0, 0);
            this.animator.rotate(LeftCalf1, 0.2F, 0, 0);
            this.animator.rotate(LeftCalf2, -0.2F, 0, 0);
            this.animator.rotate(FootLeft, 0.3F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(35);
            this.animator.resetPhase(15);
        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.WALK_ROAR.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.WALK_ROAR.animID());
            this.animator.startPhase(15);
            this.animator.rotate(waist, -0.2F, 0, 0);
            this.animator.rotate(stomach, -0.1F, 0, 0);
            this.animator.rotate(chest, 0.1F, 0, 0);
            this.animator.rotate(Neck1, -0.1F, 0, 0);
            this.animator.rotate(Neck2, -0.1F, 0, 0);
            this.animator.rotate(Neck3, 0.1F, 0, 0);
            this.animator.rotate(Neck4, 0.1F, 0, 0);
            this.animator.rotate(Neck5, 0.1F, 0, 0);
            this.animator.rotate(Head, 0.3F, 0, 0);
            this.animator.endPhase();
            this.animator.startPhase(10);
            animator.rotate(waist, 0.1F, 0, 0);
            this.animator.rotate(Neck1, 0.2F, 0, 0);
            this.animator.rotate(Neck2, 0.2F, 0, 0);
            this.animator.rotate(Neck3, 0.1F, 0, 0);
            this.animator.rotate(Neck4, -0.2F, 0, 0);
            this.animator.rotate(Neck5, -0.2F, 0, 0);
            animator.move(Throat1, 0, 0, 0);
            animator.move(Throat2, 0, -1, -3.5F);
            animator.move(Throat3, 0, -1.5F, 0);
            this.animator.rotate(Head, -0.4F, 0, 0);
            this.animator.move(Head, 0, 1, 2F);
            this.animator.rotate(LowerJaw, 0.8F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(35);
            this.animator.resetPhase(15);
        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.EATING.animID()) {
            float shakeProgress = ((EntityTyrannosaurus) entity).shakePrey.getAnimationProgressSinSqrt();
            chainSwing(bodyParts, 0.6F, 0.2F * shakeProgress, 1, ((EntityTyrannosaurus) entity).frame, 1F);
            chainSwing(tailParts, 0.6F, -0.2F * shakeProgress, 3, ((EntityTyrannosaurus) entity).frame, 1F);
            waist.rotateAngleX += 0.3 * shakeProgress;
            Head.rotateAngleX -= 0.3 * shakeProgress;
            this.animator.setAnimation(JurassiCraftAnimationIDs.EATING.animID());
            this.animator.startPhase(0);
            this.animator.rotate(LowerJaw, 0.3F, 0.0F, 0.0F);
            animator.endPhase();
            animator.setStationaryPhase(30);
            this.animator.startPhase(7);
            this.animator.rotate(LowerJaw, 0.4F, 0.0F, 0.0F);
            this.animator.rotate(Neck1, -0.4F, 0.0F, 0.0F);
            this.animator.rotate(Head, -0.4F, 0.0F, 0.0F);
            animator.endPhase();
            animator.setStationaryPhase(3);
            animator.resetPhase(10);
        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.BITE.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.BITE.animID());
            this.animator.startPhase(6);
            this.animator.rotate(Neck1, -0.1F, -0.2F, 0);
            this.animator.rotate(Head, -0.2F, -0.3F, 0);
            this.animator.rotate(waist, -0.1F, -0.2F, 0);
            this.animator.rotate(LowerJaw, 1F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.startPhase(3);
            this.animator.rotate(Neck1, 0.2F, 0.1F, 0);
            this.animator.rotate(Neck2, 0.2F, 0.1F, 0);
            this.animator.rotate(Neck3, 0.1F, 0.1F, 0);
            this.animator.rotate(Neck4, -0.2F, 0.1F, 0);
            this.animator.rotate(Neck5, -0.2F, 0.1F, 0);
            animator.move(Throat2, 0, 0, -2.7F);
            animator.move(Throat3, 0, 0, 1.5F);
            this.animator.rotate(Head, -0.2F, 0.4F, 0);
            this.animator.rotate(waist, 0.2F, 0.2F, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(2);
            this.animator.resetPhase(8);
        }
    }
}
