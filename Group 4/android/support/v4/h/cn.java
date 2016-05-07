/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.co;
import android.support.v4.h.cp;
import android.support.v4.h.cq;
import android.support.v4.h.cr;
import android.support.v4.h.cs;
import android.view.ViewConfiguration;

public final class cn {
    static final cs a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            a = new cr();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            a = new cq();
            return;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            a = new cp();
            return;
        }
        a = new co();
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}

