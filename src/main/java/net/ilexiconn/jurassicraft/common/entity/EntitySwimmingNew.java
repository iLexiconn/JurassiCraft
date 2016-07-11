package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Inherithed from Animals+ by Click_Me
 */
public abstract class EntitySwimmingNew extends EntityJurassiCraftRidable {
    public byte creatureID;
    public int frame = 0;
    public float angle = 0;
    public float deltaAngle = 4;
    public float currentSpeed = 0.2F;
    public float distanceFromTarget = 100;
    protected float swimRadius = 4.0F;
    protected float swimRadiusHeight = 4.0F;
    protected boolean isAgressive = false;
    protected int attackInterval = 50;
    protected float attackSpeed = 1.2F;
    protected float swimSpeed = 0.5F;
    protected boolean jumpOnLand = true;
    private double swimTargetX;
    private double swimTargetY;
    private double swimTargetZ;
    private Entity targetEntity;
    private boolean isAttacking;
    private int timeUntilDeltaAngleChange = 0;

    public EntitySwimmingNew(World world) {
        super(world);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.isInWater())
            // this.motionY *= 0.1D; //THIS IS CAUSING PROBLEMS, BUT SEEMS TO BE NECESSARY
            this.motionY += 0.02D; // This will negate gravity instead

        frame++;
    }

    protected void updateAITasks() {
        super.updateAITasks();

        if (this.isInWater()) {
            double dx = this.swimTargetX - this.posX;
            double dy = this.swimTargetY - this.posY;
            double dz = this.swimTargetZ - this.posZ;
            double dist = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);

            if (dist < 1.0D || dist > 1000.0D) {
                this.swimTargetX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
                this.swimTargetY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadiusHeight);
                this.swimTargetZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
                this.isAttacking = false;
            }

            if (this.worldObj.getBlock(MathHelper.floor_double(this.swimTargetX), MathHelper.floor_double(this.swimTargetY + this.height), MathHelper.floor_double(this.swimTargetZ)).getMaterial() == Material.water) {
                // this.motionX += dx / dist * 0.05D * (double) this.swimSpeed;
                this.motionY += dy / dist * 0.1D * (double) this.swimSpeed;
                // this.motionZ += dz / dist * 0.05D * (double) this.swimSpeed;
            } else {
                this.swimTargetX = this.posX;
                this.swimTargetY = this.posY + 0.1D;
                this.swimTargetZ = this.posZ;
            }

            if (this.isAttacking) {
                this.motionX *= this.attackSpeed;
                this.motionY *= this.attackSpeed;
                this.motionZ *= this.attackSpeed;
            }

            if (this.isAgressive && this.rand.nextInt(this.attackInterval) == 0) {
                this.targetEntity = this.findEntityToAttack();
            }

            if (this.targetEntity != null && this.targetEntity.isInWater()) {
                float deltaX = (float) (this.targetEntity.posX - this.posX);
                float deltaY = (float) (this.targetEntity.posY - this.posY);
                float deltaZ = (float) (this.targetEntity.posZ - this.posZ);
                this.swimTargetX = this.targetEntity.posX;
                this.swimTargetY = this.targetEntity.posY;
                this.swimTargetZ = this.targetEntity.posZ;
                this.angle = (float) (Math.atan2(deltaZ, deltaX) * (180 / Math.PI));
                this.isAttacking = true;
                this.distanceFromTarget = (float) (Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ));
            } else {
                this.distanceFromTarget = 100;
                this.isAttacking = false;
            }

            this.renderYawOffset += (-((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.5F;
            this.rotationYaw = this.renderYawOffset;
            this.rotationYaw += MathHelper.wrapAngleTo180_float(this.angle - this.rotationYaw - 90.0F);
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationPitch += ((float) Math.atan2(this.motionY, (double) f) * 180.0F / (float) Math.PI - this.rotationPitch) * 0.5F;
        } else {
            if (this.jumpOnLand && this.onGround && this.rand.nextInt(1) == 0) {
                this.motionY = 0.3F;
                this.motionX = -0.2F + this.rand.nextFloat() * 0.4F;
                this.motionZ = -0.2F + this.rand.nextFloat() * 0.4F;
            }
        }

        if (this.inWater == true) {
            float vx = (float) (currentSpeed * Math.cos(angle * (Math.PI / 180)));
            float vz = (float) (currentSpeed * Math.sin(angle * (Math.PI / 180)));
            this.motionX = vx;
            this.motionZ = vz;
            this.angle += deltaAngle;

            if (timeUntilDeltaAngleChange <= 0) {
                int i = rand.nextInt(20) + 1;

                if (i == 1) {
                    deltaAngle = -1 * deltaAngle;
                    timeUntilDeltaAngleChange = 40;
                }
            }

            timeUntilDeltaAngleChange -= 1;
        }
    }

    protected Entity findEntityToAttack() {
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

        return player != null && this.canEntityBeSeen(player) ? player : null;
    }

    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);

        if (this.isAgressive && this.targetEntity == entity) {
            this.attackEntityAsMob(entity);
        }
    }

    public boolean attackEntityAsMob(Entity entity) {
        float f = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    public boolean canBreatheUnderwater() {
        return true;
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
        } else
            this.setAir(300);
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox);
    }

}
