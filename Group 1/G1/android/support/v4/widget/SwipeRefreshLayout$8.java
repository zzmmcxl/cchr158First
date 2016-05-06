package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$8 extends Animation {
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$8(final SwipeRefreshLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        SwipeRefreshLayout.access$700(this$0, SwipeRefreshLayout.access$1400(this$0) + n * -SwipeRefreshLayout.access$1400(this$0));
        SwipeRefreshLayout.access$1300(this$0, n);
    }
}