/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.view.View;

class cj {
    public static void a(View view, int n2) {
        view.setAccessibilityLiveRegion(n2);
    }

    public static boolean a(View view) {
        return view.isLaidOut();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }
}

