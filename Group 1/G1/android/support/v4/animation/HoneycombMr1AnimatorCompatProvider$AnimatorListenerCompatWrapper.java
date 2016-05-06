package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;

static class AnimatorListenerCompatWrapper implements Animator$AnimatorListener
{
    final ValueAnimatorCompat mValueAnimatorCompat;
    final AnimatorListenerCompat mWrapped;
    
    public AnimatorListenerCompatWrapper(final AnimatorListenerCompat mWrapped, final ValueAnimatorCompat mValueAnimatorCompat) {
        super();
        this.mWrapped = mWrapped;
        this.mValueAnimatorCompat = mValueAnimatorCompat;
    }
    
    public void onAnimationCancel(final Animator animator) {
        mWrapped.onAnimationCancel(mValueAnimatorCompat);
    }
    
    public void onAnimationEnd(final Animator animator) {
        mWrapped.onAnimationEnd(mValueAnimatorCompat);
    }
    
    public void onAnimationRepeat(final Animator animator) {
        mWrapped.onAnimationRepeat(mValueAnimatorCompat);
    }
    
    public void onAnimationStart(final Animator animator) {
        mWrapped.onAnimationStart(mValueAnimatorCompat);
    }
}
