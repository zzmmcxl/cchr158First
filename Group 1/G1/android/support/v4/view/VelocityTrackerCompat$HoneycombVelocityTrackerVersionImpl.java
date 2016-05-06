package android.support.v4.view;

import android.view.VelocityTracker;

static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl
{
    HoneycombVelocityTrackerVersionImpl() {
        super();
    }
    
    @Override
    public float getXVelocity(final VelocityTracker velocityTracker, final int n) {
        return VelocityTrackerCompatHoneycomb.getXVelocity(velocityTracker, n);
    }
    
    @Override
    public float getYVelocity(final VelocityTracker velocityTracker, final int n) {
        return VelocityTrackerCompatHoneycomb.getYVelocity(velocityTracker, n);
    }
}
