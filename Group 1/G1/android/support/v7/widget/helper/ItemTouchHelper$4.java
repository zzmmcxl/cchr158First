package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;

class ItemTouchHelper$4 implements Runnable {
    final /* synthetic */ ItemTouchHelper this$0;
    final /* synthetic */ RecoverAnimation val$anim;
    final /* synthetic */ int val$swipeDir;
    
    ItemTouchHelper$4(final ItemTouchHelper this$0, final RecoverAnimation val$anim, final int val$swipeDir) {
        this$0 = this$0;
        val$anim = val$anim;
        val$swipeDir = val$swipeDir;
        super();
    }
    
    @Override
    public void run() {
        if (ItemTouchHelper.access$300(this$0) != null && ItemTouchHelper.access$300(this$0).isAttachedToWindow() && !val$anim.mOverridden && val$anim.mViewHolder.getAdapterPosition() != -1) {
            final RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.access$300(this$0).getItemAnimator();
            if ((itemAnimator != null && itemAnimator.isRunning(null)) || ItemTouchHelper.access$1800(this$0)) {
                ItemTouchHelper.access$300(this$0).post((Runnable)this);
                return;
            }
            mCallback.onSwiped(val$anim.mViewHolder, val$swipeDir);
        }
    }
}