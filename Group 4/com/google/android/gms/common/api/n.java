/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.ay;
import com.google.android.gms.common.api.internal.bd;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class n {
    private static final Set a = Collections.newSetFromMap(new WeakHashMap());

    public static Set a() {
        return a;
    }

    static /* synthetic */ Set j() {
        return a;
    }

    public h a(i i2) {
        throw new UnsupportedOperationException();
    }

    public c a(c c2) {
        throw new UnsupportedOperationException();
    }

    public void a(int n2) {
        throw new UnsupportedOperationException();
    }

    public void a(bd bd2) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(r var1);

    public abstract void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public boolean a(ay ay2) {
        throw new UnsupportedOperationException();
    }

    public Context b() {
        throw new UnsupportedOperationException();
    }

    public void b(bd bd2) {
        throw new UnsupportedOperationException();
    }

    public abstract void b(r var1);

    public Looper c() {
        throw new UnsupportedOperationException();
    }

    public void d() {
        throw new UnsupportedOperationException();
    }

    public abstract void e();

    public abstract ConnectionResult f();

    public abstract void g();

    public abstract t h();

    public abstract boolean i();
}

