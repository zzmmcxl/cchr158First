package android.support.design.widget;

import android.widget.LinearLayout$LayoutParams;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.content.Context;
import android.graphics.Paint;
import android.widget.LinearLayout;

private class SlidingTabStrip extends LinearLayout
{
    private ValueAnimatorCompat mIndicatorAnimator;
    private int mIndicatorLeft;
    private int mIndicatorRight;
    private int mSelectedIndicatorHeight;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition;
    private float mSelectionOffset;
    final /* synthetic */ TabLayout this$0;
    
    SlidingTabStrip(final TabLayout this$0, final Context context) {
        this$0 = this$0;
        super(context);
        mSelectedPosition = -1;
        mIndicatorLeft = -1;
        mIndicatorRight = -1;
        this.setWillNotDraw(false);
        mSelectedIndicatorPaint = new Paint();
    }
    
    static /* synthetic */ void access$2400(final SlidingTabStrip slidingTabStrip, final int n, final int n2) {
        slidingTabStrip.setIndicatorPosition(n, n2);
    }
    
    static /* synthetic */ int access$2502(final SlidingTabStrip slidingTabStrip, final int mSelectedPosition) {
        return slidingTabStrip.mSelectedPosition = mSelectedPosition;
    }
    
    static /* synthetic */ float access$2602(final SlidingTabStrip slidingTabStrip, final float mSelectionOffset) {
        return slidingTabStrip.mSelectionOffset = mSelectionOffset;
    }
    
