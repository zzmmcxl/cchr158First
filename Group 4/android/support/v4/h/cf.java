/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.view.View;

class cf {
    public static void a(View view, Object object) {
        view.setAccessibilityDelegate((View.AccessibilityDelegate)object);
    }

    public static void a(View view, boolean bl2) {
        view.setFitsSystemWindows(bl2);
    }

    public static boolean a(View view, int n2) {
        return view.canScrollHorizontally(n2);
    }

    public static boolean b(View view, int n2) {
        return view.canScrollVertically(n2);
    }
}

