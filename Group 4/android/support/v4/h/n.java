/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.Context;
import android.support.v4.h.o;
import android.support.v4.h.p;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class n {
    private final Context a;
    private o b;
    private p c;

    public n(Context context) {
        this.a = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return this.a();
    }

    public void a(o o2) {
        this.b = o2;
    }

    public void a(p p2) {
        if (this.c != null && p2 != null) {
            Log.w((String)"ActionProvider(support)", (String)("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?"));
        }
        this.c = p2;
    }

    public void a(SubMenu subMenu) {
    }

    public void a(boolean bl2) {
        if (this.b == null) return;
        this.b.a(bl2);
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.c = null;
        this.b = null;
    }
}

