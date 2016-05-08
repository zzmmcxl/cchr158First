package android.support.v4.view;

import android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy;
import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl$1 implements MenuItemCompatIcs$SupportActionExpandProxy {
   MenuItemCompat$IcsMenuVersionImpl$1(MenuItemCompat$IcsMenuVersionImpl var1, MenuItemCompat$OnActionExpandListener var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public boolean onMenuItemActionCollapse(MenuItem var1) {
      return this.val$listener.onMenuItemActionCollapse(var1);
   }

   public boolean onMenuItemActionExpand(MenuItem var1) {
      return this.val$listener.onMenuItemActionExpand(var1);
   }
}
