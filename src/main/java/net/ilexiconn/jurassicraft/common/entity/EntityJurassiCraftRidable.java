package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityJurassiCraftRidable extends EntityJurassiCraftSmart {
    private float mountingSpeed;

    public EntityJurassiCraftRidable(World world) {
        super(world);

        this.setMountingSpeed((float) (this.getCreature().getRidingSpeed()));
    }

    public boolean isCreatureRidable() {
        return this.getCreature().isRidable();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        // if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed())
        // {
        // this.ridingPlayerRightClick();
        // }
    }

    /**
     * Called in the onLivingUpdate() when this entity is being ridden by a player that is right clicking;
     */
    public void ridingPlayerRightClick() {
    }

    public boolean interact(EntityPlayer player) {
        ItemStack playerItemStack = player.inventory.getCurrentItem();

        if (!this.worldObj.isRemote && this.checkRidingItem(playerItemStack)) {
            if (this.isCreatureRidable() && this.isTamed() && this.isCreatureAdult() && !this.isSitting() && !this.isSleeping() && !this.isAttacking() && !this.isDefending() && this.riddenByEntity == null && player.getCommandSenderName().equals(this.getOwnerName())) {
                this.setSitting(false, null);
                this.setRidingPlayer(player);
            } else {
                if (!this.isCreatureRidable()) {
                    if (this.hasCustomNameTag())
                        player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.riding.notRidable")));
                    else
                        player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.riding.notRidable")));
                } else if (!this.isTamed()) {
                    if (this.hasCustomNameTag())
                        player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.riding.notTamed")));
                    else
                        player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.riding.notTamed")));
                } else if (!this.isCreatureAdult()) {
                    if (this.hasCustomNameTag())
                        player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.riding.notAdult")));
                    else
                        player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.riding.notAdult")));
                } else if (this.isSitting()) {
                    if (this.hasCustomNameTag())
                        player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.riding.sitting")));
                    else
                        player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.riding.sitting")));
                } else if (this.riddenByEntity != null) {
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity.riding.isRiding")));
                }
            }
        }

        return super.interact(player);
    }

    protected boolean checkRidingItem(ItemStack ridingItem) {
        return ridingItem != null && this.getCreature().isRidingItem(ridingItem.getItem());
    }

    public float getMountingSpeed() {
        return this.mountingSpeed;
    }

    public void setMountingSpeed(float speed) {
        this.mountingSpeed = speed;
    }

    public void setRidingPlayer(EntityPlayer player) {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        player.mountEntity(this);
    }

    /**
     * Sets the mob rotation depending on where the player is looking (Horse Style). ID: 0.
     */
    protected void handleMouseControlledRiding() {
        this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
        this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
        this.setRotation(this.rotationYaw, this.rotationPitch);
        this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
        this.setRotation(this.rotationYaw, this.rotationPitch);
    }

    /**
     * Sets the mob rotation depending on the item position (Pig Style). ID: 1.
     */
    protected void handleFastItemControlledRiding() {
        this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

        float adjust = MathHelper.wrapAngleTo180_float(((EntityLivingBase) this.riddenByEntity).rotationYaw - this.rotationYaw) * 0.5F;

        if (adjust > 6.0F)
            adjust = 6.0F;
        else if (adjust < -6.0F)
            adjust = -6.0F;

        this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjust);
        this.setRotation(this.rotationYaw, this.rotationPitch);
    }

    /**
     * Sets the mob rotation depending on the item position (Pig Style). ID: 2.
     */
    protected void handleSlowItemControlledRiding() {
        this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

        float adjust = MathHelper.wrapAngleTo180_float(((EntityLivingBase) this.riddenByEntity).rotationYaw - this.rotationYaw) * 0.5F;

        if (adjust > 2.0F)
            adjust = 2.0F;
        else if (adjust < -2.0F)
            adjust = -2.0F;

        this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjust);
        this.setRotation(this.rotationYaw, this.rotationPitch);
    }

    /**
     * Sets the mob rotation depending on the item position (Pig Style). ID: 3.
     */
    protected void handleVerySlowItemControlledRiding() {
        this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

        float adjust = MathHelper.wrapAngleTo180_float(((EntityLivingBase) this.riddenByEntity).rotationYaw - this.rotationYaw) * 0.5F;

        if (adjust > 0.8F)
            adjust = 0.8F;
        else if (adjust < -0.8F)
            adjust = -0.8F;

        this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjust);
        this.setRotation(this.rotationYaw, this.rotationPitch);
    }

    /**
     * Sets the mob rotation depending on A and D keys. NOT WORKING!
     */
    protected void handleKeyboardControlledRiding(float adjustment) {
        float adjustPitch = 0.0F;
        float adjustYaw = 0.0F;

        GameSettings gameSettings = Minecraft.getMinecraft().gameSettings;

        if (gameSettings.keyBindRight.getIsKeyPressed())
            adjustYaw = adjustYaw + adjustment;
        if (gameSettings.keyBindLeft.getIsKeyPressed())
            adjustYaw = adjustYaw - adjustment;

        this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjustYaw);
        this.rotationPitch = MathHelper.wrapAngleTo180_float(this.rotationPitch + adjustPitch);

        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;

        this.setRotation(this.rotationYaw, this.rotationPitch);
    }

    public void moveEntityWithHeading(float movementStrafing, float movementForward) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.checkRidingItem(((EntityPlayer) this.riddenByEntity).getHeldItem())) {
            EntityPlayer player = (EntityPlayer) this.riddenByEntity;

            switch (this.getCreature().getRidingStyle()) {
                case 0:
                    this.handleMouseControlledRiding();
                    break;
                case 1:
                    this.handleFastItemControlledRiding();
                    break;
                case 2:
                    this.handleSlowItemControlledRiding();
                    break;
                case 3:
                    this.handleVerySlowItemControlledRiding();
                    break;
                default:
                    this.handleSlowItemControlledRiding();
            }

            this.stepHeight = 1.0F;
            movementStrafing = 0.25F * player.moveStrafing * this.getMountingSpeed();

            if (moveForward < 0)
                movementForward = player.moveForward * 0.3F * this.getMountingSpeed();
            else
                movementForward = player.moveForward * this.getMountingSpeed();

            this.decreaseHeldItemDurability(1);

            if (!this.worldObj.isRemote)
                super.moveEntityWithHeading(movementStrafing, movementForward);

            this.handleLimbMovement();
        } else {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(movementStrafing, movementForward);
        }
    }

    public void rideJump() {
        if (this.onGround && !this.isJumping && !this.isAirBorne) {
            this.decreaseHeldItemDurability(20);
            this.jump();
        }
    }

    /**
     * Makes corrections to the limbSwing.
     */
    protected void handleLimbMovement() {
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double pointX = this.posX - this.prevPosX;
        double pointZ = this.posZ - this.prevPosZ;

        float distance = MathHelper.sqrt_double(pointX * pointX + pointZ * pointZ) * 4.0F;

        if (distance > 1.0F)
            distance = 1.0F;

        this.limbSwingAmount += (distance - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    /**
     * Decreases the held item durability and destroys the item if stack size is 0 or less.
     */
    protected void decreaseHeldItemDurability(int damage) {
        EntityPlayer player = (EntityPlayer) this.riddenByEntity;

        ItemStack heldItem = player.getHeldItem();

        if (this.riddenByEntity != null && heldItem.getItemDamage() + damage > heldItem.getMaxDamage()) {
            heldItem.stackSize--;

            if (heldItem.stackSize <= 0) {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            }
        } else {
            heldItem.setItemDamage(heldItem.getItemDamage() + damage);
        }
    }

    public boolean isOnLadder() {
        return false;
    }
}
