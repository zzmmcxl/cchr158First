package android.support.v7.widget.helper;

import android.view.View;
import android.support.v4.view.ViewCompat;

class ItemTouchHelper$1 implements Runnable {
    final /* synthetic */ ItemTouchHelper this$0;
    
    ItemTouchHelper$1(final ItemTouchHelper this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        if (mSelected != null && ItemTouchHelper.access$000(this$0)) {
            if (mSelected != null) {
                ItemTouchHelper.access$100(this$0, mSelected);
            }
            ItemTouchHelper.access$300(this$0).removeCallbacks(ItemTouchHelper.access$200(this$0));
            ViewCompat.postOnAnimation(ItemTouchHelper.access$300(this$0), (Runnable)this);
        }
    }
}