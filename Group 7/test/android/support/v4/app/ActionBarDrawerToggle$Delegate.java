package android.support.v4.app;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public interface ActionBarDrawerToggle$Delegate {
   @Nullable
   Drawable getThemeUpIndicator();

   void setActionBarDescription(@StringRes int var1);

   void setActionBarUpIndicator(Drawable var1, @StringRes int var2);
}
