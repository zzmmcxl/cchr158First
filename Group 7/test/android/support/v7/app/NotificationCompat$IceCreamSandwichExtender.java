package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v7.app.NotificationCompat;

class NotificationCompat$IceCreamSandwichExtender extends NotificationCompat$BuilderExtender {
   private NotificationCompat$IceCreamSandwichExtender() {
   }

   public Notification build(android.support.v4.app.NotificationCompat$Builder var1, NotificationBuilderWithBuilderAccessor var2) {
      NotificationCompat.access$300(var2, var1);
      return var2.build();
   }
}
