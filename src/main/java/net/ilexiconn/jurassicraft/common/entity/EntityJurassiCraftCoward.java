package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityJurassiCraftCoward extends EntityJurassiCraftRidable {
    public EntityJurassiCraftCoward(World world) {
        super(world);
    }

    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(18.0D, 8.0D, 18.0D));

            ArrayList<EntityJurassiCraftCoward> listOfCowards = new ArrayList<EntityJurassiCraftCoward>();

            listOfCowards.add(this);

            for (int i = 0; i < list.size(); ++i) {
                Entity entityNeighbor = list.get(i);

                if (entityNeighbor.getClass() == this.getClass() && entityNeighbor != this) {
                    listOfCowards.add((EntityJurassiCraftCoward) entityNeighbor);
                }
            }

            if (!listOfCowards.isEmpty()) {
                for (EntityJurassiCraftCoward creatures : listOfCowards) {
                    creatures.startFleeing();
                }
            }

            return super.attackEntityFrom(damageSource, damage);
        }
    }
}
