package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.StaggeredGridLayoutManager;

class StaggeredGridLayoutManager$2 extends LinearSmoothScroller {
   StaggeredGridLayoutManager$2(StaggeredGridLayoutManager var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   public PointF computeScrollVectorForPosition(int var1) {
      var1 = StaggeredGridLayoutManager.access$400(this.this$0, var1);
      return var1 == 0?null:(StaggeredGridLayoutManager.access$500(this.this$0) == 0?new PointF((float)var1, 0.0F):new PointF(0.0F, (float)var1));
   }
}
