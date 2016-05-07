/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.at;
import android.support.design.widget.l;
import android.support.v4.h.bo;
import android.support.v4.widget.bm;
import android.view.View;

class i
extends bm {
    final /* synthetic */ BottomSheetBehavior a;

    i(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override
    public int a(View view) {
        if (!BottomSheetBehavior.g(this.a)) return BottomSheetBehavior.i(this.a) - BottomSheetBehavior.f(this.a);
        return BottomSheetBehavior.h(this.a) - BottomSheetBehavior.f(this.a);
    }

    @Override
    public int a(View view, int n2, int n3) {
        int n4;
        int n5 = BottomSheetBehavior.f(this.a);
        if (BottomSheetBehavior.g(this.a)) {
            n4 = BottomSheetBehavior.h(this.a);
            return at.a(n2, n5, n4);
        }
        n4 = BottomSheetBehavior.i(this.a);
        return at.a(n2, n5, n4);
    }

    @Override
    public void a(int n2) {
        if (n2 != 1) return;
        BottomSheetBehavior.b(this.a, 1);
    }

    @Override
    public void a(View view, float f2, float f3) {
        int n2;
        int n3 = 3;
        if (f3 < 0.0f) {
            n2 = BottomSheetBehavior.f(this.a);
        } else if (BottomSheetBehavior.g(this.a) && BottomSheetBehavior.a(this.a, view, f3)) {
            n2 = BottomSheetBehavior.h(this.a);
            n3 = 5;
        } else if (f3 == 0.0f) {
            int n4 = view.getTop();
            if (Math.abs(n4 - BottomSheetBehavior.f(this.a)) < Math.abs(n4 - BottomSheetBehavior.i(this.a))) {
                n2 = BottomSheetBehavior.f(this.a);
            } else {
                n2 = BottomSheetBehavior.i(this.a);
                n3 = 4;
            }
        } else {
            n2 = BottomSheetBehavior.i(this.a);
            n3 = 4;
        }
        if (BottomSheetBehavior.j(this.a).a(view.getLeft(), n2)) {
            BottomSheetBehavior.b(this.a, 2);
            bo.a(view, new l(this.a, view, n3));
            return;
        }
        BottomSheetBehavior.b(this.a, n3);
    }

    @Override
    public void a(View view, int n2, int n3, int n4, int n5) {
        BottomSheetBehavior.a(this.a, n3);
    }

    @Override
    public boolean a(View view, int n2) {
        View view2;
        if (BottomSheetBehavior.a(this.a) == 1) {
            return false;
        }
        if (BottomSheetBehavior.b(this.a)) return false;
        if (BottomSheetBehavior.a(this.a) == 3 && BottomSheetBehavior.c(this.a) == n2 && (view2 = (View)BottomSheetBehavior.d(this.a).get()) != null) {
            if (bo.b(view2, -1)) return false;
        }
        if (BottomSheetBehavior.e(this.a) == null) return false;
        if (BottomSheetBehavior.e(this.a).get() != view) return false;
        return true;
    }

    @Override
    public int b(View view, int n2, int n3) {
        return view.getLeft();
    }
}

