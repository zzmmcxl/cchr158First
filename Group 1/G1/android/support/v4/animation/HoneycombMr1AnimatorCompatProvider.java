package android.support.v4.animation;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.animation.TimeInterpolator;

class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider
{
    private TimeInterpolator mDefaultInterpolator;
    
    HoneycombMr1AnimatorCompatProvider() {
        super();
    }
    
    @Override
    public void clearInterpolator(final View view) {
        if (mDefaultInterpolator == null) {
            mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(mDefaultInterpolator);
    }
    
    @Override
    public ValueAnimatorCompat emptyValueAnimator() {
        return new HoneycombValueAnimatorCompat((Animator)ValueAnimator.ofFloat(new float[] { 0.0f, 1.0f }));
    }
}
