package net.ilexiconn.jurassicraft.client.model.block;

import net.ilexiconn.jurassicraft.client.model.base.MowzieModelBase;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.ilexiconn.jurassicraft.client.model.base.MowzieModelRenderer;
import net.minecraft.util.MathHelper;

public class ModelEmbryo extends MowzieModelBase {
    public MowzieModelRenderer[] shapes = new MowzieModelRenderer[9];

    public ModelEmbryo() {
        textureWidth = 128;
        textureHeight = 128;

        shapes[0] = new MowzieModelRenderer(this, 30, 0); // Body
        shapes[0].addBox(-1f, 0f, -1f, 2, 5, 3);
        shapes[0].setRotationPoint(0f, 0f, 0f);
        shapes[0].setRotationAngles(0.1745329f, 0f, 0f);

        shapes[1] = new MowzieModelRenderer(this, 22, 0); // Neck
        shapes[1].addBox(-0.5f, 0f, 0f, 1, 3, 2);
        shapes[1].setRotationPoint(0f, -0.5f, -2f);
        shapes[1].setRotationAngles(0.8726646f, 0f, 0f);

        shapes[2] = new MowzieModelRenderer(this, 0, 0); // Head
        shapes[2].addBox(0f, -0.5f, 0.3f, 2, 2, 3);
        shapes[2].setRotationPoint(-1f, -2.5f, -1f);
        shapes[2].setRotationAngles(-1.972222f, 0f, 0f);

        shapes[3] = new MowzieModelRenderer(this, 52, 0); // Tail1
        shapes[3].addBox(0f, 1f, 0f, 1, 4, 1);
        shapes[3].setRotationPoint(-0.5f, 6f, 1.7f);
        shapes[3].setRotationAngles(-0.6108652f, 0f, 0f);

        shapes[4] = new MowzieModelRenderer(this, 42, 0); // Tail2
        shapes[4].addBox(0f, 0f, 0f, 2, 3, 2);
        shapes[4].setRotationPoint(-1f, 4f, 0.8f);
        shapes[4].setRotationAngles(-0.2617994f, 0f, 0f);

        shapes[5] = new MowzieModelRenderer(this, 20, 8); // ArmTop1
        shapes[5].addBox(0f, 0f, 0f, 1, 2, 1);
        shapes[5].setRotationPoint(1f, 0.5f, -0.5f);
        shapes[5].setRotationAngles(-0.3490659f, 0f, 0f);

        shapes[6] = new MowzieModelRenderer(this, 20, 13); // ArmTop2
        shapes[6].addBox(0f, 0f, 0f, 1, 2, 1);
        shapes[6].setRotationPoint(-2f, 0.5f, -0.5f);
        shapes[6].setRotationAngles(-0.3490659f, 0f, 0f);

        shapes[7] = new MowzieModelRenderer(this, 44, 8); // ArmBottom1
        shapes[7].addBox(0f, 0f, 0f, 1, 3, 1);
        shapes[7].setRotationPoint(1f, 3f, 0.5f);
        shapes[7].setRotationAngles(-0.4363323f, 0f, 0f);

        shapes[8] = new MowzieModelRenderer(this, 44, 14); // ArmBottom2
        shapes[8].addBox(0f, 0f, 0f, 1, 3, 1);
        shapes[8].setRotationPoint(-2f, 3f, 0.5f);
        shapes[8].setRotationAngles(-0.4363323f, 0f, 0f);

        addChildTo(shapes[2], shapes[1]);
        addChildTo(shapes[1], shapes[0]);
        addChildTo(shapes[5], shapes[0]);
        addChildTo(shapes[6], shapes[0]);
        addChildTo(shapes[7], shapes[0]);
        addChildTo(shapes[8], shapes[0]);
        addChildTo(shapes[3], shapes[4]);
        addChildTo(shapes[4], shapes[0]);

        // Corrections
        shapes[1].rotationPointZ -= 3.5;
        shapes[1].rotationPointY -= 1.9;
        shapes[2].rotationPointZ += 4.2;
        shapes[2].rotationPointY -= 1;

        for (MowzieModelRenderer shape : shapes) {
            shape.setTextureSize(128, 128);
            shape.updateDefaultPose();
        }
    }

    public void render(TileCultivate tile) {
        shapes[0].render(0.0625f);
        /*
         * shapes[1].render(0.0625f); shapes[2].render(0.0625f); shapes[3].render(0.0625f); shapes[4].render(0.0625f); shapes[5].render(0.0625f); shapes[6].render(0.0625f); shapes[7].render(0.0625f); shapes[8].render(0.0625f);
         */

        for (MowzieModelRenderer shape : shapes) {
            shape.resetToDefaultPose();
        }

        MowzieModelRenderer[] BodyParts = { shapes[2], shapes[1], shapes[0], shapes[3], shapes[4] };
        shapes[0].rotationPointY -= MathHelper.cos(tile.animationTick * 0.05f) * 1;
        chainWave(BodyParts, 0.05f, 0.1f, 1, tile.animationTick, 1f);
        shapes[5].rotateAngleX += MathHelper.cos(tile.animationTick * 0.05f - 5) * 0.2;
        shapes[6].rotateAngleX += MathHelper.cos(tile.animationTick * 0.05f - 5) * 0.2;
        shapes[7].rotateAngleX += MathHelper.cos(tile.animationTick * 0.05f - 5) * 0.2;
        shapes[8].rotateAngleX += MathHelper.cos(tile.animationTick * 0.05f - 5) * 0.2;
        shapes[0].rotateAngleX += -0.1 * MathHelper.cos(tile.animationTick * 0.05f);
        shapes[0].rotateAngleY += 0.005 * tile.animationTick;
    }
}