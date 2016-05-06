package android.support.v4.widget;

class ContentLoadingProgressBar$2 implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar this$0;
    
    ContentLoadingProgressBar$2(final ContentLoadingProgressBar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        ContentLoadingProgressBar.access$202(this$0, false);
        if (!ContentLoadingProgressBar.access$300(this$0)) {
            ContentLoadingProgressBar.access$102(this$0, System.currentTimeMillis());
            this$0.setVisibility(0);
        }
    }
}