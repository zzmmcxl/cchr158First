package android.support.design.widget;

import android.view.animation.Interpolator;

class ValueAnimatorCompat
{
    private final Impl mImpl;
    
    ValueAnimatorCompat(final Impl mImpl) {
        super();
        mImpl = mImpl;
    }
    
    public void cancel() {
        mImpl.cancel();
    }
    
    public void end() {
        mImpl.end();
    }
    
    public float getAnimatedFloatValue() {
        return mImpl.getAnimatedFloatValue();
    }
    
    public float getAnimatedFraction() {
        return mImpl.getAnimatedFraction();
    }
    
    public int getAnimatedIntValue() {
        return mImpl.getAnimatedIntValue();
    }
    
    public long getDuration() {
        return mImpl.getDuration();
    }
    
    public boolean isRunning() {
        return mImpl.isRunning();
    }
    
    public void setDuration(final int duration) {
        mImpl.setDuration(duration);
    }
    
    public void setFloatValues(final float n, final float n2) {
        mImpl.setFloatValues(n, n2);
    }
    
    public void setIntValues(final int n, final int n2) {
        mImpl.setIntValues(n, n2);
    }
    
    public void setInterpolator(final Interpolator interpolator) {
        mImpl.setInterpolator(interpolator);
    }
    
    public void setListener(final AnimatorListener animatorListener) {
        if (animatorListener != null) {
            mImpl.setListener((AnimatorListenerProxy)new AnimatorListenerProxy() {
                final /* synthetic */ ValueAnimatorCompat this$0;
                final /* synthetic */ AnimatorListener val$listener;
                
                ValueAnimatorCompat$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationCancel() {
                    animatorListener.onAnimationCancel(this$0);
                }
                
                @Override
                public void onAnimationEnd() {
                    animatorListener.onAnimationEnd(this$0);
                }
                
                @Override
                public void onAnimationStart() {
                    animatorListener.onAnimationStart(this$0);
                }
            });
            return;
        }
        mImpl.setListener(null);
    }
    
    public void setUpdateListener(final AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            mImpl.setUpdateListener((AnimatorUpdateListenerProxy)new AnimatorUpdateListenerProxy() {
                final /* synthetic */ ValueAnimatorCompat this$0;
                final /* synthetic */ AnimatorUpdateListener val$updateListener;
                
                ValueAnimatorCompat$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationUpdate() {
                    animatorUpdateListener.onAnimationUpdate(this$0);
                }
            });
            return;
        }
        mImpl.setUpdateListener(null);
    }
    
    public void start() {
        mImpl.start();
    }
}
