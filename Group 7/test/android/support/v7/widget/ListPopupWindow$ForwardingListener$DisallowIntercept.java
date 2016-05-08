package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow$ForwardingListener;

class ListPopupWindow$ForwardingListener$DisallowIntercept implements Runnable {
   private ListPopupWindow$ForwardingListener$DisallowIntercept(ListPopupWindow$ForwardingListener var1) {
      this.this$0 = var1;
   }

   public void run() {
      ListPopupWindow$ForwardingListener.access$900(this.this$0).getParent().requestDisallowInterceptTouchEvent(true);
   }
}