    private void setIndicatorPosition(final int mIndicatorLeft, final int mIndicatorRight) {
        if (mIndicatorLeft != this.mIndicatorLeft || mIndicatorRight != this.mIndicatorRight) {
            this.mIndicatorLeft = mIndicatorLeft;
            this.mIndicatorRight = mIndicatorRight;
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    private void updateIndicatorPosition() {
        final View child = this.getChildAt(mSelectedPosition);
        int left;
        int right;
        if (child != null && child.getWidth() > 0) {
            left = child.getLeft();
            right = child.getRight();
            if (mSelectionOffset > 0.0f && mSelectedPosition < -1 + this.getChildCount()) {
                final View child2 = this.getChildAt(1 + mSelectedPosition);
                left = (int)(mSelectionOffset * child2.getLeft() + (1.0f - mSelectionOffset) * left);
                right = (int)(mSelectionOffset * child2.getRight() + (1.0f - mSelectionOffset) * right);
            }
        }
        else {
            right = (left = -1);
        }
        this.setIndicatorPosition(left, right);
    }
    
    void animateIndicatorToPosition(final int n, final int duration) {
        if (mIndicatorAnimator != null && mIndicatorAnimator.isRunning()) {
            mIndicatorAnimator.cancel();
        }
        final boolean b = ViewCompat.getLayoutDirection((View)this) == 1;
        final View child = this.getChildAt(n);
        if (child == null) {
            this.updateIndicatorPosition();
        }
        else {
            final int left = child.getLeft();
            final int right = child.getRight();
            int mIndicatorLeft;
            int mIndicatorRight;
            if (Math.abs(n - mSelectedPosition) <= 1) {
                mIndicatorLeft = this.mIndicatorLeft;
                mIndicatorRight = this.mIndicatorRight;
            }
            else {
                final int access$2100 = TabLayout.access$2100(this$0, 24);
                if (n < mSelectedPosition) {
                    if (b) {
                        mIndicatorRight = (mIndicatorLeft = left - access$2100);
                    }
                    else {
                        mIndicatorRight = (mIndicatorLeft = right + access$2100);
                    }
                }
                else if (b) {
                    mIndicatorRight = (mIndicatorLeft = right + access$2100);
                }
                else {
                    mIndicatorRight = (mIndicatorLeft = left - access$2100);
                }
            }
            if (mIndicatorLeft != left || mIndicatorRight != right) {
                final ValueAnimatorCompat animator = ViewUtils.createAnimator();
                (mIndicatorAnimator = animator).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                animator.setDuration(duration);
                animator.setFloatValues(0.0f, 1.0f);
                animator.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                    final /* synthetic */ SlidingTabStrip this$1;
                    final /* synthetic */ int val$startLeft;
                    final /* synthetic */ int val$startRight;
                    final /* synthetic */ int val$targetLeft;
                    final /* synthetic */ int val$targetRight;
                    
                    TabLayout$SlidingTabStrip$1() {
                        this$1 = this$1;
                        super();
                    }
                    
                    @Override
                    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                        final float animatedFraction = valueAnimatorCompat.getAnimatedFraction();
                        this$1.setIndicatorPosition(AnimationUtils.lerp(mIndicatorLeft, left, animatedFraction), AnimationUtils.lerp(mIndicatorRight, right, animatedFraction));
                    }
                });
                animator.setListener((ValueAnimatorCompat.AnimatorListener)new ValueAnimatorCompat.AnimatorListenerAdapter() {
                    final /* synthetic */ SlidingTabStrip this$1;
                    final /* synthetic */ int val$position;
                    
                    TabLayout$SlidingTabStrip$2() {
                        this$1 = this$1;
                        super();
                    }
                    
                    @Override
                    public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
                        mSelectedPosition = n;
                        mSelectionOffset = 0.0f;
                    }
                });
                animator.start();
            }
        }
    }
    
    boolean childrenNeedLayout() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (this.getChildAt(i).getWidth() <= 0) {
                return true;
            }
        }
        return false;
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (mIndicatorLeft >= 0 && mIndicatorRight > mIndicatorLeft) {
            canvas.drawRect((float)mIndicatorLeft, (float)(this.getHeight() - mSelectedIndicatorHeight), (float)mIndicatorRight, (float)this.getHeight(), mSelectedIndicatorPaint);
        }
    }
    
    float getIndicatorPosition() {
        return mSelectedPosition + mSelectionOffset;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (mIndicatorAnimator != null && mIndicatorAnimator.isRunning()) {
            mIndicatorAnimator.cancel();
            this.animateIndicatorToPosition(mSelectedPosition, Math.round((1.0f - mIndicatorAnimator.getAnimatedFraction()) * (float)mIndicatorAnimator.getDuration()));
            return;
        }
        this.updateIndicatorPosition();
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (View$MeasureSpec.getMode(n) == 1073741824 && TabLayout.access$1800(this$0) == 1 && TabLayout.access$2200(this$0) == 1) {
            final int childCount = this.getChildCount();
            int max = 0;
            for (int i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    max = Math.max(max, child.getMeasuredWidth());
                }
            }
            if (max > 0) {
                final int access$2100 = TabLayout.access$2100(this$0, 16);
                boolean b = false;
                if (max * childCount <= this.getMeasuredWidth() - access$2100 * 2) {
                    for (int j = 0; j < childCount; ++j) {
                        final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)this.getChildAt(j).getLayoutParams();
                        if (linearLayout$LayoutParams.width != max || linearLayout$LayoutParams.weight != 0.0f) {
                            linearLayout$LayoutParams.width = max;
                            linearLayout$LayoutParams.weight = 0.0f;
                            b = true;
                        }
                    }
                }
                else {
                    TabLayout.access$2202(this$0, 0);
                    TabLayout.access$2300(this$0, false);
                    b = true;
                }
                if (b) {
                    super.onMeasure(n, n2);
                }
            }
        }
    }
    
    void setIndicatorPositionFromTabPosition(final int mSelectedPosition, final float mSelectionOffset) {
        if (mIndicatorAnimator != null && mIndicatorAnimator.isRunning()) {
            mIndicatorAnimator.cancel();
        }
        this.mSelectedPosition = mSelectedPosition;
        this.mSelectionOffset = mSelectionOffset;
        this.updateIndicatorPosition();
    }
    
    void setSelectedIndicatorColor(final int color) {
        if (mSelectedIndicatorPaint.getColor() != color) {
            mSelectedIndicatorPaint.setColor(color);
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    void setSelectedIndicatorHeight(final int mSelectedIndicatorHeight) {
        if (this.mSelectedIndicatorHeight != mSelectedIndicatorHeight) {
            this.mSelectedIndicatorHeight = mSelectedIndicatorHeight;
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
}
