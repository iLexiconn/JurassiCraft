package net.ilexiconn.jurassicraft.common.tileentity;

import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileDNACombinator extends TileEntity implements ISidedInventory {
    private static final short combinationSpeed = 100;
    private ItemStack[] slots = new ItemStack[3];
    private short combinationTime;

    public TileDNACombinator() {
        this.combinationTime = 0;
    }

    public short getCombinationTime() {
        return combinationTime;
    }

    public void setCombinationTime(short time) {
        this.combinationTime = time;
    }

    public short getCombinationSpeed() {
        return combinationSpeed;
    }

    public int getCombinationProgressScaled(int i) {
        return (this.getCombinationTime() * i) / this.getCombinationSpeed();
    }

    public boolean isCombining() {
        return (this.getCombinationTime() > 0);
    }

    private boolean canCombine() {
        if (this.slots[0] == null || this.slots[1] == null)
            return false;
        else if (this.slots[0].getItem() != this.slots[1].getItem())
            return false;
        else if (!slots[0].hasTagCompound() || !slots[1].hasTagCompound())
            return false;
        else if (!slots[0].getTagCompound().hasKey("Quality") || !slots[1].getTagCompound().hasKey("Quality") || !slots[0].getTagCompound().hasKey("DNA") || !slots[1].getTagCompound().hasKey("DNA"))
            return false;
        else if (slots[0].getTagCompound().getInteger("Quality") + slots[1].getTagCompound().getInteger("Quality") > 100)
            return false;

        return (this.slots[2] == null || (this.slots[0].getItem() == this.slots[2].getItem() && (slots[0].getTagCompound().getInteger("Quality") + slots[1].getTagCompound().getInteger("Quality") == slots[2].getTagCompound().getInteger("Quality")))) ? true : false;
    }

    private void combineDNA() {
        ItemStack combinedDNA = new ItemStack(slots[0].getItem());

        NBTTagCompound compound = new NBTTagCompound();

        compound.setInteger("Quality", slots[0].getTagCompound().getInteger("Quality") + slots[1].getTagCompound().getInteger("Quality"));
        compound.setString("DNA", JurassiCraftDNAHandler.mixTwoDNAs(slots[0].getTagCompound().getString("DNA"), slots[1].getTagCompound().getString("DNA")));

        combinedDNA.setTagCompound(compound);

        slots[0].stackSize--;

        if (slots[0].stackSize <= 0)
            slots[0] = null;

        slots[1].stackSize--;

        if (slots[1].stackSize <= 0)
            slots[1] = null;

        if (slots[2] != null)
            slots[2].stackSize++;
        else
            slots[2] = combinedDNA;
    }

    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            if (this.canCombine()) {
                this.combinationTime++;

                if (this.getCombinationTime() >= this.getCombinationSpeed()) {
                    this.setCombinationTime((short) 0);
                    this.combineDNA();
                }
            } else {
                this.setCombinationTime((short) 0);
            }
        }
    }

    public boolean hasItems() {
        return (this.slots[0] != null || this.slots[1] != null || this.slots[2] != null) ? true : false;
    }

    public int getSizeInventory() {
        return slots.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return slots[slot];
    }

    public ItemStack decrStackSize(int slotIndex, int amount) {
        if (this.slots[slotIndex] != null) {
            ItemStack splitedStack;

            if (this.slots[slotIndex].stackSize <= amount) {
                splitedStack = this.slots[slotIndex];
                this.slots[slotIndex] = null;
                return splitedStack;
            } else {
                splitedStack = this.slots[slotIndex].splitStack(amount);

                if (this.slots[slotIndex].stackSize == 0)
                    this.slots[slotIndex] = null;

                return splitedStack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        if (this.slots[slotIndex] != null) {
            ItemStack stack = this.slots[slotIndex];
            this.slots[slotIndex] = null;

            return stack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int soltIndex, ItemStack stack) {
        this.slots[soltIndex] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();
    }

    public String getInventoryName() {
        return "DNA Combiner";
    }

    public boolean hasCustomInventoryName() {
        return true;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {
    }

    public void closeInventory() {
    }

    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[] { 0 };
    }

    public boolean canInsertItem(int slot, ItemStack stack, int j) {
        return false;
    }

    public boolean canExtractItem(int slot, ItemStack stack, int j) {
        return false;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList items = nbt.getTagList("Items", 10);

        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < items.tagCount(); i++) {
            NBTTagCompound compound = items.getCompoundTagAt(i);
            byte slot = compound.getByte("Slot");

            if (slot >= 0 && slot < this.slots.length) {
                this.slots[slot] = ItemStack.loadItemStackFromNBT(compound);
            }
        }

        this.setCombinationTime(nbt.getShort("CombinationTime"));
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("CombinationTime", this.getCombinationTime());
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }

        nbt.setTag("Items", list);
    }
}