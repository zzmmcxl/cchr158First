package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBarDrawerToggle$Delegate;
import android.support.v7.widget.Toolbar;

class ActionBarDrawerToggle$ToolbarCompatDelegate implements ActionBarDrawerToggle$Delegate {
   final CharSequence mDefaultContentDescription;
   final Drawable mDefaultUpIndicator;
   final Toolbar mToolbar;

   ActionBarDrawerToggle$ToolbarCompatDelegate(Toolbar var1) {
      this.mToolbar = var1;
      this.mDefaultUpIndicator = var1.getNavigationIcon();
      this.mDefaultContentDescription = var1.getNavigationContentDescription();
   }

   public Context getActionBarThemedContext() {
      return this.mToolbar.getContext();
   }

   public Drawable getThemeUpIndicator() {
      return this.mDefaultUpIndicator;
   }

   public boolean isNavigationVisible() {
      return true;
   }

   public void setActionBarDescription(@StringRes int var1) {
      if(var1 == 0) {
         this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
      } else {
         this.mToolbar.setNavigationContentDescription(var1);
      }
   }

   public void setActionBarUpIndicator(Drawable var1, @StringRes int var2) {
      this.mToolbar.setNavigationIcon(var1);
      this.setActionBarDescription(var2);
   }
}
