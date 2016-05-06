package android.support.v7.widget;

class RecyclerView$2 implements Runnable {
    final /* synthetic */ RecyclerView this$0;
    
    RecyclerView$2(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        if (mItemAnimator != null) {
            mItemAnimator.runPendingAnimations();
        }
        RecyclerView.access$602(this$0, false);
    }
}