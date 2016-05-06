package android.support.design.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class Snackbar$9 extends ViewPropertyAnimatorListenerAdapter {
    boolean mEndCalled = false;
    final /* synthetic */ Snackbar this$0;
    final /* synthetic */ int val$event;
    
    Snackbar$9(final Snackbar this$0, final int val$event) {
        this$0 = this$0;
        val$event = val$event;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        Snackbar.access$300(this$0, val$event);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        if (!Snackbar.access$600(this$0).isEnabled()) {
            Snackbar.access$500(this$0).animateChildrenOut(0, 180);
        }
    }
}