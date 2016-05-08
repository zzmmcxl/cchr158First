package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationManagerCompat$ImplBase;
import android.support.v4.app.NotificationManagerCompatEclair;

class NotificationManagerCompat$ImplEclair extends NotificationManagerCompat$ImplBase {
   public void cancelNotification(NotificationManager var1, String var2, int var3) {
      NotificationManagerCompatEclair.cancelNotification(var1, var2, var3);
   }

   public void postNotification(NotificationManager var1, String var2, int var3, Notification var4) {
      NotificationManagerCompatEclair.postNotification(var1, var2, var3, var4);
   }
}
