package net.ilexiconn.jurassicraft.common.entity.ai;

import com.google.common.collect.Lists;
import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.world.World;

import java.util.List;

/**
 * A overwritten version of {@link PathNavigate} that performs validity checks before using a path.
 */
public class JCPathNavigate extends PathNavigate {
    /**
     * If this search range is <code>> 0</code>, then {@link JCPathNavigate#getPathSearchRange()} returns it. Otherwise, the value from {@link PathNavigate} is used.
     */
    private float masterSearchRange;
    private List<IPathValidator> validators;

    public JCPathNavigate(EntityLiving entity, World world) {
        super(entity, world);
        masterSearchRange = -1f;
        validators = Lists.newArrayList();
    }

    /**
     * Sets the master search range. If the given range is <code><= 0</code>, then the value of {@link PathNavigate#getPathSearchRange()} is used.
     *
     * @param range The max value to which to search pathes.
     * @see {@link JCPathNavigate#masterSearchRange}
     */
    public void setMasterSearchRange(float range) {
        this.masterSearchRange = range;
    }

    public float getPathSearchRange() {
        if (masterSearchRange <= 0f) {
            return super.getPathSearchRange();
        }

        return masterSearchRange;
    }

    /**
     * The change from {@link PathNavigate#setPath(PathEntity, double)} is that this Navigator checks if the path is valid (aka. the Entity is able to perform it)
     */
    public boolean setPath(PathEntity path, double speed) {
        if (isValid(path, speed)) {
            return super.setPath(path, speed);
        }

        return false;
    }

    /**
     * The list of validators
     *
     * @return The list of validators used by this Navigator
     * @see {@link IPathValidator}
     */
    public List<IPathValidator> getValidators() {
        return validators;
    }

    /**
     * Adds a new validator used to check the validity of a path
     *
     * @param validator The validator to add to the validators used to check pathes
     * @see {@link IPathValidator}
     */
    public void addValidator(IPathValidator validator) {
        this.validators.add(validator);
    }

    /**
     * Removes the given validator from {@link JCPathNavigate#getValidators()}
     *
     * @param validator The validator to remove
     * @see {@link IPathValidator}
     */
    public void removeValidator(IPathValidator validator) {
        this.validators.remove(validator);
    }

    /**
     * Checks if the given path is valid for this given Navigator
     *
     * @param path The path to follow
     * @param speed The speed at which the path will be executed
     * @return A boolean equal to <code>true</code> if the path is considered valid by all validators.
     * @see {@link IPathValidator#validatePath(PathNavigate, PathEntity, double)}
     */
    public boolean isValid(PathEntity path, double speed) {
        boolean valid = true;

        for (IPathValidator validator : validators) {
            valid = valid && validator.validatePath(this, path, speed);
        }

        return valid;
    }

}
