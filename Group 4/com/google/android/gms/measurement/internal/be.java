/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.bc;

public class be {
    final /* synthetic */ bc a;
    private final int b;
    private final boolean c;
    private final boolean d;

    be(bc bc2, int n2, boolean bl2, boolean bl3) {
        this.a = bc2;
        this.b = n2;
        this.c = bl2;
        this.d = bl3;
    }

    public void a(String string) {
        this.a.a(this.b, this.c, this.d, string, null, null, null);
    }

    public void a(String string, Object object) {
        this.a.a(this.b, this.c, this.d, string, object, null, null);
    }

    public void a(String string, Object object, Object object2) {
        this.a.a(this.b, this.c, this.d, string, object, object2, null);
    }

    public void a(String string, Object object, Object object2, Object object3) {
        this.a.a(this.b, this.c, this.d, string, object, object2, object3);
    }
}

