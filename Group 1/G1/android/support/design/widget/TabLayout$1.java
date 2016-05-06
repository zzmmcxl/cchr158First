package android.support.design.widget;

class TabLayout$1 implements AnimatorUpdateListener {
    final /* synthetic */ TabLayout this$0;
    
    TabLayout$1(final TabLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        this$0.scrollTo(valueAnimatorCompat.getAnimatedIntValue(), 0);
    }
}