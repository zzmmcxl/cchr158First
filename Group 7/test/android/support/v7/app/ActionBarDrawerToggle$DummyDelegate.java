package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBarDrawerToggle$Delegate;

class ActionBarDrawerToggle$DummyDelegate implements ActionBarDrawerToggle$Delegate {
   final Activity mActivity;

   ActionBarDrawerToggle$DummyDelegate(Activity var1) {
      this.mActivity = var1;
   }

   public Context getActionBarThemedContext() {
      return this.mActivity;
   }

   public Drawable getThemeUpIndicator() {
      return null;
   }

   public boolean isNavigationVisible() {
      return true;
   }

   public void setActionBarDescription(@StringRes int var1) {
   }

   public void setActionBarUpIndicator(Drawable var1, @StringRes int var2) {
   }
}
