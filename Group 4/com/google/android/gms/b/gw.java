/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.fi;

@fi
public final class gw {
    private Activity a;
    private boolean b;
    private boolean c;
    private boolean d;
    private ViewTreeObserver.OnGlobalLayoutListener e;
    private ViewTreeObserver.OnScrollChangedListener f;

    public gw(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.a = activity;
        this.e = onGlobalLayoutListener;
        this.f = onScrollChangedListener;
    }

    private void e() {
        if (this.a == null) {
            return;
        }
        if (this.b) return;
        if (this.e != null) {
            g.c().a(this.a, this.e);
        }
        if (this.f != null) {
            g.c().a(this.a, this.f);
        }
        this.b = true;
    }

    private void f() {
        if (this.a == null) {
            return;
        }
        if (!this.b) return;
        if (this.e != null) {
            g.e().a(this.a, this.e);
        }
        if (this.f != null) {
            g.c().b(this.a, this.f);
        }
        this.b = false;
    }

    public void a() {
        this.d = true;
        if (!this.c) return;
        this.e();
    }

    public void a(Activity activity) {
        this.a = activity;
    }

    public void b() {
        this.d = false;
        this.f();
    }

    public void c() {
        this.c = true;
        if (!this.d) return;
        this.e();
    }

    public void d() {
        this.c = false;
        this.f();
    }
}

