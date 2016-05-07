/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.a;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bd;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.br;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;

public class bc
extends cl {
    private final String a;
    private final char b;
    private final long c;
    private final be d;
    private final be e;
    private final be f;
    private final be g;
    private final be h;
    private final be i;
    private final be j;
    private final be k;
    private final be l;

    bc(bx bx2) {
        super(bx2);
        this.a = this.u().a();
        this.c = this.u().M();
        if (this.u().O()) {
            int n2 = this.u().N() ? 80 : 67;
            this.b = n2;
        } else {
            int n3 = this.u().N() ? 112 : 99;
            this.b = n3;
        }
        this.d = new be(this, 6, false, false);
        this.e = new be(this, 6, true, false);
        this.f = new be(this, 6, false, true);
        this.g = new be(this, 5, false, false);
        this.h = new be(this, 5, true, false);
        this.i = new be(this, 5, false, true);
        this.j = new be(this, 4, false, false);
        this.k = new be(this, 3, false, false);
        this.l = new be(this, 2, false, false);
    }

    private static String a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        int n2 = string.lastIndexOf(46);
        if (n2 == -1) return string;
        return string.substring(0, n2);
    }

    static String a(boolean bl2, Object object) {
        if (object == null) {
            return "";
        }
        Long l2 = object instanceof Integer ? Long.valueOf(((Integer)object).intValue()) : object;
        if (l2 instanceof Long) {
            if (!bl2) {
                return String.valueOf(l2);
            }
            if (Math.abs(l2) < 100) {
                return String.valueOf(l2);
            }
            String string = String.valueOf(l2).charAt(0) == '-' ? "-" : "";
            String string2 = String.valueOf(Math.abs(l2));
            return string + Math.round(Math.pow(10.0, -1 + string2.length())) + "..." + string + Math.round(Math.pow(10.0, string2.length()) - 1.0);
        }
        if (l2 instanceof Boolean) {
            return String.valueOf(l2);
        }
        if (!(l2 instanceof Throwable)) {
            if (!bl2) return String.valueOf(l2);
            return "-";
        }
        Throwable throwable = (Throwable)((Object)l2);
        StringBuilder stringBuilder = new StringBuilder(throwable.toString());
        String string = bc.a(a.class.getCanonicalName());
        String string3 = bc.a(bx.class.getCanonicalName());
        StackTraceElement[] arrstackTraceElement = throwable.getStackTrace();
        int n2 = arrstackTraceElement.length;
        int n3 = 0;
        while (n3 < n2) {
            String string4;
            String string5;
            StackTraceElement stackTraceElement = arrstackTraceElement[n3];
            if (!stackTraceElement.isNativeMethod() && (string5 = stackTraceElement.getClassName()) != null && ((string4 = bc.a(string5)).equals(string) || string4.equals(string3))) {
                stringBuilder.append(": ");
                stringBuilder.append(stackTraceElement);
                return stringBuilder.toString();
            }
            ++n3;
        }
        return stringBuilder.toString();
    }

    static String a(boolean bl2, String string, Object object, Object object2, Object object3) {
        if (string == null) {
            string = "";
        }
        String string2 = bc.a(bl2, object);
        String string3 = bc.a(bl2, object2);
        String string4 = bc.a(bl2, object3);
        StringBuilder stringBuilder = new StringBuilder();
        String string5 = "";
        if (!TextUtils.isEmpty((CharSequence)string)) {
            stringBuilder.append(string);
            string5 = ": ";
        }
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            stringBuilder.append(string5);
            stringBuilder.append(string2);
            string5 = ", ";
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            stringBuilder.append(string5);
            stringBuilder.append(string3);
            string5 = ", ";
        }
        if (TextUtils.isEmpty((CharSequence)string4)) return stringBuilder.toString();
        stringBuilder.append(string5);
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public String A() {
        Pair pair = this.t().b.a();
        if (pair != null) return String.valueOf(pair.second) + ":" + (String)pair.first;
        return null;
    }

    @Override
    protected void a() {
    }

    protected void a(int n2, String string) {
        Log.println((int)n2, (String)this.a, (String)string);
    }

    public void a(int n2, String string, Object object, Object object2, Object object3) {
        String string2;
        bf.a((Object)string);
        bt bt2 = this.n.k();
        if (bt2 == null) {
            this.a(6, "Scheduler not set. Not logging error/warn.");
            return;
        }
        if (!bt2.E()) {
            this.a(6, "Scheduler not initialized. Not logging error/warn.");
            return;
        }
        if (bt2.F()) {
            this.a(6, "Scheduler shutdown. Not logging error/warn.");
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= "01VDIWEA?".length()) {
            n2 = -1 + "01VDIWEA?".length();
        }
        String string3 = (string2 = "1" + "01VDIWEA?".charAt(n2) + this.b + this.c + ":" + bc.a(true, string, object, object2, object3)).length() > 1024 ? string.substring(0, 1024) : string2;
        bt2.a(new bd(this, string3));
    }

    protected void a(int n2, boolean bl2, boolean bl3, String string, Object object, Object object2, Object object3) {
        if (!bl2 && this.a(n2)) {
            this.a(n2, bc.a(false, string, object, object2, object3));
        }
        if (bl3) return;
        if (n2 < 5) return;
        this.a(n2, string, object, object2, object3);
    }

    protected boolean a(int n2) {
        return Log.isLoggable((String)this.a, (int)n2);
    }

    public be b() {
        return this.d;
    }

    public be c() {
        return this.g;
    }

    public be v() {
        return this.h;
    }

    public be w() {
        return this.i;
    }

    public be x() {
        return this.j;
    }

    public be y() {
        return this.k;
    }

    public be z() {
        return this.l;
    }
}

