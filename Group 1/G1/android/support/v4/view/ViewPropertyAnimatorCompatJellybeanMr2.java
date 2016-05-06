package android.support.v4.view;

import android.view.animation.Interpolator;
import android.view.View;

class ViewPropertyAnimatorCompatJellybeanMr2
{
    ViewPropertyAnimatorCompatJellybeanMr2() {
        super();
    }
    
    public static Interpolator getInterpolator(final View view) {
        return (Interpolator)view.animate().getInterpolator();
    }
}
