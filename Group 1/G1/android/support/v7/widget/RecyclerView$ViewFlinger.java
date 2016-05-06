package android.support.v7.widget;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import android.support.v4.os.TraceCompat;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.animation.Interpolator;

private class ViewFlinger implements Runnable
{
    private boolean mEatRunOnAnimationRequest;
    private Interpolator mInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    private boolean mReSchedulePostAnimationCallback;
    private ScrollerCompat mScroller;
    final /* synthetic */ RecyclerView this$0;
    
    public ViewFlinger(final RecyclerView this$0) {
        this$0 = this$0;
        super();
        mInterpolator = RecyclerView.access$3000();
        mEatRunOnAnimationRequest = false;
        mReSchedulePostAnimationCallback = false;
        mScroller = ScrollerCompat.create(this$0.getContext(), RecyclerView.access$3000());
    }
    
    private int computeScrollDuration(final int n, final int n2, final int n3, final int n4) {
        int abs = Math.abs(n);
        final int abs2 = Math.abs(n2);
        boolean b;
        if (abs > abs2) {
            b = true;
        }
        else {
            b = false;
        }
        final int n5 = (int)Math.sqrt(n3 * n3 + n4 * n4);
        final int n6 = (int)Math.sqrt(n * n + n2 * n2);
        int n7;
        if (b) {
            n7 = this$0.getWidth();
        }
        else {
            n7 = this$0.getHeight();
        }
        final int n8 = n7 / 2;
        final float n9 = n8 + n8 * this.distanceInfluenceForSnapDuration(Math.min(1.0f, 1.0f * n6 / (float)n7));
        int n10;
        if (n5 > 0) {
            n10 = 4 * Math.round(1000.0f * Math.abs(n9 / (float)n5));
        }
        else {
            if (!b) {
                abs = abs2;
            }
            n10 = (int)(300.0f * (1.0f + abs / n7));
        }
        return Math.min(n10, 2000);
    }
    
    private void disableRunOnAnimationRequests() {
        mReSchedulePostAnimationCallback = false;
        mEatRunOnAnimationRequest = true;
    }
    
    private float distanceInfluenceForSnapDuration(final float n) {
        return (float)Math.sin(0.4712389167638204 * (n - 0.5f));
    }
    
    private void enableRunOnAnimationRequests() {
        mEatRunOnAnimationRequest = false;
        if (mReSchedulePostAnimationCallback) {
            this.postOnAnimation();
        }
    }
    
