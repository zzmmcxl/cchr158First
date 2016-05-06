package android.support.v4.widget;

import android.view.animation.AnimationUtils;

private static class ClampedScroller
{
    private long mDeltaTime;
    private int mDeltaX;
    private int mDeltaY;
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private long mStartTime;
    private long mStopTime;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;
    
    public ClampedScroller() {
        super();
        this.mStartTime = Long.MIN_VALUE;
        this.mStopTime = -1L;
        this.mDeltaTime = 0L;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
    }
    
    private float getValueAt(final long n) {
        if (n < mStartTime) {
            return 0.0f;
        }
        if (mStopTime < 0L || n < mStopTime) {
            return 0.5f * AutoScrollHelper.access$900((float)(n - mStartTime) / (float)mRampUpDuration, 0.0f, 1.0f);
        }
        return 1.0f - mStopValue + mStopValue * AutoScrollHelper.access$900((float)(n - mStopTime) / (float)mEffectiveRampDown, 0.0f, 1.0f);
    }
    
    private float interpolateValue(final float n) {
        return n * (-4.0f * n) + 4.0f * n;
    }
    
    public void computeScrollDelta() {
        if (mDeltaTime == 0L) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        final float interpolateValue = this.interpolateValue(this.getValueAt(currentAnimationTimeMillis));
        final long n = currentAnimationTimeMillis - mDeltaTime;
        mDeltaTime = currentAnimationTimeMillis;
        mDeltaX = (int)(interpolateValue * n * mTargetVelocityX);
        mDeltaY = (int)(interpolateValue * n * mTargetVelocityY);
    }
    
    public int getDeltaX() {
        return mDeltaX;
    }
    
    public int getDeltaY() {
        return mDeltaY;
    }
    
    public int getHorizontalDirection() {
        return (int)(mTargetVelocityX / Math.abs(mTargetVelocityX));
    }
    
    public int getVerticalDirection() {
        return (int)(mTargetVelocityY / Math.abs(mTargetVelocityY));
    }
    
    public boolean isFinished() {
        return mStopTime > 0L && AnimationUtils.currentAnimationTimeMillis() > mStopTime + mEffectiveRampDown;
    }
    
    public void requestStop() {
        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        mEffectiveRampDown = AutoScrollHelper.access$800((int)(currentAnimationTimeMillis - mStartTime), 0, mRampDownDuration);
        mStopValue = this.getValueAt(currentAnimationTimeMillis);
        mStopTime = currentAnimationTimeMillis;
    }
    
    public void setRampDownDuration(final int mRampDownDuration) {
        this.mRampDownDuration = mRampDownDuration;
    }
    
    public void setRampUpDuration(final int mRampUpDuration) {
        this.mRampUpDuration = mRampUpDuration;
    }
    
    public void setTargetVelocity(final float mTargetVelocityX, final float mTargetVelocityY) {
        this.mTargetVelocityX = mTargetVelocityX;
        this.mTargetVelocityY = mTargetVelocityY;
    }
    
    public void start() {
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStopTime = -1L;
        mDeltaTime = mStartTime;
        mStopValue = 0.5f;
        mDeltaX = 0;
        mDeltaY = 0;
    }
}
