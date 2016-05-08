package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

class ActivityOptionsCompat21 {
   private final ActivityOptions mActivityOptions;

   private ActivityOptionsCompat21(ActivityOptions var1) {
      this.mActivityOptions = var1;
   }

   public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity var0, View var1, String var2) {
      return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(var0, var1, var2));
   }

   public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity var0, View[] var1, String[] var2) {
      Pair[] var4 = null;
      if(var1 != null) {
         Pair[] var5 = new Pair[var1.length];
         int var3 = 0;

         while(true) {
            var4 = var5;
            if(var3 >= var5.length) {
               break;
            }

            var5[var3] = Pair.create(var1[var3], var2[var3]);
            ++var3;
         }
      }

      return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(var0, var4));
   }

   public Bundle toBundle() {
      return this.mActivityOptions.toBundle();
   }

   public void update(ActivityOptionsCompat21 var1) {
      this.mActivityOptions.update(var1.mActivityOptions);
   }
}
