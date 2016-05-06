package android.support.design.widget;

class TabLayout$SlidingTabStrip$1 implements AnimatorUpdateListener {
    final /* synthetic */ SlidingTabStrip this$1;
    final /* synthetic */ int val$startLeft;
    final /* synthetic */ int val$startRight;
    final /* synthetic */ int val$targetLeft;
    final /* synthetic */ int val$targetRight;
    
    TabLayout$SlidingTabStrip$1(final SlidingTabStrip this$1, final int val$startLeft, final int val$targetLeft, final int val$startRight, final int val$targetRight) {
        this$1 = this$1;
        val$startLeft = val$startLeft;
        val$targetLeft = val$targetLeft;
        val$startRight = val$startRight;
        val$targetRight = val$targetRight;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        final float animatedFraction = valueAnimatorCompat.getAnimatedFraction();
        SlidingTabStrip.access$2400(this$1, AnimationUtils.lerp(val$startLeft, val$targetLeft, animatedFraction), AnimationUtils.lerp(val$startRight, val$targetRight, animatedFraction));
    }
}