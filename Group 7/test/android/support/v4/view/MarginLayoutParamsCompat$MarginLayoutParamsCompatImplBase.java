package android.support.v4.view;

import android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl;
import android.view.ViewGroup.MarginLayoutParams;

class MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl {
   public int getLayoutDirection(MarginLayoutParams var1) {
      return 0;
   }

   public int getMarginEnd(MarginLayoutParams var1) {
      return var1.rightMargin;
   }

   public int getMarginStart(MarginLayoutParams var1) {
      return var1.leftMargin;
   }

   public boolean isMarginRelative(MarginLayoutParams var1) {
      return false;
   }

   public void resolveLayoutDirection(MarginLayoutParams var1, int var2) {
   }

   public void setLayoutDirection(MarginLayoutParams var1, int var2) {
   }

   public void setMarginEnd(MarginLayoutParams var1, int var2) {
      var1.rightMargin = var2;
   }

   public void setMarginStart(MarginLayoutParams var1, int var2) {
      var1.leftMargin = var2;
   }
}
