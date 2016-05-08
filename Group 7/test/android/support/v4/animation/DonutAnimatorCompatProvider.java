package android.support.v4.animation;

import android.support.v4.animation.AnimatorProvider;
import android.support.v4.animation.DonutAnimatorCompatProvider$DonutFloatValueAnimator;
import android.support.v4.animation.ValueAnimatorCompat;
import android.view.View;

class DonutAnimatorCompatProvider implements AnimatorProvider {
   public void clearInterpolator(View var1) {
   }

   public ValueAnimatorCompat emptyValueAnimator() {
      return new DonutAnimatorCompatProvider$DonutFloatValueAnimator();
   }
}
