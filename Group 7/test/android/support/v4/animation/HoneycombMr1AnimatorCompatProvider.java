package android.support.v4.animation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.animation.AnimatorProvider;
import android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.view.View;

class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
   private TimeInterpolator mDefaultInterpolator;

   public void clearInterpolator(View var1) {
      if(this.mDefaultInterpolator == null) {
         this.mDefaultInterpolator = (new ValueAnimator()).getInterpolator();
      }

      var1.animate().setInterpolator(this.mDefaultInterpolator);
   }

   public ValueAnimatorCompat emptyValueAnimator() {
      return new HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[]{0.0F, 1.0F}));
   }
}
