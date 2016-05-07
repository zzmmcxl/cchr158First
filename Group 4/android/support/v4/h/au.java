/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.ay;
import android.view.MotionEvent;

class au
implements ay {
    au() {
    }

    @Override
    public int a(MotionEvent motionEvent) {
        return 1;
    }

    @Override
    public int a(MotionEvent motionEvent, int n2) {
        if (n2 != 0) return -1;
        return 0;
    }

    @Override
    public int b(MotionEvent motionEvent) {
        return 0;
    }

    @Override
    public int b(MotionEvent motionEvent, int n2) {
        if (n2 != 0) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        return 0;
    }

    @Override
    public float c(MotionEvent motionEvent, int n2) {
        if (n2 != 0) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        return motionEvent.getX();
    }

    @Override
    public float d(MotionEvent motionEvent, int n2) {
        if (n2 != 0) throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        return motionEvent.getY();
    }

    @Override
    public float e(MotionEvent motionEvent, int n2) {
        return 0.0f;
    }
}

