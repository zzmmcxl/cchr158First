package android.support.v4.widget;

import android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl;
import android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge;

class SearchViewCompat$SearchViewCompatHoneycombImpl$1 implements SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge {
   SearchViewCompat$SearchViewCompatHoneycombImpl$1(SearchViewCompat$SearchViewCompatHoneycombImpl var1, SearchViewCompat$OnQueryTextListenerCompat var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public boolean onQueryTextChange(String var1) {
      return this.val$listener.onQueryTextChange(var1);
   }

   public boolean onQueryTextSubmit(String var1) {
      return this.val$listener.onQueryTextSubmit(var1);
   }
}
