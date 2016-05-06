package android.support.v4.widget;

import android.support.v4.view.ViewCompat;

private class ScrollAnimationRunnable implements Runnable
{
    final /* synthetic */ AutoScrollHelper this$0;
    
    private ScrollAnimationRunnable(final AutoScrollHelper this$0) {
        this$0 = this$0;
        super();
    }
    
    ScrollAnimationRunnable(final AutoScrollHelper autoScrollHelper, final AutoScrollHelper$1 object) {
        this(autoScrollHelper);
    }
    
    @Override
    public void run() {
        if (!AutoScrollHelper.access$100(this$0)) {
            return;
        }
        if (AutoScrollHelper.access$200(this$0)) {
            AutoScrollHelper.access$202(this$0, false);
            AutoScrollHelper.access$300(this$0).start();
        }
        final ClampedScroller access$300 = AutoScrollHelper.access$300(this$0);
        if (access$300.isFinished() || !AutoScrollHelper.access$400(this$0)) {
            AutoScrollHelper.access$102(this$0, false);
            return;
        }
        if (AutoScrollHelper.access$500(this$0)) {
            AutoScrollHelper.access$502(this$0, false);
            AutoScrollHelper.access$600(this$0);
        }
        access$300.computeScrollDelta();
        this$0.scrollTargetBy(access$300.getDeltaX(), access$300.getDeltaY());
        ViewCompat.postOnAnimation(AutoScrollHelper.access$700(this$0), this);
    }
}
