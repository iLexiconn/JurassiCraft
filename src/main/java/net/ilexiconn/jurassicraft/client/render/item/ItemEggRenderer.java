package net.ilexiconn.jurassicraft.client.render.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.client.model.block.ModelEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemEggRenderer implements IItemRenderer {
    public ModelEgg model = new ModelEgg();
    public String dino;

    public ItemEggRenderer(String dinoName) {
        dino = dinoName;
    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        switch (helper) {
            case ENTITY_ROTATION:
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
            case ENTITY: {
                renderType = 2;
            }
            case INVENTORY: {
                if (renderType == 0) {
                    renderType = 1;
                }
            }
            case EQUIPPED_FIRST_PERSON: {
                if (renderType == 0) {
                    firstPerson = true;
                }
            }
            case EQUIPPED: {
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

                GL11.glPushMatrix();

                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

                GL11.glRotatef(180f, 0.0f, 0.0f, 1.0f);

                float scale = (renderType == 1 ? 6.2f : renderType == 2 ? 0.3f : 0.55f) * 0.5f;

                if (renderType == 0) {
                    GL11.glScalef(scale, scale, scale);

                    GL11.glRotatef(15f, 0.0f, 0.0f, 1.0f);

                    GL11.glTranslatef(-3.0f, 1.0f, 0.0f);

                    if (!firstPerson) {
                        float scale1 = 8f;
                        GL11.glTranslatef(3f, -9.0f, -7.0f);
                        GL11.glRotatef(-135f, 1.0f, -1.0f, -0.3f);

                        GL11.glScalef(scale1, scale1, scale1);
                        GL11.glRotatef(-7.5f, 0.0f, 1.0f, 0.0f);
                        GL11.glRotatef(80f, 0.0f, 0.0f, 1.0f);
                        GL11.glRotatef(10f, 1.0f, 0.0f, 1.0f);
                    } else {
                        GL11.glScalef(5f, 5f, 5f);
                        GL11.glTranslatef(0f, -1.6f, 0f);
                    }
                } else if (renderType == 1) {
                    GL11.glScalef(-scale * 6, -scale * 6, -scale * 6);

                    GL11.glRotatef(35f, 1.0f, 0.0f, 0.0f);

                    GL11.glRotatef(-50f, 0.0f, 1.0f, 0.0f);

                    GL11.glTranslatef(2.7f, 1.5f, 1.7f);
                } else if (renderType == 2) {
                    GL11.glTranslatef(0.0f, -0.8f, 0.0f);
                    GL11.glScalef(scale * 4, scale * 4, scale * 4);
                }

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/eggs/egg" + dino + ".png"));

                model.render();

                GL11.glDisable(GL11.GL_BLEND);

                GL11.glPopMatrix();
            }
            default: {
                if (renderType == 0)
                    firstPerson = true;
            }
        }
    }
}
