/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ep;
import android.support.v7.widget.fb;
import android.support.v7.widget.fc;
import android.util.Log;
import android.view.View;

public abstract class fa {
    private int a;
    private RecyclerView b;
    private ep c;
    private boolean d;
    private boolean e;
    private View f;
    private final fb g;

    private void a(int n2, int n3) {
        RecyclerView recyclerView = this.b;
        if (!this.e || this.a == -1 || recyclerView == null) {
            this.a();
        }
        this.d = false;
        if (this.f != null) {
            if (this.a(this.f) == this.a) {
                this.a(this.f, recyclerView.g, this.g);
                fb.a(this.g, recyclerView);
                this.a();
            } else {
                Log.e((String)"RecyclerView", (String)"Passed over target position while smooth scrolling.");
                this.f = null;
            }
        }
        if (!this.e) return;
        this.a(n2, n3, recyclerView.g, this.g);
        boolean bl2 = this.g.a();
        fb.a(this.g, recyclerView);
        if (!bl2) return;
        if (this.e) {
            this.d = true;
            RecyclerView.p(recyclerView).a();
            return;
        }
        this.a();
    }

    static /* synthetic */ void a(fa fa2, int n2, int n3) {
        fa2.a(n2, n3);
    }

    public int a(View view) {
        return this.b.d(view);
    }

    protected final void a() {
        if (!this.e) {
            return;
        }
        this.e();
        fc.e(this.b.g, -1);
        this.f = null;
        this.a = -1;
        this.d = false;
        this.e = false;
        ep.a(this.c, this);
        this.c = null;
        this.b = null;
    }

    public void a(int n2) {
        this.a = n2;
    }

    protected abstract void a(int var1, int var2, fc var3, fb var4);

    protected abstract void a(View var1, fc var2, fb var3);

    protected void b(View view) {
        if (this.a(view) != this.d()) return;
        this.f = view;
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public int d() {
        return this.a;
    }

    protected abstract void e();
}

