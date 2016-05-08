package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatJellybeanMr1;

class DrawableCompat$JellybeanMr1DrawableImpl extends DrawableCompat$HoneycombDrawableImpl {
   public int getLayoutDirection(Drawable var1) {
      int var2 = DrawableCompatJellybeanMr1.getLayoutDirection(var1);
      return var2 >= 0?var2:0;
   }

   public void setLayoutDirection(Drawable var1, int var2) {
      DrawableCompatJellybeanMr1.setLayoutDirection(var1, var2);
   }
}
