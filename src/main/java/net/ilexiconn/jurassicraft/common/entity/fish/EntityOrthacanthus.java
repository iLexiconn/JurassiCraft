package net.ilexiconn.jurassicraft.common.entity.fish;

import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSwimmingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOrthacanthus extends EntityJurassiCraftSwimmingBase {
    public ChainBuffer tailBuffer = new ChainBuffer(6);

    public EntityOrthacanthus(World world) {
        super(world);

        this.swimSpeed = 2.2F;
        huntingInterval = 200;
        this.setHungry(huntingInterval);

        this.setCreatureExperiencePoints(50);
    }

    public void onUpdate() {
        super.onUpdate();
        this.tailBuffer.calculateChainSwingBuffer(65.0F, 3, 4.0F, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), 1));
    }

    public EntityLivingBase getTargetPriority(EntityLivingBase target, EntityLivingBase entity1) {
        if (target != null) {
            if (entity1 instanceof EntitySquid) // Goes for squid first
                return entity1;
            else if (entity1 instanceof EntityPlayer) // Then players
                return entity1;
            else if (!(entity1 instanceof EntityCoelacanth))
                return target;
        } else if (entity1 instanceof EntitySquid || entity1 instanceof EntityPlayer || entity1 instanceof EntityOrthacanthus)
            return entity1;

        return null;
    }
}
