package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.widget.ActionMenuView;
import android.view.MenuItem;

class ActionMenuView$MenuBuilderCallback implements MenuBuilder$Callback {
   private ActionMenuView$MenuBuilderCallback(ActionMenuView var1) {
      this.this$0 = var1;
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return ActionMenuView.access$200(this.this$0) != null && ActionMenuView.access$200(this.this$0).onMenuItemClick(var2);
   }

   public void onMenuModeChange(MenuBuilder var1) {
      if(ActionMenuView.access$300(this.this$0) != null) {
         ActionMenuView.access$300(this.this$0).onMenuModeChange(var1);
      }

   }
}
