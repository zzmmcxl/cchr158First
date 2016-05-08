package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl;
import android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase;
import android.support.v4.view.MarginLayoutParamsCompat$MarginLayoutParamsCompatImplJbMr1;
import android.view.ViewGroup.MarginLayoutParams;

public final class MarginLayoutParamsCompat {
   static final MarginLayoutParamsCompat$MarginLayoutParamsCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 17) {
         IMPL = new MarginLayoutParamsCompat$MarginLayoutParamsCompatImplJbMr1();
      } else {
         IMPL = new MarginLayoutParamsCompat$MarginLayoutParamsCompatImplBase();
      }
   }

   public static int getLayoutDirection(MarginLayoutParams var0) {
      int var2 = IMPL.getLayoutDirection(var0);
      int var1 = var2;
      if(var2 != 0) {
         var1 = var2;
         if(var2 != 1) {
            var1 = 0;
         }
      }

      return var1;
   }

   public static int getMarginEnd(MarginLayoutParams var0) {
      return IMPL.getMarginEnd(var0);
   }

   public static int getMarginStart(MarginLayoutParams var0) {
      return IMPL.getMarginStart(var0);
   }

   public static boolean isMarginRelative(MarginLayoutParams var0) {
      return IMPL.isMarginRelative(var0);
   }

   public static void resolveLayoutDirection(MarginLayoutParams var0, int var1) {
      IMPL.resolveLayoutDirection(var0, var1);
   }

   public static void setLayoutDirection(MarginLayoutParams var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setMarginEnd(MarginLayoutParams var0, int var1) {
      IMPL.setMarginEnd(var0, var1);
   }

   public static void setMarginStart(MarginLayoutParams var0, int var1) {
      IMPL.setMarginStart(var0, var1);
   }
}
