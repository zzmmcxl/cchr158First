package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

interface DrawerLayout$DrawerLayoutCompatImpl {
   void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3);

   void configureApplyInsets(View var1);

   void dispatchChildInsets(View var1, Object var2, int var3);

   Drawable getDefaultStatusBarBackground(Context var1);

   int getTopInset(Object var1);
}
