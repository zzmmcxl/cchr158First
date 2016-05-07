/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.b.b;
import android.support.v7.b.e;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.w;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.support.v7.widget.df;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public class v
implements x,
View.OnKeyListener,
ViewTreeObserver.OnGlobalLayoutListener,
AdapterView.OnItemClickListener,
PopupWindow.OnDismissListener {
    static final int a = android.support.v7.b.i.abc_popup_menu_item_layout;
    boolean b;
    private final Context c;
    private final LayoutInflater d;
    private final i e;
    private final w f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private View k;
    private df l;
    private ViewTreeObserver m;
    private y n;
    private ViewGroup o;
    private boolean p;
    private int q;
    private int r = 0;

    public v(Context context, i i2, View view) {
        this(context, i2, view, false, b.popupMenuStyle);
    }

    public v(Context context, i i2, View view, boolean bl2, int n2) {
        this(context, i2, view, bl2, n2, 0);
    }

    public v(Context context, i i2, View view, boolean bl2, int n2, int n3) {
        this.c = context;
        this.d = LayoutInflater.from((Context)context);
        this.e = i2;
        this.f = new w(this, this.e);
        this.g = bl2;
        this.i = n2;
        this.j = n3;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        this.k = view;
        i2.a(this, context);
    }

    static /* synthetic */ boolean a(v v2) {
        return v2.g;
    }

    static /* synthetic */ LayoutInflater b(v v2) {
        return v2.d;
    }

    static /* synthetic */ i c(v v2) {
        return v2.e;
    }

    private int g() {
        w w2 = this.f;
        int n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n4 = w2.getCount();
        int n5 = 0;
        int n6 = 0;
        View view = null;
        int n7 = 0;
        while (n5 < n4) {
            View view2;
            int n8 = w2.getItemViewType(n5);
            if (n8 != n6) {
                n6 = n8;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.o == null) {
                this.o = new FrameLayout(this.c);
            }
            view = w2.getView(n5, view2, this.o);
            view.measure(n2, n3);
            int n9 = view.getMeasuredWidth();
            if (n9 >= this.h) {
                return this.h;
            }
            if (n9 <= n7) {
                n9 = n7;
            }
            ++n5;
            n7 = n9;
        }
        return n7;
    }

    public void a() {
        if (this.d()) return;
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void a(int n2) {
        this.r = n2;
    }

    @Override
    public void a(Context context, i i2) {
    }

    @Override
    public void a(i i2, boolean bl2) {
        if (i2 != this.e) {
            return;
        }
        this.e();
        if (this.n == null) return;
        this.n.a(i2, bl2);
    }

    public void a(y y2) {
        this.n = y2;
    }

    public void a(View view) {
        this.k = view;
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    @Override
    public boolean a(ad ad2) {
        boolean bl2;
        v v2;
        block1 : {
            if (!ad2.hasVisibleItems()) return false;
            v2 = new v(this.c, ad2, this.k);
            v2.a(this.n);
            int n2 = ad2.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                MenuItem menuItem = ad2.getItem(i2);
                if (!menuItem.isVisible() || menuItem.getIcon() == null) continue;
                bl2 = true;
                break block1;
            }
            bl2 = false;
        }
        v2.a(bl2);
        if (!v2.d()) return false;
        if (this.n == null) return true;
        this.n.a(ad2);
        return true;
    }

    @Override
    public boolean a(i i2, m m2) {
        return false;
    }

    @Override
    public void b(boolean bl2) {
        this.p = false;
        if (this.f == null) return;
        this.f.notifyDataSetChanged();
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean b(i i2, m m2) {
        return false;
    }

    public df c() {
        return this.l;
    }

    public boolean d() {
        this.l = new df(this.c, null, this.i, this.j);
        this.l.a(this);
        this.l.a(this);
        this.l.a((ListAdapter)this.f);
        this.l.a(true);
        View view = this.k;
        if (view == null) return false;
        ViewTreeObserver viewTreeObserver = this.m;
        boolean bl2 = false;
        if (viewTreeObserver == null) {
            bl2 = true;
        }
        this.m = view.getViewTreeObserver();
        if (bl2) {
            this.m.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
        this.l.a(view);
        this.l.d(this.r);
        if (!this.p) {
            this.q = this.g();
            this.p = true;
        }
        this.l.f(this.q);
        this.l.g(2);
        this.l.c();
        this.l.m().setOnKeyListener((View.OnKeyListener)this);
        return true;
    }

    public void e() {
        if (!this.f()) return;
        this.l.i();
    }

    public boolean f() {
        if (this.l == null) return false;
        if (!this.l.k()) return false;
        return true;
    }

    public void onDismiss() {
        this.l = null;
        this.e.close();
        if (this.m == null) return;
        if (!this.m.isAlive()) {
            this.m = this.k.getViewTreeObserver();
        }
        this.m.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        this.m = null;
    }

    public void onGlobalLayout() {
        if (!this.f()) return;
        View view = this.k;
        if (view != null && view.isShown()) {
            if (!this.f()) return;
            this.l.c();
            return;
        }
        this.e();
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        w w2 = this.f;
        w.a(w2).a(w2.a(n2), 0);
    }

    public boolean onKey(View view, int n2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) return false;
        if (n2 != 82) return false;
        this.e();
        return true;
    }
}

