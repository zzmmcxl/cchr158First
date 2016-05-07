/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Interpolator;

public class fb {
    private int a;
    private int b;
    private int c;
    private int d;
    private Interpolator e;
    private boolean f;
    private int g;

    private void a(RecyclerView recyclerView) {
        if (this.d >= 0) {
            int n2 = this.d;
            this.d = -1;
            RecyclerView.c(recyclerView, n2);
            this.f = false;
            return;
        }
        if (!this.f) {
            this.g = 0;
            return;
        }
        this.b();
        if (this.e == null) {
            if (this.c == Integer.MIN_VALUE) {
                RecyclerView.p(recyclerView).b(this.a, this.b);
            } else {
                RecyclerView.p(recyclerView).a(this.a, this.b, this.c);
            }
        } else {
            RecyclerView.p(recyclerView).a(this.a, this.b, this.c, this.e);
        }
        this.g = 1 + this.g;
        if (this.g > 10) {
            Log.e((String)"RecyclerView", (String)"Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f = false;
    }

    static /* synthetic */ void a(fb fb2, RecyclerView recyclerView) {
        fb2.a(recyclerView);
    }

    private void b() {
        if (this.e != null && this.c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.c >= 1) return;
        throw new IllegalStateException("Scroll duration must be a positive number");
    }

    boolean a() {
        if (this.d < 0) return false;
        return true;
    }
}

