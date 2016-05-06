package android.support.v7.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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
import android.view.View;
import android.support.annotation.Nullable;

public abstract static class LayoutManager
{
    private boolean mAutoMeasure;
    ChildHelper mChildHelper;
    private int mHeightSpec;
    boolean mIsAttachedToWindow;
    private boolean mMeasurementCacheEnabled;
    RecyclerView mRecyclerView;
    private boolean mRequestedSimpleAnimations;
    @Nullable
    SmoothScroller mSmoothScroller;
    private int mWidthSpec;
    
    public LayoutManager() {
        super();
        this.mRequestedSimpleAnimations = false;
        this.mIsAttachedToWindow = false;
        this.mAutoMeasure = false;
        this.mMeasurementCacheEnabled = true;
    }
    
    static /* synthetic */ boolean access$2000(final LayoutManager layoutManager) {
        return layoutManager.mAutoMeasure;
    }
    
    static /* synthetic */ boolean access$2600(final LayoutManager layoutManager) {
        return layoutManager.mRequestedSimpleAnimations;
    }
    
    static /* synthetic */ boolean access$2602(final LayoutManager layoutManager, final boolean mRequestedSimpleAnimations) {
        return layoutManager.mRequestedSimpleAnimations = mRequestedSimpleAnimations;
    }
    
    static /* synthetic */ void access$6000(final LayoutManager layoutManager, final SmoothScroller smoothScroller) {
        layoutManager.onSmoothScrollerStopped(smoothScroller);
    }
    
