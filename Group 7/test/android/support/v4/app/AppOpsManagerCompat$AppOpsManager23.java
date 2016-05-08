package android.support.v4.app;

import android.content.Context;
import android.support.v4.app.AppOpsManagerCompat$1;
import android.support.v4.app.AppOpsManagerCompat$AppOpsManagerImpl;
import android.support.v4.app.AppOpsManagerCompat23;

class AppOpsManagerCompat$AppOpsManager23 extends AppOpsManagerCompat$AppOpsManagerImpl {
   private AppOpsManagerCompat$AppOpsManager23() {
      super((AppOpsManagerCompat$1)null);
   }

   public int noteOp(Context var1, String var2, int var3, String var4) {
      return AppOpsManagerCompat23.noteOp(var1, var2, var3, var4);
   }

   public int noteProxyOp(Context var1, String var2, String var3) {
      return AppOpsManagerCompat23.noteProxyOp(var1, var2, var3);
   }

   public String permissionToOp(String var1) {
      return AppOpsManagerCompat23.permissionToOp(var1);
   }
}
