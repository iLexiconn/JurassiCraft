package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftFlyingCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class JurassiCraftAISelfFlying extends EntityAIBase {
    private final EntityJurassiCraftFlyingCreature creature;
    private float minimumAgeToFly;
    private int flyingChance;
    private int height;

    public JurassiCraftAISelfFlying(EntityJurassiCraftFlyingCreature entity, int flyingChance, float minimumAgeToFly) {
        this.creature = entity;
        this.flyingChance = flyingChance;
        this.minimumAgeToFly = minimumAgeToFly;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.creature.getRNG().nextInt(this.flyingChance) == 0)
            if (this.creature.riddenByEntity == null)
                if (!this.creature.isFlying())
                    if (this.creature.onGround && !this.creature.isSitting() && !this.creature.isSleeping() && !this.creature.isTakingOff())
                        return this.creature.isCreatureOlderThan(this.minimumAgeToFly);
        return false;
    }

    public void startExecuting() {
        if (this.creature.isSleeping())
            this.creature.setSleeping(false);
        if (this.creature.isSitting())
            this.creature.setSitting(false, null);
        if (this.creature.isTakingOff())
            this.creature.setTakingOff(false);
        if (this.creature.isEating())
            this.creature.setEating(false);
        if (this.creature.isDrinking())
            this.creature.setDrinking(false);
        if (this.creature.isBreeding())
            this.creature.setBreeding(false);

        this.creature.setFlying(true);
        this.creature.isAirBorne = true;
        this.goUp();
    }

    public void updateTask() {
        if (this.creature.getRNG().nextBoolean())
            this.height = this.getHeight();

        if (this.height < 6)
            this.goUp();

        if (this.creature.getRNG().nextInt(200) == 0)
            this.creature.getNavigator().getPathToXYZ(this.creature.posX + this.creature.getRNG().nextInt(20), this.creature.posY + this.creature.getRNG().nextInt(5), this.creature.posZ + this.creature.getRNG().nextInt(20));
        else if (this.creature.getRNG().nextInt(200) == 0)
            this.creature.getNavigator().getPathToXYZ(this.creature.posX - this.creature.getRNG().nextInt(20), this.creature.posY + this.creature.getRNG().nextInt(5), this.creature.posZ + this.creature.getRNG().nextInt(20));
        else if (this.creature.getRNG().nextInt(200) == 0)
            this.creature.getNavigator().getPathToXYZ(this.creature.posX + this.creature.getRNG().nextInt(20), this.creature.posY + this.creature.getRNG().nextInt(5), this.creature.posZ - this.creature.getRNG().nextInt(20));
        else if (this.creature.getRNG().nextInt(200) == 0)
            this.creature.getNavigator().getPathToXYZ(this.creature.posX - this.creature.getRNG().nextInt(20), this.creature.posY + this.creature.getRNG().nextInt(5), this.creature.posZ - this.creature.getRNG().nextInt(20));
    }

    public boolean continueExecuting() {
        return !creature.onGround;
    }

    public void resetTask() {
        super.resetTask();
        this.creature.setFlying(false);
        this.creature.isAirBorne = false;
        this.height = 0;
    }

    public int getHeight() {
        return (int) this.creature.posY - this.creature.worldObj.getTopSolidOrLiquidBlock((int) this.creature.posX, (int) this.creature.posZ);
    }

    private void goUp() {
        this.creature.motionX = (double) (1.2F * this.creature.getMountingSpeed() * MathHelper.sin(3.14159265359F + 0.01745329251F * this.creature.renderYawOffset));
        this.creature.motionZ = (double) (1.2F * this.creature.getMountingSpeed() * MathHelper.cos(0.01745329251F * this.creature.renderYawOffset));
        this.creature.motionY = 0.5F;
    }
}
