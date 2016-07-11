package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftRidable;
import net.ilexiconn.jurassicraft.common.entity.ai.JurassiCraftAIWander;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySanta extends EntityJurassiCraftRidable {
    public EntitySanta(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, 40, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(1000);
    }

    public int getTalkInterval() {
        return 350;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);

        for (int l = 0; l < 4; ++l) {
            i = MathHelper.floor_double(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
            j = MathHelper.floor_double(this.posY);
            k = MathHelper.floor_double(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));

            if ((this.worldObj.getBlock(i, j, k).getMaterial() == Material.air || this.worldObj.getBlock(i, j, k).getMaterial() == Material.grass) && Blocks.snow_layer.canPlaceBlockAt(this.worldObj, i, j, k)) {
                this.worldObj.setBlock(i, j, k, Blocks.snow_layer);
                this.worldObj.setBlock(i + 1, j, k, Blocks.snow_layer);
                this.worldObj.setBlock(i + 1, j, k + 1, Blocks.snow_layer);
                this.worldObj.setBlock(i + 1, j, k - 1, Blocks.snow_layer);
                this.worldObj.setBlock(i, j, k - 1, Blocks.snow_layer);
                this.worldObj.setBlock(i, j, k + 1, Blocks.snow_layer);
                this.worldObj.setBlock(i - 1, j, k + 1, Blocks.snow_layer);
                this.worldObj.setBlock(i - 1, j, k - 1, Blocks.snow_layer);
                this.worldObj.setBlock(i - 1, j, k, Blocks.snow_layer);
            }
        }
    }
}