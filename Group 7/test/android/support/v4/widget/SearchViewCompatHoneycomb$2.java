package android.support.v4.widget;

import android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge;
import android.widget.SearchView.OnCloseListener;

final class SearchViewCompatHoneycomb$2 implements OnCloseListener {
   SearchViewCompatHoneycomb$2(SearchViewCompatHoneycomb$OnCloseListenerCompatBridge var1) {
      this.val$listener = var1;
   }

   public boolean onClose() {
      return this.val$listener.onClose();
   }
}
