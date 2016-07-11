package net.ilexiconn.jurassicraft.common.entity;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIBite;
import net.ilexiconn.jurassicraft.common.entity.birds.EntityTitanis;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityCarnotaurus;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityHerrerasaurus;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityTyrannosaurus;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityVelociraptor;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJurassiCraftAggressive extends EntityJurassiCraftRidable {
    public float distanceFromTarget;

    public EntityJurassiCraftAggressive(World world) {
        super(world);
        this.tasks.addTask(2, new AnimationAIBite(this, this.getBiteAnimationDuration()));
    }

    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            Entity entity = damageSource.getEntity();

            if (entity != null && entity instanceof EntityLivingBase) {
                EntityLivingBase attacker = (EntityLivingBase) entity;

                if (this.checkTargetBeforeAttacking(attacker)) {
                    this.setCreatureAngry(this, attacker);
                }
            }

            return super.attackEntityFrom(damageSource, damage);
        }
    }

    public void onUpdate() {
        super.onUpdate();

        if (getAttackTarget() != null)
            distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        else
            distanceFromTarget = -1;
    }

    protected int getBiteAnimationDuration() {
        if (this instanceof EntityTyrannosaurus)
            return 20;
        else if (this instanceof EntityCarnotaurus)
            return 20;
        else if (this instanceof EntityVelociraptor)
            return 10;
        else if (this instanceof EntityHerrerasaurus)
            return 10;
        else if (this instanceof EntityTitanis)
            return 10;
        else
            return 10;
    }

    public boolean attackEntityAsMob(Entity entity) {
        /*
         * float attackDamage = (float) this.getCreatureAttack(); int i = 0; if (entity instanceof EntityLivingBase) { attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) entity); i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) entity); } boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage); if (flag) { if (i > 0) { entity.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F)); this.motionX *= 0.6D; this.motionZ *= 0.6D; } int j = EnchantmentHelper.getFireAspectModifier(this); if (j > 0) { entity.setFire(j * 4); } if (entity instanceof EntityLivingBase) { EnchantmentHelper.func_151384_a((EntityLivingBase) entity, this); } EnchantmentHelper.func_151385_b(this, entity); }
         */
        if (this instanceof EntityTyrannosaurus && distanceFromTarget >= 5.5F)
            return false;
        if (this.animID == 0)
            AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.BITE.animID());

        return true;// this.animID != JurassiCraftAnimationIDs.BITE.animID() && flag;
    }

    protected void attackEntity(Entity entity, float par2) {
        if (this.attackTime <= 0 && par2 < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
    }
}
