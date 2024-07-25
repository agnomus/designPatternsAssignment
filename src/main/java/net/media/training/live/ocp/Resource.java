package net.media.training.live.ocp;

/**
 * Created by autoopt/mayank.k
 */
public interface Resource {
    public abstract int allocate();
    public abstract void free(int resourceId);

}
