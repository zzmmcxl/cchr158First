/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.b.b;
import android.support.v7.b.f;
import android.support.v7.b.g;
import android.support.v7.b.l;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.y;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ar;
import android.support.v7.widget.cf;
import android.support.v7.widget.fn;
import android.support.v7.widget.gk;
import android.support.v7.widget.gp;
import android.support.v7.widget.gt;
import android.support.v7.widget.gu;
import android.support.v7.widget.k;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

public class gs
implements cf {
    private Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    private CharSequence i;
    private CharSequence j;
    private CharSequence k;
    private Window.Callback l;
    private boolean m;
    private k n;
    private int o = 0;
    private final ar p;
    private int q = 0;
    private Drawable r;

    public gs(Toolbar toolbar, boolean bl2) {
        this(toolbar, bl2, android.support.v7.b.j.abc_action_bar_up_description, f.abc_ic_ab_back_material);
    }

    public gs(Toolbar toolbar, boolean bl2, int n2, int n3) {
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        boolean bl3 = this.i != null;
        this.h = bl3;
        this.g = toolbar.getNavigationIcon();
        if (bl2) {
            CharSequence charSequence;
            Drawable drawable;
            int n4;
            int n5;
            int n6;
            Drawable drawable2;
            int n7;
            gk gk2 = gk.a(toolbar.getContext(), null, l.ActionBar, b.actionBarStyle, 0);
            CharSequence charSequence2 = gk2.c(l.ActionBar_title);
            if (!TextUtils.isEmpty((CharSequence)charSequence2)) {
                this.b(charSequence2);
            }
            if (!TextUtils.isEmpty((CharSequence)(charSequence = gk2.c(l.ActionBar_subtitle)))) {
                this.c(charSequence);
            }
            if ((drawable2 = gk2.a(l.ActionBar_logo)) != null) {
                this.c(drawable2);
            }
            Drawable drawable3 = gk2.a(l.ActionBar_icon);
            if (this.g == null && drawable3 != null) {
                this.a(drawable3);
            }
            if ((drawable = gk2.a(l.ActionBar_homeAsUpIndicator)) != null) {
                this.d(drawable);
            }
            this.c(gk2.a(l.ActionBar_displayOptions, 0));
            int n8 = gk2.g(l.ActionBar_customNavigationLayout, 0);
            if (n8 != 0) {
                this.a(LayoutInflater.from((Context)this.a.getContext()).inflate(n8, (ViewGroup)this.a, false));
                this.c(16 | this.b);
            }
            if ((n4 = gk2.f(l.ActionBar_height, 0)) > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = n4;
                this.a.setLayoutParams(layoutParams);
            }
            int n9 = gk2.d(l.ActionBar_contentInsetStart, -1);
            int n10 = gk2.d(l.ActionBar_contentInsetEnd, -1);
            if (n9 >= 0 || n10 >= 0) {
                this.a.a(Math.max(n9, 0), Math.max(n10, 0));
            }
            if ((n7 = gk2.g(l.ActionBar_titleTextStyle, 0)) != 0) {
                this.a.a(this.a.getContext(), n7);
            }
            if ((n5 = gk2.g(l.ActionBar_subtitleTextStyle, 0)) != 0) {
                this.a.b(this.a.getContext(), n5);
            }
            if ((n6 = gk2.g(l.ActionBar_popupTheme, 0)) != 0) {
                this.a.setPopupTheme(n6);
            }
            gk2.a();
        } else {
            this.b = this.s();
        }
        this.p = ar.a();
        this.d(n2);
        this.k = this.a.getNavigationContentDescription();
        this.b(this.p.a(this.b(), n3));
        this.a.setNavigationOnClickListener(new gt(this));
    }

    static /* synthetic */ Toolbar a(gs gs2) {
        return gs2.a;
    }

    static /* synthetic */ CharSequence b(gs gs2) {
        return gs2.i;
    }

    static /* synthetic */ Window.Callback c(gs gs2) {
        return gs2.l;
    }

    static /* synthetic */ boolean d(gs gs2) {
        return gs2.m;
    }

    private void e(CharSequence charSequence) {
        this.i = charSequence;
        if ((8 & this.b) == 0) return;
        this.a.setTitle(charSequence);
    }

    private int s() {
        int n2 = 11;
        if (this.a.getNavigationIcon() == null) return n2;
        return 15;
    }

    private void t() {
        int n2 = 2 & this.b;
        Drawable drawable = null;
        if (n2 != 0) {
            drawable = (1 & this.b) != 0 ? (this.f != null ? this.f : this.e) : this.e;
        }
        this.a.setLogo(drawable);
    }

    private void u() {
        if ((4 & this.b) == 0) return;
        if (TextUtils.isEmpty((CharSequence)this.k)) {
            this.a.setNavigationContentDescription(this.q);
            return;
        }
        this.a.setNavigationContentDescription(this.k);
    }

    private void v() {
        if ((4 & this.b) == 0) return;
        Toolbar toolbar = this.a;
        Drawable drawable = this.g != null ? this.g : this.r;
        toolbar.setNavigationIcon(drawable);
    }

    @Override
    public dc a(int n2, long l2) {
        float f2;
        dc dc2 = bo.q((View)this.a);
        if (n2 == 0) {
            f2 = 1.0f;
            return dc2.a(f2).a(l2).a(new gu(this, n2));
        }
        f2 = 0.0f;
        return dc2.a(f2).a(l2).a(new gu(this, n2));
    }

    @Override
    public ViewGroup a() {
        return this.a;
    }

    @Override
    public void a(int n2) {
        Drawable drawable = n2 != 0 ? this.p.a(this.b(), n2) : null;
        this.a(drawable);
    }

    @Override
    public void a(Drawable drawable) {
        this.e = drawable;
        this.t();
    }

    @Override
    public void a(y y2, j j2) {
        this.a.a(y2, j2);
    }

    @Override
    public void a(fn fn2) {
        if (this.c != null && this.c.getParent() == this.a) {
            this.a.removeView(this.c);
        }
        this.c = fn2;
        if (fn2 == null) return;
        if (this.o != 2) return;
        this.a.addView(this.c, 0);
        gp gp2 = (gp)this.c.getLayoutParams();
        gp2.width = -2;
        gp2.height = -2;
        gp2.a = 8388691;
        fn2.setAllowCollapse(true);
    }

    @Override
    public void a(Menu menu, y y2) {
        if (this.n == null) {
            this.n = new k(this.a.getContext());
            this.n.a(g.action_menu_presenter);
        }
        this.n.a(y2);
        this.a.a((i)menu, this.n);
    }

    public void a(View view) {
        if (this.d != null && (16 & this.b) != 0) {
            this.a.removeView(this.d);
        }
        this.d = view;
        if (view == null) return;
        if ((16 & this.b) == 0) return;
        this.a.addView(this.d);
    }

    @Override
    public void a(Window.Callback callback) {
        this.l = callback;
    }

    @Override
    public void a(CharSequence charSequence) {
        if (this.h) return;
        this.e(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        this.a.setCollapsible(bl2);
    }

    @Override
    public Context b() {
        return this.a.getContext();
    }

    @Override
    public void b(int n2) {
        Drawable drawable = n2 != 0 ? this.p.a(this.b(), n2) : null;
        this.c(drawable);
    }

    public void b(Drawable drawable) {
        if (this.r == drawable) return;
        this.r = drawable;
        this.v();
    }

    public void b(CharSequence charSequence) {
        this.h = true;
        this.e(charSequence);
    }

    @Override
    public void b(boolean bl2) {
    }

    @Override
    public void c(int n2) {
        int n3 = n2 ^ this.b;
        this.b = n2;
        if (n3 == 0) return;
        if ((n3 & 4) != 0) {
            if ((n2 & 4) != 0) {
                this.v();
                this.u();
            } else {
                this.a.setNavigationIcon(null);
            }
        }
        if ((n3 & 3) != 0) {
            this.t();
        }
        if ((n3 & 8) != 0) {
            if ((n2 & 8) != 0) {
                this.a.setTitle(this.i);
                this.a.setSubtitle(this.j);
            } else {
                this.a.setTitle(null);
                this.a.setSubtitle(null);
            }
        }
        if ((n3 & 16) == 0) return;
        if (this.d == null) return;
        if ((n2 & 16) != 0) {
            this.a.addView(this.d);
            return;
        }
        this.a.removeView(this.d);
    }

    public void c(Drawable drawable) {
        this.f = drawable;
        this.t();
    }

    public void c(CharSequence charSequence) {
        this.j = charSequence;
        if ((8 & this.b) == 0) return;
        this.a.setSubtitle(charSequence);
    }

    @Override
    public boolean c() {
        return this.a.g();
    }

    @Override
    public void d() {
        this.a.h();
    }

    public void d(int n2) {
        if (n2 == this.q) {
            return;
        }
        this.q = n2;
        if (!TextUtils.isEmpty((CharSequence)this.a.getNavigationContentDescription())) return;
        this.e(this.q);
    }

    public void d(Drawable drawable) {
        this.g = drawable;
        this.v();
    }

    public void d(CharSequence charSequence) {
        this.k = charSequence;
        this.u();
    }

    @Override
    public CharSequence e() {
        return this.a.getTitle();
    }

    public void e(int n2) {
        String string = n2 == 0 ? null : this.b().getString(n2);
        this.d(string);
    }

    @Override
    public void f() {
        Log.i((String)"ToolbarWidgetWrapper", (String)"Progress display unsupported");
    }

    @Override
    public void g() {
        Log.i((String)"ToolbarWidgetWrapper", (String)"Progress display unsupported");
    }

    @Override
    public boolean h() {
        return this.a.a();
    }

    @Override
    public boolean i() {
        return this.a.b();
    }

    @Override
    public boolean j() {
        return this.a.c();
    }

    @Override
    public boolean k() {
        return this.a.d();
    }

    @Override
    public boolean l() {
        return this.a.e();
    }

    @Override
    public void m() {
        this.m = true;
    }

    @Override
    public void n() {
        this.a.f();
    }

    @Override
    public int o() {
        return this.b;
    }

    @Override
    public int p() {
        return this.o;
    }

    @Override
    public int q() {
        return this.a.getVisibility();
    }

    @Override
    public Menu r() {
        return this.a.getMenu();
    }
}

