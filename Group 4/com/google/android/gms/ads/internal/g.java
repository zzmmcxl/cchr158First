/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.a;
import com.google.android.gms.ads.internal.overlay.j;
import com.google.android.gms.b.aj;
import com.google.android.gms.b.ak;
import com.google.android.gms.b.al;
import com.google.android.gms.b.ap;
import com.google.android.gms.b.cp;
import com.google.android.gms.b.ct;
import com.google.android.gms.b.cy;
import com.google.android.gms.b.ff;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fj;
import com.google.android.gms.b.fl;
import com.google.android.gms.b.fx;
import com.google.android.gms.b.fz;
import com.google.android.gms.b.gs;
import com.google.android.gms.b.hi;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.kh;

@fi
public class g {
    private static final Object a = new Object();
    private static g b;
    private final com.google.android.gms.ads.internal.a.a c = new com.google.android.gms.ads.internal.a.a();
    private final a d = new a();
    private final j e = new j();
    private final ff f = new ff();
    private final fx g = new fx();
    private final hi h = new hi();
    private final fz i = fz.a(Build.VERSION.SDK_INT);
    private final fl j = new fl(this.g);
    private final kf k = new kh();
    private final ap l = new ap();
    private final fj m = new fj();
    private final ak n = new ak();
    private final aj o = new aj();
    private final al p = new al();
    private final com.google.android.gms.ads.internal.purchase.g q = new com.google.android.gms.ads.internal.purchase.g();
    private final ct r = new ct();
    private final gs s = new gs();
    private final cy t = new cy();
    private final f u = new f();
    private final cp v = new cp();

    static {
        g.a(new g());
    }

    protected g() {
    }

    public static a a() {
        return g.l().d;
    }

    protected static void a(g g2) {
        Object object = a;
        // MONITORENTER : object
        b = g2;
        // MONITOREXIT : object
        return;
    }

    public static j b() {
        return g.l().e;
    }

    public static fx c() {
        return g.l().g;
    }

    public static hi d() {
        return g.l().h;
    }

    public static fz e() {
        return g.l().i;
    }

    public static fl f() {
        return g.l().j;
    }

    public static kf g() {
        return g.l().k;
    }

    public static aj h() {
        return g.l().o;
    }

    public static al i() {
        return g.l().p;
    }

    public static com.google.android.gms.ads.internal.purchase.g j() {
        return g.l().q;
    }

    public static cp k() {
        return g.l().v;
    }

    private static g l() {
        Object object = a;
        // MONITORENTER : object
        g g2 = b;
        // MONITOREXIT : object
        return g2;
    }
}

