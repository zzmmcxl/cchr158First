package android.support.design.widget;

import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorListener;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorListenerProxy;

class ValueAnimatorCompat$2 implements ValueAnimatorCompat$Impl$AnimatorListenerProxy {
   ValueAnimatorCompat$2(ValueAnimatorCompat var1, ValueAnimatorCompat$AnimatorListener var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public void onAnimationCancel() {
      this.val$listener.onAnimationCancel(this.this$0);
   }

   public void onAnimationEnd() {
      this.val$listener.onAnimationEnd(this.this$0);
   }

   public void onAnimationStart() {
      this.val$listener.onAnimationStart(this.this$0);
   }
}
