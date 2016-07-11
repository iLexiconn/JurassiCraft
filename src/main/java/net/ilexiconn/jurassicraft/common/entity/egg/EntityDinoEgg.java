package net.ilexiconn.jurassicraft.common.entity.egg;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.JurassiCraft;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftSmart;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;

public class EntityDinoEgg extends Entity implements IEntityAdditionalSpawnData {
    public Creature creature;
    public int quality;
    public int currentSpawnTime;
    public int spawnTime;
    public int rockAmount;
    public boolean froze;
    public boolean dried;

    public EntityDinoEgg(World world) {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.stepHeight = 1F;
    }

    public EntityDinoEgg(World world, Creature creature, int spawnTime) {
        this(world);
        this.creature = creature;
        this.spawnTime = spawnTime;
    }

    public EntityDinoEgg(World world, Creature creature, int quality, String dna, int spawnTime, double x, double y, double z) {
        this(world, creature, spawnTime);
        this.setPosition(x + 0.5F, y, z + 0.5F);
        this.quality = quality;
        this.setDNASequence(dna);
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    /**
     * Sets the creature DNA quality.
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * Returns the creature DNA quality.
     */
    public int getDNAQuality() {
        return this.quality;
    }

    /**
     * Returns the creature DNA sequence.
     */
    public String getDNASequence() {
        return this.dataWatcher.getWatchableObjectString(24);
    }

    /**
     * Sets the creature DNA sequence.
     */
    public void setDNASequence(String dna) {
        this.dataWatcher.updateObject(24, String.valueOf(dna));
    }

    public void setCurrentSpawnTime(int currentSpawnTime) {
        this.currentSpawnTime = currentSpawnTime;
    }

    public void setSpawnTime(int spawnTime) {
        this.spawnTime = spawnTime;
    }

    public boolean attackEntityFrom(DamageSource damage, float amount) {
        if (!this.isEntityInvulnerable()) {
            // if (this.worldObj.isRemote)
            // {
            // if (amount > 0)
            // {
            // Minecraft mc = Minecraft.getMinecraft();
            //
            // Random random = new Random();
            //
            // for (int currentParticle = 0; currentParticle < 50; ++currentParticle)
            // {
            // float f3 = MathHelper.randomFloatClamp(random, 0.0F, ((float) Math.PI * 2F));
            // double d5 = (double) MathHelper.randomFloatClamp(random, 0.75F, 1.0F);
            // double velY = 0.20000000298023224D + 1 / 100.0D;
            // double velX = (double) (MathHelper.cos(f3) * 0.2F) * d5 * d5 * (1 + 0.2D);
            // double velZ = (double) (MathHelper.sin(f3) * 0.2F) * d5 * d5 * (1 + 0.2D);
            // // mc.theWorld.spawnParticle("blockdust_" + Block.getIdFromBlock(Blocks.sandstone) + "_0", (double) ((float) this.posX), (double) ((float) this.posY), (double) ((float) this.posZ), velX, velY, velZ);
            // }
            // }
            // }
            this.setDead();
        }

        return super.attackEntityFrom(damage, amount);
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity entity) {
        return entity.boundingBox;
    }

    /**
     * returns the bounding box for this entity
     */
    public AxisAlignedBB getBoundingBox() {
        return null;
    }

    public boolean canBePushed() {
        return true;
    }

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public void onUpdate() {
        super.onUpdate();

        if (!this.isDead) {
            if (this.worldObj.isRemote) {
                this.froze = this.dataWatcher.getWatchableObjectInt(25) != 0;

                this.dried = this.dataWatcher.getWatchableObjectInt(26) != 0;

                this.currentSpawnTime = this.dataWatcher.getWatchableObjectInt(27);
            }

            if (!this.onGround)
                this.motionY -= 0.05F;

            if (this.motionY < -0.8F)
                this.motionY = -0.8F;

            if (this.onGround) {
                this.motionX *= 0.5F;
                this.motionZ *= 0.5F;
            } else {
                this.motionX *= 0.7F;
                this.motionZ *= 0.7F;
            }

            if (!this.worldObj.isRemote) {
                int amountToIncrease = 0;

                List<EggEnviroment> enviroments = EggEnviroment.getEnviroments(this);

                boolean wet = enviroments.contains(EggEnviroment.WET);
                boolean warm = enviroments.contains(EggEnviroment.WARM);
                boolean overheat = enviroments.contains(EggEnviroment.OVERHEAT);
                boolean cold = enviroments.contains(EggEnviroment.COLD);

                if (this.creature.isWaterCreature()) {
                    if (!wet) {
                        if (overheat)
                            amountToIncrease = -2;
                        else
                            amountToIncrease = -1;
                    } else {
                        amountToIncrease = 2;
                    }
                } else {
                    if (warm && !wet) {
                        amountToIncrease = 1;
                    } else {
                        if (cold && wet)
                            amountToIncrease = -2;
                        else
                            amountToIncrease = -1;
                    }
                }

                this.currentSpawnTime += amountToIncrease;

                if (this.currentSpawnTime < -500) {
                    if (this.creature.isWaterCreature())
                        this.dried = true;
                    else
                        this.froze = true;
                }

                if (this.currentSpawnTime >= this.spawnTime) {
                    Class dinoToSpawnClass = this.creature.getCreatureClass();

                    try {
                        Entity dinoToSpawn = (Entity) dinoToSpawnClass.getConstructor(World.class).newInstance(this.worldObj);

                        if (dinoToSpawn instanceof EntityJurassiCraftCreature) {
                            EntityJurassiCraftCreature baby = (EntityJurassiCraftCreature) dinoToSpawn;
                            baby.setGenetics(this.quality, this.getDNASequence());

                            EntityJurassiCraftSmart smartBaby = (EntityJurassiCraftSmart) baby;
                            if (dinoToSpawn instanceof EntityJurassiCraftSmart && smartBaby.canBeTamedUponSpawning()) {
                                EntityPlayer owner = this.worldObj.getClosestPlayerToEntity(this, 6.0F);

                                if (owner != null) {
                                    smartBaby.setTamed(true, owner);
                                    smartBaby.setOwner(owner.getCommandSenderName());

                                    this.worldObj.setEntityState(baby, (byte) 7);
                                }
                            }

                            baby.setPosition(this.posX, this.posY, this.posZ);

                            this.worldObj.spawnEntityInWorld(baby);
                            this.currentSpawnTime = 0;
                            this.setDead();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (this.currentSpawnTime < (this.spawnTime - 100)) {
                if (!this.dried && !this.froze) {
                    if (this.rotationPitch >= 5)
                        this.rockAmount = -1;
                    else if (this.rotationPitch <= -5)
                        this.rockAmount = 1;

                    this.rotationPitch += (this.rockAmount / 2.0F);
                }
            }

            if (!this.worldObj.isRemote) {
                this.dataWatcher.updateObject(25, this.froze ? 1 : 0);
                this.dataWatcher.updateObject(26, this.dried ? 1 : 0);
                this.dataWatcher.updateObject(27, this.currentSpawnTime);
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
        }
    }

    public void fall(float fallDistance) {
        super.fall(fallDistance);

        if (fallDistance > 10 && this.onGround)
            attackEntityFrom(DamageSource.fall, 1F);
    }

    protected void entityInit() {
        this.dataWatcher.addObject(24, "");
        this.dataWatcher.addObject(25, 0);
        this.dataWatcher.addObject(26, 0);
        this.dataWatcher.addObject(27, this.rockAmount);
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation(JurassiCraft.getModId() + "textures/eggs/egg" + this.creature.getCreatureName() + ".png");
    }

    public int getHatchingProgressScaled(int i) {
        if (this.spawnTime > 0) {
            return i * this.currentSpawnTime / this.spawnTime;
        }

        return 0;
    }

    public boolean interactFirst(EntityPlayer player) {
        if (player.getHeldItem() == null) {
            ItemStack stack = new ItemStack(this.creature.getEgg());

            if (!player.worldObj.isRemote) {
                NBTTagCompound compound = new NBTTagCompound();

                compound.setInteger("EggQuality", this.quality);
                compound.setString("EggDNA", this.getDNASequence());

                stack.setTagCompound(compound);

                if (player.inventory.addItemStackToInventory(stack)) {
                    this.worldObj.playSoundAtEntity(player, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    this.setDead();
                }
            }
        }

        return true;
    }

    public void writeEntityToNBT(NBTTagCompound nbt) {
        nbt.setInteger("CreatureID", this.creature.getCreatureID());
        nbt.setString("DNASequence", this.getDNASequence());
        nbt.setInteger("Quality", this.quality);
        nbt.setInteger("SpawnTime", this.spawnTime);
        nbt.setInteger("CurrentSpawnTime", this.currentSpawnTime);
        nbt.setBoolean("Froze", this.froze);
        nbt.setBoolean("Dried", this.dried);
    }

    public void readEntityFromNBT(NBTTagCompound nbt) {
        this.creature = CreatureHandler.getCreatureFromId(nbt.getInteger("CreatureID"));
        this.setDNASequence(nbt.getString("DNASequence"));
        this.setQuality(nbt.getInteger("Quality"));
        this.spawnTime = nbt.getInteger("SpawnTime");
        this.currentSpawnTime = nbt.getInteger("CurrentSpawnTime");
        this.froze = nbt.getBoolean("Froze");
        this.dried = nbt.getBoolean("Dried");
    }

    public void writeSpawnData(ByteBuf buffer) {
        buffer.writeInt(this.creature.getCreatureID());
        buffer.writeInt(this.quality);
        buffer.writeInt(this.spawnTime);
    }

    public void readSpawnData(ByteBuf additionalData) {
        this.creature = CreatureHandler.getCreatureFromId(additionalData.readInt());
        this.quality = additionalData.readInt();
        this.spawnTime = additionalData.readInt();
    }
}
