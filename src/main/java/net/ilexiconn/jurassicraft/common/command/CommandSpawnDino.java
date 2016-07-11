package net.ilexiconn.jurassicraft.common.command;

import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class CommandSpawnDino extends CommandBase {
    public String getCommandName() {
        return "spawndino";
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    public String getCommandUsage(ICommandSender sender) {
        return "commands.spawndino.usage";
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            String dinoName = args[0];
            spawnCreature(sender.getEntityWorld(), sender.getPlayerCoordinates().posX, sender.getPlayerCoordinates().posY, sender.getPlayerCoordinates().posZ, dinoName, true);
        } else if (args.length == 4) {
            String dinoName = args[0];
            int x = args[1].equals("~") ? sender.getPlayerCoordinates().posX : parseInt(sender, args[1]);
            int y = args[2].equals("~") ? sender.getPlayerCoordinates().posY : parseInt(sender, args[2]);
            int z = args[3].equals("~") ? sender.getPlayerCoordinates().posZ : parseInt(sender, args[3]);

            spawnCreature(sender.getEntityWorld(), x, y, z, dinoName, true);
        } else if (args.length == 5) {
            String dinoName = args[0];
            int x = args[1].equals("~") ? sender.getPlayerCoordinates().posX : parseInt(sender, args[1]);
            int y = args[2].equals("~") ? sender.getPlayerCoordinates().posY : parseInt(sender, args[2]);
            int z = args[3].equals("~") ? sender.getPlayerCoordinates().posZ : parseInt(sender, args[3]);

            boolean isAdult = Boolean.parseBoolean(args[4]);
            spawnCreature(sender.getEntityWorld(), x, y, z, dinoName, isAdult);
        } else {
            throw new WrongUsageException("commands.spawndino.usage");
        }
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, CreatureHandler.getCreatureNames()) : (args.length == 5 ? getListOfStringsMatchingLastWord(args, "true", "false") : null);
    }

    public void spawnCreature(World world, int x, int y, int z, String name, boolean adult) {
        Class creatureClass = CreatureHandler.getCreatureFromName(name).getCreatureClass();
        try {
            Entity creatureToSpawn = (Entity) creatureClass.getConstructor(World.class).newInstance(world);

            if (creatureToSpawn instanceof EntityJurassiCraftCreature) {
                EntityJurassiCraftCreature creature = (EntityJurassiCraftCreature) creatureToSpawn;
                creature.setGenetics(100, JurassiCraftDNAHandler.createDefaultDNA());
                creature.setPosition(x, y, z);
                creature.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                creature.rotationYawHead = creature.rotationYaw;
                creature.renderYawOffset = creature.rotationYaw;

                if (adult)
                    creature.setFullGrowth();

                world.spawnEntityInWorld(creature);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
