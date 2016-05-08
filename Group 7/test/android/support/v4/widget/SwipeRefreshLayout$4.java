package android.support.v4.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$4 extends Animation {
   SwipeRefreshLayout$4(SwipeRefreshLayout var1, int var2, int var3) {
      this.this$0 = var1;
      this.val$startingAlpha = var2;
      this.val$endingAlpha = var3;
   }

   public void applyTransformation(float var1, Transformation var2) {
      SwipeRefreshLayout.access$100(this.this$0).setAlpha((int)((float)this.val$startingAlpha + (float)(this.val$endingAlpha - this.val$startingAlpha) * var1));
   }
}
