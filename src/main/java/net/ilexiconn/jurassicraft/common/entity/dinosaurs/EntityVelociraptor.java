package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.ControlledAnimation;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftGroupAggressive;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIRoar;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIVelociraptorLeap;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIVelociraptorSniff;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIVelociraptorTwitchHead;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIGroupAttack;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityLeptictidium;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityMoeritherium;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVelociraptor extends EntityJurassiCraftGroupAggressive {
    public ControlledAnimation sittingProgress = new ControlledAnimation(35);
    public ChainBuffer tailBuffer = new ChainBuffer(6);
    public boolean leaping = false;
    public int timeSinceLeap;

    public EntityVelociraptor(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AnimationAIVelociraptorLeap(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, 40, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAISitNatural(this, 1000, 150, 350));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20, true, JurassiCraftAnimationIDs.BITE.animID()));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(7, new AnimationAIVelociraptorTwitchHead(this));
        this.tasks.addTask(7, new AnimationAIVelociraptorSniff(this));
        this.tasks.addTask(7, new AnimationAIRoar(this, 20));
        this.tasks.addTask(7, new HerdAIGroupAttack(this));
        // this.tasks.addTask(7, new HerdAISurprise(this)); // WIP
        this.tasks.addTask(7, new HerdAIVelociraptorFollowHerd(this, getCreatureSpeed()));
        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityBrachiosaurus.class, 60, 0.9F, 0.15F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityTriceratops.class, 60, 0.9F, 0.25F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityStegosaurus.class, 60, 0.9F, 0.25F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 60, 0.7F, 0.7F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHypsilophodon.class, 50, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityMoeritherium.class, 50, 0.5F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeptictidium.class, 50, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeaellynasaura.class, 50, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 50, 0.4F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHorse.class, 50, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 50, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 30, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 30, 0.6F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 20, 0.2F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 50, 0.5F));

        this.setCreatureExperiencePoints(2500);
    }

    public void onLivingUpdate() {
        // Leap AI
        // float distanceFromTarget;
        // if (getAttackTarget() != null)
        // {
        // distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
        // }
        // else
        // {
        // distanceFromTarget = -1;
        // }
        if (distanceFromTarget >= 5 && distanceFromTarget <= 6 && this.onGround && this.timeSinceLeap == 0 && this.animID == 0)
            AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.LEAP.animID());

        if (onGround == true)
            setLeaping(false);

        if (timeSinceLeap != 0)
            timeSinceLeap--;

        // Misc
        super.onLivingUpdate();
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

        this.tailBuffer.calculateChainSwingBuffer(68.0F, 5, 4.0F, this);
    }

    public void setLeaping(boolean flag) {
        this.leaping = flag;
    }

    public String getLivingSound() {
        if (this.animID == 0)
            AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.ROAR.animID());

        return "jurassicraft:velociraptorHiss";
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.0F * developmentFraction) + this.rand.nextInt(1 + (int) (2.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);

        if (this.isMale() && this.rand.nextFloat() < 0.25F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    }
}
