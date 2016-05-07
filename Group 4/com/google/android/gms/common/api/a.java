/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.bf;

public final class a {
    private final g a;
    private final k b;
    private final i c;
    private final l d;
    private final String e;

    public a(String string, g g2, i i2) {
        bf.a(g2, (Object)"Cannot construct an Api with a null ClientBuilder");
        bf.a(i2, (Object)"Cannot construct an Api with a null ClientKey");
        this.e = string;
        this.a = g2;
        this.b = null;
        this.c = i2;
        this.d = null;
    }

    public g a() {
        boolean bl2 = this.a != null;
        bf.a(bl2, (Object)"This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public k b() {
        boolean bl2 = this.b != null;
        bf.a(bl2, (Object)"This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.b;
    }

    public i c() {
        boolean bl2 = this.c != null;
        bf.a(bl2, (Object)"This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.c;
    }

    public boolean d() {
        if (this.d == null) return false;
        return true;
    }

    public String e() {
        return this.e;
    }
}

