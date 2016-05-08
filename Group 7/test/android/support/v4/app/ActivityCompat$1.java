package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat$OnRequestPermissionsResultCallback;

final class ActivityCompat$1 implements Runnable {
   ActivityCompat$1(String[] var1, Activity var2, int var3) {
      this.val$permissions = var1;
      this.val$activity = var2;
      this.val$requestCode = var3;
   }

   public void run() {
      int[] var3 = new int[this.val$permissions.length];
      PackageManager var4 = this.val$activity.getPackageManager();
      String var5 = this.val$activity.getPackageName();
      int var2 = this.val$permissions.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         var3[var1] = var4.checkPermission(this.val$permissions[var1], var5);
      }

      ((ActivityCompat$OnRequestPermissionsResultCallback)this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, var3);
   }
}
