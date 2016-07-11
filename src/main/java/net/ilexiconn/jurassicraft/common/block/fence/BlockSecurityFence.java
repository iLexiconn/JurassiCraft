package net.ilexiconn.jurassicraft.common.block.fence;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSecurityFence extends Block implements ITileEntityProvider {
    public BlockSecurityFence(float hardness, float resistance, int harvestLevel, String unlocalizedName) {
        super(Material.iron);
        this.setStepSound(soundTypeMetal);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName("iron_block");
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        switch (direction) {
            /** South */
            case 0:
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
                break;
            /** West */
            case 1:
                world.setBlockMetadataWithNotify(x, y, z, 1, 2);
                break;
            /** North */
            case 2:
                world.setBlockMetadataWithNotify(x, y, z, 2, 2);
                break;
            /** East */
            case 3:
                world.setBlockMetadataWithNotify(x, y, z, 3, 2);
                break;
        }
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }
}
