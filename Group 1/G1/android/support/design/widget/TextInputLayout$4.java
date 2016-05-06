package android.support.design.widget;

class TextInputLayout$4 implements AnimatorUpdateListener {
    final /* synthetic */ TextInputLayout this$0;
    
    TextInputLayout$4(final TextInputLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        TextInputLayout.access$500(this$0).setExpansionFraction(valueAnimatorCompat.getAnimatedFloatValue());
    }
}