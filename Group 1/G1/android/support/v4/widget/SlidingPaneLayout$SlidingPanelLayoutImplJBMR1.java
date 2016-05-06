package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase
{
    SlidingPanelLayoutImplJBMR1() {
        super();
    }
    
    @Override
    public void invalidateChildRegion(final SlidingPaneLayout slidingPaneLayout, final View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams)view.getLayoutParams()).dimPaint);
    }
}
