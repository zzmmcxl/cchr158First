/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.view.animation.Interpolator;

final class eb
implements Interpolator {
    eb() {
    }

    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return 1.0f + f3 * (f3 * (f3 * (f3 * f3)));
    }
}

