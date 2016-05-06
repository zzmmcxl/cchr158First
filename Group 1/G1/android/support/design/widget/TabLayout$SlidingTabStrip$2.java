package android.support.design.widget;

class TabLayout$SlidingTabStrip$2 extends AnimatorListenerAdapter {
    final /* synthetic */ SlidingTabStrip this$1;
    final /* synthetic */ int val$position;
    
    TabLayout$SlidingTabStrip$2(final SlidingTabStrip this$1, final int val$position) {
        this$1 = this$1;
        val$position = val$position;
        super();
    }
    
    @Override
    public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
        SlidingTabStrip.access$2502(this$1, val$position);
        SlidingTabStrip.access$2602(this$1, 0.0f);
    }
}