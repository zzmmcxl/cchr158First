package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImpl21;
import android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB;
import android.support.v4.app.ActivityOptionsCompat21;
import android.support.v4.app.ActivityOptionsCompatJB;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
   public static ActivityOptionsCompat makeCustomAnimation(Context var0, int var1, int var2) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(var0, var1, var2)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeScaleUpAnimation(View var0, int var1, int var2, int var3, int var4) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(var0, var1, var2, var3, var4)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity var0, View var1, String var2) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 21?new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(var0, var1, var2)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity var0, Pair... var1) {
      if(VERSION.SDK_INT < 21) {
         return new ActivityOptionsCompat();
      } else {
         View[] var4 = null;
         String[] var3 = null;
         if(var1 != null) {
            View[] var5 = new View[var1.length];
            String[] var6 = new String[var1.length];
            int var2 = 0;

            while(true) {
               var3 = var6;
               var4 = var5;
               if(var2 >= var1.length) {
                  break;
               }

               var5[var2] = (View)var1[var2].first;
               var6[var2] = (String)var1[var2].second;
               ++var2;
            }
         }

         return new ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(var0, var4, var3));
      }
   }

   public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View var0, Bitmap var1, int var2, int var3) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(var0, var1, var2, var3)):new ActivityOptionsCompat());
   }

   public Bundle toBundle() {
      return null;
   }

   public void update(ActivityOptionsCompat var1) {
   }
}
