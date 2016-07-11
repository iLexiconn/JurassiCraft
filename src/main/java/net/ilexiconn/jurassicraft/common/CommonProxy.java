package net.ilexiconn.jurassicraft.common;

import net.ilexiconn.jurassicraft.common.tileentity.TileCultivate;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;

public class CommonProxy {
    public float getPartialTick() {
        return 1f;
    }

    public World getWorldClient() {
        return null;
    }

    public void renderEntity(Class<? extends EntityLiving> entity, RenderLiving renderLiving) {
    }

    public void renderTileEntity(Class<? extends TileEntity> tileEntity, TileEntitySpecialRenderer renderer) {
    }

    public void renderItem(Item item, IItemRenderer render) {
    }

    public void init() throws Exception {
    }

    public void openCultivatorProgress(TileCultivate tile) {
    }

    public void openDinoPad(Entity entity) {
    }
}
