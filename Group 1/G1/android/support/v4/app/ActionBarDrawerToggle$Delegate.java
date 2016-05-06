package android.support.v4.app;

import android.support.annotation.StringRes;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;

public interface Delegate
{
    @Nullable
    Drawable getThemeUpIndicator();
    
    void setActionBarDescription(@StringRes final int p0);
    
    void setActionBarUpIndicator(final Drawable p0, @StringRes final int p1);
}
