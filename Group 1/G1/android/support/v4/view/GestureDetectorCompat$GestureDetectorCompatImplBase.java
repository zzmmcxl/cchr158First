package android.support.v4.view;

import android.os.Message;
import android.content.Context;
import android.view.ViewConfiguration;
import android.view.VelocityTracker;
import android.view.GestureDetector$OnGestureListener;
import android.os.Handler;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;

static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl
{
    private static final int DOUBLE_TAP_TIMEOUT = 0;
    private static final int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private MotionEvent mCurrentDownEvent;
    private boolean mDeferConfirmSingleTap;
    private GestureDetector$OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    private final GestureDetector$OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    
    static {
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    }
    
    public GestureDetectorCompatImplBase(final Context context, final GestureDetector$OnGestureListener mListener, final Handler handler) {
        super();
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        }
        else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = mListener;
        if (mListener instanceof GestureDetector$OnDoubleTapListener) {
            this.setOnDoubleTapListener((GestureDetector$OnDoubleTapListener)mListener);
        }
        this.init(context);
    }
    
    static /* synthetic */ MotionEvent access$000(final GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        return gestureDetectorCompatImplBase.mCurrentDownEvent;
    }
    
    static /* synthetic */ GestureDetector$OnGestureListener access$100(final GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        return gestureDetectorCompatImplBase.mListener;
    }
    
    static /* synthetic */ void access$200(final GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        gestureDetectorCompatImplBase.dispatchLongPress();
    }
    
    static /* synthetic */ GestureDetector$OnDoubleTapListener access$300(final GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        return gestureDetectorCompatImplBase.mDoubleTapListener;
    }
    
    static /* synthetic */ boolean access$400(final GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        return gestureDetectorCompatImplBase.mStillDown;
    }
    
    static /* synthetic */ boolean access$502(final GestureDetectorCompatImplBase gestureDetectorCompatImplBase, final boolean mDeferConfirmSingleTap) {
        return gestureDetectorCompatImplBase.mDeferConfirmSingleTap = mDeferConfirmSingleTap;
    }
    
    private void cancel() {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mStillDown = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        mDeferConfirmSingleTap = false;
        if (mInLongPress) {
            mInLongPress = false;
        }
    }
    
    private void cancelTaps() {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mIsDoubleTapping = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        mDeferConfirmSingleTap = false;
        if (mInLongPress) {
            mInLongPress = false;
        }
    }
    
    private void dispatchLongPress() {
        mHandler.removeMessages(3);
        mDeferConfirmSingleTap = false;
        mInLongPress = true;
        mListener.onLongPress(mCurrentDownEvent);
    }
    
    private void init(final Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (mListener == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        }
        mIsLongpressEnabled = true;
        final ViewConfiguration value = ViewConfiguration.get(context);
        final int scaledTouchSlop = value.getScaledTouchSlop();
        final int scaledDoubleTapSlop = value.getScaledDoubleTapSlop();
        mMinimumFlingVelocity = value.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = value.getScaledMaximumFlingVelocity();
        mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }
    
    private boolean isConsideredDoubleTap(final MotionEvent motionEvent, final MotionEvent motionEvent2, final MotionEvent motionEvent3) {
        if (mAlwaysInBiggerTapRegion && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= DOUBLE_TAP_TIMEOUT) {
            final int n = (int)motionEvent.getX() - (int)motionEvent3.getX();
            final int n2 = (int)motionEvent.getY() - (int)motionEvent3.getY();
            if (n * n + n2 * n2 < mDoubleTapSlopSquare) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isLongpressEnabled() {
        return mIsLongpressEnabled;
    }
    
    @Override
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        boolean b;
        if ((action & 0xFF) == 0x6) {
            b = true;
        }
        else {
            b = false;
        }
        int actionIndex;
        if (b) {
            actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        }
        else {
            actionIndex = -1;
        }
        float n = 0.0f;
        float n2 = 0.0f;
        final int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; ++i) {
            if (actionIndex != i) {
                n += MotionEventCompat.getX(motionEvent, i);
                n2 += MotionEventCompat.getY(motionEvent, i);
            }
        }
        int n3;
        if (b) {
            n3 = pointerCount - 1;
        }
        else {
            n3 = pointerCount;
        }
        final float n4 = n / n3;
        final float n5 = n2 / n3;
        final int n6 = action & 0xFF;
        boolean onScroll = false;
        Label_0200: {
            switch (n6) {
                case 5:
                    mLastFocusX = n4;
                    mDownFocusX = n4;
                    mLastFocusY = n5;
                    mDownFocusY = n5;
                    this.cancelTaps();
                    return false;
                case 6: {
                    mLastFocusX = n4;
                    mDownFocusX = n4;
                    mLastFocusY = n5;
                    mDownFocusY = n5;
                    mVelocityTracker.computeCurrentVelocity(1000, (float)mMaximumFlingVelocity);
                    final int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                    final int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                    final float xVelocity = VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId);
                    final float yVelocity = VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId);
                    int n7 = 0;
                    while (true) {
                        final int n8 = n7;
                        onScroll = false;
                        if (n8 >= pointerCount) {
                            break Label_0200;
                        }
                        if (n7 != actionIndex2) {
                            final int pointerId2 = MotionEventCompat.getPointerId(motionEvent, n7);
                            if (xVelocity * VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId2) + yVelocity * VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId2) < 0.0f) {
                                break;
                            }
                        }
                        ++n7;
                    }
                    mVelocityTracker.clear();
                    return false;
                }
                case 0: {
                    final GestureDetector$OnDoubleTapListener mDoubleTapListener = this.mDoubleTapListener;
                    boolean b2 = false;
                    if (mDoubleTapListener != null) {
                        final boolean hasMessages = mHandler.hasMessages(3);
                        if (hasMessages) {
                            mHandler.removeMessages(3);
                        }
                        if (mCurrentDownEvent != null && mPreviousUpEvent != null && hasMessages && this.isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, motionEvent)) {
                            mIsDoubleTapping = true;
                            b2 = (false | this.mDoubleTapListener.onDoubleTap(mCurrentDownEvent) | this.mDoubleTapListener.onDoubleTapEvent(motionEvent));
                        }
                        else {
                            mHandler.sendEmptyMessageDelayed(3, (long)DOUBLE_TAP_TIMEOUT);
                            b2 = false;
                        }
                    }
                    mLastFocusX = n4;
                    mDownFocusX = n4;
                    mLastFocusY = n5;
                    mDownFocusY = n5;
                    if (mCurrentDownEvent != null) {
                        mCurrentDownEvent.recycle();
                    }
                    mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    mAlwaysInTapRegion = true;
                    mAlwaysInBiggerTapRegion = true;
                    mStillDown = true;
                    mInLongPress = false;
                    mDeferConfirmSingleTap = false;
                    if (mIsLongpressEnabled) {
                        mHandler.removeMessages(2);
                        mHandler.sendEmptyMessageAtTime(2, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + (long)LONGPRESS_TIMEOUT);
                    }
                    mHandler.sendEmptyMessageAtTime(1, mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT);
                    return b2 | mListener.onDown(motionEvent);
                }
                case 2: {
                    final boolean mInLongPress = this.mInLongPress;
                    onScroll = false;
                    if (mInLongPress) {
                        break;
                    }
                    final float n9 = mLastFocusX - n4;
                    final float n10 = mLastFocusY - n5;
                    if (mIsDoubleTapping) {
                        return false | mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    }
                    if (!mAlwaysInTapRegion) {
                        if (Math.abs(n9) < 1.0f) {
                            final float n11 = fcmpl(Math.abs(n10), 1.0f);
                            onScroll = false;
                            if (n11 < 0) {
                                break;
                            }
                        }
                        final boolean onScroll2 = mListener.onScroll(mCurrentDownEvent, motionEvent, n9, n10);
                        mLastFocusX = n4;
                        mLastFocusY = n5;
                        return onScroll2;
                    }
                    final int n12 = (int)(n4 - mDownFocusX);
                    final int n13 = (int)(n5 - mDownFocusY);
                    final int n14 = n12 * n12 + n13 * n13;
                    final int mTouchSlopSquare = this.mTouchSlopSquare;
                    onScroll = false;
                    if (n14 > mTouchSlopSquare) {
                        onScroll = mListener.onScroll(mCurrentDownEvent, motionEvent, n9, n10);
                        mLastFocusX = n4;
                        mLastFocusY = n5;
                        mAlwaysInTapRegion = false;
                        mHandler.removeMessages(3);
                        mHandler.removeMessages(1);
                        mHandler.removeMessages(2);
                    }
                    if (n14 > this.mTouchSlopSquare) {
                        mAlwaysInBiggerTapRegion = false;
                        return onScroll;
                    }
                    break;
                }
                case 1: {
                    mStillDown = false;
                    final MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    boolean b3 = false;
                    Label_0943: {
                        if (mIsDoubleTapping) {
                            b3 = (false | mDoubleTapListener.onDoubleTapEvent(motionEvent));
                        }
                        else if (mInLongPress) {
                            mHandler.removeMessages(3);
                            mInLongPress = false;
                            b3 = false;
                        }
                        else if (mAlwaysInTapRegion) {
                            b3 = mListener.onSingleTapUp(motionEvent);
                            if (mDeferConfirmSingleTap && mDoubleTapListener != null) {
                                mDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                        }
                        else {
                            final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                            final int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
                            mVelocityTracker.computeCurrentVelocity(1000, (float)mMaximumFlingVelocity);
                            final float yVelocity2 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId3);
                            final float xVelocity2 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId3);
                            if (Math.abs(yVelocity2) <= mMinimumFlingVelocity) {
                                final float n15 = fcmpl(Math.abs(xVelocity2), (float)mMinimumFlingVelocity);
                                b3 = false;
                                if (n15 <= 0) {
                                    break Label_0943;
                                }
                            }
                            b3 = mListener.onFling(mCurrentDownEvent, motionEvent, xVelocity2, yVelocity2);
                        }
                    }
                    if (mPreviousUpEvent != null) {
                        mPreviousUpEvent.recycle();
                    }
                    mPreviousUpEvent = obtain;
                    if (mVelocityTracker != null) {
                        mVelocityTracker.recycle();
                        mVelocityTracker = null;
                    }
                    mIsDoubleTapping = false;
                    mDeferConfirmSingleTap = false;
                    mHandler.removeMessages(1);
                    mHandler.removeMessages(2);
                    return b3;
                }
                case 3:
                    this.cancel();
                    return false;
            }
        }
        return onScroll;
    }
    
    @Override
    public void setIsLongpressEnabled(final boolean mIsLongpressEnabled) {
        this.mIsLongpressEnabled = mIsLongpressEnabled;
    }
    
    @Override
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener mDoubleTapListener) {
        this.mDoubleTapListener = mDoubleTapListener;
    }
}
