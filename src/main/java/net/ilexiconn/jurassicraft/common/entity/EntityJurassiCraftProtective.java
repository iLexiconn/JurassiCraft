package net.ilexiconn.jurassicraft.common.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityJurassiCraftProtective extends EntityJurassiCraftRidable {
    public EntityJurassiCraftProtective(World world) {
        super(world);
    }

    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            List<Entity> neighbours = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0D, 8.0D, 16.0D));

            ArrayList<EntityJurassiCraftProtective> listChildren = new ArrayList<EntityJurassiCraftProtective>();
            ArrayList<EntityJurassiCraftProtective> listAdult = new ArrayList<EntityJurassiCraftProtective>();
            ArrayList<EntityLivingBase> listAttackers = new ArrayList<EntityLivingBase>();

            Entity entity = damageSource.getEntity();

            if (entity instanceof EntityLivingBase) {
                EntityLivingBase attacker = (EntityLivingBase) entity;

                int count = 0;

                if (this.isCreatureAdult()) {
                    listAdult.add(this);
                } else {
                    listChildren.add(this);
                }

                for (Entity entityNeighbor : neighbours) {
                    if (entityNeighbor.getClass() == this.getClass()) {
                        EntityJurassiCraftProtective validEntityNeighbor = (EntityJurassiCraftProtective) entityNeighbor;

                        if (validEntityNeighbor.isCreatureAdult()) {
                            listAdult.add(validEntityNeighbor);

                            count++;
                        } else {
                            listChildren.add(validEntityNeighbor);
                        }
                    } else if (entityNeighbor.getClass() == attacker.getClass()) {
                        listAttackers.add((EntityLivingBase) entityNeighbor);
                    }
                }

                for (EntityJurassiCraftProtective children : listChildren) {
                    children.startFleeing();
                }

                if (!this.isCreatureAdult()) {
                    for (EntityJurassiCraftProtective adult : listAdult) {
                        adult.becomeAngry(attacker, 0.0F);
                    }
                } else {
                    if (attacker != this.getOwner()) {
                        if (count >= this.numberOfAllies && !(count < listAttackers.size() * 2)) {
                            for (EntityJurassiCraftProtective adult : listAdult) {
                                adult.becomeAngry(attacker, 0.0F);
                            }
                        } else {
                            for (EntityJurassiCraftProtective adult : listAdult) {
                                adult.startFleeing();
                            }
                        }
                    }
                }
            }

            return super.attackEntityFrom(damageSource, damage);
        }
    }

    public boolean attackEntityAsMob(Entity target) {
        if (this.attackTime <= 0 && target.boundingBox.maxY > this.boundingBox.minY && target.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;

            float attackDamage = (float) this.getCreatureAttack();

            int knockback = 0;

            if (target instanceof EntityLivingBase) {
                attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) target);
                knockback += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) target);
            }

            boolean canAttack = target.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);

            if (canAttack) {
                if (knockback > 0) {
                    target.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) knockback * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) knockback * 0.5F));

                    this.motionX *= 0.6D;
                    this.motionZ *= 0.6D;
                }

                int fireAspect = EnchantmentHelper.getFireAspectModifier(this);

                if (fireAspect > 0) {
                    target.setFire(fireAspect * 4);
                }

                if (target instanceof EntityLivingBase) {
                    EnchantmentHelper.func_151384_a((EntityLivingBase) target, this);
                }

                EnchantmentHelper.func_151385_b(this, target);
            }

            return canAttack;
        } else {
            return false;
        }
    }
}
