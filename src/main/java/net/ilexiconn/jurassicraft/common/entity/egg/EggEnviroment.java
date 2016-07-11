package net.ilexiconn.jurassicraft.common.entity.egg;

import net.minecraft.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public enum EggEnviroment {
    WET, COLD, WARM, OVERHEAT;

    public static List<EggEnviroment> getEnviroments(Entity egg) {
        List<EggEnviroment> enviroments = new ArrayList<EggEnviroment>();

        boolean warm = egg.worldObj.getBlockLightValue((int) egg.posX, (int) egg.posY, (int) egg.posZ) > 6;
        boolean overheat = egg.worldObj.getBlockLightValue((int) egg.posX, (int) egg.posY, (int) egg.posZ) > 10;

        if (warm)
            enviroments.add(WARM);

        if (overheat)
            enviroments.add(OVERHEAT);

        if (egg.isWet())
            enviroments.add(WET);

        if (!warm)
            enviroments.add(COLD);

        return enviroments;
    }
}
