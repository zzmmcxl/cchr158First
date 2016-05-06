package android.support.v4.widget;

class SearchViewCompat$SearchViewCompatHoneycombImpl$1 implements OnQueryTextListenerCompatBridge {
    final /* synthetic */ SearchViewCompatHoneycombImpl this$0;
    final /* synthetic */ OnQueryTextListenerCompat val$listener;
    
    SearchViewCompat$SearchViewCompatHoneycombImpl$1(final SearchViewCompatHoneycombImpl this$0, final OnQueryTextListenerCompat val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public boolean onQueryTextChange(final String s) {
        return val$listener.onQueryTextChange(s);
    }
    
    @Override
    public boolean onQueryTextSubmit(final String s) {
        return val$listener.onQueryTextSubmit(s);
    }
}