/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.a;
import android.support.v4.h.a.g;
import android.support.v4.h.c;
import android.support.v4.h.h;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class b
extends android.support.v4.h.g {
    b() {
    }

    @Override
    public Object a() {
        return h.a();
    }

    @Override
    public Object a(a a2) {
        return h.a(new c(this, a2));
    }

    @Override
    public void a(Object object, View view, int n2) {
        h.a(object, view, n2);
    }

    @Override
    public void a(Object object, View view, g g2) {
        h.a(object, view, g2.a());
    }

    @Override
    public boolean a(Object object, View view, AccessibilityEvent accessibilityEvent) {
        return h.a(object, view, accessibilityEvent);
    }

    @Override
    public boolean a(Object object, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return h.a(object, viewGroup, view, accessibilityEvent);
    }

    @Override
    public void b(Object object, View view, AccessibilityEvent accessibilityEvent) {
        h.b(object, view, accessibilityEvent);
    }

    @Override
    public void c(Object object, View view, AccessibilityEvent accessibilityEvent) {
        h.c(object, view, accessibilityEvent);
    }

    @Override
    public void d(Object object, View view, AccessibilityEvent accessibilityEvent) {
        h.d(object, view, accessibilityEvent);
    }
}

