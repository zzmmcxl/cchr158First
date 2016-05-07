/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.b.b;
import android.support.v7.b.i;
import android.support.v7.b.k;
import android.support.v7.b.l;
import android.support.v7.view.e;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.support.v7.view.menu.z;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

final class aq {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    android.support.v7.view.menu.i j;
    g k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;

    aq(int n2) {
        this.a = n2;
        this.q = false;
    }

    z a(y y2) {
        if (this.j == null) {
            return null;
        }
        if (this.k != null) return this.k.a(this.g);
        this.k = new g(this.l, i.abc_list_menu_item_layout);
        this.k.a(y2);
        this.j.a(this.k);
        return this.k.a(this.g);
    }

    void a(Context context) {
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
        e e2 = new e(context, 0);
        e2.getTheme().setTo(theme);
        this.l = e2;
        TypedArray typedArray = e2.obtainStyledAttributes(l.AppCompatTheme);
        this.b = typedArray.getResourceId(l.AppCompatTheme_panelBackground, 0);
        this.f = typedArray.getResourceId(l.AppCompatTheme_android_windowAnimationStyle, 0);
        typedArray.recycle();
    }

    void a(android.support.v7.view.menu.i i2) {
        if (i2 == this.j) {
            return;
        }
        if (this.j != null) {
            this.j.b(this.k);
        }
        this.j = i2;
        if (i2 == null) return;
        if (this.k == null) return;
        i2.a(this.k);
    }

    public boolean a() {
        boolean bl2 = true;
        if (this.h == null) {
            return false;
        }
        if (this.i != null) return bl2;
        if (this.k.a().getCount() > 0) return bl2;
        return false;
    }
}

