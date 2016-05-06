package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;

private static class IceCreamSandwichExtender extends BuilderExtender
{
    private IceCreamSandwichExtender() {
        super();
    }
    
    IceCreamSandwichExtender(final NotificationCompat$1 object) {
        this();
    }
    
    @Override
    public Notification build(final Builder builder, final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        NotificationCompat.access$300(notificationBuilderWithBuilderAccessor, builder);
        return notificationBuilderWithBuilderAccessor.build();
    }
}
