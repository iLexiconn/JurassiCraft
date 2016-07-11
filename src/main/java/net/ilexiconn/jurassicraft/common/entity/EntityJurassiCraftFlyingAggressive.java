package net.ilexiconn.jurassicraft.common.entity;

import net.ilexiconn.jurassicraft.common.entity.ai.stats.FlyingParameters;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityJurassiCraftFlyingAggressive extends EntityJurassiCraftAggressive {
    public FlyingParameters flyingParameters;
    private String landingMaterial;

    public EntityJurassiCraftFlyingAggressive(World world, String landingMaterial) {
        super(world);

        this.setLandingMaterial(landingMaterial);
        this.setFlyingParameters(new FlyingParameters(63, 80, 10, 10, 10, 10, 10, 10, 10, this.landingMaterial));
        this.setFlying(false);
    }

    public void onLivingUpdate() {
        if (this.isFlyingCreature()) {
            if (this.riddenByEntity == null) {
                this.motionY += 0.04F + 0.06F * this.flyingParameters.flySpeedModifier / 500.0F;
                this.setFlying(true);
            }

            if (this.onGround && this.isFlying())
                this.setFlying(false);
        }

        super.onLivingUpdate();
    }

    public FlyingParameters getFlyingParameters() {
        return flyingParameters;
    }

    public void setFlyingParameters(FlyingParameters flyingParameters) {
        this.flyingParameters = flyingParameters;
    }

    public String getLandingMaterial() {
        return landingMaterial;
    }

    public void setLandingMaterial(String landingMaterial) {
        this.landingMaterial = landingMaterial;
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setString("LandingMaterial", this.landingMaterial);
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        this.setLandingMaterial(compound.getString("LandingMaterial"));
        this.setFlyingParameters(new FlyingParameters(63, 80, 10, 10, 10, 10, 10, 10, 10, compound.getString("LandingMaterial")));
    }
}
