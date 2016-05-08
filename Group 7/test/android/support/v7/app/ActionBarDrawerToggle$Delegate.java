package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;

public interface ActionBarDrawerToggle$Delegate {
   Context getActionBarThemedContext();

   Drawable getThemeUpIndicator();

   boolean isNavigationVisible();

   void setActionBarDescription(@StringRes int var1);

   void setActionBarUpIndicator(Drawable var1, @StringRes int var2);
}
