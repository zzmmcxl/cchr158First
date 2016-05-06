package android.support.design.widget;

import android.graphics.Outline;

class CircularBorderDrawableLollipop extends CircularBorderDrawable
{
    CircularBorderDrawableLollipop() {
        super();
    }
    
    public void getOutline(final Outline outline) {
        this.copyBounds(this.mRect);
        outline.setOval(this.mRect);
    }
}
