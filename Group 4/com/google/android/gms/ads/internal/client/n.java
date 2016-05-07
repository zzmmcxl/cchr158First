/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.c;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.client.l;
import com.google.android.gms.ads.internal.reward.a.d;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.bn;
import com.google.android.gms.b.fi;

@fi
public class n {
    private static final Object a = new Object();
    private static n b;
    private final a c = new a();
    private final h d = new h();
    private final l e = new l();
    private final c f = new c();
    private final bn g = new bn();
    private final d h = new d();

    static {
        n.a(new n());
    }

    protected n() {
    }

    public static a a() {
        return n.c().c;
    }

    protected static void a(n n2) {
        Object object = a;
        // MONITORENTER : object
        b = n2;
        // MONITOREXIT : object
        return;
    }

    public static l b() {
        return n.c().e;
    }

    private static n c() {
        Object object = a;
        // MONITORENTER : object
        n n2 = b;
        // MONITOREXIT : object
        return n2;
    }
}

