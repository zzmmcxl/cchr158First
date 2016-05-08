package android.support.v7.app;

import android.support.v7.app.ToolbarActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

final class ToolbarActionBar$PanelMenuPresenterCallback implements MenuPresenter$Callback {
   private ToolbarActionBar$PanelMenuPresenterCallback(ToolbarActionBar var1) {
      this.this$0 = var1;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(ToolbarActionBar.access$000(this.this$0) != null) {
         ToolbarActionBar.access$000(this.this$0).onPanelClosed(0, var1);
      }

   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      if(var1 == null && ToolbarActionBar.access$000(this.this$0) != null) {
         ToolbarActionBar.access$000(this.this$0).onMenuOpened(0, var1);
      }

      return true;
   }
}
