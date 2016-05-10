package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;

class DrawableCompatBase {
   public static void setTint(Drawable var0, int var1) {
      if(var0 instanceof DrawableWrapper) {
         ((DrawableWrapper)var0).setTint(var1);
      }

   }

   public static void setTintList(Drawable var0, ColorStateList var1) {
      if(var0 instanceof DrawableWrapper) {
         ((DrawableWrapper)var0).setTintList(var1);
      }

   }

   public static void setTintMode(Drawable var0, Mode var1) {
      if(var0 instanceof DrawableWrapper) {
         ((DrawableWrapper)var0).setTintMode(var1);
      }

   }

   public static Drawable wrapForTinting(Drawable var0) {
      Object var1 = var0;
      if(!(var0 instanceof DrawableWrapperDonut)) {
         var1 = new DrawableWrapperDonut(var0);
      }

      return (Drawable)var1;
   }
}
