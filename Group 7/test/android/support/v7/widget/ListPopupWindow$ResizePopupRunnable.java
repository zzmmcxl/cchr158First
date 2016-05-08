package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ListPopupWindow;

class ListPopupWindow$ResizePopupRunnable implements Runnable {
   private ListPopupWindow$ResizePopupRunnable(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public void run() {
      if(ListPopupWindow.access$600(this.this$0) != null && ViewCompat.isAttachedToWindow(ListPopupWindow.access$600(this.this$0)) && ListPopupWindow.access$600(this.this$0).getCount() > ListPopupWindow.access$600(this.this$0).getChildCount() && ListPopupWindow.access$600(this.this$0).getChildCount() <= this.this$0.mListItemExpandMaximum) {
         ListPopupWindow.access$1100(this.this$0).setInputMethodMode(2);
         this.this$0.show();
      }

   }
}
