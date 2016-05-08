package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$JellybeanMr1DrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatKitKat;

class DrawableCompat$KitKatDrawableImpl extends DrawableCompat$JellybeanMr1DrawableImpl {
   public int getAlpha(Drawable var1) {
      return DrawableCompatKitKat.getAlpha(var1);
   }

   public boolean isAutoMirrored(Drawable var1) {
      return DrawableCompatKitKat.isAutoMirrored(var1);
   }

   public void setAutoMirrored(Drawable var1, boolean var2) {
      DrawableCompatKitKat.setAutoMirrored(var1, var2);
   }

   public Drawable wrap(Drawable var1) {
      return DrawableCompatKitKat.wrapForTinting(var1);
   }
}
