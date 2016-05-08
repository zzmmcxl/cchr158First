package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompatSideChannelService$1;
import android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub;

public abstract class NotificationCompatSideChannelService extends Service {
   private void checkPermission(int var1, String var2) {
      String[] var5 = this.getPackageManager().getPackagesForUid(var1);
      int var4 = var5.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         if(var5[var3].equals(var2)) {
            return;
         }
      }

      throw new SecurityException("NotificationSideChannelService: Uid " + var1 + " is not authorized for package " + var2);
   }

   public abstract void cancel(String var1, int var2, String var3);

   public abstract void cancelAll(String var1);

   public abstract void notify(String var1, int var2, String var3, Notification var4);

   public IBinder onBind(Intent var1) {
      return var1.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL") && VERSION.SDK_INT <= 19?new NotificationCompatSideChannelService$NotificationSideChannelStub(this, (NotificationCompatSideChannelService$1)null):null;
   }
}
