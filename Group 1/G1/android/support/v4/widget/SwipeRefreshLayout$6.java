package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$6 extends Animation {
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$6(final SwipeRefreshLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        int n2;
        if (!SwipeRefreshLayout.access$1000(this$0)) {
            n2 = (int)(SwipeRefreshLayout.access$1100(this$0) - Math.abs(mOriginalOffsetTop));
        }
        else {
            n2 = (int)SwipeRefreshLayout.access$1100(this$0);
        }
        SwipeRefreshLayout.access$1200(this$0, mFrom + (int)(n * (n2 - mFrom)) - SwipeRefreshLayout.access$500(this$0).getTop(), false);
        SwipeRefreshLayout.access$100(this$0).setArrowScale(1.0f - n);
    }
}