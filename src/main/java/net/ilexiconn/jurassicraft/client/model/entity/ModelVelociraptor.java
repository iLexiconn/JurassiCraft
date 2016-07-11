package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVelociraptor extends MowzieModelBase {
    public MowzieModelRenderer Leftthigh;
    public MowzieModelRenderer Rightthigh;
    public MowzieModelRenderer body3;
    public MowzieModelRenderer Leftshin;
    public MowzieModelRenderer Leftupperfoot;
    public MowzieModelRenderer Leftfoot;
    public MowzieModelRenderer Lefttoe;
    public MowzieModelRenderer Lefttoeclaw1;
    public MowzieModelRenderer Lefttoeclaw2;
    public MowzieModelRenderer Rightshin;
    public MowzieModelRenderer Rightupperfoot;
    public MowzieModelRenderer Rightfoot;
    public MowzieModelRenderer Righttoe;
    public MowzieModelRenderer Righttoeclaw1;
    public MowzieModelRenderer Righttoeclaw2;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer body2;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer tail4;
    public MowzieModelRenderer tail5;
    public MowzieModelRenderer tail6;
    public MowzieModelRenderer body1;
    public MowzieModelRenderer Leftarm;
    public MowzieModelRenderer Rightarm;
    public MowzieModelRenderer neck1;
    public MowzieModelRenderer neck2;
    public MowzieModelRenderer neck3;
    public MowzieModelRenderer neck4;
    public MowzieModelRenderer Underneck;
    public MowzieModelRenderer neck5;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer JawUpper;
    public MowzieModelRenderer down_jaw;
    public MowzieModelRenderer Teeth;
    public MowzieModelRenderer Snoutridgemain;
    public MowzieModelRenderer Leftforearm;
    public MowzieModelRenderer Lefthand;
    public MowzieModelRenderer claw6;
    public MowzieModelRenderer claw5;
    public MowzieModelRenderer claw4;
    public MowzieModelRenderer Rightforearm;
    public MowzieModelRenderer Righthand;
    public MowzieModelRenderer claw3;
    public MowzieModelRenderer claw2;
    public MowzieModelRenderer claw1;
    private Animator animator;

    public ModelVelociraptor() {
        this.animator = new Animator(this);

        this.textureWidth = 135;
        this.textureHeight = 100;
        this.Rightshin = new MowzieModelRenderer(this, 2, 22);
        this.Rightshin.mirror = true;
        this.Rightshin.setRotationPoint(-2.0F, -2.2F, -6.9F);
        this.Rightshin.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(Rightshin, -0.6410594342575172F, 0.0F, 0.0F);
        this.body3 = new MowzieModelRenderer(this, 4, 80);
        this.body3.setRotationPoint(0.0F, 8.1F, 0.5F);
        this.body3.addBox(-4.0F, -5.0F, -5.9F, 8, 9, 10, 0.0F);
        this.setRotateAngle(body3, -0.136659280431156F, 0.0F, 0.0F);
        this.Leftupperfoot = new MowzieModelRenderer(this, 40, 24);
        this.Leftupperfoot.setRotationPoint(0.0F, 7.0F, 2.5F);
        this.Leftupperfoot.addBox(-1.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Leftupperfoot, -0.9707521299592461F, 0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 0, 8);
        this.Head.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Head.addBox(-2.5F, 0.0F, -6.0F, 5, 6, 6, 0.0F);
        this.setRotateAngle(Head, 0.5462880558742251F, 0.0F, 0.0F);
        this.Righttoeclaw2 = new MowzieModelRenderer(this, 66, 8);
        this.Righttoeclaw2.mirror = true;
        this.Righttoeclaw2.setRotationPoint(0.0F, 0.5F, -1.2F);
        this.Righttoeclaw2.addBox(-1.5F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Righttoeclaw2, -2.1331414117874696F, -0.0F, 0.0F);
        this.Leftarm = new MowzieModelRenderer(this, 118, 3);
        this.Leftarm.setRotationPoint(3.5F, 5.0F, -6.5F);
        this.Leftarm.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Leftarm, 0.5235987755982988F, 0.22689280275926282F, -0.08726646259971647F);
        this.Underneck = new MowzieModelRenderer(this, 67, 58);
        this.Underneck.setRotationPoint(0.0F, 5.1F, -3.6F);
        this.Underneck.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotateAngle(Underneck, 0.27314402793711257F, 0.0F, 0.0F);
        this.Lefttoe = new MowzieModelRenderer(this, 45, 14);
        this.Lefttoe.mirror = true;
        this.Lefttoe.setRotationPoint(-1.0F, -1.096331826968754F, 0.4024389806475021F);
        this.Lefttoe.addBox(-1.5F, 0.0F, -3.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(Lefttoe, -0.742986662573986F, 0.0F, 0.0F);
        this.Righttoeclaw1 = new MowzieModelRenderer(this, 66, 8);
        this.Righttoeclaw1.mirror = true;
        this.Righttoeclaw1.setRotationPoint(0.0F, 0.1F, -2.7F);
        this.Righttoeclaw1.addBox(-1.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Righttoeclaw1, -0.15184364492350666F, 0.0F, 0.0F);
        this.body1 = new MowzieModelRenderer(this, 76, 89);
        this.body1.setRotationPoint(0.0F, 1.5F, -6.2F);
        this.body1.addBox(-3.0F, 0.0F, -3.0F, 6, 6, 5, 0.0F);
        this.setRotateAngle(body1, -0.5918411493512771F, 0.0F, 0.0F);
        this.Lefthand = new MowzieModelRenderer(this, 120, 22);
        this.Lefthand.setRotationPoint(0.0F, 5.5F, -1.5F);
        this.Lefthand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Lefthand, 1.1344640137963142F, -0.3141592653589793F, -0.22689280275926282F);
        this.claw2 = new MowzieModelRenderer(this, 0, 0);
        this.claw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw2.addBox(-0.5F, 1.0F, -1.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(claw2, 0.26616271092913524F, 0.0F, 0.0F);
        this.claw3 = new MowzieModelRenderer(this, 9, 0);
        this.claw3.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.claw3.addBox(-0.5F, 1.0F, -1.2F, 1, 2, 1, 0.0F);
        this.setRotateAngle(claw3, 0.2659881780039358F, 0.04258603374866164F, -0.40264745843509187F);
        this.tail6 = new MowzieModelRenderer(this, 110, 69);
        this.tail6.setRotationPoint(0.0F, 0.2F, 8.7F);
        this.tail6.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 9, 0.0F);
        this.setRotateAngle(tail6, -0.045553093477052F, 0.0F, 0.0F);
        this.Rightarm = new MowzieModelRenderer(this, 107, 3);
        this.Rightarm.setRotationPoint(-3.5F, 5.0F, -6.5F);
        this.Rightarm.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Rightarm, 0.5235987755982988F, -0.22689280275926282F, 0.08726646259971647F);
        this.Snoutridgemain = new MowzieModelRenderer(this, 95, 62);
        this.Snoutridgemain.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.Snoutridgemain.addBox(-1.5F, 0.0F, -1.0F, 3, 6, 1, 0.0F);
        this.setRotateAngle(Snoutridgemain, 1.6669639685797841F, 0.0F, 0.0F);
        this.Leftforearm = new MowzieModelRenderer(this, 119, 12);
        this.Leftforearm.setRotationPoint(-0.2F, 6.0F, 0.6F);
        this.Leftforearm.addBox(-1.01F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Leftforearm, -1.3264502315156905F, 0.19198621771937624F, 0.08726646259971647F);
        this.body2 = new MowzieModelRenderer(this, 43, 83);
        this.body2.setRotationPoint(0.0F, -4.8F, -5.9F);
        this.body2.addBox(-3.5F, 0.0F, -8.0F, 7, 8, 8, 0.0F);
        this.setRotateAngle(body2, 0.18203784098300857F, 0.0F, 0.0F);
        this.neck3 = new MowzieModelRenderer(this, 41, 70);
        this.neck3.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.neck3.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(neck3, 0.18203784098300857F, 0.0F, 0.0F);
        this.neck5 = new MowzieModelRenderer(this, 57, 70);
        this.neck5.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.neck5.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(neck5, 0.27314402793711257F, 0.0F, 0.0F);
        this.Leftshin = new MowzieModelRenderer(this, 16, 22);
        this.Leftshin.setRotationPoint(2.0F, -2.2F, -6.9F);
        this.Leftshin.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(Leftshin, -0.6410594342575172F, 0.0F, 0.0F);
        this.Leftfoot = new MowzieModelRenderer(this, 42, 3);
        this.Leftfoot.setRotationPoint(1.0F, 5.437337731674955F, -0.6395975253653364F);
        this.Leftfoot.addBox(-1.5F, -0.9999970147507714F, -3.497556541478655F, 2, 2, 5, 0.0F);
        this.setRotateAngle(Leftfoot, 0.4363323129985824F, 0.0F, 0.0F);
        this.Lefttoeclaw1 = new MowzieModelRenderer(this, 66, 8);
        this.Lefttoeclaw1.mirror = true;
        this.Lefttoeclaw1.setRotationPoint(0.0F, 0.1F, -2.7F);
        this.Lefttoeclaw1.addBox(-1.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Lefttoeclaw1, -0.15184364492350666F, 0.0F, 0.0F);
        this.Righttoe = new MowzieModelRenderer(this, 29, 14);
        this.Righttoe.mirror = true;
        this.Righttoe.setRotationPoint(2.0F, -1.096331826968754F, 0.4024389806475021F);
        this.Righttoe.addBox(-1.5F, 0.0F, -3.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(Righttoe, -0.742986662573986F, 0.0F, 0.0F);
        this.neck1 = new MowzieModelRenderer(this, 3, 69);
        this.neck1.setRotationPoint(0.0F, 1.4F, -0.2F);
        this.neck1.addBox(-2.5F, 0.0F, -5.0F, 5, 5, 4, 0.0F);
        this.setRotateAngle(neck1, -0.3792600464583678F, 0.0F, 0.0F);
        this.down_jaw = new MowzieModelRenderer(this, 89, 73);
        this.down_jaw.setRotationPoint(0.0F, 5.2F, -5.5F);
        this.down_jaw.addBox(-1.5F, -0.5F, -6.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(down_jaw, -0.04328416544945937F, 0.0F, 0.0F);
        this.claw5 = new MowzieModelRenderer(this, 0, 0);
        this.claw5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw5.addBox(-0.5F, 1.0F, -1.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(claw5, 0.2668608426299329F, 0.0F, 0.0F);
        this.claw4 = new MowzieModelRenderer(this, 9, 0);
        this.claw4.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.claw4.addBox(-0.5F, 1.0F, -1.2F, 1, 2, 1, 0.0F);
        this.setRotateAngle(claw4, 0.26529004630313807F, 0.04258603374866164F, 0.40194932673429407F);
        this.Lefttoeclaw2 = new MowzieModelRenderer(this, 66, 8);
        this.Lefttoeclaw2.mirror = true;
        this.Lefttoeclaw2.setRotationPoint(0.0F, 0.5F, -1.2F);
        this.Lefttoeclaw2.addBox(-1.5F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Lefttoeclaw2, -2.132792345937071F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 65, 35);
        this.tail3.setRotationPoint(0.0F, 0.2F, 8.1F);
        this.tail3.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
        this.setRotateAngle(tail3, -0.045553093477052F, 0.0F, 0.0F);
        this.claw1 = new MowzieModelRenderer(this, 9, 0);
        this.claw1.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.claw1.addBox(-0.5F, 1.0F, -1.2F, 1, 2, 1, 0.0F);
        this.setRotateAngle(claw1, 0.26616271092913524F, 0.045727626402251434F, 0.40980330836826856F);
        this.Rightupperfoot = new MowzieModelRenderer(this, 30, 24);
        this.Rightupperfoot.setRotationPoint(0.0F, 7.0F, 2.5F);
        this.Rightupperfoot.addBox(-1.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Rightupperfoot, -0.9707521299592461F, 0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 32, 34);
        this.tail2.setRotationPoint(0.0F, 0.2F, 7.6F);
        this.tail2.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 9, 0.0F);
        this.setRotateAngle(tail2, -0.045553093477052F, 0.0F, 0.0F);
        this.Teeth = new MowzieModelRenderer(this, 77, 18);
        this.Teeth.setRotationPoint(0.0F, 2.7F, -5.9F);
        this.Teeth.addBox(-2.0F, 2.0F, -6.0F, 4, 1, 6, 0.0F);
        this.Leftthigh = new MowzieModelRenderer(this, 30, 53);
        this.Leftthigh.setRotationPoint(2.0F, 8.1F, 0.5F);
        this.Leftthigh.addBox(0.0F, -2.5F, -7.0F, 4, 5, 9, 0.0F);
        this.setRotateAngle(Leftthigh, 1.177922712170973F, 0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 0, 36);
        this.tail1.setRotationPoint(0.0F, -4.6F, 1.7F);
        this.tail1.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 8, 0.0F);
        this.setRotateAngle(tail1, 0.31869712141416456F, 0.0F, 0.0F);
        this.tail5 = new MowzieModelRenderer(this, 110, 52);
        this.tail5.setRotationPoint(0.0F, 0.2F, 8.7F);
        this.tail5.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 9, 0.0F);
        this.setRotateAngle(tail5, -0.045553093477052F, 0.0F, 0.0F);
        this.neck4 = new MowzieModelRenderer(this, 57, 70);
        this.neck4.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.neck4.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(neck4, 0.27314402793711257F, 0.0F, 0.0F);
        this.Righthand = new MowzieModelRenderer(this, 112, 22);
        this.Righthand.setRotationPoint(0.0F, 5.5F, -1.5F);
        this.Righthand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Righthand, 1.1344640137963142F, 0.3141592653589793F, 0.22689280275926282F);
        this.Rightforearm = new MowzieModelRenderer(this, 107, 12);
        this.Rightforearm.setRotationPoint(0.2F, 6.0F, 0.6F);
        this.Rightforearm.addBox(-0.99F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(Rightforearm, -1.3264502315156905F, -0.19198621771937624F, -0.08726646259971647F);
        this.tail4 = new MowzieModelRenderer(this, 95, 34);
        this.tail4.setRotationPoint(0.0F, 0.2F, 8.0F);
        this.tail4.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 9, 0.0F);
        this.setRotateAngle(tail4, -0.045553093477052F, 0.0F, 0.0F);
        this.claw6 = new MowzieModelRenderer(this, 9, 0);
        this.claw6.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.claw6.addBox(-0.5F, 1.0F, -1.3F, 1, 2, 1, 0.0F);
        this.setRotateAngle(claw6, 0.2668608426299329F, -0.045553093477052F, -0.40980330836826856F);
        this.Rightthigh = new MowzieModelRenderer(this, 2, 53);
        this.Rightthigh.mirror = true;
        this.Rightthigh.setRotationPoint(-2.0F, 8.1F, 0.5F);
        this.Rightthigh.addBox(-4.0F, -2.5F, -7.0F, 4, 5, 9, 0.0F);
        this.setRotateAngle(Rightthigh, 1.177922712170973F, 0.0F, 0.0F);
        this.neck2 = new MowzieModelRenderer(this, 24, 70);
        this.neck2.setRotationPoint(0.0F, 0.1F, -3.6F);
        this.neck2.addBox(-2.0F, 0.0F, -3.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(neck2, -0.273318560862312F, 0.0F, 0.0F);
        this.JawUpper = new MowzieModelRenderer(this, 57, 18);
        this.JawUpper.setRotationPoint(0.0F, 2.7F, -5.9F);
        this.JawUpper.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
        this.Rightfoot = new MowzieModelRenderer(this, 25, 3);
        this.Rightfoot.mirror = true;
        this.Rightfoot.setRotationPoint(0.0F, 5.437337731674955F, -0.6395975253653364F);
        this.Rightfoot.addBox(-1.5F, -0.9999970147507714F, -3.497556541478655F, 2, 2, 5, 0.0F);
        this.setRotateAngle(Rightfoot, 0.4363323129985824F, 0.0F, 0.0F);
        this.Rightthigh.addChild(this.Rightshin);
        this.Leftshin.addChild(this.Leftupperfoot);
        this.neck5.addChild(this.Head);
        this.Righttoeclaw1.addChild(this.Righttoeclaw2);
        this.body2.addChild(this.Leftarm);
        this.neck4.addChild(this.Underneck);
        this.Leftfoot.addChild(this.Lefttoe);
        this.Righttoe.addChild(this.Righttoeclaw1);
        this.body2.addChild(this.body1);
        this.Leftforearm.addChild(this.Lefthand);
        this.Righthand.addChild(this.claw2);
        this.Righthand.addChild(this.claw3);
        this.tail5.addChild(this.tail6);
        this.body2.addChild(this.Rightarm);
        this.JawUpper.addChild(this.Snoutridgemain);
        this.Leftarm.addChild(this.Leftforearm);
        this.body3.addChild(this.body2);
        this.neck2.addChild(this.neck3);
        this.neck4.addChild(this.neck5);
        this.Leftthigh.addChild(this.Leftshin);
        this.Leftupperfoot.addChild(this.Leftfoot);
        this.Lefttoe.addChild(this.Lefttoeclaw1);
        this.Rightfoot.addChild(this.Righttoe);
        this.body1.addChild(this.neck1);
        this.Head.addChild(this.down_jaw);
        this.Lefthand.addChild(this.claw5);
        this.Lefthand.addChild(this.claw4);
        this.Lefttoeclaw1.addChild(this.Lefttoeclaw2);
        this.tail2.addChild(this.tail3);
        this.Righthand.addChild(this.claw1);
        this.Rightshin.addChild(this.Rightupperfoot);
        this.tail1.addChild(this.tail2);
        this.Head.addChild(this.Teeth);
        this.body3.addChild(this.tail1);
        this.tail4.addChild(this.tail5);
        this.neck3.addChild(this.neck4);
        this.Rightforearm.addChild(this.Righthand);
        this.Rightarm.addChild(this.Rightforearm);
        this.tail3.addChild(this.tail4);
        this.Lefthand.addChild(this.claw6);
        this.neck1.addChild(this.neck2);
        this.Head.addChild(this.JawUpper);
        this.Rightupperfoot.addChild(this.Rightfoot);

        this.updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);

        this.body3.render(f5);
        this.Leftthigh.render(f5);
        this.Rightthigh.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float rotation, float rotationYaw, float rotationPitch, float partialTicks, Entity entity) {
        this.resetToDefaultPose();

        MowzieModelRenderer[] rightArmParts = new MowzieModelRenderer[] { Righthand, Rightforearm, Rightarm };
        MowzieModelRenderer[] leftArmParts = new MowzieModelRenderer[] { Lefthand, Leftforearm, Leftarm };
        MowzieModelRenderer[] tailParts = new MowzieModelRenderer[] { tail6, tail5, tail4, tail3, tail2, tail1 };
        MowzieModelRenderer[] bodyParts = new MowzieModelRenderer[] { body3, body2, body1, neck4, neck3, neck2, neck1, Head };

        int frame = entity.ticksExisted;

        float speed = 0.75F;
        float height = 2F * f1;

        // float dontLeanProgress = ((EntityVelociraptor) entity).dontLean.getAnimationProgressSinSqrt();

        bob(body3, 1F * speed, height, false, f, f1);
        bob(Leftthigh, 1F * speed, height, false, f, f1);
        bob(Rightthigh, 1F * speed, height, false, f, f1);
        walk(body1, 1F * speed, 0.2F, true, 1, 0, f, f1);
        walk(body2, 1F * speed, 0.2F, false, 0.5F, 0, f, f1);

        walk(Leftthigh, 0.5F * speed, 0.7F, false, 3.14F, 0.2F, f, f1);
        walk(Leftshin, 0.5F * speed, 0.6F, false, 1.5F, 0.3F, f, f1);
        walk(Leftupperfoot, 0.5F * speed, 0.8F, false, -1F, -0.1F, f, f1);
        walk(Leftfoot, 0.5F * speed, 1.5F, true, -1F, 1F, f, f1);

        walk(Rightthigh, 0.5F * speed, 0.7F, true, 3.14F, 0.2F, f, f1);
        walk(Rightshin, 0.5F * speed, 0.6F, true, 1.5F, 0.3F, f, f1);
        walk(Rightupperfoot, 0.5F * speed, 0.8F, true, -1F, -0.1F, f, f1);
        walk(Rightfoot, 0.5F * speed, 1.5F, false, -1F, 1F, f, f1);

//        body1.rotationPointY -= 0.5 * f1 * dontLeanProgress;
//        body1.rotationPointZ -= 0.5 * f1 * dontLeanProgress;
//        body1.rotateAngleX += 0.6 * f1 * dontLeanProgress;
//        body2.rotateAngleX += 0.1 * f1 * dontLeanProgress;
//        neck1.rotateAngleX += 0.1 * f1 * dontLeanProgress;
//        neck2.rotateAngleX += 0.1 * f1 * dontLeanProgress;
//        neck3.rotateAngleX -= 0.2 * f1 * dontLeanProgress;
//        neck4.rotateAngleX -= 0.2 * f1 * dontLeanProgress;
//        Head.rotateAngleX -= 0.3 * f1 * dontLeanProgress;

        chainSwing(tailParts, 0.5F * speed, -0.1F, 2, f, f1);
        chainWave(tailParts, 1F * speed, -0.1F, 2.5F, f, f1);
        chainWave(bodyParts, 1F * speed, -0.1F, 4, f, f1);

        chainWave(rightArmParts, 1F * speed, -0.3F, 4, f, f1);
        chainWave(leftArmParts, 1F * speed, -0.3F, 4, f, f1);

        // Idling
        chainWave(tailParts, 0.1F, 0.05F, 2, entity.ticksExisted, 1F);
        chainWave(bodyParts, 0.1F, -0.03F, 5, entity.ticksExisted, 1F);
        chainWave(rightArmParts, 0.1F, -0.1F, 4, entity.ticksExisted, 1F);
        chainWave(leftArmParts, 0.1F, -0.1F, 4, entity.ticksExisted, 1F);

        faceTarget(rotationYaw, rotationPitch, 1.0F, Head, neck1);

        ((EntityVelociraptor) entity).tailBuffer.applyChainSwingBuffer(tailParts);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityVelociraptor) entity);

        //Call
        if (entity.getAnimationId() == JurassiCraftAnimationIDs.ROAR.animID()) {
            animator.setAnimation(JurassiCraftAnimationIDs.ROAR.animID());
            animator.startPhase(2);
            animator.rotate(body1, -0.3f, 0, 0);
            animator.move(body1, 0, 0.5f, 0.2f);
            animator.rotate(neck1, -0.2f, 0, 0);
            animator.move(neck1, 0, 0.5f, -0.2f);
            animator.rotate(neck2, -0.2f, 0, 0);
            animator.move(neck2, 0, 0, -0.3f);
            animator.rotate(neck3, 0.1f, 0, 0);
            animator.move(neck3, 0, 0, -0.2f);
            animator.rotate(neck4, 0.2f, 0, 0);
            animator.move(neck4, 0, 0, -0.2f);
            animator.rotate(Head, 0.4f, 0, 0);
            animator.move(Head, 0, 0, -0.2f);
            animator.endPhase();
            animator.startPhase(5);
            animator.rotate(body1, 0.4f, 0, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.3f, 0, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.2f, 0, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.1f, 0, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.1f, 0, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.7f, 0, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.rotate(down_jaw, 0.4f, 0, 0);
            animator.endPhase();
            animator.setStationaryPhase(10);
            animator.resetPhase(8);
        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.TWITCH_HEAD.animID()) {
            //Twitch right
            animator.setAnimation(JurassiCraftAnimationIDs.TWITCH_HEAD.animID());
            animator.startPhase(3);
            animator.rotate(Head, 0, 0, 0.3f);
            animator.move(Head, 1, 0, 0);
            animator.endPhase();
            animator.setStationaryPhase(19);
            animator.resetPhase(3);
        }

//        if (entity.getAnimationId() == 11)
//        {
//            //Twitch left
//            animator.setAnimation(11);
//            animator.startPhase(3);
//            animator.rotate(Head, 0, 0, -0.3f);
//            animator.move(Head, -1, 0, 0);
//            animator.endPhase();
//            animator.setStationaryPhase(19);
//            animator.resetPhase(3);
//        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.SNIFF.animID()) {
            animator.setAnimation(JurassiCraftAnimationIDs.SNIFF.animID());
            animator.startPhase(8);
            animator.rotate(body1, 0.5f, 0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, 0.2f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, 0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, 0.3f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.3f, 0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.6f, 0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();
        }

        if (entity.getAnimationId() == 1) {
            animator.startPhase(1);
            animator.rotate(body1, 0.5f, 0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, 0.2f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, 0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, 0.3f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.35f, 0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.65f, 0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();
            animator.setStationaryPhase(1);
            animator.startPhase(1);
            animator.rotate(body1, 0.5f, 0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, 0.2f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, 0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, 0.3f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.3f, 0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.6f, 0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();
            animator.setStationaryPhase(1);
            animator.startPhase(1);
            animator.rotate(body1, 0.5f, 0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, 0.2f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, 0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, 0.3f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.35f, 0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.65f, 0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();
            animator.setStationaryPhase(1);
            animator.startPhase(2);
            animator.rotate(body1, 0.5f, 0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, 0.2f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, 0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, 0.3f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.3f, 0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.6f, 0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();

            animator.setStationaryPhase(3);

            animator.startPhase(8);
            animator.rotate(body1, 0.5f, -0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, -0.1f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, -0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, -0.2f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.3f, -0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.6f, -0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();

            animator.startPhase(2);
            animator.rotate(body1, 0.5f, -0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, -0.1f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, -0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, -0.2f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.35f, -0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.65f, -0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();
            animator.setStationaryPhase(1);
            animator.startPhase(2);
            animator.rotate(body1, 0.5f, -0.1f, 0);
            animator.move(body1, 0, -1, -0.5f);
            animator.rotate(neck1, 0.4f, -0.1f, 0);
            animator.move(neck1, 0, -1, 0.5f);
            animator.rotate(neck2, 0.3f, -0.2f, 0);
            animator.move(neck2, 0, 0, 0.5f);
            animator.rotate(neck3, -0.2f, -0.2f, 0);
            animator.move(neck3, 0, 0, 0.5f);
            animator.rotate(neck4, -0.3f, -0.3f, 0);
            animator.move(neck4, 0, 0, 0.5f);
            animator.rotate(Head, -0.6f, -0.3f, 0);
            animator.move(Head, 0, 0, 0.5f);
            animator.endPhase();

            animator.setStationaryPhase(5);

            animator.resetPhase(8);

        }

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.LEAP.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.LEAP.animID());
            this.animator.startPhase(5);
            this.animator.move(body1, 0, 3, 0);
            this.animator.rotate(body1, 0.5F, 0, 0);
            this.animator.rotate(tail1, 0.4F, 0, 0);
            this.animator.move(tail1, 0, 0, -2);
            this.animator.rotate(neck1, -0.5F, 0, 0);
            this.animator.move(Rightthigh, 0, 3, 0);
            this.animator.move(Leftthigh, 0, 3, 0);
            this.animator.rotate(Rightthigh, -0.2F, 0.4F, 0);
            this.animator.rotate(Leftthigh, -0.2F, -0.4F, 0);
            this.animator.rotate(Rightshin, 0.2F, 0, 0);
            this.animator.rotate(Leftshin, 0.2F, 0, 0);
            this.animator.rotate(Rightupperfoot, -0.2F, 0, 0);
            this.animator.rotate(Leftupperfoot, -0.2F, 0, 0);
            this.animator.rotate(Rightfoot, 0.2F, 0, 0);
            this.animator.rotate(Leftfoot, 0.2F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(5);
            this.animator.startPhase(4);
            this.animator.move(body1, 0, -3, 0);
            this.animator.move(tail1, 0, 0, 0);
            this.animator.rotate(tail1, -0.4F, 0, 0);
            this.animator.move(Rightthigh, 0, -3, 0);
            this.animator.move(Leftthigh, 0, -3, 0);
            this.animator.rotate(Rightthigh, 1F, 0, 0);
            this.animator.rotate(Leftthigh, 1F, 0, 0);
            this.animator.rotate(Rightshin, -1F, 0, 0);
            this.animator.rotate(Leftshin, -1F, 0, 0);
            this.animator.rotate(Rightupperfoot, 1F, 0, 0);
            this.animator.rotate(Leftupperfoot, 1F, 0, 0);
            this.animator.rotate(Rightfoot, -1F, 0, 0);
            this.animator.rotate(Leftfoot, -1F, 0, 0);
            this.animator.endPhase();
            this.animator.startPhase(2);
            this.animator.rotate(body1, -0.8F, 0, 0);
            this.animator.rotate(neck1, 0.8F, 0, 0);
            this.animator.rotate(Head, 0.5F, 0, 0);
            this.animator.rotate(down_jaw, 0.7F, 0, 0);
            this.animator.move(tail1, 0, 0, -2);
            this.animator.rotate(tail1, 0.7F, 0, 0);
            this.animator.move(neck1, 0, -2, -3);
            this.animator.rotate(Rightthigh, -1.2F, 0, 0);
            this.animator.rotate(Leftthigh, -1.2F, 0, 0);
            this.animator.rotate(Rightshin, -0.3F, 0, 0);
            this.animator.rotate(Leftshin, -0.3F, 0, 0);
            this.animator.rotate(Rightupperfoot, 0.3F, 0, 0);
            this.animator.rotate(Leftupperfoot, 0.3F, 0, 0);
            this.animator.rotate(Rightfoot, -0.3F, 0, 0);
            this.animator.rotate(Leftfoot, -0.3F, 0, 0);
            this.animator.rotate(Rightarm, -0.5F, 0, 1);
            this.animator.rotate(Leftarm, -0.5F, 0, -1);
            this.animator.rotate(Rightforearm, 0.5F, 1.5F, 0);
            this.animator.rotate(Leftforearm, 0.5F, -1.5F, 0);
            this.animator.rotate(Righthand, -1, 0, 0);
            this.animator.rotate(Lefthand, -1, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(4);
            this.animator.resetPhase(0);
        }

        if (entity.getAnimationId() == 30) {
            animator.setAnimation(30);
            animator.startPhase(10);
            animator.rotate(body3, -0.4F, 0, 0);
            animator.rotate(Head, -0.05F, 0, 0);
            animator.rotate(Rightforearm, -0.3F, 0, 0);
            animator.rotate(Leftforearm, -0.3F, 0, 0);
            animator.endPhase();
            animator.setStationaryPhase(5);
            animator.startPhase(5);
            animator.rotate(body3, -0.4F, 0, 0);
            animator.rotate(down_jaw, 0.4F, 0, 0);
            animator.rotate(Head, -0.3F, 0, 0);
            animator.rotate(Rightforearm, -0.3F, 0, 0);
            animator.rotate(Leftforearm, -0.3F, 0, 0);
            animator.endPhase();
            animator.startPhase(10);
            animator.rotate(body3, -0.4F, 0, 0);
            animator.rotate(Head, -0.05F, 0, 0);
            animator.rotate(Rightforearm, -0.3F, 0, 0);
            animator.rotate(Leftforearm, -0.3F, 0, 0);
            animator.endPhase();
            animator.startPhase(5);
            animator.rotate(body3, -0.4F, 0, 0);
            animator.rotate(down_jaw, 0.4F, 0, 0);
            animator.rotate(Head, -0.3F, 0, 0);
            animator.rotate(Rightforearm, -0.3F, 0, 0);
            animator.rotate(Leftforearm, -0.3F, 0, 0);
            animator.endPhase();
            animator.startPhase(13);
            animator.rotate(body3, 0.05F, 0, 0);
            animator.rotate(neck2, 0.1F, 0, 0);
            animator.endPhase();
            animator.resetPhase(10);
        }
    }
}
