/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.design.b;
import android.support.design.widget.Snackbar$SnackbarLayout;
import android.support.design.widget.a;
import android.support.design.widget.aw;
import android.support.design.widget.ax;
import android.support.design.widget.ay;
import android.support.design.widget.az;
import android.support.design.widget.bb;
import android.support.design.widget.bc;
import android.support.design.widget.bd;
import android.support.design.widget.be;
import android.support.design.widget.bf;
import android.support.design.widget.bg;
import android.support.design.widget.bh;
import android.support.design.widget.bi;
import android.support.design.widget.bj;
import android.support.design.widget.bl;
import android.support.design.widget.br;
import android.support.design.widget.q;
import android.support.design.widget.t;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public final class Snackbar {
    private static final Handler a = new Handler(Looper.getMainLooper(), (Handler.Callback)new aw());
    private final ViewGroup b;
    private final Snackbar$SnackbarLayout c;
    private bg d;
    private final AccessibilityManager e;
    private final bl f;

    static /* synthetic */ bl a(Snackbar snackbar) {
        return snackbar.f;
    }

    static /* synthetic */ void a(Snackbar snackbar, int n2) {
        snackbar.b(n2);
    }

    private void b(int n2) {
        bj.a().a(this.f, n2);
    }

    static /* synthetic */ void b(Snackbar snackbar) {
        snackbar.d();
    }

    static /* synthetic */ void b(Snackbar snackbar, int n2) {
        snackbar.d(n2);
    }

    static /* synthetic */ Handler c() {
        return a;
    }

    static /* synthetic */ Snackbar$SnackbarLayout c(Snackbar snackbar) {
        return snackbar.c;
    }

    private void c(int n2) {
        if (Build.VERSION.SDK_INT >= 14) {
            bo.q((View)this.c).c(this.c.getHeight()).a(a.b).a(250).a(new be(this, n2)).c();
            return;
        }
        Animation animation = AnimationUtils.loadAnimation((Context)this.c.getContext(), (int)b.design_snackbar_out);
        animation.setInterpolator(a.b);
        animation.setDuration(250);
        animation.setAnimationListener((Animation.AnimationListener)new ax(this, n2));
        this.c.startAnimation(animation);
    }

    static /* synthetic */ AccessibilityManager d(Snackbar snackbar) {
        return snackbar.e;
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 14) {
            bo.b((View)this.c, (float)this.c.getHeight());
            bo.q((View)this.c).c(0.0f).a(a.b).a(250).a(new bc(this)).c();
            return;
        }
        Animation animation = AnimationUtils.loadAnimation((Context)this.c.getContext(), (int)b.design_snackbar_in);
        animation.setInterpolator(a.b);
        animation.setDuration(250);
        animation.setAnimationListener((Animation.AnimationListener)new bd(this));
        this.c.startAnimation(animation);
    }

    private void d(int n2) {
        ViewParent viewParent;
        bj.a().a(this.f);
        if (this.d != null) {
            this.d.a(this, n2);
        }
        if (!((viewParent = this.c.getParent()) instanceof ViewGroup)) return;
        ((ViewGroup)viewParent).removeView((View)this.c);
    }

    private void e() {
        bj.a().b(this.f);
        if (this.d == null) return;
        this.d.a(this);
    }

    static /* synthetic */ void e(Snackbar snackbar) {
        snackbar.e();
    }

    final void a(int n2) {
        if (this.c.getVisibility() != 0) {
            this.d(n2);
            return;
        }
        this.c(n2);
    }

    public boolean a() {
        return bj.a().e(this.f);
    }

    final void b() {
        if (this.c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof t) {
                bf bf2 = new bf(this);
                bf2.a(0.1f);
                bf2.b(0.6f);
                bf2.a(0);
                bf2.a(new ay(this));
                ((t)layoutParams).a(bf2);
            }
            this.b.addView((View)this.c);
        }
        this.c.setOnAttachStateChangeListener(new az(this));
        if (bo.A((View)this.c)) {
            this.d();
            return;
        }
        this.c.setOnLayoutChangeListener(new bb(this));
    }
}

