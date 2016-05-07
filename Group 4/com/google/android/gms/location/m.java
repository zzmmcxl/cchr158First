/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.i;
import com.google.android.gms.location.g;
import com.google.android.gms.location.internal.ad;
import com.google.android.gms.location.internal.d;
import com.google.android.gms.location.internal.f;
import com.google.android.gms.location.n;
import com.google.android.gms.location.q;

public class m {
    public static final a a;
    public static final com.google.android.gms.location.d b;
    public static final g c;
    public static final q d;
    private static final i e;
    private static final com.google.android.gms.common.api.g f;

    static {
        e = new i();
        f = new n();
        a = new a("LocationServices.API", f, e);
        b = new d();
        c = new f();
        d = new ad();
    }

    static /* synthetic */ i a() {
        return e;
    }
}

