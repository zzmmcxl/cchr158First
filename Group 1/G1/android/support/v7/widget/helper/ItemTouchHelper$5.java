package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;

class ItemTouchHelper$5 implements ChildDrawingOrderCallback {
    final /* synthetic */ ItemTouchHelper this$0;
    
    ItemTouchHelper$5(final ItemTouchHelper this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public int onGetChildDrawingOrder(final int n, final int n2) {
        if (ItemTouchHelper.access$1600(this$0) != null) {
            int n3 = ItemTouchHelper.access$2300(this$0);
            if (n3 == -1) {
                n3 = ItemTouchHelper.access$300(this$0).indexOfChild(ItemTouchHelper.access$1600(this$0));
                ItemTouchHelper.access$2302(this$0, n3);
            }
            if (n2 == n - 1) {
                return n3;
            }
            if (n2 >= n3) {
                return n2 + 1;
            }
        }
        return n2;
    }
}