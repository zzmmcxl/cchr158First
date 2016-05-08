package android.support.v7.widget;

import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;

class SearchView$12 implements TextWatcher {
   SearchView$12(SearchView var1) {
      this.this$0 = var1;
   }

   public void afterTextChanged(Editable var1) {
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      SearchView.access$2000(this.this$0, var1);
   }
}
