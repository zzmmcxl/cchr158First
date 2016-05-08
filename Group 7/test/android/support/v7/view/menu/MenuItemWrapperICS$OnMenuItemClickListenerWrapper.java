package android.support.v7.view.menu;

import android.support.v7.view.menu.BaseWrapper;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MenuItemWrapperICS$OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
   MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS var1, OnMenuItemClickListener var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean onMenuItemClick(MenuItem var1) {
      return ((OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(this.this$0.getMenuItemWrapper(var1));
   }
}
