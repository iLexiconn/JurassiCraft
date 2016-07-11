package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftGroupAggressive;
import net.ilexiconn.jurassicraft.common.entity.EntitySpit;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAISpit;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIGroupAttack;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityLeptictidium;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityMoeritherium;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDilophosaurus extends EntityJurassiCraftGroupAggressive implements IRangedAttackMob {
    public ChainBuffer tailBuffer = new ChainBuffer(5);
    public ControlledAnimation sittingProgress = new ControlledAnimation(35);
    int timeUntilSpit = 0;
    float spitLocationRadius = 2.2F;

    public EntityDilophosaurus(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AnimationAISpit(this, 20, 10));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, 40, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAISit(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(7, new HerdAIFollowHerd(this, true, getCreatureSpeed()));
        this.tasks.addTask(7, new HerdAIGroupAttack(this));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaurus.class, 120, 0.7F, 0.1F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaurus.class, 80, 0.6F, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 70, 0.6F, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 60, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 50, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHypsilophodon.class, 50, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityMoeritherium.class, 50, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeptictidium.class, 50, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeaellynasaura.class, 50, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHorse.class, 50, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 50, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 30, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 30, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 10, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 50, 0.5F));

        this.setCreatureExperiencePoints(1800);
    }

    // Copied from snowman
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float p_82196_2_) {
        if (timeUntilSpit != 0 || getAttackTarget() == null)
            return;

        EntitySpit spit = new EntitySpit(this.worldObj, this);
        spit.setPosition(posX + spitLocationRadius * getCreatureScale() * Math.cos((renderYawOffset + 90) * Math.PI / 180), posY + 1 * getCreatureScale(), posZ + spitLocationRadius * getCreatureScale() * Math.sin((renderYawOffset + 90) * Math.PI / 180));
        double d0 = entity.posX - spit.posX;
        double d1 = entity.posY + (double) entity.getEyeHeight() - 1.100000023841858D - spit.posY;
        double d2 = entity.posZ - spit.posZ;

        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
        spit.setThrowableHeading(d0, d1 + (double) f1, d2, 1.5F, 0F);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(spit);

        timeUntilSpit = 20;
    }

    public int getTalkInterval() {
        return 350;
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;

        int count = Math.round(1 + (2.5F * developmentFraction) + this.rand.nextInt(1 + (int) (2.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);

        if (this.rand.nextFloat() < 0.1F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));

        if (this.isMale() && this.rand.nextFloat() < 0.25F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    }

    public void onUpdate() {
        super.onUpdate();

        /** Sitting Animation */
        if (this.worldObj.isRemote) {
            if (this.isSitting())
                this.sittingProgress.increaseTimer();
            else
                this.sittingProgress.decreaseTimer();
        }

        this.tailBuffer.calculateChainSwingBuffer(40.0F, 3, 4.0F, this);

        if (getAttackTarget() != null) {
            if (timeUntilSpit == 0 && getDistanceToEntity(getAttackTarget()) <= 15 && getDistanceToEntity(getAttackTarget()) >= 4 && (getAttackTarget().getActivePotionEffect(Potion.blindness) == null || getAttackTarget().getActivePotionEffect(Potion.poison) == null))
                AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.SPITTING.animID());
        }

        if (timeUntilSpit > 0)
            timeUntilSpit--;
    }
}
