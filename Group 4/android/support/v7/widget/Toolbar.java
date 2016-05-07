/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.h.ag;
import android.support.v4.h.al;
import android.support.v4.h.at;
import android.support.v4.h.bo;
import android.support.v4.h.q;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.support.v7.view.i;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar$SavedState;
import android.support.v7.widget.ar;
import android.support.v7.widget.cf;
import android.support.v7.widget.fl;
import android.support.v7.widget.gk;
import android.support.v7.widget.gl;
import android.support.v7.widget.gm;
import android.support.v7.widget.gn;
import android.support.v7.widget.go;
import android.support.v7.widget.gp;
import android.support.v7.widget.gq;
import android.support.v7.widget.gs;
import android.support.v7.widget.gz;
import android.support.v7.widget.k;
import android.support.v7.widget.y;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
extends ViewGroup {
    private boolean A;
    private final ArrayList B = new ArrayList();
    private final ArrayList C = new ArrayList();
    private final int[] D = new int[2];
    private gq E;
    private final y F;
    private gs G;
    private k H;
    private go I;
    private android.support.v7.view.menu.y J;
    private j K;
    private boolean L;
    private final Runnable M;
    private final ar N;
    View a;
    private ActionMenuView b;
    private TextView c;
    private TextView d;
    private ImageButton e;
    private ImageView f;
    private Drawable g;
    private CharSequence h;
    private ImageButton i;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final fl t = new fl();
    private int u = 8388627;
    private CharSequence v;
    private CharSequence w;
    private int x;
    private int y;
    private boolean z;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int n2) {
        int n3;
        Drawable drawable;
        CharSequence charSequence;
        int n4;
        CharSequence charSequence2;
        int n5;
        CharSequence charSequence3;
        int n6;
        super(context, attributeSet, n2);
        this.F = new gl(this);
        this.M = new gm(this);
        gk gk2 = gk.a(this.getContext(), attributeSet, l.Toolbar, n2, 0);
        this.l = gk2.g(l.Toolbar_titleTextAppearance, 0);
        this.m = gk2.g(l.Toolbar_subtitleTextAppearance, 0);
        this.u = gk2.c(l.Toolbar_android_gravity, this.u);
        this.n = 48;
        this.s = n5 = gk2.d(l.Toolbar_titleMargins, 0);
        this.r = n5;
        this.q = n5;
        this.p = n5;
        int n7 = gk2.d(l.Toolbar_titleMarginStart, -1);
        if (n7 >= 0) {
            this.p = n7;
        }
        if ((n6 = gk2.d(l.Toolbar_titleMarginEnd, -1)) >= 0) {
            this.q = n6;
        }
        if ((n4 = gk2.d(l.Toolbar_titleMarginTop, -1)) >= 0) {
            this.r = n4;
        }
        if ((n3 = gk2.d(l.Toolbar_titleMarginBottom, -1)) >= 0) {
            this.s = n3;
        }
        this.o = gk2.e(l.Toolbar_maxButtonHeight, -1);
        int n8 = gk2.d(l.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int n9 = gk2.d(l.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int n10 = gk2.e(l.Toolbar_contentInsetLeft, 0);
        int n11 = gk2.e(l.Toolbar_contentInsetRight, 0);
        this.t.b(n10, n11);
        if (n8 != Integer.MIN_VALUE || n9 != Integer.MIN_VALUE) {
            this.t.a(n8, n9);
        }
        this.g = gk2.a(l.Toolbar_collapseIcon);
        this.h = gk2.c(l.Toolbar_collapseContentDescription);
        CharSequence charSequence4 = gk2.c(l.Toolbar_title);
        if (!TextUtils.isEmpty((CharSequence)charSequence4)) {
            this.setTitle(charSequence4);
        }
        if (!TextUtils.isEmpty((CharSequence)(charSequence2 = gk2.c(l.Toolbar_subtitle)))) {
            this.setSubtitle(charSequence2);
        }
        this.j = this.getContext();
        this.setPopupTheme(gk2.g(l.Toolbar_popupTheme, 0));
        Drawable drawable2 = gk2.a(l.Toolbar_navigationIcon);
        if (drawable2 != null) {
            this.setNavigationIcon(drawable2);
        }
        if (!TextUtils.isEmpty((CharSequence)(charSequence = gk2.c(l.Toolbar_navigationContentDescription)))) {
            this.setNavigationContentDescription(charSequence);
        }
        if ((drawable = gk2.a(l.Toolbar_logo)) != null) {
            this.setLogo(drawable);
        }
        if (!TextUtils.isEmpty((CharSequence)(charSequence3 = gk2.c(l.Toolbar_logoDescription)))) {
            this.setLogoDescription(charSequence3);
        }
        if (gk2.f(l.Toolbar_titleTextColor)) {
            this.setTitleTextColor(gk2.b(l.Toolbar_titleTextColor, -1));
        }
        if (gk2.f(l.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(gk2.b(l.Toolbar_subtitleTextColor, -1));
        }
        gk2.a();
        this.N = ar.a();
    }

    private int a(int n2) {
        int n3 = n2 & 112;
        switch (n3) {
            default: {
                n3 = 112 & this.u;
            }
            case 16: 
            case 48: 
            case 80: 
        }
        return n3;
    }

    private int a(View view, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        gp gp2 = (gp)view.getLayoutParams();
        int n8 = view.getMeasuredHeight();
        int n9 = n2 > 0 ? (n8 - n2) / 2 : 0;
        switch (this.a(gp2.a)) {
            default: {
                n5 = this.getPaddingTop();
                n6 = this.getPaddingBottom();
                n7 = this.getHeight();
                n3 = (n7 - n5 - n6 - n8) / 2;
                if (n3 >= gp2.topMargin) break;
                n4 = gp2.topMargin;
                return n4 + n5;
            }
            case 48: {
                return this.getPaddingTop() - n9;
            }
            case 80: {
                return this.getHeight() - this.getPaddingBottom() - n8 - gp2.bottomMargin - n9;
            }
        }
        int n10 = n7 - n6 - n8 - n3 - n5;
        if (n10 < gp2.bottomMargin) {
            n4 = Math.max(0, n3 - (gp2.bottomMargin - n10));
            return n4 + n5;
        }
        n4 = n3;
        return n4 + n5;
    }

    private int a(View view, int n2, int n3, int n4, int n5, int[] arrn) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n6 = marginLayoutParams.leftMargin - arrn[0];
        int n7 = marginLayoutParams.rightMargin - arrn[1];
        int n8 = Math.max(0, n6) + Math.max(0, n7);
        arrn[0] = Math.max(0, - n6);
        arrn[1] = Math.max(0, - n7);
        view.measure(Toolbar.getChildMeasureSpec((int)n2, (int)(n3 + (n8 + (this.getPaddingLeft() + this.getPaddingRight()))), (int)marginLayoutParams.width), Toolbar.getChildMeasureSpec((int)n4, (int)(n5 + (this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)), (int)marginLayoutParams.height));
        return n8 + view.getMeasuredWidth();
    }

    private int a(View view, int n2, int[] arrn, int n3) {
        gp gp2 = (gp)view.getLayoutParams();
        int n4 = gp2.leftMargin - arrn[0];
        int n5 = n2 + Math.max(0, n4);
        arrn[0] = Math.max(0, - n4);
        int n6 = this.a(view, n3);
        int n7 = view.getMeasuredWidth();
        view.layout(n5, n6, n5 + n7, n6 + view.getMeasuredHeight());
        return n5 + (n7 + gp2.rightMargin);
    }

    private int a(List list, int[] arrn) {
        int n2 = arrn[0];
        int n3 = arrn[1];
        int n4 = list.size();
        int n5 = 0;
        int n6 = 0;
        int n7 = n3;
        int n8 = n2;
        while (n5 < n4) {
            View view = (View)list.get(n5);
            gp gp2 = (gp)view.getLayoutParams();
            int n9 = gp2.leftMargin - n8;
            int n10 = gp2.rightMargin - n7;
            int n11 = Math.max(0, n9);
            int n12 = Math.max(0, n10);
            n8 = Math.max(0, - n9);
            n7 = Math.max(0, - n10);
            int n13 = n6 + (n12 + (n11 + view.getMeasuredWidth()));
            ++n5;
            n6 = n13;
        }
        return n6;
    }

    static /* synthetic */ gq a(Toolbar toolbar) {
        return toolbar.E;
    }

    private void a(View view, int n2, int n3, int n4, int n5, int n6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n7 = Toolbar.getChildMeasureSpec((int)n2, (int)(n3 + (this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)), (int)marginLayoutParams.width);
        int n8 = Toolbar.getChildMeasureSpec((int)n4, (int)(n5 + (this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)), (int)marginLayoutParams.height);
        int n9 = View.MeasureSpec.getMode((int)n8);
        if (n9 != 1073741824 && n6 >= 0) {
            if (n9 != 0) {
                n6 = Math.min(View.MeasureSpec.getSize((int)n8), n6);
            }
            n8 = View.MeasureSpec.makeMeasureSpec((int)n6, (int)1073741824);
        }
        view.measure(n7, n8);
    }

    private void a(View view, boolean bl2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        gp gp2 = layoutParams == null ? this.i() : (!this.checkLayoutParams(layoutParams) ? this.a(layoutParams) : (gp)layoutParams);
        gp2.b = 1;
        if (bl2 && this.a != null) {
            view.setLayoutParams((ViewGroup.LayoutParams)gp2);
            this.C.add(view);
            return;
        }
        this.addView(view, (ViewGroup.LayoutParams)gp2);
    }

    private void a(List list, int n2) {
        int n3 = 1;
        if (bo.h((View)this) != n3) {
            n3 = 0;
        }
        int n4 = this.getChildCount();
        int n5 = q.a(n2, bo.h((View)this));
        list.clear();
        int n6 = 0;
        if (n3 != 0) {
            int n7 = n4 - 1;
            while (n7 >= 0) {
                View view = this.getChildAt(n7);
                gp gp2 = (gp)view.getLayoutParams();
                if (gp2.b == 0 && this.a(view) && this.b(gp2.a) == n5) {
                    list.add(view);
                }
                --n7;
            }
            return;
        }
        while (n6 < n4) {
            View view = this.getChildAt(n6);
            gp gp3 = (gp)view.getLayoutParams();
            if (gp3.b == 0 && this.a(view) && this.b(gp3.a) == n5) {
                list.add(view);
            }
            ++n6;
        }
    }

    private boolean a(View view) {
        if (view == null) return false;
        if (view.getParent() != this) return false;
        if (view.getVisibility() == 8) return false;
        return true;
    }

    private int b(int n2) {
        int n3 = bo.h((View)this);
        int n4 = 7 & q.a(n2, n3);
        switch (n4) {
            default: {
                if (n3 != 1) return 3;
                n4 = 5;
            }
            case 1: 
            case 3: 
            case 5: 
        }
        return n4;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return ag.a(marginLayoutParams) + ag.b(marginLayoutParams);
    }

    private int b(View view, int n2, int[] arrn, int n3) {
        gp gp2 = (gp)view.getLayoutParams();
        int n4 = gp2.rightMargin - arrn[1];
        int n5 = n2 - Math.max(0, n4);
        arrn[1] = Math.max(0, - n4);
        int n6 = this.a(view, n3);
        int n7 = view.getMeasuredWidth();
        view.layout(n5 - n7, n6, n5, n6 + view.getMeasuredHeight());
        return n5 - (n7 + gp2.leftMargin);
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        toolbar.p();
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static /* synthetic */ ImageButton c(Toolbar toolbar) {
        return toolbar.i;
    }

    static /* synthetic */ int d(Toolbar toolbar) {
        return toolbar.n;
    }

    private boolean d(View view) {
        if (view.getParent() == this) return true;
        if (!this.C.contains((Object)view)) return false;
        return true;
    }

    private MenuInflater getMenuInflater() {
        return new i(this.getContext());
    }

    private void l() {
        if (this.f != null) return;
        this.f = new ImageView(this.getContext());
    }

    private void m() {
        this.n();
        if (this.b.d() != null) return;
        android.support.v7.view.menu.i i2 = (android.support.v7.view.menu.i)this.b.getMenu();
        if (this.I == null) {
            this.I = new go(this, null);
        }
        this.b.setExpandedActionViewsExclusive(true);
        i2.a(this.I, this.j);
    }

    private void n() {
        if (this.b != null) return;
        this.b = new ActionMenuView(this.getContext());
        this.b.setPopupTheme(this.k);
        this.b.setOnMenuItemClickListener(this.F);
        this.b.a(this.J, this.K);
        gp gp2 = this.i();
        gp2.a = 8388613 | 112 & this.n;
        this.b.setLayoutParams((ViewGroup.LayoutParams)gp2);
        this.a((View)this.b, false);
    }

    private void o() {
        if (this.e != null) return;
        this.e = new ImageButton(this.getContext(), null, b.toolbarNavigationButtonStyle);
        gp gp2 = this.i();
        gp2.a = 8388611 | 112 & this.n;
        this.e.setLayoutParams((ViewGroup.LayoutParams)gp2);
    }

    private void p() {
        if (this.i != null) return;
        this.i = new ImageButton(this.getContext(), null, b.toolbarNavigationButtonStyle);
        this.i.setImageDrawable(this.g);
        this.i.setContentDescription(this.h);
        gp gp2 = this.i();
        gp2.a = 8388611 | 112 & this.n;
        gp2.b = 2;
        this.i.setLayoutParams((ViewGroup.LayoutParams)gp2);
        this.i.setOnClickListener((View.OnClickListener)new gn(this));
    }

    private void q() {
        this.removeCallbacks(this.M);
        this.post(this.M);
    }

    private boolean r() {
        if (!this.L) {
            return false;
        }
        int n2 = this.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view = this.getChildAt(n3);
            if (this.a(view) && view.getMeasuredWidth() > 0) {
                if (view.getMeasuredHeight() > 0) return false;
            }
            ++n3;
        }
        return true;
    }

    public gp a(AttributeSet attributeSet) {
        return new gp(this.getContext(), attributeSet);
    }

    protected gp a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof gp) {
            return new gp((gp)layoutParams);
        }
        if (layoutParams instanceof android.support.v7.a.b) {
            return new gp((android.support.v7.a.b)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new gp(layoutParams);
        return new gp((ViewGroup.MarginLayoutParams)layoutParams);
    }

    public void a(int n2, int n3) {
        this.t.a(n2, n3);
    }

    public void a(Context context, int n2) {
        this.l = n2;
        if (this.c == null) return;
        this.c.setTextAppearance(context, n2);
    }

    public void a(android.support.v7.view.menu.i i2, k k2) {
        if (i2 == null && this.b == null) {
            return;
        }
        this.n();
        android.support.v7.view.menu.i i3 = this.b.d();
        if (i3 == i2) return;
        if (i3 != null) {
            i3.b(this.H);
            i3.b(this.I);
        }
        if (this.I == null) {
            this.I = new go(this, null);
        }
        k2.d(true);
        if (i2 != null) {
            i2.a(k2, this.j);
            i2.a(this.I, this.j);
        } else {
            k2.a(this.j, null);
            this.I.a(this.j, null);
            k2.b(true);
            this.I.b(true);
        }
        this.b.setPopupTheme(this.k);
        this.b.setPresenter(k2);
        this.H = k2;
    }

    public void a(android.support.v7.view.menu.y y2, j j2) {
        this.J = y2;
        this.K = j2;
        if (this.b == null) return;
        this.b.a(y2, j2);
    }

    public boolean a() {
        if (this.getVisibility() != 0) return false;
        if (this.b == null) return false;
        if (!this.b.a()) return false;
        return true;
    }

    public void b(Context context, int n2) {
        this.m = n2;
        if (this.d == null) return;
        this.d.setTextAppearance(context, n2);
    }

    public boolean b() {
        if (this.b == null) return false;
        if (!this.b.g()) return false;
        return true;
    }

    public boolean c() {
        if (this.b == null) return false;
        if (!this.b.h()) return false;
        return true;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!super.checkLayoutParams(layoutParams)) return false;
        if (!(layoutParams instanceof gp)) return false;
        return true;
    }

    public boolean d() {
        if (this.b == null) return false;
        if (!this.b.e()) return false;
        return true;
    }

    public boolean e() {
        if (this.b == null) return false;
        if (!this.b.f()) return false;
        return true;
    }

    public void f() {
        if (this.b == null) return;
        this.b.i();
    }

    public boolean g() {
        if (this.I == null) return false;
        if (this.I.b == null) return false;
        return true;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.i();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.t.d();
    }

    public int getContentInsetLeft() {
        return this.t.a();
    }

    public int getContentInsetRight() {
        return this.t.b();
    }

    public int getContentInsetStart() {
        return this.t.c();
    }

    public Drawable getLogo() {
        if (this.f == null) return null;
        return this.f.getDrawable();
    }

    public CharSequence getLogoDescription() {
        if (this.f == null) return null;
        return this.f.getContentDescription();
    }

    public Menu getMenu() {
        this.m();
        return this.b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.e == null) return null;
        return this.e.getContentDescription();
    }

    public Drawable getNavigationIcon() {
        if (this.e == null) return null;
        return this.e.getDrawable();
    }

    public Drawable getOverflowIcon() {
        this.m();
        return this.b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.w;
    }

    public CharSequence getTitle() {
        return this.v;
    }

    public cf getWrapper() {
        if (this.G != null) return this.G;
        this.G = new gs(this, true);
        return this.G;
    }

    public void h() {
        if (this.I == null) {
            return;
        }
        m m2 = this.I.b;
        if (m2 == null) return;
        m2.collapseActionView();
    }

    protected gp i() {
        return new gp(-2, -2);
    }

    void j() {
        int n2 = -1 + this.getChildCount();
        while (n2 >= 0) {
            View view = this.getChildAt(n2);
            if (((gp)view.getLayoutParams()).b != 2 && view != this.b) {
                this.removeViewAt(n2);
                this.C.add(view);
            }
            --n2;
        }
    }

    void k() {
        int n2 = -1 + this.C.size();
        do {
            if (n2 < 0) {
                this.C.clear();
                return;
            }
            this.addView((View)this.C.get(n2));
            --n2;
        } while (true);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.M);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n2 = at.a(motionEvent);
        if (n2 == 9) {
            this.A = false;
        }
        if (!this.A) {
            boolean bl2 = super.onHoverEvent(motionEvent);
            if (n2 == 9 && !bl2) {
                this.A = true;
            }
        }
        if (n2 != 10) {
            if (n2 != 3) return true;
        }
        this.A = false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected void onLayout(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var6_6 = bo.h((View)this) == 1;
        var7_7 = this.getWidth();
        var8_8 = this.getHeight();
        var9_9 = this.getPaddingLeft();
        var10_10 = this.getPaddingRight();
        var11_11 = this.getPaddingTop();
        var12_12 = this.getPaddingBottom();
        var13_13 = var7_7 - var10_10;
        var14_14 = this.D;
        var14_14[1] = 0;
        var14_14[0] = 0;
        var15_15 = bo.p((View)this);
        if (this.a((View)this.e)) {
            if (var6_6) {
                var13_13 = this.b((View)this.e, var13_13, var14_14, var15_15);
                var16_16 = var9_9;
            } else {
                var16_16 = this.a((View)this.e, var9_9, var14_14, var15_15);
            }
        } else {
            var16_16 = var9_9;
        }
        if (this.a((View)this.i)) {
            if (var6_6) {
                var13_13 = this.b((View)this.i, var13_13, var14_14, var15_15);
            } else {
                var16_16 = this.a((View)this.i, var16_16, var14_14, var15_15);
            }
        }
        if (this.a((View)this.b)) {
            if (var6_6) {
                var16_16 = this.a((View)this.b, var16_16, var14_14, var15_15);
            } else {
                var13_13 = this.b((View)this.b, var13_13, var14_14, var15_15);
            }
        }
        var14_14[0] = Math.max(0, this.getContentInsetLeft() - var16_16);
        var14_14[1] = Math.max(0, this.getContentInsetRight() - (var7_7 - var10_10 - var13_13));
        var17_17 = Math.max(var16_16, this.getContentInsetLeft());
        var18_18 = Math.min(var13_13, var7_7 - var10_10 - this.getContentInsetRight());
        if (this.a(this.a)) {
            if (var6_6) {
                var18_18 = this.b(this.a, var18_18, var14_14, var15_15);
            } else {
                var17_17 = this.a(this.a, var17_17, var14_14, var15_15);
            }
        }
        if (this.a((View)this.f)) {
            if (var6_6) {
                var19_19 = this.b((View)this.f, var18_18, var14_14, var15_15);
                var20_20 = var17_17;
            } else {
                var79_21 = this.a((View)this.f, var17_17, var14_14, var15_15);
                var19_19 = var18_18;
                var20_20 = var79_21;
            }
        } else {
            var19_19 = var18_18;
            var20_20 = var17_17;
        }
        var21_22 = this.a((View)this.c);
        var22_23 = this.a((View)this.d);
        var23_24 = 0;
        if (var21_22) {
            var78_25 = (gp)this.c.getLayoutParams();
            var23_24 = 0 + (var78_25.topMargin + this.c.getMeasuredHeight() + var78_25.bottomMargin);
        }
        if (var22_23) {
            var77_26 = (gp)this.d.getLayoutParams();
            var24_27 = var23_24 + (var77_26.topMargin + this.d.getMeasuredHeight() + var77_26.bottomMargin);
        } else {
            var24_27 = var23_24;
        }
        if (!var21_22 && !var22_23) ** GOTO lbl137
        var25_28 = var21_22 != false ? this.c : this.d;
        var26_29 = var22_23 != false ? this.d : this.c;
        var27_30 = (gp)var25_28.getLayoutParams();
        var28_31 = (gp)var26_29.getLayoutParams();
        var29_32 = var21_22 != false && this.c.getMeasuredWidth() > 0 || var22_23 != false && this.d.getMeasuredWidth() > 0;
        switch (112 & this.u) {
            default: {
                var74_33 = (var8_8 - var11_11 - var12_12 - var24_27) / 2;
                var76_34 = var74_33 < var27_30.topMargin + this.r ? var27_30.topMargin + this.r : ((var75_35 = var8_8 - var12_12 - var24_27 - var74_33 - var11_11) < var27_30.bottomMargin + this.s ? Math.max(0, var74_33 - (var28_31.bottomMargin + this.s - var75_35)) : var74_33);
            }
            case 48: {
                var30_36 = this.getPaddingTop() + var27_30.topMargin + this.r;
                ** GOTO lbl79
            }
            case 80: 
        }
        var30_36 = var8_8 - var12_12 - var28_31.bottomMargin - this.s - var24_27;
        ** GOTO lbl79
        var30_36 = var11_11 + var76_34;
lbl79: // 3 sources:
        if (!var6_6) ** GOTO lbl93
        var58_37 = var29_32 != false ? this.p : 0;
        var59_38 = var58_37 - var14_14[1];
        var60_39 = var19_19 - Math.max(0, var59_38);
        var14_14[1] = Math.max(0, - var59_38);
        if (!var21_22) ** GOTO lbl123
        var70_40 = (gp)this.c.getLayoutParams();
        var71_41 = var60_39 - this.c.getMeasuredWidth();
        var72_42 = var30_36 + this.c.getMeasuredHeight();
        this.c.layout(var71_41, var30_36, var60_39, var72_42);
        var73_43 = var71_41 - this.q;
        var30_36 = var72_42 + var70_40.bottomMargin;
        var61_44 = var73_43;
        ** GOTO lbl124
lbl93: // 1 sources:
        var31_52 = var29_32 != false ? this.p : 0;
        var32_53 = var31_52 - var14_14[0];
        var20_20 += Math.max(0, var32_53);
        var14_14[0] = Math.max(0, - var32_53);
        if (var21_22) {
            var53_62 = (gp)this.c.getLayoutParams();
            var54_63 = var20_20 + this.c.getMeasuredWidth();
            var55_64 = var30_36 + this.c.getMeasuredHeight();
            this.c.layout(var20_20, var30_36, var54_63, var55_64);
            var56_65 = var54_63 + this.q;
            var57_66 = var55_64 + var53_62.bottomMargin;
            var33_54 = var56_65;
            var34_55 = var57_66;
        } else {
            var33_54 = var20_20;
            var34_55 = var30_36;
        }
        if (var22_23) {
            var47_57 = (gp)this.d.getLayoutParams();
            var48_58 = var34_55 + var47_57.topMargin;
            var49_59 = var20_20 + this.d.getMeasuredWidth();
            var50_60 = var48_58 + this.d.getMeasuredHeight();
            this.d.layout(var20_20, var48_58, var49_59, var50_60);
            var51_61 = var49_59 + this.q;
            var50_60 + var47_57.bottomMargin;
            var35_56 = var51_61;
        } else {
            var35_56 = var20_20;
        }
        if (var29_32) {
            var20_20 = Math.max(var33_54, var35_56);
        }
        ** GOTO lbl137
lbl123: // 1 sources:
        var61_44 = var60_39;
lbl124: // 2 sources:
        if (var22_23) {
            var64_45 = (gp)this.d.getLayoutParams();
            var65_46 = var30_36 + var64_45.topMargin;
            var66_47 = var60_39 - this.d.getMeasuredWidth();
            var67_48 = var65_46 + this.d.getMeasuredHeight();
            this.d.layout(var66_47, var65_46, var60_39, var67_48);
            var68_49 = var60_39 - this.q;
            var67_48 + var64_45.bottomMargin;
            var62_50 = var68_49;
        } else {
            var62_50 = var60_39;
        }
        var63_51 = var29_32 != false ? Math.min(var61_44, var62_50) : var60_39;
        var19_19 = var63_51;
lbl137: // 3 sources:
        this.a((List)this.B, 3);
        var36_67 = this.B.size();
        var38_69 = var20_20;
        for (var37_68 = 0; var37_68 < var36_67; ++var37_68) {
            var38_69 = this.a((View)this.B.get(var37_68), var38_69, var14_14, var15_15);
        }
        this.a((List)this.B, 5);
        var39_70 = this.B.size();
        for (var40_71 = 0; var40_71 < var39_70; ++var40_71) {
            var19_19 = this.b((View)this.B.get(var40_71), var19_19, var14_14, var15_15);
        }
        this.a((List)this.B, 1);
        var41_72 = this.a((List)this.B, var14_14);
        var42_73 = var9_9 + (var7_7 - var9_9 - var10_10) / 2 - var41_72 / 2;
        var43_74 = var41_72 + var42_73;
        if (var42_73 < var38_69) {
            var42_73 = var38_69;
        } else if (var43_74 > var19_19) {
            var42_73 -= var43_74 - var19_19;
        }
        var44_75 = this.B.size();
        var45_76 = 0;
        var46_77 = var42_73;
        do {
            if (var45_76 >= var44_75) {
                this.B.clear();
                return;
            }
            var46_77 = this.a((View)this.B.get(var45_76), var46_77, var14_14, var15_15);
            ++var45_76;
        } while (true);
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        int[] arrn = this.D;
        if (gz.a((View)this)) {
            n5 = 0;
            n4 = 1;
        } else {
            n5 = 1;
            n4 = 0;
        }
        boolean bl2 = this.a((View)this.e);
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        if (bl2) {
            this.a((View)this.e, n2, 0, n3, 0, this.o);
            n6 = this.e.getMeasuredWidth() + this.b((View)this.e);
            int n9 = Math.max(0, this.e.getMeasuredHeight() + this.c((View)this.e));
            n7 = gz.a(0, bo.j((View)this.e));
            n8 = n9;
        }
        if (this.a((View)this.i)) {
            this.a((View)this.i, n2, 0, n3, 0, this.o);
            n6 = this.i.getMeasuredWidth() + this.b((View)this.i);
            n8 = Math.max(n8, this.i.getMeasuredHeight() + this.c((View)this.i));
            n7 = gz.a(n7, bo.j((View)this.i));
        }
        int n10 = this.getContentInsetStart();
        int n11 = 0 + Math.max(n10, n6);
        arrn[n4] = Math.max(0, n10 - n6);
        boolean bl3 = this.a((View)this.b);
        int n12 = 0;
        if (bl3) {
            this.a((View)this.b, n2, n11, n3, 0, this.o);
            n12 = this.b.getMeasuredWidth() + this.b((View)this.b);
            n8 = Math.max(n8, this.b.getMeasuredHeight() + this.c((View)this.b));
            n7 = gz.a(n7, bo.j((View)this.b));
        }
        int n13 = this.getContentInsetEnd();
        int n14 = n11 + Math.max(n13, n12);
        arrn[n5] = Math.max(0, n13 - n12);
        if (this.a(this.a)) {
            n14 += this.a(this.a, n2, n14, n3, 0, arrn);
            n8 = Math.max(n8, this.a.getMeasuredHeight() + this.c(this.a));
            n7 = gz.a(n7, bo.j(this.a));
        }
        if (this.a((View)this.f)) {
            n14 += this.a((View)this.f, n2, n14, n3, 0, arrn);
            n8 = Math.max(n8, this.f.getMeasuredHeight() + this.c((View)this.f));
            n7 = gz.a(n7, bo.j((View)this.f));
        }
        int n15 = this.getChildCount();
        int n16 = n8;
        int n17 = n7;
        for (int i2 = 0; i2 < n15; ++i2) {
            int n18;
            int n19;
            View view = this.getChildAt(i2);
            if (((gp)view.getLayoutParams()).b == 0) {
                if (!this.a(view)) {
                    n18 = n17;
                    n19 = n16;
                } else {
                    n14 += this.a(view, n2, n14, n3, 0, arrn);
                    int n20 = Math.max(n16, view.getMeasuredHeight() + this.c(view));
                    n18 = gz.a(n17, bo.j(view));
                    n19 = n20;
                }
            } else {
                n18 = n17;
                n19 = n16;
            }
            n17 = n18;
            n16 = n19;
        }
        int n21 = this.r + this.s;
        int n22 = this.p + this.q;
        boolean bl4 = this.a((View)this.c);
        int n23 = 0;
        int n24 = 0;
        if (bl4) {
            this.a((View)this.c, n2, n14 + n22, n3, n21, arrn);
            n24 = this.c.getMeasuredWidth() + this.b((View)this.c);
            n23 = this.c.getMeasuredHeight() + this.c((View)this.c);
            n17 = gz.a(n17, bo.j((View)this.c));
        }
        if (this.a((View)this.d)) {
            n24 = Math.max(n24, this.a((View)this.d, n2, n14 + n22, n3, n21 + n23, arrn));
            n23 += this.d.getMeasuredHeight() + this.c((View)this.d);
            n17 = gz.a(n17, bo.j((View)this.d));
        }
        int n25 = n24 + n14;
        int n26 = Math.max(n16, n23);
        int n27 = n25 + (this.getPaddingLeft() + this.getPaddingRight());
        int n28 = n26 + (this.getPaddingTop() + this.getPaddingBottom());
        int n29 = bo.a(Math.max(n27, this.getSuggestedMinimumWidth()), n2, -16777216 & n17);
        int n30 = bo.a(Math.max(n28, this.getSuggestedMinimumHeight()), n3, n17 << 16);
        if (this.r()) {
            n30 = 0;
        }
        this.setMeasuredDimension(n29, n30);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItem;
        Toolbar$SavedState toolbar$SavedState = (Toolbar$SavedState)parcelable;
        super.onRestoreInstanceState(toolbar$SavedState.getSuperState());
        android.support.v7.view.menu.i i2 = this.b != null ? this.b.d() : null;
        if (toolbar$SavedState.a != 0 && this.I != null && i2 != null && (menuItem = i2.findItem(toolbar$SavedState.a)) != null) {
            al.b(menuItem);
        }
        if (!toolbar$SavedState.b) return;
        this.q();
    }

    public void onRtlPropertiesChanged(int n2) {
        int n3 = 1;
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(n2);
        }
        fl fl2 = this.t;
        if (n2 != n3) {
            n3 = 0;
        }
        fl2.a((boolean)n3);
    }

    protected Parcelable onSaveInstanceState() {
        Toolbar$SavedState toolbar$SavedState = new Toolbar$SavedState(super.onSaveInstanceState());
        if (this.I != null && this.I.b != null) {
            toolbar$SavedState.a = this.I.b.getItemId();
        }
        toolbar$SavedState.b = this.b();
        return toolbar$SavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = at.a(motionEvent);
        if (n2 == 0) {
            this.z = false;
        }
        if (!this.z) {
            boolean bl2 = super.onTouchEvent(motionEvent);
            if (n2 == 0 && !bl2) {
                this.z = true;
            }
        }
        if (n2 != 1) {
            if (n2 != 3) return true;
        }
        this.z = false;
        return true;
    }

    public void setCollapsible(boolean bl2) {
        this.L = bl2;
        this.requestLayout();
    }

    public void setLogo(int n2) {
        this.setLogo(this.N.a(this.getContext(), n2));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            this.l();
            if (!this.d((View)this.f)) {
                this.a((View)this.f, true);
            }
        } else if (this.f != null && this.d((View)this.f)) {
            this.removeView((View)this.f);
            this.C.remove((Object)this.f);
        }
        if (this.f == null) return;
        this.f.setImageDrawable(drawable);
    }

    public void setLogoDescription(int n2) {
        this.setLogoDescription(this.getContext().getText(n2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.l();
        }
        if (this.f == null) return;
        this.f.setContentDescription(charSequence);
    }

    public void setNavigationContentDescription(int n2) {
        CharSequence charSequence = n2 != 0 ? this.getContext().getText(n2) : null;
        this.setNavigationContentDescription(charSequence);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.o();
        }
        if (this.e == null) return;
        this.e.setContentDescription(charSequence);
    }

    public void setNavigationIcon(int n2) {
        this.setNavigationIcon(this.N.a(this.getContext(), n2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            this.o();
            if (!this.d((View)this.e)) {
                this.a((View)this.e, true);
            }
        } else if (this.e != null && this.d((View)this.e)) {
            this.removeView((View)this.e);
            this.C.remove((Object)this.e);
        }
        if (this.e == null) return;
        this.e.setImageDrawable(drawable);
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        this.o();
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(gq gq2) {
        this.E = gq2;
    }

    public void setOverflowIcon(Drawable drawable) {
        this.m();
        this.b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int n2) {
        if (this.k == n2) return;
        this.k = n2;
        if (n2 == 0) {
            this.j = this.getContext();
            return;
        }
        this.j = new ContextThemeWrapper(this.getContext(), n2);
    }

    public void setSubtitle(int n2) {
        this.setSubtitle(this.getContext().getText(n2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.d == null) {
                Context context = this.getContext();
                this.d = new TextView(context);
                this.d.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                if (this.m != 0) {
                    this.d.setTextAppearance(context, this.m);
                }
                if (this.y != 0) {
                    this.d.setTextColor(this.y);
                }
            }
            if (!this.d((View)this.d)) {
                this.a((View)this.d, true);
            }
        } else if (this.d != null && this.d((View)this.d)) {
            this.removeView((View)this.d);
            this.C.remove((Object)this.d);
        }
        if (this.d != null) {
            this.d.setText(charSequence);
        }
        this.w = charSequence;
    }

    public void setSubtitleTextColor(int n2) {
        this.y = n2;
        if (this.d == null) return;
        this.d.setTextColor(n2);
    }

    public void setTitle(int n2) {
        this.setTitle(this.getContext().getText(n2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.c == null) {
                Context context = this.getContext();
                this.c = new TextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.l != 0) {
                    this.c.setTextAppearance(context, this.l);
                }
                if (this.x != 0) {
                    this.c.setTextColor(this.x);
                }
            }
            if (!this.d((View)this.c)) {
                this.a((View)this.c, true);
            }
        } else if (this.c != null && this.d((View)this.c)) {
            this.removeView((View)this.c);
            this.C.remove((Object)this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.v = charSequence;
    }

    public void setTitleTextColor(int n2) {
        this.x = n2;
        if (this.c == null) return;
        this.c.setTextColor(n2);
    }
}

