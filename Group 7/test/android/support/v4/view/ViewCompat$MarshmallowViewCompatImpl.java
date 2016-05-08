package android.support.v4.view;

import android.support.v4.view.ViewCompat$LollipopViewCompatImpl;
import android.support.v4.view.ViewCompatMarshmallow;
import android.view.View;

class ViewCompat$MarshmallowViewCompatImpl extends ViewCompat$LollipopViewCompatImpl {
   public int getScrollIndicators(View var1) {
      return ViewCompatMarshmallow.getScrollIndicators(var1);
   }

   public void offsetLeftAndRight(View var1, int var2) {
      ViewCompatMarshmallow.offsetLeftAndRight(var1, var2);
   }

   public void offsetTopAndBottom(View var1, int var2) {
      ViewCompatMarshmallow.offsetTopAndBottom(var1, var2);
   }

   public void setScrollIndicators(View var1, int var2) {
      ViewCompatMarshmallow.setScrollIndicators(var1, var2);
   }

   public void setScrollIndicators(View var1, int var2, int var3) {
      ViewCompatMarshmallow.setScrollIndicators(var1, var2, var3);
   }
}
