package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat$1;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompatBase$Action$Factory;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;

final class NotificationCompat$Action$1 implements NotificationCompatBase$Action$Factory {
   public NotificationCompat$Action build(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInputCompatBase$RemoteInput[] var5) {
      return new NotificationCompat$Action(var1, var2, var3, var4, (RemoteInput[])((RemoteInput[])var5), (NotificationCompat$1)null);
   }

   public NotificationCompat$Action[] newArray(int var1) {
      return new NotificationCompat$Action[var1];
   }
}
