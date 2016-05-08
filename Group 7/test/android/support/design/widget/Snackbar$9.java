package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class Snackbar$9 extends ViewPropertyAnimatorListenerAdapter {
   boolean mEndCalled;

   Snackbar$9(Snackbar var1, int var2) {
      this.this$0 = var1;
      this.val$event = var2;
      this.mEndCalled = false;
   }

   public void onAnimationEnd(View var1) {
      Snackbar.access$300(this.this$0, this.val$event);
   }

   public void onAnimationStart(View var1) {
      if(!Snackbar.access$600(this.this$0).isEnabled()) {
         Snackbar.access$500(this.this$0).animateChildrenOut(0, 180);
      }

   }
}
