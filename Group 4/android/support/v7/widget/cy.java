/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ew;
import android.support.v7.widget.fc;
import android.view.View;

class cy {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    cy() {
    }

    View a(ew ew2) {
        View view = ew2.c(this.c);
        this.c += this.d;
        return view;
    }

    boolean a(fc fc2) {
        if (this.c < 0) return false;
        if (this.c >= fc2.e()) return false;
        return true;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}

