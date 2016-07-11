package net.ilexiconn.jurassicraft.common.entity.ai;

import com.google.common.collect.Lists;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class JurassiCraftAIGoNearWater extends EntityAIBase {
    private double speed;
    private EntityJurassiCraftCreature creature;
    private World world;
    private boolean foundPool;
    private float poolX;
    private float poolY;
    private float poolZ;
    private int maxDist;
    private long lastTimeExecuted;
    private float maxTime;

    public JurassiCraftAIGoNearWater(EntityJurassiCraftCreature creature, double creatureSpeed) {
        this(creature, creatureSpeed, ((60 * 6 + 35) * 1f / 20f)); // 6 minutes and 35 seconds
    }

    public JurassiCraftAIGoNearWater(EntityJurassiCraftCreature creature, double creatureSpeed, float maxTime) {
        this(creature, creatureSpeed, 25, maxTime);
    }

    public JurassiCraftAIGoNearWater(EntityJurassiCraftCreature creature, double creatureSpeed, int maxSearchDistance, float maxTime) {
        this.creature = creature;
        this.world = creature.worldObj;
        this.speed = creatureSpeed;
        this.maxDist = maxSearchDistance;
        this.poolY = -64;
        this.maxTime = maxTime;
    }

    public boolean continueExecuting() {
        return !foundPool && creature.getDistance(poolX, poolY, poolZ) > 5.0D;
    }

    public void startExecuting() {
        ArrayList<Vec3> waterBlocks = Lists.newArrayList();

        int startX = (int) Math.floor(creature.posX);
        int startY = (int) Math.floor(creature.posY);
        int startZ = (int) Math.floor(creature.posZ);

        for (int x = -maxDist / 2 + startX; x < maxDist / 2 + startX; x++) {
            for (int y = -maxDist / 2 + startY; y < maxDist / 2 + startY; y++) {
                for (int z = -maxDist / 2 + startZ; z < maxDist / 2 + startZ; z++) {
                    if (world.getBlock(x, y, z) == Blocks.water) {
                        waterBlocks.add(Vec3.createVectorHelper(x, y, z));
                    }
                }
            }
        }
        // Now that we have all the blocks of water around the creature, we sort them to get blobs of water and then get their center

        List<List<Vec3>> blobsList = Lists.newArrayList();
        blocksList:
        for (Vec3 waterPos : waterBlocks) {
            for (List<Vec3> list : blobsList) {
                for (Vec3 pos : list) {
                    if (isNextTo(pos, waterPos)) {
                        list.add(waterPos);
                        continue blocksList;
                    }
                }
            }
            // If we are here, that means no blocks where found near this block

            List<Vec3> blob = Lists.newArrayList();
            blob.add(waterPos);
            blobsList.add(blob);
        }

        // Then we merge blobs that are next to each other because the previous algorithm might separate some

        List<List<Vec3>> finalList = Lists.newArrayList();
        finalList.addAll(blobsList);

        blobList:
        for (List<Vec3> blob : blobsList) {
            for (Vec3 pos : blob) {
                for (List<Vec3> otherBlob : blobsList) {
                    for (Vec3 otherPos : otherBlob) {
                        if (isNextTo(pos, otherPos) && finalList.contains(blob) && finalList.contains(otherBlob)) {
                            List<Vec3> mergedBlob = Lists.newArrayList();
                            mergedBlob.addAll(blob);
                            mergedBlob.addAll(otherBlob);
                            finalList.add(mergedBlob);
                            finalList.remove(blob);
                            finalList.remove(otherBlob);
                            continue blobList;
                        }
                    }
                }
            }
        }
        // Finally, we calculate the center of each pool and get the nearest one.
        for (List<Vec3> blob : finalList) {
            double centerX = 0;
            double centerY = 0;
            double centerZ = 0;

            for (Vec3 pos : blob) {
                centerX += pos.xCoord;
                centerY += pos.yCoord;
                centerZ += pos.zCoord;
            }

            centerX /= blob.size();
            centerY /= blob.size();
            centerZ /= blob.size();

            if (creature.getDistance(centerX, centerY, centerZ) <= creature.getDistance(poolX, poolY, poolZ) || poolY <= 0) {
                poolX = (float) Math.floor(centerX);
                poolY = (float) Math.floor(centerY);
                poolZ = (float) Math.floor(centerZ);
                lastTimeExecuted = world.getWorldTime(); // TODO: Check if entity can go to this pool
                this.foundPool = true;
            }
        }
    }

    public void updateTask() {
        if (foundPool) {
            PathNavigate navigator = creature.getNavigator();
            PathEntity path = navigator.getPathToXYZ(poolX, poolY, poolZ);

            if (path != null)
                navigator.setPath(path, speed);

            lastTimeExecuted = world.getWorldTime();
        }
    }

    public boolean isInterruptible() {
        return true;
    }

    private boolean isNextTo(Vec3 a, Vec3 b) {
        double dx = a.xCoord - b.xCoord;
        double dy = a.yCoord - b.yCoord;
        double dz = a.zCoord - b.zCoord;
        return (dx + dy + dz) == 1f;
    }

    public void resetTask() {
        super.resetTask();

        this.foundPool = false;

        this.poolX = 0;
        this.poolY = -64;
        this.poolZ = 0;

        lastTimeExecuted = world.getWorldTime();
    }

    public boolean shouldExecute() {
        return world.getWorldTime() - lastTimeExecuted >= maxTime && Math.random() < 0.10;
    }
}
