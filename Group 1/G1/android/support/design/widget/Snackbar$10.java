package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class Snackbar$10 implements Animation$AnimationListener {
    final /* synthetic */ Snackbar this$0;
    final /* synthetic */ int val$event;
    
    Snackbar$10(final Snackbar this$0, final int val$event) {
        this$0 = this$0;
        val$event = val$event;
        super();
    }
    
    public void onAnimationEnd(final Animation animation) {
        Snackbar.access$300(this$0, val$event);
    }
    
    public void onAnimationRepeat(final Animation animation) {
    }
    
    public void onAnimationStart(final Animation animation) {
    }
}