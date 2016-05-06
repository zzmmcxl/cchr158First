package android.support.v7.widget.helper;

import android.support.v4.view.ViewCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.animation.AnimatorListenerCompat;

private class RecoverAnimation implements AnimatorListenerCompat
{
    final int mActionState;
    private final int mAnimationType;
    private boolean mEnded;
    private float mFraction;
    public boolean mIsPendingCleanup;
    boolean mOverridden;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    private final ValueAnimatorCompat mValueAnimator;
    final ViewHolder mViewHolder;
    float mX;
    float mY;
    final /* synthetic */ ItemTouchHelper this$0;
    
    public RecoverAnimation(final ItemTouchHelper this$0, final ViewHolder mViewHolder, final int mAnimationType, final int mActionState, final float mStartDx, final float mStartDy, final float mTargetX, final float mTargetY) {
        this$0 = this$0;
        super();
        mOverridden = false;
        mEnded = false;
        mActionState = mActionState;
        mAnimationType = mAnimationType;
        mViewHolder = mViewHolder;
        mStartDx = mStartDx;
        mStartDy = mStartDy;
        mTargetX = mTargetX;
        mTargetY = mTargetY;
        (mValueAnimator = AnimatorCompatHelper.emptyValueAnimator()).addUpdateListener(new AnimatorUpdateListenerCompat() {
            final /* synthetic */ RecoverAnimation this$1;
            final /* synthetic */ ItemTouchHelper val$this$0;
            
            ItemTouchHelper$RecoverAnimation$1() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                this$1.setFraction(valueAnimatorCompat.getAnimatedFraction());
            }
        });
        mValueAnimator.setTarget(mViewHolder.itemView);
        mValueAnimator.addListener(this);
        this.setFraction(0.0f);
    }
    
    static /* synthetic */ boolean access$1900(final RecoverAnimation recoverAnimation) {
        return recoverAnimation.mEnded;
    }
    
    static /* synthetic */ int access$2000(final RecoverAnimation recoverAnimation) {
        return recoverAnimation.mAnimationType;
    }
    
    public void cancel() {
        mValueAnimator.cancel();
    }
    
    @Override
    public void onAnimationCancel(final ValueAnimatorCompat valueAnimatorCompat) {
        this.setFraction(1.0f);
    }
    
    @Override
    public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
        if (!mEnded) {
            mViewHolder.setIsRecyclable(true);
        }
        mEnded = true;
    }
    
    @Override
    public void onAnimationRepeat(final ValueAnimatorCompat valueAnimatorCompat) {
    }
    
    @Override
    public void onAnimationStart(final ValueAnimatorCompat valueAnimatorCompat) {
    }
    
    public void setDuration(final long duration) {
        mValueAnimator.setDuration(duration);
    }
    
    public void setFraction(final float mFraction) {
        this.mFraction = mFraction;
    }
    
    public void start() {
        mViewHolder.setIsRecyclable(false);
        mValueAnimator.start();
    }
    
    public void update() {
        if (mStartDx == mTargetX) {
            mX = ViewCompat.getTranslationX(mViewHolder.itemView);
        }
        else {
            mX = mStartDx + mFraction * (mTargetX - mStartDx);
        }
        if (mStartDy == mTargetY) {
            mY = ViewCompat.getTranslationY(mViewHolder.itemView);
            return;
        }
        mY = mStartDy + mFraction * (mTargetY - mStartDy);
    }
}
