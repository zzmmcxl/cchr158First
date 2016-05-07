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
import java.util.List;

public class ct
implements bl,
bm {
    private Notification.Builder a;
    private Bundle b;
    private List c = new ArrayList();

    public ct(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int n2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int n3, int n4, boolean bl2, boolean bl3, boolean bl4, int n5, CharSequence charSequence4, boolean bl5, ArrayList arrayList, Bundle bundle, String string, boolean bl6, String string2) {
        Notification.Builder builder = new Notification.Builder(context).setWhen(notification.when).setShowWhen(bl3).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl7 = (2 & notification.flags) != 0;
        Notification.Builder builder2 = builder.setOngoing(bl7);
        boolean bl8 = (8 & notification.flags) != 0;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl8);
        boolean bl9 = (16 & notification.flags) != 0;
        Notification.Builder builder4 = builder3.setAutoCancel(bl9).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        boolean bl10 = (128 & notification.flags) != 0;
        this.a = builder4.setFullScreenIntent(pendingIntent2, bl10).setLargeIcon(bitmap).setNumber(n2).setUsesChronometer(bl4).setPriority(n5).setProgress(n3, n4, bl2);
        this.b = new Bundle();
        if (bundle != null) {
            this.b.putAll(bundle);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            this.b.putStringArray("android.people", arrayList.toArray(new String[arrayList.size()]));
        }
        if (bl5) {
            this.b.putBoolean("android.support.localOnly", true);
        }
        if (string != null) {
            this.b.putString("android.support.groupKey", string);
            if (bl6) {
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
        SparseArray sparseArray = cq.a(this.c);
        if (sparseArray != null) {
            this.b.putSparseParcelableArray("android.support.actionExtras", sparseArray);
        }
        this.a.setExtras(this.b);
        return this.a.build();
    }
}

