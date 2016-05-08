package android.support.v4.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$5 implements AnimationListener {
   SwipeRefreshLayout$5(SwipeRefreshLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(Animation var1) {
      if(!SwipeRefreshLayout.access$800(this.this$0)) {
         SwipeRefreshLayout.access$900(this.this$0, (AnimationListener)null);
      }

   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
