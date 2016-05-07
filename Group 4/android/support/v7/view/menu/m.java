/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.d.a.b;
import android.support.v4.h.aq;
import android.support.v4.h.p;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.n;
import android.support.v7.widget.ar;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public final class m
implements b {
    private static String w;
    private static String x;
    private static String y;
    private static String z;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k = 0;
    private i l;
    private ad m;
    private Runnable n;
    private MenuItem.OnMenuItemClickListener o;
    private int p = 16;
    private int q = 0;
    private View r;
    private android.support.v4.h.n s;
    private aq t;
    private boolean u = false;
    private ContextMenu.ContextMenuInfo v;

    m(i i2, int n2, int n3, int n4, int n5, CharSequence charSequence, int n6) {
        this.l = i2;
        this.a = n3;
        this.b = n2;
        this.c = n4;
        this.d = n5;
        this.e = charSequence;
        this.q = n6;
    }

    static /* synthetic */ i a(m m2) {
        return m2.l;
    }

    public b a(int n2) {
        Context context = this.l.e();
        this.a(LayoutInflater.from((Context)context).inflate(n2, (ViewGroup)new LinearLayout(context), false));
        return this;
    }

    @Override
    public b a(aq aq2) {
        this.t = aq2;
        return this;
    }

    @Override
    public b a(android.support.v4.h.n n2) {
        if (this.s != null) {
            this.s.f();
        }
        this.r = null;
        this.s = n2;
        this.l.b(true);
        if (this.s == null) return this;
        this.s.a(new n(this));
        return this;
    }

    public b a(View view) {
        this.r = view;
        this.s = null;
        if (view != null && view.getId() == -1 && this.a > 0) {
            view.setId(this.a);
        }
        this.l.b(this);
        return this;
    }

    @Override
    public android.support.v4.h.n a() {
        return this.s;
    }

    CharSequence a(aa aa2) {
        if (aa2 == null) return this.getTitle();
        if (!aa2.a()) return this.getTitle();
        return this.getTitleCondensed();
    }

    public void a(ad ad2) {
        this.m = ad2;
        ad2.setHeaderTitle(this.getTitle());
    }

    void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.v = contextMenuInfo;
    }

    public void a(boolean bl2) {
        int n2 = -5 & this.p;
        int n3 = bl2 ? 4 : 0;
        this.p = n3 | n2;
    }

    public b b(int n2) {
        this.setShowAsAction(n2);
        return this;
    }

    void b(boolean bl2) {
        int n2 = this.p;
        int n3 = -3 & this.p;
        int n4 = bl2 ? 2 : 0;
        this.p = n4 | n3;
        if (n2 == this.p) return;
        this.l.b(false);
    }

    public boolean b() {
        if (this.o != null && this.o.onMenuItemClick((MenuItem)this)) {
            return true;
        }
        if (this.l.a(this.l.p(), this)) return true;
        if (this.n != null) {
            this.n.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.l.e().startActivity(this.g);
                return true;
            }
            catch (ActivityNotFoundException var1_1) {
                Log.e((String)"MenuItemImpl", (String)"Can't find activity to handle intent; ignoring", (Throwable)var1_1);
            }
        }
        if (this.s == null) return false;
        if (this.s.d()) return true;
        return false;
    }

    public int c() {
        return this.d;
    }

    boolean c(boolean bl2) {
        int n2 = this.p;
        int n3 = -9 & this.p;
        int n4 = bl2 ? 0 : 8;
        int n5 = this.p = n4 | n3;
        boolean bl3 = false;
        if (n2 == n5) return bl3;
        return true;
    }

    @Override
    public boolean collapseActionView() {
        if ((8 & this.q) == 0) {
            return false;
        }
        if (this.r == null) {
            return true;
        }
        if (this.t == null) return this.l.d(this);
        if (!this.t.b(this)) return false;
        return this.l.d(this);
    }

    char d() {
        if (!this.l.b()) return this.h;
        return this.i;
    }

    public void d(boolean bl2) {
        if (bl2) {
            this.p = 32 | this.p;
            return;
        }
        this.p = -33 & this.p;
    }

    String e() {
        char c2 = this.d();
        if (c2 == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(w);
        switch (c2) {
            default: {
                stringBuilder.append(c2);
                return stringBuilder.toString();
            }
            case '\n': {
                stringBuilder.append(x);
                return stringBuilder.toString();
            }
            case '\b': {
                stringBuilder.append(y);
                return stringBuilder.toString();
            }
            case ' ': 
        }
        stringBuilder.append(z);
        return stringBuilder.toString();
    }

    public void e(boolean bl2) {
        this.u = bl2;
        this.l.b(false);
    }

    @Override
    public boolean expandActionView() {
        if (!this.n()) {
            return false;
        }
        if (this.t == null) return this.l.c(this);
        if (!this.t.a(this)) return false;
        return this.l.c(this);
    }

    boolean f() {
        if (!this.l.c()) return false;
        if (this.d() == '\u0000') return false;
        return true;
    }

    public boolean g() {
        if ((4 & this.p) == 0) return false;
        return true;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override
    public View getActionView() {
        if (this.r != null) {
            return this.r;
        }
        if (this.s == null) return null;
        this.r = this.s.a(this);
        return this.r;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        if (this.j != null) {
            return this.j;
        }
        if (this.k == 0) return null;
        Drawable drawable = ar.a().a(this.l.e(), this.k);
        this.k = 0;
        this.j = drawable;
        return drawable;
    }

    public Intent getIntent() {
        return this.g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.v;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return this.m;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f != null ? this.f : this.e;
        if (Build.VERSION.SDK_INT >= 18) return charSequence;
        if (charSequence == null) return charSequence;
        if (charSequence instanceof String) return charSequence;
        return charSequence.toString();
    }

    public void h() {
        this.l.b(this);
    }

    public boolean hasSubMenu() {
        if (this.m == null) return false;
        return true;
    }

    public boolean i() {
        return this.l.q();
    }

    @Override
    public boolean isActionViewExpanded() {
        return this.u;
    }

    public boolean isCheckable() {
        if ((1 & this.p) != 1) return false;
        return true;
    }

    public boolean isChecked() {
        if ((2 & this.p) != 2) return false;
        return true;
    }

    public boolean isEnabled() {
        if ((16 & this.p) == 0) return false;
        return true;
    }

    public boolean isVisible() {
        if (this.s != null && this.s.b()) {
            if ((8 & this.p) != 0) return false;
            if (!this.s.c()) return false;
            return true;
        }
        if ((8 & this.p) == 0) return true;
        return false;
    }

    public boolean j() {
        if ((32 & this.p) != 32) return false;
        return true;
    }

    public boolean k() {
        if ((1 & this.q) != 1) return false;
        return true;
    }

    public boolean l() {
        if ((2 & this.q) != 2) return false;
        return true;
    }

    public boolean m() {
        if ((4 & this.q) != 4) return false;
        return true;
    }

    public boolean n() {
        int n2 = 8 & this.q;
        boolean bl2 = false;
        if (n2 == 0) return bl2;
        if (this.r == null && this.s != null) {
            this.r = this.s.a(this);
        }
        View view = this.r;
        bl2 = false;
        if (view == null) return bl2;
        return true;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override
    public /* synthetic */ MenuItem setActionView(int n2) {
        return this.a(n2);
    }

    @Override
    public /* synthetic */ MenuItem setActionView(View view) {
        return this.a(view);
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.i == c2) {
            return this;
        }
        this.i = Character.toLowerCase(c2);
        this.l.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        int n2 = this.p;
        int n3 = -2 & this.p;
        int n4 = bl2 ? 1 : 0;
        this.p = n4 | n3;
        if (n2 == this.p) return this;
        this.l.b(false);
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        if ((4 & this.p) != 0) {
            this.l.a((MenuItem)this);
            return this;
        }
        this.b(bl2);
        return this;
    }

    public MenuItem setEnabled(boolean bl2) {
        this.p = bl2 ? 16 | this.p : -17 & this.p;
        this.l.b(false);
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.j = null;
        this.k = n2;
        this.l.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = 0;
        this.j = drawable;
        this.l.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.h == c2) {
            return this;
        }
        this.h = c2;
        this.l.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.i = Character.toLowerCase(c3);
        this.l.b(false);
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
        switch (n2 & 3) {
            default: {
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            }
            case 0: 
            case 1: 
            case 2: 
        }
        this.q = n2;
        this.l.b(this);
    }

    @Override
    public /* synthetic */ MenuItem setShowAsActionFlags(int n2) {
        return this.b(n2);
    }

    public MenuItem setTitle(int n2) {
        return this.setTitle(this.l.e().getString(n2));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.l.b(false);
        if (this.m == null) return this;
        this.m.setHeaderTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        if (charSequence == null) {
            // empty if block
        }
        this.l.b(false);
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        if (!this.c(bl2)) return this;
        this.l.a(this);
        return this;
    }

    public String toString() {
        if (this.e == null) return null;
        return this.e.toString();
    }
}

