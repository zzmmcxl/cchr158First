/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.bf;
import android.support.v4.app.dh;
import android.support.v4.app.di;
import android.support.v7.a.a;
import android.support.v7.a.v;
import android.support.v7.a.w;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.gj;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class u
extends aa
implements di,
v {
    private w m;
    private int n = 0;
    private boolean o;
    private Resources p;

    @Override
    public Intent a() {
        return bf.a(this);
    }

    @Override
    public b a(c c2) {
        return null;
    }

    public void a(dh dh2) {
        dh2.a(this);
    }

    @Override
    public void a(b b2) {
    }

    public void a(Toolbar toolbar) {
        this.k().a(toolbar);
    }

    public boolean a(Intent intent) {
        return bf.a(this, intent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.k().b(view, layoutParams);
    }

    public void b(Intent intent) {
        bf.b(this, intent);
    }

    public void b(dh dh2) {
    }

    @Override
    public void b(b b2) {
    }

    @Override
    public void d() {
        this.k().e();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 19) return super.dispatchKeyEvent(keyEvent);
        int n2 = keyEvent.getAction();
        if (n2 == 0) {
            if (!keyEvent.hasModifiers(2)) return super.dispatchKeyEvent(keyEvent);
            a a2 = this.h();
            if (a2 == null) return super.dispatchKeyEvent(keyEvent);
            if (!a2.b()) return super.dispatchKeyEvent(keyEvent);
            if (!a2.g()) return super.dispatchKeyEvent(keyEvent);
            this.o = true;
            return true;
        }
        if (n2 != 1) return super.dispatchKeyEvent(keyEvent);
        if (!this.o) return super.dispatchKeyEvent(keyEvent);
        this.o = false;
        return true;
    }

    public MenuInflater getMenuInflater() {
        return this.k().b();
    }

    public Resources getResources() {
        if (this.p != null) return this.p;
        this.p = new gj((Context)this, super.getResources());
        return this.p;
    }

    public a h() {
        return this.k().a();
    }

    public boolean i() {
        Intent intent = this.a();
        if (intent == null) return false;
        if (!this.a(intent)) {
            this.b(intent);
            return true;
        }
        dh dh2 = dh.a((Context)this);
        this.a(dh2);
        this.b(dh2);
        dh2.a();
        try {
            android.support.v4.app.a.a(this);
            return true;
        }
        catch (IllegalStateException var3_3) {
            this.finish();
            return true;
        }
    }

    public void invalidateOptionsMenu() {
        this.k().e();
    }

    @Deprecated
    public void j() {
    }

    public w k() {
        if (this.m != null) return this.m;
        this.m = w.a(this, (v)this);
        return this.m;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k().a(configuration);
    }

    public void onContentChanged() {
        this.j();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        w w2 = this.k();
        w2.g();
        w2.a(bundle);
        if (w2.h() && this.n != 0) {
            this.setTheme(this.n);
        }
        super.onCreate(bundle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.k().f();
    }

    @Override
    public final boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        if (super.onMenuItemSelected(n2, menuItem)) {
            return true;
        }
        a a2 = this.h();
        if (menuItem.getItemId() != 16908332) return false;
        if (a2 == null) return false;
        if ((4 & a2.a()) == 0) return false;
        return this.i();
    }

    public boolean onMenuOpened(int n2, Menu menu) {
        return super.onMenuOpened(n2, menu);
    }

    @Override
    public void onPanelClosed(int n2, Menu menu) {
        super.onPanelClosed(n2, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.k().b(bundle);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        this.k().d();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.k().c(bundle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.k().c();
    }

    protected void onTitleChanged(CharSequence charSequence, int n2) {
        super.onTitleChanged(charSequence, n2);
        this.k().a(charSequence);
    }

    public void setContentView(int n2) {
        this.k().a(n2);
    }

    public void setContentView(View view) {
        this.k().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.k().a(view, layoutParams);
    }

    public void setTheme(int n2) {
        super.setTheme(n2);
        this.n = n2;
    }
}

