/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.bu;
import android.support.v7.widget.bx;
import android.support.v7.widget.fi;
import android.support.v7.widget.fj;
import android.view.View;

class bt
implements bx {
    bt() {
    }

    @Override
    public float a(bu bu2) {
        return ((fi)bu2.getBackground()).a();
    }

    @Override
    public void a() {
    }

    @Override
    public void a(bu bu2, float f2) {
        ((fi)bu2.getBackground()).a(f2);
    }

    @Override
    public void a(bu bu2, int n2) {
        ((fi)bu2.getBackground()).a(n2);
    }

    @Override
    public void a(bu bu2, Context context, int n2, float f2, float f3, float f4) {
        bu2.setBackgroundDrawable(new fi(n2, f2));
        View view = (View)bu2;
        view.setClipToOutline(true);
        view.setElevation(f3);
        this.b(bu2, f4);
    }

    @Override
    public float b(bu bu2) {
        return 2.0f * this.d(bu2);
    }

    @Override
    public void b(bu bu2, float f2) {
        ((fi)bu2.getBackground()).a(f2, bu2.getUseCompatPadding(), bu2.getPreventCornerOverlap());
        this.f(bu2);
    }

    @Override
    public float c(bu bu2) {
        return 2.0f * this.d(bu2);
    }

    @Override
    public void c(bu bu2, float f2) {
        ((View)bu2).setElevation(f2);
    }

    @Override
    public float d(bu bu2) {
        return ((fi)bu2.getBackground()).b();
    }

    @Override
    public float e(bu bu2) {
        return ((View)bu2).getElevation();
    }

    public void f(bu bu2) {
        if (!bu2.getUseCompatPadding()) {
            bu2.a(0, 0, 0, 0);
            return;
        }
        float f2 = this.a(bu2);
        float f3 = this.d(bu2);
        int n2 = (int)Math.ceil(fj.b(f2, f3, bu2.getPreventCornerOverlap()));
        int n3 = (int)Math.ceil(fj.a(f2, f3, bu2.getPreventCornerOverlap()));
        bu2.a(n2, n3, n2, n3);
    }

    @Override
    public void g(bu bu2) {
        this.b(bu2, this.a(bu2));
    }

    @Override
    public void h(bu bu2) {
        this.b(bu2, this.a(bu2));
    }
}

