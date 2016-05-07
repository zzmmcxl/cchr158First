/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ag;
import android.support.v4.app.aj;
import android.support.v4.app.bc;
import android.support.v4.app.bd;
import android.support.v4.b.m;
import android.support.v4.b.n;
import android.support.v4.b.o;
import android.support.v4.g.d;
import android.support.v4.g.r;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class be
implements n,
o {
    final int a;
    final Bundle b;
    bc c;
    m d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    be n;
    final /* synthetic */ bd o;

    public be(bd bd2, int n2, Bundle bundle, bc bc2) {
        this.o = bd2;
        this.a = n2;
        this.b = bundle;
        this.c = bc2;
    }

    void a() {
        if (this.i && this.j) {
            this.h = true;
            return;
        }
        if (this.h) return;
        this.h = true;
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("  Starting: " + this));
        }
        if (this.d == null && this.c != null) {
            this.d = this.c.a(this.a, this.b);
        }
        if (this.d == null) return;
        if (this.d.getClass().isMemberClass() && !Modifier.isStatic(this.d.getClass().getModifiers())) {
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
        }
        if (!this.m) {
            this.d.a(this.a, this);
            this.d.a(this);
            this.m = true;
        }
        this.d.i();
    }

    @Override
    public void a(m m2) {
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("onLoadCanceled: " + this));
        }
        if (this.l) {
            if (!bd.a) return;
            Log.v((String)"LoaderManager", (String)"  Ignoring load canceled -- destroyed");
            return;
        }
        if (this.o.b.a(this.a) != this) {
            if (!bd.a) return;
            Log.v((String)"LoaderManager", (String)"  Ignoring load canceled -- not active");
            return;
        }
        be be2 = this.n;
        if (be2 == null) return;
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("  Switching to pending loader: " + be2));
        }
        this.n = null;
        this.o.b.b(this.a, null);
        this.f();
        this.o.a(be2);
    }

    @Override
    public void a(m m2, Object object) {
        be be2;
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("onLoadComplete: " + this));
        }
        if (this.l) {
            if (!bd.a) return;
            Log.v((String)"LoaderManager", (String)"  Ignoring load complete -- destroyed");
            return;
        }
        if (this.o.b.a(this.a) != this) {
            if (!bd.a) return;
            Log.v((String)"LoaderManager", (String)"  Ignoring load complete -- not active");
            return;
        }
        be be3 = this.n;
        if (be3 != null) {
            if (bd.a) {
                Log.v((String)"LoaderManager", (String)("  Switching to pending loader: " + be3));
            }
            this.n = null;
            this.o.b.b(this.a, null);
            this.f();
            this.o.a(be3);
            return;
        }
        if (this.g != object || !this.e) {
            this.g = object;
            this.e = true;
            if (this.h) {
                this.b(m2, object);
            }
        }
        if ((be2 = (be)this.o.c.a(this.a)) != null && be2 != this) {
            be2.f = false;
            be2.f();
            this.o.c.c(this.a);
        }
        if (bd.a(this.o) == null) return;
        if (this.o.a()) return;
        bd.a((bd)this.o).d.f();
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mArgs=");
        printWriter.println((Object)this.b);
        printWriter.print(string);
        printWriter.print("mCallbacks=");
        printWriter.println(this.c);
        printWriter.print(string);
        printWriter.print("mLoader=");
        printWriter.println(this.d);
        if (this.d != null) {
            this.d.a(string + "  ", fileDescriptor, printWriter, arrstring);
        }
        if (this.e || this.f) {
            printWriter.print(string);
            printWriter.print("mHaveData=");
            printWriter.print(this.e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f);
            printWriter.print(string);
            printWriter.print("mData=");
            printWriter.println(this.g);
        }
        printWriter.print(string);
        printWriter.print("mStarted=");
        printWriter.print(this.h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.l);
        printWriter.print(string);
        printWriter.print("mRetaining=");
        printWriter.print(this.i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.m);
        if (this.n == null) return;
        printWriter.print(string);
        printWriter.println("Pending Loader ");
        printWriter.print(this.n);
        printWriter.println(":");
        this.n.a(string + "  ", fileDescriptor, printWriter, arrstring);
    }

    void b() {
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("  Retaining: " + this));
        }
        this.i = true;
        this.j = this.h;
        this.h = false;
        this.c = null;
    }

    void b(m m2, Object object) {
        String string;
        if (this.c == null) return;
        if (bd.a(this.o) != null) {
            String string2 = bd.a((bd)this.o).d.v;
            bd.a((bd)this.o).d.v = "onLoadFinished";
            string = string2;
        } else {
            string = null;
        }
        try {
            if (bd.a) {
                Log.v((String)"LoaderManager", (String)("  onLoadFinished in " + m2 + ": " + m2.c(object)));
            }
            this.c.a(m2, object);
            this.f = true;
            return;
        }
        finally {
            if (bd.a(this.o) != null) {
                bd.a((bd)this.o).d.v = string;
            }
        }
    }

    void c() {
        if (this.i) {
            if (bd.a) {
                Log.v((String)"LoaderManager", (String)("  Finished Retaining: " + this));
            }
            this.i = false;
            if (this.h != this.j && !this.h) {
                this.e();
            }
        }
        if (!this.h) return;
        if (!this.e) return;
        if (this.k) return;
        this.b(this.d, this.g);
    }

    void d() {
        if (!this.h) return;
        if (!this.k) return;
        this.k = false;
        if (!this.e) return;
        this.b(this.d, this.g);
    }

    void e() {
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("  Stopping: " + this));
        }
        this.h = false;
        if (this.i) return;
        if (this.d == null) return;
        if (!this.m) return;
        this.m = false;
        this.d.a(this);
        this.d.b(this);
        this.d.m();
    }

    void f() {
        String string;
        if (bd.a) {
            Log.v((String)"LoaderManager", (String)("  Destroying: " + this));
        }
        this.l = true;
        boolean bl2 = this.f;
        this.f = false;
        if (this.c != null && this.d != null && this.e && bl2) {
            if (bd.a) {
                Log.v((String)"LoaderManager", (String)("  Reseting: " + this));
            }
            if (bd.a(this.o) != null) {
                String string2 = bd.a((bd)this.o).d.v;
                bd.a((bd)this.o).d.v = "onLoaderReset";
                string = string2;
            } else {
                string = null;
            }
            this.c.a(this.d);
        }
        this.c = null;
        this.g = null;
        this.e = false;
        if (this.d != null) {
            if (this.m) {
                this.m = false;
                this.d.a(this);
                this.d.b(this);
            }
            this.d.o();
        }
        if (this.n == null) return;
        this.n.f();
        return;
        finally {
            if (bd.a(this.o) != null) {
                bd.a((bd)this.o).d.v = string;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.a);
        stringBuilder.append(" : ");
        d.a(this.d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}

