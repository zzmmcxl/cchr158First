/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.ko;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.j;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.av;
import com.google.android.gms.measurement.internal.aw;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.ck;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;

public class aj
extends ck {
    static final String a = String.valueOf(j.b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean b;

    aj(bx bx2) {
        super(bx2);
    }

    int A() {
        return 500;
    }

    public long B() {
        return ((Integer)av.m.b()).intValue();
    }

    public long C() {
        return ((Integer)av.n.b()).intValue();
    }

    public long D() {
        return ((Integer)av.o.b()).intValue();
    }

    int E() {
        return 25;
    }

    int F() {
        return 50;
    }

    long G() {
        return 3600000;
    }

    long H() {
        return 60000;
    }

    long I() {
        return 61000;
    }

    long J() {
        return (Long)av.A.b();
    }

    public String K() {
        return "google_app_measurement.db";
    }

    public String L() {
        return "google_app_measurement2.db";
    }

    public long M() {
        return j.b / 1000;
    }

    public boolean N() {
        return f.a;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean O() {
        if (this.b != null) return this.b;
        // MONITORENTER : this
        if (this.b == null) {
            ApplicationInfo applicationInfo = this.m().getApplicationInfo();
            String string = ko.a(this.m(), Process.myPid());
            if (applicationInfo != null) {
                String string2 = applicationInfo.processName;
                boolean bl2 = string2 != null && string2.equals(string);
                this.b = bl2;
            }
            if (this.b == null) {
                this.b = Boolean.TRUE;
                this.s().b().a("My process not in the list of running processes");
            }
        }
        // MONITOREXIT : this
        return this.b;
    }

    public long P() {
        return (Long)av.y.b();
    }

    public long Q() {
        return (Long)av.u.b();
    }

    public long R() {
        return 1000;
    }

    public long S() {
        return Math.max(0, (Long)av.e.b());
    }

    public int T() {
        return Math.max(0, (Integer)av.k.b());
    }

    public int U() {
        return Math.max(1, (Integer)av.l.b());
    }

    public String V() {
        return (String)av.q.b();
    }

    public long W() {
        return (Long)av.f.b();
    }

    public long X() {
        return Math.max(0, (Long)av.r.b());
    }

    public long Y() {
        return Math.max(0, (Long)av.t.b());
    }

    public long Z() {
        return (Long)av.s.b();
    }

    long a(String string) {
        return this.a(string, av.d);
    }

    public long a(String string, aw aw2) {
        if (string == null) {
            return (Long)aw2.b();
        }
        String string2 = this.p().a(string, aw2.a());
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return (Long)aw2.b();
        }
        try {
            return (Long)aw2.a((long)Long.valueOf(string2));
        }
        catch (NumberFormatException var4_5) {
            return (Long)aw2.b();
        }
    }

    String a() {
        return (String)av.c.b();
    }

    public String a(String string, String string2) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme((String)av.g.b()).authority((String)av.h.b()).path("config/app/" + string).appendQueryParameter("app_instance_id", string2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(this.M()));
        return builder.build().toString();
    }

    public long aa() {
        return Math.max(0, (Long)av.v.b());
    }

    public long ab() {
        return Math.max(0, (Long)av.w.b());
    }

    public int ac() {
        return Math.min(20, Math.max(0, (Integer)av.x.b()));
    }

    public int b() {
        return 25;
    }

    int b(String string) {
        return this.b(string, av.z);
    }

    public int b(String string, aw aw2) {
        if (string == null) {
            return (Integer)aw2.b();
        }
        String string2 = this.p().a(string, aw2.a());
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return (Integer)aw2.b();
        }
        try {
            return (Integer)aw2.a((int)Integer.valueOf(string2));
        }
        catch (NumberFormatException var4_5) {
            return (Integer)aw2.b();
        }
    }

    int c() {
        return 32;
    }

    public int c(String string) {
        return this.b(string, av.i);
    }

    public int d(String string) {
        return Math.max(0, this.b(string, av.j));
    }

    public int e(String string) {
        return Math.max(0, Math.min(1000000, this.b(string, av.p)));
    }

    public int v() {
        return 24;
    }

    int w() {
        return 36;
    }

    int x() {
        return 256;
    }

    public int y() {
        return 36;
    }

    public int z() {
        return 2048;
    }
}

