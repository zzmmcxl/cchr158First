package android.support.v4.app;

import android.app.Notification;

protected static class BuilderExtender
{
    protected BuilderExtender() {
        super();
    }
    
    public Notification build(final NotificationCompat.Builder builder, final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return notificationBuilderWithBuilderAccessor.build();
    }
}
