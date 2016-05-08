package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R$attr;

class ThemeUtils {
   private static final int[] APPCOMPAT_CHECK_ATTRS;

   static {
      APPCOMPAT_CHECK_ATTRS = new int[]{R$attr.colorPrimary};
   }

   static void checkAppCompatTheme(Context var0) {
      boolean var1 = false;
      TypedArray var2 = var0.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
      if(!var2.hasValue(0)) {
         var1 = true;
      }

      if(var2 != null) {
         var2.recycle();
      }

      if(var1) {
         throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
      }
   }
}
