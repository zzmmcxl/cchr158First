package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompatHoneycombMr1
{
    MotionEventCompatHoneycombMr1() {
        super();
    }
    
    static float getAxisValue(final MotionEvent motionEvent, final int n) {
        return motionEvent.getAxisValue(n);
    }
    
    static float getAxisValue(final MotionEvent motionEvent, final int n, final int n2) {
        return motionEvent.getAxisValue(n, n2);
    }
}
