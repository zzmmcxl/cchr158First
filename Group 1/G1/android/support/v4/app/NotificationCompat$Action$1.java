package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

static final class NotificationCompat$Action$1 implements Factory {
    NotificationCompat$Action$1() {
        super();
    }
    
    public NotificationCompat.Action build(final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle, final RemoteInputCompatBase.RemoteInput[] array) {
        return new NotificationCompat.Action(n, charSequence, pendingIntent, bundle, (RemoteInput[])array);
    }
    
    @Override
    public /* bridge */ NotificationCompatBase.Action build(final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle, final RemoteInputCompatBase.RemoteInput[] array) {
        return this.build(n, charSequence, pendingIntent, bundle, array);
    }
    
    public NotificationCompat.Action[] newArray(final int n) {
        return new NotificationCompat.Action[n];
    }
    
    @Override
    public /* bridge */ NotificationCompatBase.Action[] newArray(final int n) {
        return this.newArray(n);
    }
}