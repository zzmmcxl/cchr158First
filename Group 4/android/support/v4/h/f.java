/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Bundle;
import android.support.v4.h.a;
import android.support.v4.h.a.g;
import android.support.v4.h.a.w;
import android.support.v4.h.e;
import android.support.v4.h.m;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class f
implements m {
    final /* synthetic */ a a;
    final /* synthetic */ e b;

    f(e e2, a a2) {
        this.b = e2;
        this.a = a2;
    }

    @Override
    public Object a(View view) {
        w w2 = this.a.a(view);
        if (w2 == null) return null;
        return w2.a();
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
    public boolean a(View view, int n2, Bundle bundle) {
        return this.a.a(view, n2, bundle);
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

