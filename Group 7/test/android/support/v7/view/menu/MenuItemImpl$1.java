package android.support.v7.view.menu;

import android.support.v4.view.ActionProvider$VisibilityListener;
import android.support.v7.view.menu.MenuItemImpl;

class MenuItemImpl$1 implements ActionProvider$VisibilityListener {
   MenuItemImpl$1(MenuItemImpl var1) {
      this.this$0 = var1;
   }

   public void onActionProviderVisibilityChanged(boolean var1) {
      MenuItemImpl.access$000(this.this$0).onItemVisibleChanged(this.this$0);
   }
}
