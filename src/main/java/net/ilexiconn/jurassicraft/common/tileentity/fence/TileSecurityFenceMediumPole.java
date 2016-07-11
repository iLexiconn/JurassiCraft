package net.ilexiconn.jurassicraft.common.tileentity.fence;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileSecurityFenceMediumPole extends TileEntity {
    private boolean[] builtFences = new boolean[4];

    public TileSecurityFenceMediumPole() {
        for (int i = 0; i < builtFences.length; i++)
            builtFences[i] = false;
    }

    public void setGridAtSide(int side, boolean flag) {
        this.builtFences[side] = flag;
        if (this.worldObj != null)
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
    }

    public boolean getGridAtSide(int side) {
        return this.builtFences[side];
    }

    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        for (int i = 0; i < builtFences.length; i++)
            compound.setBoolean("GridAtSide" + i, this.getGridAtSide(i));
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        for (int i = 0; i < builtFences.length; i++)
            this.setGridAtSide(i, compound.getBoolean("GridAtSide" + i));
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        this.writeToNBT(compound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, compound);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        NBTTagCompound compound = packet.func_148857_g();
        this.readFromNBT(compound);
    }
}
