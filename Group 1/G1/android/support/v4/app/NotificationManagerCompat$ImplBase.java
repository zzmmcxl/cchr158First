package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

static class ImplBase implements Impl
{
    ImplBase() {
        super();
    }
    
    @Override
    public void cancelNotification(final NotificationManager notificationManager, final String s, final int n) {
        notificationManager.cancel(n);
    }
    
    @Override
    public int getSideChannelBindFlags() {
        return 1;
    }
    
    @Override
    public void postNotification(final NotificationManager notificationManager, final String s, final int n, final Notification notification) {
        notificationManager.notify(n, notification);
    }
}
