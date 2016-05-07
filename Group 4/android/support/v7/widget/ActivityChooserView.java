/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.h.n;
import android.support.v7.b.j;
import android.support.v7.widget.ag;
import android.support.v7.widget.ah;
import android.support.v7.widget.cz;
import android.support.v7.widget.df;
import android.support.v7.widget.z;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public class ActivityChooserView
extends ViewGroup {
    n a;
    private final ag b;
    private final ah c;
    private final cz d;
    private final FrameLayout e;
    private final ImageView f;
    private final FrameLayout g;
    private final int h;
    private final DataSetObserver i;
    private final ViewTreeObserver.OnGlobalLayoutListener j;
    private df k;
    private PopupWindow.OnDismissListener l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;

    static /* synthetic */ ag a(ActivityChooserView activityChooserView) {
        return activityChooserView.b;
    }

    private void a(int n2) {
        df df2;
        if (this.b.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        this.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        boolean bl2 = this.g.getVisibility() == 0;
        int n3 = this.b.c();
        int n4 = bl2 ? 1 : 0;
        if (n2 != Integer.MAX_VALUE && n3 > n4 + n2) {
            this.b.a(true);
            this.b.a(n2 - 1);
        } else {
            this.b.a(false);
            this.b.a(n2);
        }
        if ((df2 = this.getListPopupWindow()).k()) return;
        if (this.m || !bl2) {
            this.b.a(true, bl2);
        } else {
            this.b.a(false, false);
        }
        df2.f(Math.min(this.b.a(), this.h));
        df2.c();
        if (this.a != null) {
            this.a.a(true);
        }
        df2.m().setContentDescription((CharSequence)this.getContext().getString(j.abc_activitychooserview_choose_application));
    }

    static /* synthetic */ void a(ActivityChooserView activityChooserView, int n2) {
        activityChooserView.a(n2);
    }

    static /* synthetic */ boolean a(ActivityChooserView activityChooserView, boolean bl2) {
        activityChooserView.m = bl2;
        return bl2;
    }

    static /* synthetic */ boolean b(ActivityChooserView activityChooserView) {
        return activityChooserView.m;
    }

    static /* synthetic */ FrameLayout c(ActivityChooserView activityChooserView) {
        return activityChooserView.g;
    }

    static /* synthetic */ FrameLayout d(ActivityChooserView activityChooserView) {
        return activityChooserView.e;
    }

    static /* synthetic */ int e(ActivityChooserView activityChooserView) {
        return activityChooserView.n;
    }

    static /* synthetic */ PopupWindow.OnDismissListener f(ActivityChooserView activityChooserView) {
        return activityChooserView.l;
    }

    static /* synthetic */ DataSetObserver g(ActivityChooserView activityChooserView) {
        return activityChooserView.i;
    }

    private df getListPopupWindow() {
        if (this.k != null) return this.k;
        this.k = new df(this.getContext());
        this.k.a((ListAdapter)this.b);
        this.k.a((View)this);
        this.k.a(true);
        this.k.a(this.c);
        this.k.a(this.c);
        return this.k;
    }

    public boolean a() {
        if (this.c()) return false;
        if (!this.o) {
            return false;
        }
        this.m = false;
        this.a(this.n);
        return true;
    }

    public boolean b() {
        if (!this.c()) return true;
        this.getListPopupWindow().i();
        ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) return true;
        viewTreeObserver.removeGlobalOnLayoutListener(this.j);
        return true;
    }

    public boolean c() {
        return this.getListPopupWindow().k();
    }

    public z getDataModel() {
        return this.b.d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        z z2 = this.b.d();
        if (z2 != null) {
            z2.registerObserver((Object)this.i);
        }
        this.o = true;
    }

    protected void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        z z2 = this.b.d();
        if (z2 != null) {
            z2.unregisterObserver((Object)this.i);
        }
        if ((viewTreeObserver = this.getViewTreeObserver()).isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.j);
        }
        if (this.c()) {
            this.b();
        }
        this.o = false;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        this.d.layout(0, 0, n4 - n2, n5 - n3);
        if (this.c()) return;
        this.b();
    }

    protected void onMeasure(int n2, int n3) {
        cz cz2 = this.d;
        if (this.g.getVisibility() != 0) {
            n3 = View.MeasureSpec.makeMeasureSpec((int)View.MeasureSpec.getSize((int)n3), (int)1073741824);
        }
        this.measureChild((View)cz2, n2, n3);
        this.setMeasuredDimension(cz2.getMeasuredWidth(), cz2.getMeasuredHeight());
    }

    public void setActivityChooserModel(z z2) {
        this.b.a(z2);
        if (!this.c()) return;
        this.b();
        this.a();
    }

    public void setDefaultActionButtonContentDescription(int n2) {
        this.p = n2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int n2) {
        String string = this.getContext().getString(n2);
        this.f.setContentDescription((CharSequence)string);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int n2) {
        this.n = n2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void setProvider(n n2) {
        this.a = n2;
    }
}

