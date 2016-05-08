package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;

class ListPopupWindow$ListSelectorHider implements Runnable {
   private ListPopupWindow$ListSelectorHider(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public void run() {
      this.this$0.clearListSelection();
   }
}
