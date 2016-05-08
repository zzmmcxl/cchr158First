package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayoutCompatApi21$InsetsListener;
import android.support.v4.widget.DrawerLayoutImpl;
import android.view.View;
import android.view.WindowInsets;
import android.view.ViewGroup.MarginLayoutParams;

class DrawerLayoutCompatApi21 {
   private static final int[] THEME_ATTRS = new int[]{16843828};

   public static void applyMarginInsets(MarginLayoutParams var0, Object var1, int var2) {
      WindowInsets var3 = (WindowInsets)var1;
      WindowInsets var4;
      if(var2 == 3) {
         var4 = var3.replaceSystemWindowInsets(var3.getSystemWindowInsetLeft(), var3.getSystemWindowInsetTop(), 0, var3.getSystemWindowInsetBottom());
      } else {
         var4 = var3;
         if(var2 == 5) {
            var4 = var3.replaceSystemWindowInsets(0, var3.getSystemWindowInsetTop(), var3.getSystemWindowInsetRight(), var3.getSystemWindowInsetBottom());
         }
      }

      var0.leftMargin = var4.getSystemWindowInsetLeft();
      var0.topMargin = var4.getSystemWindowInsetTop();
      var0.rightMargin = var4.getSystemWindowInsetRight();
      var0.bottomMargin = var4.getSystemWindowInsetBottom();
   }

   public static void configureApplyInsets(View var0) {
      if(var0 instanceof DrawerLayoutImpl) {
         var0.setOnApplyWindowInsetsListener(new DrawerLayoutCompatApi21$InsetsListener());
         var0.setSystemUiVisibility(1280);
      }

   }

   public static void dispatchChildInsets(View var0, Object var1, int var2) {
      WindowInsets var3 = (WindowInsets)var1;
      WindowInsets var4;
      if(var2 == 3) {
         var4 = var3.replaceSystemWindowInsets(var3.getSystemWindowInsetLeft(), var3.getSystemWindowInsetTop(), 0, var3.getSystemWindowInsetBottom());
      } else {
         var4 = var3;
         if(var2 == 5) {
            var4 = var3.replaceSystemWindowInsets(0, var3.getSystemWindowInsetTop(), var3.getSystemWindowInsetRight(), var3.getSystemWindowInsetBottom());
         }
      }

      var0.dispatchApplyWindowInsets(var4);
   }

   public static Drawable getDefaultStatusBarBackground(Context var0) {
      TypedArray var5 = var0.obtainStyledAttributes(THEME_ATTRS);
      boolean var3 = false;

      Drawable var1;
      try {
         var3 = true;
         var1 = var5.getDrawable(0);
         var3 = false;
      } finally {
         if(var3) {
            var5.recycle();
         }
      }

      var5.recycle();
      return var1;
   }

   public static int getTopInset(Object var0) {
      return var0 != null?((WindowInsets)var0).getSystemWindowInsetTop():0;
   }
}
