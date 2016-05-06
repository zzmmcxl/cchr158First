package android.support.v7.widget;

class RecyclerView$1 implements Runnable {
    final /* synthetic */ RecyclerView this$0;
    
    RecyclerView$1(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        if (!RecyclerView.access$100(this$0) || this$0.isLayoutRequested()) {
            return;
        }
        if (RecyclerView.access$200(this$0)) {
            RecyclerView.access$302(this$0, true);
            return;
        }
        RecyclerView.access$400(this$0);
    }
}