package android.support.v7.widget;

import android.util.SparseArray;
import android.view.View;
import android.support.v4.view.ViewCompat;

private class RecyclerViewDataObserver extends AdapterDataObserver
{
    final /* synthetic */ RecyclerView this$0;
    
    private RecyclerViewDataObserver(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    RecyclerViewDataObserver(final RecyclerView recyclerView, final RecyclerView$1 runnable) {
        this(recyclerView);
    }
    
    @Override
    public void onChanged() {
        this$0.assertNotInLayoutOrScroll(null);
        if (RecyclerView.access$3100(this$0).hasStableIds()) {
            mState.mStructureChanged = true;
            RecyclerView.access$4000(this$0);
        }
        else {
            mState.mStructureChanged = true;
            RecyclerView.access$4000(this$0);
        }
        if (!mAdapterHelper.hasPendingUpdates()) {
            this$0.requestLayout();
        }
    }
    
    @Override
    public void onItemRangeChanged(final int n, final int n2, final Object o) {
        this$0.assertNotInLayoutOrScroll(null);
        if (mAdapterHelper.onItemRangeChanged(n, n2, o)) {
            this.triggerUpdateProcessor();
        }
    }
    
    @Override
    public void onItemRangeInserted(final int n, final int n2) {
        this$0.assertNotInLayoutOrScroll(null);
        if (mAdapterHelper.onItemRangeInserted(n, n2)) {
            this.triggerUpdateProcessor();
        }
    }
    
    @Override
    public void onItemRangeMoved(final int n, final int n2, final int n3) {
        this$0.assertNotInLayoutOrScroll(null);
        if (mAdapterHelper.onItemRangeMoved(n, n2, n3)) {
            this.triggerUpdateProcessor();
        }
    }
    
    @Override
    public void onItemRangeRemoved(final int n, final int n2) {
        this$0.assertNotInLayoutOrScroll(null);
        if (mAdapterHelper.onItemRangeRemoved(n, n2)) {
            this.triggerUpdateProcessor();
        }
    }
    
    void triggerUpdateProcessor() {
        if (RecyclerView.access$4100(this$0) && RecyclerView.access$4200(this$0) && RecyclerView.access$4300(this$0)) {
            ViewCompat.postOnAnimation((View)this$0, RecyclerView.access$4400(this$0));
            return;
        }
        RecyclerView.access$4502(this$0, true);
        this$0.requestLayout();
    }
}
