package android.support.design.widget;

import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.MotionEventCompat;
import android.view.ViewConfiguration;
import android.view.MotionEvent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.support.v4.widget.ScrollerCompat;
import android.view.View;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V>
{
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private ScrollerCompat mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    
    public HeaderBehavior() {
        super();
        mActivePointerId = -1;
        mTouchSlop = -1;
    }
    
    public HeaderBehavior(final Context context, final AttributeSet set) {
        super(context, set);
        mActivePointerId = -1;
        mTouchSlop = -1;
    }
    
    static /* synthetic */ ScrollerCompat access$000(final HeaderBehavior headerBehavior) {
        return headerBehavior.mScroller;
    }
    
    private void ensureVelocityTracker() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }
    
    boolean canDragView(final V v) {
        return false;
    }
    
    final boolean fling(final CoordinatorLayout coordinatorLayout, final V v, final int n, final int n2, final float n3) {
        if (mFlingRunnable != null) {
            v.removeCallbacks(mFlingRunnable);
            mFlingRunnable = null;
        }
        if (mScroller == null) {
            mScroller = ScrollerCompat.create(v.getContext());
        }
        mScroller.fling(0, this.getTopAndBottomOffset(), 0, Math.round(n3), 0, 0, n, n2);
        if (mScroller.computeScrollOffset()) {
            ViewCompat.postOnAnimation(v, mFlingRunnable = new FlingRunnable(coordinatorLayout, v));
            return true;
        }
        this.onFlingFinished(coordinatorLayout, v);
        return false;
    }
    
    int getMaxDragOffset(final V v) {
        return -v.getHeight();
    }
    
    int getScrollRangeForDragFling(final V v) {
        return v.getHeight();
    }
    
    int getTopBottomOffsetForScrollingSibling() {
        return this.getTopAndBottomOffset();
    }
    
    void onFlingFinished(final CoordinatorLayout coordinatorLayout, final V v) {
    }
    
    @Override
    public boolean onInterceptTouchEvent(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
        if (mTouchSlop < 0) {
            mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && mIsBeingDragged) {
            return true;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0: {
                mIsBeingDragged = false;
                final int n = (int)motionEvent.getX();
                final int mLastMotionY = (int)motionEvent.getY();
                if (this.canDragView(v) && coordinatorLayout.isPointInChildBounds(v, n, mLastMotionY)) {
                    this.mLastMotionY = mLastMotionY;
                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.ensureVelocityTracker();
                    break;
                }
                break;
            }
            case 2: {
                final int mActivePointerId = this.mActivePointerId;
                if (mActivePointerId == -1) {
                    break;
                }
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                if (pointerIndex == -1) {
                    break;
                }
                final int mLastMotionY2 = (int)MotionEventCompat.getY(motionEvent, pointerIndex);
                if (Math.abs(mLastMotionY2 - mLastMotionY) > mTouchSlop) {
                    mIsBeingDragged = true;
                    mLastMotionY = mLastMotionY2;
                    break;
                }
                break;
            }
            case 1:
            case 3:
                mIsBeingDragged = false;
                mActivePointerId = -1;
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                    break;
                }
                break;
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.addMovement(motionEvent);
        }
        return mIsBeingDragged;
    }
    
    @Override
    public boolean onTouchEvent(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
        if (mTouchSlop < 0) {
            mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0: {
                final int n = (int)motionEvent.getX();
                final int mLastMotionY = (int)motionEvent.getY();
                if (coordinatorLayout.isPointInChildBounds(v, n, mLastMotionY) && this.canDragView(v)) {
                    this.mLastMotionY = mLastMotionY;
                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.ensureVelocityTracker();
                    break;
                }
                return false;
            }
            case 2: {
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                if (pointerIndex == -1) {
                    return false;
                }
                final int mLastMotionY2 = (int)MotionEventCompat.getY(motionEvent, pointerIndex);
                int n2 = mLastMotionY - mLastMotionY2;
                if (!mIsBeingDragged && Math.abs(n2) > mTouchSlop) {
                    mIsBeingDragged = true;
                    if (n2 > 0) {
                        n2 -= mTouchSlop;
                    }
                    else {
                        n2 += mTouchSlop;
                    }
                }
                if (mIsBeingDragged) {
                    mLastMotionY = mLastMotionY2;
                    this.scroll(coordinatorLayout, v, n2, this.getMaxDragOffset(v), 0);
                    break;
                }
                break;
            }
            case 1:
                if (mVelocityTracker != null) {
                    mVelocityTracker.addMovement(motionEvent);
                    mVelocityTracker.computeCurrentVelocity(1000);
                    this.fling(coordinatorLayout, v, -this.getScrollRangeForDragFling(v), 0, VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId));
                }
            case 3:
                mIsBeingDragged = false;
                mActivePointerId = -1;
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                    break;
                }
                break;
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.addMovement(motionEvent);
        }
        return true;
    }
    
    final int scroll(final CoordinatorLayout coordinatorLayout, final V v, final int n, final int n2, final int n3) {
        return this.setHeaderTopBottomOffset(coordinatorLayout, v, this.getTopBottomOffsetForScrollingSibling() - n, n2, n3);
    }
    
    int setHeaderTopBottomOffset(final CoordinatorLayout coordinatorLayout, final V v, final int n) {
        return this.setHeaderTopBottomOffset(coordinatorLayout, v, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    int setHeaderTopBottomOffset(final CoordinatorLayout coordinatorLayout, final V v, final int n, final int n2, final int n3) {
        final int topAndBottomOffset = this.getTopAndBottomOffset();
        int n4 = 0;
        if (n2 != 0) {
            n4 = 0;
            if (topAndBottomOffset >= n2) {
                n4 = 0;
                if (topAndBottomOffset <= n3) {
                    final int constrain = MathUtils.constrain(n, n2, n3);
                    n4 = 0;
                    if (topAndBottomOffset != constrain) {
                        this.setTopAndBottomOffset(constrain);
                        n4 = topAndBottomOffset - constrain;
                    }
                }
            }
        }
        return n4;
    }
}
