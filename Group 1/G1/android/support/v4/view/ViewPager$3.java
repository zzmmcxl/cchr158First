package android.support.v4.view;

class ViewPager$3 implements Runnable {
    final /* synthetic */ ViewPager this$0;
    
    ViewPager$3(final ViewPager this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        ViewPager.access$000(this$0, 0);
        this$0.populate();
    }
}