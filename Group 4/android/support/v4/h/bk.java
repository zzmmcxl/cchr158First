/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.bm;
import android.view.VelocityTracker;

class bk
implements bm {
    bk() {
    }

    @Override
    public float a(VelocityTracker velocityTracker, int n2) {
        return velocityTracker.getXVelocity();
    }

    @Override
    public float b(VelocityTracker velocityTracker, int n2) {
        return velocityTracker.getYVelocity();
    }
}

