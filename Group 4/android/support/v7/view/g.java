/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.d.a.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(value=11)
public class g
extends ActionMode {
    final Context a;
    final b b;

    public g(Context context, b b2) {
        this.a = context;
        this.b = b2;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.i();
    }

    public Menu getMenu() {
        return ab.a(this.a, (a)this.b.b());
    }

    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.j();
    }

    public CharSequence getTitle() {
        return this.b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    public void invalidate() {
        this.b.d();
    }

    public boolean isTitleOptional() {
        return this.b.h();
    }

    public void setCustomView(View view) {
        this.b.a(view);
    }

    public void setSubtitle(int n2) {
        this.b.b(n2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    public void setTag(Object object) {
        this.b.a(object);
    }

    public void setTitle(int n2) {
        this.b.a(n2);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean bl2) {
        this.b.a(bl2);
    }
}

