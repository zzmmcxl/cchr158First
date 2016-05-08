package android.support.v7.app;

import android.support.v7.app.ToolbarActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.view.MenuItem;
import android.view.View;

final class ToolbarActionBar$MenuBuilderCallback implements MenuBuilder$Callback {
   private ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar var1) {
      this.this$0 = var1;
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return false;
   }

   public void onMenuModeChange(MenuBuilder var1) {
      if(ToolbarActionBar.access$000(this.this$0) != null) {
         if(ToolbarActionBar.access$300(this.this$0).isOverflowMenuShowing()) {
            ToolbarActionBar.access$000(this.this$0).onPanelClosed(108, var1);
         } else if(ToolbarActionBar.access$000(this.this$0).onPreparePanel(0, (View)null, var1)) {
            ToolbarActionBar.access$000(this.this$0).onMenuOpened(108, var1);
            return;
         }
      }

   }
}
