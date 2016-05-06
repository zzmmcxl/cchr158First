package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompatApi23
{
    DrawableCompatApi23() {
        super();
    }
    
    public static int getLayoutDirection(final Drawable drawable) {
        return drawable.getLayoutDirection();
    }
    
    public static void setLayoutDirection(final Drawable drawable, final int layoutDirection) {
        drawable.setLayoutDirection(layoutDirection);
    }
}
