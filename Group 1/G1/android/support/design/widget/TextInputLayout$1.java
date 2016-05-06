package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

class TextInputLayout$1 implements TextWatcher {
    final /* synthetic */ TextInputLayout this$0;
    
    TextInputLayout$1(final TextInputLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public void afterTextChanged(final Editable editable) {
        TextInputLayout.access$100(this$0, true);
        if (TextInputLayout.access$200(this$0)) {
            TextInputLayout.access$300(this$0, editable.length());
        }
    }
    
    public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
    }
    
    public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
    }
}