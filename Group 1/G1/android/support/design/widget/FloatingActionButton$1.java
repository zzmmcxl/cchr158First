package android.support.design.widget;

class FloatingActionButton$1 implements InternalVisibilityChangedListener {
    final /* synthetic */ FloatingActionButton this$0;
    final /* synthetic */ OnVisibilityChangedListener val$listener;
    
    FloatingActionButton$1(final FloatingActionButton this$0, final OnVisibilityChangedListener val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public void onHidden() {
        val$listener.onHidden(this$0);
    }
    
    @Override
    public void onShown() {
        val$listener.onShown(this$0);
    }
}