package net.ilexiconn.jurassicraft.common.entity.mammals;

import net.ilexiconn.jurassicraft.common.entity.EntitySwimmingNew;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityBasilosaurus extends EntitySwimmingNew {
    public EntityBasilosaurus(World world) {
        super(world);

        this.swimRadius = 16.0F;
        this.swimRadiusHeight = 10.0F;
        this.swimSpeed = (float) this.getCreatureSpeed();
        this.jumpOnLand = false;
        this.attackInterval = 1;
        this.isAgressive = true;

        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySquid.class, 100, 0.2F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 100, 0.3F, 1.0F));

        this.setCreatureExperiencePoints(5000);
    }

    protected Entity findEntityToAttack() {
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);

        EntityPlayer player = (EntityPlayer) super.findEntityToAttack();
        if (player != null)
            return player;

        return this.worldObj.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (4.0F * developmentFraction) + this.rand.nextInt(1 + (int) (5.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);
    }
}
