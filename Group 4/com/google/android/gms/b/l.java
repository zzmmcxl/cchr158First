/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.Collections;
import java.util.Map;

public class l {
    public byte[] a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long f;
    public Map g = Collections.emptyMap();

    public boolean a() {
        if (this.e >= System.currentTimeMillis()) return false;
        return true;
    }

    public boolean b() {
        if (this.f >= System.currentTimeMillis()) return false;
        return true;
    }
}

