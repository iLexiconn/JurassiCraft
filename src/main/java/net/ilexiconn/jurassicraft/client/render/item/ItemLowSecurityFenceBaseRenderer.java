package net.ilexiconn.jurassicraft.client.render.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.block.ModelLowSecurityFenceBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemLowSecurityFenceBaseRenderer implements IItemRenderer {
    public ModelLowSecurityFenceBase model = new ModelLowSecurityFenceBase();
    public ResourceLocation texture;

    public ItemLowSecurityFenceBaseRenderer() {
        texture = new ResourceLocation(JurassiCraft.getModId() + "textures/blocks/fence/low_security_fence_base.png");
    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        switch (helper) {
            case ENTITY_ROTATION:
                return true;
            case ENTITY_BOBBING:
                return true;
            default:
                return false;
        }
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        boolean firstPerson = false;
        int renderType = 0;

        switch (type) {
            case ENTITY:
                renderType = 2;
            case INVENTORY:
                if (renderType == 0)
                    renderType = 1;
            case EQUIPPED_FIRST_PERSON:
                if (renderType == 0)
                    firstPerson = true;
            case EQUIPPED: {
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

                GL11.glPushMatrix();

                GL11.glRotatef(180f, 0.0f, 0.0f, 1.0f);

                if (renderType == 0) //Hand
                {
                    GL11.glScalef(0.25f, 0.25f, 0.25f);

                    GL11.glRotatef(15f, 0.0f, 0.0f, 1.0f);

                    GL11.glTranslatef(-3.0f, 1.0f, 0.0f);

                    if (!firstPerson) {
                        GL11.glTranslatef(1.5f, -3.0f, -1.25f);
                        GL11.glRotatef(-135f, 1.0f, -1.0f, -0.3f);

                        GL11.glScalef(3f, 3f, 3f);
                        GL11.glRotatef(-7.5f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(80f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(10f, 1.0f, 0.0f, 1.0f);
                    } else {
                        GL11.glScalef(4f, 4f, 4f);
                        GL11.glTranslatef(0f, -1.5f, 0f);
                    }
                } else if (renderType == 1) //Inventory
                {
                    GL11.glScalef(-12.0F, -12.0F, -12.0F);

                    GL11.glRotatef(35f, 1.0f, 0.0f, 0.0f);

                    GL11.glRotatef(45F, 0.0f, 1.0f, 0.0f);

                    GL11.glTranslatef(0.95F, -0.9F, 0.0F);
                } else if (renderType == 2) //Ground
                {
                    GL11.glTranslatef(0.0f, -0.8f, 0.0f);
                    GL11.glScalef(0.6f, 0.6f, 0.6f);
                }

                Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

                RenderHelper.enableGUIStandardItemLighting();

                model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
            }
            default:
                break;
        }
    }
}