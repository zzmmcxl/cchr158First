package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.ActivityOptionsCompat21;

class ActivityOptionsCompat$ActivityOptionsImpl21 extends ActivityOptionsCompat {
   private final ActivityOptionsCompat21 mImpl;

   ActivityOptionsCompat$ActivityOptionsImpl21(ActivityOptionsCompat21 var1) {
      this.mImpl = var1;
   }

   public Bundle toBundle() {
      return this.mImpl.toBundle();
   }

   public void update(ActivityOptionsCompat var1) {
      if(var1 instanceof ActivityOptionsCompat$ActivityOptionsImpl21) {
         ActivityOptionsCompat$ActivityOptionsImpl21 var2 = (ActivityOptionsCompat$ActivityOptionsImpl21)var1;
         this.mImpl.update(var2.mImpl);
      }

   }
}
