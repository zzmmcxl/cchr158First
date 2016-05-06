package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

static class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl
{
    JellybeanMr1DrawableImpl() {
        super();
    }
    
    @Override
    public int getLayoutDirection(final Drawable drawable) {
        final int layoutDirection = DrawableCompatJellybeanMr1.getLayoutDirection(drawable);
        if (layoutDirection >= 0) {
            return layoutDirection;
        }
        return 0;
    }
    
    @Override
    public void setLayoutDirection(final Drawable drawable, final int n) {
        DrawableCompatJellybeanMr1.setLayoutDirection(drawable, n);
    }
}
