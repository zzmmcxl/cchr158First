package android.support.v7.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1 extends DataSetObserver {
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$1(final ActivityChooserView this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onChanged() {
        super.onChanged();
        ActivityChooserView.access$000(this$0).notifyDataSetChanged();
    }
    
    public void onInvalidated() {
        super.onInvalidated();
        ActivityChooserView.access$000(this$0).notifyDataSetInvalidated();
    }
}