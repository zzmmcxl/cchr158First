package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.ActivityOptionsCompatJB;

class ActivityOptionsCompat$ActivityOptionsImplJB extends ActivityOptionsCompat {
   private final ActivityOptionsCompatJB mImpl;

   ActivityOptionsCompat$ActivityOptionsImplJB(ActivityOptionsCompatJB var1) {
      this.mImpl = var1;
   }

   public Bundle toBundle() {
      return this.mImpl.toBundle();
   }

   public void update(ActivityOptionsCompat var1) {
      if(var1 instanceof ActivityOptionsCompat$ActivityOptionsImplJB) {
         ActivityOptionsCompat$ActivityOptionsImplJB var2 = (ActivityOptionsCompat$ActivityOptionsImplJB)var1;
         this.mImpl.update(var2.mImpl);
      }

   }
}
