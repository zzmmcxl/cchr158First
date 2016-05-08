package android.support.v7.widget;

import android.support.v7.widget.ScrollingTabContainerView;
import android.view.View;

class ScrollingTabContainerView$1 implements Runnable {
   ScrollingTabContainerView$1(ScrollingTabContainerView var1, View var2) {
      this.this$0 = var1;
      this.val$tabView = var2;
   }

   public void run() {
      int var1 = this.val$tabView.getLeft();
      int var2 = (this.this$0.getWidth() - this.val$tabView.getWidth()) / 2;
      this.this$0.smoothScrollTo(var1 - var2, 0);
      this.this$0.mTabSelector = null;
   }
}
