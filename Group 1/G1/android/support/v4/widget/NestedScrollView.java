package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.widget.ScrollView;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.support.v4.view.VelocityTrackerCompat;
import android.os.Parcelable;
import android.widget.FrameLayout$LayoutParams;
import android.util.Log;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.FocusFinder;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.util.TypedValue;
import java.util.ArrayList;
import android.content.res.TypedArray;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.graphics.Rect;
import android.support.v4.view.NestedScrollingParentHelper;
import android.view.View;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.widget.FrameLayout;

public class NestedScrollView extends FrameLayout implements NestedScrollingParent, NestedScrollingChild, ScrollingView
{
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffectCompat mEdgeGlowBottom;
    private EdgeEffectCompat mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private ScrollerCompat mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    
    static {
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[] { 16843130 };
    }
    
    public NestedScrollView(final Context context) {
        this(context, null);
    }
    
    public NestedScrollView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public NestedScrollView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mTempRect = new Rect();
        mIsLayoutDirty = true;
        mIsLaidOut = false;
        mChildToScrollTo = null;
        mIsBeingDragged = false;
        mSmoothScrollingEnabled = true;
        mActivePointerId = -1;
        mScrollOffset = new int[2];
        mScrollConsumed = new int[2];
        this.initScrollView();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, SCROLLVIEW_STYLEABLE, n, 0);
        this.setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        mChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)ACCESSIBILITY_DELEGATE);
    }
    
    static /* synthetic */ int access$000(final NestedScrollView nestedScrollView) {
        return nestedScrollView.getScrollRange();
    }
    
    private boolean canScroll() {
        final View child = this.getChildAt(0);
        boolean b = false;
        if (child != null) {
            final int height = child.getHeight();
            final int height2 = this.getHeight();
            final int n = height + this.getPaddingTop() + this.getPaddingBottom();
            b = false;
            if (height2 < n) {
                b = true;
            }
        }
        return b;
    }
    
    private static int clamp(int n, final int n2, final int n3) {
        if (n2 >= n3 || n < 0) {
            n = 0;
        }
        else if (n2 + n > n3) {
            return n3 - n2;
        }
        return n;
    }
    
    private void doScrollY(final int n) {
        if (n != 0) {
            if (!mSmoothScrollingEnabled) {
                this.scrollBy(0, n);
                return;
            }
            this.smoothScrollBy(0, n);
        }
    }
    
    private void endDrag() {
        mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll();
        if (mEdgeGlowTop != null) {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        }
    }
    
    private void ensureGlows() {
        if (ViewCompat.getOverScrollMode((View)this) != 2) {
            if (mEdgeGlowTop == null) {
                final Context context = this.getContext();
                mEdgeGlowTop = new EdgeEffectCompat(context);
                mEdgeGlowBottom = new EdgeEffectCompat(context);
            }
            return;
        }
        mEdgeGlowTop = null;
        mEdgeGlowBottom = null;
    }
    
    private View findFocusableViewInBounds(final boolean b, final int n, final int n2) {
        final ArrayList focusables = this.getFocusables(2);
        View view = null;
        int n3 = 0;
        for (int size = focusables.size(), i = 0; i < size; ++i) {
            final View view2 = (View)focusables.get(i);
            final int top = view2.getTop();
            final int bottom = view2.getBottom();
            if (n < bottom && top < n2) {
                boolean b2;
                if (n < top && bottom < n2) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                if (view == null) {
                    view = view2;
                    n3 = (b2 ? 1 : 0);
                }
                else {
                    boolean b3;
                    if ((b && top < view.getTop()) || (!b && bottom > view.getBottom())) {
                        b3 = true;
                    }
                    else {
                        b3 = false;
                    }
                    if (n3 != 0) {
                        if (b2 && b3) {
                            view = view2;
                        }
                    }
                    else if (b2) {
                        view = view2;
                        n3 = 1;
                    }
                    else if (b3) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }
    
    private void flingWithNestedDispatch(final int n) {
        final int scrollY = this.getScrollY();
        final boolean b = (scrollY > 0 || n > 0) && (scrollY < this.getScrollRange() || n < 0);
        if (!this.dispatchNestedPreFling(0.0f, n)) {
            this.dispatchNestedFling(0.0f, n, b);
            if (b) {
                this.fling(n);
            }
        }
    }
    
    private int getScrollRange() {
        final int childCount = this.getChildCount();
        int max = 0;
        if (childCount > 0) {
            max = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
        }
        return max;
    }
    
    private float getVerticalScrollFactorCompat() {
        if (mVerticalScrollFactor == 0.0f) {
            final TypedValue typedValue = new TypedValue();
            final Context context = this.getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return mVerticalScrollFactor;
    }
    
    private boolean inChild(final int n, final int n2) {
        final int childCount = this.getChildCount();
        boolean b = false;
        if (childCount > 0) {
            final int scrollY = this.getScrollY();
            final View child = this.getChildAt(0);
            final int n3 = child.getTop() - scrollY;
            b = false;
            if (n2 >= n3) {
                final int n4 = child.getBottom() - scrollY;
                b = false;
                if (n2 < n4) {
                    final int left = child.getLeft();
                    b = false;
                    if (n >= left) {
                        final int right = child.getRight();
                        b = false;
                        if (n < right) {
                            b = true;
                        }
                    }
                }
            }
        }
        return b;
    }
    
    private void initOrResetVelocityTracker() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
            return;
        }
        mVelocityTracker.clear();
    }
    
    private void initScrollView() {
        mScroller = ScrollerCompat.create(this.getContext(), null);
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        final ViewConfiguration value = ViewConfiguration.get(this.getContext());
        mTouchSlop = value.getScaledTouchSlop();
        mMinimumVelocity = value.getScaledMinimumFlingVelocity();
        mMaximumVelocity = value.getScaledMaximumFlingVelocity();
    }
    
    private void initVelocityTrackerIfNotExists() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }
    
    private boolean isOffScreen(final View view) {
        final boolean withinDeltaOfScreen = this.isWithinDeltaOfScreen(view, 0, this.getHeight());
        boolean b = false;
        if (!withinDeltaOfScreen) {
            b = true;
        }
        return b;
    }
    
    private static boolean isViewDescendantOf(final View view, final View view2) {
        if (view != view2) {
            final ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || !isViewDescendantOf((View)parent, view2)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isWithinDeltaOfScreen(final View view, final int n, final int n2) {
        view.getDrawingRect(mTempRect);
        this.offsetDescendantRectToMyCoords(view, mTempRect);
        return n + mTempRect.bottom >= this.getScrollY() && mTempRect.top - n <= n2 + this.getScrollY();
    }
    
    private void onSecondaryPointerUp(final MotionEvent motionEvent) {
        final int n = (0xFF00 & motionEvent.getAction()) >> 8;
        if (MotionEventCompat.getPointerId(motionEvent, n) == mActivePointerId) {
            int n2;
            if (n == 0) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            mLastMotionY = (int)MotionEventCompat.getY(motionEvent, n2);
            mActivePointerId = MotionEventCompat.getPointerId(motionEvent, n2);
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }
    
    private void recycleVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
    
    private boolean scrollAndFocus(final int n, final int n2, final int n3) {
        boolean b = true;
        final int height = this.getHeight();
        final int scrollY = this.getScrollY();
        final int n4 = scrollY + height;
        final boolean b2 = n == 33;
        Object focusableViewInBounds = this.findFocusableViewInBounds(b2, n2, n3);
        if (focusableViewInBounds == null) {
            focusableViewInBounds = this;
        }
        if (n2 >= scrollY && n3 <= n4) {
            b = false;
        }
        else {
            int n5;
            if (b2) {
                n5 = n2 - scrollY;
            }
            else {
                n5 = n3 - n4;
            }
            this.doScrollY(n5);
        }
        if (focusableViewInBounds != this.findFocus()) {
            ((View)focusableViewInBounds).requestFocus(n);
        }
        return b;
    }
    
    private void scrollToChild(final View view) {
        view.getDrawingRect(mTempRect);
        this.offsetDescendantRectToMyCoords(view, mTempRect);
        final int computeScrollDeltaToGetChildRectOnScreen = this.computeScrollDeltaToGetChildRectOnScreen(mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            this.scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }
    
    private boolean scrollToChildRect(final Rect rect, final boolean b) {
        final int computeScrollDeltaToGetChildRectOnScreen = this.computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean b2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (b2) {
            if (!b) {
                this.smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                return b2;
            }
            this.scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
        return b2;
    }
    
    public void addView(final View view) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }
    
    public void addView(final View view, final int n) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, n);
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, n, viewGroup$LayoutParams);
    }
    
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, viewGroup$LayoutParams);
    }
    
    public boolean arrowScroll(final int n) {
        Object focus = this.findFocus();
        if (focus == this) {
            focus = null;
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, n);
        final int maxScrollAmount = this.getMaxScrollAmount();
        if (nextFocus != null && this.isWithinDeltaOfScreen(nextFocus, maxScrollAmount, this.getHeight())) {
            nextFocus.getDrawingRect(mTempRect);
            this.offsetDescendantRectToMyCoords(nextFocus, mTempRect);
            this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(mTempRect));
            nextFocus.requestFocus(n);
        }
        else {
            int scrollY = maxScrollAmount;
            if (n == 33 && this.getScrollY() < scrollY) {
                scrollY = this.getScrollY();
            }
            else if (n == 130 && this.getChildCount() > 0) {
                final int bottom = this.getChildAt(0).getBottom();
                final int n2 = this.getScrollY() + this.getHeight() - this.getPaddingBottom();
                if (bottom - n2 < maxScrollAmount) {
                    scrollY = bottom - n2;
                }
            }
            final boolean b = false;
            if (scrollY == 0) {
                return b;
            }
            int n3;
            if (n == 130) {
                n3 = scrollY;
            }
            else {
                n3 = -scrollY;
            }
            this.doScrollY(n3);
        }
        if (focus != null && ((View)focus).isFocused() && this.isOffScreen((View)focus)) {
            final int descendantFocusability = this.getDescendantFocusability();
            this.setDescendantFocusability(131072);
            this.requestFocus();
            this.setDescendantFocusability(descendantFocusability);
        }
        return true;
    }
    
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }
    
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }
    
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }
    
    public void computeScroll() {
        int n = 1;
        if (mScroller.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = mScroller.getCurrX();
            final int currY = mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                final int scrollRange = this.getScrollRange();
                final int overScrollMode = ViewCompat.getOverScrollMode((View)this);
                if (overScrollMode != 0 && (overScrollMode != n || scrollRange <= 0)) {
                    n = 0;
                }
                this.overScrollByCompat(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (n != 0) {
                    this.ensureGlows();
                    if (currY <= 0 && scrollY > 0) {
                        mEdgeGlowTop.onAbsorb((int)mScroller.getCurrVelocity());
                    }
                    else if (currY >= scrollRange && scrollY < scrollRange) {
                        mEdgeGlowBottom.onAbsorb((int)mScroller.getCurrVelocity());
                    }
                }
            }
        }
    }
    
    protected int computeScrollDeltaToGetChildRectOnScreen(final Rect rect) {
        if (this.getChildCount() != 0) {
            final int height = this.getHeight();
            int scrollY = this.getScrollY();
            int n = scrollY + height;
            final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
            if (rect.top > 0) {
                scrollY += verticalFadingEdgeLength;
            }
            if (rect.bottom < this.getChildAt(0).getHeight()) {
                n -= verticalFadingEdgeLength;
            }
            if (rect.bottom > n && rect.top > scrollY) {
                int n2;
                if (rect.height() > height) {
                    n2 = 0 + (rect.top - scrollY);
                }
                else {
                    n2 = 0 + (rect.bottom - n);
                }
                return Math.min(n2, this.getChildAt(0).getBottom() - n);
            }
            if (rect.top < scrollY && rect.bottom < n) {
                int n3;
                if (rect.height() > height) {
                    n3 = 0 - (n - rect.bottom);
                }
                else {
                    n3 = 0 - (scrollY - rect.top);
                }
                return Math.max(n3, -this.getScrollY());
            }
        }
        return 0;
    }
    
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }
    
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }
    
    public int computeVerticalScrollRange() {
        final int childCount = this.getChildCount();
        final int n = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (childCount == 0) {
            return n;
        }
        int bottom = this.getChildAt(0).getBottom();
        final int scrollY = this.getScrollY();
        final int max = Math.max(0, bottom - n);
        if (scrollY < 0) {
            bottom -= scrollY;
        }
        else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return mChildHelper.dispatchNestedFling(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return mChildHelper.dispatchNestedPreFling(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return mChildHelper.dispatchNestedPreScroll(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return mChildHelper.dispatchNestedScroll(n, n2, n3, n4, array);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (mEdgeGlowTop != null) {
            final int scrollY = this.getScrollY();
            if (!mEdgeGlowTop.isFinished()) {
                final int save = canvas.save();
                final int n = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                canvas.translate((float)this.getPaddingLeft(), (float)Math.min(0, scrollY));
                mEdgeGlowTop.setSize(n, this.getHeight());
                if (mEdgeGlowTop.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                canvas.restoreToCount(save);
            }
            if (!mEdgeGlowBottom.isFinished()) {
                final int save2 = canvas.save();
                final int n2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                final int height = this.getHeight();
                canvas.translate((float)(-n2 + this.getPaddingLeft()), (float)(height + Math.max(this.getScrollRange(), scrollY)));
                canvas.rotate(180.0f, (float)n2, 0.0f);
                mEdgeGlowBottom.setSize(n2, height);
                if (mEdgeGlowBottom.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }
    
    public boolean executeKeyEvent(final KeyEvent keyEvent) {
        mTempRect.setEmpty();
        if (!this.canScroll()) {
            final boolean focused = this.isFocused();
            boolean b = false;
            if (focused) {
                final int keyCode = keyEvent.getKeyCode();
                b = false;
                if (keyCode != 4) {
                    Object focus = this.findFocus();
                    if (focus == this) {
                        focus = null;
                    }
                    final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, 130);
                    b = false;
                    if (nextFocus != null) {
                        b = false;
                        if (nextFocus != this) {
                            final boolean requestFocus = nextFocus.requestFocus(130);
                            b = false;
                            if (requestFocus) {
                                b = true;
                            }
                        }
                    }
                }
            }
            return b;
        }
        final int action = keyEvent.getAction();
        boolean b2 = false;
        if (action == 0) {
            final int keyCode2 = keyEvent.getKeyCode();
            b2 = false;
            switch (keyCode2) {
                case 19:
                    if (!keyEvent.isAltPressed()) {
                        b2 = this.arrowScroll(33);
                        break;
                    }
                    b2 = this.fullScroll(33);
                    break;
                case 20:
                    if (!keyEvent.isAltPressed()) {
                        b2 = this.arrowScroll(130);
                        break;
                    }
                    b2 = this.fullScroll(130);
                    break;
                case 62: {
                    int n;
                    if (keyEvent.isShiftPressed()) {
                        n = 33;
                    }
                    else {
                        n = 130;
                    }
                    this.pageScroll(n);
                    b2 = false;
                    break;
                }
            }
        }
        return b2;
    }
    
    public void fling(final int n) {
        if (this.getChildCount() > 0) {
            final int n2 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
            mScroller.fling(this.getScrollX(), this.getScrollY(), 0, n, 0, 0, 0, Math.max(0, this.getChildAt(0).getHeight() - n2), 0, n2 / 2);
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public boolean fullScroll(final int n) {
        int n2;
        if (n == 130) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        final int height = this.getHeight();
        mTempRect.top = 0;
        mTempRect.bottom = height;
        if (n2 != 0) {
            final int childCount = this.getChildCount();
            if (childCount > 0) {
                mTempRect.bottom = this.getChildAt(childCount - 1).getBottom() + this.getPaddingBottom();
                mTempRect.top = mTempRect.bottom - height;
            }
        }
        return this.scrollAndFocus(n, mTempRect.top, mTempRect.bottom);
    }
    
    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        final int n = this.getChildAt(0).getBottom() - this.getScrollY() - (this.getHeight() - this.getPaddingBottom());
        if (n < verticalFadingEdgeLength) {
            return n / verticalFadingEdgeLength;
        }
        return 1.0f;
    }
    
    public int getMaxScrollAmount() {
        return (int)(0.5f * this.getHeight());
    }
    
    public int getNestedScrollAxes() {
        return mParentHelper.getNestedScrollAxes();
    }
    
    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        final int scrollY = this.getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }
    
    public boolean hasNestedScrollingParent() {
        return mChildHelper.hasNestedScrollingParent();
    }
    
    public boolean isFillViewport() {
        return mFillViewport;
    }
    
    public boolean isNestedScrollingEnabled() {
        return mChildHelper.isNestedScrollingEnabled();
    }
    
    public boolean isSmoothScrollingEnabled() {
        return mSmoothScrollingEnabled;
    }
    
    protected void measureChild(final View view, final int n, final int n2) {
        view.measure(getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight(), view.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(0, 0));
    }
    
    protected void measureChildWithMargins(final View view, final int n, final int n2, final int n3, final int n4) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(n, n2 + (this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin), viewGroup$MarginLayoutParams.width), View$MeasureSpec.makeMeasureSpec(viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin, 0));
    }
    
    public void onAttachedToWindow() {
        mIsLaidOut = false;
    }
    
    public boolean onGenericMotionEvent(final MotionEvent motionEvent) {
        if ((0x2 & MotionEventCompat.getSource(motionEvent)) != 0x0) {
            switch (motionEvent.getAction()) {
                case 8: {
                    if (mIsBeingDragged) {
                        break;
                    }
                    final float axisValue = MotionEventCompat.getAxisValue(motionEvent, 9);
                    if (axisValue == 0.0f) {
                        break;
                    }
                    final int n = (int)(axisValue * this.getVerticalScrollFactorCompat());
                    final int scrollRange = this.getScrollRange();
                    final int scrollY = this.getScrollY();
                    int n2 = scrollY - n;
                    if (n2 < 0) {
                        n2 = 0;
                    }
                    else if (n2 > scrollRange) {
                        n2 = scrollRange;
                    }
                    if (n2 != scrollY) {
                        super.scrollTo(this.getScrollX(), n2);
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (action == 2 && mIsBeingDragged) {
            return true;
        }
        switch (action & 0xFF) {
            case 2: {
                final int mActivePointerId = this.mActivePointerId;
                if (mActivePointerId == -1) {
                    break;
                }
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                if (pointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + mActivePointerId + " in onInterceptTouchEvent");
                    break;
                }
                final int mLastMotionY = (int)MotionEventCompat.getY(motionEvent, pointerIndex);
                if (Math.abs(mLastMotionY - this.mLastMotionY) <= mTouchSlop || (0x2 & this.getNestedScrollAxes()) != 0x0) {
                    break;
                }
                mIsBeingDragged = true;
                this.mLastMotionY = mLastMotionY;
                this.initVelocityTrackerIfNotExists();
                mVelocityTracker.addMovement(motionEvent);
                mNestedYOffset = 0;
                final ViewParent parent = this.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            }
            case 0: {
                final int mLastMotionY2 = (int)motionEvent.getY();
                if (!this.inChild((int)motionEvent.getX(), mLastMotionY2)) {
                    mIsBeingDragged = false;
                    this.recycleVelocityTracker();
                    break;
                }
                mLastMotionY = mLastMotionY2;
                mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.initOrResetVelocityTracker();
                mVelocityTracker.addMovement(motionEvent);
                mScroller.computeScrollOffset();
                final boolean finished = mScroller.isFinished();
                boolean mIsBeingDragged = false;
                if (!finished) {
                    mIsBeingDragged = true;
                }
                this.mIsBeingDragged = mIsBeingDragged;
                this.startNestedScroll(2);
                break;
            }
            case 1:
            case 3:
                mIsBeingDragged = false;
                mActivePointerId = -1;
                this.recycleVelocityTracker();
                if (mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                this.stopNestedScroll();
                break;
            case 6:
                this.onSecondaryPointerUp(motionEvent);
                break;
        }
        return mIsBeingDragged;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        mIsLayoutDirty = false;
        if (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, (View)this)) {
            this.scrollToChild(mChildToScrollTo);
        }
        mChildToScrollTo = null;
        if (!mIsLaidOut) {
            if (mSavedState != null) {
                this.scrollTo(this.getScrollX(), mSavedState.scrollPosition);
                mSavedState = null;
            }
            int measuredHeight;
            if (this.getChildCount() > 0) {
                measuredHeight = this.getChildAt(0).getMeasuredHeight();
            }
            else {
                measuredHeight = 0;
            }
            final int max = Math.max(0, measuredHeight - (n4 - n2 - this.getPaddingBottom() - this.getPaddingTop()));
            if (this.getScrollY() > max) {
                this.scrollTo(this.getScrollX(), max);
            }
            else if (this.getScrollY() < 0) {
                this.scrollTo(this.getScrollX(), 0);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        mIsLaidOut = true;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (mFillViewport && View$MeasureSpec.getMode(n2) != 0 && this.getChildCount() > 0) {
            final View child = this.getChildAt(0);
            final int measuredHeight = this.getMeasuredHeight();
            if (child.getMeasuredHeight() < measuredHeight) {
                child.measure(getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight(), ((FrameLayout$LayoutParams)child.getLayoutParams()).width), View$MeasureSpec.makeMeasureSpec(measuredHeight - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
            }
        }
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        if (!b) {
            this.flingWithNestedDispatch((int)n2);
            return true;
        }
        return false;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return false;
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        final int scrollY = this.getScrollY();
        this.scrollBy(0, n4);
        final int n5 = this.getScrollY() - scrollY;
        this.dispatchNestedScroll(0, n5, 0, n4 - n5, null);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        mParentHelper.onNestedScrollAccepted(view, view2, n);
        this.startNestedScroll(2);
    }
    
    protected void onOverScrolled(final int n, final int n2, final boolean b, final boolean b2) {
        super.scrollTo(n, n2);
    }
    
    protected boolean onRequestFocusInDescendants(int n, final Rect rect) {
        if (n == 2) {
            n = 130;
        }
        else if (n == 1) {
            n = 33;
        }
        View view;
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)null, n);
        }
        else {
            view = FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n);
        }
        return view != null && !this.isOffScreen(view) && view.requestFocus(n, rect);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState mSavedState = (SavedState)parcelable;
        super.onRestoreInstanceState(mSavedState.getSuperState());
        this.mSavedState = mSavedState;
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = this.getScrollY();
        return (Parcelable)savedState;
    }
    
    protected void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        if (mOnScrollChangeListener != null) {
            mOnScrollChangeListener.onScrollChange(this, n, n2, n3, n4);
        }
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        final View focus = this.findFocus();
        if (focus != null && this != focus && this.isWithinDeltaOfScreen(focus, 0, n4)) {
            focus.getDrawingRect(mTempRect);
            this.offsetDescendantRectToMyCoords(focus, mTempRect);
            this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(mTempRect));
        }
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return (n & 0x2) != 0x0;
    }
    
    public void onStopNestedScroll(final View view) {
        mParentHelper.onStopNestedScroll(view);
        this.stopNestedScroll();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.initVelocityTrackerIfNotExists();
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            mNestedYOffset = 0;
        }
        obtain.offsetLocation(0.0f, (float)mNestedYOffset);
        switch (actionMasked) {
            case 0: {
                if (this.getChildCount() == 0) {
                    return false;
                }
                final boolean mIsBeingDragged = !mScroller.isFinished();
                this.mIsBeingDragged = mIsBeingDragged;
                if (mIsBeingDragged) {
                    final ViewParent parent = this.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                mLastMotionY = (int)motionEvent.getY();
                mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.startNestedScroll(2);
                break;
            }
            case 2: {
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                if (pointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + mActivePointerId + " in onTouchEvent");
                    break;
                }
                final int n = (int)MotionEventCompat.getY(motionEvent, pointerIndex);
                int n2 = mLastMotionY - n;
                if (this.dispatchNestedPreScroll(0, n2, mScrollConsumed, mScrollOffset)) {
                    n2 -= mScrollConsumed[1];
                    obtain.offsetLocation(0.0f, (float)mScrollOffset[1]);
                    mNestedYOffset += mScrollOffset[1];
                }
                if (!mIsBeingDragged && Math.abs(n2) > mTouchSlop) {
                    final ViewParent parent2 = this.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    mIsBeingDragged = true;
                    if (n2 > 0) {
                        n2 -= mTouchSlop;
                    }
                    else {
                        n2 += mTouchSlop;
                    }
                }
                if (!mIsBeingDragged) {
                    break;
                }
                mLastMotionY = n - mScrollOffset[1];
                final int scrollY = this.getScrollY();
                final int scrollRange = this.getScrollRange();
                final int overScrollMode = ViewCompat.getOverScrollMode((View)this);
                final boolean b = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                if (this.overScrollByCompat(0, n2, 0, this.getScrollY(), 0, scrollRange, 0, 0, true) && !this.hasNestedScrollingParent()) {
                    mVelocityTracker.clear();
                }
                final int n3 = this.getScrollY() - scrollY;
                if (this.dispatchNestedScroll(0, n3, 0, n2 - n3, mScrollOffset)) {
                    mLastMotionY -= mScrollOffset[1];
                    obtain.offsetLocation(0.0f, (float)mScrollOffset[1]);
                    mNestedYOffset += mScrollOffset[1];
                    break;
                }
                if (!b) {
                    break;
                }
                this.ensureGlows();
                final int n4 = scrollY + n2;
                if (n4 < 0) {
                    mEdgeGlowTop.onPull((float)n2 / (float)this.getHeight(), MotionEventCompat.getX(motionEvent, pointerIndex) / (float)this.getWidth());
                    if (!mEdgeGlowBottom.isFinished()) {
                        mEdgeGlowBottom.onRelease();
                    }
                }
                else if (n4 > scrollRange) {
                    mEdgeGlowBottom.onPull((float)n2 / (float)this.getHeight(), 1.0f - MotionEventCompat.getX(motionEvent, pointerIndex) / this.getWidth());
                    if (!mEdgeGlowTop.isFinished()) {
                        mEdgeGlowTop.onRelease();
                    }
                }
                if (mEdgeGlowTop != null && (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished())) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                    break;
                }
                break;
            }
            case 1:
                if (mIsBeingDragged) {
                    final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                    mVelocityTracker.computeCurrentVelocity(1000, (float)mMaximumVelocity);
                    final int n5 = (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
                    if (Math.abs(n5) > mMinimumVelocity) {
                        this.flingWithNestedDispatch(-n5);
                    }
                    else if (mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation((View)this);
                    }
                }
                mActivePointerId = -1;
                this.endDrag();
                break;
            case 3:
                if (mIsBeingDragged && this.getChildCount() > 0 && mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                mActivePointerId = -1;
                this.endDrag();
                break;
            case 5: {
                final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                mLastMotionY = (int)MotionEventCompat.getY(motionEvent, actionIndex);
                mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            }
            case 6:
                this.onSecondaryPointerUp(motionEvent);
                mLastMotionY = (int)MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId));
                break;
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }
    
    boolean overScrollByCompat(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, int n7, int n8, final boolean b) {
        final int overScrollMode = ViewCompat.getOverScrollMode((View)this);
        boolean b2;
        if (this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent()) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (this.computeVerticalScrollRange() > this.computeVerticalScrollExtent()) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        int n9;
        if (overScrollMode == 0 || (overScrollMode == 1 && b2)) {
            n9 = 1;
        }
        else {
            n9 = 0;
        }
        int n10;
        if (overScrollMode == 0 || (overScrollMode == 1 && b3)) {
            n10 = 1;
        }
        else {
            n10 = 0;
        }
        int n11 = n3 + n;
        if (n9 == 0) {
            n7 = 0;
        }
        int n12 = n4 + n2;
        if (n10 == 0) {
            n8 = 0;
        }
        final int n13 = -n7;
        final int n14 = n7 + n5;
        final int n15 = -n8;
        final int n16 = n8 + n6;
        boolean b4;
        if (n11 > n14) {
            n11 = n14;
            b4 = true;
        }
        else {
            b4 = false;
            if (n11 < n13) {
                n11 = n13;
                b4 = true;
            }
        }
        boolean b5;
        if (n12 > n16) {
            n12 = n16;
            b5 = true;
        }
        else {
            b5 = false;
            if (n12 < n15) {
                n12 = n15;
                b5 = true;
            }
        }
        if (b5) {
            mScroller.springBack(n11, n12, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(n11, n12, b4, b5);
        return b4 || b5;
    }
    
    public boolean pageScroll(final int n) {
        int n2;
        if (n == 130) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        final int height = this.getHeight();
        if (n2 != 0) {
            mTempRect.top = height + this.getScrollY();
            final int childCount = this.getChildCount();
            if (childCount > 0) {
                final View child = this.getChildAt(childCount - 1);
                if (height + mTempRect.top > child.getBottom()) {
                    mTempRect.top = child.getBottom() - height;
                }
            }
        }
        else {
            mTempRect.top = this.getScrollY() - height;
            if (mTempRect.top < 0) {
                mTempRect.top = 0;
            }
        }
        mTempRect.bottom = height + mTempRect.top;
        return this.scrollAndFocus(n, mTempRect.top, mTempRect.bottom);
    }
    
    public void requestChildFocus(final View view, final View mChildToScrollTo) {
        if (!mIsLayoutDirty) {
            this.scrollToChild(mChildToScrollTo);
        }
        else {
            this.mChildToScrollTo = mChildToScrollTo;
        }
        super.requestChildFocus(view, mChildToScrollTo);
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.scrollToChildRect(rect, b);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        if (b) {
            this.recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(b);
    }
    
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
    }
    
    public void scrollTo(final int n, final int n2) {
        if (this.getChildCount() > 0) {
            final View child = this.getChildAt(0);
            final int clamp = clamp(n, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), child.getWidth());
            final int clamp2 = clamp(n2, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), child.getHeight());
            if (clamp != this.getScrollX() || clamp2 != this.getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }
    
    public void setFillViewport(final boolean mFillViewport) {
        if (mFillViewport != this.mFillViewport) {
            this.mFillViewport = mFillViewport;
            this.requestLayout();
        }
    }
    
    public void setNestedScrollingEnabled(final boolean nestedScrollingEnabled) {
        mChildHelper.setNestedScrollingEnabled(nestedScrollingEnabled);
    }
    
    public void setOnScrollChangeListener(final OnScrollChangeListener mOnScrollChangeListener) {
        this.mOnScrollChangeListener = mOnScrollChangeListener;
    }
    
    public void setSmoothScrollingEnabled(final boolean mSmoothScrollingEnabled) {
        this.mSmoothScrollingEnabled = mSmoothScrollingEnabled;
    }
    
    public boolean shouldDelayChildPressedState() {
        return true;
    }
    
    public final void smoothScrollBy(final int n, final int n2) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - mLastScroll > 250L) {
            final int max = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
            final int scrollY = this.getScrollY();
            mScroller.startScroll(this.getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + n2, max)) - scrollY);
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
        else {
            if (!mScroller.isFinished()) {
                mScroller.abortAnimation();
            }
            this.scrollBy(n, n2);
        }
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }
    
    public final void smoothScrollTo(final int n, final int n2) {
        this.smoothScrollBy(n - this.getScrollX(), n2 - this.getScrollY());
    }
    
    public boolean startNestedScroll(final int n) {
        return mChildHelper.startNestedScroll(n);
    }
    
    public void stopNestedScroll() {
        mChildHelper.stopNestedScroll();
    }
}