    private void addViewInt(final View view, int childCount, final boolean b) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (b || childViewHolderInt.isRemoved()) {
            mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
        }
        else {
            mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
        }
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            }
            else {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            mChildHelper.attachViewToParent(view, childCount, view.getLayoutParams(), false);
        }
        else if (view.getParent() == mRecyclerView) {
            final int indexOfChild = mChildHelper.indexOfChild(view);
            if (childCount == -1) {
                childCount = mChildHelper.getChildCount();
            }
            if (indexOfChild == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + mRecyclerView.indexOfChild(view));
            }
            if (indexOfChild != childCount) {
                mLayout.moveView(indexOfChild, childCount);
            }
        }
        else {
            mChildHelper.addView(view, childCount, false);
            layoutParams.mInsetsDirty = true;
            if (mSmoothScroller != null && mSmoothScroller.isRunning()) {
                mSmoothScroller.onChildAttachedToWindow(view);
            }
        }
        if (layoutParams.mPendingInvalidate) {
            childViewHolderInt.itemView.invalidate();
            layoutParams.mPendingInvalidate = false;
        }
    }
    
    public static int chooseSize(final int n, final int n2, final int n3) {
        final int mode = View$MeasureSpec.getMode(n);
        int n4 = View$MeasureSpec.getSize(n);
        switch (mode) {
            default:
                n4 = Math.max(n2, n3);
                return n4;
            case 1073741824:
                return n4;
            case Integer.MIN_VALUE:
                return Math.min(n4, Math.max(n2, n3));
        }
    }
    
    private void detachViewInternal(final int n, final View view) {
        mChildHelper.detachViewFromParent(n);
    }
    
    public static int getChildMeasureSpec(final int n, final int n2, final int n3, final int n4, final boolean b) {
        final int max = Math.max(0, n - n3);
        int n5;
        int n6;
        if (b) {
            if (n4 >= 0) {
                n5 = n4;
                n6 = 1073741824;
            }
            else if (n4 == -1) {
                switch (n2) {
                    default:
                        n6 = 0;
                        n5 = 0;
                        break;
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        n5 = max;
                        n6 = n2;
                        break;
                    case 0:
                        n6 = 0;
                        n5 = 0;
                        break;
                }
            }
            else {
                n6 = 0;
                n5 = 0;
                if (n4 == -2) {
                    n6 = 0;
                    n5 = 0;
                }
            }
        }
        else if (n4 >= 0) {
            n5 = n4;
            n6 = 1073741824;
        }
        else if (n4 == -1) {
            n5 = max;
            n6 = n2;
        }
        else {
            n6 = 0;
            n5 = 0;
            if (n4 == -2) {
                n5 = max;
                if (n2 == Integer.MIN_VALUE || n2 == 1073741824) {
                    n6 = Integer.MIN_VALUE;
                }
                else {
                    n6 = 0;
                }
            }
        }
        return View$MeasureSpec.makeMeasureSpec(n5, n6);
    }
    
    @Deprecated
    public static int getChildMeasureSpec(final int n, final int n2, final int n3, final boolean b) {
        final int max = Math.max(0, n - n2);
        int n4;
        int n5;
        if (b) {
            if (n3 >= 0) {
                n4 = n3;
                n5 = 1073741824;
            }
            else {
                n5 = 0;
                n4 = 0;
            }
        }
        else if (n3 >= 0) {
            n4 = n3;
            n5 = 1073741824;
        }
        else if (n3 == -1) {
            n4 = max;
            n5 = 1073741824;
        }
        else {
            n5 = 0;
            n4 = 0;
            if (n3 == -2) {
                n4 = max;
                n5 = Integer.MIN_VALUE;
            }
        }
        return View$MeasureSpec.makeMeasureSpec(n4, n5);
    }
    
    public static Properties getProperties(final Context context, final AttributeSet set, final int n, final int n2) {
        final Properties properties = new Properties();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.RecyclerView, n, n2);
        properties.orientation = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
        properties.spanCount = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
        properties.reverseLayout = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
        properties.stackFromEnd = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
        obtainStyledAttributes.recycle();
        return properties;
    }
    
    private static boolean isMeasurementUpToDate(final int n, final int n2, final int n3) {
        boolean b = true;
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n2);
        if (n3 > 0 && n != n3) {
            b = false;
        }
        else {
            switch (mode) {
                case 0:
                    break;
                default:
                    return false;
                case Integer.MIN_VALUE:
                    if (size < n) {
                        return false;
                    }
                    break;
                case 1073741824:
                    if (size != n) {
                        return false;
                    }
                    break;
            }
        }
        return b;
    }
    
    private void onSmoothScrollerStopped(final SmoothScroller smoothScroller) {
        if (mSmoothScroller == smoothScroller) {
            mSmoothScroller = null;
        }
    }
    
    private void scrapOrRecycleView(final Recycler recycler, final int n, final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.shouldIgnore()) {
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.access$3100(mRecyclerView).hasStableIds()) {
            this.removeViewAt(n);
            recycler.recycleViewHolderInternal(childViewHolderInt);
            return;
        }
        this.detachViewAt(n);
        recycler.scrapView(view);
        mViewInfoStore.onViewDetached(childViewHolderInt);
    }
    
    public void addDisappearingView(final View view) {
        this.addDisappearingView(view, -1);
    }
    
    public void addDisappearingView(final View view, final int n) {
        this.addViewInt(view, n, true);
    }
    
    public void addView(final View view) {
        this.addView(view, -1);
    }
    
    public void addView(final View view, final int n) {
        this.addViewInt(view, n, false);
    }
    
    public void assertInLayoutOrScroll(final String s) {
        if (mRecyclerView != null) {
            mRecyclerView.assertInLayoutOrScroll(s);
        }
    }
    
    public void assertNotInLayoutOrScroll(final String s) {
        if (mRecyclerView != null) {
            mRecyclerView.assertNotInLayoutOrScroll(s);
        }
    }
    
    public void attachView(final View view) {
        this.attachView(view, -1);
    }
    
    public void attachView(final View view, final int n) {
        this.attachView(view, n, (LayoutParams)view.getLayoutParams());
    }
    
    public void attachView(final View view, final int n, final LayoutParams layoutParams) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isRemoved()) {
            mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
        }
        else {
            mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
        }
        mChildHelper.attachViewToParent(view, n, (ViewGroup$LayoutParams)layoutParams, childViewHolderInt.isRemoved());
    }
    
    public void calculateItemDecorationsForChild(final View view, final Rect rect) {
        if (mRecyclerView == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        rect.set(mRecyclerView.getItemDecorInsetsForChild(view));
    }
    
    public boolean canScrollHorizontally() {
        return false;
    }
    
    public boolean canScrollVertically() {
        return false;
    }
    
    public boolean checkLayoutParams(final LayoutParams layoutParams) {
        return layoutParams != null;
    }
    
    public int computeHorizontalScrollExtent(final State state) {
        return 0;
    }
    
    public int computeHorizontalScrollOffset(final State state) {
        return 0;
    }
    
    public int computeHorizontalScrollRange(final State state) {
        return 0;
    }
    
    public int computeVerticalScrollExtent(final State state) {
        return 0;
    }
    
    public int computeVerticalScrollOffset(final State state) {
        return 0;
    }
    
    public int computeVerticalScrollRange(final State state) {
        return 0;
    }
    
    public void detachAndScrapAttachedViews(final Recycler recycler) {
        for (int i = -1 + this.getChildCount(); i >= 0; --i) {
            this.scrapOrRecycleView(recycler, i, this.getChildAt(i));
        }
    }
    
    public void detachAndScrapView(final View view, final Recycler recycler) {
        this.scrapOrRecycleView(recycler, mChildHelper.indexOfChild(view), view);
    }
    
    public void detachAndScrapViewAt(final int n, final Recycler recycler) {
        this.scrapOrRecycleView(recycler, n, this.getChildAt(n));
    }
    
    public void detachView(final View view) {
        final int indexOfChild = mChildHelper.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.detachViewInternal(indexOfChild, view);
        }
    }
    
    public void detachViewAt(final int n) {
        this.detachViewInternal(n, this.getChildAt(n));
    }
    
    void dispatchAttachedToWindow(final RecyclerView recyclerView) {
        mIsAttachedToWindow = true;
        this.onAttachedToWindow(recyclerView);
    }
    
    void dispatchDetachedFromWindow(final RecyclerView recyclerView, final Recycler recycler) {
        mIsAttachedToWindow = false;
        this.onDetachedFromWindow(recyclerView, recycler);
    }
    
    public void endAnimation(final View view) {
        if (mItemAnimator != null) {
            mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
        }
    }
    
    @Nullable
    public View findContainingItemView(final View view) {
        View containingItemView;
        if (mRecyclerView == null) {
            containingItemView = null;
        }
        else {
            containingItemView = mRecyclerView.findContainingItemView(view);
            if (containingItemView == null) {
                return null;
            }
            if (mChildHelper.isHidden(containingItemView)) {
                return null;
            }
        }
        return containingItemView;
    }
    
    public View findViewByPosition(final int n) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(child);
            if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == n && !childViewHolderInt.shouldIgnore() && (mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                return child;
            }
        }
        return null;
    }
    
    public abstract LayoutParams generateDefaultLayoutParams();
    
    public LayoutParams generateLayoutParams(final Context context, final AttributeSet set) {
        return new LayoutParams(context, set);
    }
    
    public LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    public int getBaseline() {
        return -1;
    }
    
    public int getBottomDecorationHeight(final View view) {
        return ((LayoutParams)view.getLayoutParams()).mDecorInsets.bottom;
    }
    
    public View getChildAt(final int n) {
        if (mChildHelper != null) {
            return mChildHelper.getChildAt(n);
        }
        return null;
    }
    
    public int getChildCount() {
        if (mChildHelper != null) {
            return mChildHelper.getChildCount();
        }
        return 0;
    }
    
    public boolean getClipToPadding() {
        return mRecyclerView != null && RecyclerView.access$5500(mRecyclerView);
    }
    
    public int getColumnCountForAccessibility(final Recycler recycler, final State state) {
        if (mRecyclerView != null && RecyclerView.access$3100(mRecyclerView) != null && this.canScrollHorizontally()) {
            return RecyclerView.access$3100(mRecyclerView).getItemCount();
        }
        return 1;
    }
    
    public int getDecoratedBottom(final View view) {
        return view.getBottom() + this.getBottomDecorationHeight(view);
    }
    
    public int getDecoratedLeft(final View view) {
        return view.getLeft() - this.getLeftDecorationWidth(view);
    }
    
    public int getDecoratedMeasuredHeight(final View view) {
        final Rect mDecorInsets = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
        return view.getMeasuredHeight() + mDecorInsets.top + mDecorInsets.bottom;
    }
    
    public int getDecoratedMeasuredWidth(final View view) {
        final Rect mDecorInsets = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
        return view.getMeasuredWidth() + mDecorInsets.left + mDecorInsets.right;
    }
    
    public int getDecoratedRight(final View view) {
        return view.getRight() + this.getRightDecorationWidth(view);
    }
    
    public int getDecoratedTop(final View view) {
        return view.getTop() - this.getTopDecorationHeight(view);
    }
    
    public View getFocusedChild() {
        View focusedChild;
        if (mRecyclerView == null) {
            focusedChild = null;
        }
        else {
            focusedChild = mRecyclerView.getFocusedChild();
            if (focusedChild == null || mChildHelper.isHidden(focusedChild)) {
                return null;
            }
        }
        return focusedChild;
    }
    
    public int getHeight() {
        return View$MeasureSpec.getSize(mHeightSpec);
    }
    
    public int getHeightMode() {
        return View$MeasureSpec.getMode(mHeightSpec);
    }
    
    public int getItemCount() {
        Object adapter;
        if (mRecyclerView != null) {
            adapter = mRecyclerView.getAdapter();
        }
        else {
            adapter = null;
        }
        if (adapter != null) {
            return ((Adapter)adapter).getItemCount();
        }
        return 0;
    }
    
    public int getItemViewType(final View view) {
        return RecyclerView.getChildViewHolderInt(view).getItemViewType();
    }
    
    public int getLayoutDirection() {
        return ViewCompat.getLayoutDirection((View)mRecyclerView);
    }
    
    public int getLeftDecorationWidth(final View view) {
        return ((LayoutParams)view.getLayoutParams()).mDecorInsets.left;
    }
    
    public int getMinimumHeight() {
        return ViewCompat.getMinimumHeight((View)mRecyclerView);
    }
    
    public int getMinimumWidth() {
        return ViewCompat.getMinimumWidth((View)mRecyclerView);
    }
    
    public int getPaddingBottom() {
        if (mRecyclerView != null) {
            return mRecyclerView.getPaddingBottom();
        }
        return 0;
    }
    
    public int getPaddingEnd() {
        if (mRecyclerView != null) {
            return ViewCompat.getPaddingEnd((View)mRecyclerView);
        }
        return 0;
    }
    
    public int getPaddingLeft() {
        if (mRecyclerView != null) {
            return mRecyclerView.getPaddingLeft();
        }
        return 0;
    }
    
    public int getPaddingRight() {
        if (mRecyclerView != null) {
            return mRecyclerView.getPaddingRight();
        }
        return 0;
    }
    
    public int getPaddingStart() {
        if (mRecyclerView != null) {
            return ViewCompat.getPaddingStart((View)mRecyclerView);
        }
        return 0;
    }
    
    public int getPaddingTop() {
        if (mRecyclerView != null) {
            return mRecyclerView.getPaddingTop();
        }
        return 0;
    }
    
    public int getPosition(final View view) {
        return ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRightDecorationWidth(final View view) {
        return ((LayoutParams)view.getLayoutParams()).mDecorInsets.right;
    }
    
    public int getRowCountForAccessibility(final Recycler recycler, final State state) {
        if (mRecyclerView != null && RecyclerView.access$3100(mRecyclerView) != null && this.canScrollVertically()) {
            return RecyclerView.access$3100(mRecyclerView).getItemCount();
        }
        return 1;
    }
    
    public int getSelectionModeForAccessibility(final Recycler recycler, final State state) {
        return 0;
    }
    
    public int getTopDecorationHeight(final View view) {
        return ((LayoutParams)view.getLayoutParams()).mDecorInsets.top;
    }
    
    public int getWidth() {
        return View$MeasureSpec.getSize(mWidthSpec);
    }
    
    public int getWidthMode() {
        return View$MeasureSpec.getMode(mWidthSpec);
    }
    
    boolean hasFlexibleChildInBothOrientations() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final ViewGroup$LayoutParams layoutParams = this.getChildAt(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasFocus() {
        return mRecyclerView != null && mRecyclerView.hasFocus();
    }
    
    public void ignoreView(final View view) {
        if (view.getParent() != mRecyclerView || mRecyclerView.indexOfChild(view) == -1) {
            throw new IllegalArgumentException("View should be fully attached to be ignored");
        }
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.addFlags(128);
        mViewInfoStore.removeViewHolder(childViewHolderInt);
    }
    
    public boolean isAttachedToWindow() {
        return mIsAttachedToWindow;
    }
    
    public boolean isAutoMeasureEnabled() {
        return mAutoMeasure;
    }
    
    public boolean isFocused() {
        return mRecyclerView != null && mRecyclerView.isFocused();
    }
    
    public boolean isLayoutHierarchical(final Recycler recycler, final State state) {
        return false;
    }
    
    public boolean isMeasurementCacheEnabled() {
        return mMeasurementCacheEnabled;
    }
    
    public boolean isSmoothScrolling() {
        return mSmoothScroller != null && mSmoothScroller.isRunning();
    }
    
    public void layoutDecorated(final View view, final int n, final int n2, final int n3, final int n4) {
        final Rect mDecorInsets = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
        view.layout(n + mDecorInsets.left, n2 + mDecorInsets.top, n3 - mDecorInsets.right, n4 - mDecorInsets.bottom);
    }
    
    public void measureChild(final View view, final int n, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final Rect itemDecorInsetsForChild = mRecyclerView.getItemDecorInsetsForChild(view);
        final int n3 = n + (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right);
        final int n4 = n2 + (itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom);
        final int childMeasureSpec = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), n3 + (this.getPaddingLeft() + this.getPaddingRight()), layoutParams.width, this.canScrollHorizontally());
        final int childMeasureSpec2 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), n4 + (this.getPaddingTop() + this.getPaddingBottom()), layoutParams.height, this.canScrollVertically());
        if (this.shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }
    
    public void measureChildWithMargins(final View view, final int n, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final Rect itemDecorInsetsForChild = mRecyclerView.getItemDecorInsetsForChild(view);
        final int n3 = n + (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right);
        final int n4 = n2 + (itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom);
        final int childMeasureSpec = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), n3 + (this.getPaddingLeft() + this.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin), layoutParams.width, this.canScrollHorizontally());
        final int childMeasureSpec2 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), n4 + (this.getPaddingTop() + this.getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin), layoutParams.height, this.canScrollVertically());
        if (this.shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }
    
    public void moveView(final int n, final int n2) {
        final View child = this.getChildAt(n);
        if (child == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + n);
        }
        this.detachViewAt(n);
        this.attachView(child, n2);
    }
    
    public void offsetChildrenHorizontal(final int n) {
        if (mRecyclerView != null) {
            mRecyclerView.offsetChildrenHorizontal(n);
        }
    }
    
    public void offsetChildrenVertical(final int n) {
        if (mRecyclerView != null) {
            mRecyclerView.offsetChildrenVertical(n);
        }
    }
    
    public void onAdapterChanged(final Adapter adapter, final Adapter adapter2) {
    }
    
    public boolean onAddFocusables(final RecyclerView recyclerView, final ArrayList<View> list, final int n, final int n2) {
        return false;
    }
    
    @CallSuper
    public void onAttachedToWindow(final RecyclerView recyclerView) {
    }
    
    @Deprecated
    public void onDetachedFromWindow(final RecyclerView recyclerView) {
    }
    
    @CallSuper
    public void onDetachedFromWindow(final RecyclerView recyclerView, final Recycler recycler) {
        this.onDetachedFromWindow(recyclerView);
    }
    
    @Nullable
    public View onFocusSearchFailed(final View view, final int n, final Recycler recycler, final State state) {
        return null;
    }
    
    public void onInitializeAccessibilityEvent(final Recycler recycler, final State state, final AccessibilityEvent accessibilityEvent) {
        int scrollable = 1;
        final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(accessibilityEvent);
        if (mRecyclerView != null && record != null) {
            if (!ViewCompat.canScrollVertically((View)mRecyclerView, scrollable) && !ViewCompat.canScrollVertically((View)mRecyclerView, -1) && !ViewCompat.canScrollHorizontally((View)mRecyclerView, -1) && !ViewCompat.canScrollHorizontally((View)mRecyclerView, scrollable)) {
                scrollable = 0;
            }
            record.setScrollable(scrollable != 0);
            if (RecyclerView.access$3100(mRecyclerView) != null) {
                record.setItemCount(RecyclerView.access$3100(mRecyclerView).getItemCount());
            }
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        this.onInitializeAccessibilityEvent(mRecycler, mState, accessibilityEvent);
    }
    
    void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.onInitializeAccessibilityNodeInfo(mRecycler, mState, accessibilityNodeInfoCompat);
    }
    
    public void onInitializeAccessibilityNodeInfo(final Recycler recycler, final State state, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (ViewCompat.canScrollVertically((View)mRecyclerView, -1) || ViewCompat.canScrollHorizontally((View)mRecyclerView, -1)) {
            accessibilityNodeInfoCompat.addAction(8192);
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        if (ViewCompat.canScrollVertically((View)mRecyclerView, 1) || ViewCompat.canScrollHorizontally((View)mRecyclerView, 1)) {
            accessibilityNodeInfoCompat.addAction(4096);
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.getRowCountForAccessibility(recycler, state), this.getColumnCountForAccessibility(recycler, state), this.isLayoutHierarchical(recycler, state), this.getSelectionModeForAccessibility(recycler, state)));
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(final Recycler recycler, final State state, final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int position;
        if (this.canScrollVertically()) {
            position = this.getPosition(view);
        }
        else {
            position = 0;
        }
        int position2;
        if (this.canScrollHorizontally()) {
            position2 = this.getPosition(view);
        }
        else {
            position2 = 0;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(position, 1, position2, 1, false, false));
    }
    
    void onInitializeAccessibilityNodeInfoForItem(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !mChildHelper.isHidden(childViewHolderInt.itemView)) {
            this.onInitializeAccessibilityNodeInfoForItem(mRecycler, mState, view, accessibilityNodeInfoCompat);
        }
    }
    
    public View onInterceptFocusSearch(final View view, final int n) {
        return null;
    }
    
    public void onItemsAdded(final RecyclerView recyclerView, final int n, final int n2) {
    }
    
    public void onItemsChanged(final RecyclerView recyclerView) {
    }
    
    public void onItemsMoved(final RecyclerView recyclerView, final int n, final int n2, final int n3) {
    }
    
    public void onItemsRemoved(final RecyclerView recyclerView, final int n, final int n2) {
    }
    
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2) {
    }
    
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2, final Object o) {
        this.onItemsUpdated(recyclerView, n, n2);
    }
    
    public void onLayoutChildren(final Recycler recycler, final State state) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onMeasure(final Recycler recycler, final State state, final int n, final int n2) {
        mRecyclerView.defaultOnMeasure(n, n2);
    }
    
    public boolean onRequestChildFocus(final RecyclerView recyclerView, final State state, final View view, final View view2) {
        return this.onRequestChildFocus(recyclerView, view, view2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(final RecyclerView recyclerView, final View view, final View view2) {
        return this.isSmoothScrolling() || recyclerView.isComputingLayout();
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
    }
    
    public Parcelable onSaveInstanceState() {
        return null;
    }
    
    public void onScrollStateChanged(final int n) {
    }
    
    boolean performAccessibilityAction(final int n, final Bundle bundle) {
        return this.performAccessibilityAction(mRecycler, mState, n, bundle);
    }
    
    public boolean performAccessibilityAction(final Recycler recycler, final State state, final int n, final Bundle bundle) {
        if (mRecyclerView != null) {
            int n2 = 0;
            int n3 = 0;
            switch (n) {
                case 8192: {
                    final boolean canScrollVertically = ViewCompat.canScrollVertically((View)mRecyclerView, -1);
                    n3 = 0;
                    if (canScrollVertically) {
                        n3 = -(this.getHeight() - this.getPaddingTop() - this.getPaddingBottom());
                    }
                    final boolean canScrollHorizontally = ViewCompat.canScrollHorizontally((View)mRecyclerView, -1);
                    n2 = 0;
                    if (canScrollHorizontally) {
                        n2 = -(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
                        break;
                    }
                    break;
                }
                case 4096: {
                    final boolean canScrollVertically2 = ViewCompat.canScrollVertically((View)mRecyclerView, 1);
                    n3 = 0;
                    if (canScrollVertically2) {
                        n3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                    }
                    final boolean canScrollHorizontally2 = ViewCompat.canScrollHorizontally((View)mRecyclerView, 1);
                    n2 = 0;
                    if (canScrollHorizontally2) {
                        n2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                        break;
                    }
                    break;
                }
            }
            if (n3 != 0 || n2 != 0) {
                mRecyclerView.scrollBy(n2, n3);
                return true;
            }
        }
        return false;
    }
    
    public boolean performAccessibilityActionForItem(final Recycler recycler, final State state, final View view, final int n, final Bundle bundle) {
        return false;
    }
    
    boolean performAccessibilityActionForItem(final View view, final int n, final Bundle bundle) {
        return this.performAccessibilityActionForItem(mRecycler, mState, view, n, bundle);
    }
    
    public void postOnAnimation(final Runnable runnable) {
        if (mRecyclerView != null) {
            ViewCompat.postOnAnimation((View)mRecyclerView, runnable);
        }
    }
    
    public void removeAllViews() {
        for (int i = -1 + this.getChildCount(); i >= 0; --i) {
            mChildHelper.removeViewAt(i);
        }
    }
    
    public void removeAndRecycleAllViews(final Recycler recycler) {
        for (int i = -1 + this.getChildCount(); i >= 0; --i) {
            if (!RecyclerView.getChildViewHolderInt(this.getChildAt(i)).shouldIgnore()) {
                this.removeAndRecycleViewAt(i, recycler);
            }
        }
    }
    
    void removeAndRecycleScrapInt(final Recycler recycler) {
        final int scrapCount = recycler.getScrapCount();
        for (int i = scrapCount - 1; i >= 0; --i) {
            final View scrapView = recycler.getScrapViewAt(i);
            final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapView);
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.setIsRecyclable(false);
                if (childViewHolderInt.isTmpDetached()) {
                    mRecyclerView.removeDetachedView(scrapView, false);
                }
                if (mItemAnimator != null) {
                    mItemAnimator.endAnimation(childViewHolderInt);
                }
                childViewHolderInt.setIsRecyclable(true);
                recycler.quickRecycleScrapView(scrapView);
            }
        }
        recycler.clearScrap();
        if (scrapCount > 0) {
            mRecyclerView.invalidate();
        }
    }
    
    public void removeAndRecycleView(final View view, final Recycler recycler) {
        this.removeView(view);
        recycler.recycleView(view);
    }
    
    public void removeAndRecycleViewAt(final int n, final Recycler recycler) {
        final View child = this.getChildAt(n);
        this.removeViewAt(n);
        recycler.recycleView(child);
    }
    
    public boolean removeCallbacks(final Runnable runnable) {
        return mRecyclerView != null && mRecyclerView.removeCallbacks(runnable);
    }
    
    public void removeDetachedView(final View view) {
        mRecyclerView.removeDetachedView(view, false);
    }
    
    public void removeView(final View view) {
        mChildHelper.removeView(view);
    }
    
    public void removeViewAt(final int n) {
        if (this.getChildAt(n) != null) {
            mChildHelper.removeViewAt(n);
        }
    }
    
    public boolean requestChildRectangleOnScreen(final RecyclerView recyclerView, final View view, final Rect rect, final boolean b) {
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int n = this.getWidth() - this.getPaddingRight();
        final int n2 = this.getHeight() - this.getPaddingBottom();
        final int n3 = view.getLeft() + rect.left - view.getScrollX();
        final int n4 = view.getTop() + rect.top - view.getScrollY();
        final int n5 = n3 + rect.width();
        final int n6 = n4 + rect.height();
        final int min = Math.min(0, n3 - paddingLeft);
        final int min2 = Math.min(0, n4 - paddingTop);
        final int max = Math.max(0, n5 - n);
        final int max2 = Math.max(0, n6 - n2);
        int n7;
        if (this.getLayoutDirection() == 1) {
            if (max != 0) {
                n7 = max;
            }
            else {
                n7 = Math.max(min, n5 - n);
            }
        }
        else if (min != 0) {
            n7 = min;
        }
        else {
            n7 = Math.min(n3 - paddingLeft, max);
        }
        int min3;
        if (min2 != 0) {
            min3 = min2;
        }
        else {
            min3 = Math.min(n4 - paddingTop, max2);
        }
        if (n7 != 0 || min3 != 0) {
            if (b) {
                recyclerView.scrollBy(n7, min3);
            }
            else {
                recyclerView.smoothScrollBy(n7, min3);
            }
            return true;
        }
        return false;
    }
    
    public void requestLayout() {
        if (mRecyclerView != null) {
            mRecyclerView.requestLayout();
        }
    }
    
    public void requestSimpleAnimationsInNextLayout() {
        mRequestedSimpleAnimations = true;
    }
    
    public int scrollHorizontallyBy(final int n, final Recycler recycler, final State state) {
        return 0;
    }
    
    public void scrollToPosition(final int n) {
    }
    
    public int scrollVerticallyBy(final int n, final Recycler recycler, final State state) {
        return 0;
    }
    
    public void setAutoMeasureEnabled(final boolean mAutoMeasure) {
        this.mAutoMeasure = mAutoMeasure;
    }
    
    void setExactMeasureSpecsFrom(final RecyclerView recyclerView) {
        this.setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View$MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }
    
    void setMeasureSpecs(final int mWidthSpec, final int mHeightSpec) {
        this.mWidthSpec = mWidthSpec;
        this.mHeightSpec = mHeightSpec;
    }
    
    public void setMeasuredDimension(final int n, final int n2) {
        RecyclerView.access$5600(mRecyclerView, n, n2);
    }
    
    public void setMeasuredDimension(final Rect rect, final int n, final int n2) {
        this.setMeasuredDimension(chooseSize(n, rect.width() + this.getPaddingLeft() + this.getPaddingRight(), this.getMinimumWidth()), chooseSize(n2, rect.height() + this.getPaddingTop() + this.getPaddingBottom(), this.getMinimumHeight()));
    }
    
    void setMeasuredDimensionFromChildren(final int n, final int n2) {
        final int childCount = this.getChildCount();
        if (childCount == 0) {
            mRecyclerView.defaultOnMeasure(n, n2);
            return;
        }
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        int n6 = Integer.MIN_VALUE;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int n7 = this.getDecoratedLeft(child) - layoutParams.leftMargin;
            final int n8 = this.getDecoratedRight(child) + layoutParams.rightMargin;
            final int n9 = this.getDecoratedTop(child) - layoutParams.topMargin;
            final int n10 = this.getDecoratedBottom(child) + layoutParams.bottomMargin;
            if (n7 < n3) {
                n3 = n7;
            }
            if (n8 > n5) {
                n5 = n8;
            }
            if (n9 < n4) {
                n4 = n9;
            }
            if (n10 > n6) {
                n6 = n10;
            }
        }
        RecyclerView.access$5400(mRecyclerView).set(n3, n4, n5, n6);
        this.setMeasuredDimension(RecyclerView.access$5400(mRecyclerView), n, n2);
    }
    
    public void setMeasurementCacheEnabled(final boolean mMeasurementCacheEnabled) {
        this.mMeasurementCacheEnabled = mMeasurementCacheEnabled;
    }
    
    void setRecyclerView(final RecyclerView mRecyclerView) {
        if (mRecyclerView == null) {
            this.mRecyclerView = null;
            mChildHelper = null;
            mWidthSpec = View$MeasureSpec.makeMeasureSpec(0, 1073741824);
            mHeightSpec = View$MeasureSpec.makeMeasureSpec(0, 1073741824);
            return;
        }
        this.mRecyclerView = mRecyclerView;
        mChildHelper = mRecyclerView.mChildHelper;
        mWidthSpec = View$MeasureSpec.makeMeasureSpec(mRecyclerView.getWidth(), 1073741824);
        mHeightSpec = View$MeasureSpec.makeMeasureSpec(mRecyclerView.getHeight(), 1073741824);
    }
    
    boolean shouldMeasureChild(final View view, final int n, final int n2, final LayoutParams layoutParams) {
        return view.isLayoutRequested() || !mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), n, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), n2, layoutParams.height);
    }
    
    boolean shouldMeasureTwice() {
        return false;
    }
    
    boolean shouldReMeasureChild(final View view, final int n, final int n2, final LayoutParams layoutParams) {
        return !mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), n, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), n2, layoutParams.height);
    }
    
    public void smoothScrollToPosition(final RecyclerView recyclerView, final State state, final int n) {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public void startSmoothScroll(final SmoothScroller mSmoothScroller) {
        if (this.mSmoothScroller != null && mSmoothScroller != this.mSmoothScroller && this.mSmoothScroller.isRunning()) {
            this.mSmoothScroller.stop();
        }
        (this.mSmoothScroller = mSmoothScroller).start(mRecyclerView, this);
    }
    
    public void stopIgnoringView(final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.stopIgnoring();
        childViewHolderInt.resetInternal();
        childViewHolderInt.addFlags(4);
    }
    
    void stopSmoothScroller() {
        if (mSmoothScroller != null) {
            mSmoothScroller.stop();
        }
    }
    
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
