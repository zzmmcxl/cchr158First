/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public abstract class b {
    private Object a;
    private boolean b;

    public abstract MenuInflater a();

    public abstract void a(int var1);

    public abstract void a(View var1);

    public abstract void a(CharSequence var1);

    public void a(Object object) {
        this.a = object;
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public abstract Menu b();

    public abstract void b(int var1);

    public abstract void b(CharSequence var1);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return false;
    }

    public abstract View i();

    public Object j() {
        return this.a;
    }

    public boolean k() {
        return this.b;
    }
}

