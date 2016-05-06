package android.support.v4.widget;

import android.widget.OverScroller;

class ScrollerCompatIcs
{
    ScrollerCompatIcs() {
        super();
    }
    
    public static float getCurrVelocity(final Object o) {
        return ((OverScroller)o).getCurrVelocity();
    }
}
