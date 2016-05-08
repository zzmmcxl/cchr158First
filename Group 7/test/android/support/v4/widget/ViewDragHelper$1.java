package android.support.v4.widget;

import android.view.animation.Interpolator;

final class ViewDragHelper$1 implements Interpolator {
   public float getInterpolation(float var1) {
      --var1;
      return var1 * var1 * var1 * var1 * var1 + 1.0F;
   }
}
