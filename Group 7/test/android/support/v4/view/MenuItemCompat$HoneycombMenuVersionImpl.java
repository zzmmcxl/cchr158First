package android.support.v4.view;

import android.support.v4.view.MenuItemCompat$MenuVersionImpl;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.support.v4.view.MenuItemCompatHoneycomb;
import android.view.MenuItem;
import android.view.View;

class MenuItemCompat$HoneycombMenuVersionImpl implements MenuItemCompat$MenuVersionImpl {
   public boolean collapseActionView(MenuItem var1) {
      return false;
   }

   public boolean expandActionView(MenuItem var1) {
      return false;
   }

   public View getActionView(MenuItem var1) {
      return MenuItemCompatHoneycomb.getActionView(var1);
   }

   public boolean isActionViewExpanded(MenuItem var1) {
      return false;
   }

   public MenuItem setActionView(MenuItem var1, int var2) {
      return MenuItemCompatHoneycomb.setActionView(var1, var2);
   }

   public MenuItem setActionView(MenuItem var1, View var2) {
      return MenuItemCompatHoneycomb.setActionView(var1, var2);
   }

   public MenuItem setOnActionExpandListener(MenuItem var1, MenuItemCompat$OnActionExpandListener var2) {
      return var1;
   }

   public void setShowAsAction(MenuItem var1, int var2) {
      MenuItemCompatHoneycomb.setShowAsAction(var1, var2);
   }
}
