package net.ilexiconn.jurassicraft.client.model.animation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Transform {
    public float rotX, rotY, rotZ;
    public float offsetX, offsetY, offsetZ;

    public Transform() {
        rotX = rotY = rotZ = 0f;
        offsetX = offsetY = offsetZ = 0f;
    }

    public Transform(float rx, float ry, float rz) {
        rotX = rx;
        rotY = ry;
        rotZ = rz;
        offsetX = offsetY = offsetZ = 0F;
    }

    public Transform(float x, float y, float z, float rx, float ry, float rz) {
        this(rx, ry, rz);
        offsetX = x;
        offsetY = y;
        offsetZ = z;
    }

    public void addRot(float x, float y, float z) {
        rotX += x;
        rotY += y;
        rotZ += z;
    }

    public void addOffset(float x, float y, float z) {
        offsetX += x;
        offsetY += y;
        offsetZ += z;
    }
}
