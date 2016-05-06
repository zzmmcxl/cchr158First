package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

public interface DrawableWrapper
{
    Drawable getWrappedDrawable();
    
    void setCompatTint(final int p0);
    
    void setCompatTintList(final ColorStateList p0);
    
    void setCompatTintMode(final PorterDuff$Mode p0);
    
    void setWrappedDrawable(final Drawable p0);
}
