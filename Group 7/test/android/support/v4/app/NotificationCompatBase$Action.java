package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;

public abstract class NotificationCompatBase$Action {
   public abstract PendingIntent getActionIntent();

   public abstract Bundle getExtras();

   public abstract int getIcon();

   public abstract RemoteInputCompatBase$RemoteInput[] getRemoteInputs();

   public abstract CharSequence getTitle();
}
