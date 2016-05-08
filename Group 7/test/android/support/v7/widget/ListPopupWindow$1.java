package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;
import android.view.View;

class ListPopupWindow$1 extends ListPopupWindow$ForwardingListener {
   ListPopupWindow$1(ListPopupWindow var1, View var2) {
      super(var2);
      this.this$0 = var1;
   }

   public ListPopupWindow getPopup() {
      return this.this$0;
   }
}
