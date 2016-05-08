package android.support.v4.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper;
import android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1;
import android.support.v4.animation.ValueAnimatorCompat;
import android.view.View;

class HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
   final Animator mWrapped;

   public HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat(Animator var1) {
      this.mWrapped = var1;
   }

   public void addListener(AnimatorListenerCompat var1) {
      this.mWrapped.addListener(new HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper(var1, this));
   }

   public void addUpdateListener(AnimatorUpdateListenerCompat var1) {
      if(this.mWrapped instanceof ValueAnimator) {
         ((ValueAnimator)this.mWrapped).addUpdateListener(new HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1(this, var1));
      }

   }

   public void cancel() {
      this.mWrapped.cancel();
   }

   public float getAnimatedFraction() {
      return ((ValueAnimator)this.mWrapped).getAnimatedFraction();
   }

   public void setDuration(long var1) {
      this.mWrapped.setDuration(var1);
   }

   public void setTarget(View var1) {
      this.mWrapped.setTarget(var1);
   }

   public void start() {
      this.mWrapped.start();
   }
}
