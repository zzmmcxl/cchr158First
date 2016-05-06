package android.support.v4.view;

import android.view.ViewGroup;

class ViewGroupCompatHC
{
    private ViewGroupCompatHC() {
        super();
    }
    
    public static void setMotionEventSplittingEnabled(final ViewGroup viewGroup, final boolean motionEventSplittingEnabled) {
        viewGroup.setMotionEventSplittingEnabled(motionEventSplittingEnabled);
    }
}
