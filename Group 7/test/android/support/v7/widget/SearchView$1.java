package android.support.v7.widget;

import android.support.v7.widget.SearchView;
import android.view.inputmethod.InputMethodManager;

class SearchView$1 implements Runnable {
   SearchView$1(SearchView var1) {
      this.this$0 = var1;
   }

   public void run() {
      InputMethodManager var1 = (InputMethodManager)this.this$0.getContext().getSystemService("input_method");
      if(var1 != null) {
         SearchView.HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(var1, this.this$0, 0);
      }

   }
}
