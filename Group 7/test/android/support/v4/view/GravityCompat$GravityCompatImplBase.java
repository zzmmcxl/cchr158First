package android.support.v4.view;

import android.graphics.Rect;
import android.support.v4.view.GravityCompat$GravityCompatImpl;
import android.view.Gravity;

class GravityCompat$GravityCompatImplBase implements GravityCompat$GravityCompatImpl {
   public void apply(int var1, int var2, int var3, Rect var4, int var5, int var6, Rect var7, int var8) {
      Gravity.apply(var1, var2, var3, var4, var5, var6, var7);
   }

   public void apply(int var1, int var2, int var3, Rect var4, Rect var5, int var6) {
      Gravity.apply(var1, var2, var3, var4, var5);
   }

   public void applyDisplay(int var1, Rect var2, Rect var3, int var4) {
      Gravity.applyDisplay(var1, var2, var3);
   }

   public int getAbsoluteGravity(int var1, int var2) {
      return -8388609 & var1;
   }
}
