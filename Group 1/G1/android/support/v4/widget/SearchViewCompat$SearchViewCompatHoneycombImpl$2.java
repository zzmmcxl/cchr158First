package android.support.v4.widget;

class SearchViewCompat$SearchViewCompatHoneycombImpl$2 implements OnCloseListenerCompatBridge {
    final /* synthetic */ SearchViewCompatHoneycombImpl this$0;
    final /* synthetic */ OnCloseListenerCompat val$listener;
    
    SearchViewCompat$SearchViewCompatHoneycombImpl$2(final SearchViewCompatHoneycombImpl this$0, final OnCloseListenerCompat val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public boolean onClose() {
        return val$listener.onClose();
    }
}