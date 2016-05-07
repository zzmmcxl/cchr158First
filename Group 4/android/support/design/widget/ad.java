/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.b;
import android.support.design.widget.a;
import android.support.design.widget.ae;
import android.support.design.widget.af;
import android.support.design.widget.ah;
import android.support.design.widget.ai;
import android.support.design.widget.am;
import android.support.design.widget.ao;
import android.support.design.widget.au;
import android.support.design.widget.av;
import android.support.design.widget.bn;
import android.support.design.widget.ct;
import android.support.design.widget.m;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

class ad
extends am {
    au a;
    private int m;
    private bn n;
    private boolean o;

    ad(ct ct2, av av2) {
        super(ct2, av2);
        this.m = ct2.getResources().getInteger(17694720);
        this.n = new bn();
        this.n.a((View)ct2);
        this.n.a(h, this.a(new ah(this, null)));
        this.n.a(i, this.a(new ah(this, null)));
        this.n.a(j, this.a(new ai(this, null)));
    }

    private Animation a(Animation animation) {
        animation.setInterpolator(a.b);
        animation.setDuration((long)this.m);
        return animation;
    }

    static /* synthetic */ boolean a(ad ad2, boolean bl2) {
        ad2.o = bl2;
        return bl2;
    }

    private static ColorStateList b(int n2) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        arrarrn[0] = i;
        arrn[0] = n2;
        arrarrn[1] = h;
        arrn[1] = n2;
        arrarrn[2] = new int[0];
        arrn[2] = 0;
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    @Override
    float a() {
        return this.f;
    }

    @Override
    void a(float f2) {
        if (this.a == null) return;
        this.a.a(f2, f2 + this.g);
        this.g();
    }

    @Override
    void a(int n2) {
        if (this.c == null) return;
        android.support.v4.c.a.a.a(this.c, ad.b(n2));
    }

    @Override
    void a(ColorStateList colorStateList) {
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, colorStateList);
        }
        if (this.d == null) return;
        this.d.a(colorStateList);
    }

    @Override
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, int n2, int n3) {
        Drawable[] arrdrawable;
        this.b = android.support.v4.c.a.a.f((Drawable)this.k());
        android.support.v4.c.a.a.a(this.b, colorStateList);
        if (mode != null) {
            android.support.v4.c.a.a.a(this.b, mode);
        }
        this.c = android.support.v4.c.a.a.f((Drawable)this.k());
        android.support.v4.c.a.a.a(this.c, ad.b(n2));
        if (n3 > 0) {
            this.d = this.a(n3, colorStateList);
            arrdrawable = new Drawable[]{this.d, this.b, this.c};
        } else {
            this.d = null;
            arrdrawable = new Drawable[]{this.b, this.c};
        }
        this.e = new LayerDrawable(arrdrawable);
        this.a = new au(this.k.getResources(), this.e, this.l.a(), this.f, this.f + this.g);
        this.a.a(false);
        this.l.a(this.a);
    }

    @Override
    void a(PorterDuff.Mode mode) {
        if (this.b == null) return;
        android.support.v4.c.a.a.a(this.b, mode);
    }

    @Override
    void a(Rect rect) {
        this.a.getPadding(rect);
    }

    @Override
    void a(ao ao2, boolean bl2) {
        if (!this.o && this.k.getVisibility() == 0) {
            Animation animation = AnimationUtils.loadAnimation((Context)this.k.getContext(), (int)b.design_fab_out);
            animation.setInterpolator(a.c);
            animation.setDuration(200);
            animation.setAnimationListener((Animation.AnimationListener)new ae(this, bl2, ao2));
            this.k.startAnimation(animation);
            return;
        }
        if (ao2 == null) return;
        ao2.b();
    }

    @Override
    void a(int[] arrn) {
        this.n.a(arrn);
    }

    @Override
    void b() {
        this.n.b();
    }

    @Override
    void b(float f2) {
        if (this.a == null) return;
        this.a.c(f2 + this.f);
        this.g();
    }

    @Override
    void b(ao ao2, boolean bl2) {
        if (this.k.getVisibility() == 0 && !this.o) {
            if (ao2 == null) return;
            ao2.a();
            return;
        }
        this.k.clearAnimation();
        this.k.a(0, bl2);
        Animation animation = AnimationUtils.loadAnimation((Context)this.k.getContext(), (int)b.design_fab_in);
        animation.setDuration(200);
        animation.setInterpolator(a.d);
        animation.setAnimationListener((Animation.AnimationListener)new af(this, ao2));
        this.k.startAnimation(animation);
    }

    @Override
    void c() {
    }
}

