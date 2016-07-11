package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCompressor extends ModelBase {
    // fields
    ModelRenderer compressorBase;
    ModelRenderer compressorSlab;
    ModelRenderer buttonBase1;
    ModelRenderer buttonTop1;
    ModelRenderer buttonBase2;
    ModelRenderer buttonTop2;
    ModelRenderer buttonBase3;
    ModelRenderer buttonTop3;
    ModelRenderer compressorTopSlab1;
    ModelRenderer compressorTobSlab2;
    ModelRenderer openStuff;

    public ModelCompressor() {
        textureWidth = 128;
        textureHeight = 64;

        compressorBase = new ModelRenderer(this, 0, 0);
        compressorBase.addBox(0F, 0F, 0F, 12, 13, 12);
        compressorBase.setRotationPoint(-6F, 10F, -6F);
        compressorBase.setTextureSize(128, 64);
        compressorBase.mirror = true;

        compressorSlab = new ModelRenderer(this, 0, 25);
        compressorSlab.addBox(0F, 0F, 0F, 16, 2, 16);
        compressorSlab.setRotationPoint(-8F, 22F, -8F);
        compressorSlab.setTextureSize(128, 64);
        compressorSlab.mirror = true;

        buttonBase1 = new ModelRenderer(this, 70, 4);
        buttonBase1.addBox(0F, 0F, 0F, 4, 4, 1);
        buttonBase1.setRotationPoint(-2F, 14F, 6F);
        buttonBase1.setTextureSize(128, 64);
        buttonBase1.mirror = true;

        buttonTop1 = new ModelRenderer(this, 70, 0);
        buttonTop1.addBox(0F, 0F, 0F, 2, 2, 1);
        buttonTop1.setRotationPoint(-1F, 15F, 7F);
        buttonTop1.setTextureSize(128, 64);
        buttonTop1.mirror = true;

        buttonBase2 = new ModelRenderer(this, 70, 10);
        buttonBase2.addBox(0F, 0F, 0F, 1, 4, 4);
        buttonBase2.setRotationPoint(6F, 14F, -2F);
        buttonBase2.setTextureSize(128, 64);
        buttonBase2.mirror = true;

        buttonTop2 = new ModelRenderer(this, 70, 19);
        buttonTop2.addBox(0F, 0F, 0F, 1, 2, 2);
        buttonTop2.setRotationPoint(7F, 15F, -1F);
        buttonTop2.setTextureSize(128, 64);
        buttonTop2.mirror = true;

        buttonBase3 = new ModelRenderer(this, 70, 10);
        buttonBase3.addBox(0F, 0F, 0F, 1, 4, 4);
        buttonBase3.setRotationPoint(-7F, 14F, -2F);
        buttonBase3.setTextureSize(128, 64);
        buttonBase3.mirror = true;

        buttonTop3 = new ModelRenderer(this, 70, 19);
        buttonTop3.addBox(0F, 0F, 0F, 1, 2, 2);
        buttonTop3.setRotationPoint(-8F, 15F, -1F);
        buttonTop3.setTextureSize(128, 64);
        buttonTop3.mirror = true;

        compressorTopSlab1 = new ModelRenderer(this, 32, 43);
        compressorTopSlab1.addBox(0F, 0F, 0F, 10, 1, 10);
        compressorTopSlab1.setRotationPoint(-5F, 9F, -5F);
        compressorTopSlab1.setTextureSize(128, 64);
        compressorTopSlab1.mirror = true;

        compressorTobSlab2 = new ModelRenderer(this, 0, 45);
        compressorTobSlab2.addBox(0F, 0F, 0F, 8, 1, 8);
        compressorTobSlab2.setRotationPoint(-4F, 8F, -4F);
        compressorTobSlab2.setTextureSize(128, 64);
        compressorTobSlab2.mirror = true;

        openStuff = new ModelRenderer(this, 70, 24);
        openStuff.addBox(0F, 0F, 0F, 9, 6, 1);
        openStuff.setRotationPoint(-4.5F, 13F, -7F);
        openStuff.setTextureSize(128, 64);
        openStuff.mirror = true;
    }

    public void render() {
        compressorBase.render(0.0625F);
        compressorSlab.render(0.0625F);
        buttonBase1.render(0.0625F);
        buttonTop1.render(0.0625F);
        buttonBase2.render(0.0625F);
        buttonTop2.render(0.0625F);
        buttonBase3.render(0.0625F);
        buttonTop3.render(0.0625F);
        compressorTopSlab1.render(0.0625F);
        compressorTobSlab2.render(0.0625F);
        openStuff.render(0.0625F);
    }
}
