/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bn;

public final class bq {
    final /* synthetic */ bn a;
    private final String b;
    private final long c;
    private boolean d;
    private long e;

    public bq(bn bn2, String string, long l2) {
        this.a = bn2;
        bf.a(string);
        this.b = string;
        this.c = l2;
    }

    private void b() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.e = bn.a(this.a).getLong(this.b, this.c);
    }

    public long a() {
        this.b();
        return this.e;
    }

    public void a(long l2) {
        SharedPreferences.Editor editor = bn.a(this.a).edit();
        editor.putLong(this.b, l2);
        editor.apply();
        this.e = l2;
    }
}

