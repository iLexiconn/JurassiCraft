package net.ilexiconn.jurassicraft.common.entity.mammals;

import net.ilexiconn.jurassicraft.common.api.IHerbivore;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftProtective;
import net.ilexiconn.jurassicraft.common.entity.IntermittentAnimation;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIBite;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIRoar;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMammoth extends EntityJurassiCraftProtective implements IHerbivore {
    public IntermittentAnimation trunkLift = new IntermittentAnimation(20, 30, 10, 1);
    public IntermittentAnimation trunkSwing = new IntermittentAnimation(20, 50, 10, 1);
    public IntermittentAnimation earFlap = new IntermittentAnimation(20, 20, 10, 1);
    public IntermittentAnimation tailSwing = new IntermittentAnimation(20, 30, 10, 1);

    public EntityMammoth(World world) {
        super(world);

        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new AnimationAIBite(this, 24));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 200));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(2, new JurassiCraftAISit(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 50, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(4, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 45, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new AnimationAIRoar(this, 40));
        this.tasks.addTask(7, new JurassiCraftAIHerdBehavior(this, 128, 2500, 24, this.getCreatureSpeed()));
        this.tasks.addTask(7, new HerdAIFollowHerd(this, false, getCreatureSpeed()));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.setCreatureExperiencePoints(3500);
    }

    public double getMountedYOffset() {
        return (double) this.getYBouningBox() + 0.5;
    }

    public int getNumberOfAllies() {
        return 1;
    }

    public int getTalkInterval() {
        return 400;
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.5F * developmentFraction) + this.rand.nextInt(1 + (int) (4.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);
    }

    public void onUpdate() {
        super.onUpdate();

        if (trunkSwing.getTimer() == 0)
            trunkLift.runAnimation();

        if (trunkLift.getTimer() == 0)
            trunkSwing.runAnimation();

        earFlap.runAnimation();
        tailSwing.runAnimation();
    }

    public boolean attackEntityAsMob(Entity entity) {
        /*
         * float attackDamage = (float) this.getCreatureAttack(); int i = 0; if (entity instanceof EntityLivingBase) { attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) entity); i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) entity); } boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage); if (flag) { if (i > 0) { entity.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F)); this.motionX *= 0.6D; this.motionZ *= 0.6D; } int j = EnchantmentHelper.getFireAspectModifier(this); if (j > 0) { entity.setFire(j * 4); } if (entity instanceof EntityLivingBase) { EnchantmentHelper.func_151384_a((EntityLivingBase) entity, this); } EnchantmentHelper.func_151385_b(this, entity); }
         */
        if (this.animID == 0)
            AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.BITE.animID());

        return true;// this.animID != JurassiCraftAnimationIDs.BITE.animID() && flag;
    }
}