    public void fling(final int n, final int n2) {
        RecyclerView.access$3900(this$0, 2);
        mLastFlingY = 0;
        mLastFlingX = 0;
        mScroller.fling(0, 0, n, n2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.postOnAnimation();
    }
    
    void postOnAnimation() {
        if (mEatRunOnAnimationRequest) {
            mReSchedulePostAnimationCallback = true;
            return;
        }
        this$0.removeCallbacks((Runnable)this);
        ViewCompat.postOnAnimation(this$0, (Runnable)this);
    }
    
    @Override
    public void run() {
        if (mLayout == null) {
            this.stop();
            return;
        }
        this.disableRunOnAnimationRequests();
        RecyclerView.access$400(this$0);
        final ScrollerCompat mScroller = this.mScroller;
        final SmoothScroller mSmoothScroller = mLayout.mSmoothScroller;
        if (mScroller.computeScrollOffset()) {
            final int currX = mScroller.getCurrX();
            final int currY = mScroller.getCurrY();
            final int n = currX - mLastFlingX;
            final int n2 = currY - mLastFlingY;
            mLastFlingX = currX;
            mLastFlingY = currY;
            final Adapter access$3100 = RecyclerView.access$3100(this$0);
            int scrollHorizontallyBy = 0;
            int n3 = 0;
            int n4 = 0;
            int scrollVerticallyBy = 0;
            if (access$3100 != null) {
                this$0.eatRequestLayout();
                RecyclerView.access$3200(this$0);
                TraceCompat.beginSection("RV Scroll");
                scrollHorizontallyBy = 0;
                n3 = 0;
                if (n != 0) {
                    scrollHorizontallyBy = mLayout.scrollHorizontallyBy(n, mRecycler, mState);
                    n3 = n - scrollHorizontallyBy;
                }
                n4 = 0;
                scrollVerticallyBy = 0;
                if (n2 != 0) {
                    scrollVerticallyBy = mLayout.scrollVerticallyBy(n2, mRecycler, mState);
                    n4 = n2 - scrollVerticallyBy;
                }
                TraceCompat.endSection();
                RecyclerView.access$3300(this$0);
                RecyclerView.access$3400(this$0);
                this$0.resumeRequestLayout(false);
                if (mSmoothScroller != null && !mSmoothScroller.isPendingInitialRun() && mSmoothScroller.isRunning()) {
                    final int itemCount = mState.getItemCount();
                    if (itemCount == 0) {
                        mSmoothScroller.stop();
                    }
                    else if (mSmoothScroller.getTargetPosition() >= itemCount) {
                        mSmoothScroller.setTargetPosition(itemCount - 1);
                        mSmoothScroller.onAnimation(n - n3, n2 - n4);
                    }
                    else {
                        mSmoothScroller.onAnimation(n - n3, n2 - n4);
                    }
                }
            }
            if (!RecyclerView.access$3600(this$0).isEmpty()) {
                this$0.invalidate();
            }
            if (ViewCompat.getOverScrollMode((View)this$0) != 2) {
                RecyclerView.access$3700(this$0, n, n2);
            }
            if (n3 != 0 || n4 != 0) {
                final int n5 = (int)mScroller.getCurrVelocity();
                int n6 = 0;
                if (n3 != currX) {
                    if (n3 < 0) {
                        n6 = -n5;
                    }
                    else if (n3 > 0) {
                        n6 = n5;
                    }
                    else {
                        n6 = 0;
                    }
                }
                int n7 = 0;
                if (n4 != currY) {
                    if (n4 < 0) {
                        n7 = -n5;
                    }
                    else if (n4 > 0) {
                        n7 = n5;
                    }
                    else {
                        n7 = 0;
                    }
                }
                if (ViewCompat.getOverScrollMode((View)this$0) != 2) {
                    this$0.absorbGlows(n6, n7);
                }
                if ((n6 != 0 || n3 == currX || mScroller.getFinalX() == 0) && (n7 != 0 || n4 == currY || mScroller.getFinalY() == 0)) {
                    mScroller.abortAnimation();
                }
            }
            if (scrollHorizontallyBy != 0 || scrollVerticallyBy != 0) {
                this$0.dispatchOnScrolled(scrollHorizontallyBy, scrollVerticallyBy);
            }
            if (!RecyclerView.access$3800(this$0)) {
                this$0.invalidate();
            }
            boolean b;
            if (n2 != 0 && mLayout.canScrollVertically() && scrollVerticallyBy == n2) {
                b = true;
            }
            else {
                b = false;
            }
            boolean b2;
            if (n != 0 && mLayout.canScrollHorizontally() && scrollHorizontallyBy == n) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            boolean b3;
            if ((n == 0 && n2 == 0) || b2 || b) {
                b3 = true;
            }
            else {
                b3 = false;
            }
            if (mScroller.isFinished() || !b3) {
                RecyclerView.access$3900(this$0, 0);
            }
            else {
                this.postOnAnimation();
            }
        }
        if (mSmoothScroller != null) {
            if (mSmoothScroller.isPendingInitialRun()) {
                mSmoothScroller.onAnimation(0, 0);
            }
            if (!mReSchedulePostAnimationCallback) {
                mSmoothScroller.stop();
            }
        }
        this.enableRunOnAnimationRequests();
    }
    
    public void smoothScrollBy(final int n, final int n2) {
        this.smoothScrollBy(n, n2, 0, 0);
    }
    
    public void smoothScrollBy(final int n, final int n2, final int n3) {
        this.smoothScrollBy(n, n2, n3, RecyclerView.access$3000());
    }
    
    public void smoothScrollBy(final int n, final int n2, final int n3, final int n4) {
        this.smoothScrollBy(n, n2, this.computeScrollDuration(n, n2, n3, n4));
    }
    
    public void smoothScrollBy(final int n, final int n2, final int n3, final Interpolator mInterpolator) {
        if (this.mInterpolator != mInterpolator) {
            this.mInterpolator = mInterpolator;
            mScroller = ScrollerCompat.create(this$0.getContext(), mInterpolator);
        }
        RecyclerView.access$3900(this$0, 2);
        mLastFlingY = 0;
        mLastFlingX = 0;
        mScroller.startScroll(0, 0, n, n2, n3);
        this.postOnAnimation();
    }
    
    public void stop() {
        this$0.removeCallbacks((Runnable)this);
        mScroller.abortAnimation();
    }
}
