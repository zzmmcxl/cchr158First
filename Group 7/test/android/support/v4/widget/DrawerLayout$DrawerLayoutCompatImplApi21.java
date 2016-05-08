package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImpl;
import android.support.v4.widget.DrawerLayoutCompatApi21;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

class DrawerLayout$DrawerLayoutCompatImplApi21 implements DrawerLayout$DrawerLayoutCompatImpl {
   public void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3) {
      DrawerLayoutCompatApi21.applyMarginInsets(var1, var2, var3);
   }

   public void configureApplyInsets(View var1) {
      DrawerLayoutCompatApi21.configureApplyInsets(var1);
   }

   public void dispatchChildInsets(View var1, Object var2, int var3) {
      DrawerLayoutCompatApi21.dispatchChildInsets(var1, var2, var3);
   }

   public Drawable getDefaultStatusBarBackground(Context var1) {
      return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(var1);
   }

   public int getTopInset(Object var1) {
      return DrawerLayoutCompatApi21.getTopInset(var1);
   }
}
