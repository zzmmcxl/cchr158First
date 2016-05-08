package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public class SearchViewCompatIcs$MySearchView extends SearchView {
   public SearchViewCompatIcs$MySearchView(Context var1) {
      super(var1);
   }

   public void onActionViewCollapsed() {
      this.setQuery("", false);
      super.onActionViewCollapsed();
   }
}
