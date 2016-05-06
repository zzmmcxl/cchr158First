package android.support.design.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class Snackbar$7 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ Snackbar this$0;
    
    Snackbar$7(final Snackbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        Snackbar.access$700(this$0);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        if (!Snackbar.access$600(this$0).isEnabled()) {
            Snackbar.access$500(this$0).animateChildrenIn(70, 180);
        }
    }
}