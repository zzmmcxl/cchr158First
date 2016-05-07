/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.h.bo;
import android.view.View;

class bs
implements Runnable {
    final /* synthetic */ SwipeDismissBehavior a;
    private final View b;
    private final boolean c;

    bs(SwipeDismissBehavior swipeDismissBehavior, View view, boolean bl2) {
        this.a = swipeDismissBehavior;
        this.b = view;
        this.c = bl2;
    }

    @Override
    public void run() {
        if (SwipeDismissBehavior.b(this.a) != null && SwipeDismissBehavior.b(this.a).a(true)) {
            bo.a(this.b, this);
            return;
        }
        if (!this.c) return;
        if (SwipeDismissBehavior.a(this.a) == null) return;
        SwipeDismissBehavior.a(this.a).a(this.b);
    }
}

