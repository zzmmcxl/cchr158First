package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

class Span
{
    static final int INVALID_LINE = Integer.MIN_VALUE;
    int mCachedEnd;
    int mCachedStart;
    int mDeletedSize;
    final int mIndex;
    private ArrayList<View> mViews;
    final /* synthetic */ StaggeredGridLayoutManager this$0;
    
    private Span(final StaggeredGridLayoutManager this$0, final int mIndex) {
        this$0 = this$0;
        super();
        mViews = new ArrayList<View>();
        mCachedStart = Integer.MIN_VALUE;
        mCachedEnd = Integer.MIN_VALUE;
        mDeletedSize = 0;
        mIndex = mIndex;
    }
    
    Span(final StaggeredGridLayoutManager staggeredGridLayoutManager, final int n, final StaggeredGridLayoutManager$1 runnable) {
        this(staggeredGridLayoutManager, n);
    }
    
    static /* synthetic */ ArrayList access$200(final Span span) {
        return span.mViews;
    }
    
    void appendToSpan(final View view) {
        final LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = this;
        mViews.add(view);
        mCachedEnd = Integer.MIN_VALUE;
        if (mViews.size() == 1) {
            mCachedStart = Integer.MIN_VALUE;
        }
        if (((RecyclerView.LayoutParams)layoutParams).isItemRemoved() || ((RecyclerView.LayoutParams)layoutParams).isItemChanged()) {
            mDeletedSize += mPrimaryOrientation.getDecoratedMeasurement(view);
        }
    }
    
    void cacheReferenceLineAndClear(final boolean b, final int n) {
        int n2;
        if (b) {
            n2 = this.getEndLine(Integer.MIN_VALUE);
        }
        else {
            n2 = this.getStartLine(Integer.MIN_VALUE);
        }
        this.clear();
        if (n2 != Integer.MIN_VALUE && (!b || n2 >= mPrimaryOrientation.getEndAfterPadding()) && (b || n2 <= mPrimaryOrientation.getStartAfterPadding())) {
            if (n != Integer.MIN_VALUE) {
                n2 += n;
            }
            mCachedEnd = n2;
            mCachedStart = n2;
        }
    }
    
    void calculateCachedEnd() {
        final View view = (View)mViews.get(-1 + mViews.size());
        final LayoutParams layoutParams = this.getLayoutParams(view);
        mCachedEnd = mPrimaryOrientation.getDecoratedEnd(view);
        if (layoutParams.mFullSpan) {
            final LazySpanLookup.FullSpanItem fullSpanItem = mLazySpanLookup.getFullSpanItem(((RecyclerView.LayoutParams)layoutParams).getViewLayoutPosition());
            if (fullSpanItem != null && fullSpanItem.mGapDir == 1) {
                mCachedEnd += fullSpanItem.getGapForSpan(mIndex);
            }
        }
    }
    
    void calculateCachedStart() {
        final View view = (View)mViews.get(0);
        final LayoutParams layoutParams = this.getLayoutParams(view);
        mCachedStart = mPrimaryOrientation.getDecoratedStart(view);
        if (layoutParams.mFullSpan) {
            final LazySpanLookup.FullSpanItem fullSpanItem = mLazySpanLookup.getFullSpanItem(((RecyclerView.LayoutParams)layoutParams).getViewLayoutPosition());
            if (fullSpanItem != null && fullSpanItem.mGapDir == -1) {
                mCachedStart -= fullSpanItem.getGapForSpan(mIndex);
            }
        }
    }
    
    void clear() {
        mViews.clear();
        this.invalidateCache();
        mDeletedSize = 0;
    }
    
    public int findFirstCompletelyVisibleItemPosition() {
        if (StaggeredGridLayoutManager.access$600(this$0)) {
            return this.findOneVisibleChild(-1 + mViews.size(), -1, true);
        }
        return this.findOneVisibleChild(0, mViews.size(), true);
    }
    
    public int findFirstVisibleItemPosition() {
        if (StaggeredGridLayoutManager.access$600(this$0)) {
            return this.findOneVisibleChild(-1 + mViews.size(), -1, false);
        }
        return this.findOneVisibleChild(0, mViews.size(), false);
    }
    
    public int findLastCompletelyVisibleItemPosition() {
        if (StaggeredGridLayoutManager.access$600(this$0)) {
            return this.findOneVisibleChild(0, mViews.size(), true);
        }
        return this.findOneVisibleChild(-1 + mViews.size(), -1, true);
    }
    
    public int findLastVisibleItemPosition() {
        if (StaggeredGridLayoutManager.access$600(this$0)) {
            return this.findOneVisibleChild(0, mViews.size(), false);
        }
        return this.findOneVisibleChild(-1 + mViews.size(), -1, false);
    }
    
