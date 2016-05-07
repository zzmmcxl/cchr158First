/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.e.i;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.eg;
import android.support.v7.widget.eh;
import android.support.v7.widget.ff;
import android.view.ViewGroup;
import java.util.List;

public abstract class ef {
    private final eg a;
    private boolean b;

    public abstract int a();

    public int a(int n2) {
        return 0;
    }

    public abstract ff a(ViewGroup var1, int var2);

    public void a(RecyclerView recyclerView) {
    }

    public void a(eh eh2) {
        this.a.registerObserver((Object)eh2);
    }

    public void a(ff ff2) {
    }

    public abstract void a(ff var1, int var2);

    public void a(ff ff2, int n2, List list) {
        this.a(ff2, n2);
    }

    public long b(int n2) {
        return -1;
    }

    public final ff b(ViewGroup viewGroup, int n2) {
        i.a("RV CreateView");
        ff ff2 = this.a(viewGroup, n2);
        ff2.e = n2;
        i.a();
        return ff2;
    }

    public void b(RecyclerView recyclerView) {
    }

    public void b(eh eh2) {
        this.a.unregisterObserver((Object)eh2);
    }

    public final void b(ff ff2, int n2) {
        ff2.b = n2;
        if (this.b()) {
            ff2.d = this.b(n2);
        }
        ff2.a(1, 519);
        i.a("RV OnBindView");
        this.a(ff2, n2, ff2.u());
        ff2.t();
        i.a();
    }

    public final boolean b() {
        return this.b;
    }

    public boolean b(ff ff2) {
        return false;
    }

    public void c(ff ff2) {
    }

    public void d(ff ff2) {
    }
}

