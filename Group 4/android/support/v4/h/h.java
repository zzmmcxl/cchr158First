/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.i;
import android.support.v4.h.j;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class h {
    public static Object a() {
        return new View.AccessibilityDelegate();
    }

    public static Object a(j j2) {
        return new i(j2);
    }

    public static void a(Object object, View view, int n2) {
        ((View.AccessibilityDelegate)object).sendAccessibilityEvent(view, n2);
    }

    public static void a(Object object, View view, Object object2) {
        ((View.AccessibilityDelegate)object).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)object2);
    }

    public static boolean a(Object object, View view, AccessibilityEvent accessibilityEvent) {
        return ((View.AccessibilityDelegate)object).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean a(Object object, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((View.AccessibilityDelegate)object).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void b(Object object, View view, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate)object).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void c(Object object, View view, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate)object).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void d(Object object, View view, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate)object).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}

