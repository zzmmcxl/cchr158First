package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ListPopupWindow$PopupScrollListener implements OnScrollListener {
   private ListPopupWindow$PopupScrollListener(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public void onScroll(AbsListView var1, int var2, int var3, int var4) {
   }

   public void onScrollStateChanged(AbsListView var1, int var2) {
      if(var2 == 1 && !this.this$0.isInputMethodNotNeeded() && ListPopupWindow.access$1100(this.this$0).getContentView() != null) {
         ListPopupWindow.access$1300(this.this$0).removeCallbacks(ListPopupWindow.access$1200(this.this$0));
         ListPopupWindow.access$1200(this.this$0).run();
      }

   }
}
