package android.support.v7.widget;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import android.view.View;
import android.view.View$OnTouchListener;

public abstract static class ForwardingListener implements View$OnTouchListener
{
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    private final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;
    private boolean mWasLongPress;
    
    public ForwardingListener(final View mSrc) {
        super();
        this.mTmpLocation = new int[2];
        this.mSrc = mSrc;
        this.mScaledTouchSlop = ViewConfiguration.get(mSrc.getContext()).getScaledTouchSlop();
        this.mTapTimeout = ViewConfiguration.getTapTimeout();
        this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }
    
    static /* synthetic */ void access$1000(final ForwardingListener forwardingListener) {
        forwardingListener.onLongPress();
    }
    
    static /* synthetic */ View access$900(final ForwardingListener forwardingListener) {
        return forwardingListener.mSrc;
    }
    
    private void clearCallbacks() {
        if (mTriggerLongPress != null) {
            mSrc.removeCallbacks(mTriggerLongPress);
        }
        if (mDisallowIntercept != null) {
            mSrc.removeCallbacks(mDisallowIntercept);
        }
    }
    
    private void onLongPress() {
        this.clearCallbacks();
        final View mSrc = this.mSrc;
        if (mSrc.isEnabled() && !mSrc.isLongClickable() && this.onForwardingStarted()) {
            mSrc.getParent().requestDisallowInterceptTouchEvent(true);
            final long uptimeMillis = SystemClock.uptimeMillis();
            final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            mSrc.onTouchEvent(obtain);
            obtain.recycle();
            mForwarding = true;
            mWasLongPress = true;
        }
    }
    
    private boolean onTouchForwarded(final MotionEvent motionEvent) {
        boolean b = true;
        final View mSrc = this.mSrc;
        final ListPopupWindow popup = this.getPopup();
        if (popup != null && popup.isShowing()) {
            final DropDownListView access$600 = ListPopupWindow.access$600(popup);
            if (access$600 != null && access$600.isShown()) {
                final MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                this.toGlobalMotionEvent(mSrc, obtainNoHistory);
                this.toLocalMotionEvent((View)access$600, obtainNoHistory);
                final boolean onForwardedEvent = access$600.onForwardedEvent(obtainNoHistory, mActivePointerId);
                obtainNoHistory.recycle();
                final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                final boolean b2 = actionMasked != (b ? 1 : 0) && actionMasked != 3 && b;
                if (!onForwardedEvent || !b2) {
                    b = false;
                }
                return b;
            }
        }
        return false;
    }
    
    private boolean onTouchObserved(final MotionEvent motionEvent) {
        final View mSrc = this.mSrc;
        if (mSrc.isEnabled()) {
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                default:
                    return false;
                case 0:
                    mActivePointerId = motionEvent.getPointerId(0);
                    mWasLongPress = false;
                    if (mDisallowIntercept == null) {
                        mDisallowIntercept = new DisallowIntercept(this);
                    }
                    mSrc.postDelayed(mDisallowIntercept, (long)mTapTimeout);
                    if (mTriggerLongPress == null) {
                        mTriggerLongPress = new TriggerLongPress(this);
                    }
                    mSrc.postDelayed(mTriggerLongPress, (long)mLongPressTimeout);
                    return false;
                case 2: {
                    final int pointerIndex = motionEvent.findPointerIndex(mActivePointerId);
                    if (pointerIndex >= 0 && !pointInView(mSrc, motionEvent.getX(pointerIndex), motionEvent.getY(pointerIndex), mScaledTouchSlop)) {
                        this.clearCallbacks();
                        mSrc.getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                    break;
                }
                case 1:
                case 3:
                    this.clearCallbacks();
                    return false;
            }
        }
        return false;
    }
    
    private static boolean pointInView(final View view, final float n, final float n2, final float n3) {
        return n >= -n3 && n2 >= -n3 && n < n3 + (view.getRight() - view.getLeft()) && n2 < n3 + (view.getBottom() - view.getTop());
    }
    
    private boolean toGlobalMotionEvent(final View view, final MotionEvent motionEvent) {
        final int[] mTmpLocation = this.mTmpLocation;
        view.getLocationOnScreen(mTmpLocation);
        motionEvent.offsetLocation((float)mTmpLocation[0], (float)mTmpLocation[1]);
        return true;
    }
    
    private boolean toLocalMotionEvent(final View view, final MotionEvent motionEvent) {
        final int[] mTmpLocation = this.mTmpLocation;
        view.getLocationOnScreen(mTmpLocation);
        motionEvent.offsetLocation((float)(-mTmpLocation[0]), (float)(-mTmpLocation[1]));
        return true;
    }
    
    public abstract ListPopupWindow getPopup();
    
    protected boolean onForwardingStarted() {
        final ListPopupWindow popup = this.getPopup();
        if (popup != null && !popup.isShowing()) {
            popup.show();
        }
        return true;
    }
    
    protected boolean onForwardingStopped() {
        final ListPopupWindow popup = this.getPopup();
        if (popup != null && popup.isShowing()) {
            popup.dismiss();
        }
        return true;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final boolean mForwarding = this.mForwarding;
        boolean onTouchForwarded;
        if (mForwarding) {
            if (mWasLongPress) {
                onTouchForwarded = this.onTouchForwarded(motionEvent);
            }
            else {
                onTouchForwarded = (this.onTouchForwarded(motionEvent) || !this.onForwardingStopped());
            }
        }
        else {
            onTouchForwarded = (this.onTouchObserved(motionEvent) && this.onForwardingStarted());
            if (onTouchForwarded) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                mSrc.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        if (!(this.mForwarding = onTouchForwarded)) {
            final boolean b = false;
            if (!mForwarding) {
                return b;
            }
        }
        return true;
    }
}
