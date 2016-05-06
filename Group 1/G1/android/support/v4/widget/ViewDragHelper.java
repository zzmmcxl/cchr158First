package android.support.v4.widget;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.Log;
import android.support.v4.view.ViewCompat;
import java.util.Arrays;
import android.view.ViewConfiguration;
import android.content.Context;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.Interpolator;

public class ViewDragHelper
{
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator;
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    
    static {
        sInterpolator = (Interpolator)new Interpolator() {
            ViewDragHelper$1() {
                super();
            }
            
            public float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
    }
    
    private ViewDragHelper(final Context context, final ViewGroup mParentView, final Callback mCallback) {
        super();
        mActivePointerId = -1;
        mSetIdleRunnable = new Runnable() {
            final /* synthetic */ ViewDragHelper this$0;
            
            ViewDragHelper$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.setDragState(0);
            }
        };
        if (mParentView == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (mCallback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        mParentView = mParentView;
        mCallback = mCallback;
        final ViewConfiguration value = ViewConfiguration.get(context);
        mEdgeSize = (int)(0.5f + 20.0f * context.getResources().getDisplayMetrics().density);
        mTouchSlop = value.getScaledTouchSlop();
        mMaxVelocity = value.getScaledMaximumFlingVelocity();
        mMinVelocity = value.getScaledMinimumFlingVelocity();
        mScroller = ScrollerCompat.create(context, sInterpolator);
    }
    
    private boolean checkNewEdgeDrag(final float n, final float n2, final int n3, final int n4) {
        final float abs = Math.abs(n);
        final float abs2 = Math.abs(n2);
        if ((n4 & mInitialEdgesTouched[n3]) == n4 && (n4 & mTrackingEdges) != 0x0 && (n4 & mEdgeDragsLocked[n3]) != n4 && (n4 & mEdgeDragsInProgress[n3]) != n4 && (abs > mTouchSlop || abs2 > mTouchSlop)) {
            if (abs < 0.5f * abs2 && mCallback.onEdgeLock(n4)) {
                final int[] mEdgeDragsLocked = this.mEdgeDragsLocked;
                mEdgeDragsLocked[n3] |= n4;
                return false;
            }
            if ((n4 & mEdgeDragsInProgress[n3]) == 0x0 && abs > mTouchSlop) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkTouchSlop(final View view, final float n, final float n2) {
        boolean b = true;
        if (view == null) {
            b = false;
        }
        else {
            final boolean b2 = mCallback.getViewHorizontalDragRange(view) > 0 && b;
            final boolean b3 = mCallback.getViewVerticalDragRange(view) > 0 && b;
            if (b2 && b3) {
                if (n * n + n2 * n2 <= mTouchSlop * mTouchSlop) {
                    return false;
                }
            }
            else if (b2) {
                if (Math.abs(n) <= mTouchSlop) {
                    return false;
                }
            }
            else {
                if (!b3) {
                    return false;
                }
                if (Math.abs(n2) <= mTouchSlop) {
                    return false;
                }
            }
        }
        return b;
    }
    
    private float clampMag(final float n, final float n2, float n3) {
        final float abs = Math.abs(n);
        if (abs < n2) {
            n3 = 0.0f;
        }
        else {
            if (abs <= n3) {
                return n;
            }
            if (n <= 0.0f) {
                return -n3;
            }
        }
        return n3;
    }
    
    private int clampMag(final int n, final int n2, int n3) {
        final int abs = Math.abs(n);
        if (abs < n2) {
            n3 = 0;
        }
        else {
            if (abs <= n3) {
                return n;
            }
            if (n <= 0) {
                return -n3;
            }
        }
        return n3;
    }
    
    private void clearMotionHistory() {
        if (mInitialMotionX == null) {
            return;
        }
        Arrays.fill(mInitialMotionX, 0.0f);
        Arrays.fill(mInitialMotionY, 0.0f);
        Arrays.fill(mLastMotionX, 0.0f);
        Arrays.fill(mLastMotionY, 0.0f);
        Arrays.fill(mInitialEdgesTouched, 0);
        Arrays.fill(mEdgeDragsInProgress, 0);
        Arrays.fill(mEdgeDragsLocked, 0);
        mPointersDown = 0;
    }
    
    private void clearMotionHistory(final int n) {
        if (mInitialMotionX == null) {
            return;
        }
        mInitialMotionX[n] = 0.0f;
        mInitialMotionY[n] = 0.0f;
        mLastMotionX[n] = 0.0f;
        mLastMotionY[n] = 0.0f;
        mInitialEdgesTouched[n] = 0;
        mEdgeDragsInProgress[n] = 0;
        mEdgeDragsLocked[n] = 0;
        mPointersDown &= (-1 ^ 1 << n);
    }
    
    private int computeAxisDuration(final int n, final int n2, final int n3) {
        if (n == 0) {
            return 0;
        }
        final int width = mParentView.getWidth();
        final int n4 = width / 2;
        final float n5 = n4 + n4 * this.distanceInfluenceForSnapDuration(Math.min(1.0f, (float)Math.abs(n) / (float)width));
        final int abs = Math.abs(n2);
        int n6;
        if (abs > 0) {
            n6 = 4 * Math.round(1000.0f * Math.abs(n5 / (float)abs));
        }
        else {
            n6 = (int)(256.0f * (1.0f + Math.abs(n) / n3));
        }
        return Math.min(n6, 600);
    }
    
    private int computeSettleDuration(final View view, final int n, final int n2, final int n3, final int n4) {
        final int clampMag = this.clampMag(n3, (int)mMinVelocity, (int)mMaxVelocity);
        final int clampMag2 = this.clampMag(n4, (int)mMinVelocity, (int)mMaxVelocity);
        final int abs = Math.abs(n);
        final int abs2 = Math.abs(n2);
        final int abs3 = Math.abs(clampMag);
        final int abs4 = Math.abs(clampMag2);
        final int n5 = abs3 + abs4;
        final int n6 = abs + abs2;
        float n7;
        if (clampMag != 0) {
            n7 = abs3 / n5;
        }
        else {
            n7 = abs / n6;
        }
        float n8;
        if (clampMag2 != 0) {
            n8 = abs4 / n5;
        }
        else {
            n8 = abs2 / n6;
        }
        return (int)(n7 * this.computeAxisDuration(n, clampMag, mCallback.getViewHorizontalDragRange(view)) + n8 * this.computeAxisDuration(n2, clampMag2, mCallback.getViewVerticalDragRange(view)));
    }
    
    public static ViewDragHelper create(final ViewGroup viewGroup, final float n, final Callback callback) {
        final ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop *= 1.0f / n;
        return create;
    }
    
    public static ViewDragHelper create(final ViewGroup viewGroup, final Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }
    
    private void dispatchViewReleased(final float n, final float n2) {
        mReleaseInProgress = true;
        mCallback.onViewReleased(mCapturedView, n, n2);
        mReleaseInProgress = false;
        if (mDragState == 1) {
            this.setDragState(0);
        }
    }
    
    private float distanceInfluenceForSnapDuration(final float n) {
        return (float)Math.sin(0.4712389167638204 * (n - 0.5f));
    }
    
    private void dragTo(final int n, final int n2, final int n3, final int n4) {
        int clampViewPositionHorizontal = n;
        int clampViewPositionVertical = n2;
        final int left = mCapturedView.getLeft();
        final int top = mCapturedView.getTop();
        if (n3 != 0) {
            clampViewPositionHorizontal = mCallback.clampViewPositionHorizontal(mCapturedView, n, n3);
            ViewCompat.offsetLeftAndRight(mCapturedView, clampViewPositionHorizontal - left);
        }
        if (n4 != 0) {
            clampViewPositionVertical = mCallback.clampViewPositionVertical(mCapturedView, n2, n4);
            ViewCompat.offsetTopAndBottom(mCapturedView, clampViewPositionVertical - top);
        }
        if (n3 != 0 || n4 != 0) {
            mCallback.onViewPositionChanged(mCapturedView, clampViewPositionHorizontal, clampViewPositionVertical, clampViewPositionHorizontal - left, clampViewPositionVertical - top);
        }
    }
    
    private void ensureMotionHistorySizeForId(final int n) {
        if (mInitialMotionX == null || mInitialMotionX.length <= n) {
            final float[] mInitialMotionX = new float[n + 1];
            final float[] mInitialMotionY = new float[n + 1];
            final float[] mLastMotionX = new float[n + 1];
            final float[] mLastMotionY = new float[n + 1];
            final int[] mInitialEdgesTouched = new int[n + 1];
            final int[] mEdgeDragsInProgress = new int[n + 1];
            final int[] mEdgeDragsLocked = new int[n + 1];
            if (this.mInitialMotionX != null) {
                System.arraycopy(this.mInitialMotionX, 0, mInitialMotionX, 0, this.mInitialMotionX.length);
                System.arraycopy(this.mInitialMotionY, 0, mInitialMotionY, 0, this.mInitialMotionY.length);
                System.arraycopy(this.mLastMotionX, 0, mLastMotionX, 0, this.mLastMotionX.length);
                System.arraycopy(this.mLastMotionY, 0, mLastMotionY, 0, this.mLastMotionY.length);
                System.arraycopy(this.mInitialEdgesTouched, 0, mInitialEdgesTouched, 0, this.mInitialEdgesTouched.length);
                System.arraycopy(this.mEdgeDragsInProgress, 0, mEdgeDragsInProgress, 0, this.mEdgeDragsInProgress.length);
                System.arraycopy(this.mEdgeDragsLocked, 0, mEdgeDragsLocked, 0, this.mEdgeDragsLocked.length);
            }
            this.mInitialMotionX = mInitialMotionX;
            this.mInitialMotionY = mInitialMotionY;
            this.mLastMotionX = mLastMotionX;
            this.mLastMotionY = mLastMotionY;
            this.mInitialEdgesTouched = mInitialEdgesTouched;
            this.mEdgeDragsInProgress = mEdgeDragsInProgress;
            this.mEdgeDragsLocked = mEdgeDragsLocked;
        }
    }
    
    private boolean forceSettleCapturedViewAt(final int n, final int n2, final int n3, final int n4) {
        final int left = mCapturedView.getLeft();
        final int top = mCapturedView.getTop();
        final int n5 = n - left;
        final int n6 = n2 - top;
        if (n5 == 0 && n6 == 0) {
            mScroller.abortAnimation();
            this.setDragState(0);
            return false;
        }
        mScroller.startScroll(left, top, n5, n6, this.computeSettleDuration(mCapturedView, n5, n6, n3, n4));
        this.setDragState(2);
        return true;
    }
    
    private int getEdgesTouched(final int n, final int n2) {
        final int n3 = mParentView.getLeft() + mEdgeSize;
        int n4 = 0;
        if (n < n3) {
            n4 = ((false | true) ? 1 : 0);
        }
        if (n2 < mParentView.getTop() + mEdgeSize) {
            n4 |= 0x4;
        }
        if (n > mParentView.getRight() - mEdgeSize) {
            n4 |= 0x2;
        }
        if (n2 > mParentView.getBottom() - mEdgeSize) {
            n4 |= 0x8;
        }
        return n4;
    }
    
    private boolean isValidPointerForActionMove(final int n) {
        if (!this.isPointerDown(n)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + n + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }
    
    private void releaseViewForPointerUp() {
        mVelocityTracker.computeCurrentVelocity(1000, mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), mMinVelocity, mMaxVelocity), this.clampMag(VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId), mMinVelocity, mMaxVelocity));
    }
    
    private void reportNewEdgeDrags(final float n, final float n2, final int n3) {
        final boolean checkNewEdgeDrag = this.checkNewEdgeDrag(n, n2, n3, 1);
        int n4 = 0;
        if (checkNewEdgeDrag) {
            n4 = ((false | true) ? 1 : 0);
        }
        if (this.checkNewEdgeDrag(n2, n, n3, 4)) {
            n4 |= 0x4;
        }
        if (this.checkNewEdgeDrag(n, n2, n3, 2)) {
            n4 |= 0x2;
        }
        if (this.checkNewEdgeDrag(n2, n, n3, 8)) {
            n4 |= 0x8;
        }
        if (n4 != 0) {
            final int[] mEdgeDragsInProgress = this.mEdgeDragsInProgress;
            mEdgeDragsInProgress[n3] |= n4;
            mCallback.onEdgeDragStarted(n4, n3);
        }
    }
    
    private void saveInitialMotion(final float n, final float n2, final int n3) {
        this.ensureMotionHistorySizeForId(n3);
        mInitialMotionX[n3] = (mLastMotionX[n3] = n);
        mInitialMotionY[n3] = (mLastMotionY[n3] = n2);
        mInitialEdgesTouched[n3] = this.getEdgesTouched((int)n, (int)n2);
        mPointersDown |= 1 << n3;
    }
    
    private void saveLastMotion(final MotionEvent motionEvent) {
        for (int pointerCount = MotionEventCompat.getPointerCount(motionEvent), i = 0; i < pointerCount; ++i) {
            final int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            final float x = MotionEventCompat.getX(motionEvent, i);
            final float y = MotionEventCompat.getY(motionEvent, i);
            mLastMotionX[pointerId] = x;
            mLastMotionY[pointerId] = y;
        }
    }
    
    public void abort() {
        this.cancel();
        if (mDragState == 2) {
            final int currX = mScroller.getCurrX();
            final int currY = mScroller.getCurrY();
            mScroller.abortAnimation();
            final int currX2 = mScroller.getCurrX();
            final int currY2 = mScroller.getCurrY();
            mCallback.onViewPositionChanged(mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        this.setDragState(0);
    }
    
    protected boolean canScroll(final View view, final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = -1 + viewGroup.getChildCount(); i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (n3 + scrollX >= child.getLeft() && n3 + scrollX < child.getRight() && n4 + scrollY >= child.getTop() && n4 + scrollY < child.getBottom() && this.canScroll(child, true, n, n2, n3 + scrollX - child.getLeft(), n4 + scrollY - child.getTop())) {
                    return true;
                }
            }
        }
        return b && (ViewCompat.canScrollHorizontally(view, -n) || ViewCompat.canScrollVertically(view, -n2));
    }
    
    public void cancel() {
        mActivePointerId = -1;
        this.clearMotionHistory();
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
    
    public void captureChildView(final View mCapturedView, final int mActivePointerId) {
        if (mCapturedView.getParent() != mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + mParentView + ")");
        }
        this.mCapturedView = mCapturedView;
        this.mActivePointerId = mActivePointerId;
        mCallback.onViewCaptured(mCapturedView, mActivePointerId);
        this.setDragState(1);
    }
    
    public boolean checkTouchSlop(final int n) {
        for (int length = mInitialMotionX.length, i = 0; i < length; ++i) {
            if (this.checkTouchSlop(n, i)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkTouchSlop(final int n, final int n2) {
        boolean b = true;
        if (!this.isPointerDown(n2)) {
            b = false;
        }
        else {
            final boolean b2 = (n & 0x1) == (b ? 1 : 0) && b;
            final boolean b3 = (n & 0x2) == 0x2 && b;
            final float n3 = mLastMotionX[n2] - mInitialMotionX[n2];
            final float n4 = mLastMotionY[n2] - mInitialMotionY[n2];
            if (b2 && b3) {
                if (n3 * n3 + n4 * n4 <= mTouchSlop * mTouchSlop) {
                    return false;
                }
            }
            else if (b2) {
                if (Math.abs(n3) <= mTouchSlop) {
                    return false;
                }
            }
            else {
                if (!b3) {
                    return false;
                }
                if (Math.abs(n4) <= mTouchSlop) {
                    return false;
                }
            }
        }
        return b;
    }
    
    public boolean continueSettling(final boolean b) {
        if (mDragState == 2) {
            int computeScrollOffset = mScroller.computeScrollOffset() ? 1 : 0;
            final int currX = mScroller.getCurrX();
            final int currY = mScroller.getCurrY();
            final int n = currX - mCapturedView.getLeft();
            final int n2 = currY - mCapturedView.getTop();
            if (n != 0) {
                ViewCompat.offsetLeftAndRight(mCapturedView, n);
            }
            if (n2 != 0) {
                ViewCompat.offsetTopAndBottom(mCapturedView, n2);
            }
            if (n != 0 || n2 != 0) {
                mCallback.onViewPositionChanged(mCapturedView, currX, currY, n, n2);
            }
            if (computeScrollOffset != 0 && currX == mScroller.getFinalX() && currY == mScroller.getFinalY()) {
                mScroller.abortAnimation();
                computeScrollOffset = 0;
            }
            if (computeScrollOffset == 0) {
                if (b) {
                    mParentView.post(mSetIdleRunnable);
                }
                else {
                    this.setDragState(0);
                }
            }
        }
        return mDragState == 2;
    }
    
    public View findTopChildUnder(final int n, final int n2) {
        for (int i = -1 + mParentView.getChildCount(); i >= 0; --i) {
            final View child = mParentView.getChildAt(mCallback.getOrderedChildIndex(i));
            if (n >= child.getLeft() && n < child.getRight() && n2 >= child.getTop() && n2 < child.getBottom()) {
                return child;
            }
        }
        return null;
    }
    
    public void flingCapturedView(final int n, final int n2, final int n3, final int n4) {
        if (!mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        mScroller.fling(mCapturedView.getLeft(), mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId), n, n3, n2, n4);
        this.setDragState(2);
    }
    
    public int getActivePointerId() {
        return mActivePointerId;
    }
    
    public View getCapturedView() {
        return mCapturedView;
    }
    
    public int getEdgeSize() {
        return mEdgeSize;
    }
    
    public float getMinVelocity() {
        return mMinVelocity;
    }
    
    public int getTouchSlop() {
        return mTouchSlop;
    }
    
    public int getViewDragState() {
        return mDragState;
    }
    
    public boolean isCapturedViewUnder(final int n, final int n2) {
        return this.isViewUnder(mCapturedView, n, n2);
    }
    
    public boolean isEdgeTouched(final int n) {
        for (int length = mInitialEdgesTouched.length, i = 0; i < length; ++i) {
            if (this.isEdgeTouched(n, i)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEdgeTouched(final int n, final int n2) {
        return this.isPointerDown(n2) && (n & mInitialEdgesTouched[n2]) != 0x0;
    }
    
    public boolean isPointerDown(final int n) {
        return (mPointersDown & 1 << n) != 0x0;
    }
    
    public boolean isViewUnder(final View view, final int n, final int n2) {
        return view != null && n >= view.getLeft() && n < view.getRight() && n2 >= view.getTop() && n2 < view.getBottom();
    }
    
    public void processTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.cancel();
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                final int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                final View topChildUnder = this.findTopChildUnder((int)x, (int)y);
                this.saveInitialMotion(x, y, pointerId);
                this.tryCaptureViewForDrag(topChildUnder, pointerId);
                final int n = mInitialEdgesTouched[pointerId];
                if ((n & mTrackingEdges) != 0x0) {
                    mCallback.onEdgeTouched(n & mTrackingEdges, pointerId);
                    return;
                }
                break;
            }
            case 5: {
                final int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                final float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                final float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                this.saveInitialMotion(x2, y2, pointerId2);
                if (mDragState == 0) {
                    this.tryCaptureViewForDrag(this.findTopChildUnder((int)x2, (int)y2), pointerId2);
                    final int n2 = mInitialEdgesTouched[pointerId2];
                    if ((n2 & mTrackingEdges) != 0x0) {
                        mCallback.onEdgeTouched(n2 & mTrackingEdges, pointerId2);
                        return;
                    }
                    break;
                }
                else {
                    if (this.isCapturedViewUnder((int)x2, (int)y2)) {
                        this.tryCaptureViewForDrag(mCapturedView, pointerId2);
                        return;
                    }
                    break;
                }
                break;
            }
            case 2:
                if (mDragState != 1) {
                    for (int pointerCount = MotionEventCompat.getPointerCount(motionEvent), i = 0; i < pointerCount; ++i) {
                        final int pointerId3 = MotionEventCompat.getPointerId(motionEvent, i);
                        if (this.isValidPointerForActionMove(pointerId3)) {
                            final float x3 = MotionEventCompat.getX(motionEvent, i);
                            final float y3 = MotionEventCompat.getY(motionEvent, i);
                            final float n3 = x3 - mInitialMotionX[pointerId3];
                            final float n4 = y3 - mInitialMotionY[pointerId3];
                            this.reportNewEdgeDrags(n3, n4, pointerId3);
                            if (mDragState == 1) {
                                break;
                            }
                            final View topChildUnder2 = this.findTopChildUnder((int)x3, (int)y3);
                            if (this.checkTouchSlop(topChildUnder2, n3, n4) && this.tryCaptureViewForDrag(topChildUnder2, pointerId3)) {
                                break;
                            }
                        }
                    }
                    this.saveLastMotion(motionEvent);
                    return;
                }
                if (this.isValidPointerForActionMove(mActivePointerId)) {
                    final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                    final float x4 = MotionEventCompat.getX(motionEvent, pointerIndex);
                    final float y4 = MotionEventCompat.getY(motionEvent, pointerIndex);
                    final int n5 = (int)(x4 - mLastMotionX[mActivePointerId]);
                    final int n6 = (int)(y4 - mLastMotionY[mActivePointerId]);
                    this.dragTo(n5 + mCapturedView.getLeft(), n6 + mCapturedView.getTop(), n5, n6);
                    this.saveLastMotion(motionEvent);
                    return;
                }
                break;
            case 6: {
                final int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (mDragState == 1 && pointerId4 == mActivePointerId) {
                    int mActivePointerId = -1;
                    for (int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent), j = 0; j < pointerCount2; ++j) {
                        final int pointerId5 = MotionEventCompat.getPointerId(motionEvent, j);
                        if (pointerId5 != this.mActivePointerId && this.findTopChildUnder((int)MotionEventCompat.getX(motionEvent, j), (int)MotionEventCompat.getY(motionEvent, j)) == mCapturedView && this.tryCaptureViewForDrag(mCapturedView, pointerId5)) {
                            mActivePointerId = this.mActivePointerId;
                            break;
                        }
                    }
                    if (mActivePointerId == -1) {
                        this.releaseViewForPointerUp();
                    }
                }
                this.clearMotionHistory(pointerId4);
            }
            case 1:
                if (mDragState == 1) {
                    this.releaseViewForPointerUp();
                }
                this.cancel();
            case 3:
                if (mDragState == 1) {
                    this.dispatchViewReleased(0.0f, 0.0f);
                }
                this.cancel();
        }
    }
    
    void setDragState(final int mDragState) {
        mParentView.removeCallbacks(mSetIdleRunnable);
        if (this.mDragState != mDragState) {
            this.mDragState = mDragState;
            mCallback.onViewDragStateChanged(mDragState);
            if (this.mDragState == 0) {
                mCapturedView = null;
            }
        }
    }
    
    public void setEdgeTrackingEnabled(final int mTrackingEdges) {
        this.mTrackingEdges = mTrackingEdges;
    }
    
    public void setMinVelocity(final float mMinVelocity) {
        this.mMinVelocity = mMinVelocity;
    }
    
    public boolean settleCapturedViewAt(final int n, final int n2) {
        if (!mReleaseInProgress) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return this.forceSettleCapturedViewAt(n, n2, (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId));
    }
    
    public boolean shouldInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.cancel();
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                final int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.saveInitialMotion(x, y, pointerId);
                final View topChildUnder = this.findTopChildUnder((int)x, (int)y);
                if (topChildUnder == mCapturedView && mDragState == 2) {
                    this.tryCaptureViewForDrag(topChildUnder, pointerId);
                }
                final int n = mInitialEdgesTouched[pointerId];
                if ((n & mTrackingEdges) != 0x0) {
                    mCallback.onEdgeTouched(n & mTrackingEdges, pointerId);
                    break;
                }
                break;
            }
            case 5: {
                final int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                final float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                final float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                this.saveInitialMotion(x2, y2, pointerId2);
                if (mDragState == 0) {
                    final int n2 = mInitialEdgesTouched[pointerId2];
                    if ((n2 & mTrackingEdges) != 0x0) {
                        mCallback.onEdgeTouched(n2 & mTrackingEdges, pointerId2);
                        break;
                    }
                    break;
                }
                else {
                    if (mDragState != 2) {
                        break;
                    }
                    final View topChildUnder2 = this.findTopChildUnder((int)x2, (int)y2);
                    if (topChildUnder2 == mCapturedView) {
                        this.tryCaptureViewForDrag(topChildUnder2, pointerId2);
                        break;
                    }
                    break;
                }
                break;
            }
            case 2:
                if (mInitialMotionX != null && mInitialMotionY != null) {
                    for (int pointerCount = MotionEventCompat.getPointerCount(motionEvent), i = 0; i < pointerCount; ++i) {
                        final int pointerId3 = MotionEventCompat.getPointerId(motionEvent, i);
                        if (this.isValidPointerForActionMove(pointerId3)) {
                            final float x3 = MotionEventCompat.getX(motionEvent, i);
                            final float y3 = MotionEventCompat.getY(motionEvent, i);
                            final float n3 = x3 - mInitialMotionX[pointerId3];
                            final float n4 = y3 - mInitialMotionY[pointerId3];
                            final View topChildUnder3 = this.findTopChildUnder((int)x3, (int)y3);
                            boolean b;
                            if (topChildUnder3 != null && this.checkTouchSlop(topChildUnder3, n3, n4)) {
                                b = true;
                            }
                            else {
                                b = false;
                            }
                            if (b) {
                                final int left = topChildUnder3.getLeft();
                                final int clampViewPositionHorizontal = mCallback.clampViewPositionHorizontal(topChildUnder3, left + (int)n3, (int)n3);
                                final int top = topChildUnder3.getTop();
                                final int clampViewPositionVertical = mCallback.clampViewPositionVertical(topChildUnder3, top + (int)n4, (int)n4);
                                final int viewHorizontalDragRange = mCallback.getViewHorizontalDragRange(topChildUnder3);
                                final int viewVerticalDragRange = mCallback.getViewVerticalDragRange(topChildUnder3);
                                if ((viewHorizontalDragRange == 0 || (viewHorizontalDragRange > 0 && clampViewPositionHorizontal == left)) && (viewVerticalDragRange == 0 || (viewVerticalDragRange > 0 && clampViewPositionVertical == top))) {
                                    break;
                                }
                            }
                            this.reportNewEdgeDrags(n3, n4, pointerId3);
                            if (mDragState == 1) {
                                break;
                            }
                            if (b && this.tryCaptureViewForDrag(topChildUnder3, pointerId3)) {
                                break;
                            }
                        }
                    }
                    this.saveLastMotion(motionEvent);
                    break;
                }
                break;
            case 6:
                this.clearMotionHistory(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                break;
            case 1:
            case 3:
                this.cancel();
                break;
        }
        return mDragState == 1;
    }
    
    public boolean smoothSlideViewTo(final View mCapturedView, final int n, final int n2) {
        this.mCapturedView = mCapturedView;
        mActivePointerId = -1;
        final boolean forceSettleCapturedView = this.forceSettleCapturedViewAt(n, n2, 0, 0);
        if (!forceSettleCapturedView && mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedView;
    }
    
    boolean tryCaptureViewForDrag(final View view, final int mActivePointerId) {
        if (view == mCapturedView && this.mActivePointerId == mActivePointerId) {
            return true;
        }
        if (view != null && mCallback.tryCaptureView(view, mActivePointerId)) {
            this.captureChildView(view, this.mActivePointerId = mActivePointerId);
            return true;
        }
        return false;
    }
}
