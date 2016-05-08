package android.support.v7.view.menu;

import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;

class ActionMenuItemView$ActionMenuItemForwardingListener extends ListPopupWindow$ForwardingListener {
   public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView var1) {
      super(var1);
      this.this$0 = var1;
   }

   public ListPopupWindow getPopup() {
      return ActionMenuItemView.access$000(this.this$0) != null?ActionMenuItemView.access$000(this.this$0).getPopup():null;
   }

   protected boolean onForwardingStarted() {
      boolean var2 = false;
      boolean var1 = var2;
      if(ActionMenuItemView.access$100(this.this$0) != null) {
         var1 = var2;
         if(ActionMenuItemView.access$100(this.this$0).invokeItem(ActionMenuItemView.access$200(this.this$0))) {
            ListPopupWindow var3 = this.getPopup();
            var1 = var2;
            if(var3 != null) {
               var1 = var2;
               if(var3.isShowing()) {
                  var1 = true;
               }
            }
         }
      }

      return var1;
   }
}
