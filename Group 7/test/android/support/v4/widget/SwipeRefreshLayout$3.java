package android.support.v4.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$3 extends Animation {
   SwipeRefreshLayout$3(SwipeRefreshLayout var1) {
      this.this$0 = var1;
   }

   public void applyTransformation(float var1, Transformation var2) {
      SwipeRefreshLayout.access$700(this.this$0, 1.0F - var1);
   }
}
