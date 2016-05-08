package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationManagerCompat$Impl;

class NotificationManagerCompat$ImplBase implements NotificationManagerCompat$Impl {
   public void cancelNotification(NotificationManager var1, String var2, int var3) {
      var1.cancel(var3);
   }

   public int getSideChannelBindFlags() {
      return 1;
   }

   public void postNotification(NotificationManager var1, String var2, int var3, Notification var4) {
      var1.notify(var3, var4);
   }
}
