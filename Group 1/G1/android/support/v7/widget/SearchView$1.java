package android.support.v7.widget;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

class SearchView$1 implements Runnable {
    final /* synthetic */ SearchView this$0;
    
    SearchView$1(final SearchView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        final InputMethodManager inputMethodManager = (InputMethodManager)this$0.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(inputMethodManager, (View)this$0, 0);
        }
    }
}