package android.support.v4.view;

import android.support.v4.view.MenuItemCompat$HoneycombMenuVersionImpl;
import android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl$1;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.support.v4.view.MenuItemCompatIcs;
import android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy;
import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl extends MenuItemCompat$HoneycombMenuVersionImpl {
   public boolean collapseActionView(MenuItem var1) {
      return MenuItemCompatIcs.collapseActionView(var1);
   }

   public boolean expandActionView(MenuItem var1) {
      return MenuItemCompatIcs.expandActionView(var1);
   }

   public boolean isActionViewExpanded(MenuItem var1) {
      return MenuItemCompatIcs.isActionViewExpanded(var1);
   }

   public MenuItem setOnActionExpandListener(MenuItem var1, MenuItemCompat$OnActionExpandListener var2) {
      return var2 == null?MenuItemCompatIcs.setOnActionExpandListener(var1, (MenuItemCompatIcs$SupportActionExpandProxy)null):MenuItemCompatIcs.setOnActionExpandListener(var1, new MenuItemCompat$IcsMenuVersionImpl$1(this, var2));
   }
}
