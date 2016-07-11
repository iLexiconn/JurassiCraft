package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLowSecurityFenceGrid extends ModelBase {
    ModelRenderer reja2;
    ModelRenderer reja3;
    ModelRenderer reja4;
    ModelRenderer reja1;

    public ModelLowSecurityFenceGrid() {
        reja2 = new ModelRenderer(this, 17, 25);
        reja2.setTextureSize(64, 64);
        reja2.addBox(-8F, -0.5F, -0.5F, 16, 1, 1);
        reja2.setRotationPoint(0F, 23F, 0F);

        reja3 = new ModelRenderer(this, 17, 25);
        reja3.setTextureSize(64, 64);
        reja3.addBox(-8F, -0.5F, -0.5F, 16, 1, 1);
        reja3.setRotationPoint(0F, 15F, 0F);

        reja4 = new ModelRenderer(this, 17, 25);
        reja4.setTextureSize(64, 64);
        reja4.addBox(-8F, -0.5F, -0.5F, 16, 1, 1);
        reja4.setRotationPoint(0F, 11F, 0F);

        reja1 = new ModelRenderer(this, 17, 25);
        reja1.setTextureSize(64, 64);
        reja1.addBox(-8F, -0.5F, -0.5F, 16, 1, 1);
        reja1.setRotationPoint(0F, 19F, 0F);
    }

    public void render(Entity entity, float armSwing, float armSwingAmount, float par4, float par5, float par6, float partialTicks) {
        reja2.rotateAngleX = 0F;
        reja2.rotateAngleY = 0F;
        reja2.rotateAngleZ = 0F;
        reja2.renderWithRotation(partialTicks);

        reja3.rotateAngleX = 0F;
        reja3.rotateAngleY = 0F;
        reja3.rotateAngleZ = 0F;
        reja3.renderWithRotation(partialTicks);

        reja4.rotateAngleX = 0F;
        reja4.rotateAngleY = 0F;
        reja4.rotateAngleZ = 0F;
        reja4.renderWithRotation(partialTicks);

        reja1.rotateAngleX = 0F;
        reja1.rotateAngleY = 0F;
        reja1.rotateAngleZ = 0F;
        reja1.renderWithRotation(partialTicks);
    }
}
