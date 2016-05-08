package android.support.v7.view.menu;

import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.support.v7.view.menu.BaseWrapper;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper extends BaseWrapper<OnActionExpandListener> implements MenuItemCompat$OnActionExpandListener {
   MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS var1, OnActionExpandListener var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean onMenuItemActionCollapse(MenuItem var1) {
      return ((OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(var1));
   }

   public boolean onMenuItemActionExpand(MenuItem var1) {
      return ((OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(this.this$0.getMenuItemWrapper(var1));
   }
}
