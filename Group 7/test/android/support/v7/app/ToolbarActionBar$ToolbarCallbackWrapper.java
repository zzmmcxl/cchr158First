package android.support.v7.app;

import android.support.v7.app.ToolbarActionBar;
import android.support.v7.view.WindowCallbackWrapper;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class ToolbarActionBar$ToolbarCallbackWrapper extends WindowCallbackWrapper {
   public ToolbarActionBar$ToolbarCallbackWrapper(ToolbarActionBar var1, Callback var2) {
      super(var2);
      this.this$0 = var1;
   }

   public View onCreatePanelView(int var1) {
      switch(var1) {
      case 0:
         Menu var2 = ToolbarActionBar.access$300(this.this$0).getMenu();
         if(this.onPreparePanel(var1, (View)null, var2) && this.onMenuOpened(var1, var2)) {
            return ToolbarActionBar.access$400(this.this$0, var2);
         }
      default:
         return super.onCreatePanelView(var1);
      }
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      boolean var4 = super.onPreparePanel(var1, var2, var3);
      if(var4 && !ToolbarActionBar.access$200(this.this$0)) {
         ToolbarActionBar.access$300(this.this$0).setMenuPrepared();
         ToolbarActionBar.access$202(this.this$0, true);
      }

      return var4;
   }
}
