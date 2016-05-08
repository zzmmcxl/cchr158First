package android.support.v4.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$1 implements AnimationListener {
   SwipeRefreshLayout$1(SwipeRefreshLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(Animation var1) {
      if(SwipeRefreshLayout.access$000(this.this$0)) {
         SwipeRefreshLayout.access$100(this.this$0).setAlpha(255);
         SwipeRefreshLayout.access$100(this.this$0).start();
         if(SwipeRefreshLayout.access$200(this.this$0) && SwipeRefreshLayout.access$300(this.this$0) != null) {
            SwipeRefreshLayout.access$300(this.this$0).onRefresh();
         }

         SwipeRefreshLayout.access$402(this.this$0, SwipeRefreshLayout.access$500(this.this$0).getTop());
      } else {
         SwipeRefreshLayout.access$600(this.this$0);
      }
   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
