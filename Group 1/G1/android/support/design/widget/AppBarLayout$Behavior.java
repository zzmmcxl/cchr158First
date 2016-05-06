package android.support.design.widget;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import android.support.v4.view.ViewCompat;
import java.util.List;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public static class Behavior extends HeaderBehavior<AppBarLayout>
{
    private static final int ANIMATE_OFFSET_DIPS_PER_SECOND = 300;
    private static final int INVALID_POSITION = -1;
    private ValueAnimatorCompat mAnimator;
    private WeakReference<View> mLastNestedScrollingChildRef;
    private int mOffsetDelta;
    private int mOffsetToChildIndexOnLayout;
    private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
    private float mOffsetToChildIndexOnLayoutPerc;
    private DragCallback mOnDragCallback;
    private boolean mSkipNestedPreScroll;
    private boolean mWasNestedFlung;
    
    public Behavior() {
        super();
        this.mOffsetToChildIndexOnLayout = -1;
    }
    
    public Behavior(final Context context, final AttributeSet set) {
        super(context, set);
        this.mOffsetToChildIndexOnLayout = -1;
    }
    
    static /* synthetic */ int access$1000(final Behavior behavior) {
        return behavior.mOffsetDelta;
    }
    
    private void animateOffsetTo(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n) {
        final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
        if (topBottomOffsetForScrollingSibling == n) {
            if (mAnimator != null && mAnimator.isRunning()) {
                mAnimator.cancel();
            }
            return;
        }
        if (mAnimator == null) {
            (mAnimator = ViewUtils.createAnimator()).setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            mAnimator.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                final /* synthetic */ Behavior this$0;
                final /* synthetic */ AppBarLayout val$child;
                final /* synthetic */ CoordinatorLayout val$coordinatorLayout;
                
                AppBarLayout$Behavior$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                    this$0.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, valueAnimatorCompat.getAnimatedIntValue());
                }
            });
        }
        else {
            mAnimator.cancel();
        }
        mAnimator.setDuration(Math.round(1000.0f * (Math.abs(topBottomOffsetForScrollingSibling - n) / coordinatorLayout.getResources().getDisplayMetrics().density) / 300.0f));
        mAnimator.setIntValues(topBottomOffsetForScrollingSibling, n);
        mAnimator.start();
    }
    
    private void dispatchOffsetUpdates(final AppBarLayout appBarLayout) {
        final List access$800 = AppBarLayout.access$800(appBarLayout);
        for (int i = 0; i < access$800.size(); ++i) {
            final OnOffsetChangedListener onOffsetChangedListener = (OnOffsetChangedListener)access$800.get(i);
            if (onOffsetChangedListener != null) {
                onOffsetChangedListener.onOffsetChanged(appBarLayout, this.getTopAndBottomOffset());
            }
        }
    }
    
    private View getChildOnOffset(final AppBarLayout appBarLayout, final int n) {
        for (int i = 0; i < appBarLayout.getChildCount(); ++i) {
            final View child = appBarLayout.getChildAt(i);
            if (child.getTop() <= -n && child.getBottom() >= -n) {
                return child;
            }
        }
        return null;
    }
    
    private int interpolateOffset(final AppBarLayout appBarLayout, int n) {
        final int abs = Math.abs(n);
        int i = 0;
        while (i < appBarLayout.getChildCount()) {
            final View child = appBarLayout.getChildAt(i);
            final AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)child.getLayoutParams();
            final Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
            if (abs >= child.getTop() && abs <= child.getBottom()) {
                if (scrollInterpolator == null) {
                    break;
                }
                final int scrollFlags = layoutParams.getScrollFlags();
                final int n2 = scrollFlags & 0x1;
                int n3 = 0;
                if (n2 != 0) {
                    n3 = 0 + (child.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                    if ((scrollFlags & 0x2) != 0x0) {
                        n3 -= ViewCompat.getMinimumHeight(child);
                    }
                }
                if (ViewCompat.getFitsSystemWindows(child)) {
                    n3 -= AppBarLayout.access$900(appBarLayout);
                }
                if (n3 > 0) {
                    n = Integer.signum(n) * (Math.round((float)n3 * scrollInterpolator.getInterpolation((float)(abs - child.getTop()) / (float)n3)) + child.getTop());
                    break;
                }
                break;
            }
            else {
                ++i;
            }
        }
        return n;
    }
    
    private void snapToChildIfNeeded(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
        final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
        final View childOnOffset = this.getChildOnOffset(appBarLayout, topBottomOffsetForScrollingSibling);
        if (childOnOffset != null) {
            final AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)childOnOffset.getLayoutParams();
            if ((0x11 & layoutParams.getScrollFlags()) == 0x11) {
                final int n = -childOnOffset.getTop();
                int n2 = -childOnOffset.getBottom();
                if ((0x2 & layoutParams.getScrollFlags()) == 0x2) {
                    n2 += ViewCompat.getMinimumHeight(childOnOffset);
                }
                int n3;
                if (topBottomOffsetForScrollingSibling < (n2 + n) / 2) {
                    n3 = n2;
                }
                else {
                    n3 = n;
                }
                this.animateOffsetTo(coordinatorLayout, appBarLayout, MathUtils.constrain(n3, -appBarLayout.getTotalScrollRange(), 0));
            }
        }
    }
    
    @Override
    boolean canDragView(final AppBarLayout appBarLayout) {
        boolean canDrag = true;
        if (mOnDragCallback != null) {
            canDrag = mOnDragCallback.canDrag(appBarLayout);
        }
        else if (mLastNestedScrollingChildRef != null) {
            final View view = (View)mLastNestedScrollingChildRef.get();
            if (view == null || !view.isShown() || ViewCompat.canScrollVertically(view, -1)) {
                return false;
            }
        }
        return canDrag;
    }
    
    @Override
    /* bridge */ boolean canDragView(final View view) {
        return this.canDragView((AppBarLayout)view);
    }
    
    @Override
    public /* bridge */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }
    
    @Override
    int getMaxDragOffset(final AppBarLayout appBarLayout) {
        return -AppBarLayout.access$400(appBarLayout);
    }
    
    @Override
    /* bridge */ int getMaxDragOffset(final View view) {
        return this.getMaxDragOffset((AppBarLayout)view);
    }
    
    @Override
    int getScrollRangeForDragFling(final AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange();
    }
    
    @Override
    /* bridge */ int getScrollRangeForDragFling(final View view) {
        return this.getScrollRangeForDragFling((AppBarLayout)view);
    }
    
    @Override
    public /* bridge */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }
    
    @Override
    int getTopBottomOffsetForScrollingSibling() {
        return this.getTopAndBottomOffset() + mOffsetDelta;
    }
    
    @Override
    void onFlingFinished(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
        this.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
    }
    
    @Override
    /* bridge */ void onFlingFinished(final CoordinatorLayout coordinatorLayout, final View view) {
        this.onFlingFinished(coordinatorLayout, (AppBarLayout)view);
    }
    
    @Override
    public boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n) {
        final boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, n);
        final int access$500 = AppBarLayout.access$500(appBarLayout);
        if (access$500 != 0) {
            boolean b;
            if ((access$500 & 0x4) != 0x0) {
                b = true;
            }
            else {
                b = false;
            }
            if ((access$500 & 0x2) != 0x0) {
                final int n2 = -AppBarLayout.access$300(appBarLayout);
                if (b) {
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, n2);
                }
                else {
                    this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, n2);
                }
            }
            else if ((access$500 & 0x1) != 0x0) {
                if (b) {
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, 0);
                }
                else {
                    this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                }
            }
        }
        else if (mOffsetToChildIndexOnLayout >= 0) {
            final View child = appBarLayout.getChildAt(mOffsetToChildIndexOnLayout);
            final int n3 = -child.getBottom();
            int topAndBottomOffset;
            if (mOffsetToChildIndexOnLayoutIsMinHeight) {
                topAndBottomOffset = n3 + ViewCompat.getMinimumHeight(child);
            }
            else {
                topAndBottomOffset = n3 + Math.round((float)child.getHeight() * mOffsetToChildIndexOnLayoutPerc);
            }
            this.setTopAndBottomOffset(topAndBottomOffset);
        }
        AppBarLayout.access$600(appBarLayout);
        mOffsetToChildIndexOnLayout = -1;
        this.setTopAndBottomOffset(MathUtils.constrain(this.getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
        this.dispatchOffsetUpdates(appBarLayout);
        return onLayoutChild;
    }
    
    @Override
    public /* bridge */ boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final View view, final int n) {
        return this.onLayoutChild(coordinatorLayout, (AppBarLayout)view, n);
    }
    
    public boolean onNestedFling(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final float n, final float n2, final boolean b) {
        boolean fling;
        if (!b) {
            fling = this.fling(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -n2);
        }
        else if (n2 < 0.0f) {
            final int n3 = -appBarLayout.getTotalScrollRange() + AppBarLayout.access$200(appBarLayout);
            final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
            fling = false;
            if (topBottomOffsetForScrollingSibling < n3) {
                this.animateOffsetTo(coordinatorLayout, appBarLayout, n3);
                fling = true;
            }
        }
        else {
            final int n4 = -AppBarLayout.access$300(appBarLayout);
            final int topBottomOffsetForScrollingSibling2 = this.getTopBottomOffsetForScrollingSibling();
            fling = false;
            if (topBottomOffsetForScrollingSibling2 > n4) {
                this.animateOffsetTo(coordinatorLayout, appBarLayout, n4);
                fling = true;
            }
        }
        return mWasNestedFlung = fling;
    }
    
    @Override
    public /* bridge */ boolean onNestedFling(final CoordinatorLayout coordinatorLayout, final View view, final View view2, final float n, final float n2, final boolean b) {
        return this.onNestedFling(coordinatorLayout, (AppBarLayout)view, view2, n, n2, b);
    }
    
    public void onNestedPreScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final int n, final int n2, final int[] array) {
        if (n2 != 0 && !mSkipNestedPreScroll) {
            int n3;
            int n4;
            if (n2 < 0) {
                n3 = -appBarLayout.getTotalScrollRange();
                n4 = n3 + AppBarLayout.access$200(appBarLayout);
            }
            else {
                n3 = -AppBarLayout.access$300(appBarLayout);
                n4 = 0;
            }
            array[1] = this.scroll(coordinatorLayout, appBarLayout, n2, n3, n4);
        }
    }
    
    @Override
    public /* bridge */ void onNestedPreScroll(final CoordinatorLayout coordinatorLayout, final View view, final View view2, final int n, final int n2, final int[] array) {
        this.onNestedPreScroll(coordinatorLayout, (AppBarLayout)view, view2, n, n2, array);
    }
    
    public void onNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final int n, final int n2, final int n3, final int n4) {
        if (n4 < 0) {
            this.scroll(coordinatorLayout, appBarLayout, n4, -AppBarLayout.access$400(appBarLayout), 0);
            mSkipNestedPreScroll = true;
            return;
        }
        mSkipNestedPreScroll = false;
    }
    
    @Override
    public /* bridge */ void onNestedScroll(final CoordinatorLayout coordinatorLayout, final View view, final View view2, final int n, final int n2, final int n3, final int n4) {
        this.onNestedScroll(coordinatorLayout, (AppBarLayout)view, view2, n, n2, n3, n4);
    }
    
    public void onRestoreInstanceState(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            final SavedState savedState = (SavedState)parcelable;
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
            mOffsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
            mOffsetToChildIndexOnLayoutPerc = savedState.firstVisibileChildPercentageShown;
            mOffsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibileChildAtMinimumHeight;
            return;
        }
        super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        mOffsetToChildIndexOnLayout = -1;
    }
    
    @Override
    public /* bridge */ void onRestoreInstanceState(final CoordinatorLayout coordinatorLayout, final View view, final Parcelable parcelable) {
        this.onRestoreInstanceState(coordinatorLayout, (AppBarLayout)view, parcelable);
    }
    
    public Parcelable onSaveInstanceState(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
        final Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        final int topAndBottomOffset = this.getTopAndBottomOffset();
        for (int i = 0; i < appBarLayout.getChildCount(); ++i) {
            final View child = appBarLayout.getChildAt(i);
            final int n = topAndBottomOffset + child.getBottom();
            if (topAndBottomOffset + child.getTop() <= 0 && n >= 0) {
                final SavedState savedState = new SavedState(onSaveInstanceState);
                savedState.firstVisibleChildIndex = i;
                savedState.firstVisibileChildAtMinimumHeight = (n == ViewCompat.getMinimumHeight(child));
                savedState.firstVisibileChildPercentageShown = n / child.getHeight();
                return (Parcelable)savedState;
            }
        }
        return onSaveInstanceState;
    }
    
    @Override
    public /* bridge */ Parcelable onSaveInstanceState(final CoordinatorLayout coordinatorLayout, final View view) {
        return this.onSaveInstanceState(coordinatorLayout, (AppBarLayout)view);
    }
    
    public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final View view2, final int n) {
        final boolean b = (n & 0x2) != 0x0 && AppBarLayout.access$100(appBarLayout) && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        if (b && mAnimator != null) {
            mAnimator.cancel();
        }
        mLastNestedScrollingChildRef = null;
        return b;
    }
    
    @Override
    public /* bridge */ boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final View view, final View view2, final View view3, final int n) {
        return this.onStartNestedScroll(coordinatorLayout, (AppBarLayout)view, view2, view3, n);
    }
    
    public void onStopNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view) {
        if (!mWasNestedFlung) {
            this.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
        }
        mSkipNestedPreScroll = false;
        mWasNestedFlung = false;
        mLastNestedScrollingChildRef = new WeakReference<View>(view);
    }
    
    @Override
    public /* bridge */ void onStopNestedScroll(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        this.onStopNestedScroll(coordinatorLayout, (AppBarLayout)view, view2);
    }
    
    public void setDragCallback(@Nullable final DragCallback mOnDragCallback) {
        this.mOnDragCallback = mOnDragCallback;
    }
    
    @Override
    int setHeaderTopBottomOffset(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n, final int n2, final int n3) {
        final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
        if (n2 != 0 && topBottomOffsetForScrollingSibling >= n2 && topBottomOffsetForScrollingSibling <= n3) {
            final int constrain = MathUtils.constrain(n, n2, n3);
            int n4 = 0;
            if (topBottomOffsetForScrollingSibling != constrain) {
                int interpolateOffset;
                if (AppBarLayout.access$700(appBarLayout)) {
                    interpolateOffset = this.interpolateOffset(appBarLayout, constrain);
                }
                else {
                    interpolateOffset = constrain;
                }
                final boolean setTopAndBottomOffset = this.setTopAndBottomOffset(interpolateOffset);
                n4 = topBottomOffsetForScrollingSibling - constrain;
                mOffsetDelta = constrain - interpolateOffset;
                if (!setTopAndBottomOffset && AppBarLayout.access$700(appBarLayout)) {
                    coordinatorLayout.dispatchDependentViewsChanged((View)appBarLayout);
                }
                this.dispatchOffsetUpdates(appBarLayout);
            }
            return n4;
        }
        return mOffsetDelta = 0;
    }
    
    @Override
    /* bridge */ int setHeaderTopBottomOffset(final CoordinatorLayout coordinatorLayout, final View view, final int n, final int n2, final int n3) {
        return this.setHeaderTopBottomOffset(coordinatorLayout, (AppBarLayout)view, n, n2, n3);
    }
    
    @Override
    public /* bridge */ boolean setLeftAndRightOffset(final int leftAndRightOffset) {
        return super.setLeftAndRightOffset(leftAndRightOffset);
    }
    
    @Override
    public /* bridge */ boolean setTopAndBottomOffset(final int topAndBottomOffset) {
        return super.setTopAndBottomOffset(topAndBottomOffset);
    }
}
