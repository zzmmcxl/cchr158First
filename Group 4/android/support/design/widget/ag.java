/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.ad;
import android.support.design.widget.ae;
import android.support.design.widget.au;
import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class ag
extends Animation {
    final /* synthetic */ ad a;
    private float b;
    private float c;

    private ag(ad ad2) {
        this.a = ad2;
    }

    /* synthetic */ ag(ad ad2, ae ae2) {
        this(ad2);
    }

    protected abstract float a();

    protected void applyTransformation(float f2, Transformation transformation) {
        this.a.a.b(this.b + f2 * this.c);
    }

    public void reset() {
        super.reset();
        this.b = this.a.a.a();
        this.c = this.a() - this.b;
    }
}

