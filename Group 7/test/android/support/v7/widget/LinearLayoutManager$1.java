package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;

class LinearLayoutManager$1 extends LinearSmoothScroller {
   LinearLayoutManager$1(LinearLayoutManager var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   public PointF computeScrollVectorForPosition(int var1) {
      return this.this$0.computeScrollVectorForPosition(var1);
   }
}
