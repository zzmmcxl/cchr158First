package android.support.v4.view;

import android.support.v4.view.MenuItemCompatIcs$OnActionExpandListenerWrapper;
import android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy;
import android.view.MenuItem;

class MenuItemCompatIcs {
   public static boolean collapseActionView(MenuItem var0) {
      return var0.collapseActionView();
   }

   public static boolean expandActionView(MenuItem var0) {
      return var0.expandActionView();
   }

   public static boolean isActionViewExpanded(MenuItem var0) {
      return var0.isActionViewExpanded();
   }

   public static MenuItem setOnActionExpandListener(MenuItem var0, MenuItemCompatIcs$SupportActionExpandProxy var1) {
      return var0.setOnActionExpandListener(new MenuItemCompatIcs$OnActionExpandListenerWrapper(var1));
   }
}
