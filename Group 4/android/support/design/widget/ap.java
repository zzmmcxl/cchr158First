/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.aj;
import android.support.design.widget.au;
import android.support.design.widget.av;
import android.support.design.widget.ct;
import android.support.design.widget.m;
import android.support.design.widget.n;
import android.support.v4.c.a.a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(value=21)
class ap
extends aj {
    private final Interpolator m;
    private InsetDrawable n;

    ap(ct ct2, av av2) {
        super(ct2, av2);
        Interpolator interpolator = ct2.isInEditMode() ? null : AnimationUtils.loadInterpolator((Context)this.k.getContext(), (int)17563661);
        this.m = interpolator;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator((TimeInterpolator)this.m);
        return animator;
    }

    @Override
    public float a() {
        return this.k.getElevation();
    }

    @Override
    public void a(float f2) {
        this.k.setElevation(f2);
        if (!this.l.b()) return;
        this.g();
    }

    @Override
    void a(int n2) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable)this.c).setColor(ColorStateList.valueOf((int)n2));
            return;
        }
        super.a(n2);
    }

    @Override
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, int n2, int n3) {
        Drawable drawable;
        this.b = a.f((Drawable)this.k());
        a.a(this.b, colorStateList);
        if (mode != null) {
            a.a(this.b, mode);
        }
        if (n3 > 0) {
            this.d = this.a(n3, colorStateList);
            Drawable[] arrdrawable = new Drawable[]{this.d, this.b};
            drawable = new LayerDrawable(arrdrawable);
        } else {
            this.d = null;
            drawable = this.b;
        }
        this.e = this.c = new RippleDrawable(ColorStateList.valueOf((int)n2), drawable, null);
        this.l.a(this.c);
    }

    @Override
    void a(Rect rect) {
        if (this.l.b()) {
            float f2 = this.l.a();
            float f3 = this.a() + this.g;
            int n2 = (int)Math.ceil(au.b(f3, f2, false));
            int n3 = (int)Math.ceil(au.a(f3, f2, false));
            rect.set(n2, n3, n2, n3);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    @Override
    void a(int[] arrn) {
    }

    @Override
    void b() {
    }

    @Override
    void b(float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, this.a((Animator)ObjectAnimator.ofFloat((Object)this.k, (String)"translationZ", (float[])new float[]{f2})));
        stateListAnimator.addState(i, this.a((Animator)ObjectAnimator.ofFloat((Object)this.k, (String)"translationZ", (float[])new float[]{f2})));
        stateListAnimator.addState(j, this.a((Animator)ObjectAnimator.ofFloat((Object)this.k, (String)"translationZ", (float[])new float[]{0.0f})));
        this.k.setStateListAnimator(stateListAnimator);
        if (!this.l.b()) return;
        this.g();
    }

    @Override
    void b(Rect rect) {
        if (this.l.b()) {
            this.n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.a((Drawable)this.n);
            return;
        }
        this.l.a(this.c);
    }

    @Override
    void c() {
        this.g();
    }

    @Override
    boolean d() {
        return false;
    }

    @Override
    m j() {
        return new n();
    }
}

