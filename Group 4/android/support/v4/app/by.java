/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.bs;
import android.support.v4.app.bt;
import android.support.v4.app.bv;
import android.support.v4.app.cj;

class by
implements bv {
    by() {
    }

    @Override
    public Notification a(bs bs2, bt bt2) {
        Notification notification = cj.a(bs2.B, bs2.a, bs2.b, bs2.c, bs2.d);
        if (bs2.j <= 0) return notification;
        notification.flags = 128 | notification.flags;
        return notification;
    }
}

