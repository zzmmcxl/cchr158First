/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.bm;
import android.support.v4.app.bn;
import android.support.v4.app.bs;
import android.support.v4.app.bt;
import android.support.v4.app.cc;
import android.support.v4.app.ce;
import android.support.v4.app.ct;
import android.widget.RemoteViews;
import java.util.ArrayList;

class cd
extends cc {
    cd() {
    }

    @Override
    public Notification a(bs bs2, bt bt2) {
        ct ct2 = new ct(bs2.a, bs2.B, bs2.b, bs2.c, bs2.h, bs2.f, bs2.i, bs2.d, bs2.e, bs2.g, bs2.o, bs2.p, bs2.q, bs2.k, bs2.l, bs2.j, bs2.n, bs2.v, bs2.C, bs2.x, bs2.r, bs2.s, bs2.t);
        bn.a(ct2, bs2.u);
        bn.a(ct2, bs2.m);
        return bt2.a(bs2, ct2);
    }
}

