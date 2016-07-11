package net.ilexiconn.jurassicraft.common.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGenAmberOre implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.isSurfaceWorld()) {
            int x, y, z;

            x = random.nextInt(16) + (chunkX * 16);
            y = random.nextInt(20);
            z = random.nextInt(16) + (chunkZ * 16);

            (new WorldGenMinable(JCBlockRegistry.amberOre, 6)).generate(world, random, x, y, z);
        }
    }
}
