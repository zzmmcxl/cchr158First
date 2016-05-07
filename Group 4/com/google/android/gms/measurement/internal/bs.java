/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.v4.g.a;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.la;
import com.google.android.gms.b.li;
import com.google.android.gms.b.lj;
import com.google.android.gms.b.lk;
import com.google.android.gms.b.mh;
import com.google.android.gms.b.mi;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.io.IOException;
import java.util.Map;

public class bs
extends cl {
    private final Map a = new a();
    private final Map b = new a();
    private final Map c = new a();

    bs(bx bx2) {
        super(bx2);
    }

    private Map a(lj lj2) {
        a a2 = new a();
        if (lj2 == null) return a2;
        if (lj2.d == null) return a2;
        lk[] arrlk = lj2.d;
        int n2 = arrlk.length;
        int n3 = 0;
        while (n3 < n2) {
            lk lk2 = arrlk[n3];
            if (lk2 != null) {
                a2.put(lk2.a, lk2.b);
            }
            ++n3;
        }
        return a2;
    }

    private lj b(String string, byte[] arrby) {
        if (arrby == null) {
            return new lj();
        }
        mh mh2 = mh.a(arrby);
        lj lj2 = new lj();
        try {
            lj2.a(mh2);
            this.s().z().a("Parsed config. version, gmp_app_id", lj2.a, lj2.b);
            return lj2;
        }
        catch (IOException var5_5) {
            this.s().c().a("Unable to merge remote config", string, var5_5);
            return null;
        }
    }

    private Map b(lj lj2) {
        a a2 = new a();
        if (lj2 == null) return a2;
        if (lj2.e == null) return a2;
        li[] arrli = lj2.e;
        int n2 = arrli.length;
        int n3 = 0;
        while (n3 < n2) {
            li li2 = arrli[n3];
            if (li2 != null) {
                a2.put(li2.a, li2.b);
            }
            ++n3;
        }
        return a2;
    }

    private void b(String string) {
        this.G();
        this.f();
        bf.a(string);
        if (this.c.containsKey(string)) return;
        byte[] arrby = this.n().d(string);
        if (arrby == null) {
            this.a.put(string, null);
            this.b.put(string, null);
            this.c.put(string, null);
            return;
        }
        lj lj2 = this.b(string, arrby);
        this.a.put(string, this.a(lj2));
        this.b.put(string, this.b(lj2));
        this.c.put(string, lj2);
    }

    protected lj a(String string) {
        this.G();
        this.f();
        bf.a(string);
        this.b(string);
        return (lj)this.c.get(string);
    }

    String a(String string, String string2) {
        this.f();
        this.b(string);
        Map map = (Map)this.a.get(string);
        if (map == null) return null;
        return (String)map.get(string2);
    }

    @Override
    protected void a() {
    }

    protected boolean a(String string, byte[] arrby) {
        this.G();
        this.f();
        bf.a(string);
        lj lj2 = this.b(string, arrby);
        if (lj2 == null) {
            return false;
        }
        this.b.put(string, this.b(lj2));
        this.c.put(string, lj2);
        this.a.put(string, this.a(lj2));
        this.g().a(string, lj2.f);
        try {
            lj2.f = null;
            byte[] arrby2 = new byte[lj2.e()];
            lj2.a(mi.a(arrby2));
            arrby = arrby2;
        }
        catch (IOException var8_5) {
            this.s().c().a("Unable to serialize reduced-size config.  Storing full config instead.", var8_5);
        }
        this.n().a(string, arrby);
        return true;
    }

    boolean b(String string, String string2) {
        this.f();
        this.b(string);
        Map map = (Map)this.b.get(string);
        if (map == null) return false;
        Boolean bl2 = (Boolean)map.get(string2);
        if (bl2 != null) return bl2;
        return false;
    }
}

