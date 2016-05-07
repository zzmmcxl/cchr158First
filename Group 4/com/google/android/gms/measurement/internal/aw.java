/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.b.je;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.f;

public final class aw {
    private final Object a;
    private final je b;
    private Object c;
    private final String d;

    private aw(String string, je je2, Object object) {
        bf.a(je2);
        this.b = je2;
        this.a = object;
        this.d = string;
    }

    static aw a(String string, int n2) {
        return aw.a(string, n2, n2);
    }

    static aw a(String string, int n2, int n3) {
        return new aw(string, je.a(string, n3), n2);
    }

    static aw a(String string, long l2) {
        return aw.a(string, l2, l2);
    }

    static aw a(String string, long l2, long l3) {
        return new aw(string, je.a(string, l3), l2);
    }

    static aw a(String string, String string2) {
        return aw.a(string, string2, string2);
    }

    static aw a(String string, String string2, String string3) {
        return new aw(string, je.a(string, string3), string2);
    }

    static aw a(String string, boolean bl2) {
        return aw.a(string, bl2, bl2);
    }

    static aw a(String string, boolean bl2, boolean bl3) {
        return new aw(string, je.a(string, bl3), bl2);
    }

    public Object a(Object object) {
        if (this.c != null) {
            return this.c;
        }
        if (object != null) return object;
        if (!f.a) return this.a;
        if (!je.b()) return this.a;
        return this.b.d();
    }

    public String a() {
        return this.d;
    }

    public Object b() {
        if (this.c != null) {
            return this.c;
        }
        if (!f.a) return this.a;
        if (!je.b()) return this.a;
        return this.b.d();
    }
}

