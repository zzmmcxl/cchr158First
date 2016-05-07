/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Build;
import android.support.design.widget.bu;
import android.support.design.widget.bx;
import android.support.design.widget.co;
import android.support.design.widget.cp;
import android.support.design.widget.cq;
import android.support.design.widget.cr;
import android.view.View;

class cn {
    static final bx a = new co();
    private static final cp b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            b = new cr(null);
            return;
        }
        b = new cq(null);
    }

    static bu a() {
        return a.a();
    }

    static void a(View view) {
        b.a(view);
    }
}

