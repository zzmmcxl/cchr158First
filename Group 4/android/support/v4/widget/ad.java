/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.h.a;
import android.support.v4.h.a.aj;
import android.support.v4.h.a.g;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

class ad
extends a {
    ad() {
    }

    @Override
    public void a(View view, g g2) {
        super.a(view, g2);
        NestedScrollView nestedScrollView = (NestedScrollView)view;
        g2.a(ScrollView.class.getName());
        if (!nestedScrollView.isEnabled()) return;
        int n2 = NestedScrollView.a(nestedScrollView);
        if (n2 <= 0) return;
        g2.a(true);
        if (nestedScrollView.getScrollY() > 0) {
            g2.a(8192);
        }
        if (nestedScrollView.getScrollY() >= n2) return;
        g2.a(4096);
    }

    @Override
    public boolean a(View view, int n2, Bundle bundle) {
        if (super.a(view, n2, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView)view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        switch (n2) {
            default: {
                return false;
            }
            case 4096: {
                int n3 = Math.min(nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom() - nestedScrollView.getPaddingTop() + nestedScrollView.getScrollY(), NestedScrollView.a(nestedScrollView));
                if (n3 == nestedScrollView.getScrollY()) return false;
                nestedScrollView.b(0, n3);
                return true;
            }
            case 8192: 
        }
        int n4 = nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom() - nestedScrollView.getPaddingTop();
        int n5 = Math.max(nestedScrollView.getScrollY() - n4, 0);
        if (n5 == nestedScrollView.getScrollY()) return false;
        nestedScrollView.b(0, n5);
        return true;
    }

    @Override
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView)view;
        accessibilityEvent.setClassName((CharSequence)ScrollView.class.getName());
        aj aj2 = android.support.v4.h.a.a.a(accessibilityEvent);
        boolean bl2 = NestedScrollView.a(nestedScrollView) > 0;
        aj2.a(bl2);
        aj2.d(nestedScrollView.getScrollX());
        aj2.e(nestedScrollView.getScrollY());
        aj2.f(nestedScrollView.getScrollX());
        aj2.g(NestedScrollView.a(nestedScrollView));
    }
}

