package android.support.design.widget;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;
import android.animation.ValueAnimator;

class ValueAnimatorCompatImplHoneycombMr1 extends Impl
{
    final ValueAnimator mValueAnimator;
    
    ValueAnimatorCompatImplHoneycombMr1() {
        super();
        mValueAnimator = new ValueAnimator();
    }
    
    public void cancel() {
        mValueAnimator.cancel();
    }
    
    public void end() {
        mValueAnimator.end();
    }
    
    public float getAnimatedFloatValue() {
        return (float)mValueAnimator.getAnimatedValue();
    }
    
    public float getAnimatedFraction() {
        return mValueAnimator.getAnimatedFraction();
    }
    
    public int getAnimatedIntValue() {
        return (int)mValueAnimator.getAnimatedValue();
    }
    
    public long getDuration() {
        return mValueAnimator.getDuration();
    }
    
    public boolean isRunning() {
        return mValueAnimator.isRunning();
    }
    
    public void setDuration(final int n) {
        mValueAnimator.setDuration((long)n);
    }
    
    public void setFloatValues(final float n, final float n2) {
        mValueAnimator.setFloatValues(new float[] { n, n2 });
    }
    
    public void setIntValues(final int n, final int n2) {
        mValueAnimator.setIntValues(new int[] { n, n2 });
    }
    
    public void setInterpolator(final Interpolator interpolator) {
        mValueAnimator.setInterpolator((TimeInterpolator)interpolator);
    }
    
    public void setListener(final AnimatorListenerProxy animatorListenerProxy) {
        mValueAnimator.addListener((Animator$AnimatorListener)new android.animation.AnimatorListenerAdapter() {
            final /* synthetic */ ValueAnimatorCompatImplHoneycombMr1 this$0;
            final /* synthetic */ AnimatorListenerProxy val$listener;
            
            ValueAnimatorCompatImplHoneycombMr1$2() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationCancel(final Animator animator) {
                animatorListenerProxy.onAnimationCancel();
            }
            
            public void onAnimationEnd(final Animator animator) {
                animatorListenerProxy.onAnimationEnd();
            }
            
            public void onAnimationStart(final Animator animator) {
                animatorListenerProxy.onAnimationStart();
            }
        });
    }
    
    public void setUpdateListener(final AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        mValueAnimator.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
            final /* synthetic */ ValueAnimatorCompatImplHoneycombMr1 this$0;
            final /* synthetic */ AnimatorUpdateListenerProxy val$updateListener;
            
            ValueAnimatorCompatImplHoneycombMr1$1() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                animatorUpdateListenerProxy.onAnimationUpdate();
            }
        });
    }
    
    public void start() {
        mValueAnimator.start();
    }
}
