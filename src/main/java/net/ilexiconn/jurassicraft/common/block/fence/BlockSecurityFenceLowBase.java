package net.ilexiconn.jurassicraft.common.block.fence;

import net.ilexiconn.jurassicraft.common.api.IFenceBase;
import net.ilexiconn.jurassicraft.common.creativetab.JCCreativeTabRegistry;
import net.ilexiconn.jurassicraft.common.tileentity.fence.TileSecurityFenceLowBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSecurityFenceLowBase extends BlockSecurityFence implements IFenceBase {
    public BlockSecurityFenceLowBase() {
        super(10.0F, 150.0F, 2, "low_Security_Fence_Base");
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        this.setCreativeTab(JCCreativeTabRegistry.blocks);
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileSecurityFenceLowBase();
    }
}
