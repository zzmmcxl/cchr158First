package android.support.design.widget;

class CollapsingToolbarLayout$2 implements AnimatorUpdateListener {
    final /* synthetic */ CollapsingToolbarLayout this$0;
    
    CollapsingToolbarLayout$2(final CollapsingToolbarLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        CollapsingToolbarLayout.access$200(this$0, valueAnimatorCompat.getAnimatedIntValue());
    }
}