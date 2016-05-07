/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import com.google.android.gms.b.jf;
import com.google.android.gms.b.jg;
import com.google.android.gms.b.jh;
import com.google.android.gms.b.ji;
import com.google.android.gms.b.jj;

public abstract class je {
    private static final Object c = new Object();
    private static jj d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final Object b;
    private Object g = null;

    protected je(String string, Object object) {
        this.a = string;
        this.b = object;
    }

    public static int a() {
        return e;
    }

    public static je a(String string, Integer n2) {
        return new jh(string, n2);
    }

    public static je a(String string, Long l2) {
        return new jg(string, l2);
    }

    public static je a(String string, String string2) {
        return new ji(string, string2);
    }

    public static je a(String string, boolean bl2) {
        return new jf(string, bl2);
    }

    public static boolean b() {
        if (d == null) return false;
        return true;
    }

    static /* synthetic */ jj e() {
        return d;
    }

    protected abstract Object a(String var1);

    public final Object c() {
        if (this.g == null) return this.a(this.a);
        return this.g;
    }

    public final Object d() {
        long l2 = Binder.clearCallingIdentity();
        try {
            Object object = this.c();
            return object;
        }
        finally {
            Binder.restoreCallingIdentity((long)l2);
        }
    }
}

