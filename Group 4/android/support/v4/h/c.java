/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.a;
import android.support.v4.h.a.g;
import android.support.v4.h.b;
import android.support.v4.h.j;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class c
implements j {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    c(b b2, a a2) {
        this.b = b2;
        this.a = a2;
    }

    @Override
    public void a(View view, int n2) {
        this.a.a(view, n2);
    }

    @Override
    public void a(View view, Object object) {
        this.a.a(view, new g(object));
    }

    @Override
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.b(view, accessibilityEvent);
    }

    @Override
    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(viewGroup, view, accessibilityEvent);
    }

    @Override
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.d(view, accessibilityEvent);
    }

    @Override
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    @Override
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.a.a(view, accessibilityEvent);
    }
}

