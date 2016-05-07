/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.h.be;
import android.support.v4.h.bf;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v4.widget.as;
import android.support.v7.b.b;
import android.support.v7.view.menu.y;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ce;
import android.support.v7.widget.cf;
import android.support.v7.widget.f;
import android.support.v7.widget.g;
import android.support.v7.widget.gz;
import android.support.v7.widget.h;
import android.support.v7.widget.i;
import android.support.v7.widget.j;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class ActionBarOverlayLayout
extends ViewGroup
implements be,
ce {
    static final int[] a;
    private final Runnable A;
    private final bf B;
    private int b;
    private int c = 0;
    private ContentFrameLayout d;
    private ActionBarContainer e;
    private cf f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private final Rect o = new Rect();
    private final Rect p = new Rect();
    private final Rect q = new Rect();
    private final Rect r = new Rect();
    private final Rect s = new Rect();
    private final Rect t = new Rect();
    private i u;
    private final int v = 600;
    private as w;
    private dc x;
    private final dt y;
    private final Runnable z;

    static {
        int[] arrn = new int[]{b.actionBarSize, 16842841};
        a = arrn;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new f(this);
        this.z = new g(this);
        this.A = new h(this);
        this.a(context);
        this.B = new bf(this);
    }

    static /* synthetic */ dc a(ActionBarOverlayLayout actionBarOverlayLayout, dc dc2) {
        actionBarOverlayLayout.x = dc2;
        return dc2;
    }

    private cf a(View view) {
        if (view instanceof cf) {
            return (cf)view;
        }
        if (!(view instanceof Toolbar)) throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
        return ((Toolbar)view).getWrapper();
    }

    private void a(Context context) {
        boolean bl2 = true;
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(a);
        this.b = typedArray.getDimensionPixelSize(0, 0);
        this.g = typedArray.getDrawable((int)bl2 ? 1 : 0);
        boolean bl3 = this.g == null ? bl2 : false;
        this.setWillNotDraw(bl3);
        typedArray.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            bl2 = false;
        }
        this.h = bl2;
        this.w = as.a(context);
    }

    static /* synthetic */ void a(ActionBarOverlayLayout actionBarOverlayLayout) {
        actionBarOverlayLayout.k();
    }

    private boolean a(float f2, float f3) {
        this.w.a(0, 0, 0, (int)f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int n2 = this.w.e();
        int n3 = this.e.getHeight();
        boolean bl2 = false;
        if (n2 <= n3) return bl2;
        return true;
    }

    static /* synthetic */ boolean a(ActionBarOverlayLayout actionBarOverlayLayout, boolean bl2) {
        actionBarOverlayLayout.l = bl2;
        return bl2;
    }

    private boolean a(View view, Rect rect, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        j j2 = (j)view.getLayoutParams();
        boolean bl6 = false;
        if (bl2) {
            int n2 = j2.leftMargin;
            int n3 = rect.left;
            bl6 = false;
            if (n2 != n3) {
                j2.leftMargin = rect.left;
                bl6 = true;
            }
        }
        if (bl3 && j2.topMargin != rect.top) {
            j2.topMargin = rect.top;
            bl6 = true;
        }
        if (bl5 && j2.rightMargin != rect.right) {
            j2.rightMargin = rect.right;
            bl6 = true;
        }
        if (!bl4) return bl6;
        if (j2.bottomMargin == rect.bottom) return bl6;
        j2.bottomMargin = rect.bottom;
        return true;
    }

    static /* synthetic */ dt b(ActionBarOverlayLayout actionBarOverlayLayout) {
        return actionBarOverlayLayout.y;
    }

    static /* synthetic */ ActionBarContainer c(ActionBarOverlayLayout actionBarOverlayLayout) {
        return actionBarOverlayLayout.e;
    }

    private void k() {
        this.removeCallbacks(this.z);
        this.removeCallbacks(this.A);
        if (this.x == null) return;
        this.x.b();
    }

    private void l() {
        this.k();
        this.postDelayed(this.z, 600);
    }

    private void m() {
        this.k();
        this.postDelayed(this.A, 600);
    }

    private void n() {
        this.k();
        this.z.run();
    }

    private void o() {
        this.k();
        this.A.run();
    }

    public j a(AttributeSet attributeSet) {
        return new j(this.getContext(), attributeSet);
    }

    @Override
    public void a(int n2) {
        this.c();
        switch (n2) {
            default: {
                return;
            }
            case 2: {
                this.f.f();
                return;
            }
            case 5: {
                this.f.g();
                return;
            }
            case 109: 
        }
        this.setOverlayMode(true);
    }

    @Override
    public void a(Menu menu, y y2) {
        this.c();
        this.f.a(menu, y2);
    }

    public boolean a() {
        return this.i;
    }

    protected j b() {
        return new j(-1, -1);
    }

    void c() {
        if (this.d != null) return;
        this.d = (ContentFrameLayout)this.findViewById(android.support.v7.b.g.action_bar_activity_content);
        this.e = (ActionBarContainer)this.findViewById(android.support.v7.b.g.action_bar_container);
        this.f = this.a(this.findViewById(android.support.v7.b.g.action_bar));
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j;
    }

    @Override
    public boolean d() {
        this.c();
        return this.f.h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g == null) return;
        if (this.h) return;
        int n2 = this.e.getVisibility() == 0 ? (int)(0.5f + ((float)this.e.getBottom() + bo.n((View)this.e))) : 0;
        this.g.setBounds(0, n2, this.getWidth(), n2 + this.g.getIntrinsicHeight());
        this.g.draw(canvas);
    }

    @Override
    public boolean e() {
        this.c();
        return this.f.i();
    }

    @Override
    public boolean f() {
        this.c();
        return this.f.j();
    }

    protected boolean fitSystemWindows(Rect rect) {
        this.c();
        if ((256 & bo.r((View)this)) != 0) {
            // empty if block
        }
        boolean bl2 = this.a((View)this.e, rect, true, true, false, true);
        this.r.set(rect);
        gz.a((View)this, this.r, this.o);
        if (!this.p.equals((Object)this.o)) {
            this.p.set(this.o);
            bl2 = true;
        }
        if (!bl2) return true;
        this.requestLayout();
        return true;
    }

    @Override
    public boolean g() {
        this.c();
        return this.f.k();
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.b();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new j(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.e == null) return 0;
        return - (int)bo.n((View)this.e);
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        this.c();
        return this.f.e();
    }

    @Override
    public boolean h() {
        this.c();
        return this.f.l();
    }

    @Override
    public void i() {
        this.c();
        this.f.m();
    }

    @Override
    public void j() {
        this.c();
        this.f.n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.a(this.getContext());
        bo.s((View)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6 = this.getChildCount();
        int n7 = this.getPaddingLeft();
        n4 - n2 - this.getPaddingRight();
        int n8 = this.getPaddingTop();
        n5 - n3 - this.getPaddingBottom();
        int n9 = 0;
        while (n9 < n6) {
            View view = this.getChildAt(n9);
            if (view.getVisibility() != 8) {
                j j2 = (j)view.getLayoutParams();
                int n10 = view.getMeasuredWidth();
                int n11 = view.getMeasuredHeight();
                int n12 = n7 + j2.leftMargin;
                int n13 = n8 + j2.topMargin;
                view.layout(n12, n13, n10 + n12, n11 + n13);
            }
            ++n9;
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        this.c();
        this.measureChildWithMargins((View)this.e, n2, 0, n3, 0);
        j j2 = (j)this.e.getLayoutParams();
        int n5 = Math.max(0, this.e.getMeasuredWidth() + j2.leftMargin + j2.rightMargin);
        int n6 = Math.max(0, this.e.getMeasuredHeight() + j2.topMargin + j2.bottomMargin);
        int n7 = gz.a(0, bo.j((View)this.e));
        boolean bl2 = (256 & bo.r((View)this)) != 0;
        if (bl2) {
            n4 = this.b;
            if (this.j && this.e.getTabContainer() != null) {
                n4 += this.b;
            }
        } else {
            n4 = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.s.set(this.r);
        if (!this.i && !bl2) {
            Rect rect = this.q;
            rect.top = n4 + rect.top;
            Rect rect2 = this.q;
            rect2.bottom = 0 + rect2.bottom;
        } else {
            Rect rect = this.s;
            rect.top = n4 + rect.top;
            Rect rect3 = this.s;
            rect3.bottom = 0 + rect3.bottom;
        }
        this.a((View)this.d, this.q, true, true, true, true);
        if (!this.t.equals((Object)this.s)) {
            this.t.set(this.s);
            this.d.a(this.s);
        }
        this.measureChildWithMargins((View)this.d, n2, 0, n3, 0);
        j j3 = (j)this.d.getLayoutParams();
        int n8 = Math.max(n5, this.d.getMeasuredWidth() + j3.leftMargin + j3.rightMargin);
        int n9 = Math.max(n6, this.d.getMeasuredHeight() + j3.topMargin + j3.bottomMargin);
        int n10 = gz.a(n7, bo.j((View)this.d));
        int n11 = n8 + (this.getPaddingLeft() + this.getPaddingRight());
        int n12 = Math.max(n9 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(bo.a(Math.max(n11, this.getSuggestedMinimumWidth()), n2, n10), bo.a(n12, n3, n10 << 16));
    }

    @Override
    public boolean onNestedFling(View view, float f2, float f3, boolean bl2) {
        if (!this.k) return false;
        if (!bl2) {
            return false;
        }
        if (this.a(f2, f3)) {
            this.o();
        } else {
            this.n();
        }
        this.l = true;
        return true;
    }

    @Override
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override
    public void onNestedPreScroll(View view, int n2, int n3, int[] arrn) {
    }

    @Override
    public void onNestedScroll(View view, int n2, int n3, int n4, int n5) {
        this.m = n3 + this.m;
        this.setActionBarHideOffset(this.m);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n2) {
        this.B.a(view, view2, n2);
        this.m = this.getActionBarHideOffset();
        this.k();
        if (this.u == null) return;
        this.u.n();
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n2) {
        if ((n2 & 2) == 0) return false;
        if (this.e.getVisibility() == 0) return this.k;
        return false;
    }

    @Override
    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                this.l();
            } else {
                this.m();
            }
        }
        if (this.u == null) return;
        this.u.o();
    }

    public void onWindowSystemUiVisibilityChanged(int n2) {
        boolean bl2 = true;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(n2);
        }
        this.c();
        int n3 = n2 ^ this.n;
        this.n = n2;
        boolean bl3 = (n2 & 4) == 0 ? bl2 : false;
        boolean bl4 = (n2 & 256) != 0 ? bl2 : false;
        if (this.u != null) {
            i i2 = this.u;
            if (bl4) {
                bl2 = false;
            }
            i2.g(bl2);
            if (bl3 || !bl4) {
                this.u.l();
            } else {
                this.u.m();
            }
        }
        if ((n3 & 256) == 0) return;
        if (this.u == null) return;
        bo.s((View)this);
    }

    protected void onWindowVisibilityChanged(int n2) {
        super.onWindowVisibilityChanged(n2);
        this.c = n2;
        if (this.u == null) return;
        this.u.a(n2);
    }

    public void setActionBarHideOffset(int n2) {
        this.k();
        int n3 = Math.max(0, Math.min(n2, this.e.getHeight()));
        bo.b((View)this.e, (float)(- n3));
    }

    public void setActionBarVisibilityCallback(i i2) {
        this.u = i2;
        if (this.getWindowToken() == null) return;
        this.u.a(this.c);
        if (this.n == 0) return;
        this.onWindowSystemUiVisibilityChanged(this.n);
        bo.s((View)this);
    }

    public void setHasNonEmbeddedTabs(boolean bl2) {
        this.j = bl2;
    }

    public void setHideOnContentScrollEnabled(boolean bl2) {
        if (bl2 == this.k) return;
        this.k = bl2;
        if (bl2) return;
        this.k();
        this.setActionBarHideOffset(0);
    }

    public void setIcon(int n2) {
        this.c();
        this.f.a(n2);
    }

    public void setIcon(Drawable drawable) {
        this.c();
        this.f.a(drawable);
    }

    public void setLogo(int n2) {
        this.c();
        this.f.b(n2);
    }

    public void setOverlayMode(boolean bl2) {
        this.i = bl2;
        boolean bl3 = bl2 && this.getContext().getApplicationInfo().targetSdkVersion < 19;
        this.h = bl3;
    }

    public void setShowingForActionMode(boolean bl2) {
    }

    public void setUiOptions(int n2) {
    }

    @Override
    public void setWindowCallback(Window.Callback callback) {
        this.c();
        this.f.a(callback);
    }

    @Override
    public void setWindowTitle(CharSequence charSequence) {
        this.c();
        this.f.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

