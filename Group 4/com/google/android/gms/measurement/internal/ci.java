/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.cc;
import java.util.List;
import java.util.concurrent.Callable;

class ci
implements Callable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ cc b;

    ci(cc cc2, AppMetadata appMetadata) {
        this.b = cc2;
        this.a = appMetadata;
    }

    public List a() {
        return cc.a(this.b).n().a(this.a.c);
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

