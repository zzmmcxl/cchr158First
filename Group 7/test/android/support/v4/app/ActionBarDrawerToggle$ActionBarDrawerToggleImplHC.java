package android.support.v4.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImpl;
import android.support.v4.app.ActionBarDrawerToggleHoneycomb;

class ActionBarDrawerToggle$ActionBarDrawerToggleImplHC implements ActionBarDrawerToggle$ActionBarDrawerToggleImpl {
   private ActionBarDrawerToggle$ActionBarDrawerToggleImplHC() {
   }

   public Drawable getThemeUpIndicator(Activity var1) {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(var1);
   }

   public Object setActionBarDescription(Object var1, Activity var2, int var3) {
      return ActionBarDrawerToggleHoneycomb.setActionBarDescription(var1, var2, var3);
   }

   public Object setActionBarUpIndicator(Object var1, Activity var2, Drawable var3, int var4) {
      return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(var1, var2, var3, var4);
   }
}
