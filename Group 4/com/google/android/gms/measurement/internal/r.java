/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.p;

class r
implements Runnable {
    final /* synthetic */ ComponentName a;
    final /* synthetic */ p b;

    r(p p2, ComponentName componentName) {
        this.b = p2;
        this.a = componentName;
    }

    @Override
    public void run() {
        i.a(this.b.a, this.a);
    }
}

