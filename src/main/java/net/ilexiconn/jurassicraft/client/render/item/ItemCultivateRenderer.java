package net.ilexiconn.jurassicraft.client.render.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.block.ModelCultivate;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemCultivateRenderer implements IItemRenderer {
    public String[] colors = { "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };
    public ModelCultivate model = new ModelCultivate();
    public ResourceLocation[] textures;

    public ItemCultivateRenderer() {
        textures = new ResourceLocation[colors.length];

        for (int i = 0; i < colors.length; i++)
            textures[i] = new ResourceLocation(JurassiCraft.getModId() + "textures/blocks/cultivate_" + colors[i] + ".png");
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

                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

                GL11.glRotatef(180f, 0.0f, 0.0f, 1.0f);

                if (renderType == 0) {
                    GL11.glScalef(0.25f, 0.25f, 0.25f);

                    GL11.glRotatef(15f, 0.0f, 0.0f, 1.0f);

                    GL11.glTranslatef(-3.0f, 1.0f, 0.0f);

                    if (!firstPerson) {
                        GL11.glTranslatef(1.0f, -3.0f, 0.0f);
                        GL11.glRotatef(-135f, 1.0f, -1.0f, -0.3f);

                        GL11.glScalef(3f, 3f, 3f);
                        GL11.glRotatef(-7.5f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(80f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(10f, 1.0f, 0.0f, 1.0f);
                    } else {
                        GL11.glScalef(4f, 4f, 4f);
                        GL11.glTranslatef(0f, -0.5f, 0f);
                    }
                } else if (renderType == 1) {
                    GL11.glScalef(-6.2f, -6.2f, -6.2f);

                    GL11.glRotatef(35f, 1.0f, 0.0f, 0.0f);

                    GL11.glRotatef(-50f, 0.0f, 1.0f, 0.0f);

                    GL11.glTranslatef(3.08f, 3.1f, 0.9f);
                } else if (renderType == 2) {
                    GL11.glTranslatef(0.0f, -0.8f, 0.0f);
                    GL11.glScalef(0.6f, 0.6f, 0.6f);
                }

                Minecraft.getMinecraft().getTextureManager().bindTexture(textures[item.getItemDamage()]);

                model.render(true);

                GL11.glDisable(GL11.GL_BLEND);

                GL11.glPopMatrix();
            }
            default:
                break;
        }
    }
}