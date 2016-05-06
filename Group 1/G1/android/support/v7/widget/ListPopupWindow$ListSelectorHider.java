package android.support.v7.widget;

private class ListSelectorHider implements Runnable
{
    final /* synthetic */ ListPopupWindow this$0;
    
    private ListSelectorHider(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    ListSelectorHider(final ListPopupWindow listPopupWindow, final ListPopupWindow$1 forwardingListener) {
        this(listPopupWindow);
    }
    
    @Override
    public void run() {
        this$0.clearListSelection();
    }
}
