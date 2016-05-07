/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.v4.h.a;
import android.support.v4.h.bc;
import android.support.v4.h.bg;
import android.support.v4.h.bh;
import android.support.v4.h.cb;
import android.support.v4.h.cc;
import android.support.v4.h.dc;
import android.support.v4.h.dw;
import android.view.View;
import java.util.WeakHashMap;

class bp
implements cb {
    WeakHashMap a = null;

    bp() {
    }

    private boolean a(bh bh2, int n2) {
        boolean bl2 = true;
        int n3 = bh2.computeHorizontalScrollOffset();
        int n4 = bh2.computeHorizontalScrollRange() - bh2.computeHorizontalScrollExtent();
        if (n4 == 0) {
            return false;
        }
        if (n2 < 0) {
            if (n3 > 0) return bl2;
            return false;
        }
        if (n3 < n4 - 1) return bl2;
        return false;
    }

    private boolean b(bh bh2, int n2) {
        boolean bl2 = true;
        int n3 = bh2.computeVerticalScrollOffset();
        int n4 = bh2.computeVerticalScrollRange() - bh2.computeVerticalScrollExtent();
        if (n4 == 0) {
            return false;
        }
        if (n2 < 0) {
            if (n3 > 0) return bl2;
            return false;
        }
        if (n3 < n4 - 1) return bl2;
        return false;
    }

    @Override
    public PorterDuff.Mode A(View view) {
        return cc.b(view);
    }

    @Override
    public void B(View view) {
        if (!(view instanceof bc)) return;
        ((bc)view).stopNestedScroll();
    }

    @Override
    public boolean C(View view) {
        return cc.c(view);
    }

    @Override
    public float D(View view) {
        return this.v(view) + this.u(view);
    }

    @Override
    public boolean E(View view) {
        return cc.f(view);
    }

    @Override
    public boolean F(View view) {
        return false;
    }

    @Override
    public int a(int n2, int n3) {
        return n2 | n3;
    }

    @Override
    public int a(int n2, int n3, int n4) {
        return View.resolveSize((int)n2, (int)n3);
    }

    @Override
    public int a(View view) {
        return 2;
    }

    long a() {
        return 10;
    }

    @Override
    public dw a(View view, dw dw2) {
        return dw2;
    }

    @Override
    public void a(View view, float f2) {
    }

    @Override
    public void a(View view, int n2, int n3) {
    }

    @Override
    public void a(View view, int n2, int n3, int n4, int n5) {
        view.setPadding(n2, n3, n4, n5);
    }

    @Override
    public void a(View view, int n2, Paint paint) {
    }

    @Override
    public void a(View view, ColorStateList colorStateList) {
        cc.a(view, colorStateList);
    }

    @Override
    public void a(View view, PorterDuff.Mode mode) {
        cc.a(view, mode);
    }

    @Override
    public void a(View view, a a2) {
    }

    @Override
    public void a(View view, bg bg2) {
    }

    @Override
    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, this.a());
    }

    @Override
    public void a(View view, Runnable runnable, long l2) {
        view.postDelayed(runnable, l2 + this.a());
    }

    @Override
    public void a(View view, boolean bl2) {
    }

    @Override
    public boolean a(View view, int n2) {
        if (!(view instanceof bh)) return false;
        if (!this.a((bh)view, n2)) return false;
        return true;
    }

    @Override
    public void b(View view, float f2) {
    }

    @Override
    public void b(View view, boolean bl2) {
    }

    @Override
    public boolean b(View view) {
        return false;
    }

    @Override
    public boolean b(View view, int n2) {
        if (!(view instanceof bh)) return false;
        if (!this.b((bh)view, n2)) return false;
        return true;
    }

    @Override
    public void c(View view, float f2) {
    }

    @Override
    public void c(View view, int n2) {
    }

    @Override
    public void c(View view, boolean bl2) {
    }

    @Override
    public boolean c(View view) {
        return false;
    }

    @Override
    public void d(View view) {
        view.invalidate();
    }

    @Override
    public void d(View view, float f2) {
    }

    @Override
    public void d(View view, int n2) {
    }

    @Override
    public int e(View view) {
        return 0;
    }

    @Override
    public void e(View view, int n2) {
        cc.b(view, n2);
    }

    @Override
    public float f(View view) {
        return 1.0f;
    }

    @Override
    public void f(View view, int n2) {
        cc.a(view, n2);
    }

    @Override
    public int g(View view) {
        return 0;
    }

    @Override
    public int h(View view) {
        return 0;
    }

    @Override
    public int i(View view) {
        return view.getMeasuredWidth();
    }

    @Override
    public int j(View view) {
        return 0;
    }

    @Override
    public int k(View view) {
        return view.getPaddingLeft();
    }

    @Override
    public int l(View view) {
        return view.getPaddingRight();
    }

    @Override
    public boolean m(View view) {
        return true;
    }

    @Override
    public float n(View view) {
        return 0.0f;
    }

    @Override
    public float o(View view) {
        return 0.0f;
    }

    @Override
    public int p(View view) {
        return cc.d(view);
    }

    @Override
    public int q(View view) {
        return cc.e(view);
    }

    @Override
    public dc r(View view) {
        return new dc(view);
    }

    @Override
    public int s(View view) {
        return 0;
    }

    @Override
    public void t(View view) {
    }

    public float u(View view) {
        return 0.0f;
    }

    public float v(View view) {
        return 0.0f;
    }

    @Override
    public boolean w(View view) {
        return false;
    }

    @Override
    public void x(View view) {
    }

    @Override
    public boolean y(View view) {
        return false;
    }

    @Override
    public ColorStateList z(View view) {
        return cc.a(view);
    }
}

