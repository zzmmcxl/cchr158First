package android.support.v4.widget;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.view.View;

private class DisableLayerRunnable implements Runnable
{
    final View mChildView;
    final /* synthetic */ SlidingPaneLayout this$0;
    
    DisableLayerRunnable(final SlidingPaneLayout this$0, final View mChildView) {
        this$0 = this$0;
        super();
        mChildView = mChildView;
    }
    
    @Override
    public void run() {
        if (mChildView.getParent() == this$0) {
            ViewCompat.setLayerType(mChildView, 0, null);
            SlidingPaneLayout.access$1000(this$0, mChildView);
        }
        SlidingPaneLayout.access$1100(this$0).remove(this);
    }
}
