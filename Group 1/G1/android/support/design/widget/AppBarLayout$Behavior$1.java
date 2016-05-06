package android.support.design.widget;

class AppBarLayout$Behavior$1 implements AnimatorUpdateListener {
    final /* synthetic */ Behavior this$0;
    final /* synthetic */ AppBarLayout val$child;
    final /* synthetic */ CoordinatorLayout val$coordinatorLayout;
    
    AppBarLayout$Behavior$1(final Behavior this$0, final CoordinatorLayout val$coordinatorLayout, final AppBarLayout val$child) {
        this$0 = this$0;
        val$coordinatorLayout = val$coordinatorLayout;
        val$child = val$child;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        this$0.setHeaderTopBottomOffset(val$coordinatorLayout, val$child, valueAnimatorCompat.getAnimatedIntValue());
    }
}