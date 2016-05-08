package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$LollipopDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatApi23;

class DrawableCompat$MDrawableImpl extends DrawableCompat$LollipopDrawableImpl {
   public int getLayoutDirection(Drawable var1) {
      return DrawableCompatApi23.getLayoutDirection(var1);
   }

   public void setLayoutDirection(Drawable var1, int var2) {
      DrawableCompatApi23.setLayoutDirection(var1, var2);
   }

   public Drawable wrap(Drawable var1) {
      return var1;
   }
}
