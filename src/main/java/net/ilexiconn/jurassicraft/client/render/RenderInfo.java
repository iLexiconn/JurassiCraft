package net.ilexiconn.jurassicraft.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderInfo {
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;
    public Block baseBlock = Blocks.dirt;
    public IIcon texture = null;
    public IIcon[] textureArray = null;
    public boolean[] renderSide = new boolean[6];
    public float light = -1f;
    public int brightness = -1;

    public RenderInfo() {
        setRenderAllSides();
    }

    public RenderInfo(Block template, IIcon[] texture) {
        this();
        baseBlock = template;
        textureArray = texture;
    }

    public RenderInfo(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        this();
        setBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public final void setBounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public final void setRenderAllSides() {
        Arrays.fill(renderSide, true);
    }

    public IIcon getBlockTextureFromSide(int side) {
        if (texture != null)
            return texture;

        if (textureArray == null || textureArray.length == 0)
            return baseBlock.getBlockTextureFromSide(side);
        else if (side >= textureArray.length)
            side = 0;

        return textureArray[side];
    }
}