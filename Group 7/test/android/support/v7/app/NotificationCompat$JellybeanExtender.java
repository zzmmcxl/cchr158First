package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v7.app.NotificationCompat;

class NotificationCompat$JellybeanExtender extends NotificationCompat$BuilderExtender {
   private NotificationCompat$JellybeanExtender() {
   }

   public Notification build(android.support.v4.app.NotificationCompat$Builder var1, NotificationBuilderWithBuilderAccessor var2) {
      NotificationCompat.access$300(var2, var1);
      Notification var3 = var2.build();
      NotificationCompat.access$400(var3, var1);
      return var3;
   }
}
