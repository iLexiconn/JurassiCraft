package net.ilexiconn.jurassicraft.common.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.ilexiconn.jurassicraft.client.gui.GuiCultivate;
import net.ilexiconn.jurassicraft.client.gui.GuiDNACombinator;
import net.ilexiconn.jurassicraft.client.gui.GuiDNAExtractor;
import net.ilexiconn.jurassicraft.client.gui.GuiSecurityFenceLow;
import net.ilexiconn.jurassicraft.common.container.ContainerCultivate;
import net.ilexiconn.jurassicraft.common.container.ContainerDNACombinator;
import net.ilexiconn.jurassicraft.common.container.ContainerDNAExtractor;
import net.ilexiconn.jurassicraft.common.container.ContainerSecurityFenceLow;
import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNACombinator;
import net.ilexiconn.jurassicraft.common.tileentity.TileDNAExtractor;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowCorner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate && id == 0)
            return new ContainerCultivate(player.inventory, (TileCultivate) tileEntity);
        if (tileEntity instanceof TileDNAExtractor)
            return new ContainerDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
        if (tileEntity instanceof TileDNACombinator)
            return new ContainerDNACombinator(player.inventory, (TileDNACombinator) tileEntity);
        if (tileEntity instanceof TileSecurityFenceLowCorner)
            return new ContainerSecurityFenceLow(player.inventory, (TileSecurityFenceLowCorner) tileEntity);

        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileCultivate && id == 0)
            return new GuiCultivate(player.inventory, (TileCultivate) tileEntity);
        if (tileEntity instanceof TileDNAExtractor)
            return new GuiDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
        if (tileEntity instanceof TileDNACombinator)
            return new GuiDNACombinator(player.inventory, (TileDNACombinator) tileEntity);
        if (tileEntity instanceof TileSecurityFenceLowCorner)
            return new GuiSecurityFenceLow(player.inventory, (TileSecurityFenceLowCorner) tileEntity);

        return null;
    }
}
