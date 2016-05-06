package android.support.v7.widget.helper;

import android.view.animation.Interpolator;

static final class ItemTouchHelper$Callback$1 implements Interpolator {
    ItemTouchHelper$Callback$1() {
        super();
    }
    
    public float getInterpolation(final float n) {
        return n * (n * (n * (n * n)));
    }
}