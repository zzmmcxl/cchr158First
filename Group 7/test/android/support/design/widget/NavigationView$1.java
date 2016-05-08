package android.support.design.widget;

import android.support.design.widget.NavigationView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.view.MenuItem;

class NavigationView$1 implements MenuBuilder$Callback {
   NavigationView$1(NavigationView var1) {
      this.this$0 = var1;
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return NavigationView.access$000(this.this$0) != null && NavigationView.access$000(this.this$0).onNavigationItemSelected(var2);
   }

   public void onMenuModeChange(MenuBuilder var1) {
   }
}
