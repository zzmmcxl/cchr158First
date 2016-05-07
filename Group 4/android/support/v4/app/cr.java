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
import android.support.v4.app.ck;
import android.support.v4.app.cq;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class cr
implements bl,
bm {
    private Notification.Builder a;
    private final Bundle b;
    private List c = new ArrayList();

    public cr(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int n2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int n3, int n4, boolean bl2, boolean bl3, int n5, CharSequence charSequence4, boolean bl4, Bundle bundle, String string, boolean bl5, String string2) {
        Notification.Builder builder = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl6 = (2 & notification.flags) != 0;
        Notification.Builder builder2 = builder.setOngoing(bl6);
        boolean bl7 = (8 & notification.flags) != 0;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl7);
        boolean bl8 = (16 & notification.flags) != 0;
        Notification.Builder builder4 = builder3.setAutoCancel(bl8).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        boolean bl9 = (128 & notification.flags) != 0;
        this.a = builder4.setFullScreenIntent(pendingIntent2, bl9).setLargeIcon(bitmap).setNumber(n2).setUsesChronometer(bl3).setPriority(n5).setProgress(n3, n4, bl2);
        this.b = new Bundle();
        if (bundle != null) {
            this.b.putAll(bundle);
        }
        if (bl4) {
            this.b.putBoolean("android.support.localOnly", true);
        }
        if (string != null) {
            this.b.putString("android.support.groupKey", string);
            if (bl5) {
                this.b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (string2 == null) return;
        this.b.putString("android.support.sortKey", string2);
    }

    @Override
    public Notification.Builder a() {
        return this.a;
    }

    @Override
    public void a(ck ck2) {
        this.c.add(cq.a(this.a, ck2));
    }

    @Override
    public Notification b() {
        Notification notification = this.a.build();
        Bundle bundle = cq.a(notification);
        Bundle bundle2 = new Bundle(this.b);
        Iterator iterator = this.b.keySet().iterator();
        do {
            if (!iterator.hasNext()) {
                bundle.putAll(bundle2);
                SparseArray sparseArray = cq.a(this.c);
                if (sparseArray == null) return notification;
                cq.a(notification).putSparseParcelableArray("android.support.actionExtras", sparseArray);
                return notification;
            }
            String string = (String)iterator.next();
            if (!bundle.containsKey(string)) continue;
            bundle2.remove(string);
        } while (true);
    }
}

