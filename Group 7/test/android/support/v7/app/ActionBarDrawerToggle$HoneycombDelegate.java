package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarDrawerToggle$Delegate;
import android.support.v7.app.ActionBarDrawerToggleHoneycomb;
import android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;

class ActionBarDrawerToggle$HoneycombDelegate implements ActionBarDrawerToggle$Delegate {
   final Activity mActivity;
   ActionBarDrawerToggleHoneycomb$SetIndicatorInfo mSetIndicatorInfo;

   private ActionBarDrawerToggle$HoneycombDelegate(Activity var1) {
      this.mActivity = var1;
   }

   public Context getActionBarThemedContext() {
      android.app.ActionBar var1 = this.mActivity.getActionBar();
      return (Context)(var1 != null?var1.getThemedContext():this.mActivity);
   }

   public Drawable getThemeUpIndicator() {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
   }

   public boolean isNavigationVisible() {
      android.app.ActionBar var1 = this.mActivity.getActionBar();
      return var1 != null && (var1.getDisplayOptions() & 4) != 0;
   }

   public void setActionBarDescription(int var1) {
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, var1);
   }

   public void setActionBarUpIndicator(Drawable var1, int var2) {
      this.mActivity.getActionBar().setDisplayShowHomeEnabled(true);
      this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, var1, var2);
      this.mActivity.getActionBar().setDisplayShowHomeEnabled(false);
   }
}
