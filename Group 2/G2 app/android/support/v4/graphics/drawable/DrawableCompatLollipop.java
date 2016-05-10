package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.graphics.drawable.DrawableCompatBase;
import android.support.v4.graphics.drawable.DrawableWrapperLollipop;

class DrawableCompatLollipop {
   public static void setHotspot(Drawable var0, float var1, float var2) {
      var0.setHotspot(var1, var2);
   }

   public static void setHotspotBounds(Drawable var0, int var1, int var2, int var3, int var4) {
      var0.setHotspotBounds(var1, var2, var3, var4);
   }

   public static void setTint(Drawable var0, int var1) {
      if(var0 instanceof DrawableWrapperLollipop) {
         DrawableCompatBase.setTint(var0, var1);
      } else {
         var0.setTint(var1);
      }
   }

   public static void setTintList(Drawable var0, ColorStateList var1) {
      if(var0 instanceof DrawableWrapperLollipop) {
         DrawableCompatBase.setTintList(var0, var1);
      } else {
         var0.setTintList(var1);
      }
   }

   public static void setTintMode(Drawable var0, Mode var1) {
      if(var0 instanceof DrawableWrapperLollipop) {
         DrawableCompatBase.setTintMode(var0, var1);
      } else {
         var0.setTintMode(var1);
      }
   }

   public static Drawable wrapForTinting(Drawable var0) {
      Object var1 = var0;
      if(var0 instanceof GradientDrawable) {
         var1 = new DrawableWrapperLollipop(var0);
      }

      return (Drawable)var1;
   }
}
