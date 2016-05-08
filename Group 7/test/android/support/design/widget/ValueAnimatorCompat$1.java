package android.support.design.widget;

import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy;

class ValueAnimatorCompat$1 implements ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy {
   ValueAnimatorCompat$1(ValueAnimatorCompat var1, ValueAnimatorCompat$AnimatorUpdateListener var2) {
      this.this$0 = var1;
      this.val$updateListener = var2;
   }

   public void onAnimationUpdate() {
      this.val$updateListener.onAnimationUpdate(this.this$0);
   }
}
