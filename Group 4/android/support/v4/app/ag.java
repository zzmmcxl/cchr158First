/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.aa;
import android.support.v4.app.ae;
import android.support.v4.app.aj;
import android.support.v4.app.bd;
import android.support.v4.app.x;
import android.support.v4.g.q;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class ag
extends ae {
    private final Activity a;
    final Context b;
    final int c;
    final aj d = new aj();
    private final Handler e;
    private q f;
    private boolean g;
    private bd h;
    private boolean i;
    private boolean j;

    ag(Activity activity, Context context, Handler handler, int n2) {
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = n2;
    }

    ag(aa aa2) {
        this(aa2, (Context)aa2, aa2.a, 0);
    }

    bd a(String string, boolean bl2, boolean bl3) {
        bd bd2;
        if (this.f == null) {
            this.f = new q();
        }
        if ((bd2 = (bd)this.f.get(string)) == null) {
            if (!bl3) return bd2;
            bd2 = new bd(string, this, bl2);
            this.f.put(string, bd2);
            return bd2;
        }
        bd2.a(this);
        return bd2;
    }

    @Override
    public View a(int n2) {
        return null;
    }

    public void a(x x2, Intent intent, int n2, Bundle bundle) {
        if (n2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.b.startActivity(intent);
    }

    void a(q q2) {
        this.f = q2;
    }

    void a(String string) {
        if (this.f == null) return;
        bd bd2 = (bd)this.f.get(string);
        if (bd2 == null) return;
        if (bd2.f) return;
        bd2.h();
        this.f.remove(string);
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
    }

    void a(boolean bl2) {
        this.g = bl2;
        if (this.h == null) {
            return;
        }
        if (!this.j) return;
        this.j = false;
        if (bl2) {
            this.h.d();
            return;
        }
        this.h.c();
    }

    @Override
    public boolean a() {
        return true;
    }

    public boolean a(x x2) {
        return true;
    }

    public LayoutInflater b() {
        return (LayoutInflater)this.b.getSystemService("layout_inflater");
    }

    void b(x x2) {
    }

    void b(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h == null) return;
        printWriter.print(string);
        printWriter.print("Loader Manager ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
        printWriter.println(":");
        this.h.a(string + "  ", fileDescriptor, printWriter, arrstring);
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.b;
    }

    Handler h() {
        return this.e;
    }

    aj i() {
        return this.d;
    }

    bd j() {
        if (this.h != null) {
            return this.h;
        }
        this.i = true;
        this.h = this.a("(root)", this.j, true);
        return this.h;
    }

    boolean k() {
        return this.g;
    }

    void l() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.h != null) {
            this.h.b();
        } else if (!this.i) {
            this.h = this.a("(root)", this.j, false);
            if (this.h != null && !this.h.e) {
                this.h.b();
            }
        }
        this.i = true;
    }

    void m() {
        if (this.h == null) {
            return;
        }
        this.h.h();
    }

    void n() {
        if (this.f == null) return;
        int n2 = this.f.size();
        bd[] arrbd = new bd[n2];
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            arrbd[i2] = (bd)this.f.c(i2);
        }
        int n3 = 0;
        while (n3 < n2) {
            bd bd2 = arrbd[n3];
            bd2.e();
            bd2.g();
            ++n3;
        }
    }

    q o() {
        int n2 = 0;
        if (this.f == null) return null;
        int n3 = this.f.size();
        bd[] arrbd = new bd[n3];
        for (int i2 = n3 - 1; i2 >= 0; --i2) {
            arrbd[i2] = (bd)this.f.c(i2);
        }
        boolean bl2 = false;
        while (n2 < n3) {
            bd bd2 = arrbd[n2];
            if (bd2.f) {
                bl2 = true;
            } else {
                bd2.h();
                this.f.remove(bd2.d);
            }
            ++n2;
        }
        return null;
    }
}

