package android.support.v4.view;

import android.view.animation.Interpolator;
import android.view.View;

static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl
{
    JBMr2ViewPropertyAnimatorCompatImpl() {
        super();
    }
    
    @Override
    public Interpolator getInterpolator(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view) {
        return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
    }
}
