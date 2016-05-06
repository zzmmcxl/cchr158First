package android.support.v7.widget.helper;

import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.RecyclerView;

class ItemTouchHelper$3 extends RecoverAnimation {
    final /* synthetic */ ItemTouchHelper this$0;
    final /* synthetic */ ViewHolder val$prevSelected;
    final /* synthetic */ int val$swipeDir;
    
    ItemTouchHelper$3(final ItemTouchHelper this$0, final ViewHolder viewHolder, final int n, final int n2, final float n3, final float n4, final float n5, final float n6, final int val$swipeDir, final ViewHolder val$prevSelected) {
        this$0 = this$0;
        val$swipeDir = val$swipeDir;
        val$prevSelected = val$prevSelected;
        this$0.super(viewHolder, n, n2, n3, n4, n5, n6);
    }
    
    @Override
    public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
        super.onAnimationEnd(valueAnimatorCompat);
        if (!this.mOverridden) {
            if (val$swipeDir <= 0) {
                mCallback.clearView(ItemTouchHelper.access$300(this$0), val$prevSelected);
            }
            else {
                mPendingCleanup.add(val$prevSelected.itemView);
                this.mIsPendingCleanup = true;
                if (val$swipeDir > 0) {
                    ItemTouchHelper.access$1500(this$0, (RecoverAnimation)this, val$swipeDir);
                }
            }
            if (ItemTouchHelper.access$1600(this$0) == val$prevSelected.itemView) {
                ItemTouchHelper.access$1700(this$0, val$prevSelected.itemView);
            }
        }
    }
}