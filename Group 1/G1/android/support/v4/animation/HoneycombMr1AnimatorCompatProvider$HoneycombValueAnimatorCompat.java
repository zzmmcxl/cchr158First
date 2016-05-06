package android.support.v4.animation;

import android.view.View;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;

static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat
{
    final Animator mWrapped;
    
    public HoneycombValueAnimatorCompat(final Animator mWrapped) {
        super();
        this.mWrapped = mWrapped;
    }
    
    @Override
    public void addListener(final AnimatorListenerCompat animatorListenerCompat) {
        mWrapped.addListener((Animator$AnimatorListener)new AnimatorListenerCompatWrapper(animatorListenerCompat, this));
    }
    
    @Override
    public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
        if (mWrapped instanceof ValueAnimator) {
            ((ValueAnimator)mWrapped).addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
                final /* synthetic */ HoneycombValueAnimatorCompat this$0;
                final /* synthetic */ AnimatorUpdateListenerCompat val$animatorUpdateListener;
                
                HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1() {
                    this$0 = this$0;
                    super();
                }
                
                public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                    animatorUpdateListenerCompat.onAnimationUpdate(this$0);
                }
            });
        }
    }
    
    @Override
    public void cancel() {
        mWrapped.cancel();
    }
    
    @Override
    public float getAnimatedFraction() {
        return ((ValueAnimator)mWrapped).getAnimatedFraction();
    }
    
    @Override
    public void setDuration(final long duration) {
        mWrapped.setDuration(duration);
    }
    
    @Override
    public void setTarget(final View target) {
        mWrapped.setTarget((Object)target);
    }
    
    @Override
    public void start() {
        mWrapped.start();
    }
}
