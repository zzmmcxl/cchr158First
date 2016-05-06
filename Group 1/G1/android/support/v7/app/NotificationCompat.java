package android.support.v7.app;

import android.support.v4.media.session.MediaSessionCompat;
import android.app.PendingIntent;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.List;
import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;

public class NotificationCompat extends android.support.v4.app.NotificationCompat
{
    public NotificationCompat() {
        super();
    }
    
    static /* synthetic */ void access$300(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final android.support.v4.app.NotificationCompat.Builder builder) {
        addMediaStyleToBuilderIcs(notificationBuilderWithBuilderAccessor, builder);
    }
    
    static /* synthetic */ void access$400(final Notification notification, final android.support.v4.app.NotificationCompat.Builder builder) {
        addBigMediaStyleToBuilderJellybean(notification, builder);
    }
    
    static /* synthetic */ void access$500(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final Style style) {
        addMediaStyleToBuilderLollipop(notificationBuilderWithBuilderAccessor, style);
    }
    
    private static void addBigMediaStyleToBuilderJellybean(final Notification notification, final android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            final MediaStyle mediaStyle = (MediaStyle)builder.mStyle;
            android.support.v7.app.NotificationCompatImplBase.<Action>overrideBigContentView(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent);
        }
    }
    
    private static void addMediaStyleToBuilderIcs(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            final MediaStyle mediaStyle = (MediaStyle)builder.mStyle;
            android.support.v7.app.NotificationCompatImplBase.<Action>overrideContentView(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediaStyle.mActionsToShowInCompact, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent);
        }
    }
    
    private static void addMediaStyleToBuilderLollipop(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final Style style) {
        if (style instanceof MediaStyle) {
            final MediaStyle mediaStyle = (MediaStyle)style;
            final int[] mActionsToShowInCompact = mediaStyle.mActionsToShowInCompact;
            Object token;
            if (mediaStyle.mToken != null) {
                token = mediaStyle.mToken.getToken();
            }
            else {
                token = null;
            }
            NotificationCompatImpl21.addMediaStyle(notificationBuilderWithBuilderAccessor, mActionsToShowInCompact, token);
        }
    }
}
