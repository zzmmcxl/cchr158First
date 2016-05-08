package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation;
import android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;

final class NotificationCompat$CarExtender$UnreadConversation$1 implements NotificationCompatBase$UnreadConversation$Factory {
   public NotificationCompat$CarExtender$UnreadConversation build(String[] var1, RemoteInputCompatBase$RemoteInput var2, PendingIntent var3, PendingIntent var4, String[] var5, long var6) {
      return new NotificationCompat$CarExtender$UnreadConversation(var1, (RemoteInput)var2, var3, var4, var5, var6);
   }
}
