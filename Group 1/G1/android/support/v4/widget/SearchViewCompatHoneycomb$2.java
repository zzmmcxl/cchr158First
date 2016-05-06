package android.support.v4.widget;

import android.widget.SearchView$OnCloseListener;

static final class SearchViewCompatHoneycomb$2 implements SearchView$OnCloseListener {
    final /* synthetic */ OnCloseListenerCompatBridge val$listener;
    
    SearchViewCompatHoneycomb$2(final OnCloseListenerCompatBridge val$listener) {
        this.val$listener = val$listener;
        super();
    }
    
    public boolean onClose() {
        return val$listener.onClose();
    }
}