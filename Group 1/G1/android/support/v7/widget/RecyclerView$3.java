package android.support.v7.widget;

import android.view.animation.Interpolator;

static final class RecyclerView$3 implements Interpolator {
    RecyclerView$3() {
        super();
    }
    
    public float getInterpolation(final float n) {
        final float n2 = n - 1.0f;
        return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
    }
}