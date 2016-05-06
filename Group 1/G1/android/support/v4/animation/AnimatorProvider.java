package android.support.v4.animation;

import android.view.View;

interface AnimatorProvider
{
    void clearInterpolator(final View p0);
    
    ValueAnimatorCompat emptyValueAnimator();
}
