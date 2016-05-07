/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.design.widget.a;
import android.support.design.widget.ad;
import android.support.design.widget.ak;
import android.support.design.widget.al;
import android.support.design.widget.ao;
import android.support.design.widget.au;
import android.support.design.widget.av;
import android.support.design.widget.ct;
import android.support.design.widget.m;
import android.support.v4.h.bo;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class aj
extends ad {
    private boolean m;

    aj(ct ct2, av av2) {
        super(ct2, av2);
    }

    static /* synthetic */ boolean a(aj aj2, boolean bl2) {
        aj2.m = bl2;
        return bl2;
    }

    private void e(float f2) {
        if (this.a != null) {
            this.a.a(- f2);
        }
        if (this.d == null) return;
        this.d.b(- f2);
    }

    @Override
    void a(ao ao2, boolean bl2) {
        if (this.m || this.k.getVisibility() != 0) {
            if (ao2 == null) return;
            ao2.b();
            return;
        }
        if (bo.A((View)this.k) && !this.k.isInEditMode()) {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator((TimeInterpolator)a.c).setListener((Animator.AnimatorListener)new ak(this, bl2, ao2));
            return;
        }
        this.k.a(8, bl2);
        if (ao2 == null) return;
        ao2.b();
    }

    @Override
    void b(ao ao2, boolean bl2) {
        if (!this.m) {
            if (this.k.getVisibility() == 0) return;
        }
        if (bo.A((View)this.k) && !this.k.isInEditMode()) {
            this.k.animate().cancel();
            if (this.k.getVisibility() != 0) {
                this.k.setAlpha(0.0f);
                this.k.setScaleY(0.0f);
                this.k.setScaleX(0.0f);
            }
            this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator((TimeInterpolator)a.d).setListener((Animator.AnimatorListener)new al(this, bl2, ao2));
            return;
        }
        this.k.a(0, bl2);
        this.k.setAlpha(1.0f);
        this.k.setScaleY(1.0f);
        this.k.setScaleX(1.0f);
        if (ao2 == null) return;
        ao2.a();
    }

    @Override
    boolean d() {
        return true;
    }

    @Override
    void e() {
        this.e(this.k.getRotation());
    }
}

