/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bo;

public final class br {
    final String a;
    final /* synthetic */ bn b;
    private final String c;
    private final String d;
    private final long e;

    private br(bn bn2, String string, long l2) {
        this.b = bn2;
        bf.a(string);
        boolean bl2 = l2 > 0;
        bf.b(bl2);
        this.a = string + ":start";
        this.c = string + ":count";
        this.d = string + ":value";
        this.e = l2;
    }

    /* synthetic */ br(bn bn2, String string, long l2, bo bo2) {
        this(bn2, string, l2);
    }

    private void b() {
        this.b.f();
        long l2 = this.b.l().a();
        SharedPreferences.Editor editor = bn.a(this.b).edit();
        editor.remove(this.c);
        editor.remove(this.d);
        editor.putLong(this.a, l2);
        editor.apply();
    }

    private long c() {
        this.b.f();
        long l2 = this.d();
        if (l2 != 0) return Math.abs(l2 - this.b.l().a());
        this.b();
        return 0;
    }

    private long d() {
        return bn.c(this.b).getLong(this.a, 0);
    }

    public Pair a() {
        this.b.f();
        long l2 = this.c();
        if (l2 < this.e) {
            return null;
        }
        if (l2 > 2 * this.e) {
            this.b();
            return null;
        }
        String string = bn.c(this.b).getString(this.d, null);
        long l3 = bn.c(this.b).getLong(this.c, 0);
        this.b();
        if (string == null) return bn.a;
        if (l3 > 0) return new Pair((Object)string, (Object)l3);
        return bn.a;
    }

    public void a(String string) {
        this.a(string, 1);
    }

    public void a(String string, long l2) {
        long l3;
        this.b.f();
        if (this.d() == 0) {
            this.b();
        }
        if (string == null) {
            string = "";
        }
        if ((l3 = bn.a(this.b).getLong(this.c, 0)) <= 0) {
            SharedPreferences.Editor editor = bn.a(this.b).edit();
            editor.putString(this.d, string);
            editor.putLong(this.c, l2);
            editor.apply();
            return;
        }
        boolean bl2 = (Long.MAX_VALUE & bn.b(this.b).nextLong()) < l2 * (Long.MAX_VALUE / (l3 + l2));
        SharedPreferences.Editor editor = bn.a(this.b).edit();
        if (bl2) {
            editor.putString(this.d, string);
        }
        editor.putLong(this.c, l3 + l2);
        editor.apply();
    }
}

