/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.bv;
import android.support.design.widget.bw;
import android.support.design.widget.by;
import android.support.design.widget.ca;
import android.view.animation.Interpolator;

class bu {
    private final by a;

    bu(by by2) {
        this.a = by2;
    }

    public void a() {
        this.a.a();
    }

    public void a(float f2, float f3) {
        this.a.a(f2, f3);
    }

    public void a(int n2) {
        this.a.a(n2);
    }

    public void a(int n2, int n3) {
        this.a.a(n2, n3);
    }

    public void a(bw bw2) {
        if (bw2 != null) {
            this.a.a(new bv(this, bw2));
            return;
        }
        this.a.a((ca)null);
    }

    public void a(Interpolator interpolator) {
        this.a.a(interpolator);
    }

    public boolean b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public float d() {
        return this.a.d();
    }

    public void e() {
        this.a.e();
    }
}

