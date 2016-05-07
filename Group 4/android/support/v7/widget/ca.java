/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.cb;
import android.support.v7.widget.cc;
import android.support.v7.widget.ff;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class ca {
    final cc a;
    final cb b;
    final List c;

    ca(cc cc2) {
        this.a = cc2;
        this.b = new cb();
        this.c = new ArrayList();
    }

    private int e(int n2) {
        if (n2 < 0) {
            return -1;
        }
        int n3 = this.a.a();
        int n4 = n2;
        while (n4 < n3) {
            int n5 = n2 - (n4 - this.b.e(n4));
            if (n5 == 0) {
                while (this.b.c(n4)) {
                    ++n4;
                }
                return n4;
            }
            n4 += n5;
        }
        return -1;
    }

    private void g(View view) {
        this.c.add(view);
        this.a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove((Object)view)) return false;
        this.a.d(view);
        return true;
    }

    View a(int n2, int n3) {
        int n4 = this.c.size();
        int n5 = 0;
        while (n5 < n4) {
            View view = (View)this.c.get(n5);
            ff ff2 = this.a.b(view);
            if (ff2.d() == n2 && !ff2.n() && !ff2.q()) {
                if (n3 == -1) return view;
                if (ff2.h() == n3) {
                    return view;
                }
            }
            ++n5;
        }
        return null;
    }

    void a() {
        this.b.a();
        int n2 = -1 + this.c.size();
        do {
            if (n2 < 0) {
                this.a.b();
                return;
            }
            this.a.d((View)this.c.get(n2));
            this.c.remove(n2);
            --n2;
        } while (true);
    }

    void a(int n2) {
        int n3 = this.e(n2);
        View view = this.a.b(n3);
        if (view == null) {
            return;
        }
        if (this.b.d(n3)) {
            this.h(view);
        }
        this.a.a(n3);
    }

    void a(View view) {
        int n2 = this.a.a(view);
        if (n2 < 0) {
            return;
        }
        if (this.b.d(n2)) {
            this.h(view);
        }
        this.a.a(n2);
    }

    void a(View view, int n2, ViewGroup.LayoutParams layoutParams, boolean bl2) {
        int n3 = n2 < 0 ? this.a.a() : this.e(n2);
        this.b.a(n3, bl2);
        if (bl2) {
            this.g(view);
        }
        this.a.a(view, n3, layoutParams);
    }

    void a(View view, int n2, boolean bl2) {
        int n3 = n2 < 0 ? this.a.a() : this.e(n2);
        this.b.a(n3, bl2);
        if (bl2) {
            this.g(view);
        }
        this.a.a(view, n3);
    }

    void a(View view, boolean bl2) {
        this.a(view, -1, bl2);
    }

    int b() {
        return this.a.a() - this.c.size();
    }

    int b(View view) {
        int n2 = this.a.a(view);
        if (n2 == -1) {
            return -1;
        }
        if (this.b.c(n2)) return -1;
        return n2 - this.b.e(n2);
    }

    View b(int n2) {
        int n3 = this.e(n2);
        return this.a.b(n3);
    }

    int c() {
        return this.a.a();
    }

    View c(int n2) {
        return this.a.b(n2);
    }

    boolean c(View view) {
        return this.c.contains((Object)view);
    }

    void d(int n2) {
        int n3 = this.e(n2);
        this.b.d(n3);
        this.a.c(n3);
    }

    void d(View view) {
        int n2 = this.a.a(view);
        if (n2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + (Object)view);
        }
        this.b.a(n2);
        this.g(view);
    }

    void e(View view) {
        int n2 = this.a.a(view);
        if (n2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + (Object)view);
        }
        if (!this.b.c(n2)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + (Object)view);
        }
        this.b.b(n2);
        this.h(view);
    }

    boolean f(View view) {
        int n2 = this.a.a(view);
        if (n2 == -1) {
            if (!this.h(view)) return true;
            return true;
        }
        if (!this.b.c(n2)) return false;
        this.b.d(n2);
        if (!this.h(view)) {
            // empty if block
        }
        this.a.a(n2);
        return true;
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}

