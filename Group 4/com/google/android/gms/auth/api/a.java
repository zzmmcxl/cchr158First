/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.c;
import com.google.android.gms.auth.api.d;
import com.google.android.gms.auth.api.e;
import com.google.android.gms.auth.api.f;
import com.google.android.gms.auth.api.g;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.auth.api.signin.internal.z;
import com.google.android.gms.auth.api.signin.j;
import com.google.android.gms.b.ib;
import com.google.android.gms.b.ic;
import com.google.android.gms.b.ik;
import com.google.android.gms.b.iy;
import com.google.android.gms.common.api.i;

public final class a {
    public static final i a = new i();
    public static final i b = new i();
    public static final i c = new i();
    public static final i d = new i();
    public static final i e = new i();
    public static final i f = new i();
    public static final com.google.android.gms.common.api.a g;
    public static final com.google.android.gms.common.api.a h;
    public static final com.google.android.gms.common.api.a i;
    public static final com.google.android.gms.common.api.a j;
    public static final com.google.android.gms.common.api.a k;
    public static final com.google.android.gms.common.api.a l;
    public static final com.google.android.gms.auth.api.proxy.a m;
    public static final com.google.android.gms.auth.api.credentials.c n;
    public static final ib o;
    public static final j p;
    public static final b q;
    public static final com.google.android.gms.auth.api.consent.a r;
    private static final com.google.android.gms.common.api.g s;
    private static final com.google.android.gms.common.api.g t;
    private static final com.google.android.gms.common.api.g u;
    private static final com.google.android.gms.common.api.g v;
    private static final com.google.android.gms.common.api.g w;
    private static final com.google.android.gms.common.api.g x;

    static {
        s = new com.google.android.gms.auth.api.b();
        t = new c();
        u = new d();
        v = new e();
        w = new f();
        x = new g();
        g = new com.google.android.gms.common.api.a("Auth.PROXY_API", s, a);
        h = new com.google.android.gms.common.api.a("Auth.CREDENTIALS_API", t, b);
        i = new com.google.android.gms.common.api.a("Auth.SIGN_IN_API", w, d);
        j = new com.google.android.gms.common.api.a("Auth.GOOGLE_SIGN_IN_API", x, e);
        k = new com.google.android.gms.common.api.a("Auth.ACCOUNT_STATUS_API", u, c);
        l = new com.google.android.gms.common.api.a("Auth.CONSENT_API", v, f);
        m = new iy();
        n = new com.google.android.gms.auth.api.credentials.internal.a();
        o = new ic();
        p = new z();
        q = new com.google.android.gms.auth.api.signin.internal.e();
        r = new ik();
    }
}

