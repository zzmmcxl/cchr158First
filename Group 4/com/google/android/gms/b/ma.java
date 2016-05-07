/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mb;
import com.google.android.gms.b.mc;
import com.google.android.gms.common.api.f;

public final class ma
implements f {
    public static final ma a = new mc().a();
    private final boolean b;
    private final boolean c;
    private final String d;
    private final boolean e;
    private final String f;
    private final boolean g;

    private ma(boolean bl2, boolean bl3, String string, boolean bl4, String string2, boolean bl5) {
        this.b = bl2;
        this.c = bl3;
        this.d = string;
        this.e = bl4;
        this.g = bl5;
        this.f = string2;
    }

    /* synthetic */ ma(boolean bl2, boolean bl3, String string, boolean bl4, String string2, boolean bl5, mb mb2) {
        this(bl2, bl3, string, bl4, string2, bl5);
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }
}

