package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class SwipeRefreshLayout$1 implements Animation$AnimationListener {
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$1(final SwipeRefreshLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onAnimationEnd(final Animation animation) {
        if (SwipeRefreshLayout.access$000(this$0)) {
            SwipeRefreshLayout.access$100(this$0).setAlpha(255);
            SwipeRefreshLayout.access$100(this$0).start();
            if (SwipeRefreshLayout.access$200(this$0) && SwipeRefreshLayout.access$300(this$0) != null) {
                SwipeRefreshLayout.access$300(this$0).onRefresh();
            }
            SwipeRefreshLayout.access$402(this$0, SwipeRefreshLayout.access$500(this$0).getTop());
            return;
        }
        SwipeRefreshLayout.access$600(this$0);
    }
    
    public void onAnimationRepeat(final Animation animation) {
    }
    
    public void onAnimationStart(final Animation animation) {
    }
}