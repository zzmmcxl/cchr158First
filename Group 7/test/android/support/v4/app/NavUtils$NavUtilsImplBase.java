package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.NavUtils;
import android.support.v4.app.NavUtils$NavUtilsImpl;
import android.support.v4.content.IntentCompat;
import android.util.Log;

class NavUtils$NavUtilsImplBase implements NavUtils$NavUtilsImpl {
   public Intent getParentActivityIntent(Activity var1) {
      String var2 = NavUtils.getParentActivityName(var1);
      if(var2 == null) {
         return null;
      } else {
         ComponentName var3 = new ComponentName(var1, var2);

         try {
            Intent var5;
            if(NavUtils.getParentActivityName(var1, var3) == null) {
               var5 = IntentCompat.makeMainActivity(var3);
            } else {
               var5 = (new Intent()).setComponent(var3);
            }

            return var5;
         } catch (NameNotFoundException var4) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName \'" + var2 + "\' in manifest");
            return null;
         }
      }
   }

   public String getParentActivityName(Context var1, ActivityInfo var2) {
      String var4;
      if(var2.metaData == null) {
         var4 = null;
      } else {
         String var3 = var2.metaData.getString("android.support.PARENT_ACTIVITY");
         if(var3 == null) {
            return null;
         }

         var4 = var3;
         if(var3.charAt(0) == 46) {
            return var1.getPackageName() + var3;
         }
      }

      return var4;
   }

   public void navigateUpTo(Activity var1, Intent var2) {
      var2.addFlags(67108864);
      var1.startActivity(var2);
      var1.finish();
   }

   public boolean shouldUpRecreateTask(Activity var1, Intent var2) {
      String var3 = var1.getIntent().getAction();
      return var3 != null && !var3.equals("android.intent.action.MAIN");
   }
}
