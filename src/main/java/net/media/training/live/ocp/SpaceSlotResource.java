package net.media.training.live.ocp;

/**
 * Created by autoopt/mayank.k
 */

public class SpaceSlotResource implements Resource{

    private ResourceType resourceType;

    @Override
    public int allocate() {
        int resourceId = findFreeSpaceSlot();
        markSpaceSlotBusy(resourceId);
        return resourceId;
    }

    @Override
    public void free(int resourceId) {
        markSpaceSlotFree(resourceId);
    }

    protected void markSpaceSlotFree(int resourceId) {
    }

    protected void markSpaceSlotBusy(int resourceId) {
    }

    protected int findFreeSpaceSlot() {
        return 0;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
}
