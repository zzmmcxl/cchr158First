package android.support.v7.widget;

import android.database.Cursor;

class SearchView$3 implements Runnable {
    final /* synthetic */ SearchView this$0;
    
    SearchView$3(final SearchView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        if (SearchView.access$100(this$0) != null && SearchView.access$100(this$0) instanceof SuggestionsAdapter) {
            SearchView.access$100(this$0).changeCursor(null);
        }
    }
}