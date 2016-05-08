package android.support.v7.widget;

import android.support.v7.widget.ActionMenuView$OnMenuItemClickListener;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

class Toolbar$1 implements ActionMenuView$OnMenuItemClickListener {
   Toolbar$1(Toolbar var1) {
      this.this$0 = var1;
   }

   public boolean onMenuItemClick(MenuItem var1) {
      return Toolbar.access$000(this.this$0) != null?Toolbar.access$000(this.this$0).onMenuItemClick(var1):false;
   }
}
