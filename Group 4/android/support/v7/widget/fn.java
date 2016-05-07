/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.d;
import android.support.v7.b.b;
import android.support.v7.view.a;
import android.support.v7.widget.bj;
import android.support.v7.widget.cz;
import android.support.v7.widget.da;
import android.support.v7.widget.fo;
import android.support.v7.widget.fp;
import android.support.v7.widget.fq;
import android.support.v7.widget.fr;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class fn
extends HorizontalScrollView
implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private fq d;
    private cz e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    static /* synthetic */ cz a(fn fn2) {
        return fn2.e;
    }

    private fr a(d d2, boolean bl2) {
        fr fr2 = new fr(this, this.getContext(), d2, bl2);
        if (bl2) {
            fr2.setBackgroundDrawable(null);
            fr2.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.h));
            return fr2;
        }
        fr2.setFocusable(true);
        if (this.d == null) {
            this.d = new fq(this, null);
        }
        fr2.setOnClickListener((View.OnClickListener)this.d);
        return fr2;
    }

    static /* synthetic */ fr a(fn fn2, d d2, boolean bl2) {
        return fn2.a(d2, bl2);
    }

    private boolean a() {
        if (this.f == null) return false;
        if (this.f.getParent() != this) return false;
        return true;
    }

    private void b() {
        if (this.a()) {
            return;
        }
        if (this.f == null) {
            this.f = this.d();
        }
        this.removeView((View)this.e);
        this.addView((View)this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter)new fp(this, null));
        }
        if (this.a != null) {
            this.removeCallbacks(this.a);
            this.a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (!this.a()) {
            return false;
        }
        this.removeView((View)this.f);
        this.addView((View)this.e, new ViewGroup.LayoutParams(-2, -1));
        this.setTabSelected(this.f.getSelectedItemPosition());
        return false;
    }

    private Spinner d() {
        bj bj2 = new bj(this.getContext(), null, b.actionDropDownStyle);
        bj2.setLayoutParams((ViewGroup.LayoutParams)new da(-2, -1));
        bj2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
        return bj2;
    }

    public void a(int n2) {
        View view = this.e.getChildAt(n2);
        if (this.a != null) {
            this.removeCallbacks(this.a);
        }
        this.a = new fo(this, view);
        this.post(this.a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a == null) return;
        this.post(this.a);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a a2 = a.a(this.getContext());
        this.setContentHeight(a2.e());
        this.c = a2.g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a == null) return;
        this.removeCallbacks(this.a);
    }

    public void onItemSelected(AdapterView adapterView, View view, int n2, long l2) {
        ((fr)view).b().d();
    }

    public void onMeasure(int n2, int n3) {
        int n4 = 1;
        int n5 = View.MeasureSpec.getMode((int)n2);
        int n6 = n5 == 1073741824 ? n4 : 0;
        this.setFillViewport((boolean)n6);
        int n7 = this.e.getChildCount();
        if (n7 > n4 && (n5 == 1073741824 || n5 == Integer.MIN_VALUE)) {
            this.b = n7 > 2 ? (int)(0.4f * (float)View.MeasureSpec.getSize((int)n2)) : View.MeasureSpec.getSize((int)n2) / 2;
            this.b = Math.min(this.b, this.c);
        } else {
            this.b = -1;
        }
        int n8 = View.MeasureSpec.makeMeasureSpec((int)this.h, (int)1073741824);
        if (n6 != 0 || !this.g) {
            n4 = 0;
        }
        if (n4 != 0) {
            this.e.measure(0, n8);
            if (this.e.getMeasuredWidth() > View.MeasureSpec.getSize((int)n2)) {
                this.b();
            } else {
                this.c();
            }
        } else {
            this.c();
        }
        int n9 = this.getMeasuredWidth();
        super.onMeasure(n2, n8);
        int n10 = this.getMeasuredWidth();
        if (n6 == 0) return;
        if (n9 == n10) return;
        this.setTabSelected(this.i);
    }

    public void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean bl2) {
        this.g = bl2;
    }

    public void setContentHeight(int n2) {
        this.h = n2;
        this.requestLayout();
    }

    public void setTabSelected(int n2) {
        this.i = n2;
        int n3 = this.e.getChildCount();
        int n4 = 0;
        do {
            if (n4 >= n3) {
                if (this.f == null) return;
                if (n2 < 0) return;
                this.f.setSelection(n2);
                return;
            }
            View view = this.e.getChildAt(n4);
            boolean bl2 = n4 == n2;
            view.setSelected(bl2);
            if (bl2) {
                this.a(n2);
            }
            ++n4;
        } while (true);
    }
}

