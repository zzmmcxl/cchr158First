/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.cg;
import android.support.design.widget.ch;
import android.support.design.widget.ci;
import android.support.design.widget.cj;
import android.view.View;
import android.view.ViewGroup;

class cf {
    private static final ch a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new cj(null);
            return;
        }
        a = new ci(null);
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        a.a(viewGroup, view, rect);
    }

    static void b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        cf.a(viewGroup, view, rect);
    }
}

