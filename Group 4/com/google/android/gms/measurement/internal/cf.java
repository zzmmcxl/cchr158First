/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.cc;

class cf
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ String c;
    final /* synthetic */ cc d;

    cf(cc cc2, String string, EventParcel eventParcel, String string2) {
        this.d = cc2;
        this.a = string;
        this.b = eventParcel;
        this.c = string2;
    }

    @Override
    public void run() {
        this.d.a(this.a);
        cc.a(this.d).a(this.b, this.c);
    }
}

