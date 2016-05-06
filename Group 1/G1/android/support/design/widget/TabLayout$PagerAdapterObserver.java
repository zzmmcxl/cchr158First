package android.support.design.widget;

import android.database.DataSetObserver;

private class PagerAdapterObserver extends DataSetObserver
{
    final /* synthetic */ TabLayout this$0;
    
    private PagerAdapterObserver(final TabLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    PagerAdapterObserver(final TabLayout tabLayout, final TabLayout$1 animatorUpdateListener) {
        this(tabLayout);
    }
    
    public void onChanged() {
        TabLayout.access$2800(this$0);
    }
    
    public void onInvalidated() {
        TabLayout.access$2800(this$0);
    }
}
