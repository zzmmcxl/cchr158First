/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.graphics.Rect;
import android.view.Gravity;

class u {
    public static int a(int n2, int n3) {
        return Gravity.getAbsoluteGravity((int)n2, (int)n3);
    }

    public static void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
        Gravity.apply((int)n2, (int)n3, (int)n4, (Rect)rect, (Rect)rect2, (int)n5);
    }
}

