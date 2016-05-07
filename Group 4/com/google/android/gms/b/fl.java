/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ao;
import com.google.android.gms.b.fh;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fm;
import com.google.android.gms.b.fx;
import com.google.android.gms.b.n;
import com.google.android.gms.b.o;
import com.google.android.gms.b.p;
import com.google.android.gms.common.r;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@fi
public class fl {
    private final Object a = new Object();
    private final String b;
    private final fm c;
    private BigInteger d = BigInteger.ONE;
    private final HashSet e = new HashSet();
    private final HashMap f = new HashMap();
    private boolean g = false;
    private boolean h = true;
    private int i = 0;
    private boolean j = false;
    private Context k;
    private VersionInfoParcel l;
    private ao m = null;
    private boolean n = true;
    private o o = null;
    private p p = null;
    private n q = null;
    private final LinkedList r = new LinkedList();
    private final fh s = null;
    private Boolean t = null;
    private String u;
    private boolean v = false;
    private boolean w = false;

    public fl(fx fx2) {
        this.b = fx2.b();
        this.c = new fm(this.b);
    }

    public ao a() {
        Object object = this.a;
        // MONITORENTER : object
        ao ao2 = this.m;
        // MONITOREXIT : object
        return ao2;
    }

    public String a(int n2, String string) {
        Resources resources = this.l.e ? this.k.getResources() : r.d(this.k);
        if (resources != null) return resources.getString(n2);
        return string;
    }

    public void a(Boolean bl2) {
        Object object = this.a;
        // MONITORENTER : object
        this.t = bl2;
        // MONITOREXIT : object
        return;
    }

    public void a(Throwable throwable, boolean bl2) {
        new fh(this.k, this.l, null, null).a(throwable, bl2);
    }

    public String b() {
        Object object = this.a;
        // MONITORENTER : object
        String string = this.u;
        // MONITOREXIT : object
        return string;
    }

    public Boolean c() {
        Object object = this.a;
        // MONITORENTER : object
        Boolean bl2 = this.t;
        // MONITOREXIT : object
        return bl2;
    }
}

