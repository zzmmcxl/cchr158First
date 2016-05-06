package android.support.v7.widget;

import android.util.Log;
import android.view.View;
import java.util.List;

static class LayoutState
{
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
    static final String TAG = "LinearLayoutManager#LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mExtra;
    boolean mInfinite;
    boolean mIsPreLayout;
    int mItemDirection;
    int mLastScrollDelta;
    int mLayoutDirection;
    int mOffset;
    boolean mRecycle;
    List<ViewHolder> mScrapList;
    int mScrollingOffset;
    
    LayoutState() {
        super();
        this.mRecycle = true;
        this.mExtra = 0;
        this.mIsPreLayout = false;
        this.mScrapList = null;
    }
    
    private View nextViewFromScrapList() {
        for (int size = mScrapList.size(), i = 0; i < size; ++i) {
            final View itemView = ((ViewHolder)mScrapList.get(i)).itemView;
            final LayoutParams layoutParams = (LayoutParams)itemView.getLayoutParams();
            if (!layoutParams.isItemRemoved() && mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                this.assignPositionFromScrapList(itemView);
                return itemView;
            }
        }
        return null;
    }
    
    public void assignPositionFromScrapList() {
        this.assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(final View view) {
        final View nextViewInLimitedList = this.nextViewInLimitedList(view);
        if (nextViewInLimitedList == null) {
            mCurrentPosition = -1;
            return;
        }
        mCurrentPosition = ((LayoutParams)nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
    }
    
    boolean hasMore(final State state) {
        return mCurrentPosition >= 0 && mCurrentPosition < state.getItemCount();
    }
    
    void log() {
        Log.d("LinearLayoutManager#LayoutState", "avail:" + mAvailable + ", ind:" + mCurrentPosition + ", dir:" + mItemDirection + ", offset:" + mOffset + ", layoutDir:" + mLayoutDirection);
    }
    
    View next(final Recycler recycler) {
        if (mScrapList != null) {
            return this.nextViewFromScrapList();
        }
        final View viewForPosition = recycler.getViewForPosition(mCurrentPosition);
        mCurrentPosition += mItemDirection;
        return viewForPosition;
    }
    
    public View nextViewInLimitedList(final View view) {
        final int size = mScrapList.size();
        View view2 = null;
        int n = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i) {
            final View itemView = ((ViewHolder)mScrapList.get(i)).itemView;
            final LayoutParams layoutParams = (LayoutParams)itemView.getLayoutParams();
            if (itemView != view && !layoutParams.isItemRemoved()) {
                final int n2 = (layoutParams.getViewLayoutPosition() - mCurrentPosition) * mItemDirection;
                if (n2 >= 0 && n2 < n) {
                    view2 = itemView;
                    if ((n = n2) == 0) {
                        break;
                    }
                }
            }
        }
        return view2;
    }
}
