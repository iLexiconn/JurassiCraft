package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLowSecurityFenceBase extends ModelBase {
    ModelRenderer bottom;
    ModelRenderer bottom1;
    ModelRenderer bottom2;

    public ModelLowSecurityFenceBase() {
        bottom = new ModelRenderer(this, 0, 1);
        bottom.setTextureSize(64, 32);
        bottom.addBox(-8F, -3.5F, -4.5F, 16, 7, 9);
        bottom.setRotationPoint(0F, 21F, 0F);

        bottom1 = new ModelRenderer(this, 0, 17);
        bottom1.setTextureSize(64, 32);
        bottom1.addBox(-8F, -1F, -1F, 16, 2, 2);
        bottom1.setRotationPoint(0F, 21F, -5F);

        bottom2 = new ModelRenderer(this, 0, 17);
        bottom2.setTextureSize(64, 32);
        bottom2.addBox(-8F, -1F, -1F, 16, 2, 2);
        bottom2.setRotationPoint(0F, 21F, 5F);
    }

    public void render(Entity entity, float armSwing, float armSwingAmount, float par4, float par5, float par6, float partialTicks) {
        bottom.rotateAngleX = 0F;
        bottom.rotateAngleY = 0F;
        bottom.rotateAngleZ = 0F;
        bottom.renderWithRotation(partialTicks);

        bottom1.rotateAngleX = 0F;
        bottom1.rotateAngleY = 0F;
        bottom1.rotateAngleZ = 0F;
        bottom1.renderWithRotation(partialTicks);

        bottom2.rotateAngleX = 0F;
        bottom2.rotateAngleY = 0F;
        bottom2.rotateAngleZ = 0F;
        bottom2.renderWithRotation(partialTicks);
    }
}