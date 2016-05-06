package android.support.v7.widget;

class AbsActionBarView$1 implements Runnable {
    final /* synthetic */ AbsActionBarView this$0;
    
    AbsActionBarView$1(final AbsActionBarView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this$0.showOverflowMenu();
    }
}