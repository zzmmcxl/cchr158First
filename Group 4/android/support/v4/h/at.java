/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.au;
import android.support.v4.h.av;
import android.support.v4.h.aw;
import android.support.v4.h.ax;
import android.support.v4.h.ay;
import android.view.MotionEvent;

public final class at {
    static final ay a;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            a = new ax();
            return;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            a = new aw();
            return;
        }
        if (Build.VERSION.SDK_INT >= 5) {
            a = new av();
            return;
        }
        a = new au();
    }

    public static int a(MotionEvent motionEvent) {
        return 255 & motionEvent.getAction();
    }

    public static int a(MotionEvent motionEvent, int n2) {
        return a.a(motionEvent, n2);
    }

    public static int b(MotionEvent motionEvent) {
        return (65280 & motionEvent.getAction()) >> 8;
    }

    public static int b(MotionEvent motionEvent, int n2) {
        return a.b(motionEvent, n2);
    }

    public static float c(MotionEvent motionEvent, int n2) {
        return a.c(motionEvent, n2);
    }

    public static int c(MotionEvent motionEvent) {
        return a.a(motionEvent);
    }

    public static float d(MotionEvent motionEvent, int n2) {
        return a.d(motionEvent, n2);
    }

    public static int d(MotionEvent motionEvent) {
        return a.b(motionEvent);
    }

    public static float e(MotionEvent motionEvent, int n2) {
        return a.e(motionEvent, n2);
    }
}

