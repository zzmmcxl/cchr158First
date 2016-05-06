package android.support.v7.widget;

class Toolbar$2 implements Runnable {
    final /* synthetic */ Toolbar this$0;
    
    Toolbar$2(final Toolbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this$0.showOverflowMenu();
    }
}