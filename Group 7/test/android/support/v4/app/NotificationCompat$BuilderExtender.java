package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$Builder;

public class NotificationCompat$BuilderExtender {
   public Notification build(NotificationCompat$Builder var1, NotificationBuilderWithBuilderAccessor var2) {
      return var2.build();
   }
}
