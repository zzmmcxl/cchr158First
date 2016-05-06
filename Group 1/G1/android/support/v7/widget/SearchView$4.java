package android.support.v7.widget;

import android.view.View;
import android.view.View$OnFocusChangeListener;

class SearchView$4 implements View$OnFocusChangeListener {
    final /* synthetic */ SearchView this$0;
    
    SearchView$4(final SearchView this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onFocusChange(final View view, final boolean b) {
        if (SearchView.access$200(this$0) != null) {
            SearchView.access$200(this$0).onFocusChange((View)this$0, b);
        }
    }
}