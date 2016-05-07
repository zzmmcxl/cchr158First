/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.h.a.g;
import android.support.v4.h.a.w;
import android.support.v4.h.b;
import android.support.v4.h.d;
import android.support.v4.h.e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class a {
    private static final d b = Build.VERSION.SDK_INT >= 16 ? new e() : (Build.VERSION.SDK_INT >= 14 ? new b() : new android.support.v4.h.g());
    private static final Object c = b.a();
    final Object a;

    public a() {
        this.a = b.a(this);
    }

    public w a(View view) {
        return b.a(c, view);
    }

    Object a() {
        return this.a;
    }

    public void a(View view, int n2) {
        b.a(c, view, n2);
    }

    public void a(View view, g g2) {
        b.a(c, view, g2);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        b.d(c, view, accessibilityEvent);
    }

    public boolean a(View view, int n2, Bundle bundle) {
        return b.a(c, view, n2, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        b.c(c, view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.b(c, view, accessibilityEvent);
    }
}

