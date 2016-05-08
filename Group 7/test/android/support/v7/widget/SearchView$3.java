package android.support.v7.widget;

import android.database.Cursor;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SuggestionsAdapter;

class SearchView$3 implements Runnable {
   SearchView$3(SearchView var1) {
      this.this$0 = var1;
   }

   public void run() {
      if(SearchView.access$100(this.this$0) != null && SearchView.access$100(this.this$0) instanceof SuggestionsAdapter) {
         SearchView.access$100(this.this$0).changeCursor((Cursor)null);
      }

   }
}
