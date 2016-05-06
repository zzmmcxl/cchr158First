package android.support.design.widget;

class ValueAnimatorCompat$2 implements AnimatorListenerProxy {
    final /* synthetic */ ValueAnimatorCompat this$0;
    final /* synthetic */ AnimatorListener val$listener;
    
    ValueAnimatorCompat$2(final ValueAnimatorCompat this$0, final AnimatorListener val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public void onAnimationCancel() {
        val$listener.onAnimationCancel(this$0);
    }
    
    @Override
    public void onAnimationEnd() {
        val$listener.onAnimationEnd(this$0);
    }
    
    @Override
    public void onAnimationStart() {
        val$listener.onAnimationStart(this$0);
    }
}