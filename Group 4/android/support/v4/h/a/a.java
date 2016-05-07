/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.os.Build;
import android.support.v4.h.a.aj;
import android.support.v4.h.a.b;
import android.support.v4.h.a.c;
import android.support.v4.h.a.d;
import android.support.v4.h.a.e;
import android.view.accessibility.AccessibilityEvent;

public final class a {
    private static final e a;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new c();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a = new b();
            return;
        }
        a = new d();
    }

    public static aj a(AccessibilityEvent accessibilityEvent) {
        return new aj((Object)accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int n2) {
        a.a(accessibilityEvent, n2);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }
}

