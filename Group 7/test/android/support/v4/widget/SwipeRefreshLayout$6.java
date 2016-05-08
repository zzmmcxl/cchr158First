package android.support.v4.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$6 extends Animation {
   SwipeRefreshLayout$6(SwipeRefreshLayout var1) {
      this.this$0 = var1;
   }

   public void applyTransformation(float var1, Transformation var2) {
      int var3;
      if(!SwipeRefreshLayout.access$1000(this.this$0)) {
         var3 = (int)(SwipeRefreshLayout.access$1100(this.this$0) - (float)Math.abs(this.this$0.mOriginalOffsetTop));
      } else {
         var3 = (int)SwipeRefreshLayout.access$1100(this.this$0);
      }

      int var4 = this.this$0.mFrom;
      var3 = (int)((float)(var3 - this.this$0.mFrom) * var1);
      int var5 = SwipeRefreshLayout.access$500(this.this$0).getTop();
      SwipeRefreshLayout.access$1200(this.this$0, var4 + var3 - var5, false);
      SwipeRefreshLayout.access$100(this.this$0).setArrowScale(1.0F - var1);
   }
}
