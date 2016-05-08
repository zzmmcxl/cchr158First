package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.NavUtils$NavUtilsImplBase;
import android.support.v4.app.NavUtilsJB;

class NavUtils$NavUtilsImplJB extends NavUtils$NavUtilsImplBase {
   public Intent getParentActivityIntent(Activity var1) {
      Intent var3 = NavUtilsJB.getParentActivityIntent(var1);
      Intent var2 = var3;
      if(var3 == null) {
         var2 = this.superGetParentActivityIntent(var1);
      }

      return var2;
   }

   public String getParentActivityName(Context var1, ActivityInfo var2) {
      String var4 = NavUtilsJB.getParentActivityName(var2);
      String var3 = var4;
      if(var4 == null) {
         var3 = super.getParentActivityName(var1, var2);
      }

      return var3;
   }

   public void navigateUpTo(Activity var1, Intent var2) {
      NavUtilsJB.navigateUpTo(var1, var2);
   }

   public boolean shouldUpRecreateTask(Activity var1, Intent var2) {
      return NavUtilsJB.shouldUpRecreateTask(var1, var2);
   }

   Intent superGetParentActivityIntent(Activity var1) {
      return super.getParentActivityIntent(var1);
   }
}
