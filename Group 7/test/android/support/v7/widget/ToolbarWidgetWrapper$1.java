package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;
import android.view.View.OnClickListener;

class ToolbarWidgetWrapper$1 implements OnClickListener {
   final ActionMenuItem mNavItem;

   ToolbarWidgetWrapper$1(ToolbarWidgetWrapper var1) {
      this.this$0 = var1;
      this.mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.access$000(this.this$0).getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.access$100(this.this$0));
   }

   public void onClick(View var1) {
      if(ToolbarWidgetWrapper.access$200(this.this$0) != null && ToolbarWidgetWrapper.access$300(this.this$0)) {
         ToolbarWidgetWrapper.access$200(this.this$0).onMenuItemSelected(0, this.mNavItem);
      }

   }
}
