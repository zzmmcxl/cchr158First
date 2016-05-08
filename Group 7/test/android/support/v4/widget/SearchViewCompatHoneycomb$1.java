package android.support.v4.widget;

import android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge;
import android.widget.SearchView.OnQueryTextListener;

final class SearchViewCompatHoneycomb$1 implements OnQueryTextListener {
   SearchViewCompatHoneycomb$1(SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge var1) {
      this.val$listener = var1;
   }

   public boolean onQueryTextChange(String var1) {
      return this.val$listener.onQueryTextChange(var1);
   }

   public boolean onQueryTextSubmit(String var1) {
      return this.val$listener.onQueryTextSubmit(var1);
   }
}
