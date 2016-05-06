package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl
{
    SlidingPanelLayoutImplBase() {
        super();
    }
    
    @Override
    public void invalidateChildRegion(final SlidingPaneLayout slidingPaneLayout, final View view) {
        ViewCompat.postInvalidateOnAnimation((View)slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
