/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.design.widget.by;
import android.support.design.widget.ca;
import android.support.design.widget.ce;
import android.view.animation.Interpolator;

class cd
extends by {
    final ValueAnimator a = new ValueAnimator();

    cd() {
    }

    @Override
    public void a() {
        this.a.start();
    }

    @Override
    public void a(float f2, float f3) {
        this.a.setFloatValues(new float[]{f2, f3});
    }

    @Override
    public void a(int n2) {
        this.a.setDuration((long)n2);
    }

    @Override
    public void a(int n2, int n3) {
        this.a.setIntValues(new int[]{n2, n3});
    }

    @Override
    public void a(ca ca2) {
        this.a.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ce(this, ca2));
    }

    @Override
    public void a(Interpolator interpolator) {
        this.a.setInterpolator((TimeInterpolator)interpolator);
    }

    @Override
    public boolean b() {
        return this.a.isRunning();
    }

    @Override
    public int c() {
        return (Integer)this.a.getAnimatedValue();
    }

    @Override
    public float d() {
        return ((Float)this.a.getAnimatedValue()).floatValue();
    }

    @Override
    public void e() {
        this.a.cancel();
    }
}

