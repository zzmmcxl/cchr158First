package android.support.v7.app;

import android.support.annotation.DrawableRes;
import android.graphics.drawable.Drawable;
import android.view.View;

public abstract static class Tab
{
    public static final int INVALID_POSITION = -1;
    
    public Tab() {
        super();
    }
    
    public abstract CharSequence getContentDescription();
    
    public abstract View getCustomView();
    
    public abstract Drawable getIcon();
    
    public abstract int getPosition();
    
    public abstract Object getTag();
    
    public abstract CharSequence getText();
    
    public abstract void select();
    
    public abstract Tab setContentDescription(final int p0);
    
    public abstract Tab setContentDescription(final CharSequence p0);
    
    public abstract Tab setCustomView(final int p0);
    
    public abstract Tab setCustomView(final View p0);
    
    public abstract Tab setIcon(@DrawableRes final int p0);
    
    public abstract Tab setIcon(final Drawable p0);
    
    public abstract Tab setTabListener(final TabListener p0);
    
    public abstract Tab setTag(final Object p0);
    
    public abstract Tab setText(final int p0);
    
    public abstract Tab setText(final CharSequence p0);
}
