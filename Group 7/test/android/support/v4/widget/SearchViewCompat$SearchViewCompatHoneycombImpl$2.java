package android.support.v4.widget;

import android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat;
import android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl;
import android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge;

class SearchViewCompat$SearchViewCompatHoneycombImpl$2 implements SearchViewCompatHoneycomb$OnCloseListenerCompatBridge {
   SearchViewCompat$SearchViewCompatHoneycombImpl$2(SearchViewCompat$SearchViewCompatHoneycombImpl var1, SearchViewCompat$OnCloseListenerCompat var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public boolean onClose() {
      return this.val$listener.onClose();
   }
}
