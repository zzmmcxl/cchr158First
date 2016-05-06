package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompatGingerbread
{
    MotionEventCompatGingerbread() {
        super();
    }
    
    public static int getSource(final MotionEvent motionEvent) {
        return motionEvent.getSource();
    }
}
