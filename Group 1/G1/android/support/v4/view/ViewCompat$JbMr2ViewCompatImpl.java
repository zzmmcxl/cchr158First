package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl
{
    JbMr2ViewCompatImpl() {
        super();
    }
    
    @Override
    public Rect getClipBounds(final View view) {
        return ViewCompatJellybeanMr2.getClipBounds(view);
    }
    
    @Override
    public void setClipBounds(final View view, final Rect rect) {
        ViewCompatJellybeanMr2.setClipBounds(view, rect);
    }
}
