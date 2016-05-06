package android.support.v7.widget.helper;

import android.view.animation.Interpolator;

static final class ItemTouchHelper$Callback$2 implements Interpolator {
    ItemTouchHelper$Callback$2() {
        super();
    }
    
    public float getInterpolation(final float n) {
        final float n2 = n - 1.0f;
        return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
    }
}