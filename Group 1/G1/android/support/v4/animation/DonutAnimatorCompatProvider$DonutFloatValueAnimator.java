package android.support.v4.animation;

import java.util.ArrayList;
import android.view.View;
import java.util.List;

private static class DonutFloatValueAnimator implements ValueAnimatorCompat
{
    private long mDuration;
    private boolean mEnded;
    private float mFraction;
    List<AnimatorListenerCompat> mListeners;
    private Runnable mLoopRunnable;
    private long mStartTime;
    private boolean mStarted;
    View mTarget;
    List<AnimatorUpdateListenerCompat> mUpdateListeners;
    
    public DonutFloatValueAnimator() {
        super();
        this.mListeners = new ArrayList<AnimatorListenerCompat>();
        this.mUpdateListeners = new ArrayList<AnimatorUpdateListenerCompat>();
        this.mDuration = 200L;
        this.mFraction = 0.0f;
        this.mStarted = false;
        this.mEnded = false;
        this.mLoopRunnable = new Runnable() {
            final /* synthetic */ DonutFloatValueAnimator this$0;
            
            DonutAnimatorCompatProvider$DonutFloatValueAnimator$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                float n = 1.0f * (this$0.getTime() - mStartTime) / mDuration;
                if (n > 1.0f || mTarget.getParent() == null) {
                    n = 1.0f;
                }
                mFraction = n;
                this$0.notifyUpdateListeners();
                if (mFraction >= 1.0f) {
                    this$0.dispatchEnd();
                    return;
                }
                mTarget.postDelayed(mLoopRunnable, 16L);
            }
        };
    }
    
    static /* synthetic */ long access$000(final DonutFloatValueAnimator donutFloatValueAnimator) {
        return donutFloatValueAnimator.getTime();
    }
    
    static /* synthetic */ long access$100(final DonutFloatValueAnimator donutFloatValueAnimator) {
        return donutFloatValueAnimator.mStartTime;
    }
    
    static /* synthetic */ long access$200(final DonutFloatValueAnimator donutFloatValueAnimator) {
        return donutFloatValueAnimator.mDuration;
    }
    
    static /* synthetic */ float access$300(final DonutFloatValueAnimator donutFloatValueAnimator) {
        return donutFloatValueAnimator.mFraction;
    }
    
    static /* synthetic */ float access$302(final DonutFloatValueAnimator donutFloatValueAnimator, final float mFraction) {
        return donutFloatValueAnimator.mFraction = mFraction;
    }
    
    static /* synthetic */ void access$400(final DonutFloatValueAnimator donutFloatValueAnimator) {
        donutFloatValueAnimator.notifyUpdateListeners();
    }
    
    static /* synthetic */ void access$500(final DonutFloatValueAnimator donutFloatValueAnimator) {
        donutFloatValueAnimator.dispatchEnd();
    }
    
    static /* synthetic */ Runnable access$600(final DonutFloatValueAnimator donutFloatValueAnimator) {
        return donutFloatValueAnimator.mLoopRunnable;
    }
    
    private void dispatchCancel() {
        for (int i = -1 + mListeners.size(); i >= 0; --i) {
            ((AnimatorListenerCompat)mListeners.get(i)).onAnimationCancel(this);
        }
    }
    
    private void dispatchEnd() {
        for (int i = -1 + mListeners.size(); i >= 0; --i) {
            ((AnimatorListenerCompat)mListeners.get(i)).onAnimationEnd(this);
        }
    }
    
    private void dispatchStart() {
        for (int i = -1 + mListeners.size(); i >= 0; --i) {
            ((AnimatorListenerCompat)mListeners.get(i)).onAnimationStart(this);
        }
    }
    
    private long getTime() {
        return mTarget.getDrawingTime();
    }
    
    private void notifyUpdateListeners() {
        for (int i = -1 + mUpdateListeners.size(); i >= 0; --i) {
            ((AnimatorUpdateListenerCompat)mUpdateListeners.get(i)).onAnimationUpdate(this);
        }
    }
    
    @Override
    public void addListener(final AnimatorListenerCompat animatorListenerCompat) {
        mListeners.add(animatorListenerCompat);
    }
    
    @Override
    public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
        mUpdateListeners.add(animatorUpdateListenerCompat);
    }
    
    @Override
    public void cancel() {
        if (mEnded) {
            return;
        }
        mEnded = true;
        if (mStarted) {
            this.dispatchCancel();
        }
        this.dispatchEnd();
    }
    
    @Override
    public float getAnimatedFraction() {
        return mFraction;
    }
    
    @Override
    public void setDuration(final long mDuration) {
        if (!mStarted) {
            this.mDuration = mDuration;
        }
    }
    
    @Override
    public void setTarget(final View mTarget) {
        this.mTarget = mTarget;
    }
    
    @Override
    public void start() {
        if (mStarted) {
            return;
        }
        mStarted = true;
        this.dispatchStart();
        mFraction = 0.0f;
        mStartTime = this.getTime();
        mTarget.postDelayed(mLoopRunnable, 16L);
    }
}
