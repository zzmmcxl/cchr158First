/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.h.at;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.b.l;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.b;
import android.support.v7.widget.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

abstract class a
extends ViewGroup {
    protected final b a;
    protected final Context b;
    protected ActionMenuView c;
    protected k d;
    protected int e;
    protected dc f;
    private boolean g;
    private boolean h;

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = new b(this);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.support.v7.b.b.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
            return;
        }
        this.b = context;
    }

    protected static int a(int n2, int n3, boolean bl2) {
        if (!bl2) return n2 + n3;
        return n2 - n3;
    }

    static /* synthetic */ void a(a a2, int n2) {
        a2.setVisibility(n2);
    }

    static /* synthetic */ void b(a a2, int n2) {
        a2.setVisibility(n2);
    }

    protected int a(View view, int n2, int n3, int n4) {
        view.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE), n3);
        return Math.max(0, n2 - view.getMeasuredWidth() - n4);
    }

    protected int a(View view, int n2, int n3, int n4, boolean bl2) {
        int n5 = view.getMeasuredWidth();
        int n6 = view.getMeasuredHeight();
        int n7 = n3 + (n4 - n6) / 2;
        if (bl2) {
            view.layout(n2 - n5, n7, n2, n6 + n7);
        } else {
            view.layout(n2, n7, n2 + n5, n6 + n7);
        }
        if (!bl2) return n5;
        return - n5;
    }

    public dc a(int n2, long l2) {
        if (this.f != null) {
            this.f.b();
        }
        if (n2 != 0) {
            dc dc2 = bo.q((View)this).a(0.0f);
            dc2.a(l2);
            dc2.a(this.a.a(dc2, n2));
            return dc2;
        }
        if (this.getVisibility() != 0) {
            bo.c((View)this, 0.0f);
        }
        dc dc3 = bo.q((View)this).a(1.0f);
        dc3.a(l2);
        dc3.a(this.a.a(dc3, n2));
        return dc3;
    }

    public boolean a() {
        if (this.d == null) return false;
        return this.d.d();
    }

    public int getAnimatedVisibility() {
        if (this.f == null) return this.getVisibility();
        return this.a.a;
    }

    public int getContentHeight() {
        return this.e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray typedArray = this.getContext().obtainStyledAttributes(null, l.ActionBar, android.support.v7.b.b.actionBarStyle, 0);
        this.setContentHeight(typedArray.getLayoutDimension(l.ActionBar_height, 0));
        typedArray.recycle();
        if (this.d == null) return;
        this.d.a(configuration);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n2 = at.a(motionEvent);
        if (n2 == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean bl2 = super.onHoverEvent(motionEvent);
            if (n2 == 9 && !bl2) {
                this.h = true;
            }
        }
        if (n2 != 10) {
            if (n2 != 3) return true;
        }
        this.h = false;
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = at.a(motionEvent);
        if (n2 == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean bl2 = super.onTouchEvent(motionEvent);
            if (n2 == 0 && !bl2) {
                this.g = true;
            }
        }
        if (n2 != 1) {
            if (n2 != 3) return true;
        }
        this.g = false;
        return true;
    }

    public void setContentHeight(int n2) {
        this.e = n2;
        this.requestLayout();
    }

    public void setVisibility(int n2) {
        if (n2 == this.getVisibility()) return;
        if (this.f != null) {
            this.f.b();
        }
        super.setVisibility(n2);
    }
}

