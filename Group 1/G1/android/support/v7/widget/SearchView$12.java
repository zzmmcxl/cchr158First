package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

class SearchView$12 implements TextWatcher {
    final /* synthetic */ SearchView this$0;
    
    SearchView$12(final SearchView this$0) {
        this$0 = this$0;
        super();
    }
    
    public void afterTextChanged(final Editable editable) {
    }
    
    public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
    }
    
    public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        SearchView.access$2000(this$0, charSequence);
    }
}