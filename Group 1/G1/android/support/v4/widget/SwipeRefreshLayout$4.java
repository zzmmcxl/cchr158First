package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class SwipeRefreshLayout$4 extends Animation {
    final /* synthetic */ SwipeRefreshLayout this$0;
    final /* synthetic */ int val$endingAlpha;
    final /* synthetic */ int val$startingAlpha;
    
    SwipeRefreshLayout$4(final SwipeRefreshLayout this$0, final int val$startingAlpha, final int val$endingAlpha) {
        this$0 = this$0;
        val$startingAlpha = val$startingAlpha;
        val$endingAlpha = val$endingAlpha;
        super();
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        SwipeRefreshLayout.access$100(this$0).setAlpha((int)(val$startingAlpha + n * (val$endingAlpha - val$startingAlpha)));
    }
}