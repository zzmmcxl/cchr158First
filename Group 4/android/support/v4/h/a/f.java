/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.view.accessibility.AccessibilityEvent;

class f {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void a(AccessibilityEvent accessibilityEvent, int n2) {
        accessibilityEvent.setContentChangeTypes(n2);
    }
}

