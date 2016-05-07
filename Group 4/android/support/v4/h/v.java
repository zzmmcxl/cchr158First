/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.af;
import android.support.v4.h.w;
import android.support.v4.h.x;
import android.support.v4.h.y;
import android.support.v4.h.z;
import android.view.LayoutInflater;

public final class v {
    static final w a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 21) {
            a = new z();
            return;
        }
        if (n2 >= 11) {
            a = new y();
            return;
        }
        a = new x();
    }

    public static af a(LayoutInflater layoutInflater) {
        return a.a(layoutInflater);
    }

    public static void a(LayoutInflater layoutInflater, af af2) {
        a.a(layoutInflater, af2);
    }
}

