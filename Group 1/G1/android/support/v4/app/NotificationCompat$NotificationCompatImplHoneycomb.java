package android.support.v4.app;

import android.app.Notification;

static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase
{
    NotificationCompatImplHoneycomb() {
        super();
    }
    
    @Override
    public Notification build(final NotificationCompat.Builder builder, final BuilderExtender builderExtender) {
        return NotificationCompatHoneycomb.add(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon);
    }
}
