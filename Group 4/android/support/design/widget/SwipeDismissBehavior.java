/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.bq;
import android.support.design.widget.br;
import android.support.design.widget.q;
import android.support.v4.h.at;
import android.support.v4.widget.bj;
import android.support.v4.widget.bm;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior
extends q {
    private bj a;
    private br b;
    private boolean c;
    private float d = 0.0f;
    private boolean e;
    private int f = 2;
    private float g = 0.5f;
    private float h = 0.0f;
    private float i = 0.5f;
    private final bm j;

    public SwipeDismissBehavior() {
        this.j = new bq(this);
    }

    static float a(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    static /* synthetic */ int a(int n2, int n3, int n4) {
        return SwipeDismissBehavior.b(n2, n3, n4);
    }

    static /* synthetic */ br a(SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.b;
    }

    private void a(ViewGroup viewGroup) {
        if (this.a != null) return;
        bj bj2 = this.e ? bj.a(viewGroup, this.d, this.j) : bj.a(viewGroup, this.j);
        this.a = bj2;
    }

    static /* synthetic */ float b(float f2, float f3, float f4) {
        return SwipeDismissBehavior.c(f2, f3, f4);
    }

    private static int b(int n2, int n3, int n4) {
        return Math.min(Math.max(n2, n3), n4);
    }

    static /* synthetic */ bj b(SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.a;
    }

    private static float c(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static /* synthetic */ int c(SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.f;
    }

    static /* synthetic */ float d(SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.g;
    }

    static /* synthetic */ float e(SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.h;
    }

    static /* synthetic */ float f(SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.i;
    }

    public void a(float f2) {
        this.h = SwipeDismissBehavior.c(0.0f, f2, 1.0f);
    }

    public void a(int n2) {
        this.f = n2;
    }

    public void a(br br2) {
        this.b = br2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean a(CoordinatorLayout var1_1, View var2_2, MotionEvent var3_3) {
        switch (at.a(var3_3)) {
            default: {
                var4_4 = var1_1.a(var2_2, (int)var3_3.getX(), (int)var3_3.getY()) == false;
            }
            case 1: 
            case 3: {
                if (this.c) {
                    this.c = false;
                    return false;
                }
                ** GOTO lbl10
            }
        }
        this.c = var4_4;
lbl10: // 2 sources:
        if (this.c) {
            return false;
        }
        this.a(var1_1);
        return this.a.a(var3_3);
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.i = SwipeDismissBehavior.c(0.0f, f2, 1.0f);
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.a == null) return false;
        this.a.b(motionEvent);
        return true;
    }
}

