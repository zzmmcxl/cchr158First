package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.view.View;

class SwipeDismissBehavior$SettleRunnable implements Runnable {
   private final boolean mDismiss;
   private final View mView;

   SwipeDismissBehavior$SettleRunnable(SwipeDismissBehavior var1, View var2, boolean var3) {
      this.this$0 = var1;
      this.mView = var2;
      this.mDismiss = var3;
   }

   public void run() {
      if(SwipeDismissBehavior.access$100(this.this$0) != null && SwipeDismissBehavior.access$100(this.this$0).continueSettling(true)) {
         ViewCompat.postOnAnimation(this.mView, this);
      } else if(this.mDismiss && SwipeDismissBehavior.access$000(this.this$0) != null) {
         SwipeDismissBehavior.access$000(this.this$0).onDismiss(this.mView);
         return;
      }

   }
}
