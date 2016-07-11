package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.entity.reptiles.EntityDeinosuchus;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDeinosuchus extends MowzieModelBase {
    public MowzieModelRenderer head1;
    public MowzieModelRenderer mouth1;
    public MowzieModelRenderer head2;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer mouth2;
    public MowzieModelRenderer mouth3;
    public MowzieModelRenderer teeth2;
    public MowzieModelRenderer head3;
    public MowzieModelRenderer teeth3;
    public MowzieModelRenderer body1;
    public MowzieModelRenderer leftArmFront1;
    public MowzieModelRenderer rightArmFront1;
    public MowzieModelRenderer body2;
    public MowzieModelRenderer leftArmFront2;
    public MowzieModelRenderer leftFootFront;
    public MowzieModelRenderer rightArmFront2;
    public MowzieModelRenderer rightFootFront;
    public MowzieModelRenderer leftArmBack1;
    public MowzieModelRenderer rightArmBack1;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer leftArmBack2;
    public MowzieModelRenderer leftFootBack;
    public MowzieModelRenderer rightArmBack2;
    public MowzieModelRenderer rightFootBack;
    public MowzieModelRenderer spikes1;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer spikes2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer spikes3;
    public MowzieModelRenderer tail4;
    public MowzieModelRenderer spikes4;
    public MowzieModelRenderer tail5;
    public MowzieModelRenderer spikes5;
    private MowzieModelRenderer[] bodyParts;
    private MowzieModelRenderer[] tailParts;

    public ModelDeinosuchus() {
        this.textureWidth = 256;
        this.textureHeight = 128;

        this.rightFootFront = new MowzieModelRenderer(this, 123, 0);
        this.rightFootFront.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.rightFootFront.addBox(-2.75F, -1.25F, -7.0F, 5, 2, 9);
        this.setRotateAngle(rightFootFront, -1.5707963267948966F, -0.5235987755982988F, 1.3962634015954636F);
        this.rightArmBack1 = new MowzieModelRenderer(this, 44, 44);
        this.rightArmBack1.setRotationPoint(-5.0F, 1.2F, 9.0F);
        this.rightArmBack1.addBox(-2.5F, -2.0F, -8.0F, 5, 4, 8);
        this.setRotateAngle(rightArmBack1, 3.0543261909900767F, 1.3089969389957472F, 3.141592653589793F);
        this.head3 = new MowzieModelRenderer(this, 150, 65);
        this.head3.setRotationPoint(0.0F, 0.0F, -15.0F);
        this.head3.addBox(-5.0F, -3.25F, -10.0F, 10, 6, 10);
        this.leftArmBack2 = new MowzieModelRenderer(this, 45, 45);
        this.leftArmBack2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.leftArmBack2.addBox(-2.5F, -1.5F, -6.0F, 5, 3, 7);
        this.setRotateAngle(leftArmBack2, 1.1344640137963142F, 0.2617993877991494F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 77, 101);
        this.tail1.setRotationPoint(0.0F, 0.0F, 17.0F);
        this.tail1.addBox(-6.0F, -6.0F, 0.0F, 12, 10, 14);
        this.setRotateAngle(tail1, -0.13962634015954636F, -0.0F, 0.0F);
        this.body1 = new MowzieModelRenderer(this, 0, 62);
        this.body1.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.body1.addBox(-6.0F, -6.0F, -0.5F, 12, 12, 15);
        this.setRotateAngle(body1, -0.03490658503988659F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 0, 37);
        this.neck.setRotationPoint(0.0F, 19.5F, 2.0F);
        this.neck.addBox(-5.0F, -5.5F, 0.0F, 10, 10, 8);
        this.setRotateAngle(neck, 0.12217304763960307F, -0.0F, 0.0F);
        this.mouth1 = new MowzieModelRenderer(this, 148, 37);
        this.mouth1.setRotationPoint(0.0F, 3.0F, -9.0F);
        this.mouth1.addBox(-4.0F, -2.0F, -7.0F, 8, 4, 16);
        this.leftArmFront2 = new MowzieModelRenderer(this, 45, 45);
        this.leftArmFront2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.leftArmFront2.addBox(-2.5F, -1.5F, -6.0F, 5, 3, 7);
        this.setRotateAngle(leftArmFront2, 1.1344640137963142F, 0.2617993877991494F, 0.0F);
        this.tail4 = new MowzieModelRenderer(this, 77, 24);
        this.tail4.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.tail4.addBox(-3.0F, -3.0F, -1.0F, 6, 7, 13);
        this.body2 = new MowzieModelRenderer(this, 0, 95);
        this.body2.setRotationPoint(0.0F, 0.0F, 14.0F);
        this.body2.addBox(-7.0F, -6.0F, 0.0F, 14, 12, 18);
        this.setRotateAngle(body2, -0.07853981633974483F, -0.0F, 0.0F);
        this.rightArmFront2 = new MowzieModelRenderer(this, 45, 45);
        this.rightArmFront2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.rightArmFront2.addBox(-2.5F, -1.5F, -6.0F, 5, 3, 7);
        this.setRotateAngle(rightArmFront2, 1.1344640137963142F, -0.2617993877991494F, 0.0F);
        this.spikes4 = new MowzieModelRenderer(this, 204, 8);
        this.spikes4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spikes4.addBox(0.0F, -7.25F, 0.0F, 0, 5, 12);
        this.tail3 = new MowzieModelRenderer(this, 77, 48);
        this.tail3.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.tail3.addBox(-4.0F, -4.0F, -1.0F, 8, 8, 13);
        this.setRotateAngle(tail3, 0.05235987755982988F, 0.0F, 0.0F);
        this.teeth2 = new MowzieModelRenderer(this, 197, 85);
        this.teeth2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teeth2.addBox(-4.5F, 2.5F, -15.0F, 9, 3, 15);
        this.leftFootFront = new MowzieModelRenderer(this, 123, 0);
        this.leftFootFront.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.leftFootFront.addBox(-2.75F, -1.25F, -7.0F, 5, 2, 9);
        this.setRotateAngle(leftFootFront, -1.5707963267948966F, 0.5235987755982988F, -1.3962634015954636F);
        this.rightFootBack = new MowzieModelRenderer(this, 123, 0);
        this.rightFootBack.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.rightFootBack.addBox(-2.75F, -1.0F, -7.0F, 5, 2, 9);
        this.setRotateAngle(rightFootBack, -1.5009831567151235F, -0.5235987755982988F, 1.3962634015954636F);
        this.spikes2 = new MowzieModelRenderer(this, 207, 36);
        this.spikes2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spikes2.addBox(0.0F, -10.75F, 1.0F, 0, 6, 12);
        this.tail5 = new MowzieModelRenderer(this, 77, 0);
        this.tail5.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.tail5.addBox(-2.0F, -2.0F, -1.0F, 4, 6, 14);
        this.spikes1 = new MowzieModelRenderer(this, 206, 44);
        this.spikes1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spikes1.addBox(0.0F, -12.75F, 0.0F, 0, 7, 14);
        this.rightArmBack2 = new MowzieModelRenderer(this, 45, 45);
        this.rightArmBack2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.rightArmBack2.addBox(-2.5F, -1.5F, -6.0F, 5, 3, 7);
        this.setRotateAngle(rightArmBack2, 1.1344640137963142F, -0.2617993877991494F, 0.0F);
        this.mouth3 = new MowzieModelRenderer(this, 154, 21);
        this.mouth3.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.mouth3.addBox(-4.0F, -2.0F, -10.0F, 8, 5, 10);
        this.spikes5 = new MowzieModelRenderer(this, 204, 8);
        this.spikes5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spikes5.addBox(0.0F, -6.0F, 0.0F, 0, 5, 12);
        this.leftArmFront1 = new MowzieModelRenderer(this, 44, 44);
        this.leftArmFront1.setRotationPoint(4.0F, 1.0F, 4.5F);
        this.leftArmFront1.addBox(-2.5F, -2.0F, -8.0F, 5, 4, 8);
        this.setRotateAngle(leftArmFront1, 3.0543261909900767F, -1.3089969389957472F, 3.141592653589793F);
        this.leftFootBack = new MowzieModelRenderer(this, 123, 0);
        this.leftFootBack.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.leftFootBack.addBox(-2.75F, -1.0F, -7.0F, 5, 2, 9);
        this.setRotateAngle(leftFootBack, -1.5009831567151235F, 0.5235987755982988F, -1.3962634015954636F);
        this.spikes3 = new MowzieModelRenderer(this, 206, 19);
        this.spikes3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spikes3.addBox(0.0F, -8.75F, -0.5F, 0, 5, 12);
        this.rightArmFront1 = new MowzieModelRenderer(this, 44, 44);
        this.rightArmFront1.setRotationPoint(-4.0F, 1.0F, 4.5F);
        this.rightArmFront1.addBox(-2.5F, -2.0F, -8.0F, 5, 4, 8);
        this.setRotateAngle(rightArmFront1, 3.0543261909900767F, 1.3089969389957472F, 3.141592653589793F);
        this.teeth3 = new MowzieModelRenderer(this, 201, 70);
        this.teeth3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teeth3.addBox(-5.0F, 2.75F, -10.0F, 10, 3, 10);
        this.head2 = new MowzieModelRenderer(this, 143, 85);
        this.head2.setRotationPoint(0.0F, -1.5F, -9.0F);
        this.head2.addBox(-4.5F, -2.5F, -15.0F, 9, 5, 15);
        this.mouth2 = new MowzieModelRenderer(this, 22, 10);
        this.mouth2.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.mouth2.addBox(-3.5F, -2.0F, -6.0F, 7, 4, 6);
        this.head1 = new MowzieModelRenderer(this, 145, 107);
        this.head1.mirror = true;
        this.head1.setRotationPoint(0.0F, 19.0F, 4.5F);
        this.head1.addBox(-5.47F, -5.0F, -9.0F, 11, 10, 9);
        this.leftArmBack1 = new MowzieModelRenderer(this, 44, 44);
        this.leftArmBack1.setRotationPoint(5.0F, 1.2F, 9.0F);
        this.leftArmBack1.addBox(-2.5F, -2.0F, -8.0F, 5, 4, 8);
        this.setRotateAngle(leftArmBack1, 3.0543261909900767F, -1.3089969389957472F, 3.141592653589793F);
        this.tail2 = new MowzieModelRenderer(this, 77, 73);
        this.tail2.setRotationPoint(0.0F, 0.0F, 14.0F);
        this.tail2.addBox(-5.0F, -5.0F, -1.0F, 10, 9, 14);
        this.setRotateAngle(tail2, 0.08726646259971647F, -0.0F, 0.0F);

        this.head1.addChild(this.mouth1);
        this.mouth1.addChild(this.mouth2);
        this.mouth2.addChild(this.mouth3);

        this.head1.addChild(this.head2);
        this.head2.addChild(this.teeth2);
        this.head2.addChild(this.head3);
        this.head3.addChild(this.teeth3);

        this.neck.addChild(this.body1);
        this.body1.addChild(this.body2);
        this.body1.addChild(this.leftArmFront1);
        this.leftArmFront1.addChild(this.leftArmFront2);
        this.leftArmFront2.addChild(this.leftFootFront);

        this.body1.addChild(this.rightArmFront1);
        this.rightArmFront1.addChild(this.rightArmFront2);
        this.rightArmFront2.addChild(this.rightFootFront);

        this.body2.addChild(this.leftArmBack1);
        this.leftArmBack1.addChild(this.leftArmBack2);
        this.leftArmBack2.addChild(this.leftFootBack);

        this.body2.addChild(this.rightArmBack1);
        this.rightArmBack1.addChild(this.rightArmBack2);
        this.rightArmBack2.addChild(this.rightFootBack);

        this.body2.addChild(this.tail1);
        this.tail1.addChild(this.tail2);
        this.tail1.addChild(this.spikes1);
        this.tail2.addChild(this.spikes2);
        this.tail2.addChild(this.tail3);
        this.tail3.addChild(this.spikes3);
        this.tail3.addChild(this.tail4);
        this.tail4.addChild(this.spikes4);
        this.tail4.addChild(this.tail5);
        this.tail5.addChild(this.spikes5);

        this.head1.updateDefaultPose();
        this.mouth1.updateDefaultPose();
        this.head2.updateDefaultPose();
        this.neck.updateDefaultPose();
        this.mouth2.updateDefaultPose();
        this.mouth3.updateDefaultPose();
        this.teeth2.updateDefaultPose();
        this.head3.updateDefaultPose();
        this.teeth3.updateDefaultPose();
        this.body1.updateDefaultPose();
        this.leftArmFront1.updateDefaultPose();
        this.rightArmFront1.updateDefaultPose();
        this.body2.updateDefaultPose();
        this.leftArmFront2.updateDefaultPose();
        this.leftFootFront.updateDefaultPose();
        this.rightArmFront2.updateDefaultPose();
        this.rightFootFront.updateDefaultPose();
        this.leftArmBack1.updateDefaultPose();
        this.rightArmBack1.updateDefaultPose();
        this.tail1.updateDefaultPose();
        this.leftArmBack2.updateDefaultPose();
        this.leftFootBack.updateDefaultPose();
        this.rightArmBack2.updateDefaultPose();
        this.rightFootBack.updateDefaultPose();
        this.spikes1.updateDefaultPose();
        this.tail2.updateDefaultPose();
        this.spikes2.updateDefaultPose();
        this.tail3.updateDefaultPose();
        this.spikes3.updateDefaultPose();
        this.tail4.updateDefaultPose();
        this.spikes4.updateDefaultPose();
        this.tail5.updateDefaultPose();
        this.spikes5.updateDefaultPose();

        this.bodyParts = new MowzieModelRenderer[] { this.tail5, this.tail4, this.tail3, this.tail2, this.tail1, this.body2, this.body1 };
        this.tailParts = new MowzieModelRenderer[] { this.tail5, this.tail4, this.tail3, this.tail2, this.tail1 };
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityDeinosuchus) entity);
        this.head1.render(f5);
        this.neck.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityDeinosuchus deinosuchus) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, deinosuchus);
        this.resetPose();

        this.faceTarget(f3, f5, 1.0F, this.head1);

        this.chainSwing(this.tailParts, 0.1F, -0.02F, 2.0, deinosuchus.frame, 1F);

        deinosuchus.tailBuffer.applyChainSwingBuffer(this.tailParts);
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    private void resetPose() {
        this.head1.resetToDefaultPose();
        this.mouth1.resetToDefaultPose();
        this.head2.resetToDefaultPose();
        this.neck.resetToDefaultPose();
        this.mouth2.resetToDefaultPose();
        this.mouth3.resetToDefaultPose();
        this.teeth2.resetToDefaultPose();
        this.head3.resetToDefaultPose();
        this.teeth3.resetToDefaultPose();
        this.body1.resetToDefaultPose();
        this.leftArmFront1.resetToDefaultPose();
        this.rightArmFront1.resetToDefaultPose();
        this.body2.resetToDefaultPose();
        this.leftArmFront2.resetToDefaultPose();
        this.leftFootFront.resetToDefaultPose();
        this.rightArmFront2.resetToDefaultPose();
        this.rightFootFront.resetToDefaultPose();
        this.leftArmBack1.resetToDefaultPose();
        this.rightArmBack1.resetToDefaultPose();
        this.tail1.resetToDefaultPose();
        this.leftArmBack2.resetToDefaultPose();
        this.leftFootBack.resetToDefaultPose();
        this.rightArmBack2.resetToDefaultPose();
        this.rightFootBack.resetToDefaultPose();
        this.spikes1.resetToDefaultPose();
        this.tail2.resetToDefaultPose();
        this.spikes2.resetToDefaultPose();
        this.tail3.resetToDefaultPose();
        this.spikes3.resetToDefaultPose();
        this.tail4.resetToDefaultPose();
        this.spikes4.resetToDefaultPose();
        this.tail5.resetToDefaultPose();
        this.spikes5.resetToDefaultPose();
    }
}
