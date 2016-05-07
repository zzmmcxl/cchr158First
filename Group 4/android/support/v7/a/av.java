/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.bm;
import android.support.v4.app.bn;
import android.support.v4.app.bs;
import android.support.v4.app.ce;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v7.a.bb;
import android.support.v7.a.bc;
import android.support.v7.a.bd;
import java.util.ArrayList;

public class av
extends bn {
    static /* synthetic */ void a(Notification notification, bs bs2) {
        av.b(notification, bs2);
    }

    static /* synthetic */ void a(bm bm2, bs bs2) {
        av.b(bm2, bs2);
    }

    private static void b(Notification notification, bs bs2) {
        if (!(bs2.m instanceof bb)) return;
        bb bb2 = (bb)bs2.m;
        bd.a(notification, bs2.a, bs2.b, bs2.c, bs2.h, bs2.i, bs2.g, bs2.n, bs2.l, bs2.B.when, bs2.u, bb2.c, bb2.g);
    }

    private static void b(bm bm2, bs bs2) {
        if (!(bs2.m instanceof bb)) return;
        bb bb2 = (bb)bs2.m;
        bd.a(bm2, bs2.a, bs2.b, bs2.c, bs2.h, bs2.i, bs2.g, bs2.n, bs2.l, bs2.B.when, bs2.u, bb2.a, bb2.c, bb2.g);
    }

    static /* synthetic */ void b(bm bm2, ce ce2) {
        av.c(bm2, ce2);
    }

    private static void c(bm bm2, ce ce2) {
        if (!(ce2 instanceof bb)) return;
        bb bb2 = (bb)ce2;
        int[] arrn = bb2.a;
        Object object = bb2.b != null ? bb2.b.a() : null;
        bc.a(bm2, arrn, object);
    }
}

