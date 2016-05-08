package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;

class ListPopupWindow$2 implements Runnable {
   ListPopupWindow$2(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public void run() {
      View var1 = this.this$0.getAnchorView();
      if(var1 != null && var1.getWindowToken() != null) {
         this.this$0.show();
      }

   }
}
