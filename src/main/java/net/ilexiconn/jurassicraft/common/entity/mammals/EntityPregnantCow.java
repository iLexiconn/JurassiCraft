package net.ilexiconn.jurassicraft.common.entity.mammals;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EntityPregnantCow implements IExtendedEntityProperties {
    public final static String PREGNANT_COW_PROPERTY = "EntityPregnantCowJC";
    private String dnaSequence;
    private String mammalName;
    private int pregnancyProgress;
    private int pregnancySpeed;
    private int dnaQuality;

    public EntityPregnantCow() {
        this.mammalName = "noEmbryo";
        this.dnaQuality = 0;
        this.dnaSequence = "";
        this.pregnancySpeed = 0;
    }

    public static final void register(EntityCow entity) {
        entity.registerExtendedProperties(EntityPregnantCow.PREGNANT_COW_PROPERTY, new EntityPregnantCow());
    }

    public static final EntityPregnantCow get(EntityCow entity) {
        return (EntityPregnantCow) entity.getExtendedProperties(EntityPregnantCow.PREGNANT_COW_PROPERTY);
    }

    public void init(Entity entity, World world) {
    }

    public String getDNASequence() {
        return dnaSequence;
    }

    public void setDNASequence(String dna) {
        this.dnaSequence = dna;
    }

    public String getMammalName() {
        return mammalName;
    }

    public void setMammalName(String mammal) {
        this.mammalName = mammal;
    }

    public int getPregnancyProgress() {
        return pregnancyProgress;
    }

    public void setPregnancyProgress(int progress) {
        this.pregnancyProgress = progress;
    }

    public void increasePregnancyProgress() {
        this.pregnancyProgress = this.getPregnancyProgress() + 1;
    }

    public int getPregnancySpeed() {
        return pregnancySpeed;
    }

    public void setPregnancySpeed(int speed) {
        this.pregnancySpeed = speed;
    }

    public int getDNAQuality() {
        return dnaQuality;
    }

    public void setDNAQuality(int quality) {
        this.dnaQuality = quality;
    }

    public int getPregnancyProgressScaled(int barSize) {
        if (this.getPregnancySpeed() <= 0)
            this.setPregnancySpeed(2048);

        return (this.getPregnancyProgress() * barSize) / this.getPregnancySpeed();
    }

    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();

        properties.setString("DNASequence", this.dnaSequence);
        properties.setString("MammalName", this.mammalName);
        properties.setInteger("PregnancyProgress", this.pregnancyProgress);
        properties.setInteger("PregnancySpeed", this.pregnancySpeed);
        properties.setInteger("DNAQuality", this.dnaQuality);

        compound.setTag(EntityPregnantCow.PREGNANT_COW_PROPERTY, properties);
    }

    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(EntityPregnantCow.PREGNANT_COW_PROPERTY);

        if (properties != null) {
            if (properties.hasKey("DNASequence"))
                this.dnaSequence = properties.getString("DNASequence");
            if (properties.hasKey("MammalName"))
                this.mammalName = properties.getString("MammalName");
            if (properties.hasKey("PregnancyProgress"))
                this.pregnancyProgress = properties.getInteger("PregnancyProgress");
            if (properties.hasKey("PregnancySpeed"))
                this.pregnancySpeed = properties.getInteger("PregnancySpeed");
            if (properties.hasKey("DNAQuality"))
                this.dnaQuality = properties.getInteger("DNAQuality");
        }
    }
}