package android.support.v4.view;

import android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemCompatIcs$OnActionExpandListenerWrapper implements OnActionExpandListener {
   private MenuItemCompatIcs$SupportActionExpandProxy mWrapped;

   public MenuItemCompatIcs$OnActionExpandListenerWrapper(MenuItemCompatIcs$SupportActionExpandProxy var1) {
      this.mWrapped = var1;
   }

   public boolean onMenuItemActionCollapse(MenuItem var1) {
      return this.mWrapped.onMenuItemActionCollapse(var1);
   }

   public boolean onMenuItemActionExpand(MenuItem var1) {
      return this.mWrapped.onMenuItemActionExpand(var1);
   }
}
