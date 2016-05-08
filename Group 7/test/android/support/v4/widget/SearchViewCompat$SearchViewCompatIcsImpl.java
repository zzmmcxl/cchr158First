package android.support.v4.widget;

import android.content.Context;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl;
import android.support.v4.widget.SearchViewCompatIcs;
import android.view.View;

class SearchViewCompat$SearchViewCompatIcsImpl extends SearchViewCompat$SearchViewCompatHoneycombImpl {
   public View newSearchView(Context var1) {
      return SearchViewCompatIcs.newSearchView(var1);
   }

   public void setImeOptions(View var1, int var2) {
      SearchViewCompatIcs.setImeOptions(var1, var2);
   }

   public void setInputType(View var1, int var2) {
      SearchViewCompatIcs.setInputType(var1, var2);
   }
}
