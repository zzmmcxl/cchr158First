package android.support.v7.widget;

import android.database.DataSetObserver;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ThemedSpinnerAdapter;
import android.content.res.Resources$Theme;
import android.support.annotation.Nullable;
import android.widget.SpinnerAdapter;
import android.widget.ListAdapter;

private static class DropDownAdapter implements ListAdapter, SpinnerAdapter
{
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(@Nullable final SpinnerAdapter mAdapter, @Nullable final Resources$Theme resources$Theme) {
        super();
        this.mAdapter = mAdapter;
        if (mAdapter instanceof ListAdapter) {
            this.mListAdapter = (ListAdapter)mAdapter;
        }
        if (resources$Theme != null) {
            if (AppCompatSpinner.access$100() && mAdapter instanceof ThemedSpinnerAdapter) {
                final ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter)mAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != resources$Theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(resources$Theme);
                }
            }
            else if (mAdapter instanceof android.support.v7.widget.ThemedSpinnerAdapter) {
                final android.support.v7.widget.ThemedSpinnerAdapter themedSpinnerAdapter2 = (android.support.v7.widget.ThemedSpinnerAdapter)mAdapter;
                if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter2.setDropDownViewTheme(resources$Theme);
                }
            }
        }
    }
    
    public boolean areAllItemsEnabled() {
        final ListAdapter mListAdapter = this.mListAdapter;
        return mListAdapter == null || mListAdapter.areAllItemsEnabled();
    }
    
    public int getCount() {
        if (mAdapter == null) {
            return 0;
        }
        return mAdapter.getCount();
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        if (mAdapter == null) {
            return null;
        }
        return mAdapter.getDropDownView(n, view, viewGroup);
    }
    
    public Object getItem(final int n) {
        if (mAdapter == null) {
            return null;
        }
        return mAdapter.getItem(n);
    }
    
    public long getItemId(final int n) {
        if (mAdapter == null) {
            return -1L;
        }
        return mAdapter.getItemId(n);
    }
    
    public int getItemViewType(final int n) {
        return 0;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        return this.getDropDownView(n, view, viewGroup);
    }
    
    public int getViewTypeCount() {
        return 1;
    }
    
    public boolean hasStableIds() {
        return mAdapter != null && mAdapter.hasStableIds();
    }
    
    public boolean isEmpty() {
        return this.getCount() == 0;
    }
    
    public boolean isEnabled(final int n) {
        final ListAdapter mListAdapter = this.mListAdapter;
        return mListAdapter == null || mListAdapter.isEnabled(n);
    }
    
    public void registerDataSetObserver(final DataSetObserver dataSetObserver) {
        if (mAdapter != null) {
            mAdapter.registerDataSetObserver(dataSetObserver);
        }
    }
    
    public void unregisterDataSetObserver(final DataSetObserver dataSetObserver) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
