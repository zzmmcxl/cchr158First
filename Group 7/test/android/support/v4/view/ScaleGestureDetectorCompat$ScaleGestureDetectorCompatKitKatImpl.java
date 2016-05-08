package android.support.v4.view;

import android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorImpl;
import android.support.v4.view.ScaleGestureDetectorCompatKitKat;

class ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorCompat$ScaleGestureDetectorImpl {
   private ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl() {
   }

   public boolean isQuickScaleEnabled(Object var1) {
      return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(var1);
   }

   public void setQuickScaleEnabled(Object var1, boolean var2) {
      ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(var1, var2);
   }
}
