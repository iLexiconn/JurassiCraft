package net.ilexiconn.jurassicraft.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLowSecurityFencePole extends ModelBase {
    ModelRenderer side1;
    ModelRenderer luz;
    ModelRenderer luz1;

    public ModelLowSecurityFencePole() {
        side1 = new ModelRenderer(this, 2, 31);
        side1.setTextureSize(128, 64);
        side1.addBox(-3F, -8F, -3F, 6, 16, 6);
        side1.setRotationPoint(0F, 16F, 0F);

        luz = new ModelRenderer(this, 50, 17);
        luz.setTextureSize(128, 64);
        luz.addBox(-1F, -1F, -1F, 2, 2, 2);
        luz.setRotationPoint(-2F, 8F, 0F);

        luz1 = new ModelRenderer(this, 65, 9);
        luz1.setTextureSize(128, 64);
        luz1.addBox(-1F, -1F, -1F, 2, 2, 2);
        luz1.setRotationPoint(2F, 8F, 0F);
    }

    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float partialTicks) {
        side1.renderWithRotation(partialTicks);
        luz.renderWithRotation(partialTicks);
        luz1.renderWithRotation(partialTicks);
    }
}