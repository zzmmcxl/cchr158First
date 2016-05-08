package android.support.v4.widget;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

class SlidingPaneLayout$DisableLayerRunnable implements Runnable {
   final View mChildView;

   SlidingPaneLayout$DisableLayerRunnable(SlidingPaneLayout var1, View var2) {
      this.this$0 = var1;
      this.mChildView = var2;
   }

   public void run() {
      if(this.mChildView.getParent() == this.this$0) {
         ViewCompat.setLayerType(this.mChildView, 0, (Paint)null);
         SlidingPaneLayout.access$1000(this.this$0, this.mChildView);
      }

      SlidingPaneLayout.access$1100(this.this$0).remove(this);
   }
}
