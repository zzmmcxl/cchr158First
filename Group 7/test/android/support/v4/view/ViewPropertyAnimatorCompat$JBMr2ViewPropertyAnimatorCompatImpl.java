package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompatJellybeanMr2;
import android.view.View;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl {
   public Interpolator getInterpolator(ViewPropertyAnimatorCompat var1, View var2) {
      return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(var2);
   }
}
