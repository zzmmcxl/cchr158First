package android.support.v4.app;

class FragmentManagerImpl$2 implements Runnable {
    final /* synthetic */ FragmentManagerImpl this$0;
    
    FragmentManagerImpl$2(final FragmentManagerImpl this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this$0.popBackStackState(mHost.getHandler(), null, -1, 0);
    }
}