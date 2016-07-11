package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class EntityJurassiCraftSwimmingBase extends EntityJurassiCraftRidable {
    public Vec3 territory;
    public int attackTimer = 40;
    protected float swimSpeed = 1;
    protected Entity hungryTarget;
    protected int huntingInterval = 1200;
    protected int hungry = huntingInterval;
    int movementSkip = 0;
    int xMovement = -1, yMovement = -1, zMovement = -1;
    float counter = 0;
    private Vec3 currentSwimTarget;
    private int newTarget = 500;

    public EntityJurassiCraftSwimmingBase(World world) {
        super(world);
    }

    public int getTotalArmorValue() {
        return 0;
    }

    public float getDistanceToTarget() {
        return this.hungryTarget == null ? 20 : this.getDistanceToEntity(hungryTarget);
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
    }

    /**
     * randomly selected ChunkCoordinates in a 7x6x7 box around the bat (y offset -2 to 4) towards which it will fly. upon getting close a new target will be selected
     */
    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);

        if (currentSwimTarget == null) {
            currentSwimTarget = Vec3.createVectorHelper(x, y, z);
        }
    }

    protected void updateAITasks() {
        super.updateAITasks();

        if (territory == null) {
            territory = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            territory.xCoord = this.posX;
            territory.yCoord = this.posY;
            territory.zCoord = this.posZ;
        }

        if (this.isInWater()) {
            --hungry;

            currentSwimTarget = findRandomTarget(this.posX, this.posY, this.posZ, false);

            if (hungry <= -2400) {
                hungry = -1;
                this.damageEntity(DamageSource.generic, 1.0F);
            }

            if (hungry <= 0) {
                --attackTimer;

                if (hungryTarget == null)
                    this.currentSwimTarget = this.getHungryTarget();
                else {
                    --newTarget;
                    territory = null;
                    this.currentSwimTarget = Vec3.createVectorHelper(hungryTarget.posX, hungryTarget.posY, hungryTarget.posZ);
                }

            } else
                currentSwimTarget = findRandomTarget(this.posX, this.posY, this.posZ, false);

            if (newTarget <= 0 || (hungryTarget != null && this.getDistanceToEntity(hungryTarget) > 15)) {
                newTarget = 500;
                hungryTarget = null;
            }

            if (this.currentSwimTarget != null && territory != null && Math.sqrt(currentSwimTarget.xCoord * territory.xCoord + currentSwimTarget.yCoord * territory.yCoord + currentSwimTarget.zCoord * territory.zCoord) > 30)
                currentSwimTarget = findRandomTarget(this.posX, this.posY, this.posZ, true);

            if (this.currentSwimTarget != null) {
                approachTarget(this.posX, this.posY, this.posZ, swimSpeed);
            }

            if (!this.worldObj.isAirBlock((int) this.posX, (int) this.posY + 1, (int) this.posZ) && !this.worldObj.isAirBlock((int) this.posX, (int) this.posY + 2, (int) this.posZ)) {
                this.motionY += 0.0110829F;
            }

        } else {
            this.setJumping(true);

            if (this.onGround) {
                this.motionX *= 0.031;
                this.motionZ *= 0.031;
            }
        }

    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int var1) {
        hungry = var1;
        hungryTarget = null;
    }

    public Vec3 getHungryTarget() {
        EntityLivingBase target = null;

        Vec3 normalizer = Vec3.createVectorHelper(1, 1, 1).normalize();
        List entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 7.0D) + 7, Math.abs(normalizer.yCoord * 7.0D) + 7, Math.abs(normalizer.zCoord * 7.0D) + 7));

        for (Object object : entities) {
            Entity entity = (Entity) object;

            if (entity.isInWater() && entity instanceof EntityLivingBase) {
                target = getTargetPriority(target, (EntityLivingBase) entity);
                hungryTarget = target;
            }
        }

        if (target == null) {
            return findRandomTarget(posX, posY, posZ, false);
        } else if (attackTimer <= 0) {
            return Vec3.createVectorHelper(target.posX, target.posY, target.posZ);
        } else {
            return currentSwimTarget;
        }
    }

    /*
     * Get a prioritized Target by comparing current target to new entity in range. Target = current target. Null at beginning of search entity1 = next entity in range to compare with target. Should never be null
     */
    public EntityLivingBase getTargetPriority(EntityLivingBase target, EntityLivingBase entity) {
        if (target != null) {
            if (target instanceof EntityPlayer)
                return target;
            else
                return entity;
        } else {
            return entity;
        }
    }

    // Math converted to use more accurate and readable Vec3's
    private void approachTarget(double x, double y, double z, float speed) {
        Vec3 target = Vec3.createVectorHelper(this.currentSwimTarget.xCoord + 0.5D - x, this.currentSwimTarget.yCoord + 0.1D - y, this.currentSwimTarget.zCoord + 0.5D - z).normalize();

        this.motionX += (target.xCoord * 0.5D - this.motionX) * 0.05000000149011612D * speed;
        this.motionY += (target.yCoord * 0.699999988079071D - this.motionY) * 0.05000000149011612D * speed;
        this.motionZ += (target.zCoord * 0.5D - this.motionZ) * 0.05000000149011612D * speed;

        float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
        float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 0.15F * speed;
        this.rotationYaw += f1;
        this.motionY += 0.0110829F;

        Block block = worldObj.getBlock(MathHelper.floor_double(this.currentSwimTarget.xCoord), MathHelper.floor_double(this.currentSwimTarget.yCoord), MathHelper.floor_double(this.currentSwimTarget.zCoord));

        if (currentSwimTarget != null && (block == null || !(block instanceof BlockLiquid)))
            currentSwimTarget = null;
    }

    public Vec3 findRandomTarget(double x, double y, double z, boolean force) {
        if (isInWater()) {
            movementSkip--;

            if (movementSkip <= 0) {
                // Will cause server and client to produce random yet identical rolls.
                rand.setSeed(getEntityId() + chunkCoordX + chunkCoordY + chunkCoordZ);
                movementSkip = rand.nextInt(15);
                int randomWaterCheck = 0;

                Block block1 = Blocks.bedrock;
                Block block2 = Blocks.bedrock;
                Vec3 newPos = null;
                // Give up after 20 rolls
                // Bad luck or cannot move in the current conditions

                while (randomWaterCheck < 20) {
                    // reuse last movement unless a wall is there.
                    if (randomWaterCheck == 0 && xMovement != -1 && !force) {
                        newPos = Vec3.createVectorHelper(x + xMovement, y + yMovement, z + zMovement);
                        block1 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord - (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord - (this.width / 2.0f)));
                        block2 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord + (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord + (this.width / 2.0f)));

                        if (block1 instanceof BlockLiquid) {
                            if (block2 instanceof BlockLiquid) {
                                break;
                            }
                        }

                        block1 = Blocks.bedrock;
                        block2 = Blocks.bedrock;
                    }

                    randomWaterCheck++;
                    xMovement = (rand.nextInt(10) - 5);
                    yMovement = (rand.nextInt(2) - 1);
                    zMovement = (rand.nextInt(10) - 5);
                    newPos = Vec3.createVectorHelper(x + xMovement, y + yMovement, z + zMovement);

                    block1 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord - (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord - (this.width / 2.0f)));
                    block2 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord + (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord + (this.width / 2.0f)));

                    if (block1 instanceof BlockLiquid) {
                        if (block2 instanceof BlockLiquid)
                            break;
                    }

                    block1 = Blocks.bedrock;
                    block2 = Blocks.bedrock;
                }

                if (block1 != Blocks.bedrock) {
                    this.swimSpeed = 1;
                    return newPos;
                } else {
                    return currentSwimTarget;
                }
            }
        }

        return currentSwimTarget;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);

        if (hungry <= 0 && entity == hungryTarget) {
            this.attackEntityAsMob(entity);
        }
    }

    public boolean attackEntityAsMob(Entity entity) {
        float attackDamage = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

        this.attackTimer = 60;
        // onKillEntity is not a part of JurrasicCraftEntityRidable, but I needed when this entity kills another....
        if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getHealth() <= attackDamage)
            this.setHungry(huntingInterval);

        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);
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

        // this.renderYawOffset += (-((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.5F;
        // this.rotationYaw = this.renderYawOffset;
        // float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        // this.rotationPitch = ((float) Math.atan2(this.motionY, (double) f) * 180.0F / (float) Math.PI - this.rotationPitch);
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     *
     * We dont need to protected boolean canDespawn() { return this.hasCustomNameTag() ? false : true; }
     **/
}
