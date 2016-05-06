package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.support.annotation.Nullable;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.view.View$MeasureSpec;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import java.util.BitSet;

public class StaggeredGridLayoutManager extends LayoutManager
{
    private static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    public static final String TAG = "StaggeredGridLayoutManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    private boolean mReverseLayout;
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    private Span[] mSpans;
    private final Rect mTmpRect;
    
    public StaggeredGridLayoutManager(final int spanCount, final int mOrientation) {
        boolean b = true;
        super();
        mSpanCount = -1;
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        mLazySpanLookup = new LazySpanLookup();
        mGapStrategy = 2;
        mTmpRect = new Rect();
        mAnchorInfo = new AnchorInfo(this);
        mLaidOutInvalidFullSpan = false;
        mSmoothScrollbarEnabled = b;
        mCheckForGapsRunnable = new Runnable() {
            final /* synthetic */ StaggeredGridLayoutManager this$0;
            
            StaggeredGridLayoutManager$1(final StaggeredGridLayoutManager this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.checkForGaps();
            }
        };
        mOrientation = mOrientation;
        this.setSpanCount(spanCount);
        if (mGapStrategy == 0) {
            b = false;
        }
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(b);
    }
    
    public StaggeredGridLayoutManager(final Context context, final AttributeSet set, final int n, final int n2) {
        boolean b = true;
        super();
        mSpanCount = -1;
        mReverseLayout = false;
        mShouldReverseLayout = false;
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        mLazySpanLookup = new LazySpanLookup();
        mGapStrategy = 2;
        mTmpRect = new Rect();
        mAnchorInfo = new AnchorInfo(this);
        mLaidOutInvalidFullSpan = false;
        mSmoothScrollbarEnabled = b;
        mCheckForGapsRunnable = new Runnable() {
            final /* synthetic */ StaggeredGridLayoutManager this$0;
            
            StaggeredGridLayoutManager$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.checkForGaps();
            }
        };
        final Properties properties = RecyclerView.LayoutManager.getProperties(context, set, n, n2);
        this.setOrientation(properties.orientation);
        this.setSpanCount(properties.spanCount);
        this.setReverseLayout(properties.reverseLayout);
        if (mGapStrategy == 0) {
            b = false;
        }
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(b);
    }
    
    static /* synthetic */ boolean access$100(final StaggeredGridLayoutManager staggeredGridLayoutManager) {
        return staggeredGridLayoutManager.checkForGaps();
    }
    
    static /* synthetic */ int access$400(final StaggeredGridLayoutManager staggeredGridLayoutManager, final int n) {
        return staggeredGridLayoutManager.calculateScrollDirectionForPosition(n);
    }
    
    static /* synthetic */ int access$500(final StaggeredGridLayoutManager staggeredGridLayoutManager) {
        return staggeredGridLayoutManager.mOrientation;
    }
    
    static /* synthetic */ boolean access$600(final StaggeredGridLayoutManager staggeredGridLayoutManager) {
        return staggeredGridLayoutManager.mReverseLayout;
    }
    
    private void appendViewToAllSpans(final View view) {
        for (int i = -1 + mSpanCount; i >= 0; --i) {
            mSpans[i].appendToSpan(view);
        }
    }
    
    private void applyPendingSavedState(final AnchorInfo anchorInfo) {
        if (mPendingSavedState.mSpanOffsetsSize > 0) {
            if (mPendingSavedState.mSpanOffsetsSize == mSpanCount) {
                for (int i = 0; i < mSpanCount; ++i) {
                    mSpans[i].clear();
                    int line = mPendingSavedState.mSpanOffsets[i];
                    if (line != Integer.MIN_VALUE) {
                        if (mPendingSavedState.mAnchorLayoutFromEnd) {
                            line += mPrimaryOrientation.getEndAfterPadding();
                        }
                        else {
                            line += mPrimaryOrientation.getStartAfterPadding();
                        }
                    }
                    mSpans[i].setLine(line);
                }
            }
            else {
                mPendingSavedState.invalidateSpanInfo();
                mPendingSavedState.mAnchorPosition = mPendingSavedState.mVisibleAnchorPosition;
            }
        }
        mLastLayoutRTL = mPendingSavedState.mLastLayoutRTL;
        this.setReverseLayout(mPendingSavedState.mReverseLayout);
        this.resolveShouldLayoutReverse();
        if (mPendingSavedState.mAnchorPosition != -1) {
            mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
            anchorInfo.mLayoutFromEnd = mPendingSavedState.mAnchorLayoutFromEnd;
        }
        else {
            anchorInfo.mLayoutFromEnd = mShouldReverseLayout;
        }
        if (mPendingSavedState.mSpanLookupSize > 1) {
            mLazySpanLookup.mData = mPendingSavedState.mSpanLookup;
            mLazySpanLookup.mFullSpanItems = mPendingSavedState.mFullSpanItems;
        }
    }
    
    private void attachViewToSpans(final View view, final LayoutParams layoutParams, final LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                this.appendViewToAllSpans(view);
                return;
            }
            layoutParams.mSpan.appendToSpan(view);
        }
        else {
            if (layoutParams.mFullSpan) {
                this.prependViewToAllSpans(view);
                return;
            }
            layoutParams.mSpan.prependToSpan(view);
        }
    }
    
    private int calculateScrollDirectionForPosition(final int n) {
        int n2 = -1;
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0) {
            if (n < this.getFirstChildPosition() == mShouldReverseLayout) {
                n2 = 1;
            }
            return n2;
        }
        if (mShouldReverseLayout) {
            return 1;
        }
        return n2;
    }
    
    private boolean checkForGaps() {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0 || mGapStrategy == 0 || !((RecyclerView.LayoutManager)this).isAttachedToWindow()) {
            return false;
        }
        int n;
        int n2;
        if (mShouldReverseLayout) {
            n = this.getLastChildPosition();
            n2 = this.getFirstChildPosition();
        }
        else {
            n = this.getFirstChildPosition();
            n2 = this.getLastChildPosition();
        }
        if (n == 0 && this.hasGapsToFix() != null) {
            mLazySpanLookup.clear();
            ((RecyclerView.LayoutManager)this).requestSimpleAnimationsInNextLayout();
            ((RecyclerView.LayoutManager)this).requestLayout();
            return true;
        }
        if (!mLaidOutInvalidFullSpan) {
            return false;
        }
        int n3;
        if (mShouldReverseLayout) {
            n3 = -1;
        }
        else {
            n3 = 1;
        }
        final FullSpanItem firstFullSpanItemInRange = mLazySpanLookup.getFirstFullSpanItemInRange(n, n2 + 1, n3, true);
        if (firstFullSpanItemInRange == null) {
            mLaidOutInvalidFullSpan = false;
            mLazySpanLookup.forceInvalidateAfter(n2 + 1);
            return false;
        }
        final FullSpanItem firstFullSpanItemInRange2 = mLazySpanLookup.getFirstFullSpanItemInRange(n, firstFullSpanItemInRange.mPosition, n3 * -1, true);
        if (firstFullSpanItemInRange2 == null) {
            mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
        }
        else {
            mLazySpanLookup.forceInvalidateAfter(1 + firstFullSpanItemInRange2.mPosition);
        }
        ((RecyclerView.LayoutManager)this).requestSimpleAnimationsInNextLayout();
        ((RecyclerView.LayoutManager)this).requestLayout();
        return true;
    }
    
    private boolean checkSpanForGap(final Span span) {
        if (mShouldReverseLayout) {
            if (span.getEndLine() >= mPrimaryOrientation.getEndAfterPadding()) {
                return false;
            }
            if (span.getLayoutParams(span.mViews.get(-1 + span.mViews.size())).mFullSpan) {
                return false;
            }
        }
        else {
            if (span.getStartLine() <= mPrimaryOrientation.getStartAfterPadding()) {
                return false;
            }
            if (span.getLayoutParams(span.mViews.get(0)).mFullSpan) {
                return false;
            }
        }
        return true;
    }
    
    private int computeScrollExtent(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        this.ensureOrientationHelper();
        final OrientationHelper mPrimaryOrientation = this.mPrimaryOrientation;
        final View firstVisibleItemClosestToStart = this.findFirstVisibleItemClosestToStart(!mSmoothScrollbarEnabled, true);
        final boolean mSmoothScrollbarEnabled = this.mSmoothScrollbarEnabled;
        boolean b = false;
        if (!mSmoothScrollbarEnabled) {
            b = true;
        }
        return ScrollbarHelper.computeScrollExtent(state, mPrimaryOrientation, firstVisibleItemClosestToStart, this.findFirstVisibleItemClosestToEnd(b, true), this, this.mSmoothScrollbarEnabled);
    }
    
    private int computeScrollOffset(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        this.ensureOrientationHelper();
        final OrientationHelper mPrimaryOrientation = this.mPrimaryOrientation;
        final View firstVisibleItemClosestToStart = this.findFirstVisibleItemClosestToStart(!mSmoothScrollbarEnabled, true);
        final boolean mSmoothScrollbarEnabled = this.mSmoothScrollbarEnabled;
        boolean b = false;
        if (!mSmoothScrollbarEnabled) {
            b = true;
        }
        return ScrollbarHelper.computeScrollOffset(state, mPrimaryOrientation, firstVisibleItemClosestToStart, this.findFirstVisibleItemClosestToEnd(b, true), this, this.mSmoothScrollbarEnabled, mShouldReverseLayout);
    }
    
    private int computeScrollRange(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        this.ensureOrientationHelper();
        final OrientationHelper mPrimaryOrientation = this.mPrimaryOrientation;
        final View firstVisibleItemClosestToStart = this.findFirstVisibleItemClosestToStart(!mSmoothScrollbarEnabled, true);
        final boolean mSmoothScrollbarEnabled = this.mSmoothScrollbarEnabled;
        boolean b = false;
        if (!mSmoothScrollbarEnabled) {
            b = true;
        }
        return ScrollbarHelper.computeScrollRange(state, mPrimaryOrientation, firstVisibleItemClosestToStart, this.findFirstVisibleItemClosestToEnd(b, true), this, this.mSmoothScrollbarEnabled);
    }
    
    private int convertFocusDirectionToLayoutDirection(final int n) {
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
    
    private FullSpanItem createFullSpanItemFromEnd(final int n) {
        final FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[mSpanCount];
        for (int i = 0; i < mSpanCount; ++i) {
            fullSpanItem.mGapPerSpan[i] = n - mSpans[i].getEndLine(n);
        }
        return fullSpanItem;
    }
    
    private FullSpanItem createFullSpanItemFromStart(final int n) {
        final FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[mSpanCount];
        for (int i = 0; i < mSpanCount; ++i) {
            fullSpanItem.mGapPerSpan[i] = mSpans[i].getStartLine(n) - n;
        }
        return fullSpanItem;
    }
    
    private void ensureOrientationHelper() {
        if (mPrimaryOrientation == null) {
            mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, mOrientation);
            mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - mOrientation);
            mLayoutState = new LayoutState();
        }
    }
    
    private int fill(final Recycler recycler, final LayoutState layoutState, final State state) {
        mRemainingSpans.set(0, mSpanCount, true);
        int n;
        if (mLayoutState.mInfinite) {
            if (layoutState.mLayoutDirection == 1) {
                n = Integer.MAX_VALUE;
            }
            else {
                n = Integer.MIN_VALUE;
            }
        }
        else if (layoutState.mLayoutDirection == 1) {
            n = layoutState.mEndLine + layoutState.mAvailable;
        }
        else {
            n = layoutState.mStartLine - layoutState.mAvailable;
        }
        this.updateAllRemainingSpans(layoutState.mLayoutDirection, n);
        int n2;
        if (mShouldReverseLayout) {
            n2 = mPrimaryOrientation.getEndAfterPadding();
        }
        else {
            n2 = mPrimaryOrientation.getStartAfterPadding();
        }
        boolean b = false;
        while (layoutState.hasMore(state) && (mLayoutState.mInfinite || !mRemainingSpans.isEmpty())) {
            final View next = layoutState.next(recycler);
            final LayoutParams layoutParams = (LayoutParams)next.getLayoutParams();
            final int viewLayoutPosition = ((RecyclerView.LayoutParams)layoutParams).getViewLayoutPosition();
            final int span = mLazySpanLookup.getSpan(viewLayoutPosition);
            int n3;
            if (span == -1) {
                n3 = 1;
            }
            else {
                n3 = 0;
            }
            Span nextSpan;
            if (n3 != 0) {
                if (layoutParams.mFullSpan) {
                    nextSpan = mSpans[0];
                }
                else {
                    nextSpan = this.getNextSpan(layoutState);
                }
                mLazySpanLookup.setSpan(viewLayoutPosition, nextSpan);
            }
            else {
                nextSpan = mSpans[span];
            }
            layoutParams.mSpan = nextSpan;
            if (layoutState.mLayoutDirection == 1) {
                ((RecyclerView.LayoutManager)this).addView(next);
            }
            else {
                ((RecyclerView.LayoutManager)this).addView(next, 0);
            }
            this.measureChildWithDecorationsAndMargin(next, layoutParams, false);
            int n4;
            int n5;
            if (layoutState.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    n4 = this.getMaxEnd(n2);
                }
                else {
                    n4 = nextSpan.getEndLine(n2);
                }
                n5 = n4 + mPrimaryOrientation.getDecoratedMeasurement(next);
                if (n3 != 0 && layoutParams.mFullSpan) {
                    final FullSpanItem fullSpanItemFromEnd = this.createFullSpanItemFromEnd(n4);
                    fullSpanItemFromEnd.mGapDir = -1;
                    fullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    mLazySpanLookup.addFullSpanItem(fullSpanItemFromEnd);
                }
            }
            else {
                if (layoutParams.mFullSpan) {
                    n5 = this.getMinStart(n2);
                }
                else {
                    n5 = nextSpan.getStartLine(n2);
                }
                n4 = n5 - mPrimaryOrientation.getDecoratedMeasurement(next);
                if (n3 != 0 && layoutParams.mFullSpan) {
                    final FullSpanItem fullSpanItemFromStart = this.createFullSpanItemFromStart(n5);
                    fullSpanItemFromStart.mGapDir = 1;
                    fullSpanItemFromStart.mPosition = viewLayoutPosition;
                    mLazySpanLookup.addFullSpanItem(fullSpanItemFromStart);
                }
            }
            if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (n3 != 0) {
                    mLaidOutInvalidFullSpan = true;
                }
                else {
                    int n6;
                    if (layoutState.mLayoutDirection == 1) {
                        if (!this.areAllEndsEqual()) {
                            n6 = 1;
                        }
                        else {
                            n6 = 0;
                        }
                    }
                    else if (!this.areAllStartsEqual()) {
                        n6 = 1;
                    }
                    else {
                        n6 = 0;
                    }
                    if (n6 != 0) {
                        final FullSpanItem fullSpanItem = mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            this.attachViewToSpans(next, layoutParams, layoutState);
            int endAfterPadding;
            int startAfterPadding;
            if (this.isLayoutRTL() && mOrientation == 1) {
                if (layoutParams.mFullSpan) {
                    endAfterPadding = mSecondaryOrientation.getEndAfterPadding();
                }
                else {
                    endAfterPadding = mSecondaryOrientation.getEndAfterPadding() - (-1 + mSpanCount - nextSpan.mIndex) * mSizePerSpan;
                }
                startAfterPadding = endAfterPadding - mSecondaryOrientation.getDecoratedMeasurement(next);
            }
            else {
                if (layoutParams.mFullSpan) {
                    startAfterPadding = mSecondaryOrientation.getStartAfterPadding();
                }
                else {
                    startAfterPadding = nextSpan.mIndex * mSizePerSpan + mSecondaryOrientation.getStartAfterPadding();
                }
                endAfterPadding = startAfterPadding + mSecondaryOrientation.getDecoratedMeasurement(next);
            }
            if (mOrientation == 1) {
                this.layoutDecoratedWithMargins(next, startAfterPadding, n4, endAfterPadding, n5);
            }
            else {
                this.layoutDecoratedWithMargins(next, n4, startAfterPadding, n5, endAfterPadding);
            }
            if (layoutParams.mFullSpan) {
                this.updateAllRemainingSpans(mLayoutState.mLayoutDirection, n);
            }
            else {
                this.updateRemainingSpans(nextSpan, mLayoutState.mLayoutDirection, n);
            }
            this.recycle(recycler, mLayoutState);
            if (mLayoutState.mStopInFocusable && next.isFocusable()) {
                if (layoutParams.mFullSpan) {
                    mRemainingSpans.clear();
                }
                else {
                    mRemainingSpans.set(nextSpan.mIndex, false);
                }
            }
            b = true;
        }
        if (!b) {
            this.recycle(recycler, mLayoutState);
        }
        int n7;
        if (mLayoutState.mLayoutDirection == -1) {
            n7 = mPrimaryOrientation.getStartAfterPadding() - this.getMinStart(mPrimaryOrientation.getStartAfterPadding());
        }
        else {
            n7 = this.getMaxEnd(mPrimaryOrientation.getEndAfterPadding()) - mPrimaryOrientation.getEndAfterPadding();
        }
        if (n7 > 0) {
            return Math.min(layoutState.mAvailable, n7);
        }
        return 0;
    }
    
    private int findFirstReferenceChildPosition(final int n) {
        for (int childCount = ((RecyclerView.LayoutManager)this).getChildCount(), i = 0; i < childCount; ++i) {
            final int position = ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(i));
            if (position >= 0 && position < n) {
                return position;
            }
        }
        return 0;
    }
    
    private int findLastReferenceChildPosition(final int n) {
        for (int i = -1 + ((RecyclerView.LayoutManager)this).getChildCount(); i >= 0; --i) {
            final int position = ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(i));
            if (position >= 0 && position < n) {
                return position;
            }
        }
        return 0;
    }
    
    private void fixEndGap(final Recycler recycler, final State state, final boolean b) {
        final int maxEnd = this.getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE) {
            final int n = mPrimaryOrientation.getEndAfterPadding() - maxEnd;
            if (n > 0) {
                final int n2 = n - -this.scrollBy(-n, recycler, state);
                if (b && n2 > 0) {
                    mPrimaryOrientation.offsetChildren(n2);
                }
            }
        }
    }
    
    private void fixStartGap(final Recycler recycler, final State state, final boolean b) {
        final int minStart = this.getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE) {
            final int n = minStart - mPrimaryOrientation.getStartAfterPadding();
            if (n > 0) {
                final int n2 = n - this.scrollBy(n, recycler, state);
                if (b && n2 > 0) {
                    mPrimaryOrientation.offsetChildren(-n2);
                }
            }
        }
    }
    
    private int getFirstChildPosition() {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return 0;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0));
    }
    
    private int getLastChildPosition() {
        final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(childCount - 1));
    }
    
    private int getMaxEnd(final int n) {
        int endLine = mSpans[0].getEndLine(n);
        for (int i = 1; i < mSpanCount; ++i) {
            final int endLine2 = mSpans[i].getEndLine(n);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }
    
    private int getMaxStart(final int n) {
        int startLine = mSpans[0].getStartLine(n);
        for (int i = 1; i < mSpanCount; ++i) {
            final int startLine2 = mSpans[i].getStartLine(n);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }
    
    private int getMinEnd(final int n) {
        int endLine = mSpans[0].getEndLine(n);
        for (int i = 1; i < mSpanCount; ++i) {
            final int endLine2 = mSpans[i].getEndLine(n);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }
    
    private int getMinStart(final int n) {
        int startLine = mSpans[0].getStartLine(n);
        for (int i = 1; i < mSpanCount; ++i) {
            final int startLine2 = mSpans[i].getStartLine(n);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }
    
    private Span getNextSpan(final LayoutState layoutState) {
        int n;
        int mSpanCount;
        int n2;
        if (this.preferLastSpan(layoutState.mLayoutDirection)) {
            n = -1 + this.mSpanCount;
            mSpanCount = -1;
            n2 = -1;
        }
        else {
            mSpanCount = this.mSpanCount;
            n2 = 1;
            n = 0;
        }
        Span span;
        if (layoutState.mLayoutDirection == 1) {
            span = null;
            int n3 = Integer.MAX_VALUE;
            final int startAfterPadding = mPrimaryOrientation.getStartAfterPadding();
            for (int i = n; i != mSpanCount; i += n2) {
                final Span span2 = mSpans[i];
                final int endLine = span2.getEndLine(startAfterPadding);
                if (endLine < n3) {
                    span = span2;
                    n3 = endLine;
                }
            }
        }
        else {
            Span span3 = null;
            int n4 = Integer.MIN_VALUE;
            final int endAfterPadding = mPrimaryOrientation.getEndAfterPadding();
            for (int j = n; j != mSpanCount; j += n2) {
                final Span span4 = mSpans[j];
                final int startLine = span4.getStartLine(endAfterPadding);
                if (startLine > n4) {
                    span3 = span4;
                    n4 = startLine;
                }
            }
            span = span3;
        }
        return span;
    }
    
    private void handleUpdate(final int n, final int n2, final int n3) {
        int n4;
        if (mShouldReverseLayout) {
            n4 = this.getLastChildPosition();
        }
        else {
            n4 = this.getFirstChildPosition();
        }
        int n5;
        int n6;
        if (n3 == 8) {
            if (n < n2) {
                n5 = n2 + 1;
                n6 = n;
            }
            else {
                n5 = n + 1;
                n6 = n2;
            }
        }
        else {
            n6 = n;
            n5 = n + n2;
        }
        mLazySpanLookup.invalidateAfter(n6);
        switch (n3) {
            case 1:
                mLazySpanLookup.offsetForAddition(n, n2);
                break;
            case 2:
                mLazySpanLookup.offsetForRemoval(n, n2);
                break;
            case 8:
                mLazySpanLookup.offsetForRemoval(n, 1);
                mLazySpanLookup.offsetForAddition(n2, 1);
                break;
        }
        if (n5 > n4) {
            int n7;
            if (mShouldReverseLayout) {
                n7 = this.getFirstChildPosition();
            }
            else {
                n7 = this.getLastChildPosition();
            }
            if (n6 <= n7) {
                ((RecyclerView.LayoutManager)this).requestLayout();
            }
        }
    }
    
    private void layoutDecoratedWithMargins(final View view, final int n, final int n2, final int n3, final int n4) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        ((RecyclerView.LayoutManager)this).layoutDecorated(view, n + layoutParams.leftMargin, n2 + layoutParams.topMargin, n3 - layoutParams.rightMargin, n4 - layoutParams.bottomMargin);
    }
    
    private void measureChildWithDecorationsAndMargin(final View view, final int n, final int n2, final boolean b) {
        ((RecyclerView.LayoutManager)this).calculateItemDecorationsForChild(view, mTmpRect);
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int updateSpecWithExtra = this.updateSpecWithExtra(n, layoutParams.leftMargin + mTmpRect.left, layoutParams.rightMargin + mTmpRect.right);
        final int updateSpecWithExtra2 = this.updateSpecWithExtra(n2, layoutParams.topMargin + mTmpRect.top, layoutParams.bottomMargin + mTmpRect.bottom);
        boolean b2;
        if (b) {
            b2 = ((RecyclerView.LayoutManager)this).shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        else {
            b2 = ((RecyclerView.LayoutManager)this).shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (b2) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }
    
    private void measureChildWithDecorationsAndMargin(final View view, final LayoutParams layoutParams, final boolean b) {
        if (layoutParams.mFullSpan) {
            if (mOrientation == 1) {
                this.measureChildWithDecorationsAndMargin(view, mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(((RecyclerView.LayoutManager)this).getHeight(), ((RecyclerView.LayoutManager)this).getHeightMode(), 0, layoutParams.height, true), b);
                return;
            }
            this.measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(((RecyclerView.LayoutManager)this).getWidth(), ((RecyclerView.LayoutManager)this).getWidthMode(), 0, layoutParams.width, true), mFullSizeSpec, b);
        }
        else {
            if (mOrientation == 1) {
                this.measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(mSizePerSpan, ((RecyclerView.LayoutManager)this).getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(((RecyclerView.LayoutManager)this).getHeight(), ((RecyclerView.LayoutManager)this).getHeightMode(), 0, layoutParams.height, true), b);
                return;
            }
            this.measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(((RecyclerView.LayoutManager)this).getWidth(), ((RecyclerView.LayoutManager)this).getWidthMode(), 0, layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(mSizePerSpan, ((RecyclerView.LayoutManager)this).getHeightMode(), 0, layoutParams.height, false), b);
        }
    }
    
    private void onLayoutChildren(final Recycler recycler, final State state, final boolean b) {
        int layoutStateDirection = 1;
        this.ensureOrientationHelper();
        final AnchorInfo mAnchorInfo = this.mAnchorInfo;
        mAnchorInfo.reset();
        if ((mPendingSavedState != null || mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            ((RecyclerView.LayoutManager)this).removeAndRecycleAllViews(recycler);
        }
        else {
            if (mPendingSavedState != null) {
                this.applyPendingSavedState(mAnchorInfo);
            }
            else {
                this.resolveShouldLayoutReverse();
                mAnchorInfo.mLayoutFromEnd = mShouldReverseLayout;
            }
            this.updateAnchorInfoForLayout(state, mAnchorInfo);
            if (mPendingSavedState == null && (mAnchorInfo.mLayoutFromEnd != mLastLayoutFromEnd || this.isLayoutRTL() != mLastLayoutRTL)) {
                mLazySpanLookup.clear();
                mAnchorInfo.mInvalidateOffsets = (layoutStateDirection != 0);
            }
            if (((RecyclerView.LayoutManager)this).getChildCount() > 0 && (mPendingSavedState == null || mPendingSavedState.mSpanOffsetsSize < layoutStateDirection)) {
                if (mAnchorInfo.mInvalidateOffsets) {
                    for (int i = 0; i < mSpanCount; ++i) {
                        mSpans[i].clear();
                        if (mAnchorInfo.mOffset != Integer.MIN_VALUE) {
                            mSpans[i].setLine(mAnchorInfo.mOffset);
                        }
                    }
                }
                else {
                    for (int j = 0; j < mSpanCount; ++j) {
                        mSpans[j].cacheReferenceLineAndClear(mShouldReverseLayout, mAnchorInfo.mOffset);
                    }
                }
            }
            ((RecyclerView.LayoutManager)this).detachAndScrapAttachedViews(recycler);
            mLayoutState.mRecycle = false;
            mLaidOutInvalidFullSpan = false;
            this.updateMeasureSpecs(mSecondaryOrientation.getTotalSpace());
            this.updateLayoutState(mAnchorInfo.mPosition, state);
            if (mAnchorInfo.mLayoutFromEnd) {
                this.setLayoutStateDirection(-1);
                this.fill(recycler, mLayoutState, state);
                this.setLayoutStateDirection(layoutStateDirection);
                mLayoutState.mCurrentPosition = mAnchorInfo.mPosition + mLayoutState.mItemDirection;
                this.fill(recycler, mLayoutState, state);
            }
            else {
                this.setLayoutStateDirection(layoutStateDirection);
                this.fill(recycler, mLayoutState, state);
                this.setLayoutStateDirection(-1);
                mLayoutState.mCurrentPosition = mAnchorInfo.mPosition + mLayoutState.mItemDirection;
                this.fill(recycler, mLayoutState, state);
            }
            this.repositionToWrapContentIfNecessary();
            if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
                if (mShouldReverseLayout) {
                    this.fixEndGap(recycler, state, layoutStateDirection != 0);
                    this.fixStartGap(recycler, state, false);
                }
                else {
                    this.fixStartGap(recycler, state, layoutStateDirection != 0);
                    this.fixEndGap(recycler, state, false);
                }
            }
            boolean b2 = false;
            if (b) {
                final boolean preLayout = state.isPreLayout();
                b2 = false;
                if (!preLayout) {
                    if (mGapStrategy == 0 || ((RecyclerView.LayoutManager)this).getChildCount() <= 0 || (!mLaidOutInvalidFullSpan && this.hasGapsToFix() == null)) {
                        layoutStateDirection = 0;
                    }
                    b2 = false;
                    if (layoutStateDirection != 0) {
                        ((RecyclerView.LayoutManager)this).removeCallbacks(mCheckForGapsRunnable);
                        final boolean checkForGaps = this.checkForGaps();
                        b2 = false;
                        if (checkForGaps) {
                            b2 = true;
                        }
                    }
                    mPendingScrollPosition = -1;
                    mPendingScrollPositionOffset = Integer.MIN_VALUE;
                }
            }
            mLastLayoutFromEnd = mAnchorInfo.mLayoutFromEnd;
            mLastLayoutRTL = this.isLayoutRTL();
            mPendingSavedState = null;
            if (b2) {
                this.onLayoutChildren(recycler, state, false);
            }
        }
    }
    
    private boolean preferLastSpan(final int n) {
        if (mOrientation == 0) {
            if (n == -1 == mShouldReverseLayout) {
                return false;
            }
        }
        else if (n == -1 == mShouldReverseLayout != this.isLayoutRTL()) {
            return false;
        }
        return true;
    }
    
    private void prependViewToAllSpans(final View view) {
        for (int i = -1 + mSpanCount; i >= 0; --i) {
            mSpans[i].prependToSpan(view);
        }
    }
    
    private void recycle(final Recycler recycler, final LayoutState layoutState) {
        if (!layoutState.mRecycle || layoutState.mInfinite) {
            return;
        }
        if (layoutState.mAvailable == 0) {
            if (layoutState.mLayoutDirection == -1) {
                this.recycleFromEnd(recycler, layoutState.mEndLine);
                return;
            }
            this.recycleFromStart(recycler, layoutState.mStartLine);
        }
        else {
            if (layoutState.mLayoutDirection == -1) {
                final int n = layoutState.mStartLine - this.getMaxStart(layoutState.mStartLine);
                int mEndLine;
                if (n < 0) {
                    mEndLine = layoutState.mEndLine;
                }
                else {
                    mEndLine = layoutState.mEndLine - Math.min(n, layoutState.mAvailable);
                }
                this.recycleFromEnd(recycler, mEndLine);
                return;
            }
            final int n2 = this.getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
            int mStartLine;
            if (n2 < 0) {
                mStartLine = layoutState.mStartLine;
            }
            else {
                mStartLine = layoutState.mStartLine + Math.min(n2, layoutState.mAvailable);
            }
            this.recycleFromStart(recycler, mStartLine);
        }
    }
    
    private void recycleFromEnd(final Recycler recycler, final int n) {
    Label_0078:
        for (int i = -1 + ((RecyclerView.LayoutManager)this).getChildCount(); i >= 0; --i) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            if (mPrimaryOrientation.getDecoratedStart(child) < n) {
                break;
            }
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.mFullSpan) {
                for (int j = 0; j < mSpanCount; ++j) {
                    if (mSpans[j].mViews.size() == 1) {
                        break Label_0078;
                    }
                }
                for (int k = 0; k < mSpanCount; ++k) {
                    mSpans[k].popEnd();
                }
            }
            else {
                if (layoutParams.mSpan.mViews.size() == 1) {
                    break;
                }
                layoutParams.mSpan.popEnd();
            }
            ((RecyclerView.LayoutManager)this).removeAndRecycleView(child, recycler);
        }
    }
    
    private void recycleFromStart(final Recycler recycler, final int n) {
    Label_0071:
        while (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(0);
            if (mPrimaryOrientation.getDecoratedEnd(child) > n) {
                break;
            }
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.mFullSpan) {
                for (int i = 0; i < mSpanCount; ++i) {
                    if (mSpans[i].mViews.size() == 1) {
                        break Label_0071;
                    }
                }
                for (int j = 0; j < mSpanCount; ++j) {
                    mSpans[j].popStart();
                }
            }
            else {
                if (layoutParams.mSpan.mViews.size() == 1) {
                    break;
                }
                layoutParams.mSpan.popStart();
            }
            ((RecyclerView.LayoutManager)this).removeAndRecycleView(child, recycler);
        }
    }
    
    private void repositionToWrapContentIfNecessary() {
        if (mSecondaryOrientation.getMode() != 1073741824) {
            float max = 0.0f;
            final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
            for (int i = 0; i < childCount; ++i) {
                final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
                float n = (float)mSecondaryOrientation.getDecoratedMeasurement(child);
                if (n >= max) {
                    if (((LayoutParams)child.getLayoutParams()).isFullSpan()) {
                        n = 1.0f * n / mSpanCount;
                    }
                    max = Math.max(max, n);
                }
            }
            final int mSizePerSpan = this.mSizePerSpan;
            int n2 = Math.round(max * (float)mSpanCount);
            if (mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                n2 = Math.min(n2, mSecondaryOrientation.getTotalSpace());
            }
            this.updateMeasureSpecs(n2);
            if (this.mSizePerSpan != mSizePerSpan) {
                for (int j = 0; j < childCount; ++j) {
                    final View child2 = ((RecyclerView.LayoutManager)this).getChildAt(j);
                    final LayoutParams layoutParams = (LayoutParams)child2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (this.isLayoutRTL() && mOrientation == 1) {
                            child2.offsetLeftAndRight(-(-1 + mSpanCount - layoutParams.mSpan.mIndex) * this.mSizePerSpan - mSizePerSpan * -(-1 + mSpanCount - layoutParams.mSpan.mIndex));
                        }
                        else {
                            final int n3 = layoutParams.mSpan.mIndex * this.mSizePerSpan;
                            final int n4 = mSizePerSpan * layoutParams.mSpan.mIndex;
                            if (mOrientation == 1) {
                                child2.offsetLeftAndRight(n3 - n4);
                            }
                            else {
                                child2.offsetTopAndBottom(n3 - n4);
                            }
                        }
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
    
    private void setLayoutStateDirection(final int mLayoutDirection) {
        int mItemDirection = 1;
        mLayoutState.mLayoutDirection = mLayoutDirection;
        final LayoutState mLayoutState = this.mLayoutState;
        if (mShouldReverseLayout != (mLayoutDirection == -1 && mItemDirection)) {
            mItemDirection = -1;
        }
        mLayoutState.mItemDirection = mItemDirection;
    }
    
    private void updateAllRemainingSpans(final int n, final int n2) {
        for (int i = 0; i < mSpanCount; ++i) {
            if (!mSpans[i].mViews.isEmpty()) {
                this.updateRemainingSpans(mSpans[i], n, n2);
            }
        }
    }
    
    private boolean updateAnchorFromChildren(final State state, final AnchorInfo anchorInfo) {
        int mPosition;
        if (mLastLayoutFromEnd) {
            mPosition = this.findLastReferenceChildPosition(state.getItemCount());
        }
        else {
            mPosition = this.findFirstReferenceChildPosition(state.getItemCount());
        }
        anchorInfo.mPosition = mPosition;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }
    
    private void updateLayoutState(final int mCurrentPosition, final State state) {
        boolean b = true;
        mLayoutState.mAvailable = 0;
        mLayoutState.mCurrentPosition = mCurrentPosition;
        final boolean smoothScrolling = ((RecyclerView.LayoutManager)this).isSmoothScrolling();
        int totalSpace = 0;
        int totalSpace2 = 0;
        if (smoothScrolling) {
            final int targetScrollPosition = state.getTargetScrollPosition();
            totalSpace = 0;
            totalSpace2 = 0;
            if (targetScrollPosition != -1) {
                if (mShouldReverseLayout == (targetScrollPosition < mCurrentPosition && b)) {
                    totalSpace = mPrimaryOrientation.getTotalSpace();
                }
                else {
                    totalSpace2 = mPrimaryOrientation.getTotalSpace();
                    totalSpace = 0;
                }
            }
        }
        if (((RecyclerView.LayoutManager)this).getClipToPadding()) {
            mLayoutState.mStartLine = mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
            mLayoutState.mEndLine = totalSpace + mPrimaryOrientation.getEndAfterPadding();
        }
        else {
            mLayoutState.mEndLine = totalSpace + mPrimaryOrientation.getEnd();
            mLayoutState.mStartLine = -totalSpace2;
        }
        mLayoutState.mStopInFocusable = false;
        mLayoutState.mRecycle = b;
        final LayoutState mLayoutState = this.mLayoutState;
        if (mPrimaryOrientation.getMode() != 0) {
            b = false;
        }
        mLayoutState.mInfinite = b;
    }
    
    private void updateRemainingSpans(final Span span, final int n, final int n2) {
        final int deletedSize = span.getDeletedSize();
        if (n == -1) {
            if (deletedSize + span.getStartLine() <= n2) {
                mRemainingSpans.set(span.mIndex, false);
            }
        }
        else if (span.getEndLine() - deletedSize >= n2) {
            mRemainingSpans.set(span.mIndex, false);
        }
    }
    
    private int updateSpecWithExtra(final int n, final int n2, final int n3) {
        if (n2 != 0 || n3 != 0) {
            final int mode = View$MeasureSpec.getMode(n);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                return View$MeasureSpec.makeMeasureSpec(Math.max(0, View$MeasureSpec.getSize(n) - n2 - n3), mode);
            }
        }
        return n;
    }
    
    boolean areAllEndsEqual() {
        final int endLine = mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i = 1; i < mSpanCount; ++i) {
            if (mSpans[i].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }
    
    boolean areAllStartsEqual() {
        final int startLine = mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i = 1; i < mSpanCount; ++i) {
            if (mSpans[i].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
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
    public boolean checkLayoutParams(final RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
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
    
    public int[] findFirstCompletelyVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[mSpanCount];
        }
        else if (array.length < mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + mSpanCount + ", array size:" + array.length);
        }
        for (int i = 0; i < mSpanCount; ++i) {
            array[i] = mSpans[i].findFirstCompletelyVisibleItemPosition();
        }
        return array;
    }
    
    View findFirstVisibleItemClosestToEnd(final boolean b, final boolean b2) {
        this.ensureOrientationHelper();
        final int startAfterPadding = mPrimaryOrientation.getStartAfterPadding();
        final int endAfterPadding = mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int i = -1 + ((RecyclerView.LayoutManager)this).getChildCount(); i >= 0; --i) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            final int decoratedStart = mPrimaryOrientation.getDecoratedStart(child);
            final int decoratedEnd = mPrimaryOrientation.getDecoratedEnd(child);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !b) {
                    return child;
                }
                if (b2 && view == null) {
                    view = child;
                }
            }
        }
        return view;
    }
    
    View findFirstVisibleItemClosestToStart(final boolean b, final boolean b2) {
        this.ensureOrientationHelper();
        final int startAfterPadding = mPrimaryOrientation.getStartAfterPadding();
        final int endAfterPadding = mPrimaryOrientation.getEndAfterPadding();
        final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
        View view = null;
        for (int i = 0; i < childCount; ++i) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            final int decoratedStart = mPrimaryOrientation.getDecoratedStart(child);
            if (mPrimaryOrientation.getDecoratedEnd(child) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !b) {
                    return child;
                }
                if (b2 && view == null) {
                    view = child;
                }
            }
        }
        return view;
    }
    
    int findFirstVisibleItemPositionInt() {
        View view;
        if (mShouldReverseLayout) {
            view = this.findFirstVisibleItemClosestToEnd(true, true);
        }
        else {
            view = this.findFirstVisibleItemClosestToStart(true, true);
        }
        if (view == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(view);
    }
    
    public int[] findFirstVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[mSpanCount];
        }
        else if (array.length < mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + mSpanCount + ", array size:" + array.length);
        }
        for (int i = 0; i < mSpanCount; ++i) {
            array[i] = mSpans[i].findFirstVisibleItemPosition();
        }
        return array;
    }
    
    public int[] findLastCompletelyVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[mSpanCount];
        }
        else if (array.length < mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + mSpanCount + ", array size:" + array.length);
        }
        for (int i = 0; i < mSpanCount; ++i) {
            array[i] = mSpans[i].findLastCompletelyVisibleItemPosition();
        }
        return array;
    }
    
    public int[] findLastVisibleItemPositions(int[] array) {
        if (array == null) {
            array = new int[mSpanCount];
        }
        else if (array.length < mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + mSpanCount + ", array size:" + array.length);
        }
        for (int i = 0; i < mSpanCount; ++i) {
            array[i] = mSpans[i].findLastVisibleItemPosition();
        }
        return array;
    }
    
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }
    
    @Override
    public RecyclerView.LayoutParams generateLayoutParams(final Context context, final AttributeSet set) {
        return new LayoutParams(context, set);
    }
    
    @Override
    public RecyclerView.LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    @Override
    public int getColumnCountForAccessibility(final Recycler recycler, final State state) {
        if (mOrientation == 1) {
            return mSpanCount;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }
    
    public int getGapStrategy() {
        return mGapStrategy;
    }
    
    public int getOrientation() {
        return mOrientation;
    }
    
    public boolean getReverseLayout() {
        return mReverseLayout;
    }
    
    @Override
    public int getRowCountForAccessibility(final Recycler recycler, final State state) {
        if (mOrientation == 0) {
            return mSpanCount;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }
    
    public int getSpanCount() {
        return mSpanCount;
    }
    
    View hasGapsToFix() {
        final int n = -1 + ((RecyclerView.LayoutManager)this).getChildCount();
        final BitSet set = new BitSet(mSpanCount);
        set.set(0, mSpanCount, true);
        int n2;
        if (mOrientation == 1 && this.isLayoutRTL()) {
            n2 = 1;
        }
        else {
            n2 = -1;
        }
        int n3;
        int n4;
        if (mShouldReverseLayout) {
            n3 = n;
            n4 = 0 - 1;
        }
        else {
            n4 = n + 1;
            n3 = 0;
        }
        int n5;
        if (n3 < n4) {
            n5 = 1;
        }
        else {
            n5 = -1;
        }
        for (int i = n3; i != n4; i += n5) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (set.get(layoutParams.mSpan.mIndex)) {
                if (this.checkSpanForGap(layoutParams.mSpan)) {
                    return child;
                }
                set.clear(layoutParams.mSpan.mIndex);
            }
            if (!layoutParams.mFullSpan && i + n5 != n4) {
                final View child2 = ((RecyclerView.LayoutManager)this).getChildAt(i + n5);
                int n6;
                if (mShouldReverseLayout) {
                    final int decoratedEnd = mPrimaryOrientation.getDecoratedEnd(child);
                    final int decoratedEnd2 = mPrimaryOrientation.getDecoratedEnd(child2);
                    if (decoratedEnd < decoratedEnd2) {
                        return child;
                    }
                    n6 = 0;
                    if (decoratedEnd == decoratedEnd2) {
                        n6 = 1;
                    }
                }
                else {
                    final int decoratedStart = mPrimaryOrientation.getDecoratedStart(child);
                    final int decoratedStart2 = mPrimaryOrientation.getDecoratedStart(child2);
                    if (decoratedStart > decoratedStart2) {
                        return child;
                    }
                    n6 = 0;
                    if (decoratedStart == decoratedStart2) {
                        n6 = 1;
                    }
                }
                if (n6 != 0) {
                    int n7;
                    if (layoutParams.mSpan.mIndex - ((LayoutParams)child2.getLayoutParams()).mSpan.mIndex < 0) {
                        n7 = 1;
                    }
                    else {
                        n7 = 0;
                    }
                    int n8;
                    if (n2 < 0) {
                        n8 = 1;
                    }
                    else {
                        n8 = 0;
                    }
                    if (n7 != n8) {
                        return child;
                    }
                }
            }
        }
        return null;
    }
    
    public void invalidateSpanAssignments() {
        mLazySpanLookup.clear();
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    boolean isLayoutRTL() {
        return ((RecyclerView.LayoutManager)this).getLayoutDirection() == 1;
    }
    
    @Override
    public void offsetChildrenHorizontal(final int n) {
        super.offsetChildrenHorizontal(n);
        for (int i = 0; i < mSpanCount; ++i) {
            mSpans[i].onOffset(n);
        }
    }
    
    @Override
    public void offsetChildrenVertical(final int n) {
        super.offsetChildrenVertical(n);
        for (int i = 0; i < mSpanCount; ++i) {
            mSpans[i].onOffset(n);
        }
    }
    
    @Override
    public void onDetachedFromWindow(final RecyclerView recyclerView, final Recycler recycler) {
        ((RecyclerView.LayoutManager)this).removeCallbacks(mCheckForGapsRunnable);
        for (int i = 0; i < mSpanCount; ++i) {
            mSpans[i].clear();
        }
    }
    
    @Nullable
    @Override
    public View onFocusSearchFailed(final View view, final int n, final Recycler recycler, final State state) {
        View view2;
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            view2 = null;
        }
        else {
            final View containingItemView = ((RecyclerView.LayoutManager)this).findContainingItemView(view);
            if (containingItemView == null) {
                return null;
            }
            this.ensureOrientationHelper();
            this.resolveShouldLayoutReverse();
            final int convertFocusDirectionToLayoutDirection = this.convertFocusDirectionToLayoutDirection(n);
            if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
                return null;
            }
            final LayoutParams layoutParams = (LayoutParams)containingItemView.getLayoutParams();
            final boolean mFullSpan = layoutParams.mFullSpan;
            final Span mSpan = layoutParams.mSpan;
            int n2;
            if (convertFocusDirectionToLayoutDirection == 1) {
                n2 = this.getLastChildPosition();
            }
            else {
                n2 = this.getFirstChildPosition();
            }
            this.updateLayoutState(n2, state);
            this.setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
            mLayoutState.mCurrentPosition = n2 + mLayoutState.mItemDirection;
            mLayoutState.mAvailable = (int)(0.33333334f * mPrimaryOrientation.getTotalSpace());
            mLayoutState.mStopInFocusable = true;
            mLayoutState.mRecycle = false;
            this.fill(recycler, mLayoutState, state);
            mLastLayoutFromEnd = mShouldReverseLayout;
            if (!mFullSpan) {
                view2 = mSpan.getFocusableViewAfter(n2, convertFocusDirectionToLayoutDirection);
                if (view2 != null && view2 != containingItemView) {
                    return view2;
                }
            }
            if (this.preferLastSpan(convertFocusDirectionToLayoutDirection)) {
                for (int i = -1 + mSpanCount; i >= 0; --i) {
                    view2 = mSpans[i].getFocusableViewAfter(n2, convertFocusDirectionToLayoutDirection);
                    if (view2 != null && view2 != containingItemView) {
                        return view2;
                    }
                }
            }
            else {
                for (int j = 0; j < mSpanCount; ++j) {
                    view2 = mSpans[j].getFocusableViewAfter(n2, convertFocusDirectionToLayoutDirection);
                    if (view2 != null && view2 != containingItemView) {
                        return view2;
                    }
                }
            }
            return null;
        }
        return view2;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
            final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(accessibilityEvent);
            final View firstVisibleItemClosestToStart = this.findFirstVisibleItemClosestToStart(false, true);
            final View firstVisibleItemClosestToEnd = this.findFirstVisibleItemClosestToEnd(false, true);
            if (firstVisibleItemClosestToStart != null && firstVisibleItemClosestToEnd != null) {
                final int position = ((RecyclerView.LayoutManager)this).getPosition(firstVisibleItemClosestToStart);
                final int position2 = ((RecyclerView.LayoutManager)this).getPosition(firstVisibleItemClosestToEnd);
                if (position < position2) {
                    record.setFromIndex(position);
                    record.setToIndex(position2);
                    return;
                }
                record.setFromIndex(position2);
                record.setToIndex(position);
            }
        }
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfoForItem(final Recycler recycler, final State state, final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        final LayoutParams layoutParams2 = (LayoutParams)layoutParams;
        if (mOrientation == 0) {
            final int spanIndex = layoutParams2.getSpanIndex();
            int mSpanCount;
            if (layoutParams2.mFullSpan) {
                mSpanCount = this.mSpanCount;
            }
            else {
                mSpanCount = 1;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanIndex, mSpanCount, -1, -1, layoutParams2.mFullSpan, false));
            return;
        }
        final int spanIndex2 = layoutParams2.getSpanIndex();
        int mSpanCount2;
        if (layoutParams2.mFullSpan) {
            mSpanCount2 = mSpanCount;
        }
        else {
            mSpanCount2 = 1;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, spanIndex2, mSpanCount2, layoutParams2.mFullSpan, false));
    }
    
    @Override
    public void onItemsAdded(final RecyclerView recyclerView, final int n, final int n2) {
        this.handleUpdate(n, n2, 1);
    }
    
    @Override
    public void onItemsChanged(final RecyclerView recyclerView) {
        mLazySpanLookup.clear();
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    @Override
    public void onItemsMoved(final RecyclerView recyclerView, final int n, final int n2, final int n3) {
        this.handleUpdate(n, n2, 8);
    }
    
    @Override
    public void onItemsRemoved(final RecyclerView recyclerView, final int n, final int n2) {
        this.handleUpdate(n, n2, 2);
    }
    
    @Override
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2, final Object o) {
        this.handleUpdate(n, n2, 4);
    }
    
    @Override
    public void onLayoutChildren(final Recycler recycler, final State state) {
        this.onLayoutChildren(recycler, state, true);
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
        SavedState savedState;
        if (mPendingSavedState != null) {
            savedState = new SavedState(mPendingSavedState);
        }
        else {
            savedState = new SavedState();
            savedState.mReverseLayout = mReverseLayout;
            savedState.mAnchorLayoutFromEnd = mLastLayoutFromEnd;
            savedState.mLastLayoutRTL = mLastLayoutRTL;
            if (mLazySpanLookup != null && mLazySpanLookup.mData != null) {
                savedState.mSpanLookup = mLazySpanLookup.mData;
                savedState.mSpanLookupSize = savedState.mSpanLookup.length;
                savedState.mFullSpanItems = mLazySpanLookup.mFullSpanItems;
            }
            else {
                savedState.mSpanLookupSize = 0;
            }
            if (((RecyclerView.LayoutManager)this).getChildCount() <= 0) {
                savedState.mAnchorPosition = -1;
                savedState.mVisibleAnchorPosition = -1;
                savedState.mSpanOffsetsSize = 0;
                return (Parcelable)savedState;
            }
            this.ensureOrientationHelper();
            int mAnchorPosition;
            if (mLastLayoutFromEnd) {
                mAnchorPosition = this.getLastChildPosition();
            }
            else {
                mAnchorPosition = this.getFirstChildPosition();
            }
            savedState.mAnchorPosition = mAnchorPosition;
            savedState.mVisibleAnchorPosition = this.findFirstVisibleItemPositionInt();
            savedState.mSpanOffsetsSize = mSpanCount;
            savedState.mSpanOffsets = new int[mSpanCount];
            for (int i = 0; i < mSpanCount; ++i) {
                int n;
                if (mLastLayoutFromEnd) {
                    n = mSpans[i].getEndLine(Integer.MIN_VALUE);
                    if (n != Integer.MIN_VALUE) {
                        n -= mPrimaryOrientation.getEndAfterPadding();
                    }
                }
                else {
                    n = mSpans[i].getStartLine(Integer.MIN_VALUE);
                    if (n != Integer.MIN_VALUE) {
                        n -= mPrimaryOrientation.getStartAfterPadding();
                    }
                }
                savedState.mSpanOffsets[i] = n;
            }
        }
        return (Parcelable)savedState;
    }
    
    @Override
    public void onScrollStateChanged(final int n) {
        if (n == 0) {
            this.checkForGaps();
        }
    }
    
    int scrollBy(final int n, final Recycler recycler, final State state) {
        this.ensureOrientationHelper();
        int layoutStateDirection;
        int n2;
        if (n > 0) {
            layoutStateDirection = 1;
            n2 = this.getLastChildPosition();
        }
        else {
            layoutStateDirection = -1;
            n2 = this.getFirstChildPosition();
        }
        mLayoutState.mRecycle = true;
        this.updateLayoutState(n2, state);
        this.setLayoutStateDirection(layoutStateDirection);
        mLayoutState.mCurrentPosition = n2 + mLayoutState.mItemDirection;
        final int abs = Math.abs(n);
        mLayoutState.mAvailable = abs;
        final int fill = this.fill(recycler, mLayoutState, state);
        int n3;
        if (abs < fill) {
            n3 = n;
        }
        else if (n < 0) {
            n3 = -fill;
        }
        else {
            n3 = fill;
        }
        mPrimaryOrientation.offsetChildren(-n3);
        mLastLayoutFromEnd = mShouldReverseLayout;
        return n3;
    }
    
    @Override
    public int scrollHorizontallyBy(final int n, final Recycler recycler, final State state) {
        return this.scrollBy(n, recycler, state);
    }
    
    @Override
    public void scrollToPosition(final int mPendingScrollPosition) {
        if (mPendingSavedState != null && mPendingSavedState.mAnchorPosition != mPendingScrollPosition) {
            mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = mPendingScrollPosition;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    public void scrollToPositionWithOffset(final int mPendingScrollPosition, final int mPendingScrollPositionOffset) {
        if (mPendingSavedState != null) {
            mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = mPendingScrollPosition;
        this.mPendingScrollPositionOffset = mPendingScrollPositionOffset;
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    @Override
    public int scrollVerticallyBy(final int n, final Recycler recycler, final State state) {
        return this.scrollBy(n, recycler, state);
    }
    
    public void setGapStrategy(final int mGapStrategy) {
        this.assertNotInLayoutOrScroll(null);
        if (mGapStrategy == this.mGapStrategy) {
            return;
        }
        if (mGapStrategy != 0 && mGapStrategy != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = mGapStrategy;
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(this.mGapStrategy != 0);
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    @Override
    public void setMeasuredDimension(final Rect rect, final int n, final int n2) {
        final int n3 = ((RecyclerView.LayoutManager)this).getPaddingLeft() + ((RecyclerView.LayoutManager)this).getPaddingRight();
        final int n4 = ((RecyclerView.LayoutManager)this).getPaddingTop() + ((RecyclerView.LayoutManager)this).getPaddingBottom();
        int n5;
        int n6;
        if (mOrientation == 1) {
            n5 = RecyclerView.LayoutManager.chooseSize(n2, n4 + rect.height(), ((RecyclerView.LayoutManager)this).getMinimumHeight());
            n6 = RecyclerView.LayoutManager.chooseSize(n, n3 + mSizePerSpan * mSpanCount, ((RecyclerView.LayoutManager)this).getMinimumWidth());
        }
        else {
            n6 = RecyclerView.LayoutManager.chooseSize(n, n3 + rect.width(), ((RecyclerView.LayoutManager)this).getMinimumWidth());
            n5 = RecyclerView.LayoutManager.chooseSize(n2, n4 + mSizePerSpan * mSpanCount, ((RecyclerView.LayoutManager)this).getMinimumHeight());
        }
        ((RecyclerView.LayoutManager)this).setMeasuredDimension(n6, n5);
    }
    
    public void setOrientation(final int mOrientation) {
        if (mOrientation != 0 && mOrientation != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        this.assertNotInLayoutOrScroll(null);
        if (mOrientation == this.mOrientation) {
            return;
        }
        this.mOrientation = mOrientation;
        if (mPrimaryOrientation != null && mSecondaryOrientation != null) {
            final OrientationHelper mPrimaryOrientation = this.mPrimaryOrientation;
            this.mPrimaryOrientation = mSecondaryOrientation;
            mSecondaryOrientation = mPrimaryOrientation;
        }
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    public void setReverseLayout(final boolean b) {
        this.assertNotInLayoutOrScroll(null);
        if (mPendingSavedState != null && mPendingSavedState.mReverseLayout != b) {
            mPendingSavedState.mReverseLayout = b;
        }
        mReverseLayout = b;
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    public void setSpanCount(final int mSpanCount) {
        this.assertNotInLayoutOrScroll(null);
        if (mSpanCount != this.mSpanCount) {
            this.invalidateSpanAssignments();
            this.mSpanCount = mSpanCount;
            mRemainingSpans = new BitSet(this.mSpanCount);
            mSpans = new Span[this.mSpanCount];
            for (int i = 0; i < this.mSpanCount; ++i) {
                mSpans[i] = new Span(this, i);
            }
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    @Override
    public void smoothScrollToPosition(final RecyclerView recyclerView, final State state, final int targetPosition) {
        final LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
            final /* synthetic */ StaggeredGridLayoutManager this$0;
            
            StaggeredGridLayoutManager$2(final Context context) {
                this$0 = this$0;
                super(context);
            }
            
            @Override
            public PointF computeScrollVectorForPosition(final int n) {
                final int access$400 = this$0.calculateScrollDirectionForPosition(n);
                if (access$400 == 0) {
                    return null;
                }
                if (mOrientation == 0) {
                    return new PointF((float)access$400, 0.0f);
                }
                return new PointF(0.0f, (float)access$400);
            }
        };
        ((RecyclerView.SmoothScroller)linearSmoothScroller).setTargetPosition(targetPosition);
        ((RecyclerView.LayoutManager)this).startSmoothScroll(linearSmoothScroller);
    }
    
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return mPendingSavedState == null;
    }
    
    boolean updateAnchorFromPendingData(final State state, final AnchorInfo anchorInfo) {
        if (state.isPreLayout() || mPendingScrollPosition == -1) {
            return false;
        }
        if (mPendingScrollPosition < 0 || mPendingScrollPosition >= state.getItemCount()) {
            mPendingScrollPosition = -1;
            mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
        }
        if (mPendingSavedState != null && mPendingSavedState.mAnchorPosition != -1 && mPendingSavedState.mSpanOffsetsSize >= 1) {
            anchorInfo.mOffset = Integer.MIN_VALUE;
            anchorInfo.mPosition = mPendingScrollPosition;
            return true;
        }
        final View viewByPosition = ((RecyclerView.LayoutManager)this).findViewByPosition(mPendingScrollPosition);
        if (viewByPosition == null) {
            anchorInfo.mPosition = mPendingScrollPosition;
            if (mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                final int calculateScrollDirectionForPosition = this.calculateScrollDirectionForPosition(anchorInfo.mPosition);
                boolean mLayoutFromEnd = false;
                if (calculateScrollDirectionForPosition == 1) {
                    mLayoutFromEnd = true;
                }
                anchorInfo.mLayoutFromEnd = mLayoutFromEnd;
                anchorInfo.assignCoordinateFromPadding();
            }
            else {
                anchorInfo.assignCoordinateFromPadding(mPendingScrollPositionOffset);
            }
            return anchorInfo.mInvalidateOffsets = true;
        }
        int mPosition;
        if (mShouldReverseLayout) {
            mPosition = this.getLastChildPosition();
        }
        else {
            mPosition = this.getFirstChildPosition();
        }
        anchorInfo.mPosition = mPosition;
        if (mPendingScrollPositionOffset != Integer.MIN_VALUE) {
            if (anchorInfo.mLayoutFromEnd) {
                anchorInfo.mOffset = mPrimaryOrientation.getEndAfterPadding() - mPendingScrollPositionOffset - mPrimaryOrientation.getDecoratedEnd(viewByPosition);
                return true;
            }
            anchorInfo.mOffset = mPrimaryOrientation.getStartAfterPadding() + mPendingScrollPositionOffset - mPrimaryOrientation.getDecoratedStart(viewByPosition);
            return true;
        }
        else {
            if (mPrimaryOrientation.getDecoratedMeasurement(viewByPosition) > mPrimaryOrientation.getTotalSpace()) {
                int mOffset;
                if (anchorInfo.mLayoutFromEnd) {
                    mOffset = mPrimaryOrientation.getEndAfterPadding();
                }
                else {
                    mOffset = mPrimaryOrientation.getStartAfterPadding();
                }
                anchorInfo.mOffset = mOffset;
                return true;
            }
            final int n = mPrimaryOrientation.getDecoratedStart(viewByPosition) - mPrimaryOrientation.getStartAfterPadding();
            if (n < 0) {
                anchorInfo.mOffset = -n;
                return true;
            }
            final int mOffset2 = mPrimaryOrientation.getEndAfterPadding() - mPrimaryOrientation.getDecoratedEnd(viewByPosition);
            if (mOffset2 < 0) {
                anchorInfo.mOffset = mOffset2;
                return true;
            }
            anchorInfo.mOffset = Integer.MIN_VALUE;
            return true;
        }
    }
    
    void updateAnchorInfoForLayout(final State state, final AnchorInfo anchorInfo) {
        if (!this.updateAnchorFromPendingData(state, anchorInfo) && !this.updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = 0;
        }
    }
    
    void updateMeasureSpecs(final int n) {
        mSizePerSpan = n / mSpanCount;
        mFullSizeSpec = View$MeasureSpec.makeMeasureSpec(n, mSecondaryOrientation.getMode());
    }
}
