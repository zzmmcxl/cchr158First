package android.support.v4.widget;

import android.widget.SearchView$OnQueryTextListener;

static final class SearchViewCompatHoneycomb$1 implements SearchView$OnQueryTextListener {
    final /* synthetic */ OnQueryTextListenerCompatBridge val$listener;
    
    SearchViewCompatHoneycomb$1(final OnQueryTextListenerCompatBridge val$listener) {
        this.val$listener = val$listener;
        super();
    }
    
    public boolean onQueryTextChange(final String s) {
        return val$listener.onQueryTextChange(s);
    }
    
    public boolean onQueryTextSubmit(final String s) {
        return val$listener.onQueryTextSubmit(s);
    }
}