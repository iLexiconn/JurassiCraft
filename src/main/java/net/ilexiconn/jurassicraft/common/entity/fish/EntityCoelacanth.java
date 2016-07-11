package net.ilexiconn.jurassicraft.common.entity.fish;

import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSwimming;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCoelacanth extends EntityJurassiCraftSwimming {
    public ChainBuffer tailBuffer = new ChainBuffer(4);
    public ControlledAnimation droppingTimer = new ControlledAnimation(35);

    public EntityCoelacanth(World world) {
        super(world);
        this.swimRadius = 8.0F;
        this.swimRadiusHeight = 4.0F;
        this.swimSpeed = 0.4F;
        this.jumpOnLand = false;
        this.setCreatureExperiencePoints(50);
    }

    protected Entity findEntityToAttack() {
        return null;
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.isAirBorne || this.isInWater())
            this.droppingTimer.decreaseTimer();
        else
            this.droppingTimer.increaseTimer();

        this.tailBuffer.calculateChainSwingBuffer(55.0F, 3, 4.0F, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), 1));
        else
            this.dropItem(this.getCreature().getSteak(), 1);
    }

    public boolean canDespawn() {
        return !this.isTamed();
    }
}
