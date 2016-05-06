package android.support.design.widget;

class ValueAnimatorCompat$1 implements AnimatorUpdateListenerProxy {
    final /* synthetic */ ValueAnimatorCompat this$0;
    final /* synthetic */ AnimatorUpdateListener val$updateListener;
    
    ValueAnimatorCompat$1(final ValueAnimatorCompat this$0, final AnimatorUpdateListener val$updateListener) {
        this$0 = this$0;
        val$updateListener = val$updateListener;
        super();
    }
    
    @Override
    public void onAnimationUpdate() {
        val$updateListener.onAnimationUpdate(this$0);
    }
}