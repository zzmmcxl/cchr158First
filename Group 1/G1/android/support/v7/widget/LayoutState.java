package android.support.v7.widget;

import android.view.View;

class LayoutState
{
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final String TAG = "LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mEndLine;
    boolean mInfinite;
    int mItemDirection;
    int mLayoutDirection;
    boolean mRecycle;
    int mStartLine;
    boolean mStopInFocusable;
    
    LayoutState() {
        super();
        mRecycle = true;
        mStartLine = 0;
        mEndLine = 0;
    }
    
    boolean hasMore(final RecyclerView.State state) {
        return mCurrentPosition >= 0 && mCurrentPosition < state.getItemCount();
    }
    
    View next(final RecyclerView.Recycler recycler) {
        final View viewForPosition = recycler.getViewForPosition(mCurrentPosition);
        mCurrentPosition += mItemDirection;
        return viewForPosition;
    }
    
    @Override
    public String toString() {
        return "LayoutState{mAvailable=" + mAvailable + ", mCurrentPosition=" + mCurrentPosition + ", mItemDirection=" + mItemDirection + ", mLayoutDirection=" + mLayoutDirection + ", mStartLine=" + mStartLine + ", mEndLine=" + mEndLine + '}';
    }
}
