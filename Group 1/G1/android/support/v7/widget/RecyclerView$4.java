package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.annotation.NonNull;

class RecyclerView$4 implements ProcessCallback {
    final /* synthetic */ RecyclerView this$0;
    
    RecyclerView$4(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void processAppeared(final ViewHolder viewHolder, final ItemHolderInfo itemHolderInfo, final ItemHolderInfo itemHolderInfo2) {
        RecyclerView.access$800(this$0, viewHolder, itemHolderInfo, itemHolderInfo2);
    }
    
    @Override
    public void processDisappeared(final ViewHolder viewHolder, @NonNull final ItemHolderInfo itemHolderInfo, @Nullable final ItemHolderInfo itemHolderInfo2) {
        mRecycler.unscrapView(viewHolder);
        RecyclerView.access$700(this$0, viewHolder, itemHolderInfo, itemHolderInfo2);
    }
    
    @Override
    public void processPersistent(final ViewHolder viewHolder, @NonNull final ItemHolderInfo itemHolderInfo, @NonNull final ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (RecyclerView.access$900(this$0)) {
            if (mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                RecyclerView.access$1000(this$0);
            }
        }
        else if (mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            RecyclerView.access$1000(this$0);
        }
    }
    
    @Override
    public void unused(final ViewHolder viewHolder) {
        mLayout.removeAndRecycleView(viewHolder.itemView, mRecycler);
    }
}