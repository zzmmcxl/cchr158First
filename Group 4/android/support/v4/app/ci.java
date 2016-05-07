/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.bl;
import android.support.v4.app.bm;
import android.support.v4.app.cf;
import android.support.v4.app.ck;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class ci
implements bl,
bm {
    private Notification.Builder a;

    public ci(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int n2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int n3, int n4, boolean bl2, boolean bl3, boolean bl4, int n5, CharSequence charSequence4, boolean bl5, String string, ArrayList arrayList, Bundle bundle, int n6, int n7, Notification notification2, String string2, boolean bl6, String string3) {
        Notification.Builder builder = new Notification.Builder(context).setWhen(notification.when).setShowWhen(bl3).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl7 = (2 & notification.flags) != 0;
        Notification.Builder builder2 = builder.setOngoing(bl7);
        boolean bl8 = (8 & notification.flags) != 0;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl8);
        boolean bl9 = (16 & notification.flags) != 0;
        Notification.Builder builder4 = builder3.setAutoCancel(bl9).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        boolean bl10 = (128 & notification.flags) != 0;
        this.a = builder4.setFullScreenIntent(pendingIntent2, bl10).setLargeIcon(bitmap).setNumber(n2).setUsesChronometer(bl4).setPriority(n5).setProgress(n3, n4, bl2).setLocalOnly(bl5).setExtras(bundle).setGroup(string2).setGroupSummary(bl6).setSortKey(string3).setCategory(string).setColor(n6).setVisibility(n7).setPublicVersion(notification2);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String string4 = (String)iterator.next();
            this.a.addPerson(string4);
        }
    }

    @Override
    public Notification.Builder a() {
        return this.a;
    }

    @Override
    public void a(ck ck2) {
        cf.a(this.a, ck2);
    }

    @Override
    public Notification b() {
        return this.a.build();
    }
}

