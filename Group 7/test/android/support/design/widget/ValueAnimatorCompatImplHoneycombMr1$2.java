package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorListenerProxy;
import android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1;

class ValueAnimatorCompatImplHoneycombMr1$2 extends AnimatorListenerAdapter {
   ValueAnimatorCompatImplHoneycombMr1$2(ValueAnimatorCompatImplHoneycombMr1 var1, ValueAnimatorCompat$Impl$AnimatorListenerProxy var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public void onAnimationCancel(Animator var1) {
      this.val$listener.onAnimationCancel();
   }

   public void onAnimationEnd(Animator var1) {
      this.val$listener.onAnimationEnd();
   }

   public void onAnimationStart(Animator var1) {
      this.val$listener.onAnimationStart();
   }
}
