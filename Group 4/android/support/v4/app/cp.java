/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.bm;
import android.widget.RemoteViews;

public class cp
implements bm {
    private Notification.Builder a;

    public cp(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int n2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int n3, int n4, boolean bl2) {
        Notification.Builder builder = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl3 = (2 & notification.flags) != 0;
        Notification.Builder builder2 = builder.setOngoing(bl3);
        boolean bl4 = (8 & notification.flags) != 0;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl4);
        boolean bl5 = (16 & notification.flags) != 0;
        Notification.Builder builder4 = builder3.setAutoCancel(bl5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        boolean bl6 = (128 & notification.flags) != 0;
        this.a = builder4.setFullScreenIntent(pendingIntent2, bl6).setLargeIcon(bitmap).setNumber(n2).setProgress(n3, n4, bl2);
    }

    @Override
    public Notification.Builder a() {
        return this.a;
    }

    @Override
    public Notification b() {
        return this.a.getNotification();
    }
}

