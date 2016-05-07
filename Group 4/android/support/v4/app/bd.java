/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ag;
import android.support.v4.app.bb;
import android.support.v4.app.bc;
import android.support.v4.app.be;
import android.support.v4.b.m;
import android.support.v4.g.d;
import android.support.v4.g.r;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class bd
extends bb {
    static boolean a = false;
    final r b = new r();
    final r c = new r();
    final String d;
    boolean e;
    boolean f;
    boolean g;
    private ag h;

    bd(String string, ag ag2, boolean bl2) {
        this.d = string;
        this.h = ag2;
        this.e = bl2;
    }

    static /* synthetic */ ag a(bd bd2) {
        return bd2.h;
    }

    private be b(int n2, Bundle bundle, bc bc2) {
        be be2 = new be(this, n2, bundle, bc2);
        be2.d = bc2.a(n2, bundle);
        return be2;
    }

    private be c(int n2, Bundle bundle, bc bc2) {
        try {
            this.g = true;
            be be2 = this.b(n2, bundle, bc2);
            this.a(be2);
            return be2;
        }
        finally {
            this.g = false;
        }
    }

    @Override
    public m a(int n2, Bundle bundle, bc bc2) {
        if (this.g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        be be2 = (be)this.b.a(n2);
        if (a) {
            Log.v((String)"LoaderManager", (String)("initLoader in " + this + ": args=" + (Object)bundle));
        }
        if (be2 == null) {
            be2 = this.c(n2, bundle, bc2);
            if (a) {
                Log.v((String)"LoaderManager", (String)("  Created new loader " + be2));
            }
        } else {
            if (a) {
                Log.v((String)"LoaderManager", (String)("  Re-using existing loader " + be2));
            }
            be2.c = bc2;
        }
        if (!be2.e) return be2.d;
        if (!this.e) return be2.d;
        be2.b(be2.d, be2.g);
        return be2.d;
    }

    void a(ag ag2) {
        this.h = ag2;
    }

    void a(be be2) {
        this.b.b(be2.a, be2);
        if (!this.e) return;
        be2.a();
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        int n2 = 0;
        if (this.b.b() > 0) {
            printWriter.print(string);
            printWriter.println("Active Loaders:");
            String string2 = string + "    ";
            for (int i2 = 0; i2 < this.b.b(); ++i2) {
                be be2 = (be)this.b.e(i2);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(this.b.d(i2));
                printWriter.print(": ");
                printWriter.println(be2.toString());
                be2.a(string2, fileDescriptor, printWriter, arrstring);
            }
        }
        if (this.c.b() <= 0) return;
        printWriter.print(string);
        printWriter.println("Inactive Loaders:");
        String string3 = string + "    ";
        while (n2 < this.c.b()) {
            be be3 = (be)this.c.e(n2);
            printWriter.print(string);
            printWriter.print("  #");
            printWriter.print(this.c.d(n2));
            printWriter.print(": ");
            printWriter.println(be3.toString());
            be3.a(string3, fileDescriptor, printWriter, arrstring);
            ++n2;
        }
    }

    @Override
    public boolean a() {
        int n2 = this.b.b();
        int n3 = 0;
        boolean bl2 = false;
        while (n3 < n2) {
            be be2 = (be)this.b.e(n3);
            boolean bl3 = be2.h && !be2.f;
            bl2 |= bl3;
            ++n3;
        }
        return bl2;
    }

    void b() {
        if (a) {
            Log.v((String)"LoaderManager", (String)("Starting in " + this));
        }
        if (this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w((String)"LoaderManager", (String)("Called doStart when already started: " + this), (Throwable)runtimeException);
            return;
        }
        this.e = true;
        int n2 = -1 + this.b.b();
        while (n2 >= 0) {
            ((be)this.b.e(n2)).a();
            --n2;
        }
    }

    void c() {
        if (a) {
            Log.v((String)"LoaderManager", (String)("Stopping in " + this));
        }
        if (!this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w((String)"LoaderManager", (String)("Called doStop when not started: " + this), (Throwable)runtimeException);
            return;
        }
        int n2 = -1 + this.b.b();
        do {
            if (n2 < 0) {
                this.e = false;
                return;
            }
            ((be)this.b.e(n2)).e();
            --n2;
        } while (true);
    }

    void d() {
        if (a) {
            Log.v((String)"LoaderManager", (String)("Retaining in " + this));
        }
        if (!this.e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w((String)"LoaderManager", (String)("Called doRetain when not started: " + this), (Throwable)runtimeException);
            return;
        }
        this.f = true;
        this.e = false;
        int n2 = -1 + this.b.b();
        while (n2 >= 0) {
            ((be)this.b.e(n2)).b();
            --n2;
        }
    }

    void e() {
        if (!this.f) return;
        if (a) {
            Log.v((String)"LoaderManager", (String)("Finished Retaining in " + this));
        }
        this.f = false;
        int n2 = -1 + this.b.b();
        while (n2 >= 0) {
            ((be)this.b.e(n2)).c();
            --n2;
        }
    }

    void f() {
        int n2 = -1 + this.b.b();
        while (n2 >= 0) {
            ((be)this.b.e((int)n2)).k = true;
            --n2;
        }
    }

    void g() {
        int n2 = -1 + this.b.b();
        while (n2 >= 0) {
            ((be)this.b.e(n2)).d();
            --n2;
        }
    }

    void h() {
        if (!this.f) {
            if (a) {
                Log.v((String)"LoaderManager", (String)("Destroying Active in " + this));
            }
            for (int i2 = -1 + this.b.b(); i2 >= 0; --i2) {
                ((be)this.b.e(i2)).f();
            }
            this.b.c();
        }
        if (a) {
            Log.v((String)"LoaderManager", (String)("Destroying Inactive in " + this));
        }
        int n2 = -1 + this.c.b();
        do {
            if (n2 < 0) {
                this.c.c();
                return;
            }
            ((be)this.c.e(n2)).f();
            --n2;
        } while (true);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.h, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}

