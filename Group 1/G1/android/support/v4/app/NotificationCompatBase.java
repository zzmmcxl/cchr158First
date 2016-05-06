package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Context;
import android.app.Notification;

public class NotificationCompatBase
{
    public NotificationCompatBase() {
        super();
    }
    
    public static Notification add(final Notification notification, final Context context, final CharSequence charSequence, final CharSequence charSequence2, final PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
