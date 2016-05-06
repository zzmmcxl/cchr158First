package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

static class ImplEclair extends ImplBase
{
    ImplEclair() {
        super();
    }
    
    @Override
    public void cancelNotification(final NotificationManager notificationManager, final String s, final int n) {
        NotificationManagerCompatEclair.cancelNotification(notificationManager, s, n);
    }
    
    @Override
    public void postNotification(final NotificationManager notificationManager, final String s, final int n, final Notification notification) {
        NotificationManagerCompatEclair.postNotification(notificationManager, s, n, notification);
    }
}
