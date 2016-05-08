package android.support.v4.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat;

class HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1 implements AnimatorUpdateListener {
   HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1(HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat var1, AnimatorUpdateListenerCompat var2) {
      this.this$0 = var1;
      this.val$animatorUpdateListener = var2;
   }

   public void onAnimationUpdate(ValueAnimator var1) {
      this.val$animatorUpdateListener.onAnimationUpdate(this.this$0);
   }
}
