/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;

class cn {
    static Notification a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int n2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap) {
        boolean bl2 = true;
        Notification.Builder builder = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl3 = (2 & notification.flags) != 0 ? bl2 : false;
        Notification.Builder builder2 = builder.setOngoing(bl3);
        boolean bl4 = (8 & notification.flags) != 0 ? bl2 : false;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl4);
        boolean bl5 = (16 & notification.flags) != 0 ? bl2 : false;
        Notification.Builder builder4 = builder3.setAutoCancel(bl5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((128 & notification.flags) != 0) {
            return builder4.setFullScreenIntent(pendingIntent2, bl2).setLargeIcon(bitmap).setNumber(n2).getNotification();
        }
        bl2 = false;
        return builder4.setFullScreenIntent(pendingIntent2, bl2).setLargeIcon(bitmap).setNumber(n2).getNotification();
    }
}

