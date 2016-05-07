/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.graphics.Rect;
import android.support.v4.h.r;
import android.view.Gravity;

class s
implements r {
    s() {
    }

    @Override
    public int a(int n2, int n3) {
        return -8388609 & n2;
    }

    @Override
    public void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
        Gravity.apply((int)n2, (int)n3, (int)n4, (Rect)rect, (Rect)rect2);
    }
}

