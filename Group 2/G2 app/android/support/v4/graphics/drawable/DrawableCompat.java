package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompatApi22;
import android.support.v4.graphics.drawable.DrawableCompatBase;
import android.support.v4.graphics.drawable.DrawableCompatHoneycomb;
import android.support.v4.graphics.drawable.DrawableCompatKitKat;
import android.support.v4.graphics.drawable.DrawableCompatLollipop;
import android.support.v4.graphics.drawable.DrawableWrapper;

public class DrawableCompat {
   static final DrawableCompat.DrawableImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 22) {
         IMPL = new DrawableCompat.LollipopMr1DrawableImpl();
      } else if(var0 >= 21) {
         IMPL = new DrawableCompat.LollipopDrawableImpl();
      } else if(var0 >= 19) {
         IMPL = new DrawableCompat.KitKatDrawableImpl();
      } else if(var0 >= 11) {
         IMPL = new DrawableCompat.HoneycombDrawableImpl();
      } else {
         IMPL = new DrawableCompat.BaseDrawableImpl();
      }
   }

   public static boolean isAutoMirrored(Drawable var0) {
      return IMPL.isAutoMirrored(var0);
   }

   public static void jumpToCurrentState(Drawable var0) {
      IMPL.jumpToCurrentState(var0);
   }

   public static void setAutoMirrored(Drawable var0, boolean var1) {
      IMPL.setAutoMirrored(var0, var1);
   }

   public static void setHotspot(Drawable var0, float var1, float var2) {
      IMPL.setHotspot(var0, var1, var2);
   }

   public static void setHotspotBounds(Drawable var0, int var1, int var2, int var3, int var4) {
      IMPL.setHotspotBounds(var0, var1, var2, var3, var4);
   }

   public static void setTint(Drawable var0, int var1) {
      IMPL.setTint(var0, var1);
   }

   public static void setTintList(Drawable var0, ColorStateList var1) {
      IMPL.setTintList(var0, var1);
   }

   public static void setTintMode(Drawable var0, Mode var1) {
      IMPL.setTintMode(var0, var1);
   }

   public static Drawable unwrap(Drawable var0) {
      Drawable var1 = var0;
      if(var0 instanceof DrawableWrapper) {
         var1 = ((DrawableWrapper)var0).getWrappedDrawable();
      }

      return var1;
   }

   public static Drawable wrap(Drawable var0) {
      return IMPL.wrap(var0);
   }

   static class BaseDrawableImpl implements DrawableCompat.DrawableImpl {
      public boolean isAutoMirrored(Drawable var1) {
         return false;
      }

      public void jumpToCurrentState(Drawable var1) {
      }

      public void setAutoMirrored(Drawable var1, boolean var2) {
      }

      public void setHotspot(Drawable var1, float var2, float var3) {
      }

      public void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5) {
      }

      public void setTint(Drawable var1, int var2) {
         DrawableCompatBase.setTint(var1, var2);
      }

      public void setTintList(Drawable var1, ColorStateList var2) {
         DrawableCompatBase.setTintList(var1, var2);
      }

      public void setTintMode(Drawable var1, Mode var2) {
         DrawableCompatBase.setTintMode(var1, var2);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatBase.wrapForTinting(var1);
      }
   }

   interface DrawableImpl {
      boolean isAutoMirrored(Drawable var1);

      void jumpToCurrentState(Drawable var1);

      void setAutoMirrored(Drawable var1, boolean var2);

      void setHotspot(Drawable var1, float var2, float var3);

      void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5);

      void setTint(Drawable var1, int var2);

      void setTintList(Drawable var1, ColorStateList var2);

      void setTintMode(Drawable var1, Mode var2);

      Drawable wrap(Drawable var1);
   }

   static class HoneycombDrawableImpl extends DrawableCompat.BaseDrawableImpl {
      public void jumpToCurrentState(Drawable var1) {
         DrawableCompatHoneycomb.jumpToCurrentState(var1);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatHoneycomb.wrapForTinting(var1);
      }
   }

   static class KitKatDrawableImpl extends DrawableCompat.HoneycombDrawableImpl {
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

   static class LollipopDrawableImpl extends DrawableCompat.KitKatDrawableImpl {
      public void setHotspot(Drawable var1, float var2, float var3) {
         DrawableCompatLollipop.setHotspot(var1, var2, var3);
      }

      public void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5) {
         DrawableCompatLollipop.setHotspotBounds(var1, var2, var3, var4, var5);
      }

      public void setTint(Drawable var1, int var2) {
         DrawableCompatLollipop.setTint(var1, var2);
      }

      public void setTintList(Drawable var1, ColorStateList var2) {
         DrawableCompatLollipop.setTintList(var1, var2);
      }

      public void setTintMode(Drawable var1, Mode var2) {
         DrawableCompatLollipop.setTintMode(var1, var2);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatLollipop.wrapForTinting(var1);
      }
   }

   static class LollipopMr1DrawableImpl extends DrawableCompat.LollipopDrawableImpl {
      public Drawable wrap(Drawable var1) {
         return DrawableCompatApi22.wrapForTinting(var1);
      }
   }
}
