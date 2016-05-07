/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.h.bo;
import android.support.v7.a.a;
import android.support.v7.a.bf;
import android.support.v7.a.bg;
import android.support.v7.a.bh;
import android.support.v7.a.bi;
import android.support.v7.a.bj;
import android.support.v7.a.bk;
import android.support.v7.a.c;
import android.support.v7.b.b;
import android.support.v7.b.i;
import android.support.v7.b.k;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.support.v7.view.menu.z;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.cf;
import android.support.v7.widget.gq;
import android.support.v7.widget.gs;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import java.util.ArrayList;

class be
extends a {
    private cf a;
    private boolean b;
    private Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList f = new ArrayList();
    private g g;
    private final Runnable h;
    private final gq i;

    public be(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.h = new bf(this);
        this.i = new bg(this);
        this.a = new gs(toolbar, false);
        this.c = new bk(this, callback);
        this.a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.i);
        this.a.a(charSequence);
    }

    static /* synthetic */ View a(be be2, Menu menu) {
        return be2.a(menu);
    }

    private View a(Menu menu) {
        this.b(menu);
        if (menu == null) return null;
        if (this.g == null) {
            return null;
        }
        if (this.g.a().getCount() <= 0) return null;
        return (View)this.g.a(this.a.a());
    }

    static /* synthetic */ Window.Callback a(be be2) {
        return be2.c;
    }

    static /* synthetic */ boolean a(be be2, boolean bl2) {
        be2.b = bl2;
        return bl2;
    }

    private void b(Menu menu) {
        if (this.g != null) return;
        if (!(menu instanceof android.support.v7.view.menu.i)) return;
        android.support.v7.view.menu.i i2 = (android.support.v7.view.menu.i)menu;
        Context context = this.a.b();
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getResources().newTheme();
        theme.setTo(context.getTheme());
        theme.resolveAttribute(b.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, true);
        }
        theme.resolveAttribute(b.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, true);
        } else {
            theme.applyStyle(k.Theme_AppCompat_CompactMenu, true);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
        contextThemeWrapper.getTheme().setTo(theme);
        this.g = new g((Context)contextThemeWrapper, i.abc_list_menu_item_layout);
        this.g.a(new bj(this, null));
        i2.a(this.g);
    }

    static /* synthetic */ boolean b(be be2) {
        return be2.b;
    }

    static /* synthetic */ cf c(be be2) {
        return be2.a;
    }

    private Menu k() {
        if (this.d) return this.a.r();
        this.a.a(new bh(this, null), new bi(this, null));
        this.d = true;
        return this.a.r();
    }

    @Override
    public int a() {
        return this.a.o();
    }

    @Override
    public void a(float f2) {
        bo.d((View)this.a.a(), f2);
    }

    @Override
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override
    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    @Override
    public void a(boolean bl2) {
    }

    @Override
    public boolean a(int n2, KeyEvent keyEvent) {
        Menu menu = this.k();
        if (menu == null) return true;
        int n3 = keyEvent != null ? keyEvent.getDeviceId() : -1;
        boolean bl2 = KeyCharacterMap.load((int)n3).getKeyboardType() != 1;
        menu.setQwertyMode(bl2);
        menu.performShortcut(n2, keyEvent, 0);
        return true;
    }

    @Override
    public boolean b() {
        if (this.a.q() != 0) return false;
        return true;
    }

    @Override
    public Context c() {
        return this.a.b();
    }

    @Override
    public void c(boolean bl2) {
    }

    @Override
    public void d(boolean bl2) {
    }

    @Override
    public void e(boolean bl2) {
        if (bl2 == this.e) {
            return;
        }
        this.e = bl2;
        int n2 = this.f.size();
        int n3 = 0;
        while (n3 < n2) {
            ((c)this.f.get(n3)).a(bl2);
            ++n3;
        }
    }

    @Override
    public boolean e() {
        this.a.a().removeCallbacks(this.h);
        bo.a((View)this.a.a(), this.h);
        return true;
    }

    @Override
    public boolean f() {
        if (!this.a.c()) return false;
        this.a.d();
        return true;
    }

    @Override
    public boolean g() {
        ViewGroup viewGroup = this.a.a();
        if (viewGroup == null) return false;
        if (viewGroup.hasFocus()) return false;
        viewGroup.requestFocus();
        return true;
    }

    @Override
    void h() {
        this.a.a().removeCallbacks(this.h);
    }

    public Window.Callback i() {
        return this.c;
    }

    void j() {
        Menu menu = this.k();
        android.support.v7.view.menu.i i2 = menu instanceof android.support.v7.view.menu.i ? (android.support.v7.view.menu.i)menu : null;
        if (i2 != null) {
            i2.g();
        }
        try {
            menu.clear();
            if (this.c.onCreatePanelMenu(0, menu)) {
                if (this.c.onPreparePanel(0, null, menu)) return;
            }
            menu.clear();
            return;
        }
        finally {
            if (i2 != null) {
                i2.h();
            }
        }
    }
}

