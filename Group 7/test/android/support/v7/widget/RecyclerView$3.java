package android.support.v7.widget;

import android.view.animation.Interpolator;

final class RecyclerView$3 implements Interpolator {
   public float getInterpolation(float var1) {
      --var1;
      return var1 * var1 * var1 * var1 * var1 + 1.0F;
   }
}
