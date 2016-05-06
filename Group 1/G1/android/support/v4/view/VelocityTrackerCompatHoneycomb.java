package android.support.v4.view;

import android.view.VelocityTracker;

class VelocityTrackerCompatHoneycomb
{
    VelocityTrackerCompatHoneycomb() {
        super();
    }
    
    public static float getXVelocity(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getXVelocity(n);
    }
    
    public static float getYVelocity(final VelocityTracker velocityTracker, final int n) {
        return velocityTracker.getYVelocity(n);
    }
}
