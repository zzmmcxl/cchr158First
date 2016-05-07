/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.view.MotionEvent;

class az {
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int a(MotionEvent motionEvent, int n2) {
        return motionEvent.findPointerIndex(n2);
    }

    public static int b(MotionEvent motionEvent, int n2) {
        return motionEvent.getPointerId(n2);
    }

    public static float c(MotionEvent motionEvent, int n2) {
        return motionEvent.getX(n2);
    }

    public static float d(MotionEvent motionEvent, int n2) {
        return motionEvent.getY(n2);
    }
}

