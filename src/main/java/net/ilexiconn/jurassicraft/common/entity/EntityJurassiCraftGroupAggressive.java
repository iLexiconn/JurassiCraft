package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import java.util.List;

public class EntityJurassiCraftGroupAggressive extends EntityJurassiCraftAggressive {
    public EntityJurassiCraftGroupAggressive(World world) {
        super(world);
    }

    protected void setCreatureAngry(EntityJurassiCraftAggressive creature, Entity entity) {
        if (entity instanceof EntityLivingBase && entity.getClass() != creature.getClass()) {
            EntityLivingBase attacker = (EntityLivingBase) entity;
            List neighbours = creature.worldObj.getEntitiesWithinAABBExcludingEntity(creature, creature.boundingBox.expand(16.0D, 8.0D, 16.0D));

            for (Object object : neighbours) {
                Entity neighbour = (Entity) object;

                if (neighbour.getClass() == this.getClass()) {
                    EntityJurassiCraftAggressive angryNeighbour = (EntityJurassiCraftAggressive) neighbour;

                    if (angryNeighbour.checkTargetBeforeAttacking(attacker)) {
                        angryNeighbour.becomeAngry(attacker, 0.0F);
                    }
                }
            }
        }

        super.setCreatureAngry(creature, entity);
    }
}
