package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;

private static class LollipopExtender extends BuilderExtender
{
    private LollipopExtender() {
        super();
    }
    
    LollipopExtender(final NotificationCompat$1 object) {
        this();
    }
    
    @Override
    public Notification build(final Builder builder, final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        NotificationCompat.access$500(notificationBuilderWithBuilderAccessor, builder.mStyle);
        return notificationBuilderWithBuilderAccessor.build();
    }
}
