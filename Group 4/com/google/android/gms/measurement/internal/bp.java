/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.bn;

public final class bp {
    final /* synthetic */ bn a;
    private final String b;
    private final boolean c;
    private boolean d;
    private boolean e;

    public bp(bn bn2, String string, boolean bl2) {
        this.a = bn2;
        bf.a(string);
        this.b = string;
        this.c = bl2;
    }

    private void b() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.e = bn.a(this.a).getBoolean(this.b, this.c);
    }

    public void a(boolean bl2) {
        SharedPreferences.Editor editor = bn.a(this.a).edit();
        editor.putBoolean(this.b, bl2);
        editor.apply();
        this.e = bl2;
    }

    public boolean a() {
        this.b();
        return this.e;
    }
}

