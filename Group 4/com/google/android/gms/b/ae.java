/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.af;
import com.google.android.gms.b.ag;
import com.google.android.gms.b.ah;
import com.google.android.gms.b.ai;
import com.google.android.gms.b.fi;

@fi
public abstract class ae {
    private final int a;
    private final String b;
    private final Object c;

    private ae(int n2, String string, Object object) {
        this.a = n2;
        this.b = string;
        this.c = object;
        g.h().a(this);
    }

    /* synthetic */ ae(int n2, String string, Object object, af af2) {
        this(n2, string, object);
    }

    public static ae a(int n2, String string) {
        ae ae2 = ae.a(n2, string, (String)null);
        g.h().b(ae2);
        return ae2;
    }

    public static ae a(int n2, String string, int n3) {
        return new ag(n2, string, n3);
    }

    public static ae a(int n2, String string, long l2) {
        return new ah(n2, string, l2);
    }

    public static ae a(int n2, String string, Boolean bl2) {
        return new af(n2, string, bl2);
    }

    public static ae a(int n2, String string, String string2) {
        return new ai(n2, string, string2);
    }

    public static ae b(int n2, String string) {
        ae ae2 = ae.a(n2, string, (String)null);
        g.h().c(ae2);
        return ae2;
    }

    protected abstract Object a(SharedPreferences var1);

    public String a() {
        return this.b;
    }

    public Object b() {
        return this.c;
    }

    public Object c() {
        return g.i().a(this);
    }
}

