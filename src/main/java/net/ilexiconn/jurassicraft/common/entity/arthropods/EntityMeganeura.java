package net.ilexiconn.jurassicraft.common.entity.arthropods;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftFlyingCreature;
import net.ilexiconn.jurassicraft.common.entity.ai.JurassiCraftAIGliding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMeganeura extends EntityJurassiCraftFlyingCreature {
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;

    public EntityMeganeura(World world) {
        super(world, "grassandleaves");
        this.tasks.addTask(0, new JurassiCraftAIGliding(this));
        this.setCreatureExperiencePoints(20);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(17, Byte.valueOf((byte) 0));
    }

    protected void updateEntityActionState() {
        this.despawnEntity();

        double var1 = this.waypointX - this.posX;
        double var3 = this.waypointY - this.posY;
        double var5 = this.waypointZ - this.posZ;
        double var7 = var1 * var1 + var3 * var3 + var5 * var5;

        if (var7 < 1.0D || var7 > 3600.0D) {
            this.waypointX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            var7 = (double) MathHelper.sqrt_double(var7);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7)) {
                this.motionX += var1 / var7 * 0.1D;
                this.motionY += var3 / var7 * 0.1D;
                this.motionZ += var5 / var7 * 0.1D;
            } else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
    }

    /**
     * True if the ghast has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double var9 = (this.waypointX - this.posX) / par7;
        double var11 = (this.waypointY - this.posY) / par7;
        double var13 = (this.waypointZ - this.posZ) / par7;

        AxisAlignedBB boundingBox = this.boundingBox.copy();

        for (int var16 = 1; (double) var16 < par7; ++var16) {
            boundingBox.offset(var9, var11, var13);

            if (!this.worldObj.getCollidingBoundingBoxes(this, boundingBox).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the entityOLD's current position is a valid location to spawn this entityOLD.
     */
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere();
    }

    public float spiderScaleAmount() {
        return 1.5F;
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        if (this.rand.nextFloat() < 0.1F) {
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));
        } else {
            if (!this.isBurning()) {
                this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat()));
            } else {
                this.dropItem(this.getCreature().getSteak(), 1);
            }
        }
    }
}
