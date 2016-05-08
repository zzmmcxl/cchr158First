package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy;
import android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1;

class ValueAnimatorCompatImplHoneycombMr1$1 implements AnimatorUpdateListener {
   ValueAnimatorCompatImplHoneycombMr1$1(ValueAnimatorCompatImplHoneycombMr1 var1, ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy var2) {
      this.this$0 = var1;
      this.val$updateListener = var2;
   }

   public void onAnimationUpdate(ValueAnimator var1) {
      this.val$updateListener.onAnimationUpdate();
   }
}
