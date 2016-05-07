/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.b.b;
import android.support.v4.b.m;
import android.support.v4.b.p;
import android.support.v4.g.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

public abstract class a
extends m {
    volatile b a;
    volatile b b;
    long c;
    long d = -10000;
    Handler e;
    private final Executor o;

    public a(Context context) {
        this(context, p.c);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.o = executor;
    }

    @Override
    protected void a() {
        super.a();
        this.k();
        this.a = new b(this);
        this.c();
    }

    void a(b b2, Object object) {
        this.a(object);
        if (this.b != b2) return;
        this.r();
        this.d = SystemClock.uptimeMillis();
        this.b = null;
        this.g();
        this.c();
    }

    public void a(Object object) {
    }

    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        super.a(string, fileDescriptor, printWriter, arrstring);
        if (this.a != null) {
            printWriter.print(string);
            printWriter.print("mTask=");
            printWriter.print(this.a);
            printWriter.print(" waiting=");
            printWriter.println(this.a.a);
        }
        if (this.b != null) {
            printWriter.print(string);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.b);
            printWriter.print(" waiting=");
            printWriter.println(this.b.a);
        }
        if (this.c == 0) return;
        printWriter.print(string);
        printWriter.print("mUpdateThrottle=");
        s.a(this.c, printWriter);
        printWriter.print(" mLastLoadCompleteTime=");
        s.a(this.d, SystemClock.uptimeMillis(), printWriter);
        printWriter.println();
    }

    void b(b b2, Object object) {
        if (this.a != b2) {
            this.a(b2, object);
            return;
        }
        if (this.h()) {
            this.a(object);
            return;
        }
        this.q();
        this.d = SystemClock.uptimeMillis();
        this.a = null;
        this.b(object);
    }

    @Override
    protected boolean b() {
        if (this.a == null) return false;
        if (this.b != null) {
            if (this.a.a) {
                this.a.a = false;
                this.e.removeCallbacks((Runnable)this.a);
            }
            this.a = null;
            return false;
        }
        if (this.a.a) {
            this.a.a = false;
            this.e.removeCallbacks((Runnable)this.a);
            this.a = null;
            return false;
        }
        boolean bl2 = this.a.a(false);
        if (bl2) {
            this.b = this.a;
            this.f();
        }
        this.a = null;
        return bl2;
    }

    void c() {
        if (this.b != null) return;
        if (this.a == null) return;
        if (this.a.a) {
            this.a.a = false;
            this.e.removeCallbacks((Runnable)this.a);
        }
        if (this.c > 0 && SystemClock.uptimeMillis() < this.d + this.c) {
            this.a.a = true;
            this.e.postAtTime((Runnable)this.a, this.d + this.c);
            return;
        }
        this.a.a(this.o, (Object[])null);
    }

    public abstract Object d();

    protected Object e() {
        return this.d();
    }

    public void f() {
    }
}

