package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$EclairDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$JellybeanMr1DrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$LollipopDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompat$MDrawableImpl;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
   static final DrawableCompat$DrawableImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new DrawableCompat$MDrawableImpl();
      } else if(var0 >= 21) {
         IMPL = new DrawableCompat$LollipopDrawableImpl();
      } else if(var0 >= 19) {
         IMPL = new DrawableCompat$KitKatDrawableImpl();
      } else if(var0 >= 17) {
         IMPL = new DrawableCompat$JellybeanMr1DrawableImpl();
      } else if(var0 >= 11) {
         IMPL = new DrawableCompat$HoneycombDrawableImpl();
      } else if(var0 >= 5) {
         IMPL = new DrawableCompat$EclairDrawableImpl();
      } else {
         IMPL = new DrawableCompat$BaseDrawableImpl();
      }
   }

   public static void applyTheme(Drawable var0, Theme var1) {
      IMPL.applyTheme(var0, var1);
   }

   public static boolean canApplyTheme(Drawable var0) {
      return IMPL.canApplyTheme(var0);
   }

   public static int getAlpha(@NonNull Drawable var0) {
      return IMPL.getAlpha(var0);
   }

   public static ColorFilter getColorFilter(Drawable var0) {
      return IMPL.getColorFilter(var0);
   }

   public static int getLayoutDirection(@NonNull Drawable var0) {
      return IMPL.getLayoutDirection(var0);
   }

   public static void inflate(Drawable var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      IMPL.inflate(var0, var1, var2, var3, var4);
   }

   public static boolean isAutoMirrored(@NonNull Drawable var0) {
      return IMPL.isAutoMirrored(var0);
   }

   public static void jumpToCurrentState(@NonNull Drawable var0) {
      IMPL.jumpToCurrentState(var0);
   }

   public static void setAutoMirrored(@NonNull Drawable var0, boolean var1) {
      IMPL.setAutoMirrored(var0, var1);
   }

   public static void setHotspot(@NonNull Drawable var0, float var1, float var2) {
      IMPL.setHotspot(var0, var1, var2);
   }

   public static void setHotspotBounds(@NonNull Drawable var0, int var1, int var2, int var3, int var4) {
      IMPL.setHotspotBounds(var0, var1, var2, var3, var4);
   }

   public static void setLayoutDirection(@NonNull Drawable var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setTint(@NonNull Drawable var0, @ColorInt int var1) {
      IMPL.setTint(var0, var1);
   }

   public static void setTintList(@NonNull Drawable var0, @Nullable ColorStateList var1) {
      IMPL.setTintList(var0, var1);
   }

   public static void setTintMode(@NonNull Drawable var0, @Nullable Mode var1) {
      IMPL.setTintMode(var0, var1);
   }

   public static <T extends Drawable> T unwrap(@NonNull Drawable var0) {
      Drawable var1 = var0;
      if(var0 instanceof DrawableWrapper) {
         var1 = ((DrawableWrapper)var0).getWrappedDrawable();
      }

      return var1;
   }

   public static Drawable wrap(@NonNull Drawable var0) {
      return IMPL.wrap(var0);
   }
}
