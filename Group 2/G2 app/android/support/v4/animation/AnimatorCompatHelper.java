package android.support.v4.animation;

import android.os.Build.VERSION;
import android.support.v4.animation.AnimatorProvider;
import android.support.v4.animation.DonutAnimatorCompatProvider;
import android.support.v4.animation.HoneycombMr1AnimatorCompatProvider;
import android.support.v4.animation.ValueAnimatorCompat;

public abstract class AnimatorCompatHelper {
   static AnimatorProvider IMPL;

   static {
      if(VERSION.SDK_INT >= 12) {
         IMPL = new HoneycombMr1AnimatorCompatProvider();
      } else {
         IMPL = new DonutAnimatorCompatProvider();
      }
   }

   public static ValueAnimatorCompat emptyValueAnimator() {
      return IMPL.emptyValueAnimator();
   }
}
