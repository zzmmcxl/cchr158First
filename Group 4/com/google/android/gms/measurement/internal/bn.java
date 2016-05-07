/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.b.a;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.b.kf;
import com.google.android.gms.measurement.e;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bo;
import com.google.android.gms.measurement.internal.bp;
import com.google.android.gms.measurement.internal.bq;
import com.google.android.gms.measurement.internal.br;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class bn
extends cl {
    static final Pair a = new Pair((Object)"", (Object)0);
    public final br b;
    public final bq c;
    public final bq d;
    public final bq e;
    public final bq f;
    public final bq g;
    public final bq h;
    public final bq i;
    public final bp j;
    public final bq k;
    public final bq l;
    public boolean m;
    private SharedPreferences o;
    private String p;
    private boolean q;
    private long r;
    private final SecureRandom s;

    bn(bx bx2) {
        super(bx2);
        this.b = new br(this, "health_monitor", this.u().S(), null);
        this.c = new bq(this, "last_upload", 0);
        this.d = new bq(this, "last_upload_attempt", 0);
        this.e = new bq(this, "backoff", 0);
        this.f = new bq(this, "last_delete_stale", 0);
        this.h = new bq(this, "time_before_start", 10000);
        this.i = new bq(this, "session_timeout", 1800000);
        this.j = new bp(this, "start_new_session", true);
        this.k = new bq(this, "last_pause_time", 0);
        this.l = new bq(this, "time_active", 0);
        this.s = new SecureRandom();
        this.g = new bq(this, "midnight_offset", 0);
    }

    static /* synthetic */ SharedPreferences a(bn bn2) {
        return bn2.o;
    }

    static /* synthetic */ SecureRandom b(bn bn2) {
        return bn2.s;
    }

    static /* synthetic */ SharedPreferences c(bn bn2) {
        return bn2.y();
    }

    private SharedPreferences y() {
        this.f();
        this.G();
        return this.o;
    }

    Pair a(String string) {
        this.f();
        long l2 = this.l().b();
        if (this.p != null && l2 < this.r) {
            return new Pair((Object)this.p, (Object)this.q);
        }
        this.r = l2 + this.u().a(string);
        a.b(true);
        try {
            b b2 = a.b(this.m());
            this.p = b2.a();
            this.q = b2.b();
        }
        catch (Throwable var4_4) {
            this.s().y().a("Unable to get advertising id", var4_4);
            this.p = "";
        }
        a.b(false);
        return new Pair((Object)this.p, (Object)this.q);
    }

    @Override
    protected void a() {
        this.o = this.m().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.m = this.o.getBoolean("has_been_opened", false);
        if (this.m) return;
        SharedPreferences.Editor editor = this.o.edit();
        editor.putBoolean("has_been_opened", true);
        editor.apply();
    }

    void a(boolean bl2) {
        this.f();
        this.s().z().a("Setting useService", bl2);
        SharedPreferences.Editor editor = this.y().edit();
        editor.putBoolean("use_service", bl2);
        editor.apply();
    }

    String b() {
        byte[] arrby = new byte[16];
        this.s.nextBytes(arrby);
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{new BigInteger(1, arrby)};
        return String.format(locale, "%032x", arrobject);
    }

    String b(String string) {
        String string2 = (String)this.a((String)string).first;
        MessageDigest messageDigest = ag.e("MD5");
        if (messageDigest == null) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{new BigInteger(1, messageDigest.digest(string2.getBytes()))};
        return String.format(locale, "%032X", arrobject);
    }

    void b(boolean bl2) {
        this.f();
        this.s().z().a("Setting measurementEnabled", bl2);
        SharedPreferences.Editor editor = this.y().edit();
        editor.putBoolean("measurement_enabled", bl2);
        editor.apply();
    }

    long c() {
        this.G();
        this.f();
        long l2 = this.g.a();
        if (l2 != 0) return l2;
        l2 = 1 + this.s.nextInt(86400000);
        this.g.a(l2);
        return l2;
    }

    Boolean v() {
        this.f();
        if (this.y().contains("use_service")) return this.y().getBoolean("use_service", false);
        return null;
    }

    boolean w() {
        boolean bl2;
        this.f();
        SharedPreferences sharedPreferences = this.y();
        if (!e.d()) {
            bl2 = true;
            return sharedPreferences.getBoolean("measurement_enabled", bl2);
        }
        bl2 = false;
        return sharedPreferences.getBoolean("measurement_enabled", bl2);
    }

    protected String x() {
        this.f();
        String string = this.y().getString("previous_os_version", null);
        String string2 = this.j().c();
        if (TextUtils.isEmpty((CharSequence)string2)) return string;
        if (string2.equals(string)) return string;
        SharedPreferences.Editor editor = this.y().edit();
        editor.putString("previous_os_version", string2);
        editor.apply();
        return string;
    }
}

