package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.PointF;
import android.util.Log;
import java.util.List;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper;

public class LinearLayoutManager extends LayoutManager implements ViewDropHandler
{
    private static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private boolean mLastStackFromEnd;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;
    
    public LinearLayoutManager(final Context context) {
        this(context, 1, false);
    }
    
    public LinearLayoutManager(final Context context, final int orientation, final boolean reverseLayout) {
        super();
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mStackFromEnd = false;
        mSmoothScrollbarEnabled = true;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        mPendingSavedState = null;
        mAnchorInfo = new AnchorInfo();
        this.setOrientation(orientation);
        this.setReverseLayout(reverseLayout);
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(true);
    }
    
    public LinearLayoutManager(final Context context, final AttributeSet set, final int n, final int n2) {
        super();
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mStackFromEnd = false;
        mSmoothScrollbarEnabled = true;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        mPendingSavedState = null;
        mAnchorInfo = new AnchorInfo();
        final Properties properties = RecyclerView.LayoutManager.getProperties(context, set, n, n2);
        this.setOrientation(properties.orientation);
        this.setReverseLayout(properties.reverseLayout);
        this.setStackFromEnd(properties.stackFromEnd);
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(true);
    }
    
    private int computeScrollExtent(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        final OrientationHelper mOrientationHelper = this.mOrientationHelper;
        final View firstVisibleChildClosestToStart = this.findFirstVisibleChildClosestToStart(!mSmoothScrollbarEnabled, true);
        final boolean mSmoothScrollbarEnabled = this.mSmoothScrollbarEnabled;
        boolean b = false;
        if (!mSmoothScrollbarEnabled) {
            b = true;
        }
        return ScrollbarHelper.computeScrollExtent(state, mOrientationHelper, firstVisibleChildClosestToStart, this.findFirstVisibleChildClosestToEnd(b, true), this, this.mSmoothScrollbarEnabled);
    }
    
    private int computeScrollOffset(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        final OrientationHelper mOrientationHelper = this.mOrientationHelper;
        final View firstVisibleChildClosestToStart = this.findFirstVisibleChildClosestToStart(!mSmoothScrollbarEnabled, true);
        final boolean mSmoothScrollbarEnabled = this.mSmoothScrollbarEnabled;
        boolean b = false;
        if (!mSmoothScrollbarEnabled) {
            b = true;
        }
        return ScrollbarHelper.computeScrollOffset(state, mOrientationHelper, firstVisibleChildClosestToStart, this.findFirstVisibleChildClosestToEnd(b, true), this, this.mSmoothScrollbarEnabled, mShouldReverseLayout);
    }
    
    private int computeScrollRange(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        final OrientationHelper mOrientationHelper = this.mOrientationHelper;
        final View firstVisibleChildClosestToStart = this.findFirstVisibleChildClosestToStart(!mSmoothScrollbarEnabled, true);
        final boolean mSmoothScrollbarEnabled = this.mSmoothScrollbarEnabled;
        boolean b = false;
        if (!mSmoothScrollbarEnabled) {
            b = true;
        }
        return ScrollbarHelper.computeScrollRange(state, mOrientationHelper, firstVisibleChildClosestToStart, this.findFirstVisibleChildClosestToEnd(b, true), this, this.mSmoothScrollbarEnabled);
    }
    
    private View findFirstReferenceChild(final Recycler recycler, final State state) {
        return this.findReferenceChild(recycler, state, 0, ((RecyclerView.LayoutManager)this).getChildCount(), state.getItemCount());
    }
    
