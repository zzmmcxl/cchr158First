package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;
import android.support.v7.widget.PopupMenu;
import android.view.View;

class PopupMenu$1 extends ListPopupWindow$ForwardingListener {
   PopupMenu$1(PopupMenu var1, View var2) {
      super(var2);
      this.this$0 = var1;
   }

   public ListPopupWindow getPopup() {
      return PopupMenu.access$000(this.this$0).getPopup();
   }

   protected boolean onForwardingStarted() {
      this.this$0.show();
      return true;
   }

   protected boolean onForwardingStopped() {
      this.this$0.dismiss();
      return true;
   }
}
