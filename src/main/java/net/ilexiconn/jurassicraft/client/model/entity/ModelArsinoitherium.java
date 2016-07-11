package net.ilexiconn.jurassicraft.client.model.entity;

import net.ilexiconn.jurassicraft.client.model.animation.Animator;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityArsinoitherium;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArsinoitherium extends MowzieModelBase {
    public MowzieModelRenderer upperbackbody;
    public MowzieModelRenderer middlebody;
    public MowzieModelRenderer upperfrontbody;
    public MowzieModelRenderer bottomfrontbody;
    public MowzieModelRenderer chest;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer head;
    public MowzieModelRenderer leftear;
    public MowzieModelRenderer rightear;
    public MowzieModelRenderer mouth;
    public MowzieModelRenderer snout;
    public MowzieModelRenderer leftbackleg1;
    public MowzieModelRenderer leftbackleg2;
    public MowzieModelRenderer leftbackleg3;
    public MowzieModelRenderer leftbackleg4;
    public MowzieModelRenderer rightbackleg1;
    public MowzieModelRenderer rightbackleg2;
    public MowzieModelRenderer rightbackleg3;
    public MowzieModelRenderer rightbackleg4;
    public MowzieModelRenderer leftfrontleg1;
    public MowzieModelRenderer leftfrontleg2;
    public MowzieModelRenderer leftfrontleg3;
    public MowzieModelRenderer leftfrontleg4;
    public MowzieModelRenderer rightfrontleg1;
    public MowzieModelRenderer rightfrontleg2;
    public MowzieModelRenderer rightfrontleg3;
    public MowzieModelRenderer rightfrontleg4;
    public MowzieModelRenderer leftupperhorn;
    public MowzieModelRenderer rightupperhorn;
    public MowzieModelRenderer leftbottomhorn1;
    public MowzieModelRenderer leftbottomhorn2;
    public MowzieModelRenderer leftbottomhorn3;
    public MowzieModelRenderer rightbottomhorn1;
    public MowzieModelRenderer rightbottomhorn2;
    public MowzieModelRenderer rightbottomhorn3;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer headShakeController;
    public MowzieModelRenderer[] neckParts;
    private Animator animator;

    public ModelArsinoitherium() {
        this.animator = new Animator(this);
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.snout = new MowzieModelRenderer(this, 34, 54);
        this.snout.setRotationPoint(0.0F, -0.5F, -8.0F);
        this.snout.addBox(-4.0F, -2.5F, -6.0F, 8, 5, 6);
        this.rightfrontleg1 = new MowzieModelRenderer(this, 0, 68);
        this.rightfrontleg1.setRotationPoint(-7.0F, 1.0F, 3.0F);
        this.rightfrontleg1.addBox(-2.0F, -4.0F, -2.0F, 6, 10, 8);
        this.setRotateAngle(rightfrontleg1, 0.17453292519943295F, -0.0F, 0.0F);
        this.rightear = new MowzieModelRenderer(this, 106, 60);
        this.rightear.setRotationPoint(-3.5F, -3.0F, 0.0F);
        this.rightear.addBox(-2.0F, -2.0F, -0.5F, 2, 3, 1);
        this.setRotateAngle(rightear, -0.37960911230876665F, 0.17191493132144145F, -0.17715091907742445F);
        this.leftbackleg4 = new MowzieModelRenderer(this, 88, 38);
        this.leftbackleg4.setRotationPoint(0.0F, 4.25F, 0.0F);
        this.leftbackleg4.addBox(-2.0F, 0.0F, -1.75F, 4, 4, 4);
        this.setRotateAngle(leftbackleg4, -0.4363323129985824F, 0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 75, 8);
        this.neck.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.neck.addBox(-4.0F, -4.0F, -5.0F, 8, 8, 6);
        this.tail1 = new MowzieModelRenderer(this, 84, 8);
        this.tail1.setRotationPoint(0.0F, -5.0F, 8.0F);
        this.tail1.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6);
        this.setRotateAngle(tail1, -0.5235987755982988F, 0.0F, 0.0F);
        this.leftbottomhorn2 = new MowzieModelRenderer(this, 116, 6);
        this.leftbottomhorn2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.leftbottomhorn2.addBox(-1.75F, -3.5F, -1.75F, 3, 3, 3);
        this.rightfrontleg3 = new MowzieModelRenderer(this, 16, 86);
        this.rightfrontleg3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.rightfrontleg3.addBox(-1.5F, -0.75F, -1.5F, 4, 6, 4);
        this.setRotateAngle(rightfrontleg3, -0.6544984694978736F, 0.0F, 0.0F);
        this.rightbottomhorn3 = new MowzieModelRenderer(this, 116, 12);
        this.rightbottomhorn3.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.rightbottomhorn3.addBox(-1.5F, -3.0F, -1.5F, 2, 3, 2);
        this.upperfrontbody = new MowzieModelRenderer(this, 66, 0);
        this.upperfrontbody.setRotationPoint(0.0F, -0.25F, -5.0F);
        this.upperfrontbody.addBox(-7.5F, -7.0F, 0.0F, 15, 14, 8);
        this.setRotateAngle(upperfrontbody, 0.08726646259971647F, 0.0F, 0.0F);
        this.leftbackleg2 = new MowzieModelRenderer(this, 32, 86);
        this.leftbackleg2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leftbackleg2.addBox(-2.5F, -1.75F, -3.75F, 5, 5, 7);
        this.leftfrontleg3 = new MowzieModelRenderer(this, 16, 86);
        this.leftfrontleg3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leftfrontleg3.addBox(-2.5F, -0.75F, -1.5F, 4, 6, 4);
        this.setRotateAngle(leftfrontleg3, -0.6544984694978736F, 0.0F, 0.0F);
        this.leftbackleg3 = new MowzieModelRenderer(this, 64, 65);
        this.leftbackleg3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.leftbackleg3.addBox(-2.0F, -1.5F, -2.0F, 4, 7, 4);
        this.setRotateAngle(leftbackleg3, 0.6108652381980153F, 0.0F, 0.0F);
        this.mouth = new MowzieModelRenderer(this, 56, 76);
        this.mouth.setRotationPoint(0.0F, 2.3F, -1.0F);
        this.mouth.addBox(-3.0F, -0.5F, -12.5F, 6, 3, 12);
        this.setRotateAngle(mouth, -0.05235987755982988F, 0.0F, 0.0F);
        this.leftear = new MowzieModelRenderer(this, 100, 60);
        this.leftear.setRotationPoint(3.5F, -3.0F, 0.0F);
        this.leftear.addBox(0.0F, -2.0F, -0.5F, 2, 3, 1);
        this.setRotateAngle(leftear, -0.37960911230876665F, -0.17191493132144145F, 0.17715091907742445F);
        this.leftbottomhorn3 = new MowzieModelRenderer(this, 116, 12);
        this.leftbottomhorn3.setRotationPoint(0.0F, -3.5F, 0.0F);
        this.leftbottomhorn3.addBox(-0.75F, -3.0F, -1.75F, 2, 3, 2);
        this.chest = new MowzieModelRenderer(this, 76, 24);
        this.chest.setRotationPoint(0.0F, 5.0F, -2.0F);
        this.chest.addBox(-4.0F, -8.75F, -3.5F, 8, 8, 6);
        this.setRotateAngle(chest, -0.8922123136195012F, 0.0F, 0.0F);
        this.rightfrontleg2 = new MowzieModelRenderer(this, 0, 86);
        this.rightfrontleg2.setRotationPoint(0.0F, 2.75F, 0.0F);
        this.rightfrontleg2.addBox(-1.5F, 0.0F, -1.5F, 4, 7, 4);
        this.setRotateAngle(rightfrontleg2, 0.20943951023931953F, -0.0F, 0.0F);
        this.rightbottomhorn2 = new MowzieModelRenderer(this, 116, 6);
        this.rightbottomhorn2.setRotationPoint(0.25F, -2.5F, -0.25F);
        this.rightbottomhorn2.addBox(-1.5F, -3.0F, -1.5F, 3, 3, 3);
        this.rightbackleg1 = new MowzieModelRenderer(this, 28, 65);
        this.rightbackleg1.setRotationPoint(-7.0F, 0.0F, 1.75F);
        this.rightbackleg1.addBox(-3.0F, -4.5F, -4.0F, 8, 11, 10);
        this.setRotateAngle(rightbackleg1, 0.17453292519943295F, 0.0F, 0.0F);
        this.leftbackleg1 = new MowzieModelRenderer(this, 28, 65);
        this.leftbackleg1.setRotationPoint(7.0F, 0.0F, 1.7F);
        this.leftbackleg1.addBox(-5.0F, -4.5F, -4.0F, 8, 11, 10);
        this.setRotateAngle(leftbackleg1, 0.17453292519943295F, 0.0F, 0.0F);
        this.rightupperhorn = new MowzieModelRenderer(this, 116, 0);
        this.rightupperhorn.setRotationPoint(-2.5F, -3.0F, -4.0F);
        this.rightupperhorn.addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1);
        this.setRotateAngle(rightupperhorn, -0.5235987755982988F, 0.0F, 0.0F);
        this.leftbottomhorn1 = new MowzieModelRenderer(this, 116, 0);
        this.leftbottomhorn1.setRotationPoint(3.0F, -2.0F, -3.0F);
        this.leftbottomhorn1.addBox(-2.75F, -2.5F, -1.75F, 4, 2, 4);
        this.head = new MowzieModelRenderer(this, 0, 54);
        this.head.setRotationPoint(0.0F, -1.25F, -3.75F);
        this.head.addBox(-4.5F, -3.25F, -8.0F, 9, 8, 8);
        this.setRotateAngle(head, 0.3490658503988659F, 0.0F, 0.0F);
        this.rightbackleg3 = new MowzieModelRenderer(this, 64, 65);
        this.rightbackleg3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.rightbackleg3.addBox(-2.0F, -1.5F, -2.0F, 4, 7, 4);
        this.setRotateAngle(rightbackleg3, 0.6108652381980153F, 0.0F, 0.0F);
        this.leftfrontleg2 = new MowzieModelRenderer(this, 0, 86);
        this.leftfrontleg2.setRotationPoint(0.0F, 2.75F, 0.0F);
        this.leftfrontleg2.addBox(-2.5F, 0.0F, -1.5F, 4, 7, 4);
        this.setRotateAngle(leftfrontleg2, 0.20943951023931953F, -0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 85, 70);
        this.tail2.setRotationPoint(0.0F, 0.0F, 5.5F);
        this.tail2.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 3);
        this.bottomfrontbody = new MowzieModelRenderer(this, 66, 22);
        this.bottomfrontbody.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.bottomfrontbody.addBox(-7.0F, -4.0F, 0.5F, 14, 6, 10);
        this.setRotateAngle(bottomfrontbody, -0.11152653920243764F, -0.0F, 0.0F);
        this.middlebody = new MowzieModelRenderer(this, 0, 0);
        this.middlebody.setRotationPoint(0.0F, 5.5F, -14.5F);
        this.middlebody.addBox(-7.5F, -7.5F, 0.0F, 15, 15, 18);
        this.setRotateAngle(middlebody, 0.2617993877991494F, 0.0F, 0.0F);
        this.rightfrontleg4 = new MowzieModelRenderer(this, 88, 38);
        this.rightfrontleg4.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.rightfrontleg4.addBox(-1.5F, -0.35F, -1.5F, 4, 4, 4);
        this.setRotateAngle(rightfrontleg4, 0.2792526803190927F, 0.0F, 0.0F);
        this.leftfrontleg1 = new MowzieModelRenderer(this, 0, 68);
        this.leftfrontleg1.setRotationPoint(7.0F, 1.0F, 3.0F);
        this.leftfrontleg1.addBox(-4.0F, -4.0F, -2.0F, 6, 10, 8);
        this.setRotateAngle(leftfrontleg1, 0.17453292519943295F, -0.0F, 0.0F);
        this.rightbottomhorn1 = new MowzieModelRenderer(this, 116, 0);
        this.rightbottomhorn1.setRotationPoint(-3.0F, -2.0F, -3.0F);
        this.rightbottomhorn1.addBox(-1.25F, -2.5F, -1.75F, 4, 2, 4);
        this.setRotateAngle(rightbottomhorn1, 0.0F, 0.017453292519943295F, 0.0F);
        this.leftupperhorn = new MowzieModelRenderer(this, 116, 0);
        this.leftupperhorn.setRotationPoint(2.5F, -3.0F, -4.0F);
        this.leftupperhorn.addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1);
        this.setRotateAngle(leftupperhorn, -0.5235987755982988F, 0.0F, 0.0F);
        this.leftfrontleg4 = new MowzieModelRenderer(this, 88, 38);
        this.leftfrontleg4.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.leftfrontleg4.addBox(-2.5F, -0.35F, -1.5F, 4, 4, 4);
        this.setRotateAngle(leftfrontleg4, 0.2792526803190927F, 0.0F, 0.0F);
        this.upperbackbody = new MowzieModelRenderer(this, 0, 33);
        this.upperbackbody.setRotationPoint(0.0F, 6.75F, 8.0F);
        this.upperbackbody.addBox(-7.0F, -6.0F, 0.0F, 14, 12, 9);
        this.setRotateAngle(upperbackbody, -0.3490658503988659F, 0.0F, 0.0F);
        this.rightbackleg4 = new MowzieModelRenderer(this, 88, 38);
        this.rightbackleg4.setRotationPoint(0.0F, 4.25F, 0.0F);
        this.rightbackleg4.addBox(-2.0F, 0.0F, -1.75F, 4, 4, 4);
        this.setRotateAngle(rightbackleg4, -0.4363323129985824F, 0.0F, 0.0F);
        this.rightbackleg2 = new MowzieModelRenderer(this, 32, 86);
        this.rightbackleg2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.rightbackleg2.addBox(-2.5F, -1.75F, -3.75F, 5, 5, 7);
        this.headShakeController = new MowzieModelRenderer(this, 0, 0);
        this.headShakeController.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headShakeController.addBox(0, 0, 0, 0, 0, 0);

        this.upperbackbody.addChild(this.tail1);
        this.tail1.addChild(this.tail2);

        this.upperbackbody.addChild(this.rightbackleg1);
        this.rightbackleg1.addChild(this.rightbackleg2);
        this.rightbackleg2.addChild(this.rightbackleg3);
        this.rightbackleg3.addChild(this.rightbackleg4);

        this.upperbackbody.addChild(this.leftbackleg1);
        this.leftbackleg1.addChild(this.leftbackleg2);
        this.leftbackleg2.addChild(this.leftbackleg3);
        this.leftbackleg3.addChild(this.leftbackleg4);

        this.upperbackbody.addChild(this.middlebody);
        this.middlebody.addChild(this.upperfrontbody);

        this.upperfrontbody.addChild(this.leftfrontleg1);
        this.leftfrontleg1.addChild(this.leftfrontleg2);
        this.leftfrontleg2.addChild(this.leftfrontleg3);
        this.leftfrontleg3.addChild(this.leftfrontleg4);

        this.upperfrontbody.addChild(this.rightfrontleg1);
        this.rightfrontleg1.addChild(this.rightfrontleg2);
        this.rightfrontleg2.addChild(this.rightfrontleg3);
        this.rightfrontleg3.addChild(this.rightfrontleg4);

        this.upperfrontbody.addChild(this.chest);
        this.upperfrontbody.addChild(this.bottomfrontbody);
        this.upperfrontbody.addChild(this.neck);
        this.neck.addChild(this.head);
        this.head.addChild(this.rightear);
        this.head.addChild(this.leftear);
        this.head.addChild(this.leftupperhorn);
        this.head.addChild(this.rightupperhorn);
        this.head.addChild(this.mouth);
        this.head.addChild(this.snout);

        this.snout.addChild(this.leftbottomhorn1);
        this.leftbottomhorn1.addChild(this.leftbottomhorn2);
        this.leftbottomhorn2.addChild(this.leftbottomhorn3);

        this.snout.addChild(this.rightbottomhorn1);
        this.rightbottomhorn1.addChild(this.rightbottomhorn2);
        this.rightbottomhorn2.addChild(this.rightbottomhorn3);

        neckParts = new MowzieModelRenderer[] { head, neck };

        this.upperbackbody.updateDefaultPose();
        this.tail1.updateDefaultPose();
        this.leftbackleg1.updateDefaultPose();
        this.rightbackleg1.updateDefaultPose();
        this.middlebody.updateDefaultPose();
        this.tail2.updateDefaultPose();
        this.leftbackleg2.updateDefaultPose();
        this.leftbackleg3.updateDefaultPose();
        this.leftbackleg4.updateDefaultPose();
        this.rightbackleg2.updateDefaultPose();
        this.rightbackleg3.updateDefaultPose();
        this.rightbackleg4.updateDefaultPose();
        this.upperfrontbody.updateDefaultPose();
        this.chest.updateDefaultPose();
        this.leftfrontleg1.updateDefaultPose();
        this.rightfrontleg1.updateDefaultPose();
        this.neck.updateDefaultPose();
        this.bottomfrontbody.updateDefaultPose();
        this.leftfrontleg2.updateDefaultPose();
        this.leftfrontleg3.updateDefaultPose();
        this.leftfrontleg4.updateDefaultPose();
        this.rightfrontleg2.updateDefaultPose();
        this.rightfrontleg3.updateDefaultPose();
        this.rightfrontleg4.updateDefaultPose();
        this.head.updateDefaultPose();
        this.leftear.updateDefaultPose();
        this.rightear.updateDefaultPose();
        this.leftupperhorn.updateDefaultPose();
        this.rightupperhorn.updateDefaultPose();
        this.mouth.updateDefaultPose();
        this.snout.updateDefaultPose();
        this.leftbottomhorn1.updateDefaultPose();
        this.rightbottomhorn1.updateDefaultPose();
        this.leftbottomhorn2.updateDefaultPose();
        this.leftbottomhorn3.updateDefaultPose();
        this.rightbottomhorn2.updateDefaultPose();
        this.rightbottomhorn3.updateDefaultPose();
        headShakeController.updateDefaultPose();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.upperbackbody.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityArsinoitherium arsinoitherium) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, arsinoitherium);
        this.resetPose();

        // f = arsinoitherium.frame;
        // f1 = (float) Math.cos(f/50)*0.5F + 1F;
        // f1 = 0.5F;

        // Sprinting functionality parameters
        float sprintModifier = (float) (1 / (1 + Math.exp(30 * (-f1 + 0.92))));
        float legOffsetModifier = 2.5F;
        float bobBase = 2F;
        if (sprintModifier >= 0.9)
            bobBase = 1F;

        float globalSpeed = 0.6F;
        float globalDegree = 1.7F;
        float height = 0.7F;
        float frontOffset = -2.3F;
        float animationDegree = 2 - sprintModifier * 0.2F;

        faceTarget(f3, f4, 1.25F, head, neck, chest);

        bob(upperbackbody, bobBase * globalSpeed, height, false, f, f1);
        walk(upperbackbody, bobBase * globalSpeed, 0.1F * height, true, -1.5F, 0.03F, f, f1);
        walk(head, bobBase * globalSpeed, 0.1F * height, false, -0.5F, 0F, f, f1);
        upperbackbody.rotateAngleX += 0.1 * sprintModifier;
        head.rotateAngleX += 0.6 * sprintModifier;

        walk(leftbackleg1, 1F * globalSpeed, 0.2F * globalDegree * animationDegree, false, 0F + sprintModifier * legOffsetModifier, 0.1F + sprintModifier * -0.1F, f, f1);
        walk(leftbackleg3, 1F * globalSpeed, 0.2F * globalDegree * animationDegree - sprintModifier * 0.1F, true, 1F + sprintModifier * legOffsetModifier, 0F, f, f1);
        walk(leftbackleg4, 1F * globalSpeed, 0.2F * globalDegree * animationDegree - sprintModifier * 0.1F, false, -1.5F + sprintModifier * legOffsetModifier, 0.5F, f, f1);

        walk(rightbackleg1, 1F * globalSpeed, 0.2F * globalDegree * animationDegree, true, 0F, 0.1F + sprintModifier * -0.1F, f, f1);
        walk(rightbackleg3, 1F * globalSpeed, 0.2F * globalDegree * animationDegree - sprintModifier * 0.1F, false, 1F, 0F, f, f1);
        walk(rightbackleg4, 1F * globalSpeed, 0.2F * globalDegree * animationDegree - sprintModifier * 0.1F, true, -1.5F, 0.5F, f, f1);

        walk(leftfrontleg1, 1F * globalSpeed, 0.2F * globalDegree * animationDegree, true, frontOffset + 0F, -0.1F + sprintModifier * 0F, f, f1);
        walk(leftfrontleg3, 1F * globalSpeed, 0.1F * globalDegree * animationDegree, true, frontOffset + 1F, -0.2F, f, f1);
        walk(leftfrontleg4, 1F * globalSpeed, 0.2F * globalDegree * animationDegree - sprintModifier * 0.1F, false, frontOffset + 2F, 0.8F, f, f1);

        walk(rightfrontleg1, 1F * globalSpeed, 0.2F * globalDegree * animationDegree, false, frontOffset + 0F + sprintModifier * legOffsetModifier, -0.1F + sprintModifier * 0F, f, f1);
        walk(rightfrontleg3, 1F * globalSpeed, 0.1F * globalDegree * animationDegree, false, frontOffset + 1F + sprintModifier * legOffsetModifier, -0.2F, f, f1);
        walk(rightfrontleg4, 1F * globalSpeed, 0.2F * globalDegree * animationDegree - sprintModifier * 0.1F, true, frontOffset + 2F + sprintModifier * legOffsetModifier, 0.8F, f, f1);

        walk(tail1, bobBase * globalSpeed, 0.4F * height, false, 0F, 0F, f, f1);

        // Idling
        walk(neck, 0.1F, 0.05F, false, -1F, 0F, arsinoitherium.frame, 1F);
        walk(head, 0.1F, 0.05F, true, 0F, 0F, arsinoitherium.frame, 1F);
        walk(upperbackbody, 0.1F, 0.025F, false, 0F, 0F, arsinoitherium.frame, 1F);
        walk(rightbackleg1, 0.1F, 0.025F, true, 0F, 0F, arsinoitherium.frame, 1F);
        walk(leftbackleg1, 0.1F, 0.025F, true, 0F, 0F, arsinoitherium.frame, 1F);

        float inverseKinematicsConstant = 0.6F;
        walk(rightfrontleg1, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, arsinoitherium.frame, 1F);
        walk(rightfrontleg3, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, arsinoitherium.frame, 1F);
        walk(rightfrontleg4, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, arsinoitherium.frame, 1F);
        walk(leftfrontleg1, 0.1F, 0.1F * inverseKinematicsConstant, false, 0F, 0F, arsinoitherium.frame, 1F);
        walk(leftfrontleg3, 0.1F, 0.3F * inverseKinematicsConstant, true, 0F, 0F, arsinoitherium.frame, 1F);
        walk(leftfrontleg4, 0.1F, 0.175F * inverseKinematicsConstant, false, 0F, 0F, arsinoitherium.frame, 1F);
        // rightfrontleg1.rotationPointZ -= 1.3 * inverseKinematicsConstant * Math.cos(arsinoitherium.frame * 0.1F);
        // leftfrontleg1.rotationPointZ -= 1.3 * inverseKinematicsConstant * Math.cos(arsinoitherium.frame * 0.1F);
        //
        // chainSwing(tailParts, 0.1F, 0.05F, 2, arsinoitherium.frame, 1F);
        // chainWave(tailParts, 0.1F, -0.05F, 1, arsinoitherium.frame, 1F);
        //
        // triceratops.tailBuffer.applyChainSwingBuffer(this.tailParts);
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    private void resetPose() {
        this.upperbackbody.resetToDefaultPose();
        this.tail1.resetToDefaultPose();
        this.leftbackleg1.resetToDefaultPose();
        this.rightbackleg1.resetToDefaultPose();
        this.middlebody.resetToDefaultPose();
        this.tail2.resetToDefaultPose();
        this.leftbackleg2.resetToDefaultPose();
        this.leftbackleg3.resetToDefaultPose();
        this.leftbackleg4.resetToDefaultPose();
        this.rightbackleg2.resetToDefaultPose();
        this.rightbackleg3.resetToDefaultPose();
        this.rightbackleg4.resetToDefaultPose();
        this.upperfrontbody.resetToDefaultPose();
        this.chest.resetToDefaultPose();
        this.leftfrontleg1.resetToDefaultPose();
        this.rightfrontleg1.resetToDefaultPose();
        this.neck.resetToDefaultPose();
        this.bottomfrontbody.resetToDefaultPose();
        this.leftfrontleg2.resetToDefaultPose();
        this.leftfrontleg3.resetToDefaultPose();
        this.leftfrontleg4.resetToDefaultPose();
        this.rightfrontleg2.resetToDefaultPose();
        this.rightfrontleg3.resetToDefaultPose();
        this.rightfrontleg4.resetToDefaultPose();
        this.head.resetToDefaultPose();
        this.leftear.resetToDefaultPose();
        this.rightear.resetToDefaultPose();
        this.leftupperhorn.resetToDefaultPose();
        this.rightupperhorn.resetToDefaultPose();
        this.mouth.resetToDefaultPose();
        this.snout.resetToDefaultPose();
        this.leftbottomhorn1.resetToDefaultPose();
        this.rightbottomhorn1.resetToDefaultPose();
        this.leftbottomhorn2.resetToDefaultPose();
        this.leftbottomhorn3.resetToDefaultPose();
        this.rightbottomhorn2.resetToDefaultPose();
        this.rightbottomhorn3.resetToDefaultPose();
        headShakeController.resetToDefaultPose();
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, (EntityArsinoitherium) entity);

        if (entity.getAnimationId() == JurassiCraftAnimationIDs.CHARGE.animID()) {
            this.animator.setAnimation(JurassiCraftAnimationIDs.CHARGE.animID());
            this.animator.startPhase(3);
            this.animator.rotate(upperbackbody, 0.25F, 0, 0);
            this.animator.rotate(leftbackleg1, -0.25F, 0, 0);
            this.animator.rotate(rightbackleg1, -0.25F, 0, 0);
            this.animator.rotate(leftfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(rightfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(leftfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(rightfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(leftfrontleg4, 0.4F, 0, 0);
            this.animator.rotate(rightfrontleg4, 0.4F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.startPhase(4);
            this.animator.rotate(upperbackbody, -0.2F, 0, 0);
            this.animator.rotate(leftbackleg1, 0.2F, 0, 0);
            this.animator.rotate(rightbackleg1, 0.2F, 0, 0);
            this.animator.rotate(neck, 0.25F, 0, 0);
            this.animator.rotate(head, 0.25F, 0, 0);
            this.animator.rotate(leftfrontleg1, -0.1F, 0, 0);
            this.animator.move(leftfrontleg1, 0, 2, -1);
            this.animator.rotate(rightfrontleg1, 0.8F, 0, 0);
            this.animator.rotate(leftfrontleg3, 0.5F, 0, 0);
            this.animator.rotate(rightfrontleg3, -1.4F, 0, 0);
            this.animator.rotate(leftfrontleg4, -0.3F, 0, 0);
            this.animator.rotate(rightfrontleg4, 0.6F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.startPhase(4);
            this.animator.rotate(upperbackbody, 0.25F, 0, 0);
            this.animator.rotate(leftbackleg1, -0.25F, 0, 0);
            this.animator.rotate(rightbackleg1, -0.25F, 0, 0);
            this.animator.rotate(leftfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(rightfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(leftfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(rightfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(leftfrontleg4, 0.4F, 0, 0);
            this.animator.rotate(rightfrontleg4, 0.4F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.startPhase(4);
            this.animator.rotate(upperbackbody, -0.2F, 0, 0);
            this.animator.rotate(leftbackleg1, 0.2F, 0, 0);
            this.animator.rotate(rightbackleg1, 0.2F, 0, 0);
            this.animator.rotate(neck, 0.25F, 0, 0);
            this.animator.rotate(head, 0.25F, 0, 0);
            this.animator.rotate(leftfrontleg1, -0.1F, 0, 0);
            this.animator.move(leftfrontleg1, 0, 2, -1);
            this.animator.rotate(rightfrontleg1, 0.8F, 0, 0);
            this.animator.rotate(leftfrontleg3, 0.5F, 0, 0);
            this.animator.rotate(rightfrontleg3, -1.4F, 0, 0);
            this.animator.rotate(leftfrontleg4, -0.3F, 0, 0);
            this.animator.rotate(rightfrontleg4, 0.6F, 0, 0);
            this.animator.endPhase();
            this.animator.setStationaryPhase(1);
            this.animator.startPhase(4);
            this.animator.rotate(upperbackbody, 0.25F, 0, 0);
            this.animator.rotate(leftbackleg1, -0.25F, 0, 0);
            this.animator.rotate(rightbackleg1, -0.25F, 0, 0);
            this.animator.rotate(leftfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(rightfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(leftfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(rightfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(leftfrontleg4, 0.4F, 0, 0);
            this.animator.rotate(rightfrontleg4, 0.4F, 0, 0);
            this.animator.endPhase();
            this.animator.startPhase(5);
            this.animator.rotate(upperbackbody, 0.25F, 0, 0);
            this.animator.rotate(leftbackleg1, -0.25F, 0, 0);
            this.animator.rotate(rightbackleg1, -0.25F, 0, 0);
            this.animator.rotate(leftfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(rightfrontleg1, 0.3F, 0, 0);
            this.animator.rotate(leftfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(rightfrontleg3, -0.9F, 0, 0);
            this.animator.rotate(leftfrontleg4, 0.4F, 0, 0);
            this.animator.rotate(rightfrontleg4, 0.4F, 0, 0);
            animator.move(headShakeController, 1, 0, 0);
            this.animator.endPhase();
            animator.setStationaryPhase(10);
            animator.resetPhase(5);
            this.animator.setStationaryPhase(57);
            chainSwing(neckParts, 1F, 0.2F * headShakeController.rotationPointX, 0, ((EntityArsinoitherium) entity).frame, 1F);
        }
    }
}
