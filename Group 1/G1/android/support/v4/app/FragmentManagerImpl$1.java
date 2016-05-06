package android.support.v4.app;

class FragmentManagerImpl$1 implements Runnable {
    final /* synthetic */ FragmentManagerImpl this$0;
    
    FragmentManagerImpl$1(final FragmentManagerImpl this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this$0.execPendingActions();
    }
}