package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJurassiCraftWaterCreature extends EntityJurassiCraftSmart {
    public EntityJurassiCraftWaterCreature(World world) {
        super(world);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox);
    }

    public int getTalkInterval() {
        return 120;
    }

    public boolean canDespawn() {
        return true;
    }

    protected int getExperiencePoints(EntityPlayer p_70693_1_) {
        return 1 + this.worldObj.rand.nextInt(3);
    }

    public void onEntityUpdate() {
        super.onEntityUpdate();
        int air = this.getAir();

        if (this.isEntityAlive() && !this.isInWater()) {
            --air;

            this.setAir(air);

            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        } else {
            this.setAir(300);
        }
    }
}
