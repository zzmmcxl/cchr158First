package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

class ViewCompatJellybeanMr2
{
    ViewCompatJellybeanMr2() {
        super();
    }
    
    public static Rect getClipBounds(final View view) {
        return view.getClipBounds();
    }
    
    public static void setClipBounds(final View view, final Rect clipBounds) {
        view.setClipBounds(clipBounds);
    }
}
