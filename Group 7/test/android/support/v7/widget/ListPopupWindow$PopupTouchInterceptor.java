package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ListPopupWindow$PopupTouchInterceptor implements OnTouchListener {
   private ListPopupWindow$PopupTouchInterceptor(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      int var3 = var2.getAction();
      int var4 = (int)var2.getX();
      int var5 = (int)var2.getY();
      if(var3 == 0 && ListPopupWindow.access$1100(this.this$0) != null && ListPopupWindow.access$1100(this.this$0).isShowing() && var4 >= 0 && var4 < ListPopupWindow.access$1100(this.this$0).getWidth() && var5 >= 0 && var5 < ListPopupWindow.access$1100(this.this$0).getHeight()) {
         ListPopupWindow.access$1300(this.this$0).postDelayed(ListPopupWindow.access$1200(this.this$0), 250L);
      } else if(var3 == 1) {
         ListPopupWindow.access$1300(this.this$0).removeCallbacks(ListPopupWindow.access$1200(this.this$0));
      }

      return false;
   }
}