    private View findFirstVisibleChildClosestToEnd(final boolean b, final boolean b2) {
        if (mShouldReverseLayout) {
            return this.findOneVisibleChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), b, b2);
        }
        return this.findOneVisibleChild(-1 + ((RecyclerView.LayoutManager)this).getChildCount(), -1, b, b2);
    }
    
    private View findFirstVisibleChildClosestToStart(final boolean b, final boolean b2) {
        if (mShouldReverseLayout) {
            return this.findOneVisibleChild(-1 + ((RecyclerView.LayoutManager)this).getChildCount(), -1, b, b2);
        }
        return this.findOneVisibleChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), b, b2);
    }
    
    private View findLastReferenceChild(final Recycler recycler, final State state) {
        return this.findReferenceChild(recycler, state, -1 + ((RecyclerView.LayoutManager)this).getChildCount(), -1, state.getItemCount());
    }
    
    private View findReferenceChildClosestToEnd(final Recycler recycler, final State state) {
        if (mShouldReverseLayout) {
            return this.findFirstReferenceChild(recycler, state);
        }
        return this.findLastReferenceChild(recycler, state);
    }
    
    private View findReferenceChildClosestToStart(final Recycler recycler, final State state) {
        if (mShouldReverseLayout) {
            return this.findLastReferenceChild(recycler, state);
        }
        return this.findFirstReferenceChild(recycler, state);
    }
    
    private int fixLayoutEndGap(final int n, final Recycler recycler, final State state, final boolean b) {
        final int n2 = mOrientationHelper.getEndAfterPadding() - n;
        if (n2 > 0) {
            final int n3 = -this.scrollBy(-n2, recycler, state);
            final int n4 = n + n3;
            if (b) {
                final int n5 = mOrientationHelper.getEndAfterPadding() - n4;
                if (n5 > 0) {
                    mOrientationHelper.offsetChildren(n5);
                    return n5 + n3;
                }
            }
            return n3;
        }
        return 0;
    }
    
    private int fixLayoutStartGap(final int n, final Recycler recycler, final State state, final boolean b) {
        final int n2 = n - mOrientationHelper.getStartAfterPadding();
        if (n2 > 0) {
            final int n3 = -this.scrollBy(n2, recycler, state);
            final int n4 = n + n3;
            if (b) {
                final int n5 = n4 - mOrientationHelper.getStartAfterPadding();
                if (n5 > 0) {
                    mOrientationHelper.offsetChildren(-n5);
                    return n3 - n5;
                }
            }
            return n3;
        }
        return 0;
    }
    
    private View getChildClosestToEnd() {
        int n;
        if (mShouldReverseLayout) {
            n = 0;
        }
        else {
            n = -1 + ((RecyclerView.LayoutManager)this).getChildCount();
        }
        return ((RecyclerView.LayoutManager)this).getChildAt(n);
    }
    
    private View getChildClosestToStart() {
        int n;
        if (mShouldReverseLayout) {
            n = -1 + ((RecyclerView.LayoutManager)this).getChildCount();
        }
        else {
            n = 0;
        }
        return ((RecyclerView.LayoutManager)this).getChildAt(n);
    }
    
    private void layoutForPredictiveAnimations(final Recycler recycler, final State state, final int n, final int n2) {
        if (!state.willRunPredictiveAnimations() || ((RecyclerView.LayoutManager)this).getChildCount() == 0 || state.isPreLayout() || !this.supportsPredictiveItemAnimations()) {
            return;
        }
        int mExtra = 0;
        int mExtra2 = 0;
        final List<ViewHolder> scrapList = recycler.getScrapList();
        final int size = scrapList.size();
        final int position = ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0));
        for (int i = 0; i < size; ++i) {
            final ViewHolder viewHolder = (ViewHolder)scrapList.get(i);
            if (!viewHolder.isRemoved()) {
                int n3;
                if (viewHolder.getLayoutPosition() < position != mShouldReverseLayout) {
                    n3 = -1;
                }
                else {
                    n3 = 1;
                }
                if (n3 == -1) {
                    mExtra += mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                }
                else {
                    mExtra2 += mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                }
            }
        }
        mLayoutState.mScrapList = scrapList;
        if (mExtra > 0) {
            this.updateLayoutStateToFillStart(((RecyclerView.LayoutManager)this).getPosition(this.getChildClosestToStart()), n);
            mLayoutState.mExtra = mExtra;
            mLayoutState.mAvailable = 0;
            mLayoutState.assignPositionFromScrapList();
            this.fill(recycler, mLayoutState, state, false);
        }
        if (mExtra2 > 0) {
            this.updateLayoutStateToFillEnd(((RecyclerView.LayoutManager)this).getPosition(this.getChildClosestToEnd()), n2);
            mLayoutState.mExtra = mExtra2;
            mLayoutState.mAvailable = 0;
            mLayoutState.assignPositionFromScrapList();
            this.fill(recycler, mLayoutState, state, false);
        }
        mLayoutState.mScrapList = null;
    }
    
    private void logChildren() {
        Log.d("LinearLayoutManager", "internal representation of views on the screen");
        for (int i = 0; i < ((RecyclerView.LayoutManager)this).getChildCount(); ++i) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            Log.d("LinearLayoutManager", "item " + ((RecyclerView.LayoutManager)this).getPosition(child) + ", coord:" + mOrientationHelper.getDecoratedStart(child));
        }
        Log.d("LinearLayoutManager", "==============");
    }
    
    private void recycleByLayoutState(final Recycler recycler, final LayoutState layoutState) {
        if (!layoutState.mRecycle || layoutState.mInfinite) {
            return;
        }
        if (layoutState.mLayoutDirection == -1) {
            this.recycleViewsFromEnd(recycler, layoutState.mScrollingOffset);
            return;
        }
        this.recycleViewsFromStart(recycler, layoutState.mScrollingOffset);
    }
    
    private void recycleChildren(final Recycler recycler, final int n, final int n2) {
        if (n != n2) {
            if (n2 > n) {
                for (int i = n2 - 1; i >= n; --i) {
                    ((RecyclerView.LayoutManager)this).removeAndRecycleViewAt(i, recycler);
                }
            }
            else {
                for (int j = n; j > n2; --j) {
                    ((RecyclerView.LayoutManager)this).removeAndRecycleViewAt(j, recycler);
                }
            }
        }
    }
    
    private void recycleViewsFromEnd(final Recycler recycler, final int n) {
        final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
        if (n >= 0) {
            final int n2 = mOrientationHelper.getEnd() - n;
            if (mShouldReverseLayout) {
                for (int i = 0; i < childCount; ++i) {
                    if (mOrientationHelper.getDecoratedStart(((RecyclerView.LayoutManager)this).getChildAt(i)) < n2) {
                        this.recycleChildren(recycler, 0, i);
                        return;
                    }
                }
            }
            else {
                for (int j = childCount - 1; j >= 0; --j) {
                    if (mOrientationHelper.getDecoratedStart(((RecyclerView.LayoutManager)this).getChildAt(j)) < n2) {
                        this.recycleChildren(recycler, childCount - 1, j);
                        return;
                    }
                }
            }
        }
    }
    
    private void recycleViewsFromStart(final Recycler recycler, final int n) {
        if (n >= 0) {
            final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
            if (mShouldReverseLayout) {
                for (int i = childCount - 1; i >= 0; --i) {
                    if (mOrientationHelper.getDecoratedEnd(((RecyclerView.LayoutManager)this).getChildAt(i)) > n) {
                        this.recycleChildren(recycler, childCount - 1, i);
                        return;
                    }
                }
            }
            else {
                for (int j = 0; j < childCount; ++j) {
                    if (mOrientationHelper.getDecoratedEnd(((RecyclerView.LayoutManager)this).getChildAt(j)) > n) {
                        this.recycleChildren(recycler, 0, j);
                        return;
                    }
                }
            }
        }
    }
    
    private void resolveShouldLayoutReverse() {
        boolean mShouldReverseLayout = true;
        if (mOrientation == (mShouldReverseLayout ? 1 : 0) || !this.isLayoutRTL()) {
            this.mShouldReverseLayout = mReverseLayout;
            return;
        }
        if (mReverseLayout) {
            mShouldReverseLayout = false;
        }
        this.mShouldReverseLayout = mShouldReverseLayout;
    }
    
    private boolean updateAnchorFromChildren(final Recycler recycler, final State state, final AnchorInfo anchorInfo) {
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0) {
            final View focusedChild = ((RecyclerView.LayoutManager)this).getFocusedChild();
            if (focusedChild != null && anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
                anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild);
                return true;
            }
            if (mLastStackFromEnd == mStackFromEnd) {
                View view;
                if (anchorInfo.mLayoutFromEnd) {
                    view = this.findReferenceChildClosestToEnd(recycler, state);
                }
                else {
                    view = this.findReferenceChildClosestToStart(recycler, state);
                }
                if (view != null) {
                    anchorInfo.assignFromView(view);
                    if (!state.isPreLayout() && this.supportsPredictiveItemAnimations()) {
                        int n;
                        if (mOrientationHelper.getDecoratedStart(view) >= mOrientationHelper.getEndAfterPadding() || mOrientationHelper.getDecoratedEnd(view) < mOrientationHelper.getStartAfterPadding()) {
                            n = 1;
                        }
                        else {
                            n = 0;
                        }
                        if (n != 0) {
                            int mCoordinate;
                            if (anchorInfo.mLayoutFromEnd) {
                                mCoordinate = mOrientationHelper.getEndAfterPadding();
                            }
                            else {
                                mCoordinate = mOrientationHelper.getStartAfterPadding();
                            }
                            anchorInfo.mCoordinate = mCoordinate;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean updateAnchorFromPendingData(final State state, final AnchorInfo anchorInfo) {
        if (state.isPreLayout() || mPendingScrollPosition == -1) {
            return false;
        }
        if (mPendingScrollPosition < 0 || mPendingScrollPosition >= state.getItemCount()) {
            mPendingScrollPosition = -1;
            mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
        }
        anchorInfo.mPosition = mPendingScrollPosition;
        if (mPendingSavedState != null && mPendingSavedState.hasValidAnchor()) {
            anchorInfo.mLayoutFromEnd = mPendingSavedState.mAnchorLayoutFromEnd;
            if (anchorInfo.mLayoutFromEnd) {
                anchorInfo.mCoordinate = mOrientationHelper.getEndAfterPadding() - mPendingSavedState.mAnchorOffset;
                return true;
            }
            anchorInfo.mCoordinate = mOrientationHelper.getStartAfterPadding() + mPendingSavedState.mAnchorOffset;
            return true;
        }
        else if (mPendingScrollPositionOffset == Integer.MIN_VALUE) {
            final View viewByPosition = this.findViewByPosition(mPendingScrollPosition);
            if (viewByPosition == null) {
                if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
                    final boolean b = mPendingScrollPosition < ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0)) && true;
                    final boolean mShouldReverseLayout = this.mShouldReverseLayout;
                    boolean mLayoutFromEnd = false;
                    if (b == mShouldReverseLayout) {
                        mLayoutFromEnd = true;
                    }
                    anchorInfo.mLayoutFromEnd = mLayoutFromEnd;
                }
                anchorInfo.assignCoordinateFromPadding();
                return true;
            }
            if (mOrientationHelper.getDecoratedMeasurement(viewByPosition) > mOrientationHelper.getTotalSpace()) {
                anchorInfo.assignCoordinateFromPadding();
                return true;
            }
            if (mOrientationHelper.getDecoratedStart(viewByPosition) - mOrientationHelper.getStartAfterPadding() < 0) {
                anchorInfo.mCoordinate = mOrientationHelper.getStartAfterPadding();
                anchorInfo.mLayoutFromEnd = false;
                return true;
            }
            if (mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(viewByPosition) < 0) {
                anchorInfo.mCoordinate = mOrientationHelper.getEndAfterPadding();
                return anchorInfo.mLayoutFromEnd = true;
            }
            int decoratedStart;
            if (anchorInfo.mLayoutFromEnd) {
                decoratedStart = mOrientationHelper.getDecoratedEnd(viewByPosition) + mOrientationHelper.getTotalSpaceChange();
            }
            else {
                decoratedStart = mOrientationHelper.getDecoratedStart(viewByPosition);
            }
            anchorInfo.mCoordinate = decoratedStart;
            return true;
        }
        else {
            anchorInfo.mLayoutFromEnd = mShouldReverseLayout;
            if (mShouldReverseLayout) {
                anchorInfo.mCoordinate = mOrientationHelper.getEndAfterPadding() - mPendingScrollPositionOffset;
                return true;
            }
            anchorInfo.mCoordinate = mOrientationHelper.getStartAfterPadding() + mPendingScrollPositionOffset;
            return true;
        }
    }
    
    private void updateAnchorInfoForLayout(final Recycler recycler, final State state, final AnchorInfo anchorInfo) {
        if (!this.updateAnchorFromPendingData(state, anchorInfo) && !this.updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            int mPosition;
            if (mStackFromEnd) {
                mPosition = -1 + state.getItemCount();
            }
            else {
                mPosition = 0;
            }
            anchorInfo.mPosition = mPosition;
        }
    }
    
    private void updateLayoutState(final int mLayoutDirection, final int mAvailable, final boolean b, final State state) {
        int n = 1;
        final LayoutState mLayoutState = this.mLayoutState;
        boolean mInfinite;
        if (mOrientationHelper.getMode() == 0) {
            mInfinite = (n != 0);
        }
        else {
            mInfinite = false;
        }
        mLayoutState.mInfinite = mInfinite;
        this.mLayoutState.mExtra = this.getExtraLayoutSpace(state);
        this.mLayoutState.mLayoutDirection = mLayoutDirection;
        int mScrollingOffset;
        if (mLayoutDirection == n) {
            final LayoutState mLayoutState2 = this.mLayoutState;
            mLayoutState2.mExtra += mOrientationHelper.getEndPadding();
            final View childClosestToEnd = this.getChildClosestToEnd();
            final LayoutState mLayoutState3 = this.mLayoutState;
            if (mShouldReverseLayout) {
                n = -1;
            }
            mLayoutState3.mItemDirection = n;
            this.mLayoutState.mCurrentPosition = ((RecyclerView.LayoutManager)this).getPosition(childClosestToEnd) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            mScrollingOffset = mOrientationHelper.getDecoratedEnd(childClosestToEnd) - mOrientationHelper.getEndAfterPadding();
        }
        else {
            final View childClosestToStart = this.getChildClosestToStart();
            final LayoutState mLayoutState4 = this.mLayoutState;
            mLayoutState4.mExtra += mOrientationHelper.getStartAfterPadding();
            final LayoutState mLayoutState5 = this.mLayoutState;
            if (!mShouldReverseLayout) {
                n = -1;
            }
            mLayoutState5.mItemDirection = n;
            this.mLayoutState.mCurrentPosition = ((RecyclerView.LayoutManager)this).getPosition(childClosestToStart) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = mOrientationHelper.getDecoratedStart(childClosestToStart);
            mScrollingOffset = -mOrientationHelper.getDecoratedStart(childClosestToStart) + mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mAvailable = mAvailable;
        if (b) {
            final LayoutState mLayoutState6 = this.mLayoutState;
            mLayoutState6.mAvailable -= mScrollingOffset;
        }
        this.mLayoutState.mScrollingOffset = mScrollingOffset;
    }
    
    private void updateLayoutStateToFillEnd(final int mCurrentPosition, final int mOffset) {
        mLayoutState.mAvailable = mOrientationHelper.getEndAfterPadding() - mOffset;
        final LayoutState mLayoutState = this.mLayoutState;
        int mItemDirection;
        if (mShouldReverseLayout) {
            mItemDirection = -1;
        }
        else {
            mItemDirection = 1;
        }
        mLayoutState.mItemDirection = mItemDirection;
        this.mLayoutState.mCurrentPosition = mCurrentPosition;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = mOffset;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }
    
    private void updateLayoutStateToFillEnd(final AnchorInfo anchorInfo) {
        this.updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }
    
    private void updateLayoutStateToFillStart(final int mCurrentPosition, final int mOffset) {
        mLayoutState.mAvailable = mOffset - mOrientationHelper.getStartAfterPadding();
        mLayoutState.mCurrentPosition = mCurrentPosition;
        final LayoutState mLayoutState = this.mLayoutState;
        int mItemDirection;
        if (mShouldReverseLayout) {
            mItemDirection = 1;
        }
        else {
            mItemDirection = -1;
        }
        mLayoutState.mItemDirection = mItemDirection;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = mOffset;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }
    
    private void updateLayoutStateToFillStart(final AnchorInfo anchorInfo) {
        this.updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }
    
    @Override
    public void assertNotInLayoutOrScroll(final String s) {
        if (mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(s);
        }
    }
    
    @Override
    public boolean canScrollHorizontally() {
        return mOrientation == 0;
    }
    
    @Override
    public boolean canScrollVertically() {
        return mOrientation == 1;
    }
    
    @Override
    public int computeHorizontalScrollExtent(final State state) {
        return this.computeScrollExtent(state);
    }
    
    @Override
    public int computeHorizontalScrollOffset(final State state) {
        return this.computeScrollOffset(state);
    }
    
    @Override
    public int computeHorizontalScrollRange(final State state) {
        return this.computeScrollRange(state);
    }
    
    public PointF computeScrollVectorForPosition(final int n) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return null;
        }
        final int position = ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0));
        boolean b = false;
        if (n < position) {
            b = true;
        }
        int n2;
        if (b != mShouldReverseLayout) {
            n2 = -1;
        }
        else {
            n2 = 1;
        }
        if (mOrientation == 0) {
            return new PointF((float)n2, 0.0f);
        }
        return new PointF(0.0f, (float)n2);
    }
    
    @Override
    public int computeVerticalScrollExtent(final State state) {
        return this.computeScrollExtent(state);
    }
    
    @Override
    public int computeVerticalScrollOffset(final State state) {
        return this.computeScrollOffset(state);
    }
    
    @Override
    public int computeVerticalScrollRange(final State state) {
        return this.computeScrollRange(state);
    }
    
    int convertFocusDirectionToLayoutDirection(final int n) {
        int n2 = -1;
        int n3 = 1;
        int n4 = Integer.MIN_VALUE;
        switch (n) {
            default:
                n2 = n4;
                return n2;
            case 1:
                return n2;
            case 2:
                return n3;
            case 33:
                if (mOrientation != n3) {
                    return n4;
                }
                return n2;
            case 130:
                if (mOrientation == n3) {
                    n4 = n3;
                }
                return n4;
            case 17:
                if (mOrientation != 0) {
                    return n4;
                }
                return n2;
            case 66:
                if (mOrientation != 0) {
                    n3 = n4;
                }
                return n3;
        }
    }
    
    LayoutState createLayoutState() {
        return new LayoutState();
    }
    
    void ensureLayoutState() {
        if (mLayoutState == null) {
            mLayoutState = this.createLayoutState();
        }
        if (mOrientationHelper == null) {
            mOrientationHelper = OrientationHelper.createOrientationHelper(this, mOrientation);
        }
    }
    
    int fill(final Recycler recycler, final LayoutState layoutState, final State state, final boolean b) {
        final int mAvailable = layoutState.mAvailable;
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                layoutState.mScrollingOffset += layoutState.mAvailable;
            }
            this.recycleByLayoutState(recycler, layoutState);
        }
        int n = layoutState.mAvailable + layoutState.mExtra;
        final LayoutChunkResult layoutChunkResult = new LayoutChunkResult();
        while ((layoutState.mInfinite || n > 0) && layoutState.hasMore(state)) {
            layoutChunkResult.resetInternal();
            this.layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (layoutChunkResult.mFinished) {
                break;
            }
            layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
            if (!layoutChunkResult.mIgnoreConsumed || mLayoutState.mScrapList != null || !state.isPreLayout()) {
                layoutState.mAvailable -= layoutChunkResult.mConsumed;
                n -= layoutChunkResult.mConsumed;
            }
            if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
                layoutState.mScrollingOffset += layoutChunkResult.mConsumed;
                if (layoutState.mAvailable < 0) {
                    layoutState.mScrollingOffset += layoutState.mAvailable;
                }
                this.recycleByLayoutState(recycler, layoutState);
            }
            if (b && layoutChunkResult.mFocusable) {
                break;
            }
        }
        return mAvailable - layoutState.mAvailable;
    }
    
    public int findFirstCompletelyVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), true, false);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    public int findFirstVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), false, true);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    public int findLastCompletelyVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(-1 + ((RecyclerView.LayoutManager)this).getChildCount(), -1, true, false);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    public int findLastVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(-1 + ((RecyclerView.LayoutManager)this).getChildCount(), -1, false, true);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    View findOneVisibleChild(final int n, final int n2, final boolean b, final boolean b2) {
        this.ensureLayoutState();
        final int startAfterPadding = mOrientationHelper.getStartAfterPadding();
        final int endAfterPadding = mOrientationHelper.getEndAfterPadding();
        int n3;
        if (n2 > n) {
            n3 = 1;
        }
        else {
            n3 = -1;
        }
        View view = null;
        for (int i = n; i != n2; i += n3) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            final int decoratedStart = mOrientationHelper.getDecoratedStart(child);
            final int decoratedEnd = mOrientationHelper.getDecoratedEnd(child);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (!b || (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding)) {
                    return child;
                }
                if (b2 && view == null) {
                    view = child;
                }
            }
        }
        return view;
    }
    
    View findReferenceChild(final Recycler recycler, final State state, final int n, final int n2, final int n3) {
        this.ensureLayoutState();
        View view = null;
        View view2 = null;
        final int startAfterPadding = mOrientationHelper.getStartAfterPadding();
        final int endAfterPadding = mOrientationHelper.getEndAfterPadding();
        int n4;
        if (n2 > n) {
            n4 = 1;
        }
        else {
            n4 = -1;
        }
        for (int i = n; i != n2; i += n4) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            final int position = ((RecyclerView.LayoutManager)this).getPosition(child);
            if (position >= 0 && position < n3) {
                if (((LayoutParams)child.getLayoutParams()).isItemRemoved()) {
                    if (view == null) {
                        view = child;
                    }
                }
                else {
                    if (mOrientationHelper.getDecoratedStart(child) < endAfterPadding && mOrientationHelper.getDecoratedEnd(child) >= startAfterPadding) {
                        return child;
                    }
                    if (view2 == null) {
                        view2 = child;
                    }
                }
            }
        }
        if (view2 == null) {
            view2 = view;
        }
        return view2;
    }
    
    @Override
    public View findViewByPosition(final int n) {
        final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
        if (childCount != 0) {
            final int n2 = n - ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0));
            if (n2 >= 0 && n2 < childCount) {
                final View child = ((RecyclerView.LayoutManager)this).getChildAt(n2);
                if (((RecyclerView.LayoutManager)this).getPosition(child) == n) {
                    return child;
                }
            }
            return super.findViewByPosition(n);
        }
        return null;
    }
    
    @Override
    public LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }
    
    protected int getExtraLayoutSpace(final State state) {
        if (state.hasTargetScrollPosition()) {
            return mOrientationHelper.getTotalSpace();
        }
        return 0;
    }
    
    public int getOrientation() {
        return mOrientation;
    }
    
    public boolean getRecycleChildrenOnDetach() {
        return mRecycleChildrenOnDetach;
    }
    
    public boolean getReverseLayout() {
        return mReverseLayout;
    }
    
    public boolean getStackFromEnd() {
        return mStackFromEnd;
    }
    
    protected boolean isLayoutRTL() {
        return ((RecyclerView.LayoutManager)this).getLayoutDirection() == 1;
    }
    
    public boolean isSmoothScrollbarEnabled() {
        return mSmoothScrollbarEnabled;
    }
    
    void layoutChunk(final Recycler recycler, final State state, final LayoutState layoutState, final LayoutChunkResult layoutChunkResult) {
        final View next = layoutState.next(recycler);
        if (next == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        final LayoutParams layoutParams = (LayoutParams)next.getLayoutParams();
        if (layoutState.mScrapList == null) {
            if (mShouldReverseLayout == (layoutState.mLayoutDirection == -1)) {
                ((RecyclerView.LayoutManager)this).addView(next);
            }
            else {
                ((RecyclerView.LayoutManager)this).addView(next, 0);
            }
        }
        else if (mShouldReverseLayout == (layoutState.mLayoutDirection == -1)) {
            ((RecyclerView.LayoutManager)this).addDisappearingView(next);
        }
        else {
            ((RecyclerView.LayoutManager)this).addDisappearingView(next, 0);
        }
        ((RecyclerView.LayoutManager)this).measureChildWithMargins(next, 0, 0);
        layoutChunkResult.mConsumed = mOrientationHelper.getDecoratedMeasurement(next);
        int mOffset;
        int n;
        int mOffset2;
        int n2;
        if (mOrientation == 1) {
            if (this.isLayoutRTL()) {
                mOffset = ((RecyclerView.LayoutManager)this).getWidth() - ((RecyclerView.LayoutManager)this).getPaddingRight();
                n = mOffset - mOrientationHelper.getDecoratedMeasurementInOther(next);
            }
            else {
                n = ((RecyclerView.LayoutManager)this).getPaddingLeft();
                mOffset = n + mOrientationHelper.getDecoratedMeasurementInOther(next);
            }
            if (layoutState.mLayoutDirection == -1) {
                mOffset2 = layoutState.mOffset;
                n2 = layoutState.mOffset - layoutChunkResult.mConsumed;
            }
            else {
                n2 = layoutState.mOffset;
                mOffset2 = layoutState.mOffset + layoutChunkResult.mConsumed;
            }
        }
        else {
            n2 = ((RecyclerView.LayoutManager)this).getPaddingTop();
            mOffset2 = n2 + mOrientationHelper.getDecoratedMeasurementInOther(next);
            if (layoutState.mLayoutDirection == -1) {
                mOffset = layoutState.mOffset;
                n = layoutState.mOffset - layoutChunkResult.mConsumed;
            }
            else {
                n = layoutState.mOffset;
                mOffset = layoutState.mOffset + layoutChunkResult.mConsumed;
            }
        }
        ((RecyclerView.LayoutManager)this).layoutDecorated(next, n + layoutParams.leftMargin, n2 + layoutParams.topMargin, mOffset - layoutParams.rightMargin, mOffset2 - layoutParams.bottomMargin);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.isFocusable();
    }
    
    void onAnchorReady(final Recycler recycler, final State state, final AnchorInfo anchorInfo, final int n) {
    }
    
    @Override
    public void onDetachedFromWindow(final RecyclerView recyclerView, final Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (mRecycleChildrenOnDetach) {
            ((RecyclerView.LayoutManager)this).removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }
    
    @Override
    public View onFocusSearchFailed(final View view, final int n, final Recycler recycler, final State state) {
        this.resolveShouldLayoutReverse();
        View view2;
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            view2 = null;
        }
        else {
            final int convertFocusDirectionToLayoutDirection = this.convertFocusDirectionToLayoutDirection(n);
            if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
                return null;
            }
            this.ensureLayoutState();
            View view3;
            if (convertFocusDirectionToLayoutDirection == -1) {
                view3 = this.findReferenceChildClosestToStart(recycler, state);
            }
            else {
                view3 = this.findReferenceChildClosestToEnd(recycler, state);
            }
            if (view3 == null) {
                return null;
            }
            this.ensureLayoutState();
            this.updateLayoutState(convertFocusDirectionToLayoutDirection, (int)(0.33333334f * mOrientationHelper.getTotalSpace()), false, state);
            mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
            mLayoutState.mRecycle = false;
            this.fill(recycler, mLayoutState, state, true);
            if (convertFocusDirectionToLayoutDirection == -1) {
                view2 = this.getChildClosestToStart();
            }
            else {
                view2 = this.getChildClosestToEnd();
            }
            if (view2 == view3 || !view2.isFocusable()) {
                return null;
            }
        }
        return view2;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
            final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(accessibilityEvent);
            record.setFromIndex(this.findFirstVisibleItemPosition());
            record.setToIndex(this.findLastVisibleItemPosition());
        }
    }
    
    @Override
    public void onLayoutChildren(final Recycler recycler, final State state) {
        if ((mPendingSavedState != null || mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            ((RecyclerView.LayoutManager)this).removeAndRecycleAllViews(recycler);
            return;
        }
        if (mPendingSavedState != null && mPendingSavedState.hasValidAnchor()) {
            mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
        }
        this.ensureLayoutState();
        mLayoutState.mRecycle = false;
        this.resolveShouldLayoutReverse();
        mAnchorInfo.reset();
        mAnchorInfo.mLayoutFromEnd = (mShouldReverseLayout ^ mStackFromEnd);
        this.updateAnchorInfoForLayout(recycler, state, mAnchorInfo);
        final int extraLayoutSpace = this.getExtraLayoutSpace(state);
        int n;
        int n2;
        if (mLayoutState.mLastScrollDelta >= 0) {
            n = extraLayoutSpace;
            n2 = 0;
        }
        else {
            n2 = extraLayoutSpace;
            n = 0;
        }
        int n3 = n2 + mOrientationHelper.getStartAfterPadding();
        int n4 = n + mOrientationHelper.getEndPadding();
        if (state.isPreLayout() && mPendingScrollPosition != -1 && mPendingScrollPositionOffset != Integer.MIN_VALUE) {
            final View viewByPosition = this.findViewByPosition(mPendingScrollPosition);
            if (viewByPosition != null) {
                int n5;
                if (mShouldReverseLayout) {
                    n5 = mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(viewByPosition) - mPendingScrollPositionOffset;
                }
                else {
                    n5 = mPendingScrollPositionOffset - (mOrientationHelper.getDecoratedStart(viewByPosition) - mOrientationHelper.getStartAfterPadding());
                }
                if (n5 > 0) {
                    n3 += n5;
                }
                else {
                    n4 -= n5;
                }
            }
        }
        int n6;
        if (mAnchorInfo.mLayoutFromEnd) {
            if (mShouldReverseLayout) {
                n6 = 1;
            }
            else {
                n6 = -1;
            }
        }
        else if (mShouldReverseLayout) {
            n6 = -1;
        }
        else {
            n6 = 1;
        }
        this.onAnchorReady(recycler, state, mAnchorInfo, n6);
        ((RecyclerView.LayoutManager)this).detachAndScrapAttachedViews(recycler);
        mLayoutState.mInfinite = (mOrientationHelper.getMode() == 0);
        mLayoutState.mIsPreLayout = state.isPreLayout();
        int n7;
        int n8;
        if (mAnchorInfo.mLayoutFromEnd) {
            this.updateLayoutStateToFillStart(mAnchorInfo);
            mLayoutState.mExtra = n3;
            this.fill(recycler, mLayoutState, state, false);
            n7 = mLayoutState.mOffset;
            final int mCurrentPosition = mLayoutState.mCurrentPosition;
            if (mLayoutState.mAvailable > 0) {
                n4 += mLayoutState.mAvailable;
            }
            this.updateLayoutStateToFillEnd(mAnchorInfo);
            mLayoutState.mExtra = n4;
            final LayoutState mLayoutState = this.mLayoutState;
            mLayoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(recycler, this.mLayoutState, state, false);
            n8 = this.mLayoutState.mOffset;
            if (this.mLayoutState.mAvailable > 0) {
                final int mAvailable = this.mLayoutState.mAvailable;
                this.updateLayoutStateToFillStart(mCurrentPosition, n7);
                this.mLayoutState.mExtra = mAvailable;
                this.fill(recycler, this.mLayoutState, state, false);
                n7 = this.mLayoutState.mOffset;
            }
        }
        else {
            this.updateLayoutStateToFillEnd(mAnchorInfo);
            mLayoutState.mExtra = n4;
            this.fill(recycler, mLayoutState, state, false);
            n8 = mLayoutState.mOffset;
            final int mCurrentPosition2 = mLayoutState.mCurrentPosition;
            if (mLayoutState.mAvailable > 0) {
                n3 += mLayoutState.mAvailable;
            }
            this.updateLayoutStateToFillStart(mAnchorInfo);
            mLayoutState.mExtra = n3;
            final LayoutState mLayoutState2 = mLayoutState;
            mLayoutState2.mCurrentPosition += mLayoutState.mItemDirection;
            this.fill(recycler, mLayoutState, state, false);
            n7 = mLayoutState.mOffset;
            if (mLayoutState.mAvailable > 0) {
                final int mAvailable2 = mLayoutState.mAvailable;
                this.updateLayoutStateToFillEnd(mCurrentPosition2, n8);
                mLayoutState.mExtra = mAvailable2;
                this.fill(recycler, mLayoutState, state, false);
                n8 = mLayoutState.mOffset;
            }
        }
        if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
            if (mShouldReverseLayout ^ mStackFromEnd) {
                final int fixLayoutEndGap = this.fixLayoutEndGap(n8, recycler, state, true);
                final int n9 = n7 + fixLayoutEndGap;
                final int n10 = n8 + fixLayoutEndGap;
                final int fixLayoutStartGap = this.fixLayoutStartGap(n9, recycler, state, false);
                n7 = n9 + fixLayoutStartGap;
                n8 = n10 + fixLayoutStartGap;
            }
            else {
                final int fixLayoutStartGap2 = this.fixLayoutStartGap(n7, recycler, state, true);
                final int n11 = n7 + fixLayoutStartGap2;
                final int n12 = n8 + fixLayoutStartGap2;
                final int fixLayoutEndGap2 = this.fixLayoutEndGap(n12, recycler, state, false);
                n7 = n11 + fixLayoutEndGap2;
                n8 = n12 + fixLayoutEndGap2;
            }
        }
        this.layoutForPredictiveAnimations(recycler, state, n7, n8);
        if (!state.isPreLayout()) {
            mPendingScrollPosition = -1;
            mPendingScrollPositionOffset = Integer.MIN_VALUE;
            mOrientationHelper.onLayoutComplete();
        }
        mLastStackFromEnd = mStackFromEnd;
        mPendingSavedState = null;
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            mPendingSavedState = (SavedState)parcelable;
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        if (mPendingSavedState != null) {
            return (Parcelable)new SavedState(mPendingSavedState);
        }
        final SavedState savedState = new SavedState();
        if (((RecyclerView.LayoutManager)this).getChildCount() <= 0) {
            savedState.invalidateAnchor();
            return (Parcelable)savedState;
        }
        this.ensureLayoutState();
        final boolean mAnchorLayoutFromEnd = mLastStackFromEnd ^ mShouldReverseLayout;
        savedState.mAnchorLayoutFromEnd = mAnchorLayoutFromEnd;
        if (mAnchorLayoutFromEnd) {
            final View childClosestToEnd = this.getChildClosestToEnd();
            savedState.mAnchorOffset = mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            savedState.mAnchorPosition = ((RecyclerView.LayoutManager)this).getPosition(childClosestToEnd);
            return (Parcelable)savedState;
        }
        final View childClosestToStart = this.getChildClosestToStart();
        savedState.mAnchorPosition = ((RecyclerView.LayoutManager)this).getPosition(childClosestToStart);
        savedState.mAnchorOffset = mOrientationHelper.getDecoratedStart(childClosestToStart) - mOrientationHelper.getStartAfterPadding();
        return (Parcelable)savedState;
    }
    
    @Override
    public void prepareForDrop(final View view, final View view2, final int n, final int n2) {
        this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        this.ensureLayoutState();
        this.resolveShouldLayoutReverse();
        final int position = ((RecyclerView.LayoutManager)this).getPosition(view);
        final int position2 = ((RecyclerView.LayoutManager)this).getPosition(view2);
        int n3;
        if (position < position2) {
            n3 = 1;
        }
        else {
            n3 = -1;
        }
        if (mShouldReverseLayout) {
            if (n3 == 1) {
                this.scrollToPositionWithOffset(position2, mOrientationHelper.getEndAfterPadding() - (mOrientationHelper.getDecoratedStart(view2) + mOrientationHelper.getDecoratedMeasurement(view)));
                return;
            }
            this.scrollToPositionWithOffset(position2, mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(view2));
        }
        else {
            if (n3 == -1) {
                this.scrollToPositionWithOffset(position2, mOrientationHelper.getDecoratedStart(view2));
                return;
            }
            this.scrollToPositionWithOffset(position2, mOrientationHelper.getDecoratedEnd(view2) - mOrientationHelper.getDecoratedMeasurement(view));
        }
    }
    
    int scrollBy(final int n, final Recycler recycler, final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0 && n != 0) {
            mLayoutState.mRecycle = true;
            this.ensureLayoutState();
            int n2;
            if (n > 0) {
                n2 = 1;
            }
            else {
                n2 = -1;
            }
            final int abs = Math.abs(n);
            this.updateLayoutState(n2, abs, true, state);
            final int n3 = mLayoutState.mScrollingOffset + this.fill(recycler, mLayoutState, state, false);
            if (n3 >= 0) {
                int mLastScrollDelta;
                if (abs > n3) {
                    mLastScrollDelta = n2 * n3;
                }
                else {
                    mLastScrollDelta = n;
                }
                mOrientationHelper.offsetChildren(-mLastScrollDelta);
                return mLayoutState.mLastScrollDelta = mLastScrollDelta;
            }
        }
        return 0;
    }
    
    @Override
    public int scrollHorizontallyBy(final int n, final Recycler recycler, final State state) {
        if (mOrientation == 1) {
            return 0;
        }
        return this.scrollBy(n, recycler, state);
    }
    
    @Override
    public void scrollToPosition(final int mPendingScrollPosition) {
        this.mPendingScrollPosition = mPendingScrollPosition;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (mPendingSavedState != null) {
            mPendingSavedState.invalidateAnchor();
        }
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    public void scrollToPositionWithOffset(final int mPendingScrollPosition, final int mPendingScrollPositionOffset) {
        this.mPendingScrollPosition = mPendingScrollPosition;
        this.mPendingScrollPositionOffset = mPendingScrollPositionOffset;
        if (mPendingSavedState != null) {
            mPendingSavedState.invalidateAnchor();
        }
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    @Override
    public int scrollVerticallyBy(final int n, final Recycler recycler, final State state) {
        if (mOrientation == 0) {
            return 0;
        }
        return this.scrollBy(n, recycler, state);
    }
    
    public void setOrientation(final int mOrientation) {
        if (mOrientation != 0 && mOrientation != 1) {
            throw new IllegalArgumentException("invalid orientation:" + mOrientation);
        }
        this.assertNotInLayoutOrScroll(null);
        if (mOrientation == this.mOrientation) {
            return;
        }
        this.mOrientation = mOrientation;
        mOrientationHelper = null;
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    public void setRecycleChildrenOnDetach(final boolean mRecycleChildrenOnDetach) {
        this.mRecycleChildrenOnDetach = mRecycleChildrenOnDetach;
    }
    
    public void setReverseLayout(final boolean mReverseLayout) {
        this.assertNotInLayoutOrScroll(null);
        if (mReverseLayout == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = mReverseLayout;
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    public void setSmoothScrollbarEnabled(final boolean mSmoothScrollbarEnabled) {
        this.mSmoothScrollbarEnabled = mSmoothScrollbarEnabled;
    }
    
    public void setStackFromEnd(final boolean mStackFromEnd) {
        this.assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == mStackFromEnd) {
            return;
        }
        this.mStackFromEnd = mStackFromEnd;
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    @Override
    boolean shouldMeasureTwice() {
        return ((RecyclerView.LayoutManager)this).getHeightMode() != 1073741824 && ((RecyclerView.LayoutManager)this).getWidthMode() != 1073741824 && ((RecyclerView.LayoutManager)this).hasFlexibleChildInBothOrientations();
    }
    
    @Override
    public void smoothScrollToPosition(final RecyclerView recyclerView, final State state, final int targetPosition) {
        final LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
            final /* synthetic */ LinearLayoutManager this$0;
            
            LinearLayoutManager$1(final Context context) {
                this$0 = this$0;
                super(context);
            }
            
            @Override
            public PointF computeScrollVectorForPosition(final int n) {
                return this$0.computeScrollVectorForPosition(n);
            }
        };
        ((RecyclerView.SmoothScroller)linearSmoothScroller).setTargetPosition(targetPosition);
        ((RecyclerView.LayoutManager)this).startSmoothScroll(linearSmoothScroller);
    }
    
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return mPendingSavedState == null && mLastStackFromEnd == mStackFromEnd;
    }
    
    void validateChildOrder() {
        int n = 1;
        Log.d("LinearLayoutManager", "validating child count " + ((RecyclerView.LayoutManager)this).getChildCount());
        if (((RecyclerView.LayoutManager)this).getChildCount() >= n) {
            final int position = ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0));
            final int decoratedStart = mOrientationHelper.getDecoratedStart(((RecyclerView.LayoutManager)this).getChildAt(0));
            if (mShouldReverseLayout) {
                for (int i = 1; i < ((RecyclerView.LayoutManager)this).getChildCount(); ++i) {
                    final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
                    final int position2 = ((RecyclerView.LayoutManager)this).getPosition(child);
                    final int decoratedStart2 = mOrientationHelper.getDecoratedStart(child);
                    if (position2 < position) {
                        this.logChildren();
                        final StringBuilder append = new StringBuilder().append("detected invalid position. loc invalid? ");
                        if (decoratedStart2 >= decoratedStart) {
                            n = 0;
                        }
                        throw new RuntimeException(append.append(n != 0).toString());
                    }
                    if (decoratedStart2 > decoratedStart) {
                        this.logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
            }
            else {
                for (int j = 1; j < ((RecyclerView.LayoutManager)this).getChildCount(); ++j) {
                    final View child2 = ((RecyclerView.LayoutManager)this).getChildAt(j);
                    final int position3 = ((RecyclerView.LayoutManager)this).getPosition(child2);
                    final int decoratedStart3 = mOrientationHelper.getDecoratedStart(child2);
                    if (position3 < position) {
                        this.logChildren();
                        final StringBuilder append2 = new StringBuilder().append("detected invalid position. loc invalid? ");
                        if (decoratedStart3 >= decoratedStart) {
                            n = 0;
                        }
                        throw new RuntimeException(append2.append(n != 0).toString());
                    }
                    if (decoratedStart3 < decoratedStart) {
                        this.logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
            }
        }
    }
}
