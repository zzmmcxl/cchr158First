/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v4.h.dv;
import android.support.v7.a.a;
import android.support.v7.a.bq;
import android.support.v7.a.br;
import android.support.v7.a.bs;
import android.support.v7.a.bt;
import android.support.v7.a.c;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.support.v7.b.l;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.cf;
import android.support.v7.widget.fn;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class bp
extends a
implements i {
    static final /* synthetic */ boolean h;
    private static final Interpolator i;
    private static final Interpolator j;
    private static final boolean k;
    private boolean A;
    private int B = 0;
    private boolean C = true;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G = true;
    private android.support.v7.view.l H;
    private boolean I;
    bt a;
    android.support.v7.view.b b;
    android.support.v7.view.c c;
    boolean d;
    final dt e;
    final dt f;
    final dv g;
    private Context l;
    private Context m;
    private Activity n;
    private Dialog o;
    private ActionBarOverlayLayout p;
    private ActionBarContainer q;
    private cf r;
    private ActionBarContextView s;
    private View t;
    private fn u;
    private ArrayList v = new ArrayList();
    private int w = -1;
    private boolean x;
    private boolean y;
    private ArrayList z = new ArrayList();

    static {
        boolean bl2 = true;
        boolean bl3 = !bp.class.desiredAssertionStatus() ? bl2 : false;
        h = bl3;
        i = new AccelerateInterpolator();
        j = new DecelerateInterpolator();
        if (Build.VERSION.SDK_INT < 14) {
            bl2 = false;
        }
        k = bl2;
    }

    public bp(Activity activity, boolean bl2) {
        this.e = new bq(this);
        this.f = new br(this);
        this.g = new bs(this);
        this.n = activity;
        View view = activity.getWindow().getDecorView();
        this.a(view);
        if (bl2) return;
        this.t = view.findViewById(16908290);
    }

    public bp(Dialog dialog) {
        this.e = new bq(this);
        this.f = new br(this);
        this.g = new bs(this);
        this.o = dialog;
        this.a(dialog.getWindow().getDecorView());
    }

    static /* synthetic */ android.support.v7.view.l a(bp bp2, android.support.v7.view.l l2) {
        bp2.H = l2;
        return l2;
    }

    private void a(View view) {
        android.support.v7.view.a a2;
        int n2;
        this.p = (ActionBarOverlayLayout)view.findViewById(g.decor_content_parent);
        if (this.p != null) {
            this.p.setActionBarVisibilityCallback(this);
        }
        this.r = this.b(view.findViewById(g.action_bar));
        this.s = (ActionBarContextView)view.findViewById(g.action_context_bar);
        this.q = (ActionBarContainer)view.findViewById(g.action_bar_container);
        if (this.r == null) throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        if (this.s == null) throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        if (this.q == null) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.l = this.r.b();
        boolean bl2 = (4 & this.r.o()) != 0;
        if (bl2) {
            this.x = true;
        }
        boolean bl3 = (a2 = android.support.v7.view.a.a(this.l)).f() || bl2;
        this.a(bl3);
        this.k(a2.d());
        TypedArray typedArray = this.l.obtainStyledAttributes(null, l.ActionBar, b.actionBarStyle, 0);
        if (typedArray.getBoolean(l.ActionBar_hideOnContentScroll, false)) {
            this.b(true);
        }
        if ((n2 = typedArray.getDimensionPixelSize(l.ActionBar_elevation, 0)) != 0) {
            this.a((float)n2);
        }
        typedArray.recycle();
    }

    static /* synthetic */ boolean a(bp bp2) {
        return bp2.C;
    }

    static /* synthetic */ boolean a(boolean bl2, boolean bl3, boolean bl4) {
        return bp.b(bl2, bl3, bl4);
    }

    private cf b(View view) {
        String string;
        if (view instanceof cf) {
            return (cf)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        if ("Can't make a decor toolbar out of " + (Object)view != null) {
            string = view.getClass().getSimpleName();
            throw new IllegalStateException(string);
        }
        string = "null";
        throw new IllegalStateException(string);
    }

    static /* synthetic */ View b(bp bp2) {
        return bp2.t;
    }

    private static boolean b(boolean bl2, boolean bl3, boolean bl4) {
        if (bl4) {
            return true;
        }
        if (bl2) return false;
        if (!bl3) return true;
        return false;
    }

    static /* synthetic */ ActionBarContainer c(bp bp2) {
        return bp2.q;
    }

    static /* synthetic */ ActionBarOverlayLayout d(bp bp2) {
        return bp2.p;
    }

    static /* synthetic */ boolean e(bp bp2) {
        return bp2.D;
    }

    static /* synthetic */ boolean f(bp bp2) {
        return bp2.E;
    }

    static /* synthetic */ ActionBarContextView g(bp bp2) {
        return bp2.s;
    }

    static /* synthetic */ cf h(bp bp2) {
        return bp2.r;
    }

    static /* synthetic */ Context i(bp bp2) {
        return bp2.l;
    }

    private void k(boolean bl2) {
        boolean bl3 = true;
        this.A = bl2;
        if (!this.A) {
            this.r.a((fn)null);
            this.q.setTabContainer(this.u);
        } else {
            this.q.setTabContainer(null);
            this.r.a(this.u);
        }
        boolean bl4 = this.j() == 2 ? bl3 : false;
        if (this.u != null) {
            if (bl4) {
                this.u.setVisibility(0);
                if (this.p != null) {
                    bo.s((View)this.p);
                }
            } else {
                this.u.setVisibility(8);
            }
        }
        cf cf2 = this.r;
        boolean bl5 = !this.A && bl4 ? bl3 : false;
        cf2.a(bl5);
        ActionBarOverlayLayout actionBarOverlayLayout = this.p;
        if (this.A || !bl4) {
            bl3 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(bl3);
    }

    private void l(boolean bl2) {
        if (bp.b(this.D, this.E, this.F)) {
            if (this.G) return;
            this.G = true;
            this.h(bl2);
            return;
        }
        if (!this.G) return;
        this.G = false;
        this.i(bl2);
    }

    private void p() {
        if (this.F) return;
        this.F = true;
        if (this.p != null) {
            this.p.setShowingForActionMode(true);
        }
        this.l(false);
    }

    private void q() {
        if (!this.F) return;
        this.F = false;
        if (this.p != null) {
            this.p.setShowingForActionMode(false);
        }
        this.l(false);
    }

    @Override
    public int a() {
        return this.r.o();
    }

    @Override
    public android.support.v7.view.b a(android.support.v7.view.c c2) {
        if (this.a != null) {
            this.a.c();
        }
        this.p.setHideOnContentScrollEnabled(false);
        this.s.c();
        bt bt2 = new bt(this, this.s.getContext(), c2);
        if (!bt2.e()) return null;
        bt2.d();
        this.s.a(bt2);
        this.j(true);
        this.s.sendAccessibilityEvent(32);
        this.a = bt2;
        return bt2;
    }

    @Override
    public void a(float f2) {
        bo.d((View)this.q, f2);
    }

    @Override
    public void a(int n2) {
        this.B = n2;
    }

    public void a(int n2, int n3) {
        int n4 = this.r.o();
        if ((n3 & 4) != 0) {
            this.x = true;
        }
        this.r.c(n2 & n3 | n4 & ~ n3);
    }

    @Override
    public void a(Configuration configuration) {
        this.k(android.support.v7.view.a.a(this.l).d());
    }

    @Override
    public void a(CharSequence charSequence) {
        this.r.a(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        this.r.b(bl2);
    }

    @Override
    public void b(boolean bl2) {
        if (bl2 && !this.p.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.d = bl2;
        this.p.setHideOnContentScrollEnabled(bl2);
    }

    @Override
    public boolean b() {
        int n2 = this.k();
        if (!this.G) return false;
        if (n2 == 0) return true;
        if (this.d() >= n2) return false;
        return true;
    }

    @Override
    public Context c() {
        if (this.m != null) return this.m;
        TypedValue typedValue = new TypedValue();
        this.l.getTheme().resolveAttribute(b.actionBarWidgetTheme, typedValue, true);
        int n2 = typedValue.resourceId;
        if (n2 != 0) {
            this.m = new ContextThemeWrapper(this.l, n2);
            return this.m;
        }
        this.m = this.l;
        return this.m;
    }

    @Override
    public void c(boolean bl2) {
        if (this.x) return;
        this.f(bl2);
    }

    @Override
    public int d() {
        return this.p.getActionBarHideOffset();
    }

    @Override
    public void d(boolean bl2) {
        this.I = bl2;
        if (bl2) return;
        if (this.H == null) return;
        this.H.b();
    }

    @Override
    public void e(boolean bl2) {
        if (bl2 == this.y) {
            return;
        }
        this.y = bl2;
        int n2 = this.z.size();
        int n3 = 0;
        while (n3 < n2) {
            ((c)this.z.get(n3)).a(bl2);
            ++n3;
        }
    }

    public void f(boolean bl2) {
        int n2 = bl2 ? 4 : 0;
        this.a(n2, 4);
    }

    @Override
    public boolean f() {
        if (this.r == null) return false;
        if (!this.r.c()) return false;
        this.r.d();
        return true;
    }

    @Override
    public void g(boolean bl2) {
        this.C = bl2;
    }

    @Override
    public boolean g() {
        ViewGroup viewGroup = this.r.a();
        if (viewGroup == null) return false;
        if (viewGroup.hasFocus()) return false;
        viewGroup.requestFocus();
        return true;
    }

    public void h(boolean bl2) {
        if (this.H != null) {
            this.H.b();
        }
        this.q.setVisibility(0);
        if (this.B == 0 && k && (this.I || bl2)) {
            bo.b((View)this.q, 0.0f);
            float f2 = - this.q.getHeight();
            if (bl2) {
                int[] arrn = new int[]{0, 0};
                this.q.getLocationInWindow(arrn);
                f2 -= (float)arrn[1];
            }
            bo.b((View)this.q, f2);
            android.support.v7.view.l l2 = new android.support.v7.view.l();
            dc dc2 = bo.q((View)this.q).c(0.0f);
            dc2.a(this.g);
            l2.a(dc2);
            if (this.C && this.t != null) {
                bo.b(this.t, f2);
                l2.a(bo.q(this.t).c(0.0f));
            }
            l2.a(j);
            l2.a(250);
            l2.a(this.f);
            this.H = l2;
            l2.a();
        } else {
            bo.c((View)this.q, 1.0f);
            bo.b((View)this.q, 0.0f);
            if (this.C && this.t != null) {
                bo.b(this.t, 0.0f);
            }
            this.f.b(null);
        }
        if (this.p == null) return;
        bo.s((View)this.p);
    }

    void i() {
        if (this.c == null) return;
        this.c.a(this.b);
        this.b = null;
        this.c = null;
    }

    public void i(boolean bl2) {
        if (this.H != null) {
            this.H.b();
        }
        if (this.B == 0 && k && (this.I || bl2)) {
            bo.c((View)this.q, 1.0f);
            this.q.setTransitioning(true);
            android.support.v7.view.l l2 = new android.support.v7.view.l();
            float f2 = - this.q.getHeight();
            if (bl2) {
                int[] arrn = new int[]{0, 0};
                this.q.getLocationInWindow(arrn);
                f2 -= (float)arrn[1];
            }
            dc dc2 = bo.q((View)this.q).c(f2);
            dc2.a(this.g);
            l2.a(dc2);
            if (this.C && this.t != null) {
                l2.a(bo.q(this.t).c(f2));
            }
            l2.a(i);
            l2.a(250);
            l2.a(this.e);
            this.H = l2;
            l2.a();
            return;
        }
        this.e.b(null);
    }

    public int j() {
        return this.r.p();
    }

    public void j(boolean bl2) {
        dc dc2;
        dc dc3;
        if (bl2) {
            this.p();
        } else {
            this.q();
        }
        if (bl2) {
            dc3 = this.r.a(4, 100);
            dc2 = this.s.a(0, 200);
        } else {
            dc2 = this.r.a(0, 200);
            dc3 = this.s.a(8, 100);
        }
        android.support.v7.view.l l2 = new android.support.v7.view.l();
        l2.a(dc3, dc2);
        l2.a();
    }

    public int k() {
        return this.q.getHeight();
    }

    @Override
    public void l() {
        if (!this.E) return;
        this.E = false;
        this.l(true);
    }

    @Override
    public void m() {
        if (this.E) return;
        this.E = true;
        this.l(true);
    }

    @Override
    public void n() {
        if (this.H == null) return;
        this.H.b();
        this.H = null;
    }

    @Override
    public void o() {
    }
}

