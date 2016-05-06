package android.support.v4.animation;

class DonutAnimatorCompatProvider$DonutFloatValueAnimator$1 implements Runnable {
    final /* synthetic */ DonutFloatValueAnimator this$0;
    
    DonutAnimatorCompatProvider$DonutFloatValueAnimator$1(final DonutFloatValueAnimator this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        float n = 1.0f * (DonutFloatValueAnimator.access$000(this$0) - DonutFloatValueAnimator.access$100(this$0)) / DonutFloatValueAnimator.access$200(this$0);
        if (n > 1.0f || mTarget.getParent() == null) {
            n = 1.0f;
        }
        DonutFloatValueAnimator.access$302(this$0, n);
        DonutFloatValueAnimator.access$400(this$0);
        if (DonutFloatValueAnimator.access$300(this$0) >= 1.0f) {
            DonutFloatValueAnimator.access$500(this$0);
            return;
        }
        mTarget.postDelayed(DonutFloatValueAnimator.access$600(this$0), 16L);
    }
}