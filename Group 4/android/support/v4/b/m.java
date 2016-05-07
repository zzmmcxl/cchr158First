/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.content.Context;
import android.support.v4.b.n;
import android.support.v4.b.o;
import android.support.v4.g.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class m {
    int f;
    o g;
    n h;
    Context i;
    boolean j = false;
    boolean k = false;
    boolean l = true;
    boolean m = false;
    boolean n = false;

    public m(Context context) {
        this.i = context.getApplicationContext();
    }

    protected void a() {
    }

    public void a(int n2, o o2) {
        if (this.g != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.g = o2;
        this.f = n2;
    }

    public void a(n n2) {
        if (this.h != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.h = n2;
    }

    public void a(o o2) {
        if (this.g == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.g != o2) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.g = null;
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string);
        printWriter.print("mId=");
        printWriter.print(this.f);
        printWriter.print(" mListener=");
        printWriter.println(this.g);
        if (this.j || this.m || this.n) {
            printWriter.print(string);
            printWriter.print("mStarted=");
            printWriter.print(this.j);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.m);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.n);
        }
        if (!this.k) {
            if (!this.l) return;
        }
        printWriter.print(string);
        printWriter.print("mAbandoned=");
        printWriter.print(this.k);
        printWriter.print(" mReset=");
        printWriter.println(this.l);
    }

    public void b(n n2) {
        if (this.h == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.h != n2) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.h = null;
    }

    public void b(Object object) {
        if (this.g == null) return;
        this.g.a(this, object);
    }

    protected boolean b() {
        return false;
    }

    public String c(Object object) {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(object, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void g() {
        if (this.h == null) return;
        this.h.a(this);
    }

    public boolean h() {
        return this.k;
    }

    public final void i() {
        this.j = true;
        this.l = false;
        this.k = false;
        this.j();
    }

    protected void j() {
    }

    public boolean k() {
        return this.b();
    }

    public void l() {
        this.a();
    }

    public void m() {
        this.j = false;
        this.n();
    }

    protected void n() {
    }

    public void o() {
        this.p();
        this.l = true;
        this.j = false;
        this.k = false;
        this.m = false;
        this.n = false;
    }

    protected void p() {
    }

    public void q() {
        this.n = false;
    }

    public void r() {
        if (!this.n) return;
        this.m = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

