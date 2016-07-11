package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.common.api.IHerbivore;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCoward;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIHypsilophodonScratchHead;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityLeaellynasaura extends EntityJurassiCraftCoward implements IHerbivore {
    public EntityLeaellynasaura(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.25D * this.getCreatureSpeed()));
        this.tasks.addTask(2, new JurassiCraftAISit(this));
        this.tasks.addTask(2, new AnimationAIHypsilophodonScratchHead(this));
        this.tasks.addTask(3, new JurassiCraftAIAvoidEntityIfNotTamed(this, EntityPlayer.class, 6.5F, 0.9D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityHerrerasaurus.class, 12.0F, 1.0D * this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 40, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(4, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 30, 0.8D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 7.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(6, new HerdAIFollowHerd(this, false, getCreatureSpeed()));

        this.targetTasks.addTask(1, new JurassiCraftAIFleeOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIFleeOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.setCreatureExperiencePoints(800);
    }

    public int getTalkInterval() {
        return 350;
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;

        int count = Math.round(1 + (1.0F * developmentFraction) + this.rand.nextInt(1 + (int) (2.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);
    }
}