package android.support.v7.widget.util;

import android.support.v7.widget.RecyclerView;
import android.support.v7.util.SortedList;

public abstract class SortedListAdapterCallback<T2> extends Callback<T2>
{
    final RecyclerView.Adapter mAdapter;
    
    public SortedListAdapterCallback(final RecyclerView.Adapter mAdapter) {
        super();
        mAdapter = mAdapter;
    }
    
    @Override
    public void onChanged(final int n, final int n2) {
        mAdapter.notifyItemRangeChanged(n, n2);
    }
    
    @Override
    public void onInserted(final int n, final int n2) {
        mAdapter.notifyItemRangeInserted(n, n2);
    }
    
    @Override
    public void onMoved(final int n, final int n2) {
        mAdapter.notifyItemMoved(n, n2);
    }
    
    @Override
    public void onRemoved(final int n, final int n2) {
        mAdapter.notifyItemRangeRemoved(n, n2);
    }
}
