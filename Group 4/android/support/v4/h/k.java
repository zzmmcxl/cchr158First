/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Bundle;
import android.support.v4.h.l;
import android.support.v4.h.m;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

class k {
    public static Object a(m m2) {
        return new l(m2);
    }

    public static Object a(Object object, View view) {
        return ((View.AccessibilityDelegate)object).getAccessibilityNodeProvider(view);
    }

    public static boolean a(Object object, View view, int n2, Bundle bundle) {
        return ((View.AccessibilityDelegate)object).performAccessibilityAction(view, n2, bundle);
    }
}

