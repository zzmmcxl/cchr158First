package android.support.v7.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.support.annotation.CallSuper;
import java.util.ArrayList;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Rect;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v7.recyclerview.R;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$MeasureSpec;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public abstract static class SmoothScroller
{
    private LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final Action mRecyclingAction;
    private boolean mRunning;
    private int mTargetPosition;
    private View mTargetView;
    
    public SmoothScroller() {
        super();
        this.mTargetPosition = -1;
        this.mRecyclingAction = new Action(0, 0);
    }
    
    static /* synthetic */ void access$3500(final SmoothScroller smoothScroller, final int n, final int n2) {
        smoothScroller.onAnimation(n, n2);
    }
    
    private void onAnimation(final int n, final int n2) {
        final RecyclerView mRecyclerView = this.mRecyclerView;
        if (!mRunning || mTargetPosition == -1 || mRecyclerView == null) {
            this.stop();
        }
        mPendingInitialRun = false;
        if (mTargetView != null) {
            if (this.getChildPosition(mTargetView) == mTargetPosition) {
                this.onTargetFound(mTargetView, mState, mRecyclingAction);
                mRecyclingAction.runIfNecessary(mRecyclerView);
                this.stop();
            }
            else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                mTargetView = null;
            }
        }
        if (mRunning) {
            this.onSeekTargetStep(n, n2, mState, mRecyclingAction);
            final boolean hasJumpTarget = mRecyclingAction.hasJumpTarget();
            mRecyclingAction.runIfNecessary(mRecyclerView);
            if (hasJumpTarget) {
                if (!mRunning) {
                    this.stop();
                    return;
                }
                mPendingInitialRun = true;
                RecyclerView.access$5900(mRecyclerView).postOnAnimation();
            }
        }
    }
    
    public View findViewByPosition(final int n) {
        return mLayout.findViewByPosition(n);
    }
    
    public int getChildCount() {
        return mLayout.getChildCount();
    }
    
    public int getChildPosition(final View view) {
        return mRecyclerView.getChildLayoutPosition(view);
    }
    
    @Nullable
    public LayoutManager getLayoutManager() {
        return mLayoutManager;
    }
    
    public int getTargetPosition() {
        return mTargetPosition;
    }
    
    @Deprecated
    public void instantScrollToPosition(final int n) {
        mRecyclerView.scrollToPosition(n);
    }
    
    public boolean isPendingInitialRun() {
        return mPendingInitialRun;
    }
    
    public boolean isRunning() {
        return mRunning;
    }
    
    protected void normalize(final PointF pointF) {
        final double sqrt = Math.sqrt(pointF.x * pointF.x + pointF.y * pointF.y);
        pointF.x /= sqrt;
        pointF.y /= sqrt;
    }
    
    protected void onChildAttachedToWindow(final View mTargetView) {
        if (this.getChildPosition(mTargetView) == this.getTargetPosition()) {
            this.mTargetView = mTargetView;
        }
    }
    
    protected abstract void onSeekTargetStep(final int p0, final int p1, final State p2, final Action p3);
    
    protected abstract void onStart();
    
    protected abstract void onStop();
    
    protected abstract void onTargetFound(final View p0, final State p1, final Action p2);
    
    public void setTargetPosition(final int mTargetPosition) {
        this.mTargetPosition = mTargetPosition;
    }
    
    void start(final RecyclerView mRecyclerView, final LayoutManager mLayoutManager) {
        this.mRecyclerView = mRecyclerView;
        this.mLayoutManager = mLayoutManager;
        if (mTargetPosition == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        mState.mTargetPosition = mTargetPosition;
        mRunning = true;
        mPendingInitialRun = true;
        mTargetView = this.findViewByPosition(this.getTargetPosition());
        this.onStart();
        RecyclerView.access$5900(this.mRecyclerView).postOnAnimation();
    }
    
    protected final void stop() {
        if (!mRunning) {
            return;
        }
        this.onStop();
        mState.mTargetPosition = -1;
        mTargetView = null;
        mTargetPosition = -1;
        mPendingInitialRun = false;
        mRunning = false;
        mLayoutManager.onSmoothScrollerStopped(this);
        mLayoutManager = null;
        mRecyclerView = null;
    }
}
