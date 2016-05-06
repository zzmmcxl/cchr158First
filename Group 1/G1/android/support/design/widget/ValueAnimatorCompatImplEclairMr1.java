package android.support.design.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.os.SystemClock;
import android.os.Looper;
import android.view.animation.Interpolator;
import android.os.Handler;

class ValueAnimatorCompatImplEclairMr1 extends Impl
{
    private static final int DEFAULT_DURATION = 200;
    private static final int HANDLER_DELAY = 10;
    private static final Handler sHandler;
    private float mAnimatedFraction;
    private int mDuration;
    private final float[] mFloatValues;
    private final int[] mIntValues;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private AnimatorListenerProxy mListener;
    private final Runnable mRunnable;
    private long mStartTime;
    private AnimatorUpdateListenerProxy mUpdateListener;
    
    static {
        sHandler = new Handler(Looper.getMainLooper());
    }
    
    ValueAnimatorCompatImplEclairMr1() {
        super();
        mIntValues = new int[2];
        mFloatValues = new float[2];
        mDuration = 200;
        mRunnable = new Runnable() {
            final /* synthetic */ ValueAnimatorCompatImplEclairMr1 this$0;
            
            ValueAnimatorCompatImplEclairMr1$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.update();
            }
        };
    }
    
    static /* synthetic */ void access$000(final ValueAnimatorCompatImplEclairMr1 valueAnimatorCompatImplEclairMr1) {
        valueAnimatorCompatImplEclairMr1.update();
    }
    
    private void update() {
        if (mIsRunning) {
            float interpolation = (SystemClock.uptimeMillis() - mStartTime) / mDuration;
            if (mInterpolator != null) {
                interpolation = mInterpolator.getInterpolation(interpolation);
            }
            mAnimatedFraction = interpolation;
            if (mUpdateListener != null) {
                mUpdateListener.onAnimationUpdate();
            }
            if (SystemClock.uptimeMillis() >= mStartTime + mDuration) {
                mIsRunning = false;
                if (mListener != null) {
                    mListener.onAnimationEnd();
                }
            }
        }
        if (mIsRunning) {
            sHandler.postDelayed(mRunnable, 10L);
        }
    }
    
    public void cancel() {
        mIsRunning = false;
        sHandler.removeCallbacks(mRunnable);
        if (mListener != null) {
            mListener.onAnimationCancel();
        }
    }
    
    public void end() {
        if (mIsRunning) {
            mIsRunning = false;
            sHandler.removeCallbacks(mRunnable);
            mAnimatedFraction = 1.0f;
            if (mUpdateListener != null) {
                mUpdateListener.onAnimationUpdate();
            }
            if (mListener != null) {
                mListener.onAnimationEnd();
            }
        }
    }
    
    public float getAnimatedFloatValue() {
        return AnimationUtils.lerp(mFloatValues[0], mFloatValues[1], this.getAnimatedFraction());
    }
    
    public float getAnimatedFraction() {
        return mAnimatedFraction;
    }
    
    public int getAnimatedIntValue() {
        return AnimationUtils.lerp(mIntValues[0], mIntValues[1], this.getAnimatedFraction());
    }
    
    public long getDuration() {
        return mDuration;
    }
    
    public boolean isRunning() {
        return mIsRunning;
    }
    
    public void setDuration(final int mDuration) {
        this.mDuration = mDuration;
    }
    
    public void setFloatValues(final float n, final float n2) {
        mFloatValues[0] = n;
        mFloatValues[1] = n2;
    }
    
    public void setIntValues(final int n, final int n2) {
        mIntValues[0] = n;
        mIntValues[1] = n2;
    }
    
    public void setInterpolator(final Interpolator mInterpolator) {
        this.mInterpolator = mInterpolator;
    }
    
    public void setListener(final AnimatorListenerProxy mListener) {
        this.mListener = mListener;
    }
    
    public void setUpdateListener(final AnimatorUpdateListenerProxy mUpdateListener) {
        this.mUpdateListener = mUpdateListener;
    }
    
    public void start() {
        if (mIsRunning) {
            return;
        }
        if (mInterpolator == null) {
            mInterpolator = (Interpolator)new AccelerateDecelerateInterpolator();
        }
        mStartTime = SystemClock.uptimeMillis();
        mIsRunning = true;
        if (mListener != null) {
            mListener.onAnimationStart();
        }
        sHandler.postDelayed(mRunnable, 10L);
    }
}
