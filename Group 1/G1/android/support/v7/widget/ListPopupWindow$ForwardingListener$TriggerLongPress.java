package android.support.v7.widget;

private class TriggerLongPress implements Runnable
{
    final /* synthetic */ ForwardingListener this$0;
    
    private TriggerLongPress(final ForwardingListener this$0) {
        this$0 = this$0;
        super();
    }
    
    TriggerLongPress(final ForwardingListener forwardingListener, final ListPopupWindow$1 forwardingListener2) {
        this(forwardingListener);
    }
    
    @Override
    public void run() {
        ForwardingListener.access$1000(this$0);
    }
}
