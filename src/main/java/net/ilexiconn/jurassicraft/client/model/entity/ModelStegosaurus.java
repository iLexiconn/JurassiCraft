package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityStegosaurus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStegosaurus extends MowzieModelBase {
    MowzieModelRenderer waist;
    MowzieModelRenderer legleftthigh;
    MowzieModelRenderer legrightthigh;
    MowzieModelRenderer neck;
    MowzieModelRenderer tail1;
    MowzieModelRenderer tail2;
    MowzieModelRenderer tail3;
    MowzieModelRenderer tail4;
    MowzieModelRenderer legleftcalf;
    MowzieModelRenderer legrightcalf;
    MowzieModelRenderer legrightfoot;
    MowzieModelRenderer legleftfoot;
    MowzieModelRenderer chest;
    MowzieModelRenderer armrightcalf;
    MowzieModelRenderer armleftcalf;
    MowzieModelRenderer armleftthigh;
    MowzieModelRenderer armrightthigh;
    MowzieModelRenderer headback;
    MowzieModelRenderer upperjaw;
    MowzieModelRenderer upperjaw2;
    MowzieModelRenderer head;
    MowzieModelRenderer tail5;
    MowzieModelRenderer lowerjaw;
    MowzieModelRenderer plate1waist;
    MowzieModelRenderer plate2waist;
    MowzieModelRenderer plate3waist;
    MowzieModelRenderer plate4chest;
    MowzieModelRenderer plate5headback;
    MowzieModelRenderer plate6tail1;
    MowzieModelRenderer plate7tail2;
    MowzieModelRenderer tailspike2tail4;
    MowzieModelRenderer tailspike1tail4;
    MowzieModelRenderer tailspike4tail5;
    MowzieModelRenderer tailspike3tail5;
    MowzieModelRenderer plate8chest;
    MowzieModelRenderer plate9neck;
    MowzieModelRenderer plate10tail3;
    MowzieModelRenderer plate11tail2;
    MowzieModelRenderer armleftfoot;
    MowzieModelRenderer armrightfoot;
    MowzieModelRenderer[] tailParts;
    private Animator animator;

    public ModelStegosaurus() {
        animator = new Animator(this);
        this.textureWidth = 256;
        this.textureHeight = 128;

        this.tail3 = new MowzieModelRenderer(this, 211, 80);
        this.tail3.setRotationPoint(0.0F, 8.7F, 23.4F);
        this.tail3.addBox(-3.0F, -1.3F, 0.0F, 6, 5, 7);
        this.setRotateAngle(tail3, -0.15707963267948966F, -0.0F, 0.0F);
        this.armrightthigh = new MowzieModelRenderer(this, 40, 50);
        this.armrightthigh.setRotationPoint(-5.5F, 12.1F, -6.1F);
        this.armrightthigh.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 4);
        this.setRotateAngle(armrightthigh, 0.3839724354387525F, -0.0F, 0.0F);
        this.tail4 = new MowzieModelRenderer(this, 155, 51);
        this.tail4.setRotationPoint(0.0F, 10.5F, 28.8F);
        this.tail4.addBox(-2.0F, -1.4F, 0.0F, 4, 3, 7);
        this.setRotateAngle(tail4, -0.0804596785169386F, -0.0F, 0.0F);
        this.plate2waist = new MowzieModelRenderer(this, 76, 1);
        this.plate2waist.setRotationPoint(0.0F, 6.0F, 9.0F);
        this.plate2waist.addBox(4.5F, -1.0F, -15.3F, 1, 7, 7);
        this.setRotateAngle(plate2waist, -0.7155849933176751F, -0.0F, 0.0F);
        this.tailspike3tail5 = new MowzieModelRenderer(this, 211, 45);
        this.tailspike3tail5.setRotationPoint(0.0F, 11.1F, 35.0F);
        this.tailspike3tail5.addBox(-4.0F, 0.7F, 3.0F, 1, 1, 6);
        this.setRotateAngle(tailspike3tail5, 0.3914773512223281F, 1.0173524209874947F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 151, 72);
        this.tail1.setRotationPoint(0.0F, 6.6F, 11.2F);
        this.tail1.addBox(-5.0F, -3.1F, -0.8F, 10, 10, 8);
        this.setRotateAngle(tail1, -0.05235987755982988F, -0.0F, 0.0F);
        this.plate4chest = new MowzieModelRenderer(this, 52, 1);
        this.plate4chest.setRotationPoint(0.0F, 7.8F, -3.0F);
        this.plate4chest.addBox(-5.0F, -5.0F, -10.0F, 1, 6, 6);
        this.setRotateAngle(plate4chest, -0.6632251157578453F, -0.0F, 0.0F);
        this.legleftcalf = new MowzieModelRenderer(this, 22, 69);
        this.legleftcalf.setRotationPoint(8.0F, 13.0F, 7.0F);
        this.legleftcalf.addBox(-1.5F, -1.6F, -2.0F, 3, 9, 4);
        this.setRotateAngle(legleftcalf, 0.6108652381980153F, -0.0F, 0.0F);
        this.tail5 = new MowzieModelRenderer(this, 184, 51);
        this.tail5.setRotationPoint(0.0F, 11.1F, 35.0F);
        this.tail5.addBox(-1.0F, -0.8F, 0.0F, 2, 2, 6);
        this.setRotateAngle(tail5, -0.045553093477052F, -0.0F, 0.0F);
        this.tailspike2tail4 = new MowzieModelRenderer(this, 211, 59);
        this.tailspike2tail4.setRotationPoint(0.0F, 10.5F, 28.8F);
        this.tailspike2tail4.addBox(-2.7F, 1.2F, 2.9F, 1, 1, 7);
        this.setRotateAngle(tailspike2tail4, 0.5410520681182421F, 1.0471975511965976F, 0.0F);
        this.waist = new MowzieModelRenderer(this, 149, 98);
        this.waist.setRotationPoint(0.0F, 6.0F, 9.0F);
        this.waist.addBox(-6.0F, -3.7F, -12.6F, 12, 14, 15);
        this.setRotateAngle(waist, 0.05235987755982988F, -0.0F, 0.0F);
        this.upperjaw = new MowzieModelRenderer(this, 51, 116);
        this.upperjaw.setRotationPoint(0.0F, 10.7F, -21.0F);
        this.upperjaw.addBox(-1.0F, -1.8F, -8.5F, 2, 3, 5);
        this.upperjaw2 = new MowzieModelRenderer(this, 51, 116);
        this.upperjaw2.setRotationPoint(0.0F, 10.7F, -21.0F);
        this.upperjaw2.addBox(-1.0F, -1.8F, -8.5F, 2, 3, 5);
        this.plate7tail2 = new MowzieModelRenderer(this, 36, 4);
        this.plate7tail2.setRotationPoint(0.0F, 6.5F, 16.8F);
        this.plate7tail2.addBox(2.5F, -6.5F, -3.8F, 1, 5, 5);
        this.setRotateAngle(plate7tail2, -1.0471975511965976F, -0.0F, 0.0F);
        this.armrightfoot = new MowzieModelRenderer(this, 2, 67);
        this.armrightfoot.setRotationPoint(-5.5F, 21.0F, -6.9F);
        this.armrightfoot.addBox(-1.5F, 0.0F, -0.3F, 3, 3, 4);
        this.neck = new MowzieModelRenderer(this, 67, 82);
        this.neck.setRotationPoint(0.0F, 9.1F, -11.3F);
        this.neck.addBox(-3.0F, -2.7F, -4.8F, 6, 7, 5);
        this.setRotateAngle(neck, 0.314857397059777F, -0.0F, 0.0F);
        this.armleftcalf = new MowzieModelRenderer(this, 2, 52);
        this.armleftcalf.setRotationPoint(5.5F, 18.0F, -4.0F);
        this.armleftcalf.addBox(-1.5F, -1.0F, -2.0F, 3, 5, 4);
        this.setRotateAngle(armleftcalf, -0.3665191429188092F, -0.0F, 0.0F);
        this.armleftthigh = new MowzieModelRenderer(this, 26, 50);
        this.armleftthigh.setRotationPoint(5.5F, 12.1F, -6.1F);
        this.armleftthigh.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 4);
        this.setRotateAngle(armleftthigh, 0.3839724354387525F, -0.0F, 0.0F);
        this.plate1waist = new MowzieModelRenderer(this, 101, 2);
        this.plate1waist.setRotationPoint(0.0F, 6.0F, 9.0F);
        this.plate1waist.addBox(-5.5F, -5.6F, -12.6F, 1, 8, 8);
        this.setRotateAngle(plate1waist, -0.7853981633974483F, -0.0F, 0.0F);
        this.plate10tail3 = new MowzieModelRenderer(this, 139, 2);
        this.plate10tail3.setRotationPoint(0.0F, 8.7F, 23.4F);
        this.plate10tail3.addBox(1.0F, -5.7F, -1.9F, 1, 3, 3);
        this.setRotateAngle(plate10tail3, -1.1913617474113294F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 78, 116);
        this.head.setRotationPoint(0.0F, 10.7F, -21.0F);
        this.head.addBox(-2.0F, -2.2F, -4.0F, 4, 5, 5);
        this.plate6tail1 = new MowzieModelRenderer(this, 52, 1);
        this.plate6tail1.setRotationPoint(0.0F, 6.6F, 11.2F);
        this.plate6tail1.addBox(-4.0F, -9.1F, -5.3F, 1, 6, 6);
        this.setRotateAngle(plate6tail1, -0.9424777960769379F, -0.0F, 0.0F);
        this.legleftthigh = new MowzieModelRenderer(this, 10, 91);
        this.legleftthigh.setRotationPoint(6.0F, 6.0F, 9.0F);
        this.legleftthigh.addBox(0.0F, -3.0F, -4.0F, 4, 11, 8);
        this.setRotateAngle(legleftthigh, -0.20943951023931953F, -0.0F, 0.0F);
        this.plate11tail2 = new MowzieModelRenderer(this, 126, 2);
        this.plate11tail2.setRotationPoint(0.0F, 6.5F, 16.8F);
        this.plate11tail2.addBox(-3.0F, -8.87F, -0.7F, 1, 4, 4);
        this.setRotateAngle(plate11tail2, -1.1913617474113294F, -0.0F, 0.0F);
        this.lowerjaw = new MowzieModelRenderer(this, 20, 121);
        this.lowerjaw.setRotationPoint(0.0F, 12.5F, -24.4F);
        this.lowerjaw.addBox(-1.0F, -1.1F, -4.5F, 2, 2, 4);
        this.plate8chest = new MowzieModelRenderer(this, 36, 4);
        this.plate8chest.setRotationPoint(0.0F, 7.8F, -3.0F);
        this.plate8chest.addBox(4.0F, -3.0F, -12.0F, 1, 5, 5);
        this.setRotateAngle(plate8chest, -0.4363323129985824F, -0.0F, 0.0F);
        this.legrightcalf = new MowzieModelRenderer(this, 42, 69);
        this.legrightcalf.setRotationPoint(-8.0F, 13.0F, 7.0F);
        this.legrightcalf.addBox(-1.5F, -1.6F, -2.0F, 3, 9, 4);
        this.setRotateAngle(legrightcalf, 0.6108652381980153F, -0.0F, 0.0F);
        this.tailspike4tail5 = new MowzieModelRenderer(this, 211, 45);
        this.tailspike4tail5.mirror = true;
        this.tailspike4tail5.setRotationPoint(0.0F, 11.1F, 35.0F);
        this.tailspike4tail5.addBox(2.9F, 0.7F, 3.0F, 1, 1, 6);
        this.setRotateAngle(tailspike4tail5, 0.3740240587023848F, -0.99728113458956F, 0.0F);
        this.plate5headback = new MowzieModelRenderer(this, 23, 13);
        this.plate5headback.setRotationPoint(0.0F, 11.5F, -15.2F);
        this.plate5headback.addBox(1.0F, -4.0F, -5.3F, 1, 3, 3);
        this.setRotateAngle(plate5headback, -0.5850343652684993F, -0.0F, 0.0F);
        this.plate3waist = new MowzieModelRenderer(this, 76, 1);
        this.plate3waist.setRotationPoint(0.0F, 6.0F, 9.0F);
        this.plate3waist.addBox(4.5F, -8.5F, -8.0F, 1, 7, 7);
        this.setRotateAngle(plate3waist, -0.8552113334772213F, -0.0F, 0.0F);
        this.legleftfoot = new MowzieModelRenderer(this, 3, 75);
        this.legleftfoot.setRotationPoint(8.0F, 18.0F, 12.0F);
        this.legleftfoot.addBox(-1.5F, 0.0F, -3.2F, 3, 6, 4);
        this.tail2 = new MowzieModelRenderer(this, 210, 105);
        this.tail2.setRotationPoint(0.0F, 6.5F, 16.8F);
        this.tail2.addBox(-4.0F, -1.5F, -1.3F, 8, 7, 10);
        this.setRotateAngle(tail2, -0.18133970928221083F, -0.0F, 0.0F);
        this.legrightthigh = new MowzieModelRenderer(this, 10, 24);
        this.legrightthigh.setRotationPoint(-6.0F, 6.0F, 9.0F);
        this.legrightthigh.addBox(-4.0F, -3.0F, -4.0F, 4, 11, 8);
        this.setRotateAngle(legrightthigh, -0.20943951023931953F, -0.0F, 0.0F);
        this.headback = new MowzieModelRenderer(this, 42, 101);
        this.headback.setRotationPoint(0.0F, 11.5F, -15.2F);
        this.headback.addBox(-2.5F, -2.7F, -5.0F, 5, 5, 6);
        this.setRotateAngle(headback, -0.06230825429619756F, -0.0F, 0.0F);
        this.plate9neck = new MowzieModelRenderer(this, 23, 13);
        this.plate9neck.setRotationPoint(0.0F, 9.1F, -11.3F);
        this.plate9neck.addBox(-2.5F, -2.3F, -6.1F, 1, 3, 3);
        this.setRotateAngle(plate9neck, -0.4886921905584123F, -0.0F, 0.0F);
        this.legrightfoot = new MowzieModelRenderer(this, 2, 64);
        this.legrightfoot.setRotationPoint(-8.0F, 18.0F, 12.0F);
        this.legrightfoot.addBox(-1.5F, 0.0F, -3.2F, 3, 6, 4);
        this.armleftfoot = new MowzieModelRenderer(this, 3, 78);
        this.armleftfoot.setRotationPoint(5.5F, 21.0F, -6.9F);
        this.armleftfoot.addBox(-1.5F, 0.0F, -0.3F, 3, 3, 4);
        this.tailspike1tail4 = new MowzieModelRenderer(this, 211, 59);
        this.tailspike1tail4.mirror = true;
        this.tailspike1tail4.setRotationPoint(0.0F, 10.5F, 28.8F);
        this.tailspike1tail4.addBox(2.7F, 1.2F, 2.9F, 1, 1, 7);
        this.setRotateAngle(tailspike1tail4, 0.5410520681182421F, -1.0471975511965976F, 0.0F);
        this.chest = new MowzieModelRenderer(this, 106, 107);
        this.chest.setRotationPoint(0.0F, 7.8F, -3.0F);
        this.chest.addBox(-5.5F, -4.7F, -8.6F, 11, 11, 9);
        this.setRotateAngle(chest, 0.24434609527920614F, -0.0F, 0.0F);
        this.armrightcalf = new MowzieModelRenderer(this, 54, 52);
        this.armrightcalf.setRotationPoint(-5.5F, 18.0F, -4.0F);
        this.armrightcalf.addBox(-1.5F, -1.0F, -2.0F, 3, 5, 4);
        this.setRotateAngle(armrightcalf, -0.3665191429188092F, -0.0F, 0.0F);

        addChildTo(upperjaw, head);
        addChildTo(upperjaw2, head);
        addChildTo(lowerjaw, head);
        addChildTo(head, headback);
        addChildTo(plate5headback, headback);
        addChildTo(headback, neck);
        addChildTo(plate9neck, neck);
        addChildTo(neck, chest);

        addChildTo(plate8chest, chest);
        addChildTo(plate4chest, chest);
        addChildTo(armleftfoot, armleftcalf);
        addChildTo(armleftcalf, armleftthigh);
        addChildTo(armleftthigh, chest);
        addChildTo(armrightfoot, armrightcalf);
        addChildTo(armrightcalf, armrightthigh);
        addChildTo(armrightthigh, chest);

        addChildTo(chest, waist);

        addChildTo(plate3waist, waist);
        addChildTo(plate1waist, waist);
        addChildTo(plate2waist, waist);

        addChildTo(legleftfoot, legleftcalf);
        addChildTo(legleftcalf, legleftthigh);
        addChildTo(legrightfoot, legrightcalf);
        addChildTo(legrightcalf, legrightthigh);

        addChildTo(tailspike4tail5, tail5);
        addChildTo(tailspike3tail5, tail5);
        addChildTo(tail5, tail4);
        addChildTo(tailspike2tail4, tail4);
        addChildTo(tailspike1tail4, tail4);
        addChildTo(tail4, tail3);
        addChildTo(plate10tail3, tail3);
        addChildTo(tail3, tail2);
        addChildTo(plate11tail2, tail2);
        addChildTo(plate7tail2, tail2);
        addChildTo(tail2, tail1);
        addChildTo(plate6tail1, tail1);
        addChildTo(tail1, waist);

        // Corrections
        upperjaw.setRotationPoint(0.02F, 0, 0);
        upperjaw2.setRotationPoint(-0.02F, 0, 0);
        plate5headback.setRotationPoint(0, 0, 0);
        plate4chest.setRotationPoint(0, 0, 0);
        plate8chest.setRotationPoint(0, 0, 0);
        plate1waist.setRotationPoint(0, 0, 0);
        plate2waist.setRotationPoint(0, 0, 0);
        plate3waist.setRotationPoint(0, 0, 0);
        plate9neck.setRotationPoint(0, 0, 0);
        tailspike4tail5.setRotationPoint(0, 0, 0);
        tailspike3tail5.setRotationPoint(0, 0, 0);
        tailspike1tail4.setRotationPoint(0, 0, 0);
        tailspike2tail4.setRotationPoint(0, 0, 0);
        plate10tail3.setRotationPoint(0, 0, 0);
        plate11tail2.setRotationPoint(0, 0, 0);
        plate7tail2.setRotationPoint(0, 0, 0);
        plate6tail1.setRotationPoint(0, 0, 0);
        head.rotationPointZ -= 11.7;
        head.rotationPointY -= 0.9;
        tail2.rotationPointZ += 12;
        tail2.rotationPointY -= 0.7;

        tailParts = new MowzieModelRenderer[] { this.tail5, this.tail4, this.tail3, this.tail2, this.tail1 };
        this.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.waist.render(f5);
        this.legleftthigh.render(f5);
        this.legrightthigh.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityStegosaurus stegosaurus) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, stegosaurus);
        this.resetToDefaultPose();

        /*
         * f = stegosaurus.frame; f1 = (float) Math.cos(f/50)*0.5F + 1F;
         */

        float scaleFactor = 0.5F;
        float height = 0.8F;
        float frontOffset = -2F;

        this.faceTarget(f3, f4, 1.0F, this.head, this.headback, this.neck);

        this.bob(this.waist, 2 * scaleFactor, height, false, f, f1);
        this.bob(this.legleftthigh, 2 * scaleFactor, height, false, f, f1);
        this.bob(this.legrightthigh, 2 * scaleFactor, height, false, f, f1);
        this.walk(this.waist, 2 * scaleFactor, 0.1F * height, true, -1.5F, 0F, f, f1);
        this.walk(this.neck, 2 * scaleFactor, 0.07F * height, false, -0.5F, 0F, f, f1);
        this.walk(this.headback, 2 * scaleFactor, 0.07F * height, false, 0.5F, 0F, f, f1);
        this.walk(this.head, 2 * scaleFactor, 0.07F * height, true, 1.5F, 0F, f, f1);

        this.walk(this.legleftthigh, 1F * scaleFactor, 0.8F, false, 0F, 0F, f, f1);
        this.walk(this.legleftcalf, 1F * scaleFactor, 0.8F, true, 1F, 0F, f, f1);
        this.walk(this.legleftfoot, 1F * scaleFactor, 0.8F, false, 1.5F, 0F, f, f1);

        this.walk(this.legrightthigh, 1F * scaleFactor, 0.8F, true, 0F, 0F, f, f1);
        this.walk(this.legrightcalf, 1F * scaleFactor, 0.8F, false, 1F, 0F, f, f1);
        this.walk(this.legrightfoot, 1F * scaleFactor, 0.8F, true, 1.5F, 0F, f, f1);

        this.walk(this.armrightthigh, 1F * scaleFactor, 0.8F, true, frontOffset + 0F, -0.1F, f, f1);
        this.walk(this.armrightcalf, 1F * scaleFactor, 0.6F, true, frontOffset + 1F, -0.2F, f, f1);
        this.walk(this.armrightfoot, 1F * scaleFactor, 0.8F, false, frontOffset + 1.5F, 0F, f, f1);

        this.walk(this.armleftthigh, 1F * scaleFactor, 0.8F, false, frontOffset + 0F, -0.1F, f, f1);
        this.walk(this.armleftcalf, 1F * scaleFactor, 0.6F, false, frontOffset + 1F, -0.2F, f, f1);
        this.walk(this.armleftfoot, 1F * scaleFactor, 0.8F, true, frontOffset + 1.5F, 0F, f, f1);

        // Idling
        this.walk(this.neck, 0.1F, 0.04F, false, -1F, 0F, stegosaurus.frame, 1F);
        this.walk(this.head, 0.1F, 0.07F, true, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.headback, 0.1F, 0.03F, false, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.waist, 0.1F, 0.025F, false, 0F, 0F, stegosaurus.frame, 1F);

        float inverseKinematicsConstant = 0.6F;
        this.walk(this.armrightthigh, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.armrightcalf, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.armrightfoot, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.armleftthigh, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.armleftcalf, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, stegosaurus.frame, 1F);
        this.walk(this.armleftfoot, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, stegosaurus.frame, 1F);
        this.armleftthigh.rotationPointZ -= 0.5 * Math.cos(stegosaurus.frame * 0.1F);
        this.armrightthigh.rotationPointZ -= 0.5 * Math.cos(stegosaurus.frame * 0.1F);

        float whipPosProgress = stegosaurus.tailWhipPosition.getAnimationProgressSinSqrt();

        if (whipPosProgress > 0) {
            // Whip Position
            if (stegosaurus.getAnimationTick() != JurassiCraftAnimationIDs.TAIL_WHIP.animID()) {
                this.chainSwing(this.tailParts, 0.3F, 0.4F, 3.0F, stegosaurus.frame, whipPosProgress);
                this.chainWave(this.tailParts, 0.075F, -0.3F, 1.5F, stegosaurus.frame, whipPosProgress);
            }
            this.chainWave(this.tailParts, 2 * scaleFactor, 0.05F, 3, f, f1);

            this.legrightthigh.rotateAngleZ += 0.25F * whipPosProgress;
            this.legleftthigh.rotateAngleZ -= 0.25F * whipPosProgress;
            this.legrightcalf.rotateAngleZ -= 0.05F * whipPosProgress;
            this.legleftcalf.rotateAngleZ += 0.05F * whipPosProgress;
            this.legrightfoot.rotateAngleZ -= 0.15F * whipPosProgress;
            this.legleftfoot.rotateAngleZ += 0.15F * whipPosProgress;
            this.armrightthigh.rotationPointY -= 1.2F * whipPosProgress;
            this.armleftthigh.rotationPointY -= 1.2F * whipPosProgress;
            this.armrightthigh.rotateAngleZ += 0.6F * whipPosProgress;
            this.armleftthigh.rotateAngleZ -= 0.6F * whipPosProgress;
            this.armrightcalf.rotateAngleX -= 0.7F * whipPosProgress;
            this.armleftcalf.rotateAngleX -= 0.7F * whipPosProgress;
            this.armrightcalf.rotateAngleZ -= 0.3F * whipPosProgress;
            this.armleftcalf.rotateAngleZ += 0.3F * whipPosProgress;
            this.armrightfoot.rotateAngleX += 0.5F * whipPosProgress;
            this.armleftfoot.rotateAngleX += 0.5F * whipPosProgress;
            this.armrightfoot.rotateAngleZ -= 0.3F * whipPosProgress;
            this.armleftfoot.rotateAngleZ += 0.3F * whipPosProgress;
            this.waist.rotateAngleX += 0.35F * whipPosProgress;
            this.chest.rotateAngleX -= 0.2F * whipPosProgress;
            this.neck.rotateAngleX -= 0.1F * whipPosProgress;
            this.tail1.rotateAngleX -= 0.1F * whipPosProgress;
        } else {
            stegosaurus.tailBuffer.applyChainSwingBuffer(this.tailParts);
        }

        this.chainSwing(this.tailParts, 0.1F, 0.2F, 3, stegosaurus.frame, 1.0F - whipPosProgress);
        this.chainWave(this.tailParts, 0.1F, -0.05F, 1, stegosaurus.frame, 1.0F - whipPosProgress);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        setRotationAngles(f, f1, f2, f3, f4, f5, (EntityStegosaurus) entity);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.TAIL_WHIP.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.TAIL_WHIP.animID());
            this.animator.startPhase(10);
            this.animator.rotate(this.tail1, 0.0F, 0.3F, 0.0F);
            this.animator.rotate(this.tail2, 0.0F, 0.2F, 0.0F);
            this.animator.rotate(this.tail3, 0.0F, 0.1F, 0.0F);
            this.animator.rotate(this.tail4, 0.0F, 0.1F, 0.0F);
            this.animator.rotate(this.tail5, 0.0F, 0.1F, 0.0F);
            this.animator.endPhase();
            this.animator.startPhase(10);
            this.animator.rotate(this.tail1, 0.0F, -0.6F, 0.0F);
            this.animator.rotate(this.tail2, 0.0F, -0.4F, 0.0F);
            this.animator.rotate(this.tail3, 0.0F, -0.2F, 0.0F);
            this.animator.rotate(this.tail4, 0.0F, -0.2F, 0.0F);
            this.animator.rotate(this.tail5, 0.0F, -0.2F, 0.0F);
            this.animator.endPhase();
            this.animator.setStationaryPhase(10);
            this.animator.resetPhase(0);
        }
    }
}
