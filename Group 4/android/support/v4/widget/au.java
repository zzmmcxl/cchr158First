/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.support.v4.widget.at;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class au
implements at {
    au() {
    }

    @Override
    public Object a(Context context, Interpolator interpolator) {
        if (interpolator == null) return new Scroller(context);
        return new Scroller(context, interpolator);
    }

    @Override
    public void a(Object object, int n2, int n3, int n4, int n5) {
        ((Scroller)object).startScroll(n2, n3, n4, n5);
    }

    @Override
    public void a(Object object, int n2, int n3, int n4, int n5, int n6) {
        ((Scroller)object).startScroll(n2, n3, n4, n5, n6);
    }

    @Override
    public void a(Object object, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        ((Scroller)object).fling(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    @Override
    public void a(Object object, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        ((Scroller)object).fling(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    @Override
    public boolean a(Object object) {
        return ((Scroller)object).isFinished();
    }

    @Override
    public boolean a(Object object, int n2, int n3, int n4, int n5, int n6, int n7) {
        return false;
    }

    @Override
    public int b(Object object) {
        return ((Scroller)object).getCurrX();
    }

    @Override
    public int c(Object object) {
        return ((Scroller)object).getCurrY();
    }

    @Override
    public float d(Object object) {
        return 0.0f;
    }

    @Override
    public boolean e(Object object) {
        return ((Scroller)object).computeScrollOffset();
    }

    @Override
    public void f(Object object) {
        ((Scroller)object).abortAnimation();
    }

    @Override
    public int g(Object object) {
        return ((Scroller)object).getFinalX();
    }

    @Override
    public int h(Object object) {
        return ((Scroller)object).getFinalY();
    }
}

