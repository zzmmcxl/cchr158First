package android.support.v4.app;

class FragmentManagerImpl$3 implements Runnable {
    final /* synthetic */ FragmentManagerImpl this$0;
    final /* synthetic */ int val$flags;
    final /* synthetic */ String val$name;
    
    FragmentManagerImpl$3(final FragmentManagerImpl this$0, final String val$name, final int val$flags) {
        this$0 = this$0;
        val$name = val$name;
        val$flags = val$flags;
        super();
    }
    
    @Override
    public void run() {
        this$0.popBackStackState(mHost.getHandler(), val$name, -1, val$flags);
    }
}