/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.a.bp;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class bt
extends b
implements j {
    final /* synthetic */ bp a;
    private final Context b;
    private final i c;
    private c d;
    private WeakReference e;

    public bt(bp bp2, Context context, c c2) {
        this.a = bp2;
        this.b = context;
        this.d = c2;
        this.c = new i(context).a(1);
        this.c.a(this);
    }

    @Override
    public MenuInflater a() {
        return new android.support.v7.view.i(this.b);
    }

    @Override
    public void a(int n2) {
        this.b(bp.i(this.a).getResources().getString(n2));
    }

    @Override
    public void a(i i2) {
        if (this.d == null) {
            return;
        }
        this.d();
        bp.g(this.a).a();
    }

    @Override
    public void a(View view) {
        bp.g(this.a).setCustomView(view);
        this.e = new WeakReference<View>(view);
    }

    @Override
    public void a(CharSequence charSequence) {
        bp.g(this.a).setSubtitle(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        super.a(bl2);
        bp.g(this.a).setTitleOptional(bl2);
    }

    @Override
    public boolean a(i i2, MenuItem menuItem) {
        if (this.d == null) return false;
        return this.d.a((b)this, menuItem);
    }

    @Override
    public Menu b() {
        return this.c;
    }

    @Override
    public void b(int n2) {
        this.a(bp.i(this.a).getResources().getString(n2));
    }

    @Override
    public void b(CharSequence charSequence) {
        bp.g(this.a).setTitle(charSequence);
    }

    @Override
    public void c() {
        if (this.a.a != this) {
            return;
        }
        if (!bp.a(bp.e(this.a), bp.f(this.a), false)) {
            this.a.b = this;
            this.a.c = this.d;
        } else {
            this.d.a(this);
        }
        this.d = null;
        this.a.j(false);
        bp.g(this.a).b();
        bp.h(this.a).a().sendAccessibilityEvent(32);
        bp.d(this.a).setHideOnContentScrollEnabled(this.a.d);
        this.a.a = null;
    }

    @Override
    public void d() {
        if (this.a.a != this) {
            return;
        }
        this.c.g();
        try {
            this.d.b(this, this.c);
            return;
        }
        finally {
            this.c.h();
        }
    }

    public boolean e() {
        this.c.g();
        try {
            boolean bl2 = this.d.a((b)this, this.c);
            return bl2;
        }
        finally {
            this.c.h();
        }
    }

    @Override
    public CharSequence f() {
        return bp.g(this.a).getTitle();
    }

    @Override
    public CharSequence g() {
        return bp.g(this.a).getSubtitle();
    }

    @Override
    public boolean h() {
        return bp.g(this.a).d();
    }

    @Override
    public View i() {
        if (this.e == null) return null;
        return (View)this.e.get();
    }
}