    int findOneVisibleChild(final int n, final int n2, final boolean b) {
        int position = -1;
        final int startAfterPadding = mPrimaryOrientation.getStartAfterPadding();
        final int endAfterPadding = mPrimaryOrientation.getEndAfterPadding();
        int n3;
        if (n2 > n) {
            n3 = 1;
        }
        else {
            n3 = position;
        }
        for (int i = n; i != n2; i += n3) {
            final View view = (View)mViews.get(i);
            final int decoratedStart = mPrimaryOrientation.getDecoratedStart(view);
            final int decoratedEnd = mPrimaryOrientation.getDecoratedEnd(view);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (!b) {
                    return ((RecyclerView.LayoutManager)this$0).getPosition(view);
                }
                if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                    position = ((RecyclerView.LayoutManager)this$0).getPosition(view);
                    break;
                }
            }
        }
        return position;
    }
    
    public int getDeletedSize() {
        return mDeletedSize;
    }
    
    int getEndLine() {
        if (mCachedEnd != Integer.MIN_VALUE) {
            return mCachedEnd;
        }
        this.calculateCachedEnd();
        return mCachedEnd;
    }
    
    int getEndLine(int mCachedEnd) {
        if (this.mCachedEnd != Integer.MIN_VALUE) {
            mCachedEnd = this.mCachedEnd;
        }
        else if (mViews.size() != 0) {
            this.calculateCachedEnd();
            return this.mCachedEnd;
        }
        return mCachedEnd;
    }
    
    public View getFocusableViewAfter(final int n, final int n2) {
        View view = null;
        if (n2 == -1) {
            for (int size = mViews.size(), i = 0; i < size; ++i) {
                final View view2 = (View)mViews.get(i);
                if (!view2.isFocusable() || ((RecyclerView.LayoutManager)this$0).getPosition(view2) > n != StaggeredGridLayoutManager.access$600(this$0)) {
                    break;
                }
                view = view2;
            }
        }
        else {
            for (int j = -1 + mViews.size(); j >= 0; --j) {
                final View view3 = (View)mViews.get(j);
                if (!view3.isFocusable()) {
                    break;
                }
                int n3;
                if (((RecyclerView.LayoutManager)this$0).getPosition(view3) > n) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
                int n4;
                if (!StaggeredGridLayoutManager.access$600(this$0)) {
                    n4 = 1;
                }
                else {
                    n4 = 0;
                }
                if (n3 != n4) {
                    break;
                }
                view = view3;
            }
        }
        return view;
    }
    
    LayoutParams getLayoutParams(final View view) {
        return (LayoutParams)view.getLayoutParams();
    }
    
    int getStartLine() {
        if (mCachedStart != Integer.MIN_VALUE) {
            return mCachedStart;
        }
        this.calculateCachedStart();
        return mCachedStart;
    }
    
    int getStartLine(int mCachedStart) {
        if (this.mCachedStart != Integer.MIN_VALUE) {
            mCachedStart = this.mCachedStart;
        }
        else if (mViews.size() != 0) {
            this.calculateCachedStart();
            return this.mCachedStart;
        }
        return mCachedStart;
    }
    
    void invalidateCache() {
        mCachedStart = Integer.MIN_VALUE;
        mCachedEnd = Integer.MIN_VALUE;
    }
    
    void onOffset(final int n) {
        if (mCachedStart != Integer.MIN_VALUE) {
            mCachedStart += n;
        }
        if (mCachedEnd != Integer.MIN_VALUE) {
            mCachedEnd += n;
        }
    }
    
    void popEnd() {
        final int size = mViews.size();
        final View view = (View)mViews.remove(size - 1);
        final LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = null;
        if (((RecyclerView.LayoutParams)layoutParams).isItemRemoved() || ((RecyclerView.LayoutParams)layoutParams).isItemChanged()) {
            mDeletedSize -= mPrimaryOrientation.getDecoratedMeasurement(view);
        }
        if (size == 1) {
            mCachedStart = Integer.MIN_VALUE;
        }
        mCachedEnd = Integer.MIN_VALUE;
    }
    
    void popStart() {
        final View view = (View)mViews.remove(0);
        final LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = null;
        if (mViews.size() == 0) {
            mCachedEnd = Integer.MIN_VALUE;
        }
        if (((RecyclerView.LayoutParams)layoutParams).isItemRemoved() || ((RecyclerView.LayoutParams)layoutParams).isItemChanged()) {
            mDeletedSize -= mPrimaryOrientation.getDecoratedMeasurement(view);
        }
        mCachedStart = Integer.MIN_VALUE;
    }
    
    void prependToSpan(final View view) {
        final LayoutParams layoutParams = this.getLayoutParams(view);
        layoutParams.mSpan = this;
        mViews.add(0, view);
        mCachedStart = Integer.MIN_VALUE;
        if (mViews.size() == 1) {
            mCachedEnd = Integer.MIN_VALUE;
        }
        if (((RecyclerView.LayoutParams)layoutParams).isItemRemoved() || ((RecyclerView.LayoutParams)layoutParams).isItemChanged()) {
            mDeletedSize += mPrimaryOrientation.getDecoratedMeasurement(view);
        }
    }
    
    void setLine(final int n) {
        mCachedStart = n;
        mCachedEnd = n;
    }
}
