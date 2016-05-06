package android.support.v7.widget;

import java.util.ArrayList;
import android.util.SparseArray;
import android.util.SparseIntArray;

public static class RecycledViewPool
{
    private static final int DEFAULT_MAX_SCRAP = 5;
    private int mAttachCount;
    private SparseIntArray mMaxScrap;
    private SparseArray<ArrayList<ViewHolder>> mScrap;
    
    public RecycledViewPool() {
        super();
        this.mScrap = (SparseArray<ArrayList<ViewHolder>>)new SparseArray();
        this.mMaxScrap = new SparseIntArray();
        this.mAttachCount = 0;
    }
    
    private ArrayList<ViewHolder> getScrapHeapForType(final int n) {
        ArrayList<ViewHolder> list = (ArrayList<ViewHolder>)mScrap.get(n);
        if (list == null) {
            list = new ArrayList<ViewHolder>();
            mScrap.put(n, (Object)list);
            if (mMaxScrap.indexOfKey(n) < 0) {
                mMaxScrap.put(n, 5);
            }
        }
        return list;
    }
    
    void attach(final Adapter adapter) {
        ++mAttachCount;
    }
    
    public void clear() {
        mScrap.clear();
    }
    
    void detach() {
        --mAttachCount;
    }
    
    public ViewHolder getRecycledView(final int n) {
        final ArrayList list = (ArrayList)mScrap.get(n);
        if (list != null && !list.isEmpty()) {
            final int n2 = -1 + list.size();
            final ViewHolder viewHolder = (ViewHolder)list.get(n2);
            list.remove(n2);
            return viewHolder;
        }
        return null;
    }
    
    void onAdapterChanged(final Adapter adapter, final Adapter adapter2, final boolean b) {
        if (adapter != null) {
            this.detach();
        }
        if (!b && mAttachCount == 0) {
            this.clear();
        }
        if (adapter2 != null) {
            this.attach(adapter2);
        }
    }
    
    public void putRecycledView(final ViewHolder viewHolder) {
        final int itemViewType = viewHolder.getItemViewType();
        final ArrayList<ViewHolder> scrapHeapForType = this.getScrapHeapForType(itemViewType);
        if (mMaxScrap.get(itemViewType) <= scrapHeapForType.size()) {
            return;
        }
        viewHolder.resetInternal();
        scrapHeapForType.add(viewHolder);
    }
    
    public void setMaxRecycledViews(final int n, final int n2) {
        mMaxScrap.put(n, n2);
        final ArrayList list = (ArrayList)mScrap.get(n);
        if (list != null) {
            while (list.size() > n2) {
                list.remove(-1 + list.size());
            }
        }
    }
    
    int size() {
        int n = 0;
        for (int i = 0; i < mScrap.size(); ++i) {
            final ArrayList list = (ArrayList)mScrap.valueAt(i);
            if (list != null) {
                n += list.size();
            }
        }
        return n;
    }
}
