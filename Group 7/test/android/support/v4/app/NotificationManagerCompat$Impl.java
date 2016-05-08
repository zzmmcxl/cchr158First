package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

interface NotificationManagerCompat$Impl {
   void cancelNotification(NotificationManager var1, String var2, int var3);

   int getSideChannelBindFlags();

   void postNotification(NotificationManager var1, String var2, int var3, Notification var4);
}
