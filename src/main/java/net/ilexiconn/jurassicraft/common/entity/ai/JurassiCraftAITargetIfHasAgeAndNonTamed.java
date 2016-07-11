package net.ilexiconn.jurassicraft.common.entity.ai;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * This AI makes an EntityJurassiCraftSmart attack a desirable mob when the creature is not tamed and has enough age. It will also check if the target is younger than a minimum age.
 *
 * @author RafaMv
 */
public class JurassiCraftAITargetIfHasAgeAndNonTamed extends EntityAITarget {
    private final Class targetClass;
    private final int targetChance;
    private final JurassiCraftAITargetIfHasAgeAndNonTamed.Sorter theNearestAttackableTargetSorter;
    private final IEntitySelector targetEntitySelector;
    private EntityJurassiCraftSmart creature;
    private EntityLivingBase target;
    private float minimumCreatureAge;
    private float maximumTargetAge;

    public JurassiCraftAITargetIfHasAgeAndNonTamed(EntityJurassiCraftSmart creature, Class targetClass, int chanceToAttack, float minimumCreatureAge) {
        this(creature, targetClass, chanceToAttack, minimumCreatureAge, 1.0F);
    }

    public JurassiCraftAITargetIfHasAgeAndNonTamed(EntityJurassiCraftSmart creature, Class targetClass, int chanceToAttack, float minimumCreatureAge, float maximumTargetAge) {
        super(creature, true, false);

        this.creature = creature;
        this.minimumCreatureAge = minimumCreatureAge;
        this.maximumTargetAge = maximumTargetAge;
        this.targetClass = targetClass;
        this.targetChance = chanceToAttack;
        this.theNearestAttackableTargetSorter = new JurassiCraftAITargetIfHasAgeAndNonTamed.Sorter(creature);

        this.targetEntitySelector = new IEntitySelector() {
            @Override
            public boolean isEntityApplicable(Entity creature) {
                return !(creature instanceof EntityLivingBase) ? false : JurassiCraftAITargetIfHasAgeAndNonTamed.this.isSuitableTarget((EntityLivingBase) creature, false);
            }
        };

        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        Random random = this.taskOwner.getRNG();

        boolean isTamed = this.creature.isTamed();
        boolean isAttacking = this.creature.isAttacking();
        boolean olderThanMinAge = this.creature.isCreatureOlderThan(this.minimumCreatureAge);

        if (this.targetChance > 0) {
            if (random.nextInt(this.targetChance) != 0 || isTamed || isAttacking || !olderThanMinAge) {
                return false;
            } else {
                double searchDistance = this.getTargetDistance();

                List nearby = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(searchDistance, 5.0D, searchDistance), this.targetEntitySelector);
                Collections.sort(nearby, this.theNearestAttackableTargetSorter);

                if (nearby.isEmpty()) {
                    return false;
                } else {
                    this.target = (EntityLivingBase) nearby.get(0);

                    if (this.target instanceof EntityJurassiCraftSmart)
                        return ((EntityJurassiCraftSmart) this.target).isCreatureOlderThan(this.maximumTargetAge) ? this.maximumTargetAge >= 1.0F : true;
                    else
                        return true;
                }
            }
        }

        return false;
    }

    public void startExecuting() {
        if (this.creature.isSitting())
            this.creature.setSitting(false, null);
        if (this.creature.isSleeping())
            this.creature.setSleeping(false);
        if (this.creature.isBreeding())
            this.creature.setBreeding(false);
        if (this.creature.isSocializing())
            this.creature.setSocializing(false);
        if (this.creature.isStalking())
            this.creature.setStalking(false);
        if (this.creature.isEating())
            this.creature.setEating(false);
        if (this.creature.isDrinking())
            this.creature.setDrinking(false);

        this.creature.setAttacking(true);
        this.taskOwner.setAttackTarget(this.target);

        super.startExecuting();
    }

    public void resetTask() {
        super.resetTask();

        this.creature.setAttacking(false);
    }

    public static class Sorter implements Comparator {
        private final Entity entity;

        public Sorter(Entity entity) {
            this.entity = entity;
        }

        public int compare(Entity entity1, Entity entity2) {
            double distance1 = this.entity.getDistanceSqToEntity(entity1);
            double distance2 = this.entity.getDistanceSqToEntity(entity2);

            return distance1 < distance2 ? -1 : (distance1 > distance2 ? 1 : 0);
        }

        public int compare(Object obj1, Object obj2) {
            return this.compare((Entity) obj1, (Entity) obj2);
        }
    }
}
