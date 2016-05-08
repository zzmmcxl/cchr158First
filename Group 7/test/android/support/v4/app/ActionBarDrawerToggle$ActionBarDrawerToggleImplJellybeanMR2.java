package android.support.v4.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImpl;
import android.support.v4.app.ActionBarDrawerToggleJellybeanMR2;

class ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggle$ActionBarDrawerToggleImpl {
   private ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2() {
   }

   public Drawable getThemeUpIndicator(Activity var1) {
      return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(var1);
   }

   public Object setActionBarDescription(Object var1, Activity var2, int var3) {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(var1, var2, var3);
   }

   public Object setActionBarUpIndicator(Object var1, Activity var2, Drawable var3, int var4) {
      return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(var1, var2, var3, var4);
   }
}
