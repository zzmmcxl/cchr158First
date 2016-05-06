package android.support.v4.view;

import android.view.MotionEvent;

static class HoneycombMr1MotionEventVersionImpl extends GingerbreadMotionEventVersionImpl
{
    HoneycombMr1MotionEventVersionImpl() {
        super();
    }
    
    @Override
    public float getAxisValue(final MotionEvent motionEvent, final int n) {
        return MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, n);
    }
    
    @Override
    public float getAxisValue(final MotionEvent motionEvent, final int n, final int n2) {
        return MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, n, n2);
    }
}
