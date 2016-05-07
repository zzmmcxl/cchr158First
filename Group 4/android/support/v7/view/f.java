/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class f
extends b
implements j {
    private Context a;
    private ActionBarContextView b;
    private c c;
    private WeakReference d;
    private boolean e;
    private boolean f;
    private i g;

    public f(Context context, ActionBarContextView actionBarContextView, c c2, boolean bl2) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = c2;
        this.g = new i(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f = bl2;
    }

    @Override
    public MenuInflater a() {
        return new MenuInflater(this.b.getContext());
    }

    @Override
    public void a(int n2) {
        this.b(this.a.getString(n2));
    }

    @Override
    public void a(i i2) {
        this.d();
        this.b.a();
    }

    @Override
    public void a(View view) {
        this.b.setCustomView(view);
        WeakReference<View> weakReference = view != null ? new WeakReference<View>(view) : null;
        this.d = weakReference;
    }

    @Override
    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    @Override
    public void a(boolean bl2) {
        super.a(bl2);
        this.b.setTitleOptional(bl2);
    }

    @Override
    public boolean a(i i2, MenuItem menuItem) {
        return this.c.a((b)this, menuItem);
    }

    @Override
    public Menu b() {
        return this.g;
    }

    @Override
    public void b(int n2) {
        this.a(this.a.getString(n2));
    }

    @Override
    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    @Override
    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.sendAccessibilityEvent(32);
        this.c.a(this);
    }

    @Override
    public void d() {
        this.c.b(this, this.g);
    }

    @Override
    public CharSequence f() {
        return this.b.getTitle();
    }

    @Override
    public CharSequence g() {
        return this.b.getSubtitle();
    }

    @Override
    public boolean h() {
        return this.b.d();
    }

    @Override
    public View i() {
        if (this.d == null) return null;
        return (View)this.d.get();
    }
}

