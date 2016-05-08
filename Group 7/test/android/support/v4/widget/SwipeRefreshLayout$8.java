package android.support.v4.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$8 extends Animation {
   SwipeRefreshLayout$8(SwipeRefreshLayout var1) {
      this.this$0 = var1;
   }

   public void applyTransformation(float var1, Transformation var2) {
      float var3 = SwipeRefreshLayout.access$1400(this.this$0);
      float var4 = -SwipeRefreshLayout.access$1400(this.this$0);
      SwipeRefreshLayout.access$700(this.this$0, var3 + var4 * var1);
      SwipeRefreshLayout.access$1300(this.this$0, var1);
   }
}
