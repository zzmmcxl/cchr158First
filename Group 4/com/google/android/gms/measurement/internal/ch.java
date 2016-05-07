/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.cc;

class ch
implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ UserAttributeParcel b;
    final /* synthetic */ cc c;

    ch(cc cc2, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.c = cc2;
        this.a = appMetadata;
        this.b = userAttributeParcel;
    }

    @Override
    public void run() {
        this.c.a(this.a.h);
        cc.a(this.c).a(this.b, this.a);
    }
}

