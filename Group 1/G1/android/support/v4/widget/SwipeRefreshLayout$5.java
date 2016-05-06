package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class SwipeRefreshLayout$5 implements Animation$AnimationListener {
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$5(final SwipeRefreshLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onAnimationEnd(final Animation animation) {
        if (!SwipeRefreshLayout.access$800(this$0)) {
            SwipeRefreshLayout.access$900(this$0, null);
        }
    }
    
    public void onAnimationRepeat(final Animation animation) {
    }
    
    public void onAnimationStart(final Animation animation) {
    }
}