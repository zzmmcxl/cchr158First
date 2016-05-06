package android.support.design.widget;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.NonNull;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.support.v4.view.NestedScrollingChild;
import android.content.res.TypedArray;
import android.view.ViewConfiguration;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.VelocityTracker;
import java.lang.ref.WeakReference;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;

public class BottomSheetBehavior<V extends View> extends Behavior<V>
{
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private int mActivePointerId;
    private BottomSheetCallback mCallback;
    private final ViewDragHelper.Callback mDragCallback;
    private boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastNestedScrollDy;
    private int mMaxOffset;
    private float mMaximumVelocity;
    private int mMinOffset;
    private boolean mNestedScrolled;
    private WeakReference<View> mNestedScrollingChildRef;
    private int mParentHeight;
    private int mPeekHeight;
    private int mState;
    private boolean mTouchingScrollingChild;
    private VelocityTracker mVelocityTracker;
    private ViewDragHelper mViewDragHelper;
    private WeakReference<V> mViewRef;
    
    public BottomSheetBehavior() {
        super();
        mState = 4;
        mDragCallback = new ViewDragHelper.Callback() {
            final /* synthetic */ BottomSheetBehavior this$0;
            
            BottomSheetBehavior$1(final BottomSheetBehavior this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
                return view.getLeft();
            }
            
            @Override
            public int clampViewPositionVertical(final View view, final int n, final int n2) {
                final int access$700 = mMinOffset;
                int n3;
                if (mHideable) {
                    n3 = mParentHeight;
                }
                else {
                    n3 = mMaxOffset;
                }
                return MathUtils.constrain(n, access$700, n3);
            }
            
            @Override
            public int getViewVerticalDragRange(final View view) {
                if (mHideable) {
                    return mParentHeight - mMinOffset;
                }
                return mMaxOffset - mMinOffset;
            }
            
            @Override
            public void onViewDragStateChanged(final int n) {
                if (n == 1) {
                    this$0.setStateInternal(1);
                }
            }
            
            @Override
            public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
                this$0.dispatchOnSlide(n2);
            }
            
            @Override
            public void onViewReleased(final View view, final float n, final float n2) {
                int n3;
                int n4;
                if (n2 < 0.0f) {
                    n3 = mMinOffset;
                    n4 = 3;
                }
                else if (mHideable && this$0.shouldHide(view, n2)) {
                    n3 = mParentHeight;
                    n4 = 5;
                }
                else if (n2 == 0.0f) {
                    final int top = view.getTop();
                    if (Math.abs(top - mMinOffset) < Math.abs(top - mMaxOffset)) {
                        n3 = mMinOffset;
                        n4 = 3;
                    }
                    else {
                        n3 = mMaxOffset;
                        n4 = 4;
                    }
                }
                else {
                    n3 = mMaxOffset;
                    n4 = 4;
                }
                if (mViewDragHelper.settleCapturedViewAt(view.getLeft(), n3)) {
                    this$0.setStateInternal(2);
                    ViewCompat.postOnAnimation(view, this$0.new SettleRunnable(view, n4));
                    return;
                }
                this$0.setStateInternal(n4);
            }
            
            @Override
            public boolean tryCaptureView(final View view, final int n) {
                boolean b = true;
                if (mState != (b ? 1 : 0) && !mTouchingScrollingChild) {
                    if (mState == 3 && this$0.mActivePointerId == n) {
                        final View view2 = (View)mNestedScrollingChildRef.get();
                        if (view2 != null && ViewCompat.canScrollVertically(view2, -1)) {
                            return false;
                        }
                    }
                    if (mViewRef == null || mViewRef.get() != view) {
                        b = false;
                    }
                    return b;
                }
                return false;
            }
        };
    }
    
    public BottomSheetBehavior(final Context context, final AttributeSet set) {
        super(context, set);
        mState = 4;
        mDragCallback = new ViewDragHelper.Callback() {
            final /* synthetic */ BottomSheetBehavior this$0;
            
            BottomSheetBehavior$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
                return view.getLeft();
            }
            
            @Override
            public int clampViewPositionVertical(final View view, final int n, final int n2) {
                final int access$700 = mMinOffset;
                int n3;
                if (mHideable) {
                    n3 = mParentHeight;
                }
                else {
                    n3 = mMaxOffset;
                }
                return MathUtils.constrain(n, access$700, n3);
            }
            
            @Override
            public int getViewVerticalDragRange(final View view) {
                if (mHideable) {
                    return mParentHeight - mMinOffset;
                }
                return mMaxOffset - mMinOffset;
            }
            
            @Override
            public void onViewDragStateChanged(final int n) {
                if (n == 1) {
                    this$0.setStateInternal(1);
                }
            }
            
            @Override
            public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
                this$0.dispatchOnSlide(n2);
            }
            
            @Override
            public void onViewReleased(final View view, final float n, final float n2) {
                int n3;
                int n4;
                if (n2 < 0.0f) {
                    n3 = mMinOffset;
                    n4 = 3;
                }
                else if (mHideable && this$0.shouldHide(view, n2)) {
                    n3 = mParentHeight;
                    n4 = 5;
                }
                else if (n2 == 0.0f) {
                    final int top = view.getTop();
                    if (Math.abs(top - mMinOffset) < Math.abs(top - mMaxOffset)) {
                        n3 = mMinOffset;
                        n4 = 3;
                    }
                    else {
                        n3 = mMaxOffset;
                        n4 = 4;
                    }
                }
                else {
                    n3 = mMaxOffset;
                    n4 = 4;
                }
                if (mViewDragHelper.settleCapturedViewAt(view.getLeft(), n3)) {
                    this$0.setStateInternal(2);
                    ViewCompat.postOnAnimation(view, this$0.new SettleRunnable(view, n4));
                    return;
                }
                this$0.setStateInternal(n4);
            }
            
            @Override
            public boolean tryCaptureView(final View view, final int n) {
                boolean b = true;
                if (mState != (b ? 1 : 0) && !mTouchingScrollingChild) {
                    if (mState == 3 && this$0.mActivePointerId == n) {
                        final View view2 = (View)mNestedScrollingChildRef.get();
                        if (view2 != null && ViewCompat.canScrollVertically(view2, -1)) {
                            return false;
                        }
                    }
                    if (mViewRef == null || mViewRef.get() != view) {
                        b = false;
                    }
                    return b;
                }
                return false;
            }
        };
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.BottomSheetBehavior_Params);
        this.setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        this.setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Params_behavior_hideable, false));
        obtainStyledAttributes.recycle();
        mMaximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
    
    static /* synthetic */ int access$000(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mState;
    }
    
    static /* synthetic */ boolean access$100(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mTouchingScrollingChild;
    }
    
    static /* synthetic */ int access$1000(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mParentHeight;
    }
    
    static /* synthetic */ int access$1100(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mMaxOffset;
    }
    
    static /* synthetic */ ViewDragHelper access$1200(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mViewDragHelper;
    }
    
    static /* synthetic */ int access$200(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mActivePointerId;
    }
    
    static /* synthetic */ WeakReference access$300(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mNestedScrollingChildRef;
    }
    
    static /* synthetic */ WeakReference access$400(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mViewRef;
    }
    
    static /* synthetic */ void access$500(final BottomSheetBehavior bottomSheetBehavior, final int n) {
        bottomSheetBehavior.dispatchOnSlide(n);
    }
    
    static /* synthetic */ void access$600(final BottomSheetBehavior bottomSheetBehavior, final int stateInternal) {
        bottomSheetBehavior.setStateInternal(stateInternal);
    }
    
    static /* synthetic */ int access$700(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mMinOffset;
    }
    
    static /* synthetic */ boolean access$800(final BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.mHideable;
    }
    
    static /* synthetic */ boolean access$900(final BottomSheetBehavior bottomSheetBehavior, final View view, final float n) {
        return bottomSheetBehavior.shouldHide(view, n);
    }
    
    private void dispatchOnSlide(final int n) {
        final View view = (View)mViewRef.get();
        if (view != null && mCallback != null) {
            if (n <= mMaxOffset) {
                mCallback.onSlide(view, (float)(mMaxOffset - n) / (float)(mMaxOffset - mMinOffset));
                return;
            }
            mCallback.onSlide(view, (float)(mMaxOffset - n) / (float)mPeekHeight);
        }
    }
    
    private View findScrollingChild(final View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                final View scrollingChild = this.findScrollingChild(viewGroup.getChildAt(i));
                if (scrollingChild != null) {
                    return scrollingChild;
                }
            }
        }
        return null;
    }
    
    public static <V extends View> BottomSheetBehavior<V> from(final V v) {
        final ViewGroup$LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        final Behavior behavior = ((LayoutParams)layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior<V>)behavior;
    }
    
    private float getYVelocity() {
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
        return VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
    }
    
    private void reset() {
        mActivePointerId = -1;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
    
    private void setStateInternal(final int mState) {
        if (this.mState != mState) {
            this.mState = mState;
            final View view = (View)mViewRef.get();
            if (view != null && mCallback != null) {
                mCallback.onStateChanged(view, mState);
            }
        }
    }
    
    private boolean shouldHide(final View view, final float n) {
        return view.getTop() >= mMaxOffset && Math.abs(view.getTop() + 0.1f * n - (float)mMaxOffset) / mPeekHeight > 0.5f;
    }
    
    public final int getPeekHeight() {
        return mPeekHeight;
    }
    
    public final int getState() {
        return mState;
    }
    
    public boolean isHideable() {
        return mHideable;
    }
    
    @Override
    public boolean onInterceptTouchEvent(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
        boolean mTouchingScrollingChild = true;
        if (!v.isShown()) {
            return false;
        }
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.reset();
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 1:
            case 3:
                this.mTouchingScrollingChild = false;
                mActivePointerId = -1;
                if (mIgnoreEvents) {
                    return mIgnoreEvents = false;
                }
                break;
            case 0: {
                final int n = (int)motionEvent.getX();
                mInitialY = (int)motionEvent.getY();
                final View view = (View)mNestedScrollingChildRef.get();
                if (view != null && coordinatorLayout.isPointInChildBounds(view, n, mInitialY)) {
                    mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.mTouchingScrollingChild = mTouchingScrollingChild;
                }
                mIgnoreEvents = (mActivePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, n, mInitialY) && mTouchingScrollingChild);
                break;
            }
        }
        if (!mIgnoreEvents && mViewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return mTouchingScrollingChild;
        }
        final View view2 = (View)mNestedScrollingChildRef.get();
        if (actionMasked != 2 || view2 == null || mIgnoreEvents || mState == (mTouchingScrollingChild ? 1 : 0) || coordinatorLayout.isPointInChildBounds(view2, (int)motionEvent.getX(), (int)motionEvent.getY()) || Math.abs((float)mInitialY - motionEvent.getY()) <= mViewDragHelper.getTouchSlop()) {
            mTouchingScrollingChild = false;
        }
        return mTouchingScrollingChild;
    }
    
    @Override
    public boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final V v, final int n) {
        if (mState != 1 && mState != 2) {
            coordinatorLayout.onLayoutChild(v, n);
        }
        mParentHeight = coordinatorLayout.getHeight();
        mMinOffset = Math.max(0, mParentHeight - v.getHeight());
        mMaxOffset = Math.max(mParentHeight - mPeekHeight, mMinOffset);
        if (mState == 3) {
            ViewCompat.offsetTopAndBottom(v, mMinOffset);
        }
        else if (mHideable && mState == 5) {
            ViewCompat.offsetTopAndBottom(v, mParentHeight);
        }
        else if (mState == 4) {
            ViewCompat.offsetTopAndBottom(v, mMaxOffset);
        }
        if (mViewDragHelper == null) {
            mViewDragHelper = ViewDragHelper.create(coordinatorLayout, mDragCallback);
        }
        mViewRef = new WeakReference<V>(v);
        mNestedScrollingChildRef = new WeakReference<View>(this.findScrollingChild(v));
        return true;
    }
    
    @Override
    public boolean onNestedPreFling(final CoordinatorLayout coordinatorLayout, final V v, final View view, final float n, final float n2) {
        return view == mNestedScrollingChildRef.get() && (mState != 3 || super.onNestedPreFling(coordinatorLayout, v, view, n, n2));
    }
    
    @Override
    public void onNestedPreScroll(final CoordinatorLayout coordinatorLayout, final V v, final View view, final int n, final int mLastNestedScrollDy, final int[] array) {
        if (view != mNestedScrollingChildRef.get()) {
            return;
        }
        final int top = v.getTop();
        final int n2 = top - mLastNestedScrollDy;
        if (mLastNestedScrollDy > 0) {
            if (n2 < mMinOffset) {
                array[1] = top - mMinOffset;
                ViewCompat.offsetTopAndBottom(v, -array[1]);
                this.setStateInternal(3);
            }
            else {
                ViewCompat.offsetTopAndBottom(v, -(array[1] = mLastNestedScrollDy));
                this.setStateInternal(1);
            }
        }
        else if (mLastNestedScrollDy < 0 && !ViewCompat.canScrollVertically(view, -1)) {
            if (n2 <= mMaxOffset || mHideable) {
                ViewCompat.offsetTopAndBottom(v, -(array[1] = mLastNestedScrollDy));
                this.setStateInternal(1);
            }
            else {
                array[1] = top - mMaxOffset;
                ViewCompat.offsetTopAndBottom(v, -array[1]);
                this.setStateInternal(4);
            }
        }
        this.dispatchOnSlide(v.getTop());
        this.mLastNestedScrollDy = mLastNestedScrollDy;
        mNestedScrolled = true;
    }
    
    @Override
    public void onRestoreInstanceState(final CoordinatorLayout coordinatorLayout, final V v, final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            mState = 4;
            return;
        }
        mState = savedState.state;
    }
    
    @Override
    public Parcelable onSaveInstanceState(final CoordinatorLayout coordinatorLayout, final V v) {
        return (Parcelable)new SavedState(super.onSaveInstanceState(coordinatorLayout, v), mState);
    }
    
    @Override
    public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final V v, final View view, final View view2, final int n) {
        mLastNestedScrollDy = 0;
        mNestedScrolled = false;
        final int n2 = n & 0x2;
        boolean b = false;
        if (n2 != 0) {
            b = true;
        }
        return b;
    }
    
    @Override
    public void onStopNestedScroll(final CoordinatorLayout coordinatorLayout, final V v, final View view) {
        if (v.getTop() == mMinOffset) {
            this.setStateInternal(3);
        }
        else if (view == mNestedScrollingChildRef.get() && mNestedScrolled) {
            int n;
            int stateInternal;
            if (mLastNestedScrollDy > 0) {
                n = mMinOffset;
                stateInternal = 3;
            }
            else if (mHideable && this.shouldHide(v, this.getYVelocity())) {
                n = mParentHeight;
                stateInternal = 5;
            }
            else if (mLastNestedScrollDy == 0) {
                final int top = v.getTop();
                if (Math.abs(top - mMinOffset) < Math.abs(top - mMaxOffset)) {
                    n = mMinOffset;
                    stateInternal = 3;
                }
                else {
                    n = mMaxOffset;
                    stateInternal = 4;
                }
            }
            else {
                n = mMaxOffset;
                stateInternal = 4;
            }
            if (mViewDragHelper.smoothSlideViewTo(v, v.getLeft(), n)) {
                this.setStateInternal(2);
                ViewCompat.postOnAnimation(v, new SettleRunnable((View)v, stateInternal));
            }
            else {
                this.setStateInternal(stateInternal);
            }
            mNestedScrolled = false;
        }
    }
    
    @Override
    public boolean onTouchEvent(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
        boolean b = true;
        if (!v.isShown()) {
            b = false;
        }
        else {
            final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (mState != (b ? 1 : 0) || actionMasked != 0) {
                mViewDragHelper.processTouchEvent(motionEvent);
                if (actionMasked == 0) {
                    this.reset();
                }
                if (mVelocityTracker == null) {
                    mVelocityTracker = VelocityTracker.obtain();
                }
                mVelocityTracker.addMovement(motionEvent);
                if (actionMasked == 2 && Math.abs((float)mInitialY - motionEvent.getY()) > mViewDragHelper.getTouchSlop()) {
                    mViewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
                    return b;
                }
            }
        }
        return b;
    }
    
    public void setBottomSheetCallback(final BottomSheetCallback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void setHideable(final boolean mHideable) {
        this.mHideable = mHideable;
    }
    
    public final void setPeekHeight(final int n) {
        mPeekHeight = Math.max(0, n);
        mMaxOffset = mParentHeight - n;
    }
    
    public final void setState(final int n) {
        final View view = (View)mViewRef.get();
        if (view != null) {
            int n2;
            if (n == 4) {
                n2 = mMaxOffset;
            }
            else if (n == 3) {
                n2 = mMinOffset;
            }
            else {
                if (!mHideable || n != 5) {
                    throw new IllegalArgumentException("Illegal state argument: " + n);
                }
                n2 = mParentHeight;
            }
            this.setStateInternal(2);
            if (mViewDragHelper.smoothSlideViewTo(view, view.getLeft(), n2)) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, n));
            }
        }
    }
}
