package android.support.v4.view;

import android.database.DataSetObserver;

private class PagerObserver extends DataSetObserver
{
    final /* synthetic */ ViewPager this$0;
    
    private PagerObserver(final ViewPager this$0) {
        this$0 = this$0;
        super();
    }
    
    PagerObserver(final ViewPager viewPager, final ViewPager$1 comparator) {
        this(viewPager);
    }
    
    public void onChanged() {
        this$0.dataSetChanged();
    }
    
    public void onInvalidated() {
        this$0.dataSetChanged();
    }
}
