package net.ilexiconn.jurassicraft.common.tileentity.fence;

import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowBase;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowCorner;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowGrid;
import net.ilexiconn.jurassicraft.common.block.fence.BlockSecurityFenceLowPole;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TileSecurityFenceLowCorner extends TileEntity implements ISidedInventory {
    private static final int REDSTONEPERGRID = 2;
    private static final int IRONPERGRID = 1;
    private ItemStack[] slots = new ItemStack[6];
    private boolean[] builtFences = new boolean[4];
    private boolean[] fenceState = new boolean[4];
    private int plannedSide = 0;

    public TileSecurityFenceLowCorner() {
        this.plannedSide = 0;
        for (int i = 0; i < builtFences.length; i++)
            builtFences[i] = false;
    }

    public int getPlannedSide() {
        return this.plannedSide;
    }

    public void setPlannedSide(int side) {
        this.plannedSide = side;
    }

    public void setFenceAt(int side, boolean hasFenceAt) {
        this.builtFences[side] = hasFenceAt;
    }

    public boolean hasFenceAt(int side) {
        return this.builtFences[side];
    }

    public void setFenceOff(int side) {
        this.fenceState[side] = false;
    }

    public void setFenceOn(int side) {
        this.fenceState[side] = true;
    }

    public void setFenceOnOff(int side, boolean turnOnOrOff) {
        this.fenceState[side] = turnOnOrOff;
    }

    public boolean isFenceOff(int side) {
        return !this.fenceState[side];
    }

    public boolean isFenceOn(int side) {
        return this.fenceState[side];
    }

    public boolean hasIronStored() {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                if (this.slots[i].getItem().getUnlocalizedName().equals("item.ingotIron"))
                    return true;
            }
        }
        return false;
    }

    public boolean hasNumberOfIronStored(int amount) {
        int ironStored = 0;
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                if (this.slots[i].getItem().getUnlocalizedName().equals("item.ingotIron"))
                    ironStored += this.slots[i].stackSize;
            }
        }
        return ironStored >= amount;
    }

    public void reduceIronIngots(int amount) {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                if (this.slots[i].getItem().getUnlocalizedName().equals("item.ingotIron")) {
                    if (this.slots[i].stackSize >= amount) {
                        this.slots[i].stackSize -= amount;
                        if (this.slots[i].stackSize < 1)
                            this.slots[i] = null;
                    } else {
                        amount -= this.slots[i].stackSize;
                        this.slots[i] = null;
                    }
                }
            }
        }
    }

    public boolean hasRedstoneStored() {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                if (this.slots[i].getItem() instanceof ItemRedstone)
                    return true;
            }
        }
        return false;
    }

    public boolean hasNumberOfRedstoneStored(int amount) {
        int redstoneStored = 0;
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                if (this.slots[i].getItem() instanceof ItemRedstone)
                    redstoneStored += this.slots[i].stackSize;
            }
        }
        return redstoneStored >= amount;
    }

    public void reduceRedstone(int amount) {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                if (this.slots[i].getItem() instanceof ItemRedstone) {
                    if (this.slots[i].stackSize >= amount) {
                        this.slots[i].stackSize -= amount;
                        if (this.slots[i].stackSize < 1)
                            this.slots[i] = null;
                    } else {
                        amount -= this.slots[i].stackSize;
                        this.slots[i] = null;
                    }
                }
            }
        }
    }

    public boolean hasItems() {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null && this.slots[i].stackSize > 0)
                return true;
        }
        return false;
    }

    private boolean hasLowSecurityMainFenceBlockAt(TileSecurityFenceLowCorner mainFence, int x, int y, int z) {
        return mainFence.worldObj.getBlock(x, y, z) instanceof BlockSecurityFenceLowCorner;
    }

    private boolean hasLowSecurityBaseFenceBlockAt(TileSecurityFenceLowCorner mainFence, int x, int y, int z) {
        return mainFence.worldObj.getBlock(x, y, z) instanceof BlockSecurityFenceLowBase;
    }

    private boolean hasLowSecurityPoleFenceBlockAt(TileSecurityFenceLowCorner mainFence, int x, int y, int z) {
        return mainFence.worldObj.getBlock(x, y, z) instanceof BlockSecurityFenceLowPole;
    }

    private boolean hasLowSecurityGridFenceBlockAt(TileSecurityFenceLowCorner mainFence, int x, int y, int z) {
        return mainFence.worldObj.getBlock(x, y, z) instanceof BlockSecurityFenceLowGrid;
    }

    public TileSecurityFenceLowCorner getNextLowSecurityMainFenceBlock(TileSecurityFenceLowCorner mainFence, int side, int distance) {
        TileEntity tileEntity = null;
        switch (side) {
            /** South */
            case 0:
                for (int i = 1; i < distance; i++) {
                    if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + i))
                        tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + i);
                }
                break;
            /** West */
            case 1:
                for (int i = 1; i < distance; i++) {
                    if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord - i, mainFence.yCoord, mainFence.zCoord))
                        tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord - i, mainFence.yCoord, mainFence.zCoord);
                }
                break;
            /** North */
            case 2:
                for (int i = 1; i < distance; i++) {
                    if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - i))
                        tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - i);
                }
                break;
            /** East */
            case 3:
                for (int i = 1; i < distance; i++) {
                    if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord + i, mainFence.yCoord, mainFence.zCoord))
                        tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord + i, mainFence.yCoord, mainFence.zCoord);
                }
                break;
        }
        if (tileEntity instanceof TileSecurityFenceLowCorner) {
            return (TileSecurityFenceLowCorner) tileEntity;
        } else {
            return null;
        }
    }

    public TileSecurityFenceLowCorner getNextLowSecurityMainFenceBlockDirectly(TileSecurityFenceLowCorner mainFence, int side, int distance) {
        TileEntity tileEntity = null;
        switch (side) {
            /** South */
            case 0:
                if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + distance))
                    tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + distance);
                break;
            /** West */
            case 1:
                if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord - distance, mainFence.yCoord, mainFence.zCoord))
                    tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord - distance, mainFence.yCoord, mainFence.zCoord);
                break;
            /** North */
            case 2:
                if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - distance))
                    tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - distance);
                break;
            /** East */
            case 3:
                if (mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord + distance, mainFence.yCoord, mainFence.zCoord))
                    tileEntity = mainFence.worldObj.getTileEntity(mainFence.xCoord + distance, mainFence.yCoord, mainFence.zCoord);
                break;
        }
        if (tileEntity instanceof TileSecurityFenceLowCorner) {
            return (TileSecurityFenceLowCorner) tileEntity;
        } else {
            return null;
        }
    }

    public int getFencePoleHeight(TileSecurityFenceLowCorner mainFence) {
        int i = 0;
        if (mainFence.worldObj != null) {
            while (this.hasLowSecurityPoleFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord))
                i++;
        }
        return i;
    }

    public int getSmallerFencePoleHeight(TileSecurityFenceLowCorner mainFence1, TileSecurityFenceLowCorner mainFence2) {
        int heigthFence1 = this.getFencePoleHeight(mainFence1);
        int heigthFence2 = this.getFencePoleHeight(mainFence2);
        return Math.min(heigthFence1, heigthFence2);
    }

    public List<TileSecurityFenceLowPole> getAllFencePoles(TileSecurityFenceLowCorner mainFence) {
        int i = this.getFencePoleHeight(mainFence);
        if (i > 0) {
            List<TileSecurityFenceLowPole> fencePoles = new ArrayList();
            for (int j = 0; j < i; j++) {
                fencePoles.add((TileSecurityFenceLowPole) mainFence.worldObj.getTileEntity(mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord));
            }
            return fencePoles;
        }
        return null;
    }

    public void setGridsToAllFencePoles(TileSecurityFenceLowCorner mainFence) {
        int i = this.getFencePoleHeight(mainFence);

        for (int height = 0; height < i; height++) {
            for (int side = 0; side < 4; side++) {
                TileEntity fence = mainFence.worldObj.getTileEntity(mainFence.xCoord, mainFence.yCoord + height + 1, mainFence.zCoord);
                if (fence instanceof TileSecurityFenceLowPole)
                    ((TileSecurityFenceLowPole) fence).setGridAtSide(side, this.hasFenceAt(side));
            }
        }
    }

    public int getFenceBaseLength(TileSecurityFenceLowCorner mainFence, int side) {
        boolean flag = true;
        int metadata = mainFence.getBlockMetadata();
        int i = 0;
        switch (side) {
            /** South */
            case 0:
                while (flag) {
                    metadata = mainFence.worldObj.getBlockMetadata(mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + i + 1);
                    if (mainFence.hasLowSecurityBaseFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + i + 1) && (metadata == 1 || metadata == 3)) {
                        i++;
                    } else {
                        flag = false;
                    }
                }
                break;
            /** West */
            case 1:
                while (flag) {
                    metadata = mainFence.worldObj.getBlockMetadata(mainFence.xCoord - i - 1, mainFence.yCoord, mainFence.zCoord);
                    if (mainFence.hasLowSecurityBaseFenceBlockAt(mainFence, mainFence.xCoord - i - 1, mainFence.yCoord, mainFence.zCoord) && (metadata == 0 || metadata == 2)) {
                        i++;
                    } else {
                        flag = false;
                    }
                }
                break;
            /** North */
            case 2:
                while (flag) {
                    metadata = mainFence.worldObj.getBlockMetadata(mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - i - 1);
                    if (mainFence.hasLowSecurityBaseFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - i - 1) && (metadata == 1 || metadata == 3)) {
                        i++;
                    } else {
                        flag = false;
                    }
                }
                break;
            /** East */
            case 3:
                while (flag) {
                    metadata = mainFence.worldObj.getBlockMetadata(mainFence.xCoord + i + 1, mainFence.yCoord, mainFence.zCoord);
                    if (mainFence.hasLowSecurityBaseFenceBlockAt(mainFence, mainFence.xCoord + i + 1, mainFence.yCoord, mainFence.zCoord) && (metadata == 0 || metadata == 2)) {
                        i++;
                    } else {
                        flag = false;
                    }
                }
                break;
        }
        return i;
    }

    public boolean isBaseAtSideValid(TileSecurityFenceLowCorner mainFence, int side, int length) {
        length++;
        switch (side) {
            /** South */
            case 0:
                return mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord + length);
            /** West */
            case 1:
                return mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord - length, mainFence.yCoord, mainFence.zCoord);
            /** North */
            case 2:
                return mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord, mainFence.zCoord - length);
            /** East */
            case 3:
                return mainFence.hasLowSecurityMainFenceBlockAt(mainFence, mainFence.xCoord + length, mainFence.yCoord, mainFence.zCoord);
            default:
                return false;
        }
    }

    public boolean hasEmptySpaceAt(TileSecurityFenceLowCorner mainFence, int side, int length, int height) {
        switch (side) {
            /** South */
            case 0:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.worldObj.isAirBlock(mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord + j + 1))
                            return false;
                    }
                }
                break;
            /** West */
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.worldObj.isAirBlock(mainFence.xCoord - j - 1, mainFence.yCoord + i + 1, mainFence.zCoord))
                            return false;
                    }
                }
                break;
            /** North */
            case 2:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.worldObj.isAirBlock(mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord - j - 1))
                            return false;
                    }
                }
                break;
            /** East */
            case 3:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.worldObj.isAirBlock(mainFence.xCoord + j + 1, mainFence.yCoord + i + 1, mainFence.zCoord))
                            return false;
                    }
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean hasGridBetweenSpace(TileSecurityFenceLowCorner mainFence, int side, int length, int height) {
        switch (side) {
            /** South */
            case 0:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord + j + 1))
                            return false;
                    }
                }
                break;
            /** West */
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord - j - 1, mainFence.yCoord + i + 1, mainFence.zCoord))
                            return false;
                    }
                }
                break;
            /** North */
            case 2:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord - j - 1))
                            return false;
                    }
                }
                break;
            /** East */
            case 3:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord + j + 1, mainFence.yCoord + i + 1, mainFence.zCoord))
                            return false;
                    }
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public int getNumberOfGridsToBuild(int lengthOfTheFence, int heightOfTheFence) {
        return lengthOfTheFence * heightOfTheFence;
    }

    public int getNumberOfGridsToFix(TileSecurityFenceLowCorner mainFence, int side, int length, int height) {
        int numberOfGridsMissing = 0;
        switch (side) {
            /** South */
            case 0:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord + j + 1))
                            numberOfGridsMissing++;
                    }
                }
                break;
            /** West */
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord - j - 1, mainFence.yCoord + i + 1, mainFence.zCoord))
                            numberOfGridsMissing++;
                    }
                }
                break;
            /** North */
            case 2:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord, mainFence.yCoord + i + 1, mainFence.zCoord - j - 1))
                            numberOfGridsMissing++;
                    }
                }
                break;
            /** East */
            case 3:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (!mainFence.hasLowSecurityGridFenceBlockAt(mainFence, mainFence.xCoord + j + 1, mainFence.yCoord + i + 1, mainFence.zCoord))
                            numberOfGridsMissing++;
                    }
                }
                break;
        }
        return numberOfGridsMissing;
    }

    public int getRedstoneRequiredForGrid(int numberOfGrids) {
        return REDSTONEPERGRID * numberOfGrids;
    }

    public int getIronRequiredForGrid(int numberOfGrids) {
        return IRONPERGRID * numberOfGrids;
    }

    private void buildFenceOff(TileSecurityFenceLowCorner mainFence1, TileSecurityFenceLowCorner mainFence2, int side, int length, int height) {
        Block grid = JCBlockRegistry.securityFenceLowGrid;
        switch (side) {
            /** South */
            case 0:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        mainFence1.worldObj.setBlock(mainFence1.xCoord, mainFence1.yCoord + i + 1, mainFence1.zCoord + j + 1, grid, 1, 2);
                    }
                }
                mainFence1.setFenceAt(0, true);
                mainFence1.setFenceOff(0);
                mainFence2.setFenceAt(2, true);
                mainFence2.setFenceOff(2);
                break;
            /** West */
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        mainFence1.worldObj.setBlock(mainFence1.xCoord - j - 1, mainFence1.yCoord + i + 1, mainFence1.zCoord, grid, 2, 2);
                    }
                }
                mainFence1.setFenceAt(1, true);
                mainFence1.setFenceOff(1);
                mainFence2.setFenceAt(3, true);
                mainFence2.setFenceOff(3);
                break;
            /** North */
            case 2:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        mainFence1.worldObj.setBlock(mainFence1.xCoord, mainFence1.yCoord + i + 1, mainFence1.zCoord - j - 1, grid, 3, 2);
                    }
                }
                mainFence1.setFenceAt(2, true);
                mainFence1.setFenceOff(2);
                mainFence2.setFenceAt(0, true);
                mainFence2.setFenceOff(0);
                break;
            /** East */
            case 3:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        mainFence1.worldObj.setBlock(mainFence1.xCoord + j + 1, mainFence1.yCoord + i + 1, mainFence1.zCoord, grid, 0, 2);
                    }
                }
                mainFence1.setFenceAt(3, true);
                mainFence1.setFenceOff(3);
                mainFence2.setFenceAt(1, true);
                mainFence2.setFenceOff(1);
                break;
        }
    }

    private void changeFenceState(boolean turnOnOrOff, TileSecurityFenceLowCorner mainFence1, TileSecurityFenceLowCorner mainFence2, int side, int length, int height) {
        int metadata = 0;
        if (turnOnOrOff) {
            switch (side) {
                case 0:
                    metadata = 1;
                    break;
                case 1:
                    metadata = 2;
                    break;
                case 2:
                    metadata = 3;
                    break;
                case 3:
                    metadata = 0;
                    break;
            }
        } else {
            switch (side) {
                case 0:
                    metadata = 5;
                    break;
                case 1:
                    metadata = 6;
                    break;
                case 2:
                    metadata = 7;
                    break;
                case 3:
                    metadata = 4;
                    break;
            }
        }
        switch (side) {
            /** South */
            case 0:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (mainFence1.hasLowSecurityGridFenceBlockAt(mainFence1, mainFence1.xCoord, mainFence1.yCoord + i + 1, mainFence1.zCoord + j + 1)) {
                            mainFence1.worldObj.setBlockMetadataWithNotify(mainFence1.xCoord, mainFence1.yCoord + i + 1, mainFence1.zCoord + j + 1, metadata, 2);
                        }
                    }
                }
                mainFence1.setFenceOnOff(0, !turnOnOrOff);
                mainFence2.setFenceOnOff(2, !turnOnOrOff);
                break;
            /** West */
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (mainFence1.hasLowSecurityGridFenceBlockAt(mainFence1, mainFence1.xCoord - j - 1, mainFence1.yCoord + i + 1, mainFence1.zCoord)) {
                            mainFence1.worldObj.setBlockMetadataWithNotify(mainFence1.xCoord - j - 1, mainFence1.yCoord + i + 1, mainFence1.zCoord, metadata, 2);
                        }
                    }
                }
                mainFence1.setFenceOnOff(1, !turnOnOrOff);
                mainFence2.setFenceOnOff(3, !turnOnOrOff);
                break;
            /** North */
            case 2:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (mainFence1.hasLowSecurityGridFenceBlockAt(mainFence1, mainFence1.xCoord, mainFence1.yCoord + i + 1, mainFence1.zCoord - j - 1)) {
                            mainFence1.worldObj.setBlockMetadataWithNotify(mainFence1.xCoord, mainFence1.yCoord + i + 1, mainFence1.zCoord - j - 1, metadata, 2);
                        }
                    }
                }
                mainFence1.setFenceOnOff(2, !turnOnOrOff);
                mainFence2.setFenceOnOff(0, !turnOnOrOff);
                break;
            /** East */
            case 3:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < length; j++) {
                        if (mainFence1.hasLowSecurityGridFenceBlockAt(mainFence1, mainFence1.xCoord + j + 1, mainFence1.yCoord + i + 1, mainFence1.zCoord)) {
                            mainFence1.worldObj.setBlockMetadataWithNotify(mainFence1.xCoord + j + 1, mainFence1.yCoord + i + 1, mainFence1.zCoord, metadata, 2);
                        }
                    }
                }
                mainFence1.setFenceOnOff(3, !turnOnOrOff);
                mainFence2.setFenceOnOff(1, !turnOnOrOff);
                break;
        }
    }

    public void tryToBuildFence(int side) {
        if (this.worldObj.isRemote) {
            return;
        } else {
            int length = this.getFenceBaseLength(this, side);

            if (!this.isBaseAtSideValid(this, side, length)) {
                return;
            } else {
                TileSecurityFenceLowCorner otherFence = this.getNextLowSecurityMainFenceBlockDirectly(this, side, length + 1);

                int height = this.getSmallerFencePoleHeight(this, otherFence);
                int numberOfGrids = this.getNumberOfGridsToBuild(length, height);

                int ironRequired = this.getIronRequiredForGrid(numberOfGrids);

                if (!this.hasNumberOfIronStored(ironRequired)) {
                    return;
                } else {
                    int redstoneRequired = this.getRedstoneRequiredForGrid(numberOfGrids);
                    if (!this.hasNumberOfRedstoneStored(redstoneRequired)) {
                        return;
                    } else {
                        if (!this.hasEmptySpaceAt(this, side, length, height)) {
                            return;
                        } else {
                            this.buildFenceOff(this, otherFence, side, length, height);
                            this.reduceIronIngots(ironRequired);
                            this.reduceRedstone(redstoneRequired);
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                            otherFence.worldObj.markBlockForUpdate(otherFence.xCoord, otherFence.yCoord, otherFence.zCoord);
                        }
                    }
                }
            }
        }
    }

    public void tryToFixFence(int side) {
        if (this.worldObj.isRemote) {
            return;
        } else {
            int length = this.getFenceBaseLength(this, side);

            if (!this.isBaseAtSideValid(this, side, length)) {
                /** Missing other main base. */
                return;
            } else {
                TileSecurityFenceLowCorner otherFence = this.getNextLowSecurityMainFenceBlockDirectly(this, side, length + 1);

                int height = this.getSmallerFencePoleHeight(this, otherFence);

                if (this.hasGridBetweenSpace(this, side, length, height)) {
                    /** The fence does not need to be fixed. */
                    return;
                } else {
                    int numberOfGrids = this.getNumberOfGridsToFix(this, side, length, height);

                    int ironRequired = this.getIronRequiredForGrid(numberOfGrids);

                    if (!this.hasNumberOfIronStored(ironRequired)) {
                        /** More iron ingot is required. */
                        return;
                    } else {
                        int redstoneRequired = this.getRedstoneRequiredForGrid(numberOfGrids);

                        if (!this.hasNumberOfRedstoneStored(redstoneRequired)) {
                            /** More redstone is required. */
                            return;
                        } else {
                            this.buildFenceOff(this, otherFence, side, length, height);
                            this.reduceIronIngots(ironRequired);
                            this.reduceRedstone(redstoneRequired);
                            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                            otherFence.worldObj.markBlockForUpdate(otherFence.xCoord, otherFence.yCoord, otherFence.zCoord);
                        }
                    }
                }
            }
        }
    }

    public void tryToTurnOnTheFence(int side) {
        if (this.worldObj.isRemote) {
            return;
        } else {
            int length = this.getFenceBaseLength(this, side);

            if (!this.isBaseAtSideValid(this, side, length)) {
                return;
            } else {
                TileSecurityFenceLowCorner otherFence = this.getNextLowSecurityMainFenceBlockDirectly(this, side, length + 1);

                int height = this.getSmallerFencePoleHeight(this, otherFence);

                this.changeFenceState(this.isFenceOn(side), this, otherFence, side, length, height);
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
                otherFence.worldObj.markBlockForUpdate(otherFence.xCoord, otherFence.yCoord, otherFence.zCoord);
            }
        }
    }

    /**
     * Returns a HashMap<Integer, int[]> with all coordinates of every fence block between an area of 22 x 22.
     * <p/>
     * Note: 0 = xCoord, 1 = yCoord, 2 = zCoord.
     */
    public HashMap<Integer, int[]> getAllFenceBlocks() {
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        int numberOfBlocks = 0;
        for (int i = -11; i < 12; i++) {
            for (int k = -11; k < 12; k++) {
                if (this.hasLowSecurityMainFenceBlockAt(this, this.xCoord + i, this.yCoord, this.zCoord + k) || this.hasLowSecurityBaseFenceBlockAt(this, this.xCoord + i, this.yCoord, this.zCoord + k) || this.hasLowSecurityPoleFenceBlockAt(this, this.xCoord + i, this.yCoord, this.zCoord + k) || this.hasLowSecurityGridFenceBlockAt(this, this.xCoord + i, this.yCoord, this.zCoord + k)) {
                    map.put(numberOfBlocks, new int[] { i, k });
                    numberOfBlocks++;
                }
            }
        }
        return map;
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
                if (this.slots[i].stackSize == 0) {
                    this.slots[i] = null;
                }
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
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return "Security_Fence_Main_Block";
    }

    public boolean hasCustomInventoryName() {
        return true;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 49.0D;
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

    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(tagCompound);
                list.appendTag(tagCompound);
            }
        }
        compound.setTag("Items", list);

        for (int i = 0; i < builtFences.length; i++)
            compound.setBoolean("FenceAtSide" + i, this.hasFenceAt(i));

        for (int i = 0; i < fenceState.length; i++)
            compound.setBoolean("FenceStateAtSide" + i, this.isFenceOn(i));

        compound.setByte("PlannedSide", (byte) this.getPlannedSide());
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList list = compound.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound tagCompound = list.getCompoundTagAt(i);
            byte j = tagCompound.getByte("Slot");

            if (j >= 0 && j < this.slots.length) {
                this.slots[j] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }

        for (int i = 0; i < builtFences.length; i++)
            this.setFenceAt(i, compound.getBoolean("FenceAtSide" + i));

        for (int i = 0; i < fenceState.length; i++)
            this.setFenceOnOff(i, compound.getBoolean("FenceStateAtSide" + i));

        this.setPlannedSide((int) compound.getByte("PlannedSide"));
        this.setGridsToAllFencePoles(this);
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
