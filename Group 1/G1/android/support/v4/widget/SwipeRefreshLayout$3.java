package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$3 extends Animation {
    final /* synthetic */ SwipeRefreshLayout this$0;
    
    SwipeRefreshLayout$3(final SwipeRefreshLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        SwipeRefreshLayout.access$700(this$0, 1.0f - n);
    }
}