package net.ilexiconn.jurassicraft.common.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftRidable;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantCow;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantHorse;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantPig;
import net.ilexiconn.jurassicraft.common.entity.mammals.EntityPregnantSheep;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class JurassiCraftLivingEvent {
    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        Entity entity = event.entity;

        if (entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) entity) == null)
            EntityPregnantCow.register((EntityCow) entity);
        else if (entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) entity) == null)
            EntityPregnantPig.register((EntityPig) entity);
        else if (entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) entity) == null)
            EntityPregnantHorse.register((EntityHorse) entity);
        else if (entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) entity) == null)
            EntityPregnantSheep.register((EntitySheep) entity);
    }

    @SubscribeEvent
    public void onEntityJump(LivingJumpEvent event) {
        Entity ridingEntity = event.entityLiving.ridingEntity;

        if (ridingEntity instanceof EntityJurassiCraftRidable)
            ((EntityJurassiCraftRidable) ridingEntity).rideJump();
    }

    @SubscribeEvent
    public void onEntityLiving(LivingUpdateEvent event) {
        if (event.entityLiving instanceof EntityCow) {
            EntityPregnantCow cow = EntityPregnantCow.get((EntityCow) event.entityLiving);

            if (cow != null && !cow.getMammalName().equals("noEmbryo")) {
                if (cow.getPregnancyProgress() < cow.getPregnancySpeed()) {
                    cow.increasePregnancyProgress();
                    event.entityLiving.onLivingUpdate();
                } else {
                    spawnMammalBaby(cow.getMammalName(), cow.getDNAQuality(), cow.getDNASequence(), event);
                    cow.setMammalName("noEmbryo");
                    cow.setDNAQuality(0);
                    cow.setDNASequence("");
                    cow.setPregnancyProgress(0);
                    cow.setPregnancySpeed(0);
                }
            }
        } else if (event.entityLiving instanceof EntityPig) {
            EntityPregnantPig pig = EntityPregnantPig.get((EntityPig) event.entityLiving);

            if (pig != null && !pig.getMammalName().equals("noEmbryo")) {
                if (pig.getPregnancyProgress() < pig.getPregnancySpeed()) {
                    pig.increasePregnancyProgress();
                    event.entityLiving.onLivingUpdate();
                } else {
                    spawnMammalBaby(pig.getMammalName(), pig.getDNAQuality(), pig.getDNASequence(), event);
                    pig.setMammalName("noEmbryo");
                    pig.setDNAQuality(0);
                    pig.setDNASequence("");
                    pig.setPregnancyProgress(0);
                    pig.setPregnancySpeed(0);
                }
            }
        } else if (event.entityLiving instanceof EntityHorse) {
            EntityPregnantHorse horse = EntityPregnantHorse.get((EntityHorse) event.entityLiving);

            if (horse != null && !horse.getMammalName().equals("noEmbryo")) {
                if (horse.getPregnancyProgress() < horse.getPregnancySpeed()) {
                    horse.increasePregnancyProgress();
                    event.entityLiving.onLivingUpdate();
                } else {
                    spawnMammalBaby(horse.getMammalName(), horse.getDNAQuality(), horse.getDNASequence(), event);
                    horse.setMammalName("noEmbryo");
                    horse.setDNAQuality(0);
                    horse.setDNASequence("");
                    horse.setPregnancyProgress(0);
                    horse.setPregnancySpeed(0);
                }
            }
        } else if (event.entityLiving instanceof EntitySheep) {
            EntityPregnantSheep sheep = EntityPregnantSheep.get((EntitySheep) event.entityLiving);

            if (sheep != null && !sheep.getMammalName().equals("noEmbryo")) {
                if (sheep.getPregnancyProgress() < sheep.getPregnancySpeed()) {
                    sheep.increasePregnancyProgress();
                    event.entityLiving.onLivingUpdate();
                } else {
                    spawnMammalBaby(sheep.getMammalName(), sheep.getDNAQuality(), sheep.getDNASequence(), event);
                    sheep.setMammalName("noEmbryo");
                    sheep.setDNAQuality(0);
                    sheep.setDNASequence("");
                    sheep.setPregnancyProgress(0);
                    sheep.setPregnancySpeed(0);
                }
            }
        }
    }

    public void spawnMammalBaby(String mammalName, int quality, String dnaSequence, LivingUpdateEvent event) {
        Class mammalToSpawnClass = CreatureHandler.getCreatureFromName(mammalName).getCreatureClass();

        if (mammalToSpawnClass != null) {
            try {
                Entity mammalToSpawn = (Entity) mammalToSpawnClass.getConstructor(World.class).newInstance(event.entityLiving.worldObj);

                if (mammalToSpawn instanceof EntityJurassiCraftCreature) {
                    EntityJurassiCraftCreature baby = (EntityJurassiCraftCreature) mammalToSpawn;
                    baby.setGenetics(quality, dnaSequence);

                    if (mammalToSpawn instanceof EntityJurassiCraftSmart && ((EntityJurassiCraftSmart) baby).canBeTamedUponSpawning()) {
                        EntityPlayer owner = event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 6.0F);

                        if (owner != null) {
                            ((EntityJurassiCraftSmart) baby).setTamed(true, owner);
                            ((EntityJurassiCraftSmart) baby).setOwner(owner.getCommandSenderName());
                            event.entityLiving.worldObj.setEntityState(baby, (byte) 7);
                        }
                    }

                    baby.setPosition(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);

                    if (!event.entityLiving.worldObj.isRemote) {
                        event.entityLiving.worldObj.spawnEntityInWorld(baby);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
