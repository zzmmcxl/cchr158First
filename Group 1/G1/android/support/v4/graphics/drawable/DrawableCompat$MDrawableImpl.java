package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

static class MDrawableImpl extends LollipopDrawableImpl
{
    MDrawableImpl() {
        super();
    }
    
    @Override
    public int getLayoutDirection(final Drawable drawable) {
        return DrawableCompatApi23.getLayoutDirection(drawable);
    }
    
    @Override
    public void setLayoutDirection(final Drawable drawable, final int n) {
        DrawableCompatApi23.setLayoutDirection(drawable, n);
    }
    
    @Override
    public Drawable wrap(final Drawable drawable) {
        return drawable;
    }
}
