package android.support.v7.app;

import android.support.annotation.StringRes;
import android.graphics.drawable.Drawable;
import android.content.Context;

public interface Delegate
{
    Context getActionBarThemedContext();
    
    Drawable getThemeUpIndicator();
    
    boolean isNavigationVisible();
    
    void setActionBarDescription(@StringRes final int p0);
    
    void setActionBarUpIndicator(final Drawable p0, @StringRes final int p1);
}
