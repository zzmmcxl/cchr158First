package android.support.v7.widget;

import android.util.SparseArray;

class RecyclerView$6 implements Callback {
    final /* synthetic */ RecyclerView this$0;
    
    RecyclerView$6(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    void dispatchUpdate(final UpdateOp updateOp) {
        switch (updateOp.cmd) {
            default:
            case 1:
                mLayout.onItemsAdded(this$0, updateOp.positionStart, updateOp.itemCount);
            case 2:
                mLayout.onItemsRemoved(this$0, updateOp.positionStart, updateOp.itemCount);
            case 4:
                mLayout.onItemsUpdated(this$0, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            case 8:
                mLayout.onItemsMoved(this$0, updateOp.positionStart, updateOp.itemCount, 1);
        }
    }
    
    @Override
    public ViewHolder findViewHolder(final int n) {
        Object viewHolderForPosition = this$0.findViewHolderForPosition(n, true);
        if (viewHolderForPosition == null) {
            viewHolderForPosition = null;
        }
        else if (mChildHelper.isHidden(((ViewHolder)viewHolderForPosition).itemView)) {
            return null;
        }
        return (ViewHolder)viewHolderForPosition;
    }
    
    @Override
    public void markViewHoldersUpdated(final int n, final int n2, final Object o) {
        this$0.viewRangeUpdate(n, n2, o);
        mItemsChanged = true;
    }
    
    @Override
    public void offsetPositionsForAdd(final int n, final int n2) {
        this$0.offsetPositionRecordsForInsert(n, n2);
        mItemsAddedOrRemoved = true;
    }
    
    @Override
    public void offsetPositionsForMove(final int n, final int n2) {
        this$0.offsetPositionRecordsForMove(n, n2);
        mItemsAddedOrRemoved = true;
    }
    
    @Override
    public void offsetPositionsForRemovingInvisible(final int n, final int n2) {
        this$0.offsetPositionRecordsForRemove(n, n2, true);
        mItemsAddedOrRemoved = true;
        State.access$1712(mState, n2);
    }
    
    @Override
    public void offsetPositionsForRemovingLaidOutOrNewView(final int n, final int n2) {
        this$0.offsetPositionRecordsForRemove(n, n2, false);
        mItemsAddedOrRemoved = true;
    }
    
    @Override
    public void onDispatchFirstPass(final UpdateOp updateOp) {
        this.dispatchUpdate(updateOp);
    }
    
    @Override
    public void onDispatchSecondPass(final UpdateOp updateOp) {
        this.dispatchUpdate(updateOp);
    }
}