package android.support.v4.app;

class FragmentManagerImpl$4 implements Runnable {
    final /* synthetic */ FragmentManagerImpl this$0;
    final /* synthetic */ int val$flags;
    final /* synthetic */ int val$id;
    
    FragmentManagerImpl$4(final FragmentManagerImpl this$0, final int val$id, final int val$flags) {
        this$0 = this$0;
        val$id = val$id;
        val$flags = val$flags;
        super();
    }
    
    @Override
    public void run() {
        this$0.popBackStackState(mHost.getHandler(), null, val$id, val$flags);
    }
}