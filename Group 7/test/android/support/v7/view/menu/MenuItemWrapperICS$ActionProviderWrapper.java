package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.SubMenu;
import android.view.View;

class MenuItemWrapperICS$ActionProviderWrapper extends ActionProvider {
   final android.view.ActionProvider mInner;

   public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS var1, Context var2, android.view.ActionProvider var3) {
      super(var2);
      this.this$0 = var1;
      this.mInner = var3;
   }

   public boolean hasSubMenu() {
      return this.mInner.hasSubMenu();
   }

   public View onCreateActionView() {
      return this.mInner.onCreateActionView();
   }

   public boolean onPerformDefaultAction() {
      return this.mInner.onPerformDefaultAction();
   }

   public void onPrepareSubMenu(SubMenu var1) {
      this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(var1));
   }
}
