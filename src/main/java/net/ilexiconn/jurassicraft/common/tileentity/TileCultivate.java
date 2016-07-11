package net.ilexiconn.jurassicraft.common.tileentity;

import net.ilexiconn.jurassicraft.common.data.enums.JurassiCraftFoodNutrients;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.item.ItemDNA;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TileCultivate extends TileEntity implements ISidedInventory {
    public final Map<Short, Byte> growthRateList = new HashMap<Short, Byte>();
    private final short maxValue = 3000;
    public int animationTick;
    public int rotation;
    private Random random;
    private ItemStack[] slots = new ItemStack[4];
    private short cultivateTime;
    private int cultivateSpeed;
    private byte waterStored;
    private short proximateValue;
    private short mineralValue;
    private short vitaminValue;
    private short lipidValue;
    private float creatureSize;
    private boolean shouldUpdate;
    private Creature creature;

    public TileCultivate() {
        this.random = new Random();
        this.cultivateSpeed = 100;
        this.creature = null;
        this.waterStored = 0;
        this.cultivateTime = 0;
        this.proximateValue = 0;
        this.mineralValue = 0;
        this.vitaminValue = 0;
        this.lipidValue = 0;
        this.creatureSize = 0.0F;
    }

    public Creature getCreature() {
        return this.creature;
    }

    /**
     * Returns the current hatchery time.
     */
    public int getCultivateTime() {
        return this.cultivateTime;
    }

    /**
     * Returns the current hatchery time.
     */
    public void setCultivateTime(short time) {
        this.cultivateTime = time;
    }

    /**
     * Returns the maximum value of nutrients that can be stored.
     */
    public int getMaximumValueOfNutrients() {
        return this.maxValue;
    }

    public float getCreatureSize() {
        return this.creatureSize;
    }

    public void setCreatureSize(float time, float speed) {
        if (speed > 0) {
            this.creatureSize = time / speed;
        } else {
            this.creatureSize = 0.0F;
        }
    }

    /**
     * Returns the current water stored.
     */
    public byte getWaterStored() {
        return this.waterStored;
    }

    /**
     * Sets the water value.
     */
    public void setWaterStored(byte water) {
        this.waterStored = water;
    }

    /**
     * Returns true if there is water stored.
     */
    public boolean hasWater() {
        return (this.waterStored > 0);
    }

    /**
     * Returns the current proximate value.
     */
    public int getProximateValue() {
        return this.proximateValue;
    }

    /**
     * Sets the current value of proximate.
     */
    public void setProximateValue(short proximate) {
        this.proximateValue = proximate;
    }

    /**
     * Returns true if there is proximate stored.
     */
    public boolean hasProximate() {
        return (this.proximateValue > 0);
    }

    /**
     * Returns the current minerals value.
     */
    public int getMineralValue() {
        return this.mineralValue;
    }

    /**
     * Sets the current value of minerals.
     */
    public void setMineralValue(short mineral) {
        this.mineralValue = mineral;
    }

    /**
     * Returns true if there is mineral stored.
     */
    public boolean hasMineral() {
        return (this.mineralValue > 0);
    }

    /**
     * Returns the current vitamin value.
     */
    public int getVitaminValue() {
        return this.vitaminValue;
    }

    /**
     * Sets the current value of vitamins.
     */
    public void setVitaminValue(short vitamin) {
        this.vitaminValue = vitamin;
    }

    /**
     * Returns true if there is vitamin stored.
     */
    public boolean hasVitamin() {
        return (this.vitaminValue > 0);
    }

    /**
     * Returns the current value of lipids.
     */
    public int getLipidValue() {
        return this.lipidValue;
    }

    /**
     * Sets the current value of lipids.
     */
    public void setLipidValue(short lipids) {
        this.lipidValue = lipids;
    }

    /**
     * Returns true if there is lipids stored.
     */
    public boolean hasLipid() {
        return (this.lipidValue > 0);
    }

    /**
     * Returns a percentage of the water stored scaled for X value.
     */
    public int getWaterStoredProgressScaled(int i) {
        return (this.waterStored * i) / 3;
    }

    /**
     * Sets the cultivate process speed.
     */
    public int setCultivateSpeed(int speed) {
        return this.cultivateSpeed = speed;
    }

    /**
     * Returns the number of ticks required to cultivate the creature.
     */
    public int getCultivateSpeed() {
        return this.cultivateSpeed;
    }

    /**
     * Returns a percentage of the hatchery process scaled for X value.
     */
    public int getCultivateTimeProgressScaled(int i) {
        if (this.getCultivateSpeed() <= 0)
            this.setCultivateSpeed(100);

        return (this.getCultivateTime() * i) / this.getCultivateSpeed();
    }

    /**
     * Returns a percentage of the proximate value scaled for X value.
     */
    public int getProximateBarScaled(int i) {
        return (this.getProximateValue() * i) / this.getMaximumValueOfNutrients();
    }

    /**
     * Returns a percentage of the mineral value scaled for X value.
     */
    public int getMineralBarScaled(int i) {
        return (this.getMineralValue() * i) / this.getMaximumValueOfNutrients();
    }

    /**
     * Returns a percentage of vitamins scaled for X value.
     */
    public int getVitaminBarScaled(int i) {
        return (this.getVitaminValue() * i) / this.getMaximumValueOfNutrients();
    }

    /**
     * Returns a percentage of lipids scaled for X value.
     */
    public int getLipidBarScaled(int i) {
        return (this.getLipidValue() * i) / this.getMaximumValueOfNutrients();
    }

    /**
     * Returns true if the hatchery time is larger than 0.
     */
    public boolean isHatching() {
        return (this.cultivateTime > 0);
    }

    /**
     * Returns true if the machine can consume the water bucket at slot[0].
     */
    private boolean canCansumeWaterBucket() {
        if (this.slots[0] != null) {
            if (this.slots[0].getItem() == Items.water_bucket) {
                if (this.slots[1] == null)
                    return true;
                else if (this.slots[1].getItem() == Items.bucket)
                    return true;
            }
        }

        return false;
    }

    /**
     * Consumes water bucket from slot[0] if there is space for more water.
     */
    private void consumeWaterBucket() {
        if (!this.worldObj.isRemote) {
            if ((this.getWaterStored() + 1) > 3) {
                return;
            } else {
                this.slots[0].stackSize--;

                if (this.slots[0].stackSize <= 0)
                    this.slots[0] = null;

                this.setWaterStored((byte) (this.getWaterStored() + 1));

                if (this.slots[1] == null) {
                    ItemStack waterBucket = new ItemStack(Items.bucket);
                    this.slots[1] = waterBucket;
                } else {
                    this.slots[1].stackSize++;
                }
            }
        }
    }

    /**
     * Returns true if the machine can consume food.
     */
    private boolean canCansumeFood() {
        if (this.slots[3] == null) {
            return false;
        } else {
            if ((proximateValue < this.getMaximumValueOfNutrients()) || (mineralValue < this.getMaximumValueOfNutrients()) || (vitaminValue < this.getMaximumValueOfNutrients()) || (lipidValue < this.getMaximumValueOfNutrients())) {
                if (JurassiCraftFoodNutrients.FOODLIST.containsKey(this.slots[3].getItem()))
                    return true;
            }

            return false;
        }
    }

    /**
     * Consumes food from slot[7] if it is valid.
     */
    private void consumeFood() {
        if (!worldObj.isRemote) {
            int id = JurassiCraftFoodNutrients.FOODLIST.get(this.slots[3].getItem());

            if (this.slots[3].getItem() instanceof ItemBucketMilk) {
                this.slots[3] = null;
                this.slots[3] = new ItemStack(Items.bucket);
            } else {
                this.slots[3].stackSize--;

                if (this.slots[3].stackSize <= 0)
                    this.slots[3] = null;
            }

            if (proximateValue < this.getMaximumValueOfNutrients()) {
                proximateValue = (short) (proximateValue + (800 + random.nextInt(201)) * (JurassiCraftFoodNutrients.values()[id].getProximate()));

                if (proximateValue > this.getMaximumValueOfNutrients())
                    proximateValue = (short) this.getMaximumValueOfNutrients();
            }

            if (mineralValue < this.getMaximumValueOfNutrients()) {
                mineralValue = (short) (mineralValue + (900 + random.nextInt(101)) * (JurassiCraftFoodNutrients.values()[id].getMinerals()));

                if (mineralValue > this.getMaximumValueOfNutrients())
                    mineralValue = (short) this.getMaximumValueOfNutrients();
            }

            if (vitaminValue < this.getMaximumValueOfNutrients()) {
                vitaminValue = (short) (vitaminValue + (900 + random.nextInt(101)) * (JurassiCraftFoodNutrients.values()[id].getVitamins()));

                if (vitaminValue > this.getMaximumValueOfNutrients())
                    vitaminValue = (short) this.getMaximumValueOfNutrients();
            }

            if (lipidValue < this.getMaximumValueOfNutrients()) {
                lipidValue = (short) (lipidValue + (980 + random.nextInt(101)) * (JurassiCraftFoodNutrients.values()[id].getLipids()));

                if (lipidValue > this.getMaximumValueOfNutrients())
                    lipidValue = (short) this.getMaximumValueOfNutrients();
            }
        }
    }

    /**
     * Returns true if the machine can cultivate certain creature.
     */
    private boolean canCultivate() {
        ItemStack dnaSlot = getDNASlot();

        if (dnaSlot != null) {
            if (dnaSlot.hasTagCompound()) {
                if (dnaSlot.getTagCompound().hasKey("Quality") && dnaSlot.getTagCompound().hasKey("DNA")) {
                    if (dnaSlot.getTagCompound().getInteger("Quality") >= 50) {
                        creature = CreatureHandler.getCreatureFromDNA((ItemDNA) dnaSlot.getItem());

                        return !(this.getProximateValue() < creature.getMinProximate() || this.getMineralValue() < creature.getMinMinerals() || this.getVitaminValue() < creature.getMinVitamins() || this.getLipidValue() < creature.getMinLipids());
                    }
                }
            }
        }

        return false;
    }

    /**
     * Creates the specific creature for the current DNA setup.
     */
    private void cultivateCreature() {
        if (!canCultivate()) {
            return;
        } else {
            NBTTagCompound compound = new NBTTagCompound();

            ItemStack cultivateResult = new ItemStack(((ItemDNA) getDNASlot().getItem()).getCorrespondingEggOrSyringe(), 1, 0);

            if (creature.getEgg() != null)
                compound.setInteger("EggQuality", getDNASlot().getTagCompound().getInteger("Quality"));

            compound.setString("EggDNA", getDNASlot().getTagCompound().getString("DNA"));

            if (creature.getMammalSyringe() != null)
                compound.setInteger("SyringeQuality", getDNASlot().getTagCompound().getInteger("Quality"));

            compound.setString("SyringeDNA", getDNASlot().getTagCompound().getString("DNA"));

            cultivateResult.setTagCompound(compound);

            this.slots[2] = null;
            this.slots[2] = cultivateResult;
            this.setCultivateTime((short) 0);
            this.setWaterStored((byte) 0);

            this.proximateValue = (short) (proximateValue - creature.getMinProximate());
            this.mineralValue = (short) (mineralValue - creature.getMinMinerals());
            this.vitaminValue = (short) (vitaminValue - creature.getMinVitamins());
            this.lipidValue = (short) (lipidValue - creature.getMinLipids());
        }
    }

    private ItemStack getDNASlot() {
        return this.slots[2];
    }

    /**
     * Resets a list of values to update the size of the creature for rendering.
     */
    private void recalculateGrowthRate() {
        if (creature != null) {
            int speed = creature.getCultivateSpeed();

            for (byte i = 0; i <= 10 - 1; i++) {
                if (i > 0)
                    this.growthRateList.put((short) ((i * speed) / 10), i);
                else
                    this.growthRateList.put((short) 2, (byte) 0);
            }
        }
    }

    /**
     * Resets cultivateTime and creature, and updates render.
     */
    private void resetBaseValues() {
        this.cultivateTime = 0;
        this.cultivateSpeed = 100;
        this.creature = null;
        this.growthRateList.clear();
        this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
    }

    /**
     * Check for any item stacks in all slots.
     */
    public boolean hasItems() {
        return this.slots[0] != null || this.slots[1] != null || getDNASlot() != null || this.slots[3] != null;
    }

    /**
     * Check for any item stacks in the DNA slot.
     */
    private boolean hasEmptyDNASlot() {
        return (getDNASlot() == null) ? true : false;
    }

    public void updateEntity() {
        animationTick++;

        if (animationTick == Integer.MAX_VALUE)
            animationTick = 0;

        if (!this.worldObj.isRemote) {
            if (!this.isHatching()) {
                if (this.canCansumeWaterBucket())
                    this.consumeWaterBucket();

                if (canCansumeFood())
                    this.consumeFood();

                if (this.getWaterStored() >= 3) {
                    if ((this.getProximateValue() > 0) && (this.getMineralValue() > 0) && (this.getVitaminValue() > 0) && (this.getLipidValue() > 0)) {
                        if (this.canCultivate()) {
                            this.cultivateSpeed = creature.getCultivateSpeed();
                            this.recalculateGrowthRate();
                            this.setCultivateTime((short) 1);
                            this.creatureSize = 0.0F;
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                        }
                    }
                }
            } else {
                this.cultivateTime++;

                if (this.growthRateList.containsKey(cultivateTime)) {
                    this.setCreatureSize(this.cultivateTime, this.cultivateSpeed);
                    this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                } else if (shouldUpdate) {
                    this.setCreatureSize(this.cultivateTime, this.cultivateSpeed);
                    this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                    this.shouldUpdate = false;
                }

                if (this.cultivateTime >= this.cultivateSpeed) {
                    this.cultivateCreature();
                    this.resetBaseValues();
                } else {
                    if (this.hasEmptyDNASlot())
                        this.resetBaseValues();
                }
            }
        }
    }

    public void cancelHatching(float progress) {
        if (this.isHatching()) {
            this.setProximateValue((short) (this.getProximateValue() - (int) (progress * creature.getMinProximate())));
            this.setMineralValue((short) (this.getMineralValue() - (int) (progress * creature.getMinMinerals())));
            this.setVitaminValue((short) (this.getVitaminValue() - (int) (progress * creature.getMinVitamins())));
            this.setLipidValue((short) (this.getLipidValue() - (int) (progress * creature.getMinLipids())));

            if (progress >= 0.75F)
                this.setWaterStored((byte) 0);
            else if (progress >= 0.5F)
                this.setWaterStored((byte) 1);
            else
                this.setWaterStored((byte) 2);

            this.cultivateTime = 0;
            this.cultivateSpeed = 100;
            this.creature = null;
            this.growthRateList.clear();
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
    }

    public int getSizeInventory() {
        return this.slots.length;
    }

    public ItemStack getStackInSlot(int i) {
        return this.slots[i];
    }

    public ItemStack decrStackSize(int i, int stackSize) {
        if (this.slots[i] != null) {
            ItemStack splitedStack;

            if (this.slots[i].stackSize <= stackSize) {
                splitedStack = this.slots[i];
                this.slots[i] = null;

                return splitedStack;
            } else {
                splitedStack = this.slots[i].splitStack(stackSize);

                if (this.slots[i].stackSize == 0)
                    this.slots[i] = null;

                return splitedStack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.slots[i] != null) {
            ItemStack itemStack = this.slots[i];
            this.slots[i] = null;

            return itemStack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.slots[i] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
            itemStack.stackSize = this.getInventoryStackLimit();
    }

    public String getInventoryName() {
        return "Hatchery";
    }

    public boolean hasCustomInventoryName() {
        return true;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return ((this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D));
    }

    public void openInventory() {

    }

    public void closeInventory() {

    }

    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return false;
    }

    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[] { 0 };
    }

    public boolean canInsertItem(int i, ItemStack itemStack, int j) {
        return false;
    }

    public boolean canExtractItem(int i, ItemStack itemStack, int j) {
        return false;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        byte creatureID = -1;

        if (creature != null)
            creatureID = creature.getCreatureID();

        nbt.setByte("CreatureID", creatureID);
        nbt.setByte("Water", waterStored);
        nbt.setShort("Proximate", proximateValue);
        nbt.setShort("Mineral", mineralValue);
        nbt.setShort("Vitamin", vitaminValue);
        nbt.setShort("Lipid", lipidValue);
        nbt.setShort("cultivateTime", cultivateTime);
        nbt.setFloat("CreatureSize", creatureSize);

        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }

        nbt.setInteger("rotation", rotation);
        nbt.setTag("Items", list);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.shouldUpdate = true;

        NBTTagList list = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        for (int slotId = 0; slotId < list.tagCount(); slotId++) {
            NBTTagCompound compound = list.getCompoundTagAt(slotId);
            byte slot = compound.getByte("Slot");

            if (slot >= 0 && slot < this.slots.length)
                this.slots[slot] = ItemStack.loadItemStackFromNBT(compound);
        }

        this.creature = CreatureHandler.getCreatureFromId(nbt.getByte("CreatureID"));
        this.creatureSize = nbt.getShort("CreatureSize");
        this.waterStored = nbt.getByte("Water");
        this.cultivateTime = nbt.getShort("cultivateTime");
        this.proximateValue = nbt.getShort("Proximate");
        this.mineralValue = nbt.getShort("Mineral");
        this.vitaminValue = nbt.getShort("Vitamin");
        this.lipidValue = nbt.getShort("Lipid");
        this.rotation = nbt.getInteger("rotation");

        if (creature != null) {
            this.setCultivateSpeed(creature.getCultivateSpeed());
            this.recalculateGrowthRate();
        }
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        this.writeToNBT(compound);

        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, compound);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        NBTTagCompound compound = packet.func_148857_g();
        this.readFromNBT(compound);
    }
}