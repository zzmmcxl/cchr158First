/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bx;

class b {
    private final bx a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private long g;
    private long h;
    private String i;
    private String j;
    private long k;
    private long l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;
    private boolean r;
    private long s;
    private long t;

    b(bx bx2, String string) {
        bf.a(bx2);
        bf.a(string);
        this.a = bx2;
        this.b = string;
        this.a.x();
    }

    public void a() {
        this.a.x();
        this.r = false;
    }

    public void a(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.g != l2;
        this.r = bl3 | bl2;
        this.g = l2;
    }

    public void a(String string) {
        this.a.x();
        this.r |= ag.a(this.c, string);
        this.c = string;
    }

    public void a(boolean bl2) {
        this.a.x();
        boolean bl3 = this.r;
        boolean bl4 = this.m != bl2;
        this.r = bl4 | bl3;
        this.m = bl2;
    }

    public String b() {
        this.a.x();
        return this.b;
    }

    public void b(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.h != l2;
        this.r = bl3 | bl2;
        this.h = l2;
    }

    public void b(String string) {
        this.a.x();
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = null;
        }
        this.r |= ag.a(this.d, string);
        this.d = string;
    }

    public String c() {
        this.a.x();
        return this.c;
    }

    public void c(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.k != l2;
        this.r = bl3 | bl2;
        this.k = l2;
    }

    public void c(String string) {
        this.a.x();
        this.r |= ag.a(this.e, string);
        this.e = string;
    }

    public String d() {
        this.a.x();
        return this.d;
    }

    public void d(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.l != l2;
        this.r = bl3 | bl2;
        this.l = l2;
    }

    public void d(String string) {
        this.a.x();
        this.r |= ag.a(this.i, string);
        this.i = string;
    }

    public String e() {
        this.a.x();
        return this.e;
    }

    public void e(long l2) {
        boolean bl2 = true;
        boolean bl3 = l2 >= 0 ? bl2 : false;
        bf.b(bl3);
        this.a.x();
        boolean bl4 = this.r;
        if (this.f == l2) {
            bl2 = false;
        }
        this.r = bl4 | bl2;
        this.f = l2;
    }

    public void e(String string) {
        this.a.x();
        this.r |= ag.a(this.j, string);
        this.j = string;
    }

    public long f() {
        this.a.x();
        return this.g;
    }

    public void f(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.s != l2;
        this.r = bl3 | bl2;
        this.s = l2;
    }

    public long g() {
        this.a.x();
        return this.h;
    }

    public void g(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.t != l2;
        this.r = bl3 | bl2;
        this.t = l2;
    }

    public String h() {
        this.a.x();
        return this.i;
    }

    public void h(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.n != l2;
        this.r = bl3 | bl2;
        this.n = l2;
    }

    public String i() {
        this.a.x();
        return this.j;
    }

    public void i(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.o != l2;
        this.r = bl3 | bl2;
        this.o = l2;
    }

    public long j() {
        this.a.x();
        return this.k;
    }

    public void j(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.p != l2;
        this.r = bl3 | bl2;
        this.p = l2;
    }

    public long k() {
        this.a.x();
        return this.l;
    }

    public void k(long l2) {
        this.a.x();
        boolean bl2 = this.r;
        boolean bl3 = this.q != l2;
        this.r = bl3 | bl2;
        this.q = l2;
    }

    public boolean l() {
        this.a.x();
        return this.m;
    }

    public long m() {
        this.a.x();
        return this.f;
    }

    public long n() {
        this.a.x();
        return this.s;
    }

    public long o() {
        this.a.x();
        return this.t;
    }

    public void p() {
        this.a.x();
        long l2 = 1 + this.f;
        if (l2 > Integer.MAX_VALUE) {
            this.a.f().c().a("Bundle index overflow");
            l2 = 0;
        }
        this.r = true;
        this.f = l2;
    }

    public long q() {
        this.a.x();
        return this.n;
    }

    public long r() {
        this.a.x();
        return this.o;
    }

    public long s() {
        this.a.x();
        return this.p;
    }

    public long t() {
        this.a.x();
        return this.q;
    }
}

