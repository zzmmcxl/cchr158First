package android.support.v4.widget;

import android.widget.EdgeEffect;

class EdgeEffectCompatLollipop
{
    EdgeEffectCompatLollipop() {
        super();
    }
    
    public static boolean onPull(final Object o, final float n, final float n2) {
        ((EdgeEffect)o).onPull(n, n2);
        return true;
    }
}
