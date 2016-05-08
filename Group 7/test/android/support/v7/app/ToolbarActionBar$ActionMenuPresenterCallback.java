package android.support.v7.app;

import android.support.v7.app.ToolbarActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

final class ToolbarActionBar$ActionMenuPresenterCallback implements MenuPresenter$Callback {
   private boolean mClosingActionMenu;

   private ToolbarActionBar$ActionMenuPresenterCallback(ToolbarActionBar var1) {
      this.this$0 = var1;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(!this.mClosingActionMenu) {
         this.mClosingActionMenu = true;
         ToolbarActionBar.access$300(this.this$0).dismissPopupMenus();
         if(ToolbarActionBar.access$000(this.this$0) != null) {
            ToolbarActionBar.access$000(this.this$0).onPanelClosed(108, var1);
         }

         this.mClosingActionMenu = false;
      }
   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      if(ToolbarActionBar.access$000(this.this$0) != null) {
         ToolbarActionBar.access$000(this.this$0).onMenuOpened(108, var1);
         return true;
      } else {
         return false;
      }
   }
}
