/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.bu;
import android.support.v7.widget.bw;
import android.support.v7.widget.bx;
import android.support.v7.widget.fj;
import android.support.v7.widget.fk;
import android.view.View;

class bv
implements bx {
    final RectF a = new RectF();

    bv() {
    }

    private fj i(bu bu2) {
        return (fj)bu2.getBackground();
    }

    @Override
    public float a(bu bu2) {
        return this.i(bu2).c();
    }

    fj a(Context context, int n2, float f2, float f3, float f4) {
        return new fj(context.getResources(), n2, f2, f3, f4);
    }

    @Override
    public void a() {
        fj.c = new bw(this);
    }

    @Override
    public void a(bu bu2, float f2) {
        this.i(bu2).a(f2);
        this.f(bu2);
    }

    @Override
    public void a(bu bu2, int n2) {
        this.i(bu2).a(n2);
    }

    @Override
    public void a(bu bu2, Context context, int n2, float f2, float f3, float f4) {
        fj fj2 = this.a(context, n2, f2, f3, f4);
        fj2.a(bu2.getPreventCornerOverlap());
        bu2.setBackgroundDrawable(fj2);
        this.f(bu2);
    }

    @Override
    public float b(bu bu2) {
        return this.i(bu2).d();
    }

    @Override
    public void b(bu bu2, float f2) {
        this.i(bu2).c(f2);
        this.f(bu2);
    }

    @Override
    public float c(bu bu2) {
        return this.i(bu2).e();
    }

    @Override
    public void c(bu bu2, float f2) {
        this.i(bu2).b(f2);
    }

    @Override
    public float d(bu bu2) {
        return this.i(bu2).a();
    }

    @Override
    public float e(bu bu2) {
        return this.i(bu2).b();
    }

    public void f(bu bu2) {
        Rect rect = new Rect();
        this.i(bu2).a(rect);
        ((View)bu2).setMinimumHeight((int)Math.ceil(this.c(bu2)));
        ((View)bu2).setMinimumWidth((int)Math.ceil(this.b(bu2)));
        bu2.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override
    public void g(bu bu2) {
    }

    @Override
    public void h(bu bu2) {
        this.i(bu2).a(bu2.getPreventCornerOverlap());
        this.f(bu2);
    }
}

