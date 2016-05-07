/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.v;
import android.support.v7.a.w;
import android.support.v7.a.y;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

abstract class x
extends w {
    final Context a;
    final Window b;
    final Window.Callback c;
    final Window.Callback d;
    final v e;
    a f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence m;
    private boolean n;

    x(Context context, Window window, v v2) {
        this.a = context;
        this.b = window;
        this.e = v2;
        this.c = this.b.getCallback();
        if (this.c instanceof y) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = this.a(this.c);
        this.b.setCallback(this.d);
    }

    @Override
    public a a() {
        this.j();
        return this.f;
    }

    abstract b a(c var1);

    Window.Callback a(Window.Callback callback) {
        return new y(this, callback);
    }

    abstract void a(int var1, Menu var2);

    @Override
    public final void a(CharSequence charSequence) {
        this.m = charSequence;
        this.b(charSequence);
    }

    abstract boolean a(int var1, KeyEvent var2);

    abstract boolean a(KeyEvent var1);

    @Override
    public MenuInflater b() {
        if (this.g != null) return this.g;
        this.j();
        Context context = this.f != null ? this.f.c() : this.a;
        this.g = new i(context);
        return this.g;
    }

    abstract void b(CharSequence var1);

    abstract boolean b(int var1, Menu var2);

    @Override
    public void c(Bundle bundle) {
    }

    @Override
    public void f() {
        this.n = true;
    }

    @Override
    public boolean h() {
        return false;
    }

    abstract void j();

    final a k() {
        return this.f;
    }

    final Context l() {
        a a2 = this.a();
        Context context = null;
        if (a2 == null) return this.a;
        context = a2.c();
        if (context != null) return context;
        return this.a;
    }

    public boolean m() {
        return false;
    }

    final boolean n() {
        return this.n;
    }

    final Window.Callback o() {
        return this.b.getCallback();
    }

    final CharSequence p() {
        if (!(this.c instanceof Activity)) return this.m;
        return ((Activity)this.c).getTitle();
    }
}

