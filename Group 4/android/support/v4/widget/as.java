/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.at;
import android.support.v4.widget.au;
import android.support.v4.widget.av;
import android.support.v4.widget.aw;
import android.view.animation.Interpolator;

public final class as {
    Object a;
    at b;

    private as(int n2, Context context, Interpolator interpolator) {
        this.b = n2 >= 14 ? new aw() : (n2 >= 9 ? new av() : new au());
        this.a = this.b.a(context, interpolator);
    }

    public static as a(Context context) {
        return as.a(context, null);
    }

    public static as a(Context context, Interpolator interpolator) {
        return new as(Build.VERSION.SDK_INT, context, interpolator);
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.b.a(this.a, n2, n3, n4, n5);
    }

    public void a(int n2, int n3, int n4, int n5, int n6) {
        this.b.a(this.a, n2, n3, n4, n5, n6);
    }

    public void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.b.a(this.a, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        this.b.a(this.a, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
    }

    public boolean a() {
        return this.b.a(this.a);
    }

    public boolean a(int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.b.a(this.a, n2, n3, n4, n5, n6, n7);
    }

    public int b() {
        return this.b.b(this.a);
    }

    public int c() {
        return this.b.c(this.a);
    }

    public int d() {
        return this.b.g(this.a);
    }

    public int e() {
        return this.b.h(this.a);
    }

    public float f() {
        return this.b.d(this.a);
    }

    public boolean g() {
        return this.b.e(this.a);
    }

    public void h() {
        this.b.f(this.a);
    }
}

