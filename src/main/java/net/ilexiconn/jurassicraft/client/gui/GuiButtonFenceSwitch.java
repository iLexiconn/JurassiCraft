package net.ilexiconn.jurassicraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButtonFenceSwitch extends GuiButton {
    private int xTexPos;
    private int yTexPos;
    private boolean state;

    public GuiButtonFenceSwitch(int id, int xPos, int yPos, int xguiPosition, int yguiPosition, int width, int height, boolean state) {
        super(id, xPos, yPos, width, height, "");
        this.xTexPos = xguiPosition;
        this.yTexPos = yguiPosition;
        this.state = state;
    }

    public void drawButton(Minecraft mc, int x, int y) {
        mc.renderEngine.bindTexture(new ResourceLocation(JurassiCraft.getModId() + "textures/gui/guiSecurityFenceWidgets.png"));

        if (this.enabled) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            if (this.state)
                this.drawTexturedModalRect(this.xPosition, this.yPosition, this.xTexPos, this.yTexPos, this.width, this.height);
            else
                this.drawTexturedModalRect(this.xPosition, this.yPosition, this.xTexPos, this.yTexPos + 1 * this.height, this.width, this.height);

            this.mouseDragged(mc, x, y);
        } else {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, this.xTexPos, this.yTexPos + 2 * this.height, this.width, this.height);
            this.mouseDragged(mc, x, y);
        }
    }

    public void setState(boolean onORoff) {
        this.state = onORoff;
    }

    public void toggleState() {
        this.state = !this.state;
    }
}
