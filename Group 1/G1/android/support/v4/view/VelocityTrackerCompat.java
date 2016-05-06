package android.support.v4.view;

import android.view.VelocityTracker;
import android.os.Build$VERSION;

public final class VelocityTrackerCompat
{
    static final VelocityTrackerVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (VelocityTrackerVersionImpl)new HoneycombVelocityTrackerVersionImpl();
            return;
        }
        IMPL = (VelocityTrackerVersionImpl)new BaseVelocityTrackerVersionImpl();
    }
    
    private VelocityTrackerCompat() {
        super();
    }
    
    public static float getXVelocity(final VelocityTracker velocityTracker, final int n) {
        return IMPL.getXVelocity(velocityTracker, n);
    }
    
    public static float getYVelocity(final VelocityTracker velocityTracker, final int n) {
        return IMPL.getYVelocity(velocityTracker, n);
    }
}
