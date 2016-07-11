package net.ilexiconn.jurassicraft.common.entity.reptiles;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftRidableFlying;
import net.ilexiconn.jurassicraft.common.entity.ai.JurassiCraftAIEatDroppedFood;
import net.ilexiconn.jurassicraft.common.entity.ai.JurassiCraftAIFollowFood;
import net.ilexiconn.jurassicraft.common.entity.ai.JurassiCraftAISit;
import net.ilexiconn.jurassicraft.common.entity.ai.JurassiCraftAIWander;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCearadactylus extends EntityJurassiCraftRidableFlying {
    public ChunkCoordinates currentTarget;
    public int maxHeight = 130;
    private boolean isFlying;

    public EntityCearadactylus(World world) {
        super(world);

        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new JurassiCraftAIWander(this, 40, this.getCreatureSpeed()));
        this.tasks.addTask(3, new JurassiCraftAISit(this));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftAIFollowFood(this, 60, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(1500);
    }

    protected void entityInit() {
        super.entityInit();

        this.dataWatcher.addObject(17, new Byte((byte) 0));
    }

    public double getMountedYOffset() {
        return (double) this.getYBouningBox() * 0.6D;
    }

    public int getTalkInterval() {
        return 350;
    }

    public void readEntityFromNBT(NBTTagCompound nbttag) {
        super.readEntityFromNBT(nbttag);

        this.dataWatcher.updateObject(17, Byte.valueOf(nbttag.getByte("Flying")));
    }

    public void writeEntityToNBT(NBTTagCompound nbttag) {
        super.writeEntityToNBT(nbttag);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.0F * developmentFraction) + this.rand.nextInt(1 + (int) (2.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);

        if (this.rand.nextFloat() < 0.1F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
    }

    public void setFlying(boolean state) {
        isFlying = state;

    }

    /*
     * Makes it fly... Pretty neet :) Thanks Alexthe666 for the majority of the code ;)
     */

    // TODO: Fix the wondering on the ground :P

    /*
     * Updates the creature every tick to decide what its going to do :)
     */
    public void onLivingUpdate() {

        if (motionY < 0.0D) {
            motionY *= 0.6D;
        }
        if (this.riddenByEntity == null) {
            if (!worldObj.isRemote) {
                if (getEntityToAttack() == null) {
                    if (rand.nextInt(400) == 0)
                        if (!isFlying)
                            setFlying(true);
                        else
                            setFlying(false);

                    if (isFlying) {
                        flyAround();
                    } else {

                    }

                    if (getEntityToAttack() != null) {
                        currentTarget = new ChunkCoordinates((int) getEntityToAttack().posX, (int) ((int) getEntityToAttack().posY + getEntityToAttack().getEyeHeight()), (int) getEntityToAttack().posZ);
                        setFlying(false);
                        flyTowardsTarget();
                    }
                }
            }
        }
        super.onLivingUpdate();
    }

    /*
     * Makes the animals fly towards its location
     */
    public void flyTowardsTarget() {
        if (currentTarget != null) {
            double targetX = currentTarget.posX + 0.5D - posX;
            double targetY = currentTarget.posY + 1D - posY;
            double targetZ = currentTarget.posZ + 0.5D - posZ;
            motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D;
            motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
            motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D;
            float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
            float rotation = MathHelper.wrapAngleTo180_float(angle - rotationYaw);
            rotationYaw += rotation;
            if (this.posY > maxHeight) {
                currentTarget.posY = -1;
            }
        }
    }

    /*
     * base of the flying
     */
    public void flyAround() {
        if (currentTarget != null)
            if (!worldObj.isAirBlock(currentTarget.posX, currentTarget.posY, currentTarget.posZ) || currentTarget.posY < 1)
                currentTarget = null;

        if (currentTarget == null || rand.nextInt(30) == 0 || currentTarget.getDistanceSquared((int) posX, (int) posY, (int) posZ) < 10F)
            currentTarget = new ChunkCoordinates((int) posX + rand.nextInt(90) - rand.nextInt(60), (int) posY + rand.nextInt(60) - 2, (int) posZ + rand.nextInt(90) - rand.nextInt(60));

        flyTowardsTarget();
    }

    /*
     * Checks if the animal is on ground (Not perfect, but it works)
     */
    public boolean checkGround(EntityCearadactylus reptile) {
        reptile = this;
        return !reptile.worldObj.isAirBlock((int) reptile.posX, (int) reptile.posY - 1, (int) reptile.posZ);
    }
}
