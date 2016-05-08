package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatBase$Action;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;

public interface NotificationCompatBase$Action$Factory {
   NotificationCompatBase$Action build(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInputCompatBase$RemoteInput[] var5);

   NotificationCompatBase$Action[] newArray(int var1);
}
