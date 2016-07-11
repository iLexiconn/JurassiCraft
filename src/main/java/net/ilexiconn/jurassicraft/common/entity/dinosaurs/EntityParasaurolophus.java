package net.ilexiconn.jurassicraft.common.entity.dinosaurs;

import net.ilexiconn.jurassicraft.client.model.base.ControlledParam;
import net.ilexiconn.jurassicraft.common.api.IHerbivore;
import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftAnimationIDs;
import net.ilexiconn.jurassicraft.common.entity.ChainBuffer;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftProtective;
import net.ilexiconn.jurassicraft.common.entity.ai.*;
import net.ilexiconn.jurassicraft.common.entity.ai.animation.AnimationAIParasaurolophusTrumpet;
import net.ilexiconn.jurassicraft.common.entity.ai.herds.HerdAIFollowHerd;
import net.ilexiconn.jurassicraft.common.handler.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityParasaurolophus extends EntityJurassiCraftProtective implements IHerbivore {
    public ChainBuffer tailBuffer = new ChainBuffer(6);
    public ControlledParam walkLean = new ControlledParam(0, 0, (float) Math.PI / 2, 0);
    public int timeUntilCanCall = 0;

    public EntityParasaurolophus(World world) {
        super(world);
        this.getNavigator().setAvoidsWater(true);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new JurassiCraftAIAngry(this, 200));
        this.tasks.addTask(1, new JurassiCraftAIFlee(this, 60, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(2, new JurassiCraftAISit(this));
        this.tasks.addTask(2, new AnimationAIParasaurolophusTrumpet(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.1F * this.getCreatureSpeed(), false));
        this.tasks.addTask(4, new JurassiCraftAIFollowFood(this, 50, 1.1D * this.getCreatureSpeed()));
        this.tasks.addTask(4, new JurassiCraftAIEatDroppedFood(this, 16.0D));
        this.tasks.addTask(4, new JurassiCraftAIEating(this, 20));
        this.tasks.addTask(5, new JurassiCraftAIWander(this, 45, 0.7D * this.getCreatureSpeed()));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 12.0F, this.getCreatureSpeed(), 1.2D * this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new JurassiCraftAIHerdBehavior(this, 128, 2500, 24, this.getCreatureSpeed()));
        this.tasks.addTask(7, new HerdAIFollowHerd(this, false, getCreatureSpeed()));

        this.targetTasks.addTask(1, new JurassiCraftAIOwnerIsHurtByTarget(this));
        this.targetTasks.addTask(2, new JurassiCraftAIOwnerHurtsTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setCreatureExperiencePoints(1800);
    }

    public double getMountedYOffset() {
        return 1.1D * (double) this.getYBouningBox();
    }

    public int getNumberOfAllies() {
        return 1;
    }

    public int getTalkInterval() {
        return 350;
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.moveForward != 0)
            this.walkLean.change = 0.1F;

        if (this.moveForward == 0)
            this.walkLean.change = -0.1F;

        this.walkLean.update();

        if (timeUntilCanCall > 0)
            timeUntilCanCall--;

        this.tailBuffer.calculateChainSwingBuffer(48.0F, 3, 5.0F, this);
    }

    public String getLivingSound() {
        int sound = this.rand.nextInt(3);

        if (sound <= 1) {
            this.playSound("jurassicraft:" + this.getCreatureName().toLowerCase(), this.getSoundVolume(), this.getSoundPitch());
            return null;
        } else {
            if (timeUntilCanCall == 0 && animID == 0)
                AnimationHandler.sendAnimationPacket(this, JurassiCraftAnimationIDs.TRUMPET.animID());

            return null;
        }
    }

    public List<EntityParasaurolophus> getParasaurolophusNearby(double distanceX, double distanceY, double distanceZ) {
        List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(distanceX, distanceY, distanceZ));
        ArrayList<EntityParasaurolophus> listParasaurolophus = new ArrayList<EntityParasaurolophus>();

        for (Entity entityNeighbor : list) {
            if (entityNeighbor instanceof EntityParasaurolophus && entityNeighbor != this)
                listParasaurolophus.add((EntityParasaurolophus) entityNeighbor);
        }

        return listParasaurolophus;
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        float developmentFraction = this.getGrowthStage() / 120.0F;
        int count = Math.round(1 + (4.0F * developmentFraction) + this.rand.nextInt(1 + (int) (4.0F * developmentFraction)) + this.rand.nextInt(1 + enchantBonus));

        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), count));
        else
            this.dropItem(this.getCreature().getSteak(), count);

        if (this.rand.nextFloat() < 0.1F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkull()));

        if (this.isMale() && this.rand.nextFloat() < 0.25F)
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getSkin()));
    }
}
