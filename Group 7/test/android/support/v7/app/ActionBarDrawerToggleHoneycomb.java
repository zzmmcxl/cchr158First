package android.support.v7.app;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;
import android.util.Log;

class ActionBarDrawerToggleHoneycomb {
   private static final String TAG = "ActionBarDrawerToggleHoneycomb";
   private static final int[] THEME_ATTRS = new int[]{16843531};

   public static Drawable getThemeUpIndicator(Activity var0) {
      TypedArray var2 = var0.obtainStyledAttributes(THEME_ATTRS);
      Drawable var1 = var2.getDrawable(0);
      var2.recycle();
      return var1;
   }

   public static ActionBarDrawerToggleHoneycomb$SetIndicatorInfo setActionBarDescription(ActionBarDrawerToggleHoneycomb$SetIndicatorInfo var0, Activity var1, int var2) {
      ActionBarDrawerToggleHoneycomb$SetIndicatorInfo var3 = var0;
      if(var0 == null) {
         var3 = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(var1);
      }

      if(var3.setHomeAsUpIndicator != null) {
         try {
            android.app.ActionBar var5 = var1.getActionBar();
            var3.setHomeActionContentDescription.invoke(var5, new Object[]{Integer.valueOf(var2)});
            if(VERSION.SDK_INT <= 19) {
               var5.setSubtitle(var5.getSubtitle());
            }
         } catch (Exception var4) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set content description via JB-MR2 API", var4);
            return var3;
         }
      }

      return var3;
   }

   public static ActionBarDrawerToggleHoneycomb$SetIndicatorInfo setActionBarUpIndicator(ActionBarDrawerToggleHoneycomb$SetIndicatorInfo var0, Activity var1, Drawable var2, int var3) {
      var0 = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(var1);
      if(var0.setHomeAsUpIndicator != null) {
         try {
            android.app.ActionBar var5 = var1.getActionBar();
            var0.setHomeAsUpIndicator.invoke(var5, new Object[]{var2});
            var0.setHomeActionContentDescription.invoke(var5, new Object[]{Integer.valueOf(var3)});
            return var0;
         } catch (Exception var4) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator via JB-MR2 API", var4);
            return var0;
         }
      } else if(var0.upIndicatorView != null) {
         var0.upIndicatorView.setImageDrawable(var2);
         return var0;
      } else {
         Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator");
         return var0;
      }
   }
}
