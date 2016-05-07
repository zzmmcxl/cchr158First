/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.h.bo;
import android.view.View;

class l
implements Runnable {
    final /* synthetic */ BottomSheetBehavior a;
    private final View b;
    private final int c;

    l(BottomSheetBehavior bottomSheetBehavior, View view, int n2) {
        this.a = bottomSheetBehavior;
        this.b = view;
        this.c = n2;
    }

    @Override
    public void run() {
        if (BottomSheetBehavior.j(this.a) != null && BottomSheetBehavior.j(this.a).a(true)) {
            bo.a(this.b, this);
            return;
        }
        BottomSheetBehavior.b(this.a, this.c);
    }
}

