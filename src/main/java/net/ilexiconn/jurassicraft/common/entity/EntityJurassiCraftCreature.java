package net.ilexiconn.jurassicraft.common.entity;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.jurassicraft.common.api.IAnimatedEntity;
import net.ilexiconn.jurassicraft.common.handler.CreatureHandler;
import net.ilexiconn.jurassicraft.common.handler.JurassiCraftDNAHandler;
import net.ilexiconn.jurassicraft.common.item.ItemGrowthSerum;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.HashSet;

public class EntityJurassiCraftCreature extends EntityCreature implements IEntityAdditionalSpawnData, IAnimatedEntity {
    private Creature creature;

    protected final HashSet<Integer> growthStageList = new HashSet<Integer>();

    public int frame;
    public int expParameter;

    protected float geneticQuality;
    protected boolean gender;
    protected byte texture;

    protected int animID;
    protected int animTick;

    private float heightParameter, lengthParameter;

    private float bBoxXZ, bBoxY;

    public EntityJurassiCraftCreature(World world) {
        super(world);

        this.setCreature(CreatureHandler.classToCreature(getClass()));

        if (this.getGeneticQuality() < 0.6F || this.getGeneticQuality() >= 1.4F) {
            this.setRandomGenetics();
        }

        this.resetGrowthStageList();
        this.setCreatureGender(JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()) == 0.5F ? this.rand.nextBoolean() : (JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()) > 0.5F));
        this.setNewCreatureTexture(JurassiCraftDNAHandler.getDefaultTextureDNAQuality(this.getDNASequence()));
        this.updateCreatureData(this.getTotalTicksLived());

        this.animTick = 0;
        this.animID = 0;
    }

    /**
     * Checks if this entity is inside of an opaque block
     */
    public boolean isEntityInsideOpaqueBlock() {
        for (int i = 0; i < 8; ++i) {
            float f = ((float) ((i >> 0) % 2) - 0.5F) * this.width * 0.8F;
            float f1 = ((float) ((i >> 1) % 2) - 0.5F) * 0.1F;
            float f2 = ((float) ((i >> 2) % 2) - 0.5F) * this.width * 0.8F;
            int j = MathHelper.floor_double(this.posX + (double) f);
            int k = MathHelper.floor_double(this.posY + (double) this.height + (double) f1);
            int l = MathHelper.floor_double(this.posZ + (double) f2);

            if (this.worldObj.getBlock(j, k, l).isNormalCube()) {
                return true;
            }
        }

        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(12, 0.0F);
        this.dataWatcher.addObject(13, Byte.valueOf((byte) (0)));
        this.dataWatcher.addObject(14, String.valueOf(""));
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected boolean canDespawn() {
        return false;
    }

    /**
     * Returns the creature.
     */
    public Creature getCreature() {
        return this.creature;
    }

    /**
     * Sets the creature.
     */
    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    /**
     * Returns the creature genetic quality.
     */
    public float getGeneticQuality() {
        return this.geneticQuality;
    }

    /**
     * Sets the creature genetic quality. Genetic quality is how much the creature varies in status. 1.0F is the base value.
     */
    private void setGeneticQuality(float quality) {
        this.geneticQuality = quality;
    }

    /**
     * Returns the creature DNA sequence.
     */
    public String getDNASequence() {
        return this.dataWatcher.getWatchableObjectString(14);
    }

    /**
     * Sets the creature DNA sequence.
     */
    public void setDNASequence(String dna) {
        this.dataWatcher.updateObject(14, String.valueOf(dna));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.animID != 0)
            this.animTick++;

        this.frame++;
    }

    public void onLivingUpdate() {
        if (this.getTotalTicksLived() <= this.getCreature().getTicksToAdulthood() && this.growthStageList.contains(this.getTotalTicksLived())) {
            if (this.getGrowthStage() < 120)
                this.setGrowthStage((byte) (this.getGrowthStage() + 1));

            if (this.getCreature() != null)
                this.updateCreatureData(this.getTotalTicksLived());
        }

        if (getAttackTarget() != null && getAttackTarget().ridingEntity != null)
            setAttackTarget(null);

        super.onLivingUpdate();
    }

    public boolean interact(EntityPlayer player) {
        /** DEBUG INFO */
        // this.showDebugInfo(player);

        if (player != null && player.getHeldItem() != null) {
            if (player.getHeldItem().getItem() instanceof ItemGrowthSerum) {
                if (this.forceCreatureGrowth(player, (byte) 10) && !player.capabilities.isCreativeMode) {
                    player.getHeldItem().stackSize--;
                }
            }
        }

        return super.interact(player);
    }

    public void showDebugInfo(EntityPlayer player) {
        System.out.println("");
        System.out.println("=============== UPDATE DATA ===============");

        if (this.worldObj.isRemote) {
            System.out.println("================= Client ==================");

            if (player != null && player.getHeldItem() != null)
                System.out.println("Held item = " + player.getHeldItem().getUnlocalizedName());
            if (this instanceof EntityJurassiCraftSmart)
                System.out.println("Owner: " + ((EntityJurassiCraftSmart) this).getOwnerName() + ", isTamed: " + ((EntityJurassiCraftSmart) this).isTamed());

            System.out.println("Health: " + this.getCreatureHealth());
            System.out.println("Attack: " + this.getCreatureAttack());
            System.out.println("Speed: " + this.getCreatureSpeed());
            System.out.println("Knockback: " + this.getCreatureKnockback());
            System.out.println("Length: " + this.getCreatureLength());
            System.out.println("Height: " + this.getCreatureHeight());
            System.out.println("Scale: " + this.getCreatureScale());
            System.out.println("Genetic Quality: " + this.getGeneticQuality() + ", DNASequence: " + this.getDNASequence() + ". Revised DNA for 50% " + JurassiCraftDNAHandler.reviseDNA(this.getDNASequence(), 50));
            System.out.println("Gender: " + this.getCreatureGenderString() + ". Genetic for gender: " + JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()));
            System.out.println("Texture number: " + this.getCreatureTexture() + ". Genetic for texture: " + JurassiCraftDNAHandler.getDefaultTextureDNAQuality(this.getDNASequence()));
            System.out.println("Adult: " + this.isCreatureAdult());
            System.out.println("===========================================");
        } else {
            System.out.println("================= Server ==================");
            if (player != null && player.getHeldItem() != null)
                System.out.println("Held item = " + player.getHeldItem().getUnlocalizedName());
            if (this instanceof EntityJurassiCraftSmart)
                System.out.println("Owner: " + ((EntityJurassiCraftSmart) this).getOwnerName() + ", isTamed: " + ((EntityJurassiCraftSmart) this).isTamed());

            System.out.println("Health: " + this.getCreatureHealth());
            System.out.println("Attack: " + this.getCreatureAttack());
            System.out.println("Speed: " + this.getCreatureSpeed());
            System.out.println("Knockback: " + this.getCreatureKnockback());
            System.out.println("Length: " + this.getCreatureLength());
            System.out.println("Height: " + this.getCreatureHeight());
            System.out.println("Scale: " + this.getCreatureScale());
            System.out.println("Genetic Quality: " + this.getGeneticQuality() + ", DNASequence: " + this.getDNASequence() + ". Revised DNA for 50% " + JurassiCraftDNAHandler.reviseDNA(this.getDNASequence(), 50));
            System.out.println("Gender: " + this.getCreatureGenderString() + ". Genetic for gender: " + JurassiCraftDNAHandler.getDefaultGenderDNAQuality(this.getDNASequence()));
            System.out.println("Texture number: " + this.getCreatureTexture() + ". Genetic for texture: " + JurassiCraftDNAHandler.getDefaultTextureDNAQuality(this.getDNASequence()));
            System.out.println("Adult: " + this.isCreatureAdult());
            System.out.println("===========================================");
            System.out.println("");
        }
    }

    /**
     * Updates the creature status.
     */
    protected void updateCreatureData(int ticks) {
        if (ticks > 0) {
            double ticksToAdulthood = this.getCreature().getTicksToAdulthood();
            double minHealth = this.getCreature().getMinHealth();
            double minStrength = this.getCreature().getMinStrength();
            double minSpeed = this.getCreature().getMinSpeed();
            double minKnockback = this.getCreature().getMinKnockback();

            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((int) (this.getGeneticQuality() * (ticks * this.getCreature().getMaxHealth() - minHealth) / ticksToAdulthood + minHealth));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((float) (this.getGeneticQuality() * (ticks * (this.getCreature().getMaxStrength() - minStrength) / ticksToAdulthood + minStrength)));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((float) (ticks * (this.getCreature().getMaxSpeed() - minSpeed) / ticksToAdulthood + minSpeed));
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue((float) (this.getGeneticQuality() * (ticks * (this.getCreature().getMaxKnockback() - minKnockback) / ticksToAdulthood + minKnockback)));
            this.setBoundingBox((float) (this.getGeneticQuality() * (this.getCreature().getXzBoxMin() + this.getCreature().getXzBoxDelta() * (((float) this.getGrowthStage()) / 120))), (float) (this.getGeneticQuality() * (this.getCreature().getYBoxMin() + this.getCreature().getYBoxDelta() * (((float) this.getGrowthStage()) / 120))));
            this.setCreatureLength();
            this.setCreatureHeight();
            this.setCreatureSize(this.getXZBoundingBox(), this.getYBouningBox());
            this.setCreatureScale();

            this.heal((float) (this.getCreatureHealth() - this.prevHealth));
        }
    }

    /**
     * Resets the growthStageList. This is a list of values (number of ticks) that represent when the creature updates its status.
     */
    private void resetGrowthStageList() {
        int ticks = (int) this.getCreature().getTicksToAdulthood();

        this.growthStageList.add(1);

        for (byte i = 1; i < (byte) 120; i++) {
            this.growthStageList.add((ticks * i) / (byte) 120);
        }

        this.growthStageList.add(ticks);
    }

    /**
     * Returns the current growth stage of the creature. In order words, how many times this creature has updated.
     */
    public byte getGrowthStage() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    /**
     * Sets what is the growth stage of the creature.
     */
    private void setGrowthStage(byte stage) {
        this.dataWatcher.updateObject(13, Byte.valueOf(stage));
    }

    /**
     * Sets the creature xz and y hit box using genetic quality and growth stage.
     */
    public void setBoundingBox(float xz, float y) {
        this.bBoxXZ = xz;
        this.bBoxY = y;
    }

    /**
     * Sets a new bounding box for the creature depending on its status.
     */
    protected final void setCreatureSize(float xzBoundingBox, float yBouningBox) {
        super.setSize(xzBoundingBox, yBouningBox);
    }

    /**
     * Returns the scale of the this.creature.
     */
    public float getCreatureScale() {
        return this.dataWatcher.getWatchableObjectFloat(12) * this.getCreature().getScaleAdjustment();
    }

    /**
     * Sets the scale of the this.creature depending on the age and genetic quality.
     */
    private void setCreatureScale(float scale) {
        if (scale > 0.0F) {
            this.dataWatcher.updateObject(12, Float.valueOf(scale));
        } else {
            this.dataWatcher.updateObject(12, 0.0F);
        }
    }

    /**
     * Sets the scale of the this.creature depending on the age and genetic quality.
     */
    private void setCreatureScale() {
        if (this.getTotalTicksLived() < this.getCreature().getTicksToAdulthood()) {
            float maxHeight = this.getCreature().getMaxHeight();
            float minHeight = this.getCreature().getMinHeight();
            float maxLength = this.getCreature().getMaxLength();
            float minLength = this.getCreature().getMinLength();

            this.dataWatcher.updateObject(12, Float.valueOf(this.getGeneticQuality() * (((minLength + minHeight) / 2) + (((maxHeight + maxLength) / 2) - ((minHeight + minLength) / 2)) * (((float) this.getTotalTicksLived()) / ((float) this.getCreature().getTicksToAdulthood()))) / ((maxHeight + maxLength) / 2)));
        } else {
            this.dataWatcher.updateObject(12, Float.valueOf(this.getGeneticQuality()));
        }
    }

    /**
     * Returns how many ticks this entity has lived.
     */
    public int getTotalTicksLived() {
        return this.ticksExisted;
    }

    /**
     * Resets the ticks that this entity has lived (Client only).
     */
    private void setTicksExisted(int ticks) {
        this.ticksExisted = ticks;
    }

    /**
     * Force the creature to grow a specific value if it is possible.
     */
    public boolean forceCreatureGrowth(EntityPlayer player, byte growthIncrease) {
        if (this.getGrowthStage() + growthIncrease <= 120) {
            this.setGrowthStage((byte) (this.getGrowthStage() + growthIncrease));
            this.setTicksExisted((int) (this.getCreature().getTicksToAdulthood() * this.getGrowthStage() / 120));

            if (this.getCreature() != null)
                this.updateCreatureData(this.getTotalTicksLived());

            return true;
        } else {
            if (player != null && player.worldObj.isRemote) {
                if (this.hasCustomNameTag())
                    player.addChatMessage(new ChatComponentText(this.getCustomNameTag() + " (" + StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + ") " + StatCollector.translateToLocal("entity.interaction.fullGrown")));
                else
                    player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("entity." + this.getCreature().getCreatureName() + ".name") + " " + StatCollector.translateToLocal("entity.interaction.fullGrown")));
            }

            return false;
        }
    }

    /**
     * Force the creature to grow to its maximum size.
     */
    public void setFullGrowth() {
        if (!this.isCreatureAdult()) {
            this.setGrowthStage((byte) (120));
            this.setTicksExisted((int) (this.getCreature().getTicksToAdulthood() * this.getGrowthStage() / 120));

            if (this.getCreature() != null)
                this.updateCreatureData(this.getTotalTicksLived());
        }
    }

    /**
     * Force the creature to grow to its minimum size.
     */
    public void setNoGrowth() {
        if (this.getGrowthStage() != 0) {
            this.setGrowthStage((byte) (0));
            this.setTicksExisted(0);

            if (this.getCreature() != null)
                this.updateCreatureData(this.getTotalTicksLived());
        }
    }

    /**
     * Returns the creature Name.
     */
    public String getCreatureName() {
        return this.getCreature().getCreatureName();
    }

    /**
     * Checks if the creature has a genetic code.
     */
    public boolean hasDNASequence() {
        return !(this.getDNASequence() == null || this.getDNASequence() == "");
    }

    /**
     * Sets the creature genetic data depending on the dna quality and code.
     */
    public void setGenetics(int dnaQuality, String dna) {
        this.setDNASequence(JurassiCraftDNAHandler.reviseDNA(dna, dnaQuality));
        this.setGeneticQuality(JurassiCraftDNAHandler.getDefaultGeneticDNAQuality(dna));
    }

    /**
     * Sets the creature genetic data randomly.
     */
    public void setRandomGenetics() {
        String dna = JurassiCraftDNAHandler.createDefaultDNA();

        this.setGeneticQuality(JurassiCraftDNAHandler.getDefaultGeneticDNAQuality(dna));
        this.setDNASequence(dna);
    }

    /**
     * Returns how many ticks this creature requires to reach adulthood.
     */
    public float getAdultAge() {
        return (float) this.getCreature().getTicksToAdulthood();
    }

    /**
     * Returns true if the creature is considered an adult.
     */
    public boolean isCreatureAdult() {
        return this.getTotalTicksLived() >= this.getCreature().getAdultAge() * this.getAdultAge();
    }

    /**
     * Returns true if the creature is older than a certain percentage of the ticks for adulthood.
     */
    public boolean isCreatureOlderThan(float percentage) {
        return this.getTotalTicksLived() >= percentage * this.getCreature().getTicksToAdulthood();
    }

    /**
     * Returns the creature hit box.
     */
    public float getXZBoundingBox() {
        return this.bBoxXZ;
    }

    /**
     * Returns the creature hit box.
     */
    public float getYBouningBox() {
        return this.bBoxY;
    }

    /**
     * Returns the current health of the creature. This is just a information for the user.
     */
    public double getCreatureCurrentHealth() {
        return (double) ((int) (100 * this.getHealth())) / 100;
    }

    /**
     * Returns the health of the creature. This is just a information for the user.
     */
    public double getCreatureHealth() {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue())) / 100;
    }

    public int getCreatureHealthScaled(int i) {
        return (int) ((this.getCreatureHealth() * i) / (1.2F * this.getCreature().getMaxHealth()));
    }

    /**
     * Returns the speed of the creature. This is just a information for the user.
     */
    public double getCreatureAttack() {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue())) / 100;
    }

    public int getCreatureAttackScaled(int i) {
        return (int) ((this.getCreatureAttack() * i) / (1.2F * this.getCreature().getMaxStrength()));
    }

    /**
     * Returns the speed of the creature. This is just a information for the user.
     */
    public double getCreatureSpeed() {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue())) / 100;
    }

    public int getCreatureSpeedScaled(int i) {
        return (int) ((this.getCreatureSpeed() * i) / (1.2F * this.getCreature().getMaxSpeed()));
    }

    /**
     * Returns the speed of the creature. This is just a information for the user.
     */
    public double getCreatureKnockback() {
        return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue())) / 100;
    }

    /**
     * Returns the knock back of the creature. This is just a information for the user.
     */
    public int getCreatureKnockbackScaled(int i) {
        return (int) ((this.getCreatureKnockback() * i) / (1.2F * this.getCreature().getMaxKnockback()));
    }

    /**
     * Returns the length of the creature. This is just a information for the user.
     */
    public float getCreatureLength() {
        return (float) ((int) (100 * this.lengthParameter)) / 100;
    }

    public int getCreatureLengthScaled(int i) {
        return (int) ((this.getCreatureLength() * i) / (1.2F * this.getCreature().getMaxLength()));
    }

    /**
     * Returns the height of the creature. This is just a information for the user.
     */
    public float getCreatureHeight() {
        return ((float) ((int) (this.heightParameter * 100) / 100)) - 0.25F;
    }

    public int getCreatureHeightScaled(int i) {
        return (int) ((this.getCreatureHeight() * i) / (1.2F * this.getCreature().getMaxHeight()));
    }

    /**
     * Returns true if the creature is a male.
     */
    public boolean isMale() {
        return this.getCreatureGender();
    }

    /**
     * Returns the creature gender as String.
     */
    public String getCreatureGenderString() {
        return this.getCreatureGender() ? "Male" : "Female";
    }

    /**
     * Returns the creature gender. False is female and true is male.
     */
    public boolean getCreatureGender() {
        return this.gender;
    }

    /**
     * Sets the creature gender. 0 is female and 1 is male.
     */
    public void setCreatureGender(boolean sex) {
        this.gender = sex;
    }

    /**
     * Sets the creature texture based on the genetics.
     */
    private void setNewCreatureTexture(float textureFromGenetics) {
        int textureCount = this.getCreature().getTextureCount();

        if (textureCount > 0) {
            float texturesInterval = 0.8F / textureCount;

            for (int i = 1; i <= textureCount; i++) {
                if (textureFromGenetics <= 0.2F + texturesInterval * i) {
                    this.texture = (byte) (i - 1);
                    return;
                }
            }
        }

        this.texture = (byte) 0;
    }

    /**
     * Sets the creature texture.
     */
    public byte getCreatureTexture() {
        return this.texture;
    }

    /**
     * Sets the creature texture.
     */
    private void setCreatureTexture(byte texture) {
        this.texture = texture;
    }

    /**
     * Sets the length of the creature. This is just a information for the user.
     */
    public void setCreatureLength() {
        if (this.getTotalTicksLived() <= this.getCreature().getTicksToAdulthood())
            this.lengthParameter = (float) (this.getGeneticQuality() * (this.getCreature().getMinLength() + (this.getTotalTicksLived() * (this.getCreature().getMaxLength() - this.getCreature().getMinLength()) / this.getCreature().getTicksToAdulthood())));
        else
            this.lengthParameter = this.getGeneticQuality() * (this.getCreature().getMaxLength());
    }

    /**
     * Sets the height of the creature. This is just a information for the user.
     */
    public void setCreatureHeight() {
        if (this.getTotalTicksLived() <= this.getCreature().getTicksToAdulthood())
            this.heightParameter = (float) (this.getGeneticQuality() * (this.getCreature().getMinHeight() + (this.getTotalTicksLived() * (this.getCreature().getMaxHeight() - this.getCreature().getMinHeight()) / this.getCreature().getTicksToAdulthood())));
        else
            this.heightParameter = this.getGeneticQuality() * (this.getCreature().getMaxHeight());
    }

    /**
     * Returns how many days this entity has lived.
     */
    public int getCreatureAgeInDays() {
        return this.getTotalTicksLived() / 24000;
    }

    /**
     * Returns how many months this entity has lived.
     */
    public int getCreatureAgeInMonths() {
        return this.getTotalTicksLived() / (720000);
    }

    /**
     * Returns how many years this entity has lived.
     */
    public int getCreatureAgeInYears() {
        return this.getTotalTicksLived() / (8640000);
    }

    /**
     * Returns how many days, and/or months, and/or years this entity has lived. Note: returns string value.
     */
    public String getCreatureAgeString() {
        byte years = (byte) getCreatureAgeInYears();
        byte months = (byte) (getCreatureAgeInMonths() - 12 * this.getCreatureAgeInYears());
        byte days = (byte) (getCreatureAgeInDays() - 30 * this.getCreatureAgeInMonths());

        String yearString = StatCollector.translateToLocal("container.pad.years");
        String monthString = StatCollector.translateToLocal("container.pad.months");
        String dayString = StatCollector.translateToLocal("container.pad.days");

        if (years <= 1)
            yearString = StatCollector.translateToLocal("container.pad.year");

        if (months <= 1)
            monthString = StatCollector.translateToLocal("container.pad.month");

        if (days <= 1)
            dayString = StatCollector.translateToLocal("container.pad.day");

        if (years <= 0) {
            if (months <= 0)
                return (String.valueOf(days) + " " + dayString);
            else
                return (String.valueOf(months) + " " + monthString + String.valueOf(days) + " " + dayString);
        } else {
            if (months <= 0)
                return (String.valueOf(years) + " " + yearString + String.valueOf(days) + " " + dayString);
            else
                return (String.valueOf(years) + " " + yearString + String.valueOf(months) + " " + monthString + String.valueOf(days) + " " + dayString);
        }
    }

    public float getEyeHeight() {
        return this.getCreatureHeight() * 0.85F;
    }

    public int getTalkInterval() {
        return 200;
    }

    protected float getSoundPitch() {
        return Float.valueOf(1.0F + 0.8F * (120 - this.getGrowthStage()) / 120);
    }

    protected float getSoundVolume() {
        return Float.valueOf(0.7F + 0.3F * this.getGrowthStage() / 120);
    }

    public int getCreatureExperiencePoints() {
        return this.expParameter;
    }

    public void setCreatureExperiencePoints(int points) {
        this.expParameter = points;
    }

    protected int getExperiencePoints(EntityPlayer player) {
        return (int) (this.getCreatureExperiencePoints() * this.getGeneticQuality() * this.getGrowthStage() / 120);
    }

    public boolean isWaterCreature() {
        return this.getCreature().isWaterCreature();
    }

    public boolean isFlyingCreature() {
        return this.getCreature().isFlyingCreature();
    }

    public int getAnimationId() {
        return this.animID;
    }

    public void setAnimationId(int id) {
        this.animID = id;
    }

    public int getAnimationTick() {
        return this.animTick;
    }

    public void setAnimationTick(int tick) {
        this.animTick = tick;
    }

    public String getLivingSound() {
        this.playSound("jurassicraft:" + this.getCreatureName().toLowerCase() + ":living", this.getSoundVolume(), this.getSoundPitch());

        return null;
    }

    public String getHurtSound() {
        this.playSound("jurassicraft:" + this.getCreatureName().toLowerCase() + ":hurt", this.getSoundVolume(), this.getSoundPitch());

        return null;
    }

    public String getDeathSound() {
        this.playSound("jurassicraft:" + this.getCreatureName().toLowerCase() + ":death", this.getSoundVolume(), this.getSoundPitch());

        return null;
    }

    protected EntityItem dropItemStackWithGenetics(ItemStack stack) {
        if (stack.getItem() != null) {
            NBTTagCompound compound = new NBTTagCompound();

            if (this.hasDNASequence())
                compound.setString("DNA", this.getDNASequence());
            else
                compound.setString("DNA", JurassiCraftDNAHandler.createDefaultDNA());

            compound.setInteger("Quality", 100);
            stack.setTagCompound(compound);
        }

        return this.entityDropItem(stack, 0.0F);
    }

    protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) {
        if (!this.isBurning())
            this.dropItemStackWithGenetics(new ItemStack(this.getCreature().getMeat(), 1));
        else
            this.dropItem(this.getCreature().getSteak(), 1);
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setByte("ID", this.getCreature().getCreatureID());
        compound.setInteger("TicksExisted", this.getTotalTicksLived());
        compound.setByte("GrowthStage", this.getGrowthStage());
        compound.setString("DNASequence", this.getDNASequence());
        compound.setFloat("GeneticQuality", this.getGeneticQuality());
        compound.setBoolean("Gender", this.getCreatureGender());
        compound.setByte("Texture", this.getCreatureTexture());
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        this.setCreature(CreatureHandler.getCreatureFromId(compound.getByte("ID")));
        this.setTicksExisted(compound.getInteger("TicksExisted"));
        this.setGrowthStage(compound.getByte("GrowthStage"));
        this.setDNASequence(compound.getString("DNASequence"));
        this.setGeneticQuality(compound.getFloat("GeneticQuality"));
        this.setCreatureGender(compound.getBoolean("Gender"));
        this.setCreatureTexture(compound.getByte("Texture"));
        this.resetGrowthStageList();
        this.updateCreatureData(this.getTotalTicksLived());
    }

    public void writeSpawnData(ByteBuf buf) {
        buf.writeByte(this.getCreature().getCreatureID());
        buf.writeInt(this.getTotalTicksLived());
        buf.writeByte(this.getGrowthStage());
        buf.writeFloat(this.getGeneticQuality());
        buf.writeBoolean(this.getCreatureGender());
        buf.writeByte(this.getCreatureTexture());
    }

    public void readSpawnData(ByteBuf buf) {
        try {
            this.setCreature(CreatureHandler.getCreatureFromId(buf.readByte()));
            this.setTicksExisted(buf.readInt());
            this.setGrowthStage(buf.readByte());
            this.setGeneticQuality(buf.readFloat());
            this.setCreatureGender(buf.readBoolean());
            this.setCreatureTexture(buf.readByte());
            this.resetGrowthStageList();
            this.updateCreatureData(this.getTotalTicksLived());
        } catch (Exception e) {
            System.err.println("Error while reading dino spawn data!");

            e.printStackTrace();
        }
    }
}
