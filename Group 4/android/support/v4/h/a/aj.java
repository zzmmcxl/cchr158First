/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.os.Build;
import android.support.v4.h.a.ak;
import android.support.v4.h.a.al;
import android.support.v4.h.a.am;
import android.support.v4.h.a.an;
import android.support.v4.h.a.ao;

public class aj {
    private static final am a;
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new an();
            return;
        }
        if (Build.VERSION.SDK_INT >= 15) {
            a = new al();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a = new ak();
            return;
        }
        a = new ao();
    }

    public aj(Object object) {
        this.b = object;
    }

    public void a(int n2) {
        a.b(this.b, n2);
    }

    public void a(boolean bl2) {
        a.a(this.b, bl2);
    }

    public void b(int n2) {
        a.a(this.b, n2);
    }

    public void c(int n2) {
        a.e(this.b, n2);
    }

    public void d(int n2) {
        a.c(this.b, n2);
    }

    public void e(int n2) {
        a.d(this.b, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        aj aj2 = (aj)object;
        if (this.b == null) {
            if (aj2.b == null) return true;
            return false;
        }
        if (this.b.equals(aj2.b)) return true;
        return false;
    }

    public void f(int n2) {
        a.f(this.b, n2);
    }

    public void g(int n2) {
        a.g(this.b, n2);
    }

    public int hashCode() {
        if (this.b != null) return this.b.hashCode();
        return 0;
    }
}

