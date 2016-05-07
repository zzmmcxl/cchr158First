/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.d;
import android.support.design.widget.an;
import android.support.design.widget.ao;
import android.support.design.widget.av;
import android.support.design.widget.ct;
import android.support.design.widget.m;
import android.view.ViewTreeObserver;

abstract class am {
    static final int[] h = new int[]{16842919, 16842910};
    static final int[] i = new int[]{16842908, 16842910};
    static final int[] j = new int[0];
    private final Rect a = new Rect();
    Drawable b;
    Drawable c;
    m d;
    Drawable e;
    float f;
    float g;
    final ct k;
    final av l;
    private ViewTreeObserver.OnPreDrawListener m;

    am(ct ct2, av av2) {
        this.k = ct2;
        this.l = av2;
    }

    private void l() {
        if (this.m != null) return;
        this.m = new an(this);
    }

    abstract float a();

    m a(int n2, ColorStateList colorStateList) {
        Resources resources = this.k.getResources();
        m m2 = this.j();
        m2.a(resources.getColor(d.design_fab_stroke_top_outer_color), resources.getColor(d.design_fab_stroke_top_inner_color), resources.getColor(d.design_fab_stroke_end_inner_color), resources.getColor(d.design_fab_stroke_end_outer_color));
        m2.a(n2);
        m2.a(colorStateList);
        return m2;
    }

    abstract void a(float var1);

    abstract void a(int var1);

    abstract void a(ColorStateList var1);

    abstract void a(ColorStateList var1, PorterDuff.Mode var2, int var3, int var4);

    abstract void a(PorterDuff.Mode var1);

    abstract void a(Rect var1);

    abstract void a(ao var1, boolean var2);

    abstract void a(int[] var1);

    abstract void b();

    abstract void b(float var1);

    void b(Rect rect) {
    }

    abstract void b(ao var1, boolean var2);

    abstract void c();

    final void c(float f2) {
        if (this.f == f2) return;
        this.f = f2;
        this.a(f2);
    }

    final void d(float f2) {
        if (this.g == f2) return;
        this.g = f2;
        this.b(f2);
    }

    boolean d() {
        return false;
    }

    void e() {
    }

    final Drawable f() {
        return this.e;
    }

    final void g() {
        Rect rect = this.a;
        this.a(rect);
        this.b(rect);
        this.l.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void h() {
        if (!this.d()) return;
        this.l();
        this.k.getViewTreeObserver().addOnPreDrawListener(this.m);
    }

    void i() {
        if (this.m == null) return;
        this.k.getViewTreeObserver().removeOnPreDrawListener(this.m);
        this.m = null;
    }

    m j() {
        return new m();
    }

    GradientDrawable k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}

