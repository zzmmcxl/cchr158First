package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;

class HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper implements AnimatorListener {
   final ValueAnimatorCompat mValueAnimatorCompat;
   final AnimatorListenerCompat mWrapped;

   public HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper(AnimatorListenerCompat var1, ValueAnimatorCompat var2) {
      this.mWrapped = var1;
      this.mValueAnimatorCompat = var2;
   }

   public void onAnimationCancel(Animator var1) {
      this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
   }

   public void onAnimationEnd(Animator var1) {
      this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
   }

   public void onAnimationRepeat(Animator var1) {
      this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
   }

   public void onAnimationStart(Animator var1) {
      this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
   }
}
