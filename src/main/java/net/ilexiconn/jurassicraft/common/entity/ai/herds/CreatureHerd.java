package net.ilexiconn.jurassicraft.common.entity.ai.herds;

import com.google.common.collect.Lists;
import net.ilexiconn.jurassicraft.common.entity.EntityJurassiCraftCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CreatureHerd implements Collection<EntityJurassiCraftCreature> {
    private static List<CreatureHerd> herds = Lists.newArrayList();
    private ArrayList<EntityJurassiCraftCreature> creatures;
    private Class<? extends EntityJurassiCraftCreature> herdType;
    private boolean groupAttack;

    public CreatureHerd(boolean attack) {
        creatures = Lists.newArrayList();
        this.groupAttack = attack;
    }

    public static List<CreatureHerd> getHerds() {
        return herds;
    }

    public static void registerHerd(CreatureHerd herd) {
        herds.add(herd);
    }

    public static void removeHerd(CreatureHerd herd) {
        herds.remove(herd);
    }

    /**
     * Adds the entity only if the herd "accepts" it<br/>
     * Acceptance is based on the creatures' types (T-rex herds will only accept T-rexs' friend dinosaurs)
     *
     * @param e The entity to add to the herd
     * @return <code>true</code> if the creature was accepted and added to this herd. <code>false</code> is returned otherwise
     */
    public boolean add(EntityJurassiCraftCreature e) {
        if (isAcceptable(e)) {
            creatures.add(e);
            return true;
        }

        return false;
    }

    public boolean isAcceptable(EntityJurassiCraftCreature e) {
        if (herdType == null) {
            herdType = e.getClass();
            return true;
        }

        if (herdType == e.getClass()) // FIXME: We will need something else than per-class herds
            return creatures.size() < 7 && !contains(e);

        return false;
    }

    /**
     * Adds a collection of entities into this herd if possible
     *
     * @param c The collection of creatures to add to this herd
     * @return <code>true</code> if all creatures were added to this herd
     */
    public boolean addAll(Collection<? extends EntityJurassiCraftCreature> c) {
        boolean added = true;

        for (EntityJurassiCraftCreature creature : c)
            added = added && add(creature);

        return added;
    }

    public void clear() {
        creatures.clear();
    }

    public boolean contains(Object o) {
        return creatures.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return creatures.containsAll(c);
    }

    public boolean isEmpty() {
        return creatures.isEmpty();
    }

    public Iterator<EntityJurassiCraftCreature> iterator() {
        return creatures.iterator();
    }

    public boolean remove(Object o) {
        // TODO Notify herd maybe?
        if (creatures.size() - 1 == 0)
            herds.remove(this);

        return creatures.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        // TODO Notify herd ?

        if (creatures.size() - c.size() <= 0)
            herds.remove(this);

        return creatures.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        // TODO Notify herd
        return creatures.retainAll(c);
    }

    public int size() {
        return creatures.size();
    }

    public Object[] toArray() {
        return creatures.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return creatures.toArray(a);
    }

    public Vec3 computeCenter() {
        double x = 0f;
        double y = 0f;
        double z = 0f;

        for (EntityJurassiCraftCreature creature : creatures) {
            x += creature.posX;
            y += creature.posY;
            z += creature.posZ;
        }

        x /= creatures.size();
        y /= creatures.size();
        z /= creatures.size();

        return Vec3.createVectorHelper(x, y, z);
    }

    public Vec3 getPosition(EntityJurassiCraftCreature creature, float f) {
        if (f == 1.0F) {
            return Vec3.createVectorHelper(creature.posX, creature.posY, creature.posZ);
        } else {
            double x = creature.prevPosX + (creature.posX - creature.prevPosX) * (double) f;
            double y = creature.prevPosY + (creature.posY - creature.prevPosY) * (double) f;
            double z = creature.prevPosZ + (creature.posZ - creature.prevPosZ) * (double) f;

            return Vec3.createVectorHelper(x, y, z);
        }
    }

    public double getDistanceFrom(EntityJurassiCraftCreature creature) {
        Vec3 center = computeCenter();

        return getPosition(creature, 1f).distanceTo(center);
    }

    public boolean groupAttack() {
        return groupAttack;
    }

    public CreatureHerd groupAttack(boolean attack) {
        groupAttack = attack;
        return this;
    }

    public void attack(EntityLivingBase target) {
        if (!groupAttack)
            return;

        for (EntityJurassiCraftCreature creature : creatures) // Check if an owner is target
        {
            if (creature instanceof IEntityOwnable) {
                IEntityOwnable ownable = (IEntityOwnable) creature;

                if (ownable.getOwner() == target)
                    return; // We're attacking the owner, abort!
            }
        }

        for (EntityJurassiCraftCreature creature : creatures)
            creature.setAttackTarget(target);
    }

    public int indexOf(EntityJurassiCraftCreature creature) {
        return creatures.indexOf(creature);
    }
}
