package net.ilexiconn.jurassicraft.common.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.ilexiconn.jurassicraft.common.block.JCBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class WorldGenFossilOre implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.isSurfaceWorld()) {
            int x, y, z;

            for (int i = 0; i < 20; i++) {
                x = random.nextInt(16) + (chunkX * 16);
                z = random.nextInt(16) + (chunkZ * 16);
                int worldHeight = world.getHeightValue(x, z);

                if (worldHeight <= 0)
                    worldHeight = 4;

                y = random.nextInt(worldHeight);

                generateOre(world, random, x, y, z);
            }
        }
    }

    public boolean generateOre(World world, Random random, int x, int y, int z) {
        int numberOfBlocks = 7 + random.nextInt(3);

        float f = random.nextFloat() * (float) Math.PI;
        double d0 = (double) ((float) (x + 8) + MathHelper.sin(f) * (float) numberOfBlocks / 8.0F);
        double d1 = (double) ((float) (x + 8) - MathHelper.sin(f) * (float) numberOfBlocks / 8.0F);
        double d2 = (double) ((float) (z + 8) + MathHelper.cos(f) * (float) numberOfBlocks / 8.0F);
        double d3 = (double) ((float) (z + 8) - MathHelper.cos(f) * (float) numberOfBlocks / 8.0F);
        double d4 = (double) (y + random.nextInt(3) - 2);
        double d5 = (double) (y + random.nextInt(3) - 2);

        for (int l = 0; l <= numberOfBlocks; ++l) {
            double d6 = d0 + (d1 - d0) * (double) l / (double) numberOfBlocks;
            double d7 = d4 + (d5 - d4) * (double) l / (double) numberOfBlocks;
            double d8 = d2 + (d3 - d2) * (double) l / (double) numberOfBlocks;
            double d9 = random.nextDouble() * (double) numberOfBlocks / 16.0D;
            double d10 = (double) (MathHelper.sin((float) l * (float) Math.PI / (float) numberOfBlocks) + 1.0F) * d9 + 1.0D;
            double d11 = (double) (MathHelper.sin((float) l * (float) Math.PI / (float) numberOfBlocks) + 1.0F) * d9 + 1.0D;
            int i1 = MathHelper.floor_double(d6 - d10 / 2.0D);
            int j1 = MathHelper.floor_double(d7 - d11 / 2.0D);
            int k1 = MathHelper.floor_double(d8 - d10 / 2.0D);
            int l1 = MathHelper.floor_double(d6 + d10 / 2.0D);
            int i2 = MathHelper.floor_double(d7 + d11 / 2.0D);
            int j2 = MathHelper.floor_double(d8 + d10 / 2.0D);

            for (int k2 = i1; k2 <= l1; ++k2) {
                double d12 = ((double) k2 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D) {
                    for (int l2 = j1; l2 <= i2; ++l2) {
                        double d13 = ((double) l2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                double d14 = ((double) i3 + 0.5D - d8) / (d10 / 2.0D);

                                Block block = world.getBlock(k2, l2, i3);
                                int blockMetadata = world.getBlockMetadata(k2, l2, i3);

                                if (block.isReplaceableOreGen(world, k2, l2, i3, Blocks.stone) || block.isReplaceableOreGen(world, k2, l2, i3, Blocks.sandstone) || block.isReplaceableOreGen(world, k2, l2, i3, Blocks.hardened_clay) || block.isReplaceableOreGen(world, k2, l2, i3, Blocks.stained_hardened_clay))
                                    if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) {
                                        Block toGenerate = JCBlockRegistry.fossilOre;
                                        int metadataToGenerate = random.nextInt(6);

                                        if (block == Blocks.hardened_clay) {
                                            toGenerate = JCBlockRegistry.clayFossilOre;
                                            metadataToGenerate = 0;
                                        } else if (block == Blocks.stained_hardened_clay) {
                                            toGenerate = JCBlockRegistry.clayFossilOre;
                                            metadataToGenerate = convertVanillaMetadataToOre(blockMetadata);
                                        } else if (block == Blocks.sandstone || block == Blocks.sand) {
                                            toGenerate = JCBlockRegistry.sandstoneFossilOre;
                                            metadataToGenerate = random.nextInt(6);
                                        }

                                        world.setBlock(k2, l2, i3, toGenerate, metadataToGenerate, 2);
                                    }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    /**
     * Converts metadata from the vanilla Stained Clay to the respective one from the Fossil Clay Ore
     *
     * @param metadata The metadata to convert
     * @return Returns the converted metadata
     */
    private int convertVanillaMetadataToOre(int metadata) {
        switch (metadata) {
            case 0:
                return 5;
            case 1:
                return 2;
            case 4:
                return 6;
            case 8:
                return 4;
            case 12:
                return 1;
            case 14:
                return 3;
            default:
                return 0;
        }
    }
}
