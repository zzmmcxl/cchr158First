package android.support.v7.app;

import android.support.v7.app.ToolbarActionBar;
import android.support.v7.widget.Toolbar$OnMenuItemClickListener;
import android.view.MenuItem;

class ToolbarActionBar$2 implements Toolbar$OnMenuItemClickListener {
   ToolbarActionBar$2(ToolbarActionBar var1) {
      this.this$0 = var1;
   }

   public boolean onMenuItemClick(MenuItem var1) {
      return ToolbarActionBar.access$000(this.this$0).onMenuItemSelected(0, var1);
   }
}
