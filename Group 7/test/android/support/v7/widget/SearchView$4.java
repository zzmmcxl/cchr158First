package android.support.v7.widget;

import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.View.OnFocusChangeListener;

class SearchView$4 implements OnFocusChangeListener {
   SearchView$4(SearchView var1) {
      this.this$0 = var1;
   }

   public void onFocusChange(View var1, boolean var2) {
      if(SearchView.access$200(this.this$0) != null) {
         SearchView.access$200(this.this$0).onFocusChange(this.this$0, var2);
      }

   }
}
