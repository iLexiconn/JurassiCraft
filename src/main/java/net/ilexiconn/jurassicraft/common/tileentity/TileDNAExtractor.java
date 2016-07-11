package net.ilexiconn.jurassicraft.common.tileentity;

import net.ilexiconn.jurassicraft.common.api.IDNASource;
import net.ilexiconn.jurassicraft.common.entity.Creature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.ilexiconn.jurassicraft.common.item.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class TileDNAExtractor extends TileEntity implements ISidedInventory {
    private static final short extractionSpeed = 100;
    private ItemStack[] slots = new ItemStack[8];
    private short extractionTime;
    private ArrayList<ItemDNA> allDNAs = new ArrayList<ItemDNA>();

    public TileDNAExtractor() {
        this.extractionTime = 0;

        for (Creature creature : CreatureHandler.getCreatures()) {
            ItemDNA dna = creature.getDNA();

            if (dna != null)
                this.allDNAs.add(dna);
        }
    }

    public short getExtractionTime() {
        return extractionTime;
    }

    public void setExtractionTime(short time) {
        this.extractionTime = time;
    }

    public short getExtractionSpeed() {
        return extractionSpeed;
    }

    public int getExtractionProgressScaled(int i) {
        return (this.getExtractionTime() * i) / this.getExtractionSpeed();
    }

    public boolean isExtracting() {
        return (this.getExtractionTime() > 0);
    }

    private boolean canExtract() {
        if (this.slots[0] == null && this.slots[1] == null && this.slots[2] == null && this.slots[3] == null)
            return false;
        else
            return !(this.slots[4] != null && this.slots[5] != null && this.slots[6] != null && this.slots[7] != null);
    }

    private void extractItem() {
        for (int i = 0; i < 4; i++) {
            if (slots[i] != null && slots[i].getItem() instanceof IDNASource) {
                ItemStack newItem = null;

                if (slots[i].getItem() instanceof ItemFossil)
                    newItem = this.getDNASampleFromFossil();
                else if (slots[i].getItem() instanceof ItemMeat)
                    newItem = this.getDNASampleFromMeat(slots[i]);
                else if (slots[i].getItem() instanceof ItemAmber)
                    newItem = this.getDNASampleFromAmber();
                else if (slots[i].getItem() instanceof ItemFur || slots[i].getItem() instanceof ItemSkin || slots[i].getItem() instanceof ItemScale || slots[i].getItem() instanceof ItemFeather || slots[i].getItem() instanceof ItemSkull || slots[i].getItem() instanceof ItemTooth || slots[i].getItem() instanceof ItemBristles)
                    newItem = this.getDNASampleFromDrop(slots[i]);
                else {
                    int output = this.worldObj.rand.nextInt(3);

                    if (output == 0)
                        newItem = new ItemStack(Blocks.sand, 1 + this.worldObj.rand.nextInt(2));
                    else if (output == 1)
                        newItem = new ItemStack(Blocks.cobblestone, 1 + this.worldObj.rand.nextInt(2));
                    else if (output == 2)
                        newItem = new ItemStack(Items.bone, 1 + this.worldObj.rand.nextInt(3));
                }

                if (newItem != null) {
                    for (int j = 4; j < 8; j++) {
                        if (this.slots[j] != null && this.slots[j].getItem() == newItem.getItem() && !newItem.hasTagCompound()) {
                            this.slots[i].stackSize--;

                            if (this.slots[i].stackSize <= 0)
                                this.slots[i] = null;

                            this.slots[j].stackSize++;
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                            return;
                        }
                    }

                    for (int j = 4; j < 8; j++) {
                        if (this.slots[j] == null) {
                            this.slots[i].stackSize--;

                            if (this.slots[i].stackSize <= 0)
                                this.slots[i] = null;

                            this.slots[j] = newItem;
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                            return;
                        }
                    }
                }
            }
        }
    }

    private ItemStack getDNASampleFromFossil() {
        if (this.worldObj.rand.nextFloat() >= 0.70F) {
            ItemStack dna = new ItemStack(this.getRandomDNA());

            if (!dna.hasTagCompound()) {
                NBTTagCompound compound = new NBTTagCompound();
                float probability = this.worldObj.rand.nextFloat();

                if (probability <= 0.10F)
                    compound.setInteger("Quality", 100);
                else if (probability <= 0.35F)
                    compound.setInteger("Quality", 75);
                else if (probability <= 0.75F)
                    compound.setInteger("Quality", 50);
                else
                    compound.setInteger("Quality", 25);

                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
                dna.setTagCompound(compound);

                return dna;
            } else {
                if (!dna.getTagCompound().hasKey("Quality")) {
                    float probability = this.worldObj.rand.nextFloat();

                    if (probability <= 0.10F)
                        dna.getTagCompound().setInteger("Quality", 100);
                    else if (probability <= 0.35F)
                        dna.getTagCompound().setInteger("Quality", 75);
                    else if (probability <= 0.75F)
                        dna.getTagCompound().setInteger("Quality", 50);
                    else
                        dna.getTagCompound().setInteger("Quality", 25);
                }

                if (!dna.getTagCompound().hasKey("DNA"))
                    dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
            }
        } else {
            int output = this.worldObj.rand.nextInt(3);

            if (output == 0)
                return new ItemStack(Blocks.sand, 1 + this.worldObj.rand.nextInt(2));
            else if (output == 1)
                return new ItemStack(Blocks.cobblestone, 1 + this.worldObj.rand.nextInt(2));
            else if (output == 2)
                return new ItemStack(Items.bone, 1 + this.worldObj.rand.nextInt(3));
        }

        return null;
    }

    private ItemStack getDNASampleFromAmber() {
        ItemStack dna = new ItemStack(this.getRandomDNA());

        if (!dna.hasTagCompound()) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("Quality", 100);
            compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());
            dna.setTagCompound(compound);

            return dna;
        } else {
            if (!dna.getTagCompound().hasKey("Quality"))
                dna.getTagCompound().setInteger("Quality", 100);

            if (!dna.getTagCompound().hasKey("DNA"))
                dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

            return dna;
        }
    }

    private ItemStack getDNASampleFromMeat(ItemStack meat) {
        ItemStack dna = new ItemStack(this.getDNAFromMeat((ItemMeat) meat.getItem()));

        if (meat.hasTagCompound()) {
            dna.setTagCompound(meat.getTagCompound());

            if (!dna.getTagCompound().hasKey("Quality"))
                dna.getTagCompound().setInteger("Quality", 100);

            if (!dna.getTagCompound().hasKey("DNA"))
                dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

            return dna;
        } else {
            if (!dna.hasTagCompound()) {
                NBTTagCompound compound = new NBTTagCompound();

                compound.setInteger("Quality", 100);
                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

                dna.setTagCompound(compound);

                return dna;
            } else {
                if (!dna.getTagCompound().hasKey("Quality"))
                    dna.getTagCompound().setInteger("Quality", 100);

                if (!dna.getTagCompound().hasKey("DNA"))
                    dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

                return dna;
            }
        }
    }

    private ItemStack getDNASampleFromDrop(ItemStack stack) {
        ItemStack dna = null;

        Item item = stack.getItem();

        if (item instanceof ItemFur)
            dna = new ItemStack(((ItemFur) item).getCorrespondingDNA());
        else if (item instanceof ItemSkin)
            dna = new ItemStack(((ItemSkin) item).getCorrespondingDNA());
        else if (item instanceof ItemScale)
            dna = new ItemStack(((ItemScale) item).getCorrespondingDNA());
        else if (item instanceof ItemFeather)
            dna = new ItemStack(((ItemFeather) item).getCorrespondingDNA());
        else if (item instanceof ItemSkull)
            dna = new ItemStack(((ItemSkull) item).getCorrespondingDNA());
        else if (item instanceof ItemTooth)
            dna = new ItemStack(((ItemTooth) item).getCorrespondingDNA());
        else if (item instanceof ItemBristles)
            dna = new ItemStack(((ItemBristles) item).getCorrespondingDNA());
        else
            dna = new ItemStack(this.getRandomDNA());

        if (stack.hasTagCompound()) {
            dna.setTagCompound(stack.getTagCompound());

            if (!dna.getTagCompound().hasKey("Quality"))
                dna.getTagCompound().setInteger("Quality", 100);

            if (!dna.getTagCompound().hasKey("DNA"))
                dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

            return dna;
        } else {
            if (!dna.hasTagCompound()) {
                NBTTagCompound compound = new NBTTagCompound();

                compound.setInteger("Quality", 100);
                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

                dna.setTagCompound(compound);

                return dna;
            } else {
                if (!dna.getTagCompound().hasKey("Quality"))
                    dna.getTagCompound().setInteger("Quality", 100);

                if (!dna.getTagCompound().hasKey("DNA"))
                    dna.getTagCompound().setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

                return dna;
            }
        }
    }

    private Item getDNAFromMeat(ItemMeat meat) {
        return meat.getCorrespondingDNA();
    }

    private Item getRandomDNA() {
        return allDNAs.get(this.worldObj.rand.nextInt(allDNAs.size()));
    }

    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            if (this.canExtract()) {
                this.extractionTime++;

                if (this.getExtractionTime() >= this.getExtractionSpeed()) {
                    this.setExtractionTime((short) 0);
                    this.extractItem();
                }
            } else {
                this.setExtractionTime((short) 0);
            }
        }
    }

    public boolean hasItems() {
        return (this.slots[0] != null || this.slots[1] != null || this.slots[2] != null || this.slots[3] != null || this.slots[4] != null || this.slots[5] != null || this.slots[6] != null || this.slots[7] != null) ? true : false;
    }

    public int getSizeInventory() {
        return slots.length;
    }

    public ItemStack getStackInSlot(int i) {
        return slots[i];
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
            ItemStack stack = this.slots[i];
            this.slots[i] = null;

            return stack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack stack) {
        this.slots[i] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();
    }

    public String getInventoryName() {
        return "DNA Extractor";
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

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);

        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound compound = list.getCompoundTagAt(i);
            byte slot = compound.getByte("Slot");

            if (slot >= 0 && slot < this.slots.length)
                this.slots[slot] = ItemStack.loadItemStackFromNBT(compound);
        }

        this.setExtractionTime(nbt.getShort("ExtractionTime"));
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("ExtractionTime", this.getExtractionTime());
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