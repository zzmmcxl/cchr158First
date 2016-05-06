package android.support.v4.app;

import android.app.PendingIntent;

static final class NotificationCompat$CarExtender$UnreadConversation$1 implements Factory {
    NotificationCompat$CarExtender$UnreadConversation$1() {
        super();
    }
    
    public CarExtender.UnreadConversation build(final String[] array, final RemoteInputCompatBase.RemoteInput remoteInput, final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final String[] array2, final long n) {
        return new CarExtender.UnreadConversation(array, (RemoteInput)remoteInput, pendingIntent, pendingIntent2, array2, n);
    }
    
    @Override
    public /* bridge */ NotificationCompatBase.UnreadConversation build(final String[] array, final RemoteInputCompatBase.RemoteInput remoteInput, final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final String[] array2, final long n) {
        return this.build(array, remoteInput, pendingIntent, pendingIntent2, array2, n);
    }
}