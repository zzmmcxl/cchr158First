package android.support.v7.widget;

private class DisallowIntercept implements Runnable
{
    final /* synthetic */ ForwardingListener this$0;
    
    private DisallowIntercept(final ForwardingListener this$0) {
        this$0 = this$0;
        super();
    }
    
    DisallowIntercept(final ForwardingListener forwardingListener, final ListPopupWindow$1 forwardingListener2) {
        this(forwardingListener);
    }
    
    @Override
    public void run() {
        ForwardingListener.access$900(this$0).getParent().requestDisallowInterceptTouchEvent(true);
    }
}
