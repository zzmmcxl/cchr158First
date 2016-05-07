/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.dx;
import android.support.v7.widget.dy;
import android.support.v7.widget.ep;
import android.view.View;

public abstract class dw {
    protected final ep a;
    private int b = Integer.MIN_VALUE;

    private dw(ep ep2) {
        this.a = ep2;
    }

    /* synthetic */ dw(ep ep2, dx dx2) {
        this(ep2);
    }

    public static dw a(ep ep2) {
        return new dx(ep2);
    }

    public static dw a(ep ep2, int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("invalid orientation");
            }
            case 0: {
                return dw.a(ep2);
            }
            case 1: 
        }
        return dw.b(ep2);
    }

    public static dw b(ep ep2) {
        return new dy(ep2);
    }

    public abstract int a(View var1);

    public void a() {
        this.b = this.f();
    }

    public abstract void a(int var1);

    public int b() {
        if (Integer.MIN_VALUE != this.b) return this.f() - this.b;
        return 0;
    }

    public abstract int b(View var1);

    public abstract int c();

    public abstract int c(View var1);

    public abstract int d();

    public abstract int d(View var1);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();
}

