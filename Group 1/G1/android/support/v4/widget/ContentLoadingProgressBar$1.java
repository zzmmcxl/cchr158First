package android.support.v4.widget;

class ContentLoadingProgressBar$1 implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar this$0;
    
    ContentLoadingProgressBar$1(final ContentLoadingProgressBar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        ContentLoadingProgressBar.access$002(this$0, false);
        ContentLoadingProgressBar.access$102(this$0, -1L);
        this$0.setVisibility(8);
    }
}