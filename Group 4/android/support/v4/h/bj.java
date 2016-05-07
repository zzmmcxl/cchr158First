/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.bk;
import android.support.v4.h.bl;
import android.support.v4.h.bm;
import android.view.VelocityTracker;

public final class bj {
    static final bm a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new bl();
            return;
        }
        a = new bk();
    }

    public static float a(VelocityTracker velocityTracker, int n2) {
        return a.a(velocityTracker, n2);
    }

    public static float b(VelocityTracker velocityTracker, int n2) {
        return a.b(velocityTracker, n2);
    }
}

