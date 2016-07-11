package net.ilexiconn.jurassicraft.common.entity.reptiles;

import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftAggressive;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityGallimimus;
import net.ilexiconn.jurassicraft.common.entity.dinosaurs.EntityOviraptor;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityLeptictidium;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityMoeritherium;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDeinosuchus extends EntityJurassiCraftAggressive {
    public ChainBuffer tailBuffer = new ChainBuffer(5);

    public EntityDeinosuchus(World world) {
        super(world);

        this.getNavigator().setAvoidsWater(false);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0F * this.getCreatureSpeed(), false));
        this.tasks.addTask(3, new JurassiCraftAIWander(this, 40, this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAISit(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIFollowFood(this, 100, 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(6, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityGallimimus.class, 40, 0.4F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityMoeritherium.class, 40, 0.4F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityOviraptor.class, 40, 0.3F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityLeptictidium.class, 40, 0.3F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityHorse.class, 50, 0.25F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityCow.class, 30, 0.2F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPig.class, 30, 0.15F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntitySheep.class, 30, 0.2F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityChicken.class, 10, 0.1F, 1.0F));
        this.targetTasks.addTask(3, new JurassiCraftAITargetIfHasAgeAndNonTamed(this, EntityPlayer.class, 40, 0.3F, 1.0F));

        this.setCreatureExperiencePoints(4000);
    }

    public int getTalkInterval() {
        return 350;
    }

    public void onUpdate() {
        super.onUpdate();

        this.tailBuffer.calculateChainSwingBuffer(45.0F, 5, 2.5F, this);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (3.5F * developmentFraction) + this.rand.nextInt(1 + (int) (3.5F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);
    }
}
