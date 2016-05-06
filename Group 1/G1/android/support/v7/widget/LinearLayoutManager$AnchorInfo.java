package android.support.v7.widget;

import android.view.View;

class AnchorInfo
{
    int mCoordinate;
    boolean mLayoutFromEnd;
    int mPosition;
    final /* synthetic */ LinearLayoutManager this$0;
    
    AnchorInfo(final LinearLayoutManager this$0) {
        this$0 = this$0;
        super();
    }
    
    static /* synthetic */ boolean access$000(final AnchorInfo anchorInfo, final View view, final State state) {
        return anchorInfo.isViewValidAsAnchor(view, state);
    }
    
    private boolean isViewValidAsAnchor(final View view, final State state) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
    }
    
    void assignCoordinateFromPadding() {
        int mCoordinate;
        if (mLayoutFromEnd) {
            mCoordinate = mOrientationHelper.getEndAfterPadding();
        }
        else {
            mCoordinate = mOrientationHelper.getStartAfterPadding();
        }
        this.mCoordinate = mCoordinate;
    }
    
    public void assignFromView(final View view) {
        if (mLayoutFromEnd) {
            mCoordinate = mOrientationHelper.getDecoratedEnd(view) + mOrientationHelper.getTotalSpaceChange();
        }
        else {
            mCoordinate = mOrientationHelper.getDecoratedStart(view);
        }
        mPosition = ((RecyclerView.LayoutManager)this$0).getPosition(view);
    }
    
    public void assignFromViewAndKeepVisibleRect(final View view) {
        final int totalSpaceChange = mOrientationHelper.getTotalSpaceChange();
        if (totalSpaceChange >= 0) {
            this.assignFromView(view);
        }
        else {
            mPosition = ((RecyclerView.LayoutManager)this$0).getPosition(view);
            if (mLayoutFromEnd) {
                final int n = mOrientationHelper.getEndAfterPadding() - totalSpaceChange - mOrientationHelper.getDecoratedEnd(view);
                mCoordinate = mOrientationHelper.getEndAfterPadding() - n;
                if (n > 0) {
                    final int n2 = mCoordinate - mOrientationHelper.getDecoratedMeasurement(view);
                    final int startAfterPadding = mOrientationHelper.getStartAfterPadding();
                    final int n3 = n2 - (startAfterPadding + Math.min(mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0));
                    if (n3 < 0) {
                        mCoordinate += Math.min(n, -n3);
                    }
                }
            }
            else {
                final int decoratedStart = mOrientationHelper.getDecoratedStart(view);
                final int n4 = decoratedStart - mOrientationHelper.getStartAfterPadding();
                mCoordinate = decoratedStart;
                if (n4 > 0) {
                    final int n5 = mOrientationHelper.getEndAfterPadding() - Math.min(0, mOrientationHelper.getEndAfterPadding() - totalSpaceChange - mOrientationHelper.getDecoratedEnd(view)) - (decoratedStart + mOrientationHelper.getDecoratedMeasurement(view));
                    if (n5 < 0) {
                        mCoordinate -= Math.min(n4, -n5);
                    }
                }
            }
        }
    }
    
    void reset() {
        mPosition = -1;
        mCoordinate = Integer.MIN_VALUE;
        mLayoutFromEnd = false;
    }
    
    @Override
    public String toString() {
        return "AnchorInfo{mPosition=" + mPosition + ", mCoordinate=" + mCoordinate + ", mLayoutFromEnd=" + mLayoutFromEnd + '}';
    }
}
