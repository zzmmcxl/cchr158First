package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarDrawerToggle$Delegate;
import android.util.AttributeSet;

class ActionBarDrawerToggle$JellybeanMr2Delegate implements ActionBarDrawerToggle$Delegate {
   final Activity mActivity;

   private ActionBarDrawerToggle$JellybeanMr2Delegate(Activity var1) {
      this.mActivity = var1;
   }

   public Context getActionBarThemedContext() {
      android.app.ActionBar var1 = this.mActivity.getActionBar();
      return (Context)(var1 != null?var1.getThemedContext():this.mActivity);
   }

   public Drawable getThemeUpIndicator() {
      TypedArray var1 = this.getActionBarThemedContext().obtainStyledAttributes((AttributeSet)null, new int[]{16843531}, 16843470, 0);
      Drawable var2 = var1.getDrawable(0);
      var1.recycle();
      return var2;
   }

   public boolean isNavigationVisible() {
      android.app.ActionBar var1 = this.mActivity.getActionBar();
      return var1 != null && (var1.getDisplayOptions() & 4) != 0;
   }

   public void setActionBarDescription(int var1) {
      android.app.ActionBar var2 = this.mActivity.getActionBar();
      if(var2 != null) {
         var2.setHomeActionContentDescription(var1);
      }

   }

   public void setActionBarUpIndicator(Drawable var1, int var2) {
      android.app.ActionBar var3 = this.mActivity.getActionBar();
      if(var3 != null) {
         var3.setHomeAsUpIndicator(var1);
         var3.setHomeActionContentDescription(var2);
      }

   }
}
