// Date: 25.09.2014 19:49:57
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCearadactylus extends MowzieModelBase {
    // fields
    MowzieModelRenderer Left_Foot;
    MowzieModelRenderer Right_Foot;
    MowzieModelRenderer Left_Calf;
    MowzieModelRenderer Right_Calf;
    MowzieModelRenderer Left_Thigh;
    MowzieModelRenderer Right_Thigh;
    MowzieModelRenderer Body_1;
    MowzieModelRenderer Body_2;
    MowzieModelRenderer Tail_1;
    MowzieModelRenderer Tail_2;
    MowzieModelRenderer Tail_3;
    MowzieModelRenderer Tail_4;
    MowzieModelRenderer Left_Wing_1;
    MowzieModelRenderer Right_Wing_1;
    MowzieModelRenderer Left_Wing_2;
    MowzieModelRenderer Right_Wing_2;
    MowzieModelRenderer Neck_1;
    MowzieModelRenderer Neck_2;
    MowzieModelRenderer Neck_3;
    MowzieModelRenderer Head;
    MowzieModelRenderer Upper_Jaw;
    MowzieModelRenderer Lower_Jaw;
    MowzieModelRenderer Nose;
    MowzieModelRenderer Teeth;

    public ModelCearadactylus() {
        textureWidth = 256;
        textureHeight = 128;

        Left_Foot = new MowzieModelRenderer(this, 0, 0);
        Left_Foot.addBox(-1.5F, 0F, -5F, 3, 2, 5);
        Left_Foot.setRotationPoint(5F, 16.5F, 16F);
        Left_Foot.setTextureSize(256, 128);
        Left_Foot.mirror = true;
        setRotation(Left_Foot, 2.181662F, 0F, 0F);
        Right_Foot = new MowzieModelRenderer(this, 0, 0);
        Right_Foot.addBox(-1.5F, 0F, -5F, 3, 2, 5);
        Right_Foot.setRotationPoint(-5F, 16.5F, 16F);
        Right_Foot.setTextureSize(256, 128);
        Right_Foot.mirror = true;
        setRotation(Right_Foot, 2.181662F, 0F, 0F);
        Left_Calf = new MowzieModelRenderer(this, 0, 12);
        Left_Calf.addBox(-1F, 0F, 0F, 2, 7, 2);
        Left_Calf.setRotationPoint(5F, 15F, 10F);
        Left_Calf.setTextureSize(256, 128);
        Left_Calf.mirror = true;
        setRotation(Left_Calf, 1.204277F, 0F, 0F);
        Right_Calf = new MowzieModelRenderer(this, 0, 12);
        Right_Calf.addBox(-1F, 0F, 0F, 2, 7, 2);
        Right_Calf.setRotationPoint(-5F, 15F, 10F);
        Right_Calf.setTextureSize(256, 128);
        Right_Calf.mirror = true;
        setRotation(Right_Calf, 1.204277F, 0F, 0F);
        Left_Thigh = new MowzieModelRenderer(this, 0, 25);
        Left_Thigh.addBox(0F, 0F, -2F, 3, 6, 4);
        Left_Thigh.setRotationPoint(3.5F, 12.6F, 7.4F);
        Left_Thigh.setTextureSize(256, 128);
        Left_Thigh.mirror = true;
        setRotation(Left_Thigh, 1.134464F, 0F, 0F);
        Right_Thigh = new MowzieModelRenderer(this, 0, 25);
        Right_Thigh.addBox(-3F, 0F, -2F, 3, 6, 4);
        Right_Thigh.setRotationPoint(-3.5F, 12.6F, 7.4F);
        Right_Thigh.setTextureSize(256, 128);
        Right_Thigh.mirror = true;
        setRotation(Right_Thigh, 1.134464F, 0F, 0F);
        Body_1 = new MowzieModelRenderer(this, 48, 21);
        Body_1.addBox(-3.5F, 0F, 0F, 7, 7, 9);
        Body_1.setRotationPoint(0F, 8F, 3F);
        Body_1.setTextureSize(256, 128);
        Body_1.mirror = true;
        setRotation(Body_1, -0.0349066F, 0F, 0F);
        Body_2 = new MowzieModelRenderer(this, 48, 0);
        Body_2.addBox(-5F, 0F, 0F, 10, 8, 8);
        Body_2.setRotationPoint(0F, 6.5F, -3F);
        Body_2.setTextureSize(256, 128);
        Body_2.mirror = true;
        setRotation(Body_2, -0.0872665F, 0F, 0F);
        Tail_1 = new MowzieModelRenderer(this, 48, 69);
        Tail_1.addBox(-2F, 0F, 0F, 4, 4, 4);
        Tail_1.setRotationPoint(0F, 8.3F, 9.5F);
        Tail_1.setTextureSize(256, 128);
        Tail_1.mirror = true;
        setRotation(Tail_1, -0.0743572F, 0F, 0F);
        Tail_2 = new MowzieModelRenderer(this, 48, 57);
        Tail_2.addBox(-1.5F, 0F, 0F, 3, 3, 4);
        Tail_2.setRotationPoint(0F, 8.6F, 11F);
        Tail_2.setTextureSize(256, 128);
        Tail_2.mirror = true;
        setRotation(Tail_2, -0.1487144F, 0F, 0F);
        Tail_3 = new MowzieModelRenderer(this, 48, 48);
        Tail_3.addBox(-1F, 0F, 0F, 2, 2, 4);
        Tail_3.setRotationPoint(0F, 9.5F, 13F);
        Tail_3.setTextureSize(256, 128);
        Tail_3.mirror = true;
        setRotation(Tail_3, -0.1115358F, 0F, 0F);
        Tail_4 = new MowzieModelRenderer(this, 48, 40);
        Tail_4.addBox(-0.5F, 0F, 0F, 1, 1, 4);
        Tail_4.setRotationPoint(0F, 10.4F, 15F);
        Tail_4.setTextureSize(256, 128);
        Tail_4.mirror = true;
        setRotation(Tail_4, -0.0362881F, 0F, 0F);
        Left_Wing_1 = new MowzieModelRenderer(this, 0, 45);
        Left_Wing_1.addBox(0F, 0F, -4F, 2, 15, 6);
        Left_Wing_1.setRotationPoint(4.5F, 9.5F, -1F);
        Left_Wing_1.setTextureSize(256, 128);
        Left_Wing_1.mirror = true;
        setRotation(Left_Wing_1, -0.1745329F, 0F, -1.745329F);
        Right_Wing_1 = new MowzieModelRenderer(this, 0, 45);
        Right_Wing_1.addBox(-2F, 0F, -4F, 2, 15, 6);
        Right_Wing_1.setRotationPoint(-4.5F, 9.5F, -1F);
        Right_Wing_1.setTextureSize(256, 128);
        Right_Wing_1.mirror = true;
        setRotation(Right_Wing_1, -0.1745329F, 0F, 1.745329F);
        Left_Wing_2 = new MowzieModelRenderer(this, 0, 77);
        Left_Wing_2.addBox(0F, -16F, 0F, 2, 16, 6);
        Left_Wing_2.setRotationPoint(18.1F, 5.1F, -7.5F);
        Left_Wing_2.setTextureSize(256, 128);
        Left_Wing_2.mirror = true;
        setRotation(Left_Wing_2, -0.4363323F, 0.1396263F, 1.553343F);
        Right_Wing_2 = new MowzieModelRenderer(this, 0, 77);
        Right_Wing_2.addBox(-2F, -16F, 0F, 2, 16, 6);
        Right_Wing_2.setRotationPoint(-18.1F, 5.1F, -7.5F);
        Right_Wing_2.setTextureSize(256, 128);
        Right_Wing_2.mirror = true;
        setRotation(Right_Wing_2, -0.4363323F, -0.1396263F, -1.553343F);
        Neck_1 = new MowzieModelRenderer(this, 127, 0);
        Neck_1.addBox(-3.5F, 0F, -1F, 7, 6, 4);
        Neck_1.setRotationPoint(0F, 6.5F, -3F);
        Neck_1.setTextureSize(256, 128);
        Neck_1.mirror = true;
        setRotation(Neck_1, -0.2647486F, 0F, 0F);
        Neck_2 = new MowzieModelRenderer(this, 155, 0);
        Neck_2.addBox(-2.5F, 0.7F, -3F, 5, 5, 6);
        Neck_2.setRotationPoint(0F, 6.5F, -3F);
        Neck_2.setTextureSize(256, 128);
        Neck_2.mirror = true;
        setRotation(Neck_2, -0.3753481F, 0F, 0F);
        Neck_3 = new MowzieModelRenderer(this, 182, 0);
        Neck_3.addBox(-2F, 0F, 0F, 4, 4, 6);
        Neck_3.setRotationPoint(0F, 5F, -9F);
        Neck_3.setTextureSize(256, 128);
        Neck_3.mirror = true;
        setRotation(Neck_3, -0.4900007F, 0F, 0F);
        Head = new MowzieModelRenderer(this, 98, 0);
        Head.addBox(-3F, -2F, -7F, 6, 6, 7);
        Head.setRotationPoint(0F, 5F, -9F);
        Head.setTextureSize(256, 128);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Upper_Jaw = new MowzieModelRenderer(this, 131, 19);
        Upper_Jaw.addBox(-1.5F, 0F, -10F, 3, 2, 10);
        Upper_Jaw.setRotationPoint(0F, 5F, -14F);
        Upper_Jaw.setTextureSize(256, 128);
        Upper_Jaw.mirror = true;
        setRotation(Upper_Jaw, 0F, 0F, 0F);
        Lower_Jaw = new MowzieModelRenderer(this, 131, 37);
        Lower_Jaw.addBox(-1F, 0F, -9F, 2, 1, 9);
        Lower_Jaw.setRotationPoint(0F, 7F, -14F);
        Lower_Jaw.setTextureSize(256, 128);
        Lower_Jaw.mirror = true;
        setRotation(Lower_Jaw, 0F, 0F, 0F);
        Nose = new MowzieModelRenderer(this, 131, 51);
        Nose.addBox(-1.5F, 0F, -10F, 3, 1, 10);
        Nose.setRotationPoint(0F, 3.9F, -14.1F);
        Nose.setTextureSize(256, 128);
        Nose.mirror = true;
        setRotation(Nose, 0.1047198F, 0F, 0F);
        Teeth = new MowzieModelRenderer(this, 131, 63);
        Teeth.addBox(-1.5F, 0.2F, -10F, 3, 1, 10);
        Teeth.setRotationPoint(0F, 6.8F, -14F);
        Teeth.setTextureSize(256, 128);
        Teeth.mirror = true;
        setRotation(Teeth, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Left_Foot.render(f5);
        Right_Foot.render(f5);
        Left_Calf.render(f5);
        Right_Calf.render(f5);
        Left_Thigh.render(f5);
        Right_Thigh.render(f5);
        Body_1.render(f5);
        Body_2.render(f5);
        Tail_1.render(f5);
        Tail_2.render(f5);
        Tail_3.render(f5);
        Tail_4.render(f5);
        Left_Wing_1.render(f5);
        Right_Wing_1.render(f5);
        Left_Wing_2.render(f5);
        Right_Wing_2.render(f5);
        Neck_1.render(f5);
        Neck_2.render(f5);
        Neck_3.render(f5);
        Head.render(f5);
        Upper_Jaw.render(f5);
        Lower_Jaw.render(f5);
        Nose.render(f5);
        Teeth.render(f5);
    }

    private void setRotation(MowzieModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }

}
