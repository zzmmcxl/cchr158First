/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.SystemClock;
import com.google.android.gms.b.kf;

public final class kh
implements kf {
    private static kh a;

    public static kf c() {
        // MONITORENTER : com.google.android.gms.b.kh.class
        if (a == null) {
            a = new kh();
        }
        kh kh2 = a;
        return kh2;
    }

    @Override
    public long a() {
        return System.currentTimeMillis();
    }

    @Override
    public long b() {
        return SystemClock.elapsedRealtime();
    }
}